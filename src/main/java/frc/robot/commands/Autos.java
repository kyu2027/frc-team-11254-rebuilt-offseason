// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.ShootWithDelay;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(ExampleSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }

  public static Command sideAuto(Drive drive, Shooter shooter) {
    return Commands.sequence(
      drive.timeDrive(1.5, -0.15),
      new ShootWithDelay(shooter)
    );
  }

  public static Command middleAuto(Drive drive, Shooter shooter){
     return Commands.sequence(
      drive.timeDrive(1.5, -0.2),
      new ShootWithDelay(shooter)
     );
   }
}
