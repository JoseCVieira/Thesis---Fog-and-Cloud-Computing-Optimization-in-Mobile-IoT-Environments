package org.fog.vmmigration;

import org.cloudbus.cloudsim.NetworkTopology;
import org.fog.entities.MobileDevice;
import org.fog.localization.Distances;
import org.fog.vmmobile.constants.Directions;
import org.fog.vmmobile.constants.MaxAndMin;
import org.fog.vmmobile.constants.Policies;
/**
 * @author Marcio Moraes Lopes
 */

public class LiveMigration implements VmMigrationTechnique {
	private int migPointPolicy;

	public LiveMigration(int migPointPolicy){
		super();
		setMigPointPolicy(migPointPolicy);	
	}
	@Override
	public void verifyPoints(MobileDevice smartThing, int relativePosition) {
		// TODO Auto-generated method stub


		smartThing.setMigPoint(migPointPolicyFunction(getMigPointPolicy() //either (0 or 1) -> policies
				,smartThing));// 0 -> fixed or 1 -> with speed
		smartThing.setMigZone(migrationZoneFunction(smartThing.getDirection(), relativePosition));
	}

	@Override
	public double migrationTimeFunction(double vmSize, double bandwidth) {
		// TODO Auto-generated method stub
		double time = ((double)(vmSize*8*1024*1024)/bandwidth)*1000.0;//normal Size
		return time; 
	}

	@Override
	public boolean migPointPolicyFunction(int policy, MobileDevice smartThing) {
		// TODO Auto-generated method stub
		double distance = Distances.checkDistance(smartThing.getSourceAp().getCoord(), smartThing.getCoord());
		double bandwidth=smartThing.getVmLocalServerCloudlet().getUplinkBandwidth();

		smartThing.setMigTime(migrationTimeFunction(smartThing.getVmMobileDevice().getSize()//vmSize
				, bandwidth)
				+ smartThing.getVmLocalServerCloudlet().getUplinkLatency() //Link Latency
				+ NetworkTopology.getDelay(smartThing.getId(), smartThing.getVmLocalServerCloudlet().getId())
				+ LatencyByDistance.latencyConnection(smartThing.getVmLocalServerCloudlet(), smartThing));

		if(policy == Policies.FIXED_MIGRATION_POINT){	
			return migrationPointFunction(distance);
		}
		else {
			return migrationPointFunction(distance, smartThing.getMigTime(), smartThing.getSpeed());//relative according smartThing's speed
		}			
	}

	@Override
	public boolean migrationPointFunction(double distance, double migTime,
			int speed) {
		// TODO Auto-generated method stub
		double newDistance = (double) (migTime/1000.0)*speed;//((migTime/1000.0) * speed);//minimal distance to migration 
		newDistance += MaxAndMin.MIG_POINT;
		if((distance>=MaxAndMin.MAX_DISTANCE - newDistance||distance >= MaxAndMin.MAX_DISTANCE - MaxAndMin.MAX_DISTANCE_TO_HANDOFF) &&//MaxAndMin.MIG_POINT) && // start together the handoff-> 
				distance < MaxAndMin.MAX_DISTANCE)
			return true;
		else
			return false;
	}

	@Override
	public boolean migrationPointFunction(double distance) {
		// TODO Auto-generated method stub
		if (distance >= MaxAndMin.MAX_DISTANCE - MaxAndMin.LIVE_MIG_POINT && 
				distance < MaxAndMin.MAX_DISTANCE)
			return true;
		else
			return false;
	}

	@Override
	public boolean migrationZoneFunction(int smartThingDirection,
			int zoneDirection) {
		// TODO Auto-generated method stub

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

	public int getMigPointPolicy() {
		return migPointPolicy;
	}

	public void setMigPointPolicy(int migPointPolicy) {
		this.migPointPolicy = migPointPolicy;
	}



}
