package org.usfirst.frc.team7587.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team7587.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick joy = new Joystick(0);

	public OI() {
		// Put Some buttons on the SmartDashboard
		SmartDashboard.putData("Elevator Bottom", new SetElevatorSetpoint(0));
		SmartDashboard.putData("Elevator Platform", new SetElevatorSetpoint(0.1));
		SmartDashboard.putData("Elevator Top", new SetElevatorSetpoint(0.3));

		SmartDashboard.putData("Wrist Horizontal", new SetWristSetpoint(0));
		SmartDashboard.putData("Raise Wrist", new SetWristSetpoint(-45));

		SmartDashboard.putData("Open Claw", new OpenClaw());
		SmartDashboard.putData("Close Claw", new CloseClaw());

		SmartDashboard.putData("Deliver Soda", new Autonomous());
/*
		// Create some buttons
		JoystickButton d_up = new JoystickButton(joy, 3);			// up
		JoystickButton d_down = new JoystickButton(joy, 0);			// down

		JoystickButton d_right = new JoystickButton(joy, 1);		// open
		JoystickButton d_left = new JoystickButton(joy, 2);			// close
*/		
		JoystickButton d_up = new JoystickButton(joy, 4);			// up
		JoystickButton d_down = new JoystickButton(joy, 1);			// down

		JoystickButton d_right = new JoystickButton(joy, 2);		// open
		JoystickButton d_left = new JoystickButton(joy, 3);			// close
		
		JoystickButton d_whori = new JoystickButton(joy, 5);			// horizontal
		JoystickButton d_wstr = new JoystickButton(joy, 6);			// raised
		
//		JoystickButton l2 = new JoystickButton(joy, 9);
//		JoystickButton r2 = new JoystickButton(joy, 10);
//		JoystickButton l1 = new JoystickButton(joy, 11);
//		JoystickButton r1 = new JoystickButton(joy, 12);

		// Connect the buttons to commands
		d_up.whenPressed(new SetElevatorSetpoint(0.3));   //actual 2, set 3
		d_down.whenPressed(new SetElevatorSetpoint(-0.2));  //actual 3, set 4
		
		d_right.whenPressed(new OpenClaw());    //actual  0, set 1
		d_left.whenPressed(new CloseClaw());    // actual 1, set 2

		d_whori.whenPressed( new SetWristSetpoint(0));
		d_wstr.whenPressed( new SetWristSetpoint(-45));
		
//		r1.whenPressed(new PrepareToPickup());
//		r2.whenPressed(new Pickup());
//		l1.whenPressed(new Place());
//		l2.whenPressed(new Autonomous());
	}

	public Joystick getJoystick() {
		return joy;
	}
}
