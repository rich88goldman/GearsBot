/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team7587.robot.Robot;

/**
 * Move the elevator to a given location. This command finishes when it is
 * within the tolerance, but leaves the PID loop running to maintain the
 * position. Other commands using the elevator should make sure they disable
 * PID!
 */
public class SetElevatorSetpoint extends Command {
	private double setpoint;

	public SetElevatorSetpoint(double setpoint) {
		this.setpoint = setpoint;
		requires(Robot.elevator);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.log2("elevator init setPoint: " + setpoint);
		Robot.elevator.enable();
		Robot.elevator.setSetpoint(setpoint);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		Robot.log2("check finish: current setPoint=" + Robot.elevator.getSetpoint() + " vs " + this.setpoint);
		return Robot.elevator.getSetpoint() == this.setpoint;
//		return Robot.elevator.onTarget();			// it doesn't use value from setAbsoluteTolerance(0.005)!?
	}
}
