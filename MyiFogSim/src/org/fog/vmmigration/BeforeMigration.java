package org.fog.vmmigration;

import org.fog.entities.FogDevice;
import org.fog.entities.MobileDevice;
/**
 * @author Marcio Moraes Lopes
 */

public interface BeforeMigration {
	public double dataprepare(MobileDevice smartThing);
	public boolean openConnection(FogDevice sourceServerCloudlet, FogDevice destinationServerCloudlet);
	public boolean tryOpenConnection();
	
}
