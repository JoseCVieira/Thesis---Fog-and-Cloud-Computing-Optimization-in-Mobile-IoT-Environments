package org.fog.vmmigration;

import java.util.List;

import org.cloudbus.cloudsim.core.CloudSim;
import org.fog.entities.ApDevice;
import org.fog.entities.FogDevice;
import org.fog.entities.MobileDevice;
import org.fog.localization.DiscoverLocalization;
import org.fog.localization.Distances;

public class LowestDistBwSmartThingAP implements DecisionMigration {

	private  List<FogDevice> serverCloudlets;
	private  List<ApDevice> apDevices;
	private  int migPointPolicy;
	private  ApDevice correntAP;
	private  int nextApId;
	private  int nextServerClouletId;
	private  int smartThingPosition;
	private  boolean migZone;
	private  boolean migPoint;
	private int policyReplicaVM;
	/**
	 * @author Marcio Moraes Lopes
	 */

	public LowestDistBwSmartThingAP(List<FogDevice> serverCloudlets, 
			List<ApDevice> apDevices, int migPointPolicy, int policyReplicaVM) {
		super();
		setServerCloudlets(serverCloudlets);
		setApDevices(apDevices);
		setMigPointPolicy(migPointPolicy);
		setPolicyReplicaVM(policyReplicaVM);
		// TODO Auto-generated constructor stub
	}



	@Override
	public boolean shouldMigrate(MobileDevice smartThing) {
		// TODO Auto-generated method stub
		setCorrentAP(smartThing.getSourceAp());			

		setSmartThingPosition(DiscoverLocalization.discoverLocal(getCorrentAP().getCoord()
				, smartThing.getCoord()));//return the relative position between Access point and smart thing -> set this value
		smartThing.getMigrationTechnique().verifyPoints(smartThing, getSmartThingPosition());


		if(!(smartThing.isMigPoint() && smartThing.isMigZone())){
			//							System.out.println("Clock: "+CloudSim.clock()+" SmartThing is not on migration zone... isMigPoint: "+ isMigPoint()+" isMigZone: "+isMigZone()+" Distance: "+ Distances.checkDistance(getCorrentAP().getCoord(), smartThing.getCoord()));
			return false;//no migration
		}
		else{
			setNextApId(Migration.nextAp(apDevices, smartThing));
			if(getNextApId() < 0){//index is negative 
				//					System.out.println("Does not exist nextAp");
				return false;//no migration
			}
			if(!Migration.isEdgeAp(apDevices.get(getNextApId()), smartThing)){// verify if the next Ap is edge (return false if the ServerCloudlet destination is the same ServerCloud source)
				return false;//no migration
			}
			setNextServerClouletId(
					apDevices.get(getNextApId()).getServerCloudlet().getMyId());//ServerCloudlet linked with nextap
		}

		return ServiceAgreement.serviceAgreement(serverCloudlets.get(getNextServerClouletId()), smartThing);
	}

	public  List<FogDevice> getServerCloudlets() {
		return serverCloudlets;
	}


	public  void setServerCloudlets(List<FogDevice> serverCloudlets) {
		this.serverCloudlets = serverCloudlets;
	}


	public  List<ApDevice> getApDevices() {
		return apDevices;
	}


	public  void setApDevices(List<ApDevice> apDevices) {
		this.apDevices = apDevices;
	}


	public  int getMigPointPolicy() {
		return migPointPolicy;
	}


	public  void setMigPointPolicy(int migPointPolicy) {
		this.migPointPolicy = migPointPolicy;
	}


	public  ApDevice getCorrentAP() {
		return correntAP;
	}


	public  void setCorrentAP(ApDevice correntAP) {
		this.correntAP = correntAP;
	}


	public  int getNextApId() {
		return nextApId;
	}


	public  void setNextApId(int nextApId) {
		this.nextApId = nextApId;
	}


	public  int getNextServerClouletId() {
		return nextServerClouletId;
	}


	public  void setNextServerClouletId(int nextServerClouletId) {
		this.nextServerClouletId = nextServerClouletId;
	}


	public  int getSmartThingPosition() {
		return smartThingPosition;
	}


	public  void setSmartThingPosition(int smartThingPosition) {
		this.smartThingPosition = smartThingPosition;
	}


	public  boolean isMigZone() {
		return migZone;
	}


	public  void setMigZone(boolean migZone) {
		this.migZone = migZone;
	}


	public  boolean isMigPoint() {
		return migPoint;
	}


	public  void setMigPoint(boolean migPoint) {
		this.migPoint = migPoint;
	}



	public int getPolicyReplicaVM() {
		return policyReplicaVM;
	}



	public void setPolicyReplicaVM(int policyReplicaVM) {
		this.policyReplicaVM = policyReplicaVM;
	}

}
