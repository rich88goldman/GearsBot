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
		addSequential(new OpenClaw()); Timer.delay(0.5);
//		addSequential(new SetWristSetpoint(-45)); Timer.delay(0.5);
		addSequential(new SetElevatorSetpoint(0.4)); Timer.delay(0.5);
		addSequential(new DriveStraight(4)); Timer.delay(1); // Use Encoders if ultrasonic is broken
		
		// addSequential(new Place());
		// addSequential(new SetDistanceToBox(0.60));
//		addSequential(new SetWristSetpoint(0));
		 addSequential(new DriveStraight(-4)); Timer.delay(0.5);// Use Encoders if ultrasonic is broken
		addSequential(new SetElevatorSetpoint(0)); Timer.delay(0.5);
//		 addParallel(new SetWristSetpoint(0)); Timer.delay(0.5);
		 addSequential(new CloseClaw()); 
	}

}
