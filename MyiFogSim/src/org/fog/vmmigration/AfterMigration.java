package org.fog.vmmigration;

import org.fog.entities.FogDevice;
/**
 * @author Marcio Moraes Lopes
 */

public interface AfterMigration {

	public void closeConnection(FogDevice sourceServerCloudlet, FogDevice destinationServerCloudlet);
	
}
