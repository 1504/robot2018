package org.usfirst.frc.team1504.robot;

public class Groundtruth {
	double leftX;
	double leftY;
	double leftSQUAL;
	double rightX;
	double rightY;
	double rightSQUAL;
	int numOfVal = 1;
	double [] acceleration;
	double [] oldLeftX;
	double [] oldLeftY;
	double [] oldRightX;
	double [] oldRightY;
	public Groundtruth(){
		acceleration = new double[3];
		oldLeftX = new double[numOfVal];
		oldLeftY = new double[numOfVal];
		oldRightX = new double[numOfVal];
		oldRightY = new double[numOfVal];
	}
	public void update(byte[] data){
		leftX = data[0];
		leftY = data[1];
		leftSQUAL = data[2];
		rightX = data[3];
		rightY = data[4];
		rightSQUAL = data[5];
	}
	public double [] getAcceleration(){
		
		return acceleration;
	}
	
}
