// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The robot's "main loop".
 *
 * <p>TimedRobot calls the methods below automatically every 20 milliseconds (50 times a second).
 * Which ones get called depends on the mode the Driver Station has the robot in: disabled,
 * autonomous, teleop or test.
 *
 * <p>In a command-based robot this file stays small on purpose. The real work happens in
 * subsystems and commands, and {@link RobotContainer} wires them together. This file just keeps
 * the {@link CommandScheduler} running and starts/stops the autonomous command.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private final RobotContainer m_robotContainer;

  /** Runs once when the robot first turns on. */
  public Robot() {
    // Creating the RobotContainer builds all our subsystems and sets up the controls.
    m_robotContainer = new RobotContainer();
  }

  /**
   * Runs every 20 ms, no matter what mode the robot is in.
   *
   * <p>CommandScheduler.run() is the heart of command-based programming. Each loop it: runs every
   * subsystem's periodic() method, runs every scheduled command's execute(), checks whether each
   * command isFinished(), and starts default commands on subsystems that are free.
   *
   * <p>If you delete this line, NOTHING in your command-based code will run.
   */
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /** Runs once each time the robot is disabled. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** Runs once at the start of the autonomous period. */
  @Override
  public void autonomousInit() {
    // Ask RobotContainer which command to run, then hand it to the scheduler.
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      CommandScheduler.getInstance().schedule(m_autonomousCommand);
    }
  }

  /** Runs every 20 ms during autonomous. The scheduler does the work, so this stays empty. */
  @Override
  public void autonomousPeriodic() {}

  /** Runs once at the start of teleop (driver-controlled) period. */
  @Override
  public void teleopInit() {
    // If auto is still running when teleop starts, stop it so the driver gets control right away.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** Runs every 20 ms during teleop. The default drive command handles driving. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancel everything when entering test mode so nothing moves unexpectedly.
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}
}
