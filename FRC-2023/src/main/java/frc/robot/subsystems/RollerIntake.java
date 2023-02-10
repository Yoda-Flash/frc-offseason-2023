// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.time.Instant;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RollerIntake extends SubsystemBase {
  
  private static final class Config{
  public static final int kConeIntakeMotorID = 5;
  public static final int kCubeIntakeMotorID = 6;
  public static final double kIntakeSpeed = 0.4;
  }

  /** Creates a new RollerIntake. */
  private CANSparkMax m_coneIntakeMotor = new CANSparkMax(Config.kConeIntakeMotorID, MotorType.kBrushless); 
  private CANSparkMax m_cubeIntakeMotor = new CANSparkMax(Config.kCubeIntakeMotorID, MotorType.kBrushless);

  public RollerIntake() {
    m_cubeIntakeMotor.setInverted(true);
    m_coneIntakeMotor.setInverted(true);
  }

  public void setConeForward(){
    m_coneIntakeMotor.set(Config.kIntakeSpeed);
  }
  
  public InstantCommand intakeCone(){
    return new InstantCommand(this::setConeForward, this);
  }

  public void setCubeForward(){
    m_cubeIntakeMotor.set(Config.kIntakeSpeed);
  }

  public InstantCommand intakeCube(){
    return new InstantCommand(this::setCubeForward, this);
  }

  public void setConeReverse(){
    m_coneIntakeMotor.set(-Config.kIntakeSpeed);
  }

  public InstantCommand ejectCone(){
    return new InstantCommand(this::setConeReverse, this);
  }

  public void setCubeReverse(){
    m_cubeIntakeMotor.set(-Config.kIntakeSpeed);
  }

  public InstantCommand ejectCube(){
    return new InstantCommand(this::setCubeReverse, this);
  }

  public void setCubeOff(){
    m_cubeIntakeMotor.set(0);
  }

  public InstantCommand turnOffCube(){
    return new InstantCommand(this::setCubeOff, this);
  }

  public void setConeOff(){
    m_coneIntakeMotor.set(0);
  }

  public InstantCommand turnOffCone(){
    return new InstantCommand(this::setConeOff, this);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
