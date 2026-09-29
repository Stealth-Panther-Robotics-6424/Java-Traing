// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.DriveForTime;
import frc.robot.commands.RunStudentCode;
import frc.robot.subsystems.DriveSubsystem;

/**
 * Where the robot gets put together.
 *
 * <p>This class does three jobs:
 *
 * <ol>
 *   <li>Creates each subsystem exactly once.
 *   <li>Connects the controller to commands (a default command and the X button).
 *   <li>Decides which command runs in autonomous.
 * </ol>
 */
public class RobotContainer {
  // ---- Subsystems ----
  // Create each subsystem ONCE, here. Every command that needs the drivetrain gets this same
  // object passed to it.
  //private final DriveSubsystem m_robotDrive = new DriveSubsystem();

  // ---- Controllers ----
  // CommandXboxController lets us attach commands to buttons, like m_driverController.x().
  private final CommandXboxController m_driverController =
      new CommandXboxController(OIConstants.kDriverControllerPort);

  /** Builds the robot: subsystems, controls and autonomous. */
  public RobotContainer() {
    // A "default command" runs on a subsystem whenever no other command is using it.
    // During teleop nothing else uses the drivetrain, so DefaultDrive runs the whole time and
    // the driver is always in control. When auto's DriveForTime needs the drivetrain, the
    // scheduler pauses DefaultDrive and brings it back once auto is done.
    //
    // The "() -> ..." parts are lambdas: little functions that DefaultDrive calls every loop to
    // get the CURRENT stick position. If we passed getLeftY() directly, it would read the stick
    // once, right now, and never again.
    //
    // Why the minus signs? Xbox sticks report UP as negative. We flip them so pushing up means
    // "drive forward" and pushing right means "turn right" (WPILib counts counter-clockwise as
    // positive rotation).
    
    configureButtonBindings();
  }

  /**
   * Connects buttons to commands.
   *
   * <p>A "trigger" is something that can be true or false, like "is X pressed?". onTrue() means
   * "each time it changes from not-pressed to pressed, schedule this command once."
   */
  private void configureButtonBindings() {
    // Press X: run whatever the students wrote in StudentCode.java.
    m_driverController.x().onTrue(new RunStudentCode());
  }

  /**
   * Tells {@link Robot} which command to run when autonomous starts.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // Drive straight forward at half speed for 2 seconds, then stop.
    return null;
  }
}
