# Lesson 1: Your First Command-Based Robot

A ready-to-run robot for the simulator. It has a tank drivetrain you drive with
an Xbox controller, a 2-second timed autonomous, and a spot where **students
write their own code**. Press **X** and the robot runs whatever the students
wrote.

Built for **WPILib 2026** (GradleRIO 2026.1.1, Java 17), same setup as the
team's `Sample` project.

## How it fits Unit 1, Session 1

Unit 1 Session 1 (see the Drive lesson and practice plans) is: run a program,
change it, and use variables. That is exactly what students do here, in one
file. The tasks in `StudentCode.java` are the practice plan's tasks:

| Practice plan task | Where students do it |
|---|---|
| Task 1: run the program, change the message, fix a deliberate error | `System.out.println("Hello from my robot!");` |
| Task 2: variables for inches and meters, print both | the `TASK 2` comment |
| Task 3: five test values, then a second conversion | the `TASK 3` comment |
| Stretch: feet to meters, print a sentence | the `Stretch` comment |

Students never touch the drivetrain code and never set anything up.

## Mentor: get ready (10 minutes, before class)

1. Open this folder in **WPILib VS Code** (`File > Open Folder`). The team
   number doesn't matter for the simulator.
2. `Ctrl+Shift+P` → **WPILib: Simulate Robot Code** → choose *Sim GUI*. The
   first build downloads libraries, so do it once with internet **before
   class** on every laptop.
3. In the Sim GUI, drag a controller (or *Keyboard 0*) from *System
   Joysticks* onto *Joysticks[0]*.
4. Under *Robot State*, pick **Teleoperated**. **Buttons only work while the
   robot is enabled.**
5. Press **X** (button 3 in the Sim GUI) and look for `Hello from my robot!`
   in the console (the terminal panel that started the simulator).

Do this on a student laptop, not just yours. Then save a copy of the untouched
folder for anyone who breaks theirs.

## Students: your job

1. Open `src/main/java/frc/robot/StudentCode.java`. **This is the only file you
   edit.** Write your code between the START and END lines.
2. **Save** (`Ctrl+S`). Unsaved code will not run.
3. Start the simulator, set it to **Teleoperated**, press **X**, and read the
   console.
4. Changed something? Save, stop the simulator, start it again, press X.

If the console shows a red error, read the **first** error, find the file name
and line number, and look at that line and the one above it.

## What's in the project

```
src/main/java/frc/robot/
├── StudentCode.java         ← students write here (run() is called on X)
├── Main.java                starts the robot (never edit)
├── Robot.java               the 20 ms loop; keeps the scheduler running
├── RobotContainer.java      builds subsystems, hooks up controls, picks auto
├── Constants.java           every port, speed and time in one place
├── subsystems/
│   └── DriveSubsystem.java  the four drive motors
└── commands/
    ├── RunStudentCode.java  the command X runs: calls StudentCode.run() once
    ├── DefaultDrive.java    drive with the sticks (teleop)
    └── DriveForTime.java    drive straight for N seconds (auto)
```

### The big idea (for the mini-lesson or later sessions)

Command-based code splits the robot into two kinds of things:

| | Question it answers | Example here |
|---|---|---|
| **Subsystem** | What *can* this part of the robot do? | `DriveSubsystem` can drive and stop |
| **Command** | What should the robot do *right now*, and when is it done? | `DefaultDrive`, `DriveForTime`, `RunStudentCode` |

The **CommandScheduler** runs every 20 ms and decides which commands run. A
command says which subsystems it needs (`addRequirements`), and the scheduler
guarantees two commands never control the same motors at once.

### `RunStudentCode.java` and the X button
In `RobotContainer.java`, one line connects the button to the command:

```java
m_driverController.x().onTrue(new RunStudentCode());
```

"Each time X goes from not-pressed to pressed, schedule `RunStudentCode` once."
The command calls `StudentCode.run()` in `initialize()` and finishes right
away. It needs no subsystems, so pressing X never interrupts driving. If a
student's code crashes, the command catches it and prints a message instead of
stopping the robot program.

### The drivetrain and auto (unchanged from the sample)
- `Constants.java`: motor ports (PWM 0–3, same as the team `Sample`),
  controller port, auto speed and time. Constant names start with `k`.
- `DriveSubsystem.java`: four `PWMSparkMax` motors; the second on each side
  follows the first; the right side is inverted; `DifferentialDrive` turns
  "forward + turn" into left/right speeds.
- `DefaultDrive.java`: reads the sticks every loop and calls `arcadeDrive`. It
  is the drivetrain's **default command**, so it runs whenever nothing else
  needs the drivetrain. Left stick Y is forward/back and right stick X turns.
- `DriveForTime.java`: the timed auto (drive at 50% for 2 s, then stop). It
  shows a command's four steps: `initialize()` once, `execute()` every loop,
  `isFinished()` every loop, `end()` once.
- `Robot.java`: `robotPeriodic()` calls `CommandScheduler.getInstance().run()`.
  Delete that line and nothing works.

## Mentor notes

- **Stuck students:** use the hint ladder in the Unit 1 Practice Plan. Don't
  take the keyboard.
- **"Nothing happens when I press X":** the usual causes are (1) the
  simulator isn't in Teleoperated, (2) the file wasn't saved, (3) the
  simulator wasn't restarted after the change, (4) the controller isn't
  dragged onto Joysticks[0].
- **Watch for:** integer division (`1 / 2` is `0`, so use `double`), numbers
  inside quotes, missing semicolons.
- **Try the auto:** set *Autonomous* in the Sim GUI. The drive motors show in
  the *PWM* / *Other Devices* panels for 2 seconds.
- **Answer key:** see `lesson-01-mentor-answers.md` next to this folder. Don't
  share it with students.

## Later sessions

The same robot carries the unit forward. Session 2 (decisions and loops) and
Session 3 (methods and classes) also happen inside `StudentCode.java`; for
example, students can move their conversions into a method with a parameter.
Later units add more buttons, encoders and PID.
