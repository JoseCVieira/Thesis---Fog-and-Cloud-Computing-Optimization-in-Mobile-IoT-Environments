package org.fog.entities;

import java.util.HashMap;
import java.util.Map;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.UtilizationModel;
import org.fog.vmmigration.MyStatistics;

public class Tuple extends Cloudlet{

	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int ACTUATOR = 3;
	
	private String appId;
	
	private String tupleType;
	private String destModuleName;
	private String srcModuleName;
	private int actualTupleId;
	private int direction;
	private int actuatorId;
	private int sourceDeviceId;
	private double initialTime;
	private double finalTime;
	private int myTupleId;
	
	/**
	 * Map to keep track of which module instances has a tuple traversed.
	 * 
	 * Map from moduleName to vmId of a module instance
	 */
	private Map<String, Integer> moduleCopyMap;
	
	public Tuple(String appId, int cloudletId, int direction, long cloudletLength, int pesNumber,
			long cloudletFileSize, long cloudletOutputSize,
			UtilizationModel utilizationModelCpu,
			UtilizationModel utilizationModelRam,
			UtilizationModel utilizationModelBw) {
		super(cloudletId, cloudletLength, pesNumber, cloudletFileSize,
				cloudletOutputSize, utilizationModelCpu, utilizationModelRam,
				utilizationModelBw);
		setAppId(appId);
		setDirection(direction);
		setSourceDeviceId(-1);
		setModuleCopyMap(new HashMap<String, Integer>());
		setInitialTime(-1);
		setFinalTime(-1);
		setMyTupleId(MyStatistics.getInstance().getMyCountTuple());
	}

	public int getActualTupleId() {
		return actualTupleId;
	}

	public void setActualTupleId(int actualTupleId) {
		this.actualTupleId = actualTupleId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTupleType() {
		return tupleType;
	}

	public void setTupleType(String tupleType) {
		this.tupleType = tupleType;
	}

	public String getDestModuleName() {
		return destModuleName;
	}

	public void setDestModuleName(String destModuleName) {
		this.destModuleName = destModuleName;
	}

	public String getSrcModuleName() {
		return srcModuleName;
	}

	public void setSrcModuleName(String srcModuleName) {
		this.srcModuleName = srcModuleName;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getActuatorId() {
		return actuatorId;
	}

	public void setActuatorId(int actuatorId) {
		this.actuatorId = actuatorId;
	}

	public int getSourceDeviceId() {
		return sourceDeviceId;
	}

	public void setSourceDeviceId(int sourceDeviceId) {
		this.sourceDeviceId = sourceDeviceId;
	}

	public Map<String, Integer> getModuleCopyMap() {
		return moduleCopyMap;
	}

	public void setModuleCopyMap(Map<String, Integer> moduleCopyMap) {
		this.moduleCopyMap = moduleCopyMap;
	}

	public double getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(double initialTime) {
		this.initialTime = initialTime;
	}

	public double getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(double finalTime) {
		this.finalTime = finalTime;
	}

	public int getMyTupleId() {
		return myTupleId;
	}

	public void setMyTupleId(int myTupleId) {
		this.myTupleId = myTupleId;
	}

}
