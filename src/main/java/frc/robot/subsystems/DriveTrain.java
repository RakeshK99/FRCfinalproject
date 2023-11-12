// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  CANSparkMax frontRightCanSparkMax;
  CANSparkMax bottomRightCanSparkMax;
  CANSparkMax frontLeftCanSparkMax;
  CANSparkMax bottomLeftCanSparkMax;
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    frontRightCanSparkMax = new CANSparkMax(0, MotorType.kBrushless);
    bottomRightCanSparkMax = new CANSparkMax(0, MotorType.kBrushless);
    frontLeftCanSparkMax = new CANSparkMax(0, MotorType.kBrushless);
    bottomLeftCanSparkMax = new CANSparkMax(0, MotorType.kBrushless);
    bottomLeftCanSparkMax.getInverted();
    bottomRightCanSparkMax.getInverted();
    bottomLeftCanSparkMax.follow(frontLeftCanSparkMax, false);
    bottomRightCanSparkMax.follow(frontRightCanSparkMax, false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void getPercentOutput(){
    frontRightCanSparkMax.s
  }
}

