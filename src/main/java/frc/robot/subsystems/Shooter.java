// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import pabeles.concurrency.ConcurrencyOps.Reset;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkFlexConfig;
import static frc.robot.Constants.ShooterConstants.*;

public class Shooter extends SubsystemBase {
  private SparkMax shootermotor;
  private SparkMaxConfig shootermotorconfig;
  private SparkFlex intake;
  private SparkFlexConfig intakeconfig;
  private SparkMax feeder;
  private SparkMaxConfig feederconfig;

  /** Creates a new Shooter. */
  public Shooter() {
    shootermotor = new SparkMax(SHOOTERID, SparkMax.MotorType.kBrushless);
    intake = new SparkFlex(INTAKEID, SparkFlex.MotorType.kBrushless);
    feeder = new SparkMax(FEEDERID, SparkMax.MotorType.kBrushless);

    shootermotorconfig = new SparkMaxConfig();
    intakeconfig = new SparkFlexConfig();
    feederconfig = new SparkMaxConfig();

    shootermotorconfig
      .idleMode(IdleMode.kBrake)
      .smartCurrentLimit(30);
    intakeconfig
      .idleMode(IdleMode.kBrake)
      .smartCurrentLimit(30);
    feederconfig
      .idleMode(IdleMode.kBrake)
      .smartCurrentLimit(30);

    shootermotor.configure(shootermotorconfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    intake.configure (intakeconfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    feeder.configure (feederconfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public void intake() {
    shootermotor.set(0.1);
    intake.set(0.2);
    feeder.set(0.1);
  }

  public void outtake() {
    shootermotor.set(-0.1);
    intake.set(-0.2);
    feeder.set(-0.1);
  }

  public void stop() {
    shootermotor.set(0);
    intake.set(0);
    feeder.set(0);
  }

  public void shoot() {
    shootermotor.set(0.3);
  }

  public void feed(){
    feeder.set(-0.25);
  }
    

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
