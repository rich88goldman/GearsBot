package org.usfirst.frc.team7587.robot.commands;

import org.usfirst.frc.team7587.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The main autonomous command to pickup and deliver the soda to the box.
 */
public class Autonomous extends CommandGroup {
	public Autonomous() {

		Robot.println("Autonomous constructor");
		// addSequential(new PrepareToPickup());
		// addSequential(new Pickup());
		// addSequential(new SetDistanceToBox(0.10));
		addSequential(new OpenClaw());
		addSequential(new SetWristSetpoint(-45));
		Timer.delay(1);
//		addSequential(new SetElevatorSetpoint(0.4));
		addSequential(new DriveStraight(3)); // Use Encoders if ultrasonic is broken
		// addSequential(new Place());
		// addSequential(new SetDistanceToBox(0.60));
		addSequential(new SetWristSetpoint(0));
//		addSequential(new SeetElevatorSetpoint(-0.1));
		 addSequential(new DriveStraight(-3)); // Use Encoders if ultrasonic is broken
		// addParallel(new SetWristSetpoint(-45));
		 addSequential(new CloseClaw());

	}

}
