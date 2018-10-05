package org.fog.vmmigration;

import org.fog.entities.MobileDevice;
/**
 * @author Marcio Moraes Lopes
 */

public interface DecisionMigration {
	
	public boolean shouldMigrate(MobileDevice smartThing);
}
