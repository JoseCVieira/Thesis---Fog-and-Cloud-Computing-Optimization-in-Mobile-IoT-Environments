package org.fog.vmmigration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.Severity;

import org.cloudbus.cloudsim.NetworkTopology;
import org.fog.entities.*;
import org.fog.localization.Coordinate;
import org.fog.localization.DiscoverLocalization;
import org.fog.localization.Distances;
import org.fog.vmmobile.constants.*;
public class Migration {


	private static boolean migrationPoint;
	private static boolean migrationZone;
	private int location;
	private ApDevice correntAP;
	private FogDevice correntServerCloudlet;
	private MobileDevice correntSmartThing;
	private ApDevice apAvailable;
	private FogDevice serverCloudletAvailable;
	private int flowDirection;
	private static List<ApDevice> apsAvailable;
	private static List<FogDevice> serverCloudletsAvailable;
	private static int policyReplicaVM;

	/**
	 * @param args
	 * @author Marcio Moraes Lopes
	 */


	public static List<ApDevice> apAvailableList(List<ApDevice> oldApList
			, MobileDevice smartThing ){//It looks to cone and return the Aps available list
		List<ApDevice> newApList =new ArrayList<>();

		int localAp;
		boolean cone;
		for(ApDevice ap: oldApList){
			if(!smartThing.getSourceAp().equals(ap))
				newApList.add(ap);
		}

		return newApList;



	}






	public static int nextAp(List<ApDevice> apDevices, MobileDevice smartThing){//Policy: the closest Ap 

		setApsAvailable(apAvailableList(apDevices,smartThing));//It return apDevice list without the smartThing's sourceAp 
		if (getApsAvailable().size() == 0){
			return -1;
		}

		return  Distances.theClosestAp(getApsAvailable(), smartThing);//return the closest ap's id or -1 if it doesn't exist
	}
	public int nextApFromCloudlet(Set<ApDevice> apDevices, MobileDevice smartThing){

		return 0;
	}
	public static boolean insideCone(int smartThingDirection, int zoneDirection){//
		int ajust1, ajust2;

		if(smartThingDirection==Directions.EAST){
			ajust1=Directions.SOUTHEAST;
			ajust2=Directions.EAST+1;
		}
		else if(smartThingDirection==Directions.SOUTHEAST){
			ajust1=Directions.SOUTHEAST-1;
			ajust2=Directions.EAST;
		}
		else{
			ajust1=smartThingDirection-1; /*plus 45 degree*/
			ajust2=smartThingDirection+1;
		}

		if(zoneDirection == smartThingDirection || 
				zoneDirection==ajust1 || 
				zoneDirection == ajust2) /*Define Migration Zone -> it looks for 135 degree = 45 way + 45 way1 +45 way2*/
			return true;
		else
			return false;
	}




	public static List<FogDevice> serverClouletsAvailableList(List<FogDevice> oldServerCloudlets, MobileDevice smartThing){
		List<FogDevice> newServerCloudlets = new ArrayList<>();

		int localServerCloudlet;
		boolean cone;
		for(FogDevice sc: oldServerCloudlets ){
			localServerCloudlet=DiscoverLocalization.discoverLocal(
					smartThing.getCoord(),sc.getCoord());//return the relative position between Server Cloudlet and smart thing -> set this value
			cone = insideCone(localServerCloudlet,smartThing.getDirection());
			//, localAp);
			if(cone&&(sc.getMyId()!=smartThing.getSourceServerCloudlet().getMyId())){
				newServerCloudlets.add(sc);
			}
		}
		return newServerCloudlets;
	}
	public static int nextServerCloudlet(List<FogDevice> serverCloudlets, MobileDevice smartThing){//Policy: the closest serverCloudlet

		setServerCloudletsAvailable(serverClouletsAvailableList(serverCloudlets, smartThing));
		if(getServerCloudletsAvailable().size()==0){
			return -1;
		}
		else{
			return Distances.theClosestServerCloudlet(getServerCloudletsAvailable(), smartThing);
		}
	}


	public static boolean isEdgeAp(ApDevice apDevice, MobileDevice smartThing){
		if(apDevice.getServerCloudlet().getMyId() == smartThing.getSourceServerCloudlet().getMyId())// verify if the next Ap is edge
			return false; 
		else 
			return true;
	}

	public static int lowestLatencyCostServerCloudlet(List<FogDevice> oldServerCloudlets, List<ApDevice> oldApDevices, MobileDevice smartThing){
		List<FogDevice> newServerCloudlets = new ArrayList<>();
		List<FogDevice> numServerCloudlets = new ArrayList<>(); 

		for(FogDevice sc: oldServerCloudlets){ 
			newServerCloudlets.add(sc);
		}

		for(int i = 0; i<9; i++){
			int destinationServerCloudlet = nextServerCloudlet(newServerCloudlets, smartThing);
			if(destinationServerCloudlet>=0){
				for(FogDevice sc1:newServerCloudlets){
					if(sc1.getMyId()==destinationServerCloudlet){
						numServerCloudlets.add(sc1);
						break;
					}
				}

				FogDevice sc=null;
				for(int j = 0;j < newServerCloudlets.size();j++){

					sc=newServerCloudlets.get(j);
					if(sc.getMyId()==destinationServerCloudlet){
						newServerCloudlets.remove(sc);
						break;
					}
				}
			}
			else {
				break;
			}
		}

		if(numServerCloudlets.size()==0){
			return -1;
		}
		double sumCost;
		int choose =-1;
		double minCost=-1;
		int idNextAp = nextAp(oldApDevices, smartThing);

		if(idNextAp<0){
			return -1;
		}

		for(int i = 0; i<numServerCloudlets.size();i++){
			minCost = sumCostFunction(numServerCloudlets.get(i),oldApDevices.get(idNextAp),smartThing);
			if(minCost>=0){
				choose=numServerCloudlets.get(i).getMyId();
				break;
			}
		}
		if(minCost<0){
			return -1;
		}

		for(FogDevice sc: numServerCloudlets){
			sumCost = sumCostFunction(sc,oldApDevices.get(idNextAp),smartThing);
			if(sumCost<0){
				continue;
			}
			if(sumCost<minCost){
				minCost = sumCost;
				choose = sc.getMyId();
			}
		}

		return choose;
	}

	public static double sumCostFunction(FogDevice serverCloudlet, ApDevice nextAp, MobileDevice smartThing){
		double sum = -1;
		List<ApDevice> tempListAps = new ArrayList<>(); // It creates a temporary List to invoke the nextAp
		if(nextAp.getServerCloudlet().equals(serverCloudlet)){
			sum = NetworkTopology.getDelay(smartThing.getId(), nextAp.getId()) 
					+ NetworkTopology.getDelay(nextAp.getId(),nextAp.getServerCloudlet().getId())
					+ (1.0/nextAp.getServerCloudlet().getHost().getAvailableMips())
					+ LatencyByDistance.latencyConnection(nextAp.getServerCloudlet(), smartThing);


		}
		else{
			sum = NetworkTopology.getDelay(smartThing.getId(), nextAp.getId()) 
					+ NetworkTopology.getDelay(nextAp.getId(),nextAp.getServerCloudlet().getId())
					+ 1.0 //router
					+ NetworkTopology.getDelay(nextAp.getServerCloudlet().getId(),serverCloudlet.getId())
					+ (1.0/serverCloudlet.getHost().getAvailableMips())
					+ LatencyByDistance.latencyConnection(serverCloudlet, smartThing);


		}
		return sum;



	}

	public static boolean isMigrationPoint() {
		return migrationPoint;
	}

	public static void setMigrationPoint(boolean migrationPoint) {
		Migration.migrationPoint = migrationPoint;
	}

	public static boolean isMigrationZone() {
		return migrationZone;
	}

	public static void setMigrationZone(boolean migrationZone) {
		Migration.migrationZone = migrationZone;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public ApDevice getCorrentAP() {
		return correntAP;
	}

	public void setCorrentAP(ApDevice correntAP) {
		this.correntAP = correntAP;
	}

	public FogDevice getCorrentServerCloudlet() {
		return correntServerCloudlet;
	}

	public void setCorrentServerCloudlet(FogDevice correntServerCloudlet) {
		this.correntServerCloudlet = correntServerCloudlet;
	}

	public MobileDevice getCorrentSmartThing() {
		return correntSmartThing;
	}

	public void setCorrentSmartThing(MobileDevice correntSmartThing) {
		this.correntSmartThing = correntSmartThing;
	}

	public ApDevice getApAvailable() {
		return apAvailable;
	}

	public void setApAvailable(ApDevice apAvailable) {
		this.apAvailable = apAvailable;
	}

	public FogDevice getServerCloudletAvailable() {
		return serverCloudletAvailable;
	}

	public void setServerCloudletAvailable(FogDevice serverCloudletAvailable) {
		this.serverCloudletAvailable = serverCloudletAvailable;
	}

	public int getFlowDirection() {
		return flowDirection;
	}

	public void setFlowDirection(int flowDirection) {
		this.flowDirection = flowDirection;
	}

	public static List<ApDevice> getApsAvailable() {
		return apsAvailable;
	}

	public static void setApsAvailable(List<ApDevice> apsAvailable) {
		Migration.apsAvailable = apsAvailable;
	}

	public static List<FogDevice> getServerCloudletsAvailable() {
		return serverCloudletsAvailable;
	}

	public static void setServerCloudletsAvailable(List<FogDevice> serverCloudletsAvailable) {
		Migration.serverCloudletsAvailable = serverCloudletsAvailable;
	}

	public static int getPolicyReplicaVM() {
		return policyReplicaVM;
	}

	public static void setPolicyReplicaVM(int policyReplicaVM) {
		Migration.policyReplicaVM = policyReplicaVM;
	}




}
