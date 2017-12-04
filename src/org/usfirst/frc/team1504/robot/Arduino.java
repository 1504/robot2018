package org.usfirst.frc.team1504.robot;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
public class Arduino {
	I2C arduino;
	Port kOnboard;
	int numOfBytes = 9;
	byte [] buffer;
	public Arduino(){
		arduino = new I2C(Port.kOnboard, 2);
		buffer = new byte[6];
	}
	public byte[] getBytes(){
		arduino.read(0, numOfBytes, buffer);
		return buffer;
	}
}
