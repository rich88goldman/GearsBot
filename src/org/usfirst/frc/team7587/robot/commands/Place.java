package org.usfirst.frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Place a held soda can onto the platform.
 */
public class Place extends CommandGroup {
	//all sub commands are done in sequence
	public Place() {
		addSequential(new SetElevatorSetpoint(0.25));
		addSequential(new SetWristSetpoint(0));
		addSequential(new OpenClaw());
	}
}
