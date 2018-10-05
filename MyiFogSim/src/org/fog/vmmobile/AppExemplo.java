package org.fog.vmmobile;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.math3.util.Pair;
import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.CloudletScheduler;
import org.cloudbus.cloudsim.CloudletSchedulerDynamicWorkload;
import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.NetworkTopology;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.VmAllocationPolicySimple;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.network.DelayMatrix_Float;
import org.cloudbus.cloudsim.network.TopologicalGraph;
import org.cloudbus.cloudsim.network.TopologicalLink;
import org.cloudbus.cloudsim.power.PowerHost;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;
import org.cloudbus.cloudsim.sdn.overbooking.BwProvisionerOverbooking;
import org.cloudbus.cloudsim.sdn.overbooking.PeProvisionerOverbooking;
import org.fog.application.AppEdge;
import org.fog.application.AppLoop;
import org.fog.application.AppModule;
import org.fog.application.Application;
import org.fog.application.selectivity.FractionalSelectivity;
import org.fog.application.selectivity.SelectivityModel;
import org.fog.entities.*;
import org.fog.localization.*;
import org.fog.placement.MobileController;
import org.fog.placement.ModuleMapping;
import org.fog.policy.AppModuleAllocationPolicy;
import org.fog.scheduler.StreamOperatorScheduler;
import org.fog.scheduler.TupleScheduler;
import org.fog.utils.FogLinearPowerModel;
import org.fog.utils.FogUtils;
import org.fog.utils.GeoLocation;
import org.fog.utils.Logger;
import org.fog.utils.TimeKeeper;
import org.fog.utils.distribution.DeterministicDistribution;
import org.fog.utils.distribution.Distribution;
import org.fog.vmmigration.BeforeMigration;
import org.fog.vmmigration.CompleteVM;
import org.fog.vmmigration.ContainerVM;
import org.fog.vmmigration.DecisionMigration;
import org.fog.vmmigration.LiveMigration;
import org.fog.vmmigration.LowestDistBwSmartThingAP;
import org.fog.vmmigration.LowestDistBwSmartThingServerCloudlet;
import org.fog.vmmigration.LowestLatency;
import org.fog.vmmigration.MyStatistics;
import org.fog.vmmigration.NextStep;
import org.fog.vmmigration.PrepareCompleteVM;
import org.fog.vmmigration.PrepareContainerVM;
import org.fog.vmmigration.PrepareLiveMigration;
import org.fog.vmmigration.Service;
import org.fog.vmmigration.VmMigrationTechnique;
import org.fog.vmmobile.constants.*;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;
//import sun.util.resources.TimeZoneNames_en_CA;


public class AppExemplo {
	private static int stepPolicy; //Quantity of steps in the nextStep Function
	private static List<MobileDevice> smartThings = new ArrayList<MobileDevice>();
	private static List<FogDevice> serverCloudlets = new ArrayList<>();
	private static List<ApDevice> apDevices = new ArrayList<>();
	private static List<FogBroker> brokerList = new ArrayList<>();
	private static List<String> appIdList = new ArrayList<>();
	private static List<Application> applicationList= new ArrayList<>();
	private static boolean migrationAble;

	private static int migPointPolicy;
	private static int migStrategyPolicy;
	private static int positionApPolicy;
	private static int positionScPolicy;
	private static int policyReplicaVM;
	private static int maxBandwidth;
	private static int maxSmartThings;
	private static Coordinate coordDevices;//=new Coordinate(MaxAndMin.MAX_X, MaxAndMin.MAX_Y);//Grid/Map 
	private static int seed;
	private static Random rand;
	static final boolean CLOUD = true;


	static final int numOfDepts = 1;
	static final int numOfMobilesPerDept = 4;
	static final double EEG_TRANSMISSION_TIME = 10;	
	/**
	 * @param args
	 * @author Marcio Moraes Lopes
	 * @throws Exception 
	 */

	public static void main(String[] args) throws Exception {
		// First step: Initialize the CloudSim package. It should be called before creating any entities.
		// Second step: Create all devices
		// Third step: Create Broker
		// Fourth step: Create one virtual machine
		// Fifth step: Create one Application (appModule, appEdge, appLoop and tuples)
		// Sixth step: Configure network
		// Seventh step: Starts the simulation
		// Final step: Print results when simulation is over
		// TODO Auto-generated method stub
		/**********It's necessary to CloudSim.java for working correctly**********/
		Log.disable();
		//		Logger.ENABLED=true;  
		//		LogMobile.ENABLED=true;

		int numUser = 1; // number of cloud users
		Calendar calendar = Calendar.getInstance();
		boolean traceFlag = false; // mean trace events
		CloudSim.init(numUser, calendar, traceFlag);
		/**************************************************************************/
		setPositionApPolicy(Policies.FIXED_AP_LOCATION);
		//		setPositionApPolicy(Policies.RANDOM_AP_LOCATION);

		setPositionScPolicy(Policies.FIXED_SC_LOCATION);
		//		setPositionScPolicy(Policies.RANDOM_SC_LOCATION);

		setStepPolicy(1);
		if(Integer.parseInt(args[0])==0){
			setMigrationAble(false);
		}
		else{
			setMigrationAble(true);
		}
		setSeed(Integer.parseInt(args[1])); //It is used to generate randomize aspects. Use 30 seeds.
		if(getSeed()<1){
			System.out.println("Seed cannot be less than 1");
			System.exit(0);
		}
		setMigPointPolicy(Integer.parseInt(args[2])); 
		setMigStrategyPolicy(Integer.parseInt(args[3])); 
		setMaxSmartThings(Integer.parseInt(args[4]));
		setMaxBandwidth(Integer.parseInt(args[5]));
		setPolicyReplicaVM(Integer.parseInt(args[6]));

		setRand(new Random(getSeed()*Integer.MAX_VALUE));
		/**STEP 2: CREATE ALL DEVICES -> example from: CloudSim - example5.java**/

		/*It is creating Access Points. It makes according positionApPolicy*/
		if(positionApPolicy==Policies.FIXED_AP_LOCATION){
			addApDevicesFixed(apDevices,coordDevices);//it creates the Access Point according coordDevices' size
		}
		else{
			for(int i=0; i< MaxAndMin.MAX_AP_DEVICE;i++){//it creates the Access Points
				addApDevicesRandon(apDevices, coordDevices,i);
			}
		}

		/*It is creating Server Cloudlets.*/
		if(getPositionScPolicy()==Policies.FIXED_SC_LOCATION){
			addServerCloudlet(serverCloudlets, coordDevices);
		}
		else{
			for (int i=0;i<MaxAndMin.MAX_SERVER_CLOUDLET;i++){ //it creates the ServerCloudlets
				addServerCloudlet(serverCloudlets, coordDevices, i);
			}
		}
		createServerCloudletsNetwork(getServerCloudlets());
		/*It is creating Smart Things.*/
		for(int i=0; i< getMaxSmartThings();i++){//it creates the SmartThings - initial parameter
			addSmartThing(smartThings,coordDevices, i);
		}

		int index;//Auxiliary  
		int myCount=0;

		for(MobileDevice st:getSmartThings()){//it makes the connection between SmartThing and the closest AccessPoint
			if(!ApDevice.connectApSmartThing(getApDevices(),st, 0.5)){//getRand().nextDouble())){
				myCount++;
				LogMobile.debug("AppExemplo.java", st.getName()+" isn't connected");
			}
		}
		LogMobile.debug("AppExemplo.java", "total no connection: "+myCount);

		for(ApDevice ap: getApDevices()){ //it makes the connection between AccessPoint and the closest ServerCloudlet
			index = Distances.theClosestServerCloudletToAp(getServerCloudlets(),ap);
			ap.setServerCloudlet(getServerCloudlets().get(index));
			ap.setParentId(getServerCloudlets().get(index).getId());
			getServerCloudlets().get(index).setApDevices(ap,Policies.ADD);
			NetworkTopology.addLink(serverCloudlets.get(index).getId(), ap.getId(), ap.getDownlinkBandwidth(), 0.5);//getRand().nextDouble());

			for(MobileDevice st : ap.getSmartThings()){//it makes the symbolic link between smartThing and ServerCloudlet
				getServerCloudlets().get(index).connectServerCloudletSmartThing(st);
				getServerCloudlets().get(index).setSmartThingsWithVm(st, Policies.ADD);

			}
		}
		/**STEP 3: CREATE BROKER -> example from: CloudSim - example5.java**/

		for(MobileDevice st : getSmartThings()){
			getBrokerList().add(new FogBroker("My_broker"+Integer.toString(st.getMyId())));
		}

		/**STEP 4: CREATE ONE VIRTUAL MACHINE FOR EACH BROKER/USER -> example from: CloudSim - example5.java**/
		//		Random rand = new Random(getSeed());
		for(MobileDevice st: getSmartThings()){// It only creates the virtual machine for each smartThing
			if(st.getSourceAp()!=null){
				CloudletScheduler cloudletScheduler = new TupleScheduler(500,1);
				long sizeVm = (MaxAndMin.MIN_VM_SIZE + (long)((MaxAndMin.MAX_VM_SIZE - MaxAndMin.MIN_VM_SIZE) * (getRand().nextDouble())));
				AppModule vmSmartThingTest = new AppModule(st.getMyId() // id
						, "AppModuleVm_"+st.getName() //name
						, "MyApp_vr_game"+st.getMyId() //appId
						, getBrokerList().get(st.getMyId()).getId() //userId
						, 2000 //mips
						, 64 //(int) sizeVm/3 
						, 1000 //bw
						, sizeVm
						, "Vm_"+st.getName() //vmm
						, cloudletScheduler
						, new HashMap<Pair<String, String>, SelectivityModel>());

				st.setVmMobileDevice(vmSmartThingTest);
				st.getSourceServerCloudlet().getHost().vmCreate(vmSmartThingTest); 
				st.setVmLocalServerCloudlet(st.getSourceServerCloudlet());			
			}
		}
		int i=0;
		for(FogBroker br :getBrokerList()){//Each broker receives one smartThing's VM 
			List<Vm> tempVmList = new ArrayList<>();
			tempVmList.add(getSmartThings().get(i++).getVmMobileDevice());
			br.submitVmList(tempVmList);
		}
		// identifier of the application

		/**STEP 5: CREATE THE APPLICATION -> example from: CloudSim and iFogSim **/
		i=0;

		for(FogBroker br: getBrokerList()){
			getAppIdList().add("MyApp_vr_game"+Integer.toString(i));

			Application myApp = createApplication(getAppIdList().get(i), br.getId(),i, (AppModule)getSmartThings().get(i).getVmMobileDevice());
			getApplicationList().add(myApp);
			i++;
		}		
		/**STEP 5.1: IT LINKS SENSORS AND ACTUATORS FOR EACH BROKER -> example from: CloudSim and iFogSim**/
		for(MobileDevice st: getSmartThings()){
			int brokerId=getBrokerList().get(st.getMyId()).getId();
			String appId=getAppIdList().get(st.getMyId());
			if(st.getSourceAp()!=null){
				for(MobileSensor s: st.getSensors()){
					s.setAppId(appId);
					s.setUserId(brokerId);
					s.setGatewayDeviceId(st.getId());
					s.setLatency(6.0);	
					//					st.getSourceServerCloudlet().getChildrenIds().add(s.getId());
				}
				for(MobileActuator a: st.getActuators()){
					a.setUserId(brokerId);
					a.setAppId(appId);
					a.setGatewayDeviceId(st.getId());
					a.setLatency(1.0);
					a.setActuatorType("DISPLAY"+st.getMyId());
					//					st.getSourceServerCloudlet().getChildrenIds().add(a.getId());
				}
			}
		}

		/**STEP 6: CREATE MAPPING, CONTROLLER, AND SUBMIT APPLICATION -> example from: iFogSim - Position3.java **/

		MobileController mobileController = null;
		ModuleMapping moduleMapping = ModuleMapping.createModuleMapping(); // initializing a module mapping

		for(Application app: getApplicationList()){
			app.setPlacementStrategy("Mapping");
		}
		i=0;
		for(FogDevice sc: getServerCloudlets()){
			i=0;
			for(MobileDevice st: getSmartThings()){
				if(st.getApDevices()!=null){
					if(sc.equals(st.getSourceServerCloudlet())){
						moduleMapping.addModuleToDevice(((AppModule)st.getVmMobileDevice()).getName(), sc.getName(),1);//MaxAndMin.MAX_SMART_THING);// numOfDepts*numOfMobilesPerDept);
						moduleMapping.addModuleToDevice("client"+st.getMyId(), st.getName(), 1);
					}
				}
				i++;
			}
		}
		mobileController = new MobileController("MobileController"
				, getServerCloudlets()
				, getApDevices()
				, getSmartThings()
				, getBrokerList()
				, moduleMapping
				, getMigPointPolicy()
				, getMigStrategyPolicy()
				, getStepPolicy()
				, getCoordDevices()
				, getSeed()
				, isMigrationAble());
		i=0;
		for(Application app: applicationList){
			mobileController.submitApplication(app,1); 
		}
		TimeKeeper.getInstance().setSimulationStartTime(Calendar.getInstance().getTimeInMillis());
		MyStatistics.getInstance().setSeed(getSeed());
		for(MobileDevice st: getSmartThings()){
			if(getMigPointPolicy()==Policies.FIXED_MIGRATION_POINT){
				if(getMigStrategyPolicy()==Policies.LOWEST_LATENCY){

					MyStatistics.getInstance().setFileMap("./outputLatencies/"+st.getMyId()+"/latencies_FIXED_MIGRATION_POINT_with_LOWEST_LATENCY_seed_"+getSeed()+"_st_"+st.getMyId()+".txt",st.getMyId());
					MyStatistics.getInstance().putLantencyFileName("FIXED_MIGRATION_POINT_with_LOWEST_LATENCY_seed_"+getSeed()+"_st_"+st.getMyId(),st.getMyId());
					MyStatistics.getInstance().setToPrint("FIXED_MIGRATION_POINT_with_LOWEST_LATENCY");
				}
				else if(getMigStrategyPolicy()==Policies.LOWEST_DIST_BW_SMARTTING_AP){
					MyStatistics.getInstance().setFileMap("./outputLatencies/"+st.getMyId()+"/latencies_FIXED_MIGRATION_POINT_with_LOWEST_DIST_BW_SMARTTING_AP_seed_"+getSeed()+"_st_"+st.getMyId()+".txt",st.getMyId());
					MyStatistics.getInstance().putLantencyFileName("FIXED_MIGRATION_POINT_with_LOWEST_DIST_BW_SMARTTING_AP_seed_"+getSeed()+"_st_"+st.getMyId(),st.getMyId());
					MyStatistics.getInstance().setToPrint("FIXED_MIGRATION_POINT_with_LOWEST_DIST_BW_SMARTTING_AP");


				}
				else if(getMigStrategyPolicy()==Policies.LOWEST_DIST_BW_SMARTTING_SERVERCLOUDLET){
					MyStatistics.getInstance().setFileMap("./outputLatencies/"+st.getMyId()+"/latencies_FIXED_MIGRATION_POINT_with_LOWEST_DIST_BW_SMARTTING_SERVERCLOUDLET_seed_"+getSeed()+"_st_"+st.getMyId()+".txt",st.getMyId());
					MyStatistics.getInstance().putLantencyFileName("FIXED_MIGRATION_POINT_with_LOWEST_DIST_BW_SMARTTING_SERVERCLOUDLET_seed_"+getSeed()+"_st_"+st.getMyId(),st.getMyId());
					MyStatistics.getInstance().setToPrint("FIXED_MIGRATION_POINT_with_LOWEST_DIST_BW_SMARTTING_SERVERCLOUDLET");

				}
			}
			else if(getMigPointPolicy()==Policies.SPEED_MIGRATION_POINT){
				if(getMigStrategyPolicy()==Policies.LOWEST_LATENCY){
					MyStatistics.getInstance().setFileMap("./outputLatencies/"+st.getMyId()+"/latencies_SPEED_MIGRATION_POINT_with_LOWEST_LATENCY_seed_"+getSeed()+"_st_"+st.getMyId()+".txt",st.getMyId());
					MyStatistics.getInstance().putLantencyFileName("SPEED_MIGRATION_POINT_with_LOWEST_LATENCY_seed_"+getSeed()+"_st_"+st.getMyId(),st.getMyId());
					MyStatistics.getInstance().setToPrint("SPEED_MIGRATION_POINT_with_LOWEST_LATENCY");

				}
				else if(getMigStrategyPolicy()==Policies.LOWEST_DIST_BW_SMARTTING_AP){
					MyStatistics.getInstance().setFileMap("./outputLatencies/"+st.getMyId()+"/latencies_SPEED_MIGRATION_POINT_with_LOWEST_DIST_BW_SMARTTING_AP_seed_"+getSeed()+"_st_"+st.getMyId()+".txt",st.getMyId());
					MyStatistics.getInstance().putLantencyFileName("SPEED_MIGRATION_POINT_with_LOWEST_DIST_BW_SMARTTING_AP_seed_"+getSeed()+"_st_"+st.getMyId(),st.getMyId());
					MyStatistics.getInstance().setToPrint("SPEED_MIGRATION_POINT_with_LOWEST_DIST_BW_SMARTTING_AP");

				}
				else if(getMigStrategyPolicy()==Policies.LOWEST_DIST_BW_SMARTTING_SERVERCLOUDLET){
					MyStatistics.getInstance().setFileMap("./outputLatencies/"+st.getMyId()+"/latencies_SPEED_MIGRATION_POINT_with_LOWEST_DIST_BW_SMARTTING_SERVERCLOUDLET_seed_"+getSeed()+"_st_"+st.getMyId()+".txt",st.getMyId());
					MyStatistics.getInstance().putLantencyFileName("SPEED_MIGRATION_POINT_with_LOWEST_DIST_BW_SMARTTING_SERVERCLOUDLET_seed_"+getSeed()+"_st_"+st.getMyId(),st.getMyId());
					MyStatistics.getInstance().setToPrint("SPEED_MIGRATION_POINT_with_LOWEST_DIST_BW_SMARTTING_SERVERCLOUDLET");


				}
			}
			MyStatistics.getInstance().putLantencyFileName("Time-latency",st.getMyId());
			MyStatistics.getInstance().getMyCount().put(st.getMyId(), 0);
		}


		myCount=0;


		for(MobileDevice st: getSmartThings()){
			System.out.println(st.getName()+"- X: "+st.getCoord().getCoordX() +" Y: "+st.getCoord().getCoordY()+ " Direction: "+st.getDirection()+ " Speed: "+st.getSpeed()+ " VmSize: "+st.getVmMobileDevice().getSize());
		}
		System.out.println("_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");
		for(FogDevice sc: getServerCloudlets()){
			System.out.println(sc.getName()+"- X: "+sc.getCoord().getCoordX() +" Y: "+sc.getCoord().getCoordY()+" UpLinkLatency: "+sc.getUplinkLatency());
		}
		System.out.println("_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");
		for(ApDevice ap: getApDevices()){
			System.out.println(ap.getName()+"- X: "+ap.getCoord().getCoordX() +" Y: "+ap.getCoord().getCoordY() + " connected to "+ap.getServerCloudlet().getName());

		}

		CloudSim.startSimulation();
		System.out.println("Simulation over");
		CloudSim.stopSimulation();

	}

	private static void addApDevicesFixed(List<ApDevice> apDevices,
			Coordinate coordDevices) {
		int i=0;
		boolean control = true;
		int coordY=0;
		for(int coordX=100; coordX<MaxAndMin.MAX_X-100; coordX+=6500){ /*evenly distributed*/
			if(control){
				coordY=4000;
			}
			else{
				coordY = 10500;
			}
			control=!control;
			for(; coordY<MaxAndMin.MAX_Y-100; coordY+=6500, i++){
				ApDevice ap = new ApDevice("AccessPoint"+Integer.toString(i),//name
						coordX,coordY
						,i//ap.set//id
						,100 * 1024 * 1024//downLinkBandwidth - 100Mbits
						,200//engergyConsuption
						,MaxAndMin.MAX_ST_IN_AP//maxSmartThing
						,100 * 1024 * 1024//upLinkBandwidth - 100Mbits
						,4//upLinkLatency
						);
				apDevices.add(i, ap);
			}
		}
		LogMobile.debug("AppExemplo.java", "Total of accessPoints: "+i);

	}
	private static void addApDevicesRandon(List<ApDevice> apDevices,
			Coordinate coordDevices, int i) {
		int coordX,coordY;
		coordX = getRand().nextInt(MaxAndMin.MAX_X);
		coordY = getRand().nextInt(MaxAndMin.MAX_Y);
		ApDevice ap = new ApDevice("AccessPoint"+Integer.toString(i),//name
				coordX,coordY
				,i//id
				,100 * 1024 * 1024//downLinkBandwidth - 100 Mbits
				,200//engergyConsuption 
				,MaxAndMin.MAX_ST_IN_AP//maxSmartThing
				,100 * 1024 * 1024//upLinkBandwidth 100 Mbits
				,4//upLinkLatency
				);
		apDevices.add(i,ap);
	}

	public static void addSmartThing(List<MobileDevice> smartThing, Coordinate coordDevices, int i){

		int coordX,coordY;
		int direction, speed;
		direction = getRand().nextInt(MaxAndMin.MAX_DIRECTION-1)+1;
		speed = getRand().nextInt(MaxAndMin.MAX_SPEED-1)+1;
		VmMigrationTechnique migrationTechnique = null;

		if(getPolicyReplicaVM()==Policies.MIGRATION_COMPLETE_VM){
			migrationTechnique = new CompleteVM(getMigPointPolicy());
		}
		else if(getPolicyReplicaVM()==Policies.MIGRATION_CONTAINER_VM){
			migrationTechnique = new ContainerVM(getMigPointPolicy());
		}
		else if(getPolicyReplicaVM()==Policies.LIVE_MIGRATION){
			migrationTechnique = new LiveMigration(getMigPointPolicy());

		}
		DeterministicDistribution distribution0 = new DeterministicDistribution(EEG_TRANSMISSION_TIME);

		/***************Start set of Mobile Sensors****************/

		Set<MobileSensor> sensors = new HashSet<>();
		MobileSensor sensor = new MobileSensor("Sensor"+i //Tuple's name
				, "EEG"+i //Tuple's type
				, i //User Id
				, "MyApp_vr_game"+i //app's name
				, distribution0 );
		sensors.add(sensor);

		/***************End set of Mobile Sensors****************/


		/***************Start set of Mobile Actuators ****************/

		Set<MobileActuator> actuators = new HashSet<>();
		MobileActuator actuator = new MobileActuator("Actuator"+i
				, i
				, "MyApp_vr_game"+i
				, "DISPLAY"+i);
		actuators.add(actuator);

		/***************End set of Mobile Actuators ****************/

		/***************Start MobileDevice Configurations ****************/

		FogLinearPowerModel powerModel = new FogLinearPowerModel(87.53d, 82.44d);//10//maxPower

		List<Pe> peList = new ArrayList<>();
		int mips = 1000;
		peList.add(new Pe(0, new PeProvisionerOverbooking(mips))); 

		int hostId = FogUtils.generateEntityId();
		long storage = 40000;
		int bw = 2048;
		int ram = 1024;
		PowerHost host = new PowerHost(//To the hardware's characteristics (MobileDevice) - to CloudSim
				hostId,
				new RamProvisionerSimple(ram),
				new BwProvisionerOverbooking(bw),
				storage,
				peList,
				new StreamOperatorScheduler(peList),
				powerModel
				);

		List<Host> hostList = new ArrayList<Host>();
		hostList.add(host);


		String arch = "x86"; // system architecture
		String os = "Android"; // operating system
		String vmm = "empty";//Empty 
		double vmSize = MaxAndMin.MAX_VM_SIZE;
		double time_zone = 10.0; // time zone this resource located
		double cost = 1.0; // the cost of using processing in this resource
		double costPerMem = 0.005; // the cost of using memory in this resource
		double costPerStorage = 0.0001; // the cost of using storage in this
		// resource
		double costPerBw = 0.001; // the cost of using bw in this resource
		LinkedList<Storage> storageList = new LinkedList<Storage>(); // we are not adding SAN
		// devices by now

		//for Characteristics 

		FogDeviceCharacteristics characteristics = new FogDeviceCharacteristics(arch
				, os
				, vmm
				, host
				, time_zone
				, cost
				, costPerMem
				, costPerStorage
				, costPerBw);

		AppModuleAllocationPolicy vmAllocationPolicy = new AppModuleAllocationPolicy(hostList);

		MobileDevice st = null;
		float maxServiceValue = getRand().nextFloat()*100;
		try {

			while(true){
				coordX =  getRand().nextInt((int)(MaxAndMin.MAX_X*0.8));
				coordY =  getRand().nextInt((int)(MaxAndMin.MAX_Y*0.8));
				if((coordX < MaxAndMin.MAX_X*0.2) ||(coordY < MaxAndMin.MAX_Y*0.2)){
					continue;
				}

				st = new MobileDevice("SmartThing"+ Integer.toString(i)
				, characteristics
				, vmAllocationPolicy
				, storageList
				, 2//schedulingInterval
				, 1 * 1024 * 1024//uplinkBandwidth - 1 Mbit
				, 2 * 1024 * 1024//downlinkBandwidth - 2 Mbits
				, 2//uplinkLatency
				, 0.01//mipsPer..
				, coordX, coordY
				, i//id
				, direction
				, speed
				, maxServiceValue
				, vmSize
				, migrationTechnique);
				st.setTempSimulation(0);
				st.setTimeFinishDeliveryVm(-1);
				st.setTimeFinishHandoff(0);
				st.setSensors(sensors);
				st.setActuators(actuators);

				smartThing.add(i,st);
				break;
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addServerCloudlet(List<FogDevice> serverCloudlets, Coordinate coordDevices, int i){

		int coordX,coordY;
		DecisionMigration migrationStrategy;
		if(getMigStrategyPolicy()==Policies.LOWEST_LATENCY){
			migrationStrategy = new LowestLatency(getServerCloudlets(), getApDevices(), getMigPointPolicy(), getPolicyReplicaVM());
		}
		else if(getMigStrategyPolicy()==Policies.LOWEST_DIST_BW_SMARTTING_SERVERCLOUDLET){
			migrationStrategy = new LowestDistBwSmartThingServerCloudlet(getServerCloudlets(), getApDevices(), getMigPointPolicy(), getPolicyReplicaVM());

		}
		else{ 
			migrationStrategy = new LowestDistBwSmartThingAP(getServerCloudlets(), getApDevices(), getMigPointPolicy(), getPolicyReplicaVM());
		}

		BeforeMigration beforeMigration = null;
		if(getPolicyReplicaVM()==Policies.MIGRATION_COMPLETE_VM){
			beforeMigration = new PrepareCompleteVM();
		}
		else if(getPolicyReplicaVM()==Policies.MIGRATION_CONTAINER_VM){
			beforeMigration = new PrepareContainerVM();
		}
		else if(getPolicyReplicaVM()==Policies.LIVE_MIGRATION){
			beforeMigration = new PrepareLiveMigration();
		}

		FogLinearPowerModel powerModel = new FogLinearPowerModel(107.339d, 83.433d);//10//maxPower

		List<Pe> peList = new ArrayList<>();//CloudSim Pe (Processing Element) class represents CPU unit, defined in terms of Millions
		//		 * Instructions Per Second (MIPS) rating
		int mips = 2800000*(i+1);
		// 3. Create PEs and add these into a list.
		peList.add(new Pe(0, new PeProvisionerOverbooking(mips))); // need to store Pe id and MIPS Rating - to CloudSim 

		int hostId = FogUtils.generateEntityId();
		long storage = 1000*1024*1024;//Long.MAX_VALUE; // host storage 
		int bw = 1000 * 1024 * 1024;
		int ram = 25000;//host memory (MB)
		PowerHost host = new PowerHost(//To the hardware's characteristics (MobileDevice) - to CloudSim
				hostId,
				new RamProvisionerSimple(ram),
				new BwProvisionerOverbooking(bw),
				storage,
				peList,
				new StreamOperatorScheduler(peList),
				powerModel
				);

		List<Host> hostList = new ArrayList<Host>();
		hostList.add(host);

		String arch = "x86"; // system architecture
		String os = "Linux"; // operating system
		String vmm = "Empty";//Empty 
		double time_zone = 10.0; // time zone this resource located
		double cost = 3.0; // the cost of using processing in this resource
		double costPerMem = 0.05; // the cost of using memory in this resource
		double costPerStorage = 0.001; // the cost of using storage in this
		// resource
		double costPerBw = 0.0; // the cost of using bw in this resource
		LinkedList<Storage> storageList = new LinkedList<Storage>(); // we are not adding SAN
		// devices by now
		FogDeviceCharacteristics characteristics = new FogDeviceCharacteristics(arch
				, os
				, vmm
				, host
				, time_zone
				, cost
				, costPerMem
				, costPerStorage
				, costPerBw);

		AppModuleAllocationPolicy vmAllocationPolicy = new AppModuleAllocationPolicy(hostList);
		FogDevice  sc = null;
		Service serviceOffer = new Service(); 
		serviceOffer.setType(getRand().nextInt(10000)%MaxAndMin.MAX_SERVICES);
		if(serviceOffer.getType()==Services.HIBRID || serviceOffer.getType() == Services.PUBLIC){
			serviceOffer.setValue(getRand().nextFloat()*10);
		}
		else {
			serviceOffer.setValue(0);
		}
		try {

			coordX =  getRand().nextInt(MaxAndMin.MAX_X);
			coordY =  getRand().nextInt(MaxAndMin.MAX_X);
			double maxBandwidth = getMaxBandwidth()*1024*1024;//MaxAndMin.MAX_BANDWIDTH;
			double minBandwidth = (getMaxBandwidth()-9)*1024*1024;//MaxAndMin.MIN_BANDWIDTH;
			double upLinkRandom = minBandwidth + (maxBandwidth - minBandwidth) * getRand().nextDouble();
			double downLinkRandom = minBandwidth + (maxBandwidth - minBandwidth) * getRand().nextDouble();

			sc =  new FogDevice("ServerCloudlet"+ Integer.toString(i) //name
			, characteristics
			, vmAllocationPolicy//vmAllocationPolicy
			, storageList
			, 10//schedulingInterval
			, upLinkRandom//uplinkBandwidth
			, downLinkRandom//downlinkBandwidth
			, 4//rand.nextDouble()//uplinkLatency
			, 0.01//mipsPer..
			, coordX, coordY
			, i
			, serviceOffer
			, migrationStrategy
			, getPolicyReplicaVM()
			, beforeMigration
					);
			serverCloudlets.add(i,sc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addServerCloudlet(List<FogDevice> serverCloudlets, Coordinate coordDevices){
		int i=0;
		int coordX,coordY;

		for(coordX=1001; coordX<MaxAndMin.MAX_X-990; coordX+=10001){ /*evenly distributed*/
			for(coordY=1001; coordY<MaxAndMin.MAX_Y-990; coordY+=10001, i++){
				DecisionMigration migrationStrategy;
				if(getMigStrategyPolicy()==Policies.LOWEST_LATENCY){
					migrationStrategy = new LowestLatency(getServerCloudlets(), getApDevices(), getMigPointPolicy(), getPolicyReplicaVM());
				}
				else if(getMigStrategyPolicy()==Policies.LOWEST_DIST_BW_SMARTTING_SERVERCLOUDLET){
					migrationStrategy = new LowestDistBwSmartThingServerCloudlet(getServerCloudlets(), getApDevices(), getMigPointPolicy(), getPolicyReplicaVM());
				}
				else{ 
					migrationStrategy = new LowestDistBwSmartThingAP(getServerCloudlets(), getApDevices(), getMigPointPolicy(), getPolicyReplicaVM());
				}
				BeforeMigration beforeMigration = null;
				if(getPolicyReplicaVM()==Policies.MIGRATION_COMPLETE_VM){
					beforeMigration = new PrepareCompleteVM();
				}
				else if(getPolicyReplicaVM()==Policies.MIGRATION_CONTAINER_VM){
					beforeMigration = new PrepareContainerVM();
				}
				else if(getPolicyReplicaVM()==Policies.LIVE_MIGRATION){
					beforeMigration = new PrepareLiveMigration();
				}



				FogLinearPowerModel powerModel = new FogLinearPowerModel(107.339d, 83.433d);//10//maxPower

				List<Pe> peList = new ArrayList<>();//CloudSim Pe (Processing Element) class represents CPU unit, defined in terms of Millions
				//		 * Instructions Per Second (MIPS) rating
				int mips = 2800000*(i+1);
				// 3. Create PEs and add these into a list.
				peList.add(new Pe(0, new PeProvisionerOverbooking(mips))); // need to store Pe id and MIPS Rating - to CloudSim 

				int hostId = FogUtils.generateEntityId();
				long storage = 1000*1024*1024;//Long.MAX_VALUE; // host storage 
				int bw = 1000 * 1024 * 1024;
				int ram = 25000;//host memory (MB)
				PowerHost host = new PowerHost(//To the hardware's characteristics (MobileDevice) - to CloudSim
						hostId,
						new RamProvisionerSimple(ram),
						new BwProvisionerOverbooking(bw),
						storage,
						peList,
						new StreamOperatorScheduler(peList),
						powerModel
						);

				List<Host> hostList = new ArrayList<Host>();
				hostList.add(host);

				String arch = "x86"; // system architecture
				String os = "Linux"; // operating system
				String vmm = "Empty";//Empty 
				double time_zone = 10.0; // time zone this resource located
				double cost = 3.0; // the cost of using processing in this resource
				double costPerMem = 0.05; // the cost of using memory in this resource
				double costPerStorage = 0.001; // the cost of using storage in this
				// resource
				double costPerBw = 0.0; // the cost of using bw in this resource
				LinkedList<Storage> storageList = new LinkedList<Storage>(); // we are not adding SAN
				// devices by now
				FogDeviceCharacteristics characteristics = new FogDeviceCharacteristics(arch
						, os
						, vmm
						, host
						, time_zone
						, cost
						, costPerMem
						, costPerStorage
						, costPerBw);

				AppModuleAllocationPolicy vmAllocationPolicy = new AppModuleAllocationPolicy(hostList);
				FogDevice  sc = null;
				Service serviceOffer = new Service(); 
				serviceOffer.setType(getRand().nextInt(10000)%MaxAndMin.MAX_SERVICES);
				if(serviceOffer.getType()==Services.HIBRID || serviceOffer.getType() == Services.PUBLIC){
					serviceOffer.setValue(getRand().nextFloat()*10);
				}
				else {
					serviceOffer.setValue(0);
				}
				try {
					double maxBandwidth = getMaxBandwidth()*1024*1024;//MaxAndMin.MAX_BANDWIDTH;
					double minBandwidth = (getMaxBandwidth()-9)*1024*1024;//MaxAndMin.MIN_BANDWIDTH;
					double upLinkRandom = minBandwidth + (maxBandwidth - minBandwidth) * getRand().nextDouble();
					double downLinkRandom = minBandwidth + (maxBandwidth - minBandwidth) * getRand().nextDouble();
					sc =  new FogDevice("ServerCloudlet"+ Integer.toString(i) //name
					, characteristics
					, vmAllocationPolicy//vmAllocationPolicy
					, storageList
					, 10//schedulingInterval
					, upLinkRandom//uplinkBandwidth
					, downLinkRandom//downlinkBandwidth
					, 4//rand.nextDouble()//uplinkLatency
					, 0.01//mipsPer..
					, coordX, coordY
					, i
					, serviceOffer
					, migrationStrategy
					, getPolicyReplicaVM()
					, beforeMigration
							);
					serverCloudlets.add(i,sc);
					sc.setParentId(-1);

					//					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		LogMobile.debug("AppExemplo2.java", "Total of serverCloudlets: "+i);
	}
	private static void createServerCloudletsNetwork(List<FogDevice> serverCloudlets){
		//for no full graph, use -1 to link
		HashMap<FogDevice, Double> net = new HashMap<>();
		for(FogDevice sc : serverCloudlets){//It makes a full graph 
			for(FogDevice sc1 : serverCloudlets){
				if(sc.equals(sc1)){
					break;
				}
				if(sc.getUplinkBandwidth() < sc1.getDownlinkBandwidth()){
					net.put(sc1, sc.getUplinkBandwidth());
					NetworkTopology.addLink(sc.getId(), sc1.getId(), sc.getUplinkBandwidth(),0.5);//getRand().nextDouble());
				}
				else{
					net.put(sc1,sc1.getDownlinkBandwidth());
					NetworkTopology.addLink(sc.getId(), sc1.getId(), sc1.getDownlinkBandwidth(),0.5);//getRand().nextDouble());
				}	
			}
			sc.setNetServerCloudlets(net);
		}
	}

	@SuppressWarnings("unused")
	private static Application createApplication(String appId, int userId, int myId, AppModule userVm){

		Application application = Application.createApplication(appId, userId); // creates an empty application model (empty directed graph)
		application.addAppModule(userVm); // adding module Client to the application model
		application.addAppModule("client"+myId,"appModuleClient"+myId, 10);

		/*
		 * Connecting the application modules (vertices) in the application model (directed graph) with edges
		 */
		if(EEG_TRANSMISSION_TIME>=10)
			application.addAppEdge("EEG"+myId, "client"+myId, 2000, 500, "EEG"+myId, Tuple.UP, AppEdge.SENSOR); // adding edge from EEG (sensor) to Client module carrying tuples of type EEG
		else
			application.addAppEdge("EEG"+myId, "client"+myId, 3000, 500, "EEG"+myId, Tuple.UP, AppEdge.SENSOR);

		application.addAppEdge("client"+myId, userVm.getName(), 3500, 500, "_SENSOR"+myId, Tuple.UP, AppEdge.MODULE); // adding edge from Client to Concentration Calculator module carrying tuples of type _SENSOR

		application.addAppEdge(userVm.getName(), userVm.getName(), 1000, 1000, 1000, "PLAYER_GAME_STATE"+myId, Tuple.UP, AppEdge.MODULE); // adding periodic edge (period=1000ms) from Concentration Calculator to Connector module carrying tuples of type PLAYER_GAME_STATE
		application.addAppEdge(userVm.getName(), "client"+myId, 14, 500, "CONCENTRATION"+myId, Tuple.DOWN, AppEdge.MODULE);  // adding edge from Concentration Calculator to Client module carrying tuples of type CONCENTRATION
		application.addAppEdge(userVm.getName(), "client"+myId, 1000, 28, 1000, "GLOBAL_GAME_STATE"+myId, Tuple.DOWN, AppEdge.MODULE); // adding periodic edge (period=1000ms) from Connector to Client module carrying tuples of type GLOBAL_GAME_STATE
		application.addAppEdge("client"+myId, "DISPLAY"+myId, 1000, 500, "SELF_STATE_UPDATE"+myId, Tuple.DOWN, AppEdge.ACTUATOR);  // adding edge from Client module to Display (actuator) carrying tuples of type SELF_STATE_UPDATE
		application.addAppEdge("client"+myId, "DISPLAY"+myId, 1000, 500, "GLOBAL_STATE_UPDATE"+myId, Tuple.DOWN, AppEdge.ACTUATOR);  // adding edge from Client module to Display (actuator) carrying tuples of type GLOBAL_STATE_UPDATE


		/*
		 * Defining the input-output relationships (represented by selectivity) of the application modules. 
		 */

		application.addTupleMapping("client"+myId, "EEG"+myId, "_SENSOR"+myId, new FractionalSelectivity(0.9)); // 0.9 tuples of type _SENSOR are emitted by Client module per incoming tuple of type EEG 
		application.addTupleMapping("client"+myId, "CONCENTRATION"+myId, "SELF_STATE_UPDATE"+myId, new FractionalSelectivity(1.0)); // 1.0 tuples of type SELF_STATE_UPDATE are emitted by Client module per incoming tuple of type CONCENTRATION 
		application.addTupleMapping(userVm.getName(), "_SENSOR"+myId, "CONCENTRATION"+myId, new FractionalSelectivity(1.0)); // 1.0 tuples of type CONCENTRATION are emitted by Concentration Calculator module per incoming tuple of type _SENSOR 
		application.addTupleMapping("client"+myId, "GLOBAL_GAME_STATE"+myId, "GLOBAL_STATE_UPDATE"+myId, new FractionalSelectivity(1.0)); // 1.0 tuples of type GLOBAL_STATE_UPDATE are emitted by Client module per incoming tuple of type GLOBAL_GAME_STATE 


		/*
		 * Defining application loops to monitor the latency of. 
		 * Here, we add only one loop for monitoring : EEG(sensor) -> Client -> Concentration Calculator -> Client -> DISPLAY (actuator)
		 */
		final String client="client"+myId;//userVm.getName();
		final String concentration = userVm.getName();
		final String eeg = "EEG"+myId;
		final String display ="DISPLAY"+myId;
		final AppLoop loop1 = new AppLoop(new ArrayList<String>(){{add(eeg);add(client);add(concentration);add(client);add(display);}});
		List<AppLoop> loops = new ArrayList<AppLoop>(){{add(loop1);}};
		application.setLoops(loops);

		return application;
	}


	public static int getPolicyReplicaVM() {
		return policyReplicaVM;
	}

	public static void setPolicyReplicaVM(int policyReplicaVM) {
		AppExemplo.policyReplicaVM = policyReplicaVM;
	}

	public static int getStepPolicy() {
		return stepPolicy;
	}

	public static void setStepPolicy(int stepPolicy) {
		AppExemplo.stepPolicy = stepPolicy;
	}

	public static List<MobileDevice> getSmartThings() {
		return smartThings;
	}
	public static void setSmartThings(List<MobileDevice> smartThings) {
		AppExemplo.smartThings = smartThings;
	}
	public static List<FogDevice> getServerCloudlets() {
		return serverCloudlets;
	}
	public static void setServerCloudlets(List<FogDevice> serverCloudlets) {
		AppExemplo.serverCloudlets = serverCloudlets;
	}
	public static List<ApDevice> getApDevices() {
		return apDevices;
	}
	public static void setApDevices(List<ApDevice> apDevices) {
		AppExemplo.apDevices = apDevices;
	}
	public static int getMigPointPolicy() {
		return migPointPolicy;
	}

	public static void setMigPointPolicy(int migPointPolicy) {
		AppExemplo.migPointPolicy = migPointPolicy;
	}

	public static int getMigStrategyPolicy() {
		return migStrategyPolicy;
	}

	public static void setMigStrategyPolicy(int migStrategyPolicy) {
		AppExemplo.migStrategyPolicy = migStrategyPolicy;
	}

	public static int getPositionApPolicy() {
		return positionApPolicy;
	}

	public static void setPositionApPolicy(int positionApPolicy) {
		AppExemplo.positionApPolicy = positionApPolicy;
	}

	public static Coordinate getCoordDevices() {
		return coordDevices;
	}

	public static void setCoordDevices(Coordinate coordDevices) {
		AppExemplo.coordDevices = coordDevices;
	}


	public static List<FogBroker> getBrokerList() {
		return brokerList;
	}


	public static void setBrokerList(List<FogBroker> brokerList) {
		AppExemplo.brokerList = brokerList;
	}




	public static List<String> getAppIdList() {
		return appIdList;
	}




	public static void setAppIdList(List<String> appIdList) {
		AppExemplo.appIdList = appIdList;
	}




	public static List<Application> getApplicationList() {
		return applicationList;
	}




	public static void setApplicationList(List<Application> applicationList) {
		AppExemplo.applicationList = applicationList;
	}




	public static int getSeed() {
		return seed;
	}




	public static void setSeed(int seed) {
		AppExemplo.seed = seed;
	}




	public static int getPositionScPolicy() {
		return positionScPolicy;
	}




	public static void setPositionScPolicy(int positionScPolicy) {
		AppExemplo.positionScPolicy = positionScPolicy;
	}




	public static int getMaxSmartThings() {
		return maxSmartThings;
	}




	public static void setMaxSmartThings(int maxSmartThings) {
		AppExemplo.maxSmartThings = maxSmartThings;
	}

	public static Random getRand() {
		return rand;
	}

	public static void setRand(Random rand) {
		AppExemplo.rand = rand;
	}

	public static int getMaxBandwidth() {
		return maxBandwidth;
	}

	public static void setMaxBandwidth(int maxBandwidth) {
		AppExemplo.maxBandwidth = maxBandwidth;
	}

	public static boolean isMigrationAble() {
		return migrationAble;
	}

	public static void setMigrationAble(boolean migrationAble) {
		AppExemplo.migrationAble = migrationAble;
	}


}


