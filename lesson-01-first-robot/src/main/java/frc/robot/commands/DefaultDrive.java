// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import java.util.function.DoubleSupplier;

/**
 * Lets the driver drive the robot with the controller sticks.
 *
 * <p>A COMMAND is an action the robot performs using one or more subsystems. Every command has the
 * same four-step life:
 *
 * <ol>
 *   <li>initialize() runs once when the command starts.
 *   <li>execute() runs every 20 ms while the command is running.
 *   <li>isFinished() is checked every 20 ms; returning true ends the command.
 *   <li>end() runs once when the command stops (finished OR interrupted).
 * </ol>
 *
 * <p>This command is used as the drivetrain's default command, so it runs whenever nothing else
 * needs the drivetrain. It never finishes on its own.
 */
public class DefaultDrive extends Command {
  private final DriveSubsystem m_drive;

  // A DoubleSupplier is "something we can ask for a number". Each loop we ask it for the current
  // stick value. This keeps the command from knowing anything about the controller itself, so the
  // same command would work with a joystick, a gamepad, or numbers from a test.
  private final DoubleSupplier m_forward;
  private final DoubleSupplier m_rotation;

  /**
   * Creates a new DefaultDrive.
   *
   * @param subsystem the drivetrain to drive
   * @param forward supplies the forward/back speed (-1.0 to 1.0)
   * @param rotation supplies the turning speed (-1.0 to 1.0)
   */
  public DefaultDrive(DriveSubsystem subsystem, DoubleSupplier forward, DoubleSupplier rotation) {
    m_drive = subsystem;
    m_forward = forward;
    m_rotation = rotation;

    // VERY IMPORTANT: tell the scheduler this command uses the drivetrain. This is how the
    // scheduler makes sure two commands never fight over the same motors at the same time.
    addRequirements(m_drive);
  }

  /** Every 20 ms: read the sticks and drive. */
  @Override
  public void execute() {
    m_drive.arcadeDrive(m_forward.getAsDouble(), m_rotation.getAsDouble());
  }

  // We don't override isFinished(). The default returns false, which means "keep running
  // forever". That's exactly what a default drive command should do.
}
