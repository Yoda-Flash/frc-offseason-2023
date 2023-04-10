// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */

  private static final class Config{
    public static final double kElevatorEncoderTopLimit = -55.65;
    public static final int kMotorID = 5;

  }

  private CANSparkMax m_elevatorMotor = new CANSparkMax(Config.kMotorID, MotorType.kBrushless);
  private DigitalInput m_bottomSwitch = new DigitalInput(1);

  public Elevator() {
    SmartDashboard.putData("Elevator/Cancel", new InstantCommand(() -> System.out.println("Canceling commands on Elevator...."), this));
  }

  public void setMotor(double speed){
    if (m_bottomSwitch.get() && speed > 0) m_elevatorMotor.set(0);
    else if (getEncoderTicks() < Config.kElevatorEncoderTopLimit && speed < 0) m_elevatorMotor.set(0);
    else m_elevatorMotor.set(speed);
  }

  public boolean getLowerLimit(){
    return m_bottomSwitch.get();
  }

  public double getEncoderTicks(){
    return m_elevatorMotor.getEncoder().getPosition();
  }

  public void resetEncoderTicks(){
    m_elevatorMotor.getEncoder().setPosition(0);
  }

  public double getEncoderLimitUp(){
    return Config.kElevatorEncoderTopLimit;
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Elevator Limit Switch", getLowerLimit());
    SmartDashboard.putNumber("Elevator Encoder Ticcks", getEncoderTicks());

    // This method will be called once per scheduler run
  }
}
