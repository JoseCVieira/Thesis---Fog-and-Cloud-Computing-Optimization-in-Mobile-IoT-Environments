package org.fog.placement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.apache.commons.math3.util.Pair;
import org.cloudbus.cloudsim.CloudletScheduler;
import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.NetworkTopology;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.core.SimEntity;
import org.cloudbus.cloudsim.core.SimEvent;
import org.fog.application.AppEdge;
import org.fog.application.AppLoop;
import org.fog.application.AppModule;
import org.fog.application.Application;
import org.fog.application.selectivity.SelectivityModel;
import org.fog.entities.*;
import org.fog.localization.Coordinate;
import org.fog.localization.Distances;
import org.fog.utils.Config;
import org.fog.utils.FogEvents;
import org.fog.utils.FogUtils;
import org.fog.utils.ModuleLaunchConfig;
import org.fog.utils.NetworkUsageMonitor;
import org.fog.utils.TimeKeeper;
import org.fog.vmmigration.Migration;
import org.fog.vmmigration.MyStatistics;
import org.fog.vmmigration.NextStep;
import org.fog.vmmobile.LogMobile;
import org.fog.vmmobile.constants.MaxAndMin;
import org.fog.vmmobile.constants.MobileEvents;
/**
 * @author Marcio Moraes Lopes
 */

public class MobileController extends SimEntity {
	private static boolean migrationAble;
	private static int migPointPolicy;

	private static int stepPolicy; //Quantity of steps in the nextStep Function
	private static Coordinate coordDevices;//=new Coordinate(MaxAndMin.MAX_X, MaxAndMin.MAX_Y);//Grid/Map 

	private static int migStrategyPolicy;
	private static int seed;

	private static List<FogDevice> serverCloudlets;
	private static List<MobileDevice> smartThings;
	private static List<ApDevice> apDevices;
	private static List<FogBroker> brokerList;

	private Map<String, Application> applications;
	private Map<String, Integer> appLaunchDelays;
	private ModuleMapping moduleMapping;
	private Map<Integer, Double> globalCurrentCpuLoad;

	static final int numOfDepts = 1;
	static final int numOfMobilesPerDept = 4;
	private static Random rand;
	public MobileController(){

	}
	public MobileController(String name, List<FogDevice> serverCloudlets, List<ApDevice> apDevices, List<MobileDevice> smartThings,List<FogBroker> brokers, ModuleMapping moduleMapping
			, int migPointPolicy, int migStrategyPolicy, int stepPolicy, Coordinate coordDevices, int seed, boolean migrationAble) {
		// TODO Auto-generated constructor stub
		super(name);
		this.applications = new HashMap<String, Application>();
		this.globalCurrentCpuLoad = new HashMap <Integer, Double>();
		setAppLaunchDelays(new HashMap<String, Integer>());
		setModuleMapping(moduleMapping);
		for(FogDevice sc : serverCloudlets){
			sc.setControllerId(getId());
		}
		setSeed(seed);
		setServerCloudlets(serverCloudlets);
		setApDevices(apDevices);
		setSmartThings(smartThings);
		setBrokerList(brokers);
		setMigPointPolicy(migPointPolicy);
		setMigStrategyPolicy(migStrategyPolicy);
		setStepPolicy(stepPolicy);
		setCoordDevices(coordDevices);
		connectWithLatencies();
		initializeCPULoads();
		setRand(new Random(getSeed()*Long.MAX_VALUE));
		setMigrationAble(migrationAble);
	}
	public MobileController(String name, List<FogDevice> serverCloudlets,
			List<ApDevice> apDevices, List<MobileDevice> smartThings,
			int migPointPolicy, int migStrategyPolicy, int stepPolicy,
			Coordinate coordDevices, int seed) {
		// TODO Auto-generated constructor stub
		super(name);
		this.applications = new HashMap<String, Application>();
		this.globalCurrentCpuLoad = new HashMap <Integer, Double>();
		setAppLaunchDelays(new HashMap<String, Integer>());
		setModuleMapping(moduleMapping);
		for(FogDevice sc : serverCloudlets){
			sc.setControllerId(getId());
		}
		setSeed(seed);
		setServerCloudlets(serverCloudlets);
		setApDevices(apDevices);
		setSmartThings(smartThings);
		setMigPointPolicy(migPointPolicy);
		setMigStrategyPolicy(migStrategyPolicy);
		setStepPolicy(stepPolicy);
		setCoordDevices(coordDevices);
		connectWithLatencies();
		initializeCPULoads();
		setRand(new Random(getSeed()*Long.MAX_VALUE));

	}
	private void connectWithLatencies(){
		for(FogDevice st : getSmartThings()){
			FogDevice parent = getFogDeviceById(st.getParentId());
			if(parent == null){
				continue;
			}
			double latency = st.getUplinkLatency();
			parent.getChildToLatencyMap().put(st.getId(), latency);
			parent.getChildrenIds().add(st.getId());
		}
	}
	private FogDevice getFogDeviceById(int id){
		for(FogDevice sc : getServerCloudlets()){
			if(id==sc.getId())
				return sc;
		}
		return null;
	}

	private void initializeCPULoads() {
		//		Map<String, Map<String, Integer>> mapping = moduleMapping.getModuleMapping();
		//		for(String deviceName : mapping.keySet()){
		//			FogDevice device = getDeviceByName(deviceName);
		//			for(String moduleName : mapping.get(deviceName).keySet()){
		//				
		//				AppModule module = getApplication().getModuleByName(moduleName);
		//				if(module == null)
		//					continue;
		//				getCurrentCpuLoad().put(device.getId(), getCurrentCpuLoad().get(device.getId()).doubleValue() + module.getMips());
		//			}
		//		}
		for(FogDevice sc : getServerCloudlets()){
			this.globalCurrentCpuLoad.put(sc.getId(), 0.0);
		}
		for(MobileDevice st : getSmartThings()){
			this.globalCurrentCpuLoad.put(st.getId(), 0.0);
		}
	}
	@Override
	public void startEntity() {
		// TODO Auto-generated method stub
		for(String appId : applications.keySet()){
			LogMobile.debug("MobileController.java",appId +" - "+getAppLaunchDelays().get(appId));
			if(getAppLaunchDelays().get(appId)==0)
				processAppSubmit(applications.get(appId));
			else
				send(getId(), getAppLaunchDelays().get(appId), FogEvents.APP_SUBMIT, applications.get(appId));
		}
		for(int i = 0; i<MaxAndMin.MAX_SIMULATION_TIME; i+=1000){
			send(getId()//Application
					, i //delay -> When the event will occur 
					, MobileEvents.NEXT_STEP
					);//, getSmartThings());	
			send(getId()
					,i
					,MobileEvents.CHECK_NEW_STEP);
		}

		if(isMigrationAble()){
			for(FogDevice sc: getServerCloudlets()){
				for(int i = 0; i<MaxAndMin.MAX_SIMULATION_TIME; i+=1000){
					send(sc.getId()//serverCloudlet
							, i //delay -> When the event will occur 
							, MobileEvents.MAKE_DECISION_MIGRATION
							, sc.getSmartThings());
				}
			}
		}



		send(getId(), Config.RESOURCE_MANAGE_INTERVAL, FogEvents.CONTROLLER_RESOURCE_MANAGE);

		for(FogDevice dev : getServerCloudlets())
			sendNow(dev.getId(), FogEvents.RESOURCE_MGMT);

		send(getId(), MaxAndMin.MAX_SIMULATION_TIME, MobileEvents.STOP_SIMULATION);
	}
	private void processAppSubmit(SimEvent ev){
		Application app = (Application) ev.getData();
		processAppSubmit(app);
	}
	private void processAppSubmit(Application application){
		System.out.println(CloudSim.clock()+" Submitted application "+ application.getAppId());
		FogUtils.appIdToGeoCoverageMap.put(application.getAppId(), application.getGeoCoverage());
		getApplications().put(application.getAppId(), application);
		List<FogDevice> tempAllDevices = new ArrayList<>();
		for(FogDevice sc: getServerCloudlets()){
			tempAllDevices.add(sc);
		}

		for(MobileDevice st: getSmartThings()){
			tempAllDevices.add(st);
		}

		ModulePlacement modulePlacement = new ModulePlacementMapping(tempAllDevices//getServerCloudlets()
				, application, getModuleMapping(),globalCurrentCpuLoad);


		for(FogDevice fogDevice : getServerCloudlets()){
			sendNow(fogDevice.getId(), FogEvents.ACTIVE_APP_UPDATE, application);
		}
		for(MobileDevice st : getSmartThings()){
			sendNow(st.getId(), FogEvents.ACTIVE_APP_UPDATE, application);
		}

		Map<Integer, List<AppModule>> deviceToModuleMap = modulePlacement.getDeviceToModuleMap();
		Map<Integer, Map<String, Integer>> instanceCountMap = modulePlacement.getModuleInstanceCountMap();
		for(Integer deviceId : deviceToModuleMap.keySet()){
			for(AppModule module : deviceToModuleMap.get(deviceId)){
				sendNow(deviceId, FogEvents.APP_SUBMIT, application);
				sendNow(deviceId, FogEvents.LAUNCH_MODULE, module);
				sendNow(deviceId, FogEvents.LAUNCH_MODULE_INSTANCE,
						new ModuleLaunchConfig(module, instanceCountMap.get(deviceId).get(module.getName())));
			}

		}
	}
	private void processAppSubmitMigration(SimEvent ev){
		Application application = (Application) ev.getData();
		System.out.println(CloudSim.clock()+" Submitted application after migration "+ application.getAppId());
		FogUtils.appIdToGeoCoverageMap.put(application.getAppId(), application.getGeoCoverage());
		getApplications().put(application.getAppId(), application);
		FogDevice sc = (FogDevice)CloudSim.getEntity(ev.getSource());
		List<FogDevice> tempList =new ArrayList<>();
		tempList.add(sc);
		ModulePlacement modulePlacement = new ModulePlacementMapping(tempList//getServerCloudlets()
				, application, getModuleMapping(),globalCurrentCpuLoad,true);

		//		for(FogDevice fogDevice : getServerCloudlets()){
		sendNow(sc.getId(), FogEvents.ACTIVE_APP_UPDATE, application);
		//		}

		Map<Integer, List<AppModule>> deviceToModuleMap = modulePlacement.getDeviceToModuleMap();
		Map<Integer, Map<String, Integer>> instanceCountMap = modulePlacement.getModuleInstanceCountMap();
		//		for(Integer deviceId : deviceToModuleMap.keySet()){
		for(AppModule module : deviceToModuleMap.get(sc.getId())){
			sendNow(sc.getId(), FogEvents.APP_SUBMIT, application);
			sendNow(sc.getId(), FogEvents.LAUNCH_MODULE, module);
			sendNow(sc.getId(), FogEvents.LAUNCH_MODULE_INSTANCE,
					new ModuleLaunchConfig(module, instanceCountMap.get(sc.getId()).get(module.getName())));
		}

		//		}
	}

	private void processTupleFinished(SimEvent ev) {
	}
	protected void manageResources(){
		send(getId(), Config.RESOURCE_MANAGE_INTERVAL, FogEvents.CONTROLLER_RESOURCE_MANAGE);
	}


	@Override
	public void processEvent(SimEvent ev) {
		// TODO Auto-generated method stub
		switch(ev.getTag()){
		case FogEvents.APP_SUBMIT:
			System.out.println("APP_SUBMIT");
			processAppSubmit(ev);
			break;
		case MobileEvents.APP_SUBMIT_MIGRATE:
			processAppSubmitMigration(ev);
			break;

		case FogEvents.TUPLE_FINISHED:
			System.out.println("TUPLE_FINISHED");
			processTupleFinished(ev);
			break;
		case FogEvents.CONTROLLER_RESOURCE_MANAGE:
			manageResources();
			break;
		case MobileEvents.NEXT_STEP:
			NextStep.nextStep(getServerCloudlets()
					, getApDevices()
					, getSmartThings()
					, getCoordDevices()
					, getStepPolicy()
					, getSeed());

			break;
		case MobileEvents.CREATE_NEW_SMARTTHING:
			createNewSmartThing();
			break;
		case MobileEvents.CHECK_NEW_STEP:
			checkNewStep();
			System.out.println("SmartThingListSize: "+getSmartThings().size());
			if(getSmartThings().isEmpty())
				sendNow(getId(), MobileEvents.STOP_SIMULATION);
			break;
		case MobileEvents.STOP_SIMULATION:
			System.out.println("*********************myStopSimulation MobilieController ***********");
			System.out.println("CloudSim.clock(): "+CloudSim.clock());
			System.out.println("Size SmartThings: "+getSmartThings().size());
			CloudSim.stopSimulation();
			printTimeDetails();
			printPowerDetails();
			printCostDetails();
			printNetworkUsageDetails();
			printMigrationsDetalis();
			System.exit(0);
			break;

		}
	}


	private void createNewSmartThing() {
		// TODO Auto-generated method stub
		int i= getSmartThings().size();


		System.out.println("criado...");
		if(ApDevice.connectApSmartThing(getApDevices(), getSmartThings().get(i),getRand().nextDouble())){
			getSmartThings().get(i).getSourceAp().getServerCloudlet().connectServerCloudletSmartThing(getSmartThings().get(i));
			System.out.println("conectado... "+getSmartThings().get(i).getSourceServerCloudlet().getName());
		}

	}
	private double migrationTimeToLiveMigration(MobileDevice smartThing) {
		// TODO Auto-generated method stub
		double runTime = CloudSim.clock()-smartThing.getTimeStartLiveMigration(); 		
		if(smartThing.getMigTime()>runTime){
			runTime = smartThing.getMigTime()-runTime;
			return runTime;
		}
		else{
			return 0;
		}

	}

	private void checkNewStep() {
		// TODO Auto-generated method stub
		int index=0;

		for(MobileDevice st: getSmartThings()){
			MyStatistics.getInstance().getEnergyHistory().put(st.getMyId(), st.getEnergyConsumption());
			MyStatistics.getInstance().getPowerHistory().put(st.getMyId(),st.getHost().getPower());
			if(st.getSourceAp()!=null){
				if(!st.isLockedToHandoff()){//(!st.isHandoffStatus()){
					double distance=Distances.checkDistance(st.getCoord(), st.getSourceAp().getCoord());
					//					List<ApDevice> tempApList=new ArrayList<>();


					if(distance>=MaxAndMin.MAX_DISTANCE-MaxAndMin.MAX_DISTANCE_TO_HANDOFF && distance<MaxAndMin.MAX_DISTANCE){ //Handoff Zone
						index=Migration.nextAp(getApDevices(), st);
						if(index >= 0){//index isn't negative 
							st.setDestinationAp(getApDevices().get(index));	
							st.setHandoffStatus(true);
							st.setLockedToHandoff(true);
							float handoffLocked = (float) ((MaxAndMin.MAX_DISTANCE_TO_HANDOFF/(st.getSpeed()+1))*2000);

							double handoffTime = MaxAndMin.MIN_HANDOFF_TIME + (MaxAndMin.MAX_HANDOFF_TIME - MaxAndMin.MIN_HANDOFF_TIME) * getRand().nextDouble(); //"Maximo" tempo para handoff
							int delayConnection = 100; //connection between SmartThing and ServerCloudlet


							if(!st.getDestinationAp().getServerCloudlet().equals(st.getSourceServerCloudlet())){	

								if(isMigrationAble()){
									LogMobile.debug("MobileController.java", st.getName()+" will be desconnected from "+ 
											st.getSourceServerCloudlet().getName()+" by handoff");
									sendNow(st.getSourceServerCloudlet().getId(),MobileEvents.MAKE_DECISION_MIGRATION,st);
									send(st.getSourceServerCloudlet().getId(),handoffTime+delayConnection-1,MobileEvents.DESCONNECT_ST_TO_SC,st);
									MyStatistics.getInstance().startWithoutConnetion(st.getMyId(),CloudSim.clock());
									send(st.getDestinationAp().getServerCloudlet().getId(), handoffTime+delayConnection,MobileEvents.CONNECT_ST_TO_SC,st);
									if(st.isPostCopyStatus()){
										double newMigTime = migrationTimeToLiveMigration(st);
										if(newMigTime==0){
											newMigTime=((st.getVmMobileDevice().getHost().getRamProvisioner().getUsedRam()*8*1024*1024)/st.getVmLocalServerCloudlet().getUplinkBandwidth())*1000.0;
										}
										double delayProcess = st.getVmLocalServerCloudlet().getCharacteristics().
												getCpuTime((st.getVmMobileDevice().getSize()*1024*1024*8)*0.7, 0.0);//the connection already is opened 
										st.setTimeFinishDeliveryVm(-1.0);
										st.setMigStatus(true);
										MyStatistics.getInstance().startWithoutVmTime(st.getMyId(), CloudSim.clock());
										send(st.getVmLocalServerCloudlet().getId(),newMigTime+delayProcess,MobileEvents.SET_MIG_STATUS_TRUE, st);
									}

								}
							}
							else{
								if(isMigrationAble()){
									if(st.isMigStatus()||st.isPostCopyStatus()){
										sendNow(st.getVmLocalServerCloudlet().getId(), MobileEvents.ABORT_MIGRATION,st);
									}
								}
							}



							send(st.getSourceAp().getId(),handoffTime,MobileEvents.START_HANDOFF,st);
							send(st.getDestinationAp().getId(),handoffLocked,MobileEvents.UNLOCKED_HANDOFF,st);
							MyStatistics.getInstance().setTotalHandoff(1);

							LogMobile.debug("MobileController.java", st.getName()+" handoff was scheduled! "+"SourceAp: "+st.getSourceAp().getName()
									+" NextAp: "+st.getDestinationAp().getName()+"\n");
							LogMobile.debug("MobileController.java", "Distance between "+ st.getName()+" and "+st.getSourceAp().getName()+": "+
									Distances.checkDistance(st.getCoord(), st.getSourceAp().getCoord()));
						}
						else{
							LogMobile.debug("MobileController.java", st.getName()+" can't make handoff because don't exist closest nextAp");
						}
					}
					else if(distance>=MaxAndMin.MAX_DISTANCE) {
						st.getSourceAp().desconnectApSmartThing(st);
						st.getSourceServerCloudlet().desconnectServerCloudletSmartThing(st);
						if(st.isLockedToMigration()||st.isMigStatus()){
							sendNow(st.getVmLocalServerCloudlet().getId(), MobileEvents.ABORT_MIGRATION,st);
						} 
						LogMobile.debug("MobileController.java", st.getName()+" desconnected by MAX_DISTANCE - Distance: "+distance);
						LogMobile.debug("MobileController.java", st.getName()+" X: "+st.getCoord().getCoordX()+ " Y: "+st.getCoord().getCoordY());
					}
				}
			}
			else{
				if(ApDevice.connectApSmartThing(getApDevices(), st, getRand().nextDouble())){ 
					st.getSourceAp().getServerCloudlet().connectServerCloudletSmartThing(st);
					LogMobile.debug("MobileController.java", st.getName() +" has a new connection - SourceAp: "+st.getSourceAp().getName()+
							" SourceServerCouldlet: "+st.getSourceServerCloudlet().getName());

					CloudletScheduler cloudletScheduler = new CloudletSchedulerTimeShared();

					long sizeVm = (MaxAndMin.MIN_VM_SIZE + (long)((MaxAndMin.MAX_VM_SIZE - MaxAndMin.MIN_VM_SIZE) * (getRand().nextDouble())));
					AppModule vmSmartThing = new AppModule(st.getMyId(), "AppModuleVm_"+st.getName()
					, "MyApp_vr_game"+st.getMyId()
					, getBrokerList().get(st.getMyId()).getId()
					, 2000
					, 64
					, 1000
					, sizeVm
					, "Vm_"+st.getName()
					, cloudletScheduler
					, new HashMap<Pair<String, String>, SelectivityModel>());

					st.setVmMobileDevice(vmSmartThing);
					st.getSourceServerCloudlet().getHost().vmCreate(vmSmartThing);
					st.setVmLocalServerCloudlet(st.getSourceServerCloudlet());
					st.setLockedToMigration(false);

					int brokerId=getBrokerList().get(st.getMyId()).getId();
					for(MobileSensor s: st.getSensors()){
						s.setAppId("MyApp_vr_game"+st.getMyId());
						s.setUserId(brokerId);
						s.setGatewayDeviceId(st.getId());
						s.setLatency(6.0);	

					}
					for(MobileActuator a: st.getActuators()){
						a.setUserId(brokerId);
						a.setAppId("MyApp_vr_game"+st.getMyId());
						a.setGatewayDeviceId(st.getId());
						a.setLatency(1.0);
						a.setActuatorType("DISPLAY"+st.getMyId());

					}
					ModuleMapping moduleMapping = ModuleMapping.createModuleMapping();
					moduleMapping.addModuleToDevice(((AppModule)st.getVmMobileDevice()).getName(), st.getSourceServerCloudlet().getName(), 1);//numOfDepts*numOfMobilesPerDept);
					moduleMapping.addModuleToDevice("client"+st.getMyId(), st.getName(), 1);
					processAppSubmit(getApplications().get("MyApp_vr_game"+st.getMyId()));
				}
				else{
					//To do something
				}
			}
		}
	}


	@Override
	public void shutdownEntity() {
		// TODO Auto-generated method stub

	}

	private void printCostDetails(){
		//System.out.println("Cost of execution in cloud = "+getCloud().getTotalCost());
	}
	private FogDevice getCloud(){
		for(FogDevice dev : getServerCloudlets())
			if(dev.getName().equals("cloud"))
				return dev;
		return null;
	}
	private void printPowerDetails() {
		// TODO Auto-generated method stub
		for(FogDevice fogDevice : getServerCloudlets()){
			System.out.println(fogDevice.getName()+ ": Power = "+fogDevice.getHost().getPower());
			System.out.println(fogDevice.getName() + ": Energy Consumed = "+fogDevice.getEnergyConsumption());
		}
		for(int i=0;i<MyStatistics.getInstance().getPowerHistory().size();i++){
			System.out.println("SmartThing"+i+": Power = "+MyStatistics.getInstance().getPowerHistory().get(i));

		}
		for(int i=0;i<MyStatistics.getInstance().getEnergyHistory().size();i++){
			System.out.println("SmartThing"+i+": Energy Consumed = "+MyStatistics.getInstance().getEnergyHistory().get(i));

		}


	}
	private String getStringForLoopId(int loopId){
		for(String appId : getApplications().keySet()){
			Application app = getApplications().get(appId);
			for(AppLoop loop : app.getLoops()){
				if(loop.getLoopId() == loopId)
					return loop.getModules().toString();
			}
		}
		return null;
	}
	double LATENCIA=0.0;
	private void printTimeDetails() {

		System.out.println("=========================================");
		System.out.println("============== RESULTS ==================");
		System.out.println("=========================================");
		System.out.println("EXECUTION TIME : "+ (Calendar.getInstance().getTimeInMillis() - TimeKeeper.getInstance().getSimulationStartTime()));
		System.out.println("=========================================");
		System.out.println("APPLICATION LOOP DELAYS");
		System.out.println("=========================================");
		for(Integer loopId : TimeKeeper.getInstance().getLoopIdToTupleIds().keySet()){
			//			double average = 0, count = 0;
			//			for(int tupleId : TimeKeeper.getInstance().getLoopIdToTupleIds().get(loopId)){
			//				Double startTime = 	TimeKeeper.getInstance().getEmitTimes().get(tupleId);
			//				Double endTime = 	TimeKeeper.getInstance().getEndTimes().get(tupleId);
			//				if(startTime == null || endTime == null)
			//					break;
			//				average += endTime-startTime;
			//				count += 1;
			//			}
			//			System.out.println(getStringForLoopId(loopId) + " ---> "+(average/count));
			System.out.println(getStringForLoopId(loopId) + " ---> "+TimeKeeper.getInstance().getLoopIdToCurrentAverage().get(loopId)+" MaxExecutionTime: "+TimeKeeper.getInstance().getMaxLoopExecutionTime().get(loopId));
			MyStatistics.getInstance().printLatencies(TimeKeeper.getInstance().getLoopIdToCurrentAverage().get(loopId),loopId);
			//LATENCIA=TimeKeeper.getInstance().getLoopIdToCurrentAverage().get(loopId);
		}
		System.out.println("=========================================");
		System.out.println("TUPLE CPU EXECUTION DELAY");
		System.out.println("=========================================");

		for(String tupleType : TimeKeeper.getInstance().getTupleTypeToAverageCpuTime().keySet()){
			System.out.println(tupleType + " ---> "+TimeKeeper.getInstance().getTupleTypeToAverageCpuTime().get(tupleType));
		}

		System.out.println("=========================================");
	}
	private void printNetworkUsageDetails() {
		System.out.println("Total network usage = "+(int)NetworkUsageMonitor.getNetworkUsage()/CloudSim.clock());//Config.MAX_SIMULATION_TIME);
	}
	private void printMigrationsDetalis(){
		System.out.println("=========================================");
		System.out.println("==============MIGRATIONS=================");
		System.out.println("=========================================");
		System.out.println("Total of migrations: "+MyStatistics.getInstance().getTotalMigrations());
		System.out.println("Total of handoff: "+MyStatistics.getInstance().getTotalHandoff());
		System.out.println("Total of migration to differents SC: " + MyStatistics.getInstance().getMyCountLowestLatency());

		MyStatistics.getInstance().printResults();
		System.out.println("***Last time without connection***");

		for(Entry<Integer, Double> test :MyStatistics.getInstance().getWithoutConnectionTime().entrySet()){
			System.out.println("SmartThing"+test.getKey()+": "+MyStatistics.getInstance().getWithoutConnectionTime().get(test.getKey())+" - Max: "+MyStatistics.getInstance().getMaxWithoutConnectionTime().get(test.getKey()));
		}

		System.out.println("Average of without connection: "+MyStatistics.getInstance().getAverageWithoutConnection());

		System.out.println("***Last time without Vm***");

		for(Entry<Integer, Double> test :MyStatistics.getInstance().getWithoutVmTime().entrySet()){
			System.out.println("SmartThing"+test.getKey()+": "+MyStatistics.getInstance().getWithoutVmTime().get(test.getKey())+" - Max: "+MyStatistics.getInstance().getMaxWithoutVmTime().get(test.getKey()));
		}

		System.out.println("Average of without Vm: "+MyStatistics.getInstance().getAverageWithoutVmTime());

		System.out.println("===Last delay after connection===");
		for(Entry<Integer, Double> test : MyStatistics.getInstance().getDelayAfterNewConnection().entrySet()){
			System.out.println("SmartThing"+test.getKey()+": "+MyStatistics.getInstance().getDelayAfterNewConnection().get(test.getKey())+" - Max: "+MyStatistics.getInstance().getMaxDelayAfterNewConnection().get(test.getKey()));
		}
		System.out.println("Average of delay after new Connection: "+MyStatistics.getInstance().getAverageDelayAfterNewConnection());


		System.out.println("---Average of Time of Migrations---");
		for(Entry<Integer, Double> test : MyStatistics.getInstance().getMigrationTime().entrySet()){
			System.out.println("SmartThing"+test.getKey()+": "+MyStatistics.getInstance().getMigrationTime().get(test.getKey())+" - Max: "+MyStatistics.getInstance().getMaxMigrationTime().get(test.getKey()));
		}
		System.out.println("Average of Time of Migrations: "+MyStatistics.getInstance().getAverageMigrationTime());
		System.out.println("Tuple lost: "+(((double)MyStatistics.getInstance().getMyCountLostTuple()/MyStatistics.getInstance().getMyCountTotalTuple()))*100+"%");
		System.out.println("Tuple lost: "+MyStatistics.getInstance().getMyCountLostTuple());
		System.out.println("Total tuple: "+ MyStatistics.getInstance().getMyCountTotalTuple());

	}

	public void submitApplication(Application application, int delay){
		FogUtils.appIdToGeoCoverageMap.put(application.getAppId(), application.getGeoCoverage());
		getApplications().put(application.getAppId(), application);
		getAppLaunchDelays().put(application.getAppId(), delay);
		for(MobileDevice st: getSmartThings()){
			for(Sensor s : st.getSensors()){
				if(s.getAppId().equals(application.getAppId()))
					s.setApp(application);
			}
			for(Actuator a : st.getActuators()){
				if(a.getAppId().equals(application.getAppId()))
					a.setApp(application);
			}
		}
		for(AppEdge edge : application.getEdges()){
			if(edge.getEdgeType() == AppEdge.ACTUATOR){
				String moduleName = edge.getSource();
				for(MobileDevice st: getSmartThings()){		
					for(Actuator actuator : st.getActuators()){
						if(actuator.getActuatorType().equalsIgnoreCase(edge.getDestination()))
							application.getModuleByName(moduleName).subscribeActuator(actuator.getId(), edge.getTupleType());
					}
				}
			}
		}

	}
	public void submitApplicationMigration(MobileDevice smartThing, Application application, int delay){
		FogUtils.appIdToGeoCoverageMap.put(application.getAppId(), application.getGeoCoverage());
		getApplications().put(application.getAppId(), application);
		getAppLaunchDelays().put(application.getAppId(), delay);

		for(AppEdge edge : application.getEdges()){
			if(edge.getEdgeType() == AppEdge.ACTUATOR){
				String moduleName = edge.getSource();
				for(MobileDevice st: getSmartThings()){		
					for(Actuator actuator : st.getActuators()){
						if(actuator.getActuatorType().equalsIgnoreCase(edge.getDestination()))
							application.getModuleByName(moduleName).subscribeActuator(actuator.getId(), edge.getTupleType());
					}
				}
			}
		}

	}

	public Map<String, Application> getApplications() {
		return applications;
	}

	public void setApplications(Map<String, Application> applications) {
		this.applications = applications;
	}

	public Map<String, Integer> getAppLaunchDelays() {
		return appLaunchDelays;
	}

	public void setAppLaunchDelays(Map<String, Integer> appLaunchDelays) {
		this.appLaunchDelays = appLaunchDelays;
	}

	public ModuleMapping getModuleMapping() {
		return moduleMapping;
	}

	public void setModuleMapping(ModuleMapping moduleMapping) {
		this.moduleMapping = moduleMapping;
	}

	public Map<Integer, Double> getGlobalCurrentCpuLoad() {
		return globalCurrentCpuLoad;
	}

	public void setGlobalCurrentCpuLoad(Map<Integer, Double> globalCurrentCpuLoad) {
		this.globalCurrentCpuLoad = globalCurrentCpuLoad;
	}
	public void setGlobalCPULoad(Map<Integer, Double> currentCpuLoad) {
		for(FogDevice device : getServerCloudlets()){
			this.globalCurrentCpuLoad.put(device.getId(), currentCpuLoad.get(device.getId()));
		}
	}

	public static int getMigPointPolicy() {
		return migPointPolicy;
	}
	public static void setMigPointPolicy(int migPointPolicy) {
		MobileController.migPointPolicy = migPointPolicy;
	}
	public static int getMigStrategyPolicy() {
		return migStrategyPolicy;
	}
	public static void setMigStrategyPolicy(int migStrategyPolicy) {
		MobileController.migStrategyPolicy = migStrategyPolicy;
	}
	public static int getStepPolicy() {
		return stepPolicy;
	}
	public static void setStepPolicy(int stepPolicy) {
		MobileController.stepPolicy = stepPolicy;
	}
	public static Coordinate getCoordDevices() {
		return coordDevices;
	}
	public static void setCoordDevices(Coordinate coordDevices) {
		MobileController.coordDevices = coordDevices;
	}
	public List<FogBroker> getBrokerList() {
		return brokerList;
	}
	public void setBrokerList(List<FogBroker> brokerList) {
		this.brokerList = brokerList;
	}
	public static int getSeed() {
		return seed;
	}
	public static void setSeed(int seed) {
		MobileController.seed = seed;
	}
	public static List<FogDevice> getServerCloudlets() {
		return serverCloudlets;
	}
	public static void setServerCloudlets(List<FogDevice> serverCloudlets) {
		MobileController.serverCloudlets = serverCloudlets;
	}
	public static List<MobileDevice> getSmartThings() {
		return smartThings;
	}
	public static void setSmartThings(List<MobileDevice> smartThings) {
		MobileController.smartThings = smartThings;
	}
	public static List<ApDevice> getApDevices() {
		return apDevices;
	}
	public static void setApDevices(List<ApDevice> apDevices) {
		MobileController.apDevices = apDevices;
	}
	public static Random getRand() {
		return rand;
	}
	public static void setRand(Random rand) {
		MobileController.rand = rand;
	}
	public static boolean isMigrationAble() {
		return migrationAble;
	}
	public static void setMigrationAble(boolean migrationAble) {
		MobileController.migrationAble = migrationAble;
	}

}
