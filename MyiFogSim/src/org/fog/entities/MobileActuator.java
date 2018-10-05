package org.fog.entities;

import org.fog.utils.GeoLocation;
/**
* @author Marcio Moraes Lopes
*/
public class MobileActuator extends Actuator{

	public MobileActuator(String name, int userId, String appId,
			int gatewayDeviceId, double latency, GeoLocation geoLocation,
			String actuatorType, String srcModuleName) {
		super(name, userId, appId, gatewayDeviceId, latency, geoLocation, actuatorType,
				srcModuleName);
		// TODO Auto-generated constructor stub
	}

	public MobileActuator(String name, int userId, String appId,
			String actuatorType) {
		super(name, userId, appId, actuatorType);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
