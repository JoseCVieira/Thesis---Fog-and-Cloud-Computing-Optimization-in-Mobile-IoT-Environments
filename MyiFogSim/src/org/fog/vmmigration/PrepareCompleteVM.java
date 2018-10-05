package org.fog.vmmigration;

import org.cloudbus.cloudsim.NetworkTopology;
import org.fog.entities.FogDevice;
import org.fog.entities.MobileDevice;
import org.fog.utils.NetworkUsageMonitor;
/**
 * @author Marcio Moraes Lopes
 */
public class PrepareCompleteVM implements BeforeMigration {
	private double timeToOpenConnection = 0.0;
	@Override
	public double dataprepare(MobileDevice smartThing) {
		// TODO Auto-generated method stub
		FogDevice scSource = smartThing.getSourceAp().getServerCloudlet();
		if(openConnection(scSource, smartThing.getDestinationServerCloudlet())){
			double delayProcess = scSource.getCharacteristics().
					getCpuTime((smartThing.getVmMobileDevice().getSize()*1024*1024*8), 0.0)
					+getTimeToOpenConnection();	
			return  delayProcess;
		}
		else{
			return -1;
		}
	}

	@Override
	public boolean openConnection(FogDevice sourceServerCloudlet,
			FogDevice destinationServerCloudlet) {
		// TODO Auto-generated method stub
		for(int i = 0; i<3 ; i++){//It'll try three times to opening connection
			if(tryOpenConnection()){// It should be a method that really open the connection
				setTimeToOpenConnection(getTimeToOpenConnection()+10.0);
				double delay = NetworkTopology.getDelay(sourceServerCloudlet.getId(), destinationServerCloudlet.getId());
				
				return true;
			}
			else{
				//maybe to exchange anything (e.g Links)
				setTimeToOpenConnection(getTimeToOpenConnection()+30.0);
			}
		}
		return false;
	}
@Override
	public boolean tryOpenConnection() {
		// TODO Auto-generated method stub
		return true;
	}

	public double getTimeToOpenConnection() {
		return timeToOpenConnection;
	}

	public void setTimeToOpenConnection(double timeToOpenConnection) {
		this.timeToOpenConnection = timeToOpenConnection;
	}

	

}
