// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RollerIntake extends SubsystemBase {
  public static final class Config{
  public static final int k_intakeMotorID = 5;
  public static final double k_intakeSpeed = .4;
  }
  /** Creates a new RollerIntake. */
  private CANSparkMax m_intakeMotor = new CANSparkMax(Config.k_intakeMotorID, MotorType.kBrushless); 

  public RollerIntake() {
    m_intakeMotor.setInverted(true);
  }

  public void setForward(){
    m_intakeMotor.set(Config.k_intakeSpeed);
  }

  public void setReverse(){
    m_intakeMotor.set(-Config.k_intakeSpeed);
  }

  public void setOff(){
    m_intakeMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
