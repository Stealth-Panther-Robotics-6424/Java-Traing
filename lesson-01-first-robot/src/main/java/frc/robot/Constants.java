// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * One place for every "magic number" on the robot.
 *
 * <p>Wiring ports, speeds and times all live here instead of being typed directly into the code.
 * If the electrical team moves a motor to a different port, you change ONE line here and the whole
 * program picks it up.
 *
 * <p>Naming convention: constants start with a lowercase "k" (kLeftMotor1Port). Each group of
 * related constants gets its own inner class (DriveConstants, OIConstants, ...).
 */
public final class Constants {
  /** Everything about the drivetrain. */
  public static final class DriveConstants {
    // PWM ports on the roboRIO that each motor controller is plugged into.
    // Each side has a "leader" (motor 1) and a "follower" (motor 2).
    public static final int kLeftMotor1Port = 0;
    public static final int kLeftMotor2Port = 1;
    public static final int kRightMotor1Port = 2;
    public static final int kRightMotor2Port = 3;

    // The motors on the right side face the opposite direction from the left side, so "forward"
    // for the right motors is really "backward". Inverting them makes both sides agree.
    public static final boolean kRightMotorsInverted = true;
  }

  /** "OI" stands for Operator Interface: the controllers the drive team holds. */
  public static final class OIConstants {
    // The USB port the controller shows up on in the Driver Station (0 = first controller).
    public static final int kDriverControllerPort = 0;
  }

  /** Settings for the autonomous period. */
  public static final class AutoConstants {
    // How fast to drive during auto, from -1.0 (full reverse) to 1.0 (full forward).
    public static final double kDriveSpeed = 0.5;

    // How long to drive forward, in seconds.
    public static final double kDriveTimeSeconds = 2.0;
  }
}
