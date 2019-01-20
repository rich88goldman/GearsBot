/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team7587.robot.Robot;

/**
 * Drive the given distance straight (negative values go backwards). Uses a
 * local PID controller to run a simple PID loop that is only enabled while this
 * command is running. The input is the averaged values of the left and right
 * encoders.
 */
public class DriveStraight extends Command {
	private PIDController pid;

	public DriveStraight(double distance) {
		requires(Robot.drivetrain);
		pid = new PIDController(2, 0, 0, new PIDSource() {
			PIDSourceType m_sourceType = PIDSourceType.kDisplacement;

			@Override
			public double pidGet() {
				return Robot.drivetrain.getDistance();
			}

			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				m_sourceType = pidSource;
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				return m_sourceType;
			}
		}, new PIDOutput() {
			@Override
			public void pidWrite(double d) {
				if(Double.isNaN(d)) {
					Robot.println(" found NaN!");
					d = 0;
				}else {
					Robot.println("pid Write: " + d);
				}
				Robot.drivetrain.drive(d/2, d/2);
			}
		});
		pid.setAbsoluteTolerance(0.02);
		Robot.println("----set distance: " + distance);
		pid.setSetpoint(distance);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		// Get everything in a safe starting state.
		pid.reset();
		pid.enable();
		
		Robot.drivetrain.reset();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		
		return pid.onTarget();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// Stop PID and the wheels
		pid.disable();
		Robot.drivetrain.drive(0, 0);
	}
}
