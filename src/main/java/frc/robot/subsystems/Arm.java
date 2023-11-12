// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.opencv.ml.SVM;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/*

  - Arm subsystem has two Falcon motors and one CTRE cancoder

  - The cancoder should be in absolute mode

  - When the robot is turned on, the robot should get it's initial position using the 
    cancoder

 */



public class Arm extends SubsystemBase {
  TalonFX angularArmTalonFx = new TalonFX(0);
    // TODO: encoder
    CANCoder positionCanCoder = new CANCoder(0);
    PIDController angleArmController = new PIDController(0, 0, 0);
  /** Creates a new Arm. */
  public Arm() {
  positionCanCoder.setPositionToAbsolute();
  }

  public void control(double theta) {
    // theta is in degrees
    // TODO: uses the PID controller and the encoder to move the subsystem to angle theta
    //theta = positionCanCoder.getAbsolutePosition();
    //angularArmTalonFx.set(angleArmController.calculate(positionCanCoder.getAbsolutePosition()), theta);
    angularArmTalonFx.set(ControlMode.PercentOutput, angleArmController.calculate(positionCanCoder.getAbsolutePosition(), theta));
  
    //angleArmController.calculate(theta);
  }
  public void controlVelocity(double velocity){
  angularArmTalonFx.set(ControlMode.Velocity, angleArmController.calculate(positionCanCoder.getVelocity(), velocity));

  }
  public double getAngle() {
    // TODO: return current arm angle in degrees
    return positionCanCoder.getAbsolutePosition();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // TODO: log the current arm angle to smartdashboard
    SmartDashboard.putNumber("arm position : ", getAngle());

  }
}
