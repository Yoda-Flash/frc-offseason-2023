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
  public static final int k_intakeMontorID = 5;
  public static final double k_intakeSpeed = .4;
  }
  /** Creates a new RollerIntake. */
  private JoystickButton m_intakeIn;
  private JoystickButton m_intakeOut;
  private CANSparkMax m_intakeMotor = new CANSparkMax(Config.k_intakeMontorID, MotorType.kBrushless); 
  public RollerIntake(JoystickButton intakeIn, JoystickButton intakeOut) {
    m_intakeIn = intakeIn;
    m_intakeOut = intakeOut;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
