/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team7587.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team7587.robot.Robot;

/**
 * The wrist subsystem is like the elevator, but with a rotational joint instead
 * of a linear joint.
 */
public class Wrist extends PIDSubsystem {
	private SpeedController motor;
	private Potentiometer pot;

	private static final double kP_real = 1, kP_simulation = 0.05;

	public Wrist() {
		super(kP_real, 0, 0);
		Robot.println("Wrist constructor");
		if (Robot.isSimulation()) { // Check for simulation and update PID values
			getPIDController().setPID(kP_simulation, 0, 0, 0);
		}
		setAbsoluteTolerance(2.5);

		motor = new Victor(6);

		// Conversion value of potentiometer varies between the real world and
		// simulation
		if (Robot.isReal()) {
			pot = new AnalogPotentiometer(3, -270.0 / 5);
		} else {
			pot = new AnalogPotentiometer(3); // Defaults to degrees
		}
		

		// Let's show everything on the LiveWindow
//		LiveWindow.addActuator("WRist", "Motor", (Victor) motor);
//		LiveWindow.addSensor("WRist", "Pot", (AnalogPotentiometer) pot);
//		LiveWindow.addActuator("WRist", "PID", getPIDController());
	}

	@Override
	public void initDefaultCommand() {
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
		SmartDashboard.putData("Wrist Angle", (AnalogPotentiometer) pot);
	}

	/**
	 * Use the potentiometer as the PID sensor. This method is automatically
	 * called by the subsystem.
	 */
	@Override
	protected double returnPIDInput() {
//		Robot.println("returnPIDInput:" + pot.get());
		return pot.get();
	}

	/**
	 * Use the motor as the PID output. This method is automatically called by
	 * the subsystem.
	 */
	@Override
	protected void usePIDOutput(double d) {
//		Robot.println("usePIDOutput:" + d);
		if(!Double.isNaN(d)) {
			motor.set(d);
		}
		
	}
}
