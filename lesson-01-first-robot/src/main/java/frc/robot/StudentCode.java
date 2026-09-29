// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * *** THIS IS THE ONLY FILE STUDENTS EDIT. ***
 *
 * <p>Everything else in this project already works. Whenever the driver presses the X button on
 * the controller, the robot calls the run() method below, once.
 *
 * <p>Whatever you print with System.out.println shows up in the console of the simulator.
 *
 * <p>How to test your code:
 *
 * <ol>
 *   <li>Save this file (Ctrl+S). Unsaved changes will NOT run.
 *   <li>Start the simulator and, in the Sim GUI, set the robot to <b>Teleoperated</b>.
 *   <li>Press the X button on the controller and read the output in the console.
 *   <li>Change your code, save, stop the simulator, and start it again.
 * </ol>
 */
public final class StudentCode {
  private StudentCode() {}

  /** Called once each time X is pressed. Write your code between the START and END lines. */
  public static void run() {
    // ===================== START OF STUDENT CODE =====================

    // Task 1: run and change the program.
    // Press X and find this message in the console. Then change the words, save, restart the
    // simulator and press X again. Did the output change?
    System.out.println("Hello from my robot!");

    // Task 2: use variables.
    // A variable is a labeled box that stores one value. Write the TYPE first, then the NAME,
    // then = and the value:
    //
    //   double distanceInches = 12.0;
    //
    // Make a variable for a distance in inches, and a second one for the same distance in meters
    // (meters = inches * 0.0254). Print both with a label.

    // Task 3: try more values.
    // Change the inches value to five different numbers. Check each answer on a calculator.
    // Then add a second conversion, such as degrees to radians, using two new variables.

    // Stretch: convert feet to meters, or print a full sentence like
    // "12 inches is 0.3048 meters".

    // ====================== END OF STUDENT CODE ======================
  }
}
