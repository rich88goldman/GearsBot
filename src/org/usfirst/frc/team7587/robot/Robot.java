package org.usfirst.frc.team7587.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.time.LocalDateTime;

import org.usfirst.frc.team7587.robot.commands.Autonomous;
import org.usfirst.frc.team7587.robot.subsystems.Claw;
import org.usfirst.frc.team7587.robot.subsystems.DriveTrain;
import org.usfirst.frc.team7587.robot.subsystems.Elevator;
import org.usfirst.frc.team7587.robot.subsystems.Wrist;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Command autonomousCommand;

	public static DriveTrain drivetrain;
	public static Elevator elevator;
	public static Wrist wrist;
	public static Claw claw;
	public static OI oi;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		// Initialize all subsystems
		drivetrain = new DriveTrain();
		elevator = new Elevator();
		wrist = new Wrist();
		claw = new Claw();
		oi = new OI();

		// instantiate the command used for the autonomous period
		autonomousCommand = new Autonomous();

		// Show what command your subsystem is running on the SmartDashboard
		SmartDashboard.putData(drivetrain);
		SmartDashboard.putData(elevator);
		SmartDashboard.putData(wrist);
		SmartDashboard.putData(claw);

	}
/*
	public static boolean isReal() {
		return false;
	}
	public static boolean isSimulation() {
		return true;
	}
*/
	

	@Override
	public void autonomousInit() {
		println("autonomousInit, autonomousCommand start");
		autonomousCommand.start(); // schedule the autonomous command (example)
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		// println("autonomousPeriodic...");
		Scheduler.getInstance().run();
		// Timer.delay(0.1);
		log();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		println("teleopInit");
		autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		// println("teleopPeriodic...");
		Scheduler.getInstance().run();
		// Timer.delay(0.1);
		log();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	private void log() {
		// wrist.log();
		// elevator.log();
		drivetrain.log();
		// claw.log();
	}

	public static void println(String s) {
		System.out.println("<" + LocalDateTime.now() + ">: " + s);
	}

	// @Override
	// public boolean isReal() {
	// return false;
	// }

}
