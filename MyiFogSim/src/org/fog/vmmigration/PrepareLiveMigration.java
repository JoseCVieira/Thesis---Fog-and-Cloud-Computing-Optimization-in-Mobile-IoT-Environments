package org.fog.vmmigration;

import org.fog.entities.FogDevice;
import org.fog.entities.MobileDevice;
/**
 * @author Marcio Moraes Lopes
 */
public class PrepareLiveMigration implements BeforeMigration {
	private double timeToOpenConnection = 0.0;
	@Override
	public double dataprepare(MobileDevice smartThing) {
		// TODO Auto-generated method stub
//		delayProcess = getCharacteristics().getCpuTime((smartThing.getVmMobileDevice().getSize()*1024*1024*8)*0.7, 0.0);//boa metrica//    MaxAndMin.DELAY_PROCESS;//Milliseconds 
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
		for(int i = 0; i<5 ; i++){//It'll try three times to opening connection
			if(tryOpenConnection()){// It should be a method that really open the connection
				setTimeToOpenConnection(getTimeToOpenConnection()+10.0);
				return true;
			}
			else{
				//maybe to exchange anything (e.g Links)
				setTimeToOpenConnection(getTimeToOpenConnection()+30.0);
			}
		}
		return false;
	}
public void jaque(){
	
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
