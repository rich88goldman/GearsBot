/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

import org.usfirst.frc.team7587.robot.Robot;

/**
 * Closes the claw for one second. Real robots should use sensors, stalling
 * motors is BAD!
 */
public class CloseClaw extends TimedCommand {// Command {
	public CloseClaw() {
		super(1);
		requires(Robot.claw);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.log2("CloseClaw init: " + System.identityHashCode(this));
		Robot.claw.close();
	}

	// Make this return true when this Command no longer needs to run execute()
	/*  -- for now make it finished in 1 sec
	@Override
	protected boolean isFinished() {
		return Robot.claw.isGrabbing();
	}
	*/

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// NOTE: Doesn't stop in simulation due to lower friction causing the
		// can to fall out
		// + there is no need to worry about stalling the motor or crushing the
		// can.
		Robot.log2("CloseClaw end, sim? " + Robot.isSimulation());
//		if (!Robot.isSimulation())
			Robot.claw.stop();
	}
}
