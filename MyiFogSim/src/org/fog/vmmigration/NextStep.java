package org.fog.vmmigration;

import java.util.List;
import java.util.Random;

import org.cloudbus.cloudsim.core.CloudSim;
import org.fog.entities.*;
import org.fog.localization.Coordinate;
import org.fog.vmmobile.AppExemplo;
import org.fog.vmmobile.LogMobile;
import org.fog.vmmobile.constants.Directions;
import org.fog.vmmobile.constants.MaxAndMin;
import org.fog.vmmobile.constants.Policies;
/**
 * @author Marcio Moraes Lopes
 */
public class NextStep {

	public static  void nextStep(List<FogDevice> serverCloudlets, List<ApDevice> apDevices, List<MobileDevice> smartThings, 
			Coordinate coordDevices, int stepPolicy, int seed) {
		MobileDevice st=null;
		Coordinate coordinate = new Coordinate();
		for(int i = 0;i<smartThings.size();i++){//It makes the new position according direction and speed
			st=smartThings.get(i);
		
			if((st.getDirection()!=Directions.NONE))
				coordinate.newCoordinate(st, stepPolicy, coordDevices);//1 -> It means that only one step 
			if(st.getCoord().getCoordX()==-1){
			
				if(st.getSourceServerCloudlet()!=null){
					int j=0,indexCloud=0;
					for(FogDevice sc:serverCloudlets){
						if(st.getSourceServerCloudlet().equals(sc)){
							indexCloud=j;
							break;
						}
						j++;
					}
					serverCloudlets.get(indexCloud).getSmartThings().remove(st);
					
					j=0;
					int indexAp=0;
					for(ApDevice ap:apDevices){
						if(st.getSourceAp().equals(ap)){
							indexAp=j;
							break;
						}
						j++;
					}
					apDevices.get(indexAp).getSmartThings().remove(st);

					st.setSourceAp(null);
					st.setSourceServerCloudlet(null);
					st.setMigStatus(false);
			
				}
				if(st.getSourceAp()==null){
					smartThings.remove(st);
					LogMobile.debug("NextStep.java", st.getName()+" was removed!");
				}
				else{
					st.getSourceServerCloudlet().setSmartThings(st, Policies.REMOVE); //it'll remove the smartThing from serverCloudlets-smartThing's set
					st.getSourceAp().setSmartThings(st, Policies.REMOVE);//it'll remove the smartThing from ap-smartThing's set
					LogMobile.debug("NextStep.java", st.getName()+" was removed!");
					smartThings.remove(st);
				}
			}
		}

		Random rand = new Random((long)(CloudSim.clock())*seed);
		int direction=0, speed=0,exchange=0;

//		for(MobileDevice stt: smartThings){//It exchange the x% of the cases
//			exchange = rand.nextInt(100);// 4 -> 25%, 5 -> 20%, 10 -> 10%, 20 -> 5%, 50 -> 2% and 100 -> 1%
//
//			if(exchange == 0){
//				while(true){
//					direction = rand.nextInt(MaxAndMin.MAX_DIRECTION-1)+1;
//					if(direction!=stt.getDirection()){
//						stt.setDirection(direction);
//						LogMobile.debug("NextStep.java", stt.getName()+" has a new direction");
//						break;
//					}
//				}
//			}
//			exchange = rand.nextInt(20);// 4 -> 25%, 5 -> 20%, 10 -> 10%, 20 -> 5%, 50 -> 2% and 100 -> 1%
//			if(exchange == 0){
//				while(true){
//					speed = rand.nextInt(MaxAndMin.MAX_SPEED);
//					if(speed !=stt.getSpeed()){
//						stt.setSpeed(speed);
//						LogMobile.debug("NextStep.java", stt.getName()+" has a new speed");
//						break;
//					}
//				}
//			}
//		}

	}

}



