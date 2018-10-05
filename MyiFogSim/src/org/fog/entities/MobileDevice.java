package org.fog.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.fog.application.AppEdge;
import org.fog.application.AppModule;
import org.fog.localization.*;
import org.fog.placement.MobileController;
import org.fog.policy.AppModuleAllocationPolicy;
import org.fog.utils.Config;
import org.fog.utils.FogEvents;
import org.fog.utils.FogUtils;
import org.fog.utils.Logger;
import org.fog.utils.ModuleLaunchConfig;
import org.fog.vmmigration.MyStatistics;
import org.fog.vmmigration.VmMigrationTechnique;
import org.fog.vmmobile.LogMobile;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.core.SimEvent;
import org.cloudbus.cloudsim.Vm;
/**
* @author Marcio Moraes Lopes
*/
public class MobileDevice extends FogDevice {


	private int direction; //NONE, NORTH, SOUTH, ...
	private int speed; // in m/s
	//private double distanceAp;
	private FogDevice sourceServerCloudlet;
	private FogDevice destinationServerCloudlet;
	private FogDevice vmLocalServerCloudlet;
	private ApDevice sourceAp;
	private ApDevice destinationAp;
	private Vm vmMobileDevice; 
	private double migTime;
	private boolean migPoint;
	private boolean migZone;
	private Set<MobileSensor> sensors;//Set of Sensors
	private Set<MobileActuator> actuators;//Set of Actuators
	private float maxServiceValue;
	private boolean migStatus;
	private boolean postCopyStatus;
	private boolean handoffStatus;
	private boolean lockedToHandoff;
	private boolean lockedToMigration;
	private boolean abortMigration;
	private double vmSize;
	private double tempSimulation;
	private double timeFinishHandoff = 0;
	private double timeFinishDeliveryVm = 0;
	private double timeStartLiveMigration = 0;
	private boolean status;
	protected VmMigrationTechnique migrationTechnique;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getName() == null) ? 0 : this.getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MobileDevice other = (MobileDevice) obj;
		if (this.getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!this.getName().equals(other.getName()))
			return false;
		return true;
	}

	public MobileDevice() {
		// TODO Auto-generated constructor stub
	}

	public MobileDevice(String name, Coordinate coord, int coordX, int coordY, int id) {
		// TODO Auto-generated constructor stub
		super(name, coordX, coordY, id);

		setDirection(0);
		setSpeed(0);
		//	setDistanceAp(0);
		setSourceServerCloudlet(null);
		setDestinationServerCloudlet(null);
		setVmLocalServerCloudlet(null);
		setSourceAp(null);
		setDestinationAp(null);
		setVmMobileDevice(null);
		setMigTime(0);
		setMigStatus(false);
		setPostCopyStatus(false);
		setHandoffStatus(false);
		setLockedToHandoff(false);
		setLockedToMigration(false);
		setAbortMigration(false);
		setMigPoint(false);
		setMigZone(false);
		actuators = new HashSet<>();
		sensors = new HashSet<>();
		setStatus(true);


	}
	public MobileDevice(String name, int coordX, int coordY, int id, int dir, int sp) {
		//			public MobileDevice(String name, Coordinate coord, int coordX, int coordY, int id, int dir, int sp) {

		// TODO Auto-generated constructor stub
		//		super(name, coord, coordX, coordY, id);
		super(name, coordX, coordY, id);
		setDirection(dir);
		setSpeed(sp);
		//	setDistanceAp(0);
		setSourceServerCloudlet(null);
		setDestinationServerCloudlet(null);
		setVmLocalServerCloudlet(null);
		setSourceAp(null);
		setDestinationAp(null);
		setVmMobileDevice(null);
		setMigTime(0);
		setMigStatus(false);
		setPostCopyStatus(false);

		setHandoffStatus(false);
		setLockedToHandoff(false);
		setLockedToMigration(false);
		setStatus(true);
		setAbortMigration(false);


		actuators = new HashSet<>();
		sensors = new HashSet<>();


	}

	public MobileDevice(String name,
			FogDeviceCharacteristics characteristics,
			AppModuleAllocationPolicy vmAllocationPolicy,
			LinkedList<Storage> storageList, double schedulingInterval, double uplinkBandwidth
			, double downlinkBandwidth, double uplinkLatency,
			double d, int coordX, int coordY, int id, int dir, int sp, float maxServiceValue, double vmSize
			, VmMigrationTechnique migrationTechnique) throws Exception {
		// TODO Auto-generated constructor stub
		super(name, characteristics, vmAllocationPolicy
				, storageList, schedulingInterval
				, uplinkBandwidth
				, downlinkBandwidth
				, uplinkLatency, sp, coordX, coordY, id);
		setDirection(dir);
		setSpeed(sp);
		//		setDistanceAp(0);
		setSourceServerCloudlet(null);
		setDestinationServerCloudlet(null);
		setVmLocalServerCloudlet(null);
		setSourceAp(null);
		setDestinationAp(null);
		setVmMobileDevice(null);
		setMigTime(0);
		setMigStatus(false);
		setPostCopyStatus(false);

		setVmSize(vmSize);
		setHandoffStatus(false);
		setLockedToHandoff(false);
		setStatus(true);
		setAbortMigration(false);
		setMigrationTechnique(migrationTechnique);

		actuators = new HashSet<>();
		sensors = new HashSet<>();
		setMaxServiceValue(maxServiceValue);

	}

	@Override
	public String toString() {
		return this.getName() + "[coordX="+this.getCoord().getCoordX()
				+ ", coordY="+this.getCoord().getCoordY()
				+ ", direction=" + direction + ", speed=" + speed
				+ /*", distanceAp=" + distanceAp + */", sourceCloudletServer="
				+ sourceServerCloudlet + ", destinationCloudletServer="
				+ destinationServerCloudlet + ", sourceAp=" + sourceAp
				+ ", destinationAp=" + destinationAp + ", vmMobileDevice="
				+ vmMobileDevice + ", migTime=" + migTime + ", sensors="
				+ sensors + ", actuators=" + actuators + "]";
	}
	@Override
	protected void processOtherEvent(SimEvent ev) {
		switch(ev.getTag()){
		case FogEvents.TUPLE_ARRIVAL:
			processTupleArrival(ev);
			break;
		case FogEvents.LAUNCH_MODULE:
			processModuleArrival(ev);
			break;
		case FogEvents.RELEASE_OPERATOR:
			processOperatorRelease(ev);
			break;
		case FogEvents.SENSOR_JOINED:
			processSensorJoining(ev);
			break;
		case FogEvents.SEND_PERIODIC_TUPLE:
			sendPeriodicTuple(ev);
			break;
		case FogEvents.APP_SUBMIT:
			processAppSubmit(ev);
			break;
		case FogEvents.UPDATE_NORTH_TUPLE_QUEUE:
			updateNorthTupleQueue();
			break;
		case FogEvents.UPDATE_SOUTH_TUPLE_QUEUE:
			updateSouthTupleQueue();
			break;
		case FogEvents.ACTIVE_APP_UPDATE:
			updateActiveApplications(ev);
			break;
		case FogEvents.ACTUATOR_JOINED:
			processActuatorJoined(ev);
			break;
		case FogEvents.LAUNCH_MODULE_INSTANCE:
			updateModuleInstanceCount(ev);
			break;
		case FogEvents.RESOURCE_MGMT:
			manageResources(ev);
			break;
		default:
			break;
		}
	}

	protected void processTupleArrival(SimEvent ev){

		Tuple tuple = (Tuple)ev.getData();
		MyStatistics.getInstance().setMyCountTotalTuple(1);

		boolean flagContinue=false;
		if(!MobileController.getSmartThings().contains(this)){
			return;
		}
			
		for(MobileDevice st: MobileController.getSmartThings()){
			for(Sensor s: st.getSensors()){
				if(tuple.getAppId().equals(s.getAppId())){
					flagContinue=true;
					break;
				}
			}
		}
		if(!flagContinue){
			return;
		}
		
		if(tuple.getInitialTime()==-1){
			MyStatistics.getInstance().getTupleLatency().put(tuple.getMyTupleId(), CloudSim.clock()-getUplinkLatency());
			tuple.setInitialTime(CloudSim.clock()-getUplinkLatency());
		}

		if(getName().equals("cloud")){
			updateCloudTraffic();
		}

		/*if(getName().equals("d-0") && tuple.getTupleType().equals("_SENSOR")){
System.out.println(++numClients);
}*/
		Logger.debug(getName(), "Received tuple "+tuple.getCloudletId()+" with tupleType = "+tuple.getTupleType()+"\t| Source : "+
				CloudSim.getEntityName(ev.getSource())+"|Dest : "+CloudSim.getEntityName(ev.getDestination()));
		send(ev.getSource(), CloudSim.getMinTimeBetweenEvents(), FogEvents.TUPLE_ACK);

		if(FogUtils.appIdToGeoCoverageMap.containsKey(tuple.getAppId())){
		}

		if(tuple.getDirection() == Tuple.ACTUATOR){
			
			sendTupleToActuator(tuple);
			return;
		}


		if((isMigStatus()||isHandoffStatus())){// && (ev.getSource()!=ev.getDestination())){
//			if(!tuple.getTupleType().contains("EEG")){
			
			MyStatistics.getInstance().setMyCountLostTuple(1);
				if(isMigStatus()){//send again
//					if(MyStatistics.getInstance().getInitialWithoutVmTime().get(getMyId())==null){
//						MyStatistics.getInstance().startWithoutVmTime(getMyId(), CloudSim.clock());
//					}
				
					//				MyStatistics.getInstance().putLatencyFile(CloudSim.clock());
//										LogMobile.debug("MobileDevice.java", getName()+" is in Migration");
					//				System.out.println("Clock: "+CloudSim.clock()+" - MobileDevice.java - Destination: "+CloudSim.getEntityName(ev.getDestination())+": Tuple "+tuple.getCloudletId());
					//				System.out.println("Clock: "+CloudSim.clock()+" - MobileDevice.java - Source: "+CloudSim.getEntityName(ev.getSource()));
					//				Logger.ENABLED=true;  
					//				System.out.println("Clock: "+CloudSim.clock()+" - TupleId: "+tuple.getMyTupleId()+" MobileDevice.java - Migration");
//					double mt= getMigTime();
//					double clock = CloudSim.clock();
//					double semVm = MyStatistics.getInstance().getInitialWithoutVmTime().get(getMyId());
//					double iddatuple = (tuple.getCloudletId()/1000.0);
//					double delay = getMigTime() - (CloudSim.clock() - MyStatistics.getInstance().getInitialWithoutVmTime().get(getMyId()));
//					if(delay < 100){
//						delay = 1000;
//					}
//					send(ev.getDestination(),1000, FogEvents.TUPLE_ARRIVAL, tuple);
					return;
				}
				else{//send again
					//	MyStatistics.getInstance().putLatencyFile(CloudSim.clock());
					//					LogMobile.debug("MobileDevice.java", getName()+" is in Handoff");
					//				System.out.println("Clock: "+CloudSim.clock()+" - MobileDevice.java - Destination: "+CloudSim.getEntityName(ev.getDestination())+": Tuple "+tuple.getCloudletId());
					//				System.out.println("Clock: "+CloudSim.clock()+" - MobileDevice.java - Source: "+CloudSim.getEntityName(ev.getSource()));
					//				System.out.println("Clock: "+CloudSim.clock()+" - TupleId: "+tuple.getMyTupleId()+" MobileDevice.java - Handoff");
//					send(ev.getDestination(), 100, FogEvents.TUPLE_ARRIVAL, tuple);
					return;
				}
//			}
		}
		else {
//			if(MyStatistics.getInstance().getInitialWithoutVmTime().get(getMyId())!=null){
//				MyStatistics.getInstance().finalWithoutVmTime(getMyId(), CloudSim.clock());
//				MyStatistics.getInstance().getInitialWithoutVmTime().remove(getMyId());
//			}
			if(getHost().getVmList().size() > 0){
				for(Vm vm:getHost().getVmList()){
					final AppModule operator = (AppModule)vm;//getHost().getVmList().get(index);
					if(CloudSim.clock() > 0){
						getHost().getVmScheduler().deallocatePesForVm(operator);
						getHost().getVmScheduler().allocatePesForVm(operator, new ArrayList<Double>(){
							protected static final long serialVersionUID = 1L;
							{add((double) getHost().getTotalMips());}});
					}

					break;
					
				}

			}
			if(getName().equals("cloud") && tuple.getDestModuleName()==null){
				sendNow(getControllerId(), FogEvents.TUPLE_FINISHED, null);
			}
			

			if(appToModulesMap.containsKey(tuple.getAppId())){
				if(appToModulesMap.get(tuple.getAppId()).contains(tuple.getDestModuleName())){
					int vmId = -1;
					for(Vm vm : getHost().getVmList()){
						//if(vm.getVmm().equals("Xen")){
						if(((AppModule)vm).getName().equals(tuple.getDestModuleName()))
							vmId = vm.getId();
						//}
					}
					if(vmId < 0
							|| (tuple.getModuleCopyMap().containsKey(tuple.getDestModuleName()) && 
									tuple.getModuleCopyMap().get(tuple.getDestModuleName())!=vmId )){
						return;
					}
					tuple.setVmId(vmId);
					//Logger.error(getName(), "Executing tuple for operator " + moduleName);

					updateTimingsOnReceipt(tuple);

					executeTuple(ev, tuple.getDestModuleName());
				}else if(tuple.getDestModuleName()!=null){
					if(tuple.getDirection() == Tuple.UP)
						sendUp(tuple);
					else if(tuple.getDirection() == Tuple.DOWN){
						for(int childId : getChildrenIds())
							sendDown(tuple, childId);
					}
				}else{
					sendUp(tuple);
				}
			}else{
				if(tuple.getDirection() == Tuple.UP)
					sendUp(tuple);
				else if(tuple.getDirection() == Tuple.DOWN){
					for(int childId : getChildrenIds())
						sendDown(tuple, childId);
				}
			}
		}
	}
	private void sendPeriodicTuple(SimEvent ev) {
		AppEdge edge = (AppEdge)ev.getData();
		String srcModule = edge.getSource();
		AppModule module = null;
		for(Vm vm : getHost().getVmList()){
			//	if(vm.getVmm().equals("Xen")){
			if(((AppModule)vm).getName().equals(srcModule)){
				module=(AppModule)vm;
				break;
			}
			//}
		}
		if(module == null)
			return;

		int instanceCount = getModuleInstanceCount().get(module.getAppId()).get(srcModule);

		/*
		 * Since tuples sent through a DOWN application edge are anyways broadcasted, only UP tuples are replicated
		 */
		for(int i = 0;i<((edge.getDirection()==Tuple.UP)?instanceCount:1);i++){
			Tuple tuple = applicationMap.get(module.getAppId()).createTuple(edge, getId());
			updateTimingsOnSending(tuple);
			sendToSelf(tuple);			
		}
		send(getId(), edge.getPeriodicity(), FogEvents.SEND_PERIODIC_TUPLE, edge);
	}

	private void updateModuleInstanceCount(SimEvent ev) {
		ModuleLaunchConfig config = (ModuleLaunchConfig)ev.getData();
		String appId = config.getModule().getAppId();
		if(!moduleInstanceCount.containsKey(appId))
			moduleInstanceCount.put(appId, new HashMap<String, Integer>());
		moduleInstanceCount.get(appId).put(config.getModule().getName(), config.getInstanceCount());
		System.out.println(getName()+ " Creating "+config.getInstanceCount()+" instances of module "+config.getModule().getName());
	}
	private void manageResources(SimEvent ev) {
		//		updateEnergyConsumption();
		send(getId(), Config.RESOURCE_MGMT_INTERVAL, FogEvents.RESOURCE_MGMT);
	}

	public float getMaxServiceValue() {
		return maxServiceValue;
	}

	public void setMaxServiceValue(float maxServiceValue) {
		this.maxServiceValue = maxServiceValue;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	//	public double getDistanceAp() {
	//		return distanceAp;
	//	}
	//
	//	public void setDistanceAp(double distanceAp) {
	//		this.distanceAp = distanceAp;
	//	}



	public FogDevice getSourceServerCloudlet() {
		return sourceServerCloudlet;
	}

	public void setSourceServerCloudlet(FogDevice sourceServerCloudlet) {
		this.sourceServerCloudlet = sourceServerCloudlet;
	}

	public FogDevice getDestinationServerCloudlet() {
		return destinationServerCloudlet;
	}

	public void setDestinationServerCloudlet(FogDevice destinationServerCloudlet) {
		this.destinationServerCloudlet = destinationServerCloudlet;
	}

	public ApDevice getSourceAp() {
		return sourceAp;
	}

	public void setSourceAp(ApDevice sourceAp) {
		this.sourceAp = sourceAp;
	}

	public ApDevice getDestinationAp() {
		return destinationAp;
	}

	public void setDestinationAp(ApDevice destinationAp) {
		this.destinationAp = destinationAp;
	}

	public Vm getVmMobileDevice() {
		return vmMobileDevice;
	}

	public void setVmMobileDevice(Vm vmMobileDevice) {
		this.vmMobileDevice = vmMobileDevice;
	}

	public double getVmSize() {
		return vmSize;
	}

	public void setVmSize(double vmSize) {
		this.vmSize = vmSize;
	}

	public double getMigTime() {
		return migTime;
	}

	public void setMigTime(double d) {
		this.migTime = d;
	}

	public Set<MobileSensor> getSensors() {
		return sensors;
	}

	public void setSensors(Set<MobileSensor> sensors) {
		this.sensors = sensors;
	}

	public Set<MobileActuator> getActuators() {
		return actuators;
	}

	public void setActuators(Set<MobileActuator> actuators) {
		this.actuators = actuators;
	}

	public boolean isMigStatus() {
		return migStatus;
	}

	public void setMigStatus(boolean migStatus) {
		this.migStatus = migStatus;
	}

	public double getTempSimulation() {
		return tempSimulation;
	}

	public void setTempSimulation(double tempSimulation) {
		this.tempSimulation = tempSimulation;
	}

	public boolean isHandoffStatus() {
		return handoffStatus;
	}

	public void setHandoffStatus(boolean handoffStatus) {
		this.handoffStatus = handoffStatus;
	}

	public double getTimeFinishHandoff() {
		return timeFinishHandoff;
	}

	public void setTimeFinishHandoff(double timeFinishHandoff) {
		this.timeFinishHandoff = timeFinishHandoff;
	}

	public double getTimeFinishDeliveryVm() {
		return timeFinishDeliveryVm;
	}

	public void setTimeFinishDeliveryVm(double timeFinishDeliveryVm) {
		this.timeFinishDeliveryVm = timeFinishDeliveryVm;
	}

	public FogDevice getVmLocalServerCloudlet() {
		return vmLocalServerCloudlet;
	}

	public void setVmLocalServerCloudlet(FogDevice vmLocalServerCloudlet) {
		this.vmLocalServerCloudlet = vmLocalServerCloudlet;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isLockedToHandoff() {
		return lockedToHandoff;
	}

	public void setLockedToHandoff(boolean LockedToHandoff) {
		this.lockedToHandoff = LockedToHandoff;
	}

	public boolean isLockedToMigration() {
		return lockedToMigration;
	}

	public void setLockedToMigration(boolean lockedToMigration) {
		this.lockedToMigration = lockedToMigration;
	}

	public boolean isAbortMigration() {
		return abortMigration;
	}

	public void setAbortMigration(boolean abortMigration) {
		this.abortMigration = abortMigration;
	}

	public VmMigrationTechnique getMigrationTechnique() {
		return migrationTechnique;
	}

	public void setMigrationTechnique(VmMigrationTechnique migrationTechnique) {
		this.migrationTechnique = migrationTechnique;
	}

	public boolean isMigPoint() {
		return migPoint;
	}

	public void setMigPoint(boolean migPoint) {
		this.migPoint = migPoint;
	}

	public boolean isMigZone() {
		return migZone;
	}

	public void setMigZone(boolean migZone) {
		this.migZone = migZone;
	}

	public boolean isPostCopyStatus() {
		return postCopyStatus;
	}

	public void setPostCopyStatus(boolean postCopyStatus) {
		this.postCopyStatus = postCopyStatus;
	}

	public double getTimeStartLiveMigration() {
		return timeStartLiveMigration;
	}

	public void setTimeStartLiveMigration(double timeStartLiveMigration) {
		this.timeStartLiveMigration = timeStartLiveMigration;
	}

	

	



}