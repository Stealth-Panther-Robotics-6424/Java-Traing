// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

/**
 * The drivetrain: the four motors that move the robot around.
 *
 * <p>A SUBSYSTEM is a piece of robot hardware plus the code that controls it. It answers "what CAN
 * this part of the robot do?" (drive, stop). It does not decide WHEN to do those things; that is
 * the job of commands.
 *
 * <p>This is a "tank style" (differential) drivetrain: two motors on the left, two on the right.
 * To turn, one side spins faster than the other.
 */
public class DriveSubsystem extends SubsystemBase {
  // The motor controllers. "m_" means "member variable" (it belongs to this object).
  // "final" means we create them once and never replace them.
  private final PWMSparkMax m_leftLeader = new PWMSparkMax(DriveConstants.kLeftMotor1Port);
  private final PWMSparkMax m_leftFollower = new PWMSparkMax(DriveConstants.kLeftMotor2Port);
  private final PWMSparkMax m_rightLeader = new PWMSparkMax(DriveConstants.kRightMotor1Port);
  private final PWMSparkMax m_rightFollower = new PWMSparkMax(DriveConstants.kRightMotor2Port);

  // DifferentialDrive does the math that turns "forward + turn" into a left speed and a right
  // speed. We give it the leader on each side; the followers copy their leaders.
  private final DifferentialDrive m_drive =
      new DifferentialDrive(m_leftLeader::set, m_rightLeader::set);

  /** Creates the drivetrain and sets up the motors. */
  public DriveSubsystem() {
    // Followers copy whatever their leader is told to do, so we only ever command the leaders.
    m_leftLeader.addFollower(m_leftFollower);
    m_rightLeader.addFollower(m_rightFollower);

    // Flip the right side so that a positive speed moves BOTH sides forward.
    // (Followers copy the inverted output, so we only invert the leader.)
    // If the robot spins in place when you push forward, this is the setting to check.
    m_rightLeader.setInverted(DriveConstants.kRightMotorsInverted);
  }

  /**
   * Drives the robot using "arcade" controls: one value for forward/back and one for turning.
   *
   * @param forward speed forward, from -1.0 (full reverse) to 1.0 (full forward)
   * @param rotation turning speed, from -1.0 (clockwise/right) to 1.0 (counter-clockwise/left)
   */
  public void arcadeDrive(double forward, double rotation) {
    m_drive.arcadeDrive(forward, rotation);
  }

  /** Stops all drive motors. */
  public void stop() {
    m_drive.stopMotor();
  }

  /**
   * Runs automatically every 20 ms (the CommandScheduler calls it), whether or not a command is
   * using this subsystem. A good place to send sensor values to the dashboard. We have no sensors
   * yet, so it is empty.
   */
  @Override
  public void periodic() {}
}
