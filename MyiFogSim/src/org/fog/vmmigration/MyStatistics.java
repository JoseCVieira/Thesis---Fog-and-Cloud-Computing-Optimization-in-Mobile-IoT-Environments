package org.fog.vmmigration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.fog.entities.Tuple;
import org.fog.utils.TimeKeeper;
import org.fog.vmmobile.LogMobile;
/**
 * @author Marcio Moraes Lopes
 */

public class MyStatistics {
	private static MyStatistics instance;

	private double totalMigTimes;
	private double timeOutApplication;	
	private int totalMigrations;
	
	private long myCountLostTuple;
	private long myCountTotalTuple;
	
	private String toPrint;
	private Map<Integer,Integer> myCount;

	private FileWriter fileLatency;
	private BufferedWriter printFile;
	private Map<Integer, File> fileMap;
	private int seed;
	private Map<Integer, Double> tupleLatency;
	private int  myCountTuple;
	private int myCountLowestLatency;
	private int totalHandoff;

	private Map<Integer, Double> withoutConnectionTime;
	private Map<Integer, Double> maxWithoutConnectionTime;
	private double averageWithoutConnection;
	private int myCountWithoutConnection;
	private Map<Integer,Double> initialTimeWithoutConnection;

	private Map<Integer,Double> initialTimeDelayAfterNewConnection;
	private Map<Integer, Double> DelayAfterNewConnection;
	private Map<Integer, Double> maxDelayAfterNewConnection;
	private double averageDelayAfterNewConnection;
	private int myCountDelayAfterNewConnection; 

	private Map<Integer, Double> withoutVmTime;
	private Map<Integer, Double> maxWithoutVmTime;
	private double averageWithoutVmTime;
	private int myCountWithoutVmTime;
	private Map<Integer,Double> initialWithoutVmTime;

	private Map<Integer, Double> migrationTime;
	private Map<Integer, Double> maxMigrationTime;
	private double averageMigrationTime;
	private int myCountMigrationTime;

	private Map<Integer, Double> powerHistory;
	private Map<Integer, Double> energyHistory;

	public MyStatistics() {
		setTotalMigTimes(0);
		setTimeOutApplication(0);
		setTotalMigrations(0);
		setMyCountWithoutConnection(0);
		setMyCountWithoutVmTime(0);
		setMyCountDelayAfterNewConnection(0);
		setMyCountMigrationTime(0);
		setMyCountLowestLatency(0);
		setMyCount(new HashMap<Integer, Integer>());
		setMyCountTotalTuple(0);
		setMyCountLostTuple(0);

		setTupleLatency(new HashMap<Integer, Double>());
		this.fileMap=new HashMap<Integer,File>();

		setWithoutConnectionTime(new HashMap<Integer, Double>());
		setWithoutVmTime(new HashMap<Integer, Double>());
		setDelayAfterNewConnection(new HashMap<Integer, Double>());
		setMigrationTime(new HashMap<Integer, Double>());

		setInitialTimeWithoutConnection(new HashMap<Integer, Double>());
		setInitialWithoutVmTime(new HashMap<Integer, Double>());
		setInitialTimeDelayAfterNewConnection(new HashMap<Integer, Double>());

		setMaxWithoutConnectionTime(new HashMap<Integer, Double>());
		setMaxWithoutVmTime(new HashMap<Integer, Double>());
		setMaxDelayAfterNewConnection(new HashMap<Integer, Double>());
		setMaxMigrationTime(new HashMap<Integer, Double>());;

		setPowerHistory(new HashMap<Integer, Double>());
		setEnergyHistory(new HashMap<Integer, Double>());

	}
	public static MyStatistics getInstance(){
		if(instance == null)
			instance = new MyStatistics();
		return instance;
	}
	public void countMigration(){
		setTotalMigrations(1);
	}
	public void putLatencyFileValue(double latency, double time, String appId, int smartThingMyId, String serverCloudletName, String tupleType) {
		try {
			setFileLatency(new FileWriter(getFileMap().get(smartThingMyId),true));
			setPrintFile(new BufferedWriter(getFileLatency()));
			int i = getMyCount().get(smartThingMyId);
			i++;
			getMyCount().put(smartThingMyId, i);
			getPrintFile().write(Integer.toString(i)+" - "+Double.toString(time)+" - "+Double.toString(latency)+" - "+appId+ " - smartThingMyId: "+smartThingMyId+" - "+serverCloudletName+" - TupleType: - "+ tupleType);
			getPrintFile().newLine();
			getPrintFile().close();
			getFileLatency().close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void putLantencyFileName(String name, int smartThingMyId ){
		try {
			setFileLatency(new FileWriter(getFileMap().get(smartThingMyId),true));
			setPrintFile(new BufferedWriter(getFileLatency()));
			getPrintFile().write(name);
			getPrintFile().newLine();
			getPrintFile().close();
			getFileLatency().close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startWithoutConnetion(int id, double clock){
		getInitialTimeWithoutConnection().put(id, clock);
	}

	public void finalWithoutConnection(int id, double clock){
		if(getInitialTimeWithoutConnection().get(id)!=null){
			double delay = clock - getInitialTimeWithoutConnection().get(id);
			double correntAverage = getAverageWithoutConnection();
			double correntCount = getMyCountWithoutConnection() ;
			getWithoutConnectionTime().put(id, delay);
			setAverageWithoutConnection((correntAverage*correntCount+delay)/(correntCount+1));
			if(!getMaxWithoutConnectionTime().containsKey(id)){
				getMaxWithoutConnectionTime().put(id, 0.0);
			}
			if(delay>getMaxWithoutConnectionTime().get(id)){
				getMaxWithoutConnectionTime().put(id,delay);
			}
			getInitialTimeWithoutConnection().remove(id);
		}
	}

	public void startWithoutVmTime(int id, double clock){
		getInitialWithoutVmTime().put(id, clock);
	}

	public void finalWithoutVmTime(int id, double clock){
		if(getInitialWithoutVmTime().get(id)!=null){
			double delay = clock - getInitialWithoutVmTime().get(id);
			double correntAverage = getAverageWithoutVmTime();
			double correntCount = getMyCountWithoutVmTime() ;
			LogMobile.debug("MyStatistics.java", "SmartThing"+id+" - WithoutVm: "+delay);
			getWithoutVmTime().put(id, delay);
			setAverageWithoutVmTime((correntAverage*correntCount+delay)/(correntCount+1));
			if(!getMaxWithoutVmTime().containsKey(id)){
				getMaxWithoutVmTime().put(id, 0.0);
			}
			if(delay>getMaxWithoutVmTime().get(id)){
				getMaxWithoutVmTime().put(id,delay);
			}
			getInitialWithoutVmTime().remove(id);
		}
	}


	public void startDelayAfterNewConnection(int id, double clock){
		getInitialTimeDelayAfterNewConnection().put(id, clock);	
	}
	public void finalDelayAfterNewConnection(int id, double clock){//T8
		if(getInitialTimeDelayAfterNewConnection().get(id)!=null){
			double delay = clock - getInitialTimeDelayAfterNewConnection().get(id);
			LogMobile.debug("MyStatistics.java", "SmartThing"+id+" - DelayAfterNewConnection: "+delay);
			double correntAverage = getAverageDelayAfterNewConnection();
			double correntCount = getMyCountDelayAfterNewConnection() ;
			getDelayAfterNewConnection().put(id, delay);
			setAverageDelayAfterNewConnection((correntAverage*correntCount+delay)/(correntCount+1));
			if(!getMaxDelayAfterNewConnection().containsKey(id)){
				getMaxDelayAfterNewConnection().put(id, 0.0);
			}
			if(delay>getMaxDelayAfterNewConnection().get(id)){
				getMaxDelayAfterNewConnection().put(id,delay);
			}
			getInitialTimeDelayAfterNewConnection().remove(id);
		}
	}
	public void historyMigrationTime(int id, double time){
		double correntAverage = getAverageMigrationTime();
		double correntCount = getMyCountMigrationTime();
		getMigrationTime().put(id, time);
		setAverageMigrationTime((correntAverage*correntCount+time)/(correntCount+1));
		if(!getMaxMigrationTime().containsKey(id)){
			getMaxMigrationTime().put(id, 0.0);
		}
		if(time> getMaxMigrationTime().get(id)){
			getMaxMigrationTime().put(id,time);
		}
	}

	public void printLatencies(double latency, int user){

		try {
			
			
			File file1 = null;
			File file2 = null;
			File file3 = null;
			File file4 = null;
			File file5 = null;
			
			File file6 = null;
			File file7 = null;
			File file8 = null;
			File file9 = null;
			File file10 = null;
			
			
			String name1="./averages/0_latency_"+getToPrint();
			String name2="./averages/1_latency_"+getToPrint();
			String name3="./averages/2_latency_"+getToPrint();
			String name4="./averages/3_latency_"+getToPrint();
			String name5="./averages/4_latency_"+getToPrint();
			
			String name6="./averages/5_latency_"+getToPrint();
			String name7="./averages/6_latency_"+getToPrint();
			String name8="./averages/7_latency_"+getToPrint();
			String name9="./averages/8_latency_"+getToPrint();
			String name10="./averages/9_latency_"+getToPrint();
			

				file1 = new File(name1); 
				file2 = new File(name2); 
				file3 = new File(name3); 
				file4 = new File(name4); 
				file5 = new File(name5);
			
				file6 = new File(name6); 
				file7 = new File(name7); 
				file8 = new File(name8); 
				file9 = new File(name9); 
				file10 = new File(name10);
				

				if(!file1.exists()){
					file1.createNewFile();
				}
				if(!file2.exists()){
					file2.createNewFile();
				}
				if(!file3.exists()){
					file3.createNewFile();
				}
				if(!file4.exists()){
					file4.createNewFile();
				}
				
				if(!file5.exists()){
					file5.createNewFile();
				}

				if(!file6.exists()){
					file6.createNewFile();
				}
				if(!file7.exists()){
					file7.createNewFile();
				}
				if(!file8.exists()){
					file8.createNewFile();
				}
				if(!file9.exists()){
					file9.createNewFile();
				}		
				if(!file10.exists()){
					file10.createNewFile();
				}

				
			FileWriter fileWriter1 = new FileWriter(name1,true);
			FileWriter fileWriter2 = new FileWriter(name2,true);
			FileWriter fileWriter3 = new FileWriter(name3,true);
			FileWriter fileWriter4 = new FileWriter(name4,true);
			FileWriter fileWriter5 = new FileWriter(name5,true);
			
			FileWriter fileWriter6 = new FileWriter(name6,true);
			FileWriter fileWriter7 = new FileWriter(name7,true);
			FileWriter fileWriter8 = new FileWriter(name8,true);
			FileWriter fileWriter9 = new FileWriter(name9,true);
			FileWriter fileWriter10 = new FileWriter(name10,true);
		
		
			BufferedWriter buffer1 = new BufferedWriter(fileWriter1);
			BufferedWriter buffer2 = new BufferedWriter(fileWriter2);
			BufferedWriter buffer3 = new BufferedWriter(fileWriter3);
			BufferedWriter buffer4 = new BufferedWriter(fileWriter4);
			BufferedWriter buffer5 = new BufferedWriter(fileWriter5);
			
			BufferedWriter buffer6 = new BufferedWriter(fileWriter6);
			BufferedWriter buffer7 = new BufferedWriter(fileWriter7);
			BufferedWriter buffer8 = new BufferedWriter(fileWriter8);
			BufferedWriter buffer9 = new BufferedWriter(fileWriter9);
			BufferedWriter buffer10 = new BufferedWriter(fileWriter10);
			
			if(user==1){
				buffer1.write(Double.toString(latency)+" "+Integer.toString(getSeed()));
				buffer1.newLine();
				buffer1.close();
				fileWriter1.close();

			}
			else if (user==2){
				buffer2.write(Double.toString(latency)+" "+Integer.toString(getSeed()));
				buffer2.newLine();
				buffer2.close();
				fileWriter2.close();
			}

			else if(user==3){
				buffer3.write(Double.toString(latency)+" "+Integer.toString(getSeed()));
				buffer3.newLine();
				buffer3.close();
				fileWriter3.close();
			}

			else if(user==4){
				buffer4.write(Double.toString(latency)+" "+Integer.toString(getSeed()));
				buffer4.newLine();
				buffer4.close();
				fileWriter4.close();
			}

			else if(user==5){
				buffer5.write(Double.toString(latency)+" "+Integer.toString(getSeed()));
				buffer5.newLine();
				buffer5.close();
				fileWriter5.close();
			}
			else if(user==6){
				buffer6.write(Double.toString(latency)+" "+Integer.toString(getSeed()));
				buffer6.newLine();
				buffer6.close();
				fileWriter6.close();
			}
			else if(user==7){
				buffer7.write(Double.toString(latency)+" "+Integer.toString(getSeed()));
				buffer7.newLine();
				buffer7.close();
				fileWriter7.close();
			}
			else if(user==8){
				buffer8.write(Double.toString(latency)+" "+Integer.toString(getSeed()));
				buffer8.newLine();
				buffer8.close();
				fileWriter8.close();
			}
			else if(user==9){
				buffer9.write(Double.toString(latency)+" "+Integer.toString(getSeed()));
				buffer9.newLine();
				buffer9.close();
				fileWriter9.close();
			}
			else if(user==10){
				buffer10.write(Double.toString(latency)+" "+Integer.toString(getSeed()));
				buffer10.newLine();
				buffer10.close();
				fileWriter10.close();
			}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	public void printResults() {
		try {

			File file1 = null;
			File file2 = null;
			File file3 = null;
			File file4 = null;
			File file5 = null;
			
			String name1="./averages/withoutConnection_"+getToPrint();
			String name2="./averages/withoutVM_"+getToPrint();
			String name3="./averages/delayAfterConnection_"+getToPrint();
			String name4="./averages/timeOfMigration_"+getToPrint();
			String name5="./averages/all_"+getToPrint();
			

				file1 = new File(name1); 
				file2 = new File(name2); 
				file3 = new File(name3); 
				file4 = new File(name4); 
				file5 = new File(name5);

				if(!file1.exists()){
					file1.createNewFile();
				}
				if(!file2.exists()){
					file2.createNewFile();
				}
				if(!file3.exists()){
					file3.createNewFile();
				}
				if(!file4.exists()){
					file4.createNewFile();
				}
				
				if(!file5.exists()){
					file5.createNewFile();
				}
				

			FileWriter fileWriter1 = new FileWriter(name1,true);
			FileWriter fileWriter2 = new FileWriter(name2,true);
			FileWriter fileWriter3 = new FileWriter(name3,true);
			FileWriter fileWriter4 = new FileWriter(name4,true);
			FileWriter fileWriter5 = new FileWriter(name5,true);
		
			BufferedWriter buffer1 = new BufferedWriter(fileWriter1);
			BufferedWriter buffer2 = new BufferedWriter(fileWriter2);
			BufferedWriter buffer3 = new BufferedWriter(fileWriter3);
			BufferedWriter buffer4 = new BufferedWriter(fileWriter4);
			BufferedWriter buffer5 = new BufferedWriter(fileWriter5);

			
			buffer1.write(Double.toString(getAverageWithoutConnection())+" "+Integer.toString(getSeed()));
			buffer2.write(Double.toString(getAverageWithoutVmTime())+" "+Integer.toString(getSeed()));
			buffer3.write(Double.toString(getAverageDelayAfterNewConnection())+" "+Integer.toString(getSeed()));
			buffer4.write(Double.toString(getAverageMigrationTime())+" "+Integer.toString(getSeed()));
			buffer5.write(Double.toString(getAverageWithoutConnection())+" "+
						  Double.toString(getAverageWithoutVmTime())+" "+
					      Double.toString(getAverageDelayAfterNewConnection())+" "+
					      Double.toString(getAverageMigrationTime())+" "+
					      Integer.toString(getTotalMigrations()) +" "+
					      Integer.toString(getTotalHandoff())+" "+
					      Integer.toString(getSeed()));
		
			
			buffer1.newLine();
			buffer2.newLine();
			buffer3.newLine();
			buffer4.newLine();
			buffer5.newLine();

				
			buffer1.close();
			buffer2.close();
			buffer3.close();
			buffer4.close();
			buffer5.close();

			
			
			fileWriter1.close();
			fileWriter2.close();
			fileWriter3.close();
			fileWriter4.close();
			fileWriter5.close();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	public double getTotalMigTimes() {
		return totalMigTimes;
	}

	public void setTotalMigTimes(double totalMigTimes) {
		this.totalMigTimes += totalMigTimes;
	}

	public double getTimeOutApplication() {
		return timeOutApplication;
	}

	public void setTimeOutApplication(double timeOutApplication) {
		this.timeOutApplication = timeOutApplication;
	}

	public int getTotalMigrations() {
		return totalMigrations;
	}

	public void setTotalMigrations(int totalMigrations) {
		this.totalMigrations += totalMigrations;
	}

	public static void setInstance(MyStatistics instance) {
		MyStatistics.instance = instance;
	}
	public FileWriter getFileLatency() {
		return fileLatency;
	}
	public void setFileLatency(FileWriter fileLatency) {
		this.fileLatency = fileLatency;
	}


	public void setPrintFile(BufferedWriter printFile) {
		this.printFile = printFile;
	}
	public BufferedWriter getPrintFile() {
		return printFile;
	}

	public Map<Integer, File> getFileMap() {
		return fileMap;
	}
	public void setFileMap(String name, int id) {
		File file = new File(name);
		this.fileMap.put(id, file);
		getFileMap().get(id).delete();
		try {

			getFileMap().get(id).createNewFile();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int getSeed() {
		return seed;
	}
	public void setSeed(int seed) {
		this.seed = seed;
	}
	public Map<Integer, Double> getTupleLatency() {
		return tupleLatency;
	}
	public void setTupleLatency(Map<Integer, Double> tupleLatency) {
		this.tupleLatency = tupleLatency;
	}
	public int getMyCountTuple() {
		return ++myCountTuple;
	}
	public void setMyCountTuple(int myCountTuple) {
		this.myCountTuple = myCountTuple;
	}
	public Map<Integer, Double> getWithoutConnectionTime() {
		return withoutConnectionTime;
	}
	public void setWithoutConnectionTime(Map<Integer, Double> withoutConnectionTime) {
		this.withoutConnectionTime = withoutConnectionTime;
	}
	public Map<Integer, Double> getInitialTimeWithoutConnection() {
		return initialTimeWithoutConnection;
	}
	public void setInitialTimeWithoutConnection(Map<Integer, Double> initialTimeWithoutConnection) {
		this.initialTimeWithoutConnection = initialTimeWithoutConnection;
	}
	public double getAverageWithoutConnection() {
		return averageWithoutConnection;
	}
	public void setAverageWithoutConnection(double averageWithoutConnection) {
		this.averageWithoutConnection = averageWithoutConnection;
	}
	public int getMyCountWithoutConnection() {
		return myCountWithoutConnection++;
	}
	public void setMyCountWithoutConnection(int myCountWithoutConnection) {
		this.myCountWithoutConnection = myCountWithoutConnection;
	}
	public Map<Integer, Double> getPowerHistory() {
		return powerHistory;
	}
	public void setPowerHistory(Map<Integer, Double> powerHistory) {
		this.powerHistory = powerHistory;
	}
	public Map<Integer, Double> getEnergyHistory() {
		return energyHistory;
	}
	public void setEnergyHistory(Map<Integer, Double> energyHistory) {
		this.energyHistory = energyHistory;
	}
	public Map<Integer, Double> getMaxWithoutConnectionTime() {
		return maxWithoutConnectionTime;
	}
	public void setMaxWithoutConnectionTime(
			Map<Integer, Double> maxWithoutConnectionTime) {
		this.maxWithoutConnectionTime = maxWithoutConnectionTime;
	}
	public Map<Integer, Double> getInitialTimeDelayAfterNewConnection() {
		return initialTimeDelayAfterNewConnection;
	}
	public void setInitialTimeDelayAfterNewConnection(
			Map<Integer, Double> initialTimeDelayAfterNewConnection) {
		this.initialTimeDelayAfterNewConnection = initialTimeDelayAfterNewConnection;
	}
	public Map<Integer, Double> getDelayAfterNewConnection() {
		return DelayAfterNewConnection;
	}
	public void setDelayAfterNewConnection(
			Map<Integer, Double> delayAfterNewConnection) {
		DelayAfterNewConnection = delayAfterNewConnection;
	}
	public Map<Integer, Double> getMaxDelayAfterNewConnection() {
		return maxDelayAfterNewConnection;
	}
	public void setMaxDelayAfterNewConnection(
			Map<Integer, Double> maxDelayAfterNewConnection) {
		this.maxDelayAfterNewConnection = maxDelayAfterNewConnection;
	}
	public double getAverageDelayAfterNewConnection() {
		return averageDelayAfterNewConnection;
	}
	public void setAverageDelayAfterNewConnection(
			double averageDelayAfterNewConnection) {
		this.averageDelayAfterNewConnection = averageDelayAfterNewConnection;
	}
	public int getMyCountDelayAfterNewConnection() {
		return myCountDelayAfterNewConnection++;
	}
	public void setMyCountDelayAfterNewConnection(int myCountDelayAfterNewConnection) {
		this.myCountDelayAfterNewConnection = myCountDelayAfterNewConnection;
	}
	public Map<Integer, Double> getWithoutVmTime() {
		return withoutVmTime;
	}
	public void setWithoutVmTime(Map<Integer, Double> withoutVmTime) {
		this.withoutVmTime = withoutVmTime;
	}
	public Map<Integer, Double> getMaxWithoutVmTime() {
		return maxWithoutVmTime;
	}
	public void setMaxWithoutVmTime(Map<Integer, Double> maxWithoutVmTime) {
		this.maxWithoutVmTime = maxWithoutVmTime;
	}
	public double getAverageWithoutVmTime() {
		return averageWithoutVmTime;
	}
	public void setAverageWithoutVmTime(double averageWithoutVmTime) {
		this.averageWithoutVmTime = averageWithoutVmTime;
	}
	public int getMyCountWithoutVmTime() {
		return myCountWithoutVmTime++;
	}
	public void setMyCountWithoutVmTime(int myCountWithoutVmTime) {
		this.myCountWithoutVmTime = myCountWithoutVmTime;
	}
	public Map<Integer, Double> getInitialWithoutVmTime() {
		return initialWithoutVmTime;
	}
	public void setInitialWithoutVmTime(Map<Integer, Double> initialWithoutVmTime) {
		this.initialWithoutVmTime = initialWithoutVmTime;
	}
	public Map<Integer, Double> getMigrationTime() {
		return migrationTime;
	}
	public void setMigrationTime(Map<Integer, Double> migrationTime) {
		this.migrationTime = migrationTime;
	}
	public Map<Integer, Double> getMaxMigrationTime() {
		return maxMigrationTime;
	}
	public void setMaxMigrationTime(Map<Integer, Double> maxMigrationTime) {
		this.maxMigrationTime = maxMigrationTime;
	}
	public double getAverageMigrationTime() {
		return averageMigrationTime;
	}
	public void setAverageMigrationTime(double averageMigrationTime) {
		this.averageMigrationTime = averageMigrationTime;
	}
	public int getMyCountMigrationTime() {
		return myCountMigrationTime++;
	}
	public void setMyCountMigrationTime(int myCountMigrationTime) {
		this.myCountMigrationTime = myCountMigrationTime;
	}
	public String getToPrint() {
		return toPrint;
	}
	public void setToPrint(String toPrint) {
		this.toPrint = toPrint;
	}
	public int getMyCountLowestLatency() {
		return myCountLowestLatency;
	}
	public void setMyCountLowestLatency(int myCountLowestLatency) {
		this.myCountLowestLatency += myCountLowestLatency;
	}
	public int getTotalHandoff() {
		return totalHandoff;
	}
	public void setTotalHandoff(int totalHandoff) {
		this.totalHandoff += totalHandoff;
	}

	public void setMyCount(Map<Integer, Integer> myCount) {
		this.myCount = myCount;
	}
	public Map<Integer, Integer> getMyCount() {
		return myCount;
	}
	public long getMyCountLostTuple() {
		return myCountLostTuple;
	}
	public void setMyCountLostTuple(long myCountLostTuple) {
		this.myCountLostTuple += myCountLostTuple;
	}
	public long getMyCountTotalTuple() {
		return myCountTotalTuple;
	}
	public void setMyCountTotalTuple(long myCountTotalTuple) {
		this.myCountTotalTuple += myCountTotalTuple;
	}



}
