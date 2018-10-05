package org.fog.localization;

import java.util.Arrays;

import org.fog.entities.*;
import org.fog.vmmobile.constants.*;
/**
* @author Marcio Moraes Lopes
*/


public class Coordinate { //extends Map {

	private int coordX;
	private int coordY;

	public Coordinate(){
	}

	public  boolean isWithinLimitPosition(Coordinate c){
		if (c.getCoordX()>=MaxAndMin.MAX_X||
				c.getCoordX()<0||
				c.getCoordY()>=MaxAndMin.MAX_Y||
				c.getCoordY()<0)
			return false;
		else
			return true;
	}
	public  void desableSmartThing(MobileDevice smartThing){
		//	System.out.println("Removing SmartThing: "+smartThing.getId());
		smartThing.setCoord((int) -1, (int)-1);
	}
	public  void newCoordinate(MobileDevice smartThing, int add, Coordinate coordDevices){//(pointUSER user,float add)

		if(smartThing.getSpeed()!=0){
			int increaseX= (smartThing.getCoord().getCoordX()+(smartThing.getSpeed()*add));
			int increaseY= (smartThing.getCoord().getCoordY()+(smartThing.getSpeed()*add));
			int decreaseX= (smartThing.getCoord().getCoordX()-(smartThing.getSpeed()*add));
			int decreaseY= (smartThing.getCoord().getCoordY()-(smartThing.getSpeed()*add));
			int direction= smartThing.getDirection();
			int oldCoordX = smartThing.getCoord().getCoordX();
			int oldCoordY = smartThing.getCoord().getCoordY();

			if(decreaseX<0||decreaseY<0||increaseX>=MaxAndMin.MAX_X||increaseY>=MaxAndMin.MAX_Y){//It checks the CoordDevices limits.
				desableSmartThing(smartThing);
				return;
			}

			if(direction==Directions.EAST){
				/*same Y, increase X*/
				smartThing.getCoord().setCoordX(increaseX);
			}
			else if(direction==Directions.WEST){
				/*same Y, decrease X*/
				smartThing.getCoord().setCoordX(decreaseX);//next position in the same direction
			}
			else if(direction==Directions.SOUTH){//Directions.NORTH){
				/*same X, increase Y*/
				smartThing.getCoord().setCoordY(increaseY);//next position in the same direction
			}
			else if(direction==Directions.NORTH){//Directions.SOUTH){
				/*same X, decrease Y*/
				smartThing.getCoord().setCoordY(decreaseY);
			}
			else if(direction==Directions.SOUTHEAST){//Directions.NORTHEAST){
				/*increase X and Y*/
				smartThing.getCoord().setCoordX(increaseX);
				smartThing.getCoord().setCoordY(increaseY);

			}
			else if(direction==Directions.NORTHWEST){//Directions.SOUTHWEST){
				/*decrease X and Y*/
				smartThing.getCoord().setCoordX(decreaseX);
				smartThing.getCoord().setCoordY(decreaseY);

			}
			else if(direction==Directions.SOUTHWEST){//Directions.NORTHWEST){
				/*decrease X increase Y*/
				smartThing.getCoord().setCoordX(decreaseX);
				smartThing.getCoord().setCoordY(increaseY);

			}
			else if(direction==Directions.NORTHEAST){//Directions.SOUTHEAST){
				/*increase X decrease Y*/
				smartThing.getCoord().setCoordX(increaseX);
				smartThing.getCoord().setCoordY(decreaseY);
			}
		}
	}





	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}



}
