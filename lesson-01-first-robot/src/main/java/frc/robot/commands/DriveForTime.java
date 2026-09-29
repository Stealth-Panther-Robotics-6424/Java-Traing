// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

/**
 * A simple timed autonomous: drive straight at a set speed for a set number of seconds, then stop.
 *
 * <p>This is the easiest possible auto and a good first step, but it is not very accurate. How far
 * the robot goes depends on battery voltage, carpet and wheel wear. In a later lesson we will use
 * encoders to drive an exact distance instead.
 */
public class DriveForTime extends Command {
  private final DriveSubsystem m_drive;
  private final double m_speed;
  private final double m_seconds;

  // A stopwatch we use to know when time is up.
  private final Timer m_timer = new Timer();

  /**
   * Creates a new DriveForTime.
   *
   * @param subsystem the drivetrain to drive
   * @param speed how fast to drive, -1.0 (full reverse) to 1.0 (full forward)
   * @param seconds how long to drive for
   */
  public DriveForTime(DriveSubsystem subsystem, double speed, double seconds) {
    m_drive = subsystem;
    m_speed = speed;
    m_seconds = seconds;

    addRequirements(m_drive);
  }

  /** Runs once at the start: reset the stopwatch to zero and start it. */
  @Override
  public void initialize() {
    m_timer.restart();
  }

  /** Every 20 ms: keep driving straight (zero rotation). */
  @Override
  public void execute() {
    m_drive.arcadeDrive(m_speed, 0.0);
  }

  /** Every 20 ms the scheduler asks "are you done?". We're done once enough time has passed. */
  @Override
  public boolean isFinished() {
    return m_timer.hasElapsed(m_seconds);
  }

  /**
   * Runs once when the command stops. "interrupted" is true if something else cancelled us early
   * (for example, teleop starting). Either way, stop the motors so the robot doesn't keep going.
   */
  @Override
  public void end(boolean interrupted) {
    m_drive.stop();
    m_timer.stop();
  }
}
