// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private static class Config{
    public static final int kArmMotorID = 7;
    public static final double kAnglePerTick = 8;
  }
  
  private CANSparkMax m_armMotor = new CANSparkMax(Config.kArmMotorID, MotorType.kBrushless);
  private double m_ticks;
  public Arm() {
   //m_armMotor.setInverted(true);
  }
  public double getEncoderTicks(){
    return m_armMotor.getEncoder().getPosition();
  }
  public void setEncoderTicks(double ticks){
    m_ticks = ticks;
  }
  public double getTicks(){
    return m_ticks;
  }
  public void setSpeed(double speed){
    m_armMotor.set(speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
