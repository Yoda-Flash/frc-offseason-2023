// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */

  private static final class Config{

    public static final int kMotorID = 5;

  }

  private CANSparkMax m_motor = new CANSparkMax(Config.kMotorID, MotorType.kBrushless);
  private DigitalInput m_topSwitch = new DigitalInput(0);
  private DigitalInput m_bottomSwitch = new DigitalInput(1);

  double m_encoderPositionDown;
  double m_encoderPositionUp;

  public Elevator() {

  }

  public void setMotor(double speed){
    if (!m_topSwitch.get() && speed > 0) m_motor.set(0);
    else if (!m_bottomSwitch.get() && speed < 0) m_motor.set(0);
    else m_motor.set(speed);

  }

  public boolean getLowerLimit(){
    return m_bottomSwitch.get();
  }

  public boolean getUpperLimit(){
    return m_topSwitch.get();
  }

  public double getEncoderTicks(){
    return m_motor.getEncoder().getPosition();
  }

  public void resetEncoderTicks(){
    m_motor.getEncoder().setPosition(0);
  }

  public void setEncoderPositionUp(double MaxPosition){
   m_encoderPositionUp = MaxPosition;
  }

  public void setEncoderPositionDown(double MinPosition){
    m_encoderPositionDown = MinPosition;
  }

  public double getEncoderPositionUp(){
    return m_encoderPositionUp;
  }

  public double getEncoderPositionDown(){
    return m_encoderPositionDown;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
