// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.StudentCode;

/**
 * Runs the students' code once when it is scheduled.
 *
 * <p>This command uses no subsystems, so it never interrupts driving: you can press X while the
 * robot is being driven. It finishes right away, in the same loop it started.
 *
 * <p>Mentors: if a student's code crashes (for example, dividing by zero), we catch the problem
 * and print it instead of letting it stop the whole robot program.
 */
public class RunStudentCode extends Command {
  /** Runs once, when the command starts. */
  @Override
  public void initialize() {
    try {
      StudentCode.run();
    } catch (RuntimeException e) {
      System.out.println("Your code crashed while running: " + e);
    }
  }

  /** Done immediately: the work happened in initialize(). */
  @Override
  public boolean isFinished() {
    return true;
  }
}
