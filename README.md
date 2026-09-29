# Java-Traing

Training code for the programming curriculum of **Stealth Panther Robotics (FRC Team 6424)**. Each lesson is a ready-to-run WPILib robot project that students can open in the simulator, so no robot hardware is needed.

## Lessons

| Lesson | Topic | Folder |
|---|---|---|
| 1 | Your first command-based robot: run a program, change it, use variables | [`lesson-01-first-robot`](lesson-01-first-robot/) |

Each lesson folder has its own `README.md` with mentor setup steps, student instructions, and notes on how the project is laid out. Start there.

## Requirements

- [WPILib 2026](https://docs.wpilib.org/) (VS Code with the WPILib extension)
- Java 17 (bundled with the WPILib installer)
- GradleRIO 2026.1.1 (downloaded automatically on first build)
- An Xbox controller, or use *Keyboard 0* in the simulator

## Quick start

1. Clone this repo:

   ```
   git clone https://github.com/<your-org>/Java-Traing.git
   ```

2. Open a lesson folder (for example `lesson-01-first-robot`) in **WPILib VS Code** using `File > Open Folder`.
3. Press `Ctrl+Shift+P`, run **WPILib: Simulate Robot Code**, and choose *Sim GUI*.
4. Set the robot to **Teleoperated** and follow the lesson's README.

The first build downloads libraries, so run it once with an internet connection before class.

## Repository layout

```
Java-Traing/
├── README.md
└── lesson-01-first-robot/     a complete Gradle/WPILib project
    ├── README.md              lesson guide for mentors and students
    ├── build.gradle
    ├── vendordeps/
    └── src/main/java/frc/robot/
        ├── StudentCode.java   the one file students edit
        ├── RobotContainer.java
        ├── subsystems/
        └── commands/
```

Every lesson is a self-contained project, so it can be opened, built, and simulated on its own.

## For mentors

- Try each lesson on a student laptop before class, not just your own.
- Keep an untouched copy of each lesson folder to hand out if a student breaks theirs.
- Mentor answer keys are kept out of the lesson folders so students don't stumble onto them.

## License

Lesson projects are based on the WPILib project template. See `WPILib-License.md` inside each lesson folder for the WPILib license.
