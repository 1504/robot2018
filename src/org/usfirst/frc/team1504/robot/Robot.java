package org.usfirst.frc.team1504.robot;

import edu.wpi.first.wpilibj.CameraServer;
//import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.*;
import com.ctre.CANTalon;

/**
 * This is a demo program for learning basic Java and Git for the 2017 FRC season.
 * 
 * TODO: Add in code to run the right side of the robot.
 * TODO: Add in speed dividers:
 *           Left trigger: Speed / 2
 *           Right trigger: Speed / 3.5
 */
public class Robot extends SampleRobot {
	Joystick leftStick;  // set to ID 1 in DriverStation
	Joystick rightStick; // set to ID 2 in DriverStation
	NetworkTable table;
	RobotDrive drive;
	public static final int FRONT_LEFT_TALON_PORT = 10;
	public static final int BACK_LEFT_TALON_PORT = 11;
	public static final int BACK_RIGHT_TALON_PORT = 12;
	public static final int FRONT_RIGHT_TALON_PORT = 13;
	public static final int[] DRIVE_MOTOR_PORTS = {
			FRONT_LEFT_TALON_PORT,
			BACK_LEFT_TALON_PORT,
			BACK_RIGHT_TALON_PORT,
			FRONT_RIGHT_TALON_PORT
	};
	public static final double[] RIGHT = {
			1,-1,-1, 1
	};
	public static final double[] LEFT = {
			-1,1,1, -1
	};
	public static final double[] d = {
			80.0 //change this to be the center of the camera
	};
	private CANTalon[] _motors = new CANTalon[DRIVE_MOTOR_PORTS.length];
	//CANTalon leftMotor;
	
	public Robot() {
		// Joystick on DriverStation port 0
		//leftStick = new Joystick(0);
		// Joystick on DriverStaton port 1
		for(int i = 0; i < DRIVE_MOTOR_PORTS.length; i++)
		{
			_motors[i] = new CANTalon(DRIVE_MOTOR_PORTS[i]);
		}
		rightStick = new Joystick(1);
		table = NetworkTable.getTable("GRIP/paper");
		for(int i = 0; i < _motors.length; i++)
		{
		//	_motors[i].set(.2 * LEFT[i]);
		}
		// Motor controller with CAN ID 10
		//leftMotor = new CANTalon(10);
		CameraServer.getInstance().startAutomaticCapture();
		CameraServer.getInstance();
	}
	public void operatorControl() {
    	while (isOperatorControl() && isEnabled()) {
    		if(table.getNumberArray("centerX", d).length==1){
    			System.out.println(table.getNumberArray("centerX", d)[0]);
	    		double centerX = table.getNumberArray("centerX", d)[0];
	    		double diff = d[0] - centerX; //needs to go right if neg, left if pos
	    		if (diff < -10){
	    			for(int i = 0; i < _motors.length; i++)
	    			{
	    				_motors[i].set(.2 * RIGHT[i]);
	    			}
	    		}
	    		else if (diff > 10){
	    			for(int i = 0; i < _motors.length; i++)
	    			{
	    				_motors[i].set(.2 * LEFT[i]);
	    			}
	    		}
	    		else{
	    			for(int i = 0; i < _motors.length; i++)
	    			{
	    				_motors[i].set(0);
	    			}
	    			
	    		}
	    		/*if(centerX < d[0] - 20){
	    			for(int i = 0; i < _motors.length; i++)
	    			{
	    				_motors[i].set(.2 * LEFT[i]);
	    			}
	    		} else if (centerX > d[0] + 20){
	    			for(int i = 0; i < _motors.length; i++)
	    			{
	    				_motors[i].set(.2 * RIGHT[i]);
	    			}
	    			
	    		}else if (centerX > d[0] + 20 && centerX < d[0] - 20){
	    			
	    		}*/
	    		
    		} else{
    			for(int i = 0; i < _motors.length; i++)
    			{
    				_motors[i].set(0);
    			}
    			
    		}
			// Create a variable for the left motor output value
			// and set it equal to the left joystick input
			
			// Wait for a little while - run this loop ~200 times a second
			Timer.delay(0.05);
    		//Timer.delay(0.01);
    	}
    }
	
	
	/**
	 * Runs the motors with tank steering.
	 */
	/*public void operatorControl() {
		while (isOperatorControl() && isEnabled()) {
			// Create a variable for the left motor output value
			// and set it equal to the left joystick input
			double leftOutput = leftStick.getY();
			
			// Set the left motor to the correct value
			leftMotor.set(leftOutput);
			
			// Wait for a little while - run this loop ~200 times a second
			Timer.delay(0.005);
		}
	}*/

}
