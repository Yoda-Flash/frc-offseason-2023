// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Elevator.ElevatorExtensionModes;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class OneThirdExtensionElevator extends CommandBase {

  private static final class Config{
    public static final double kSpeed = 0.5;
    public static final double kP = 0.05;
    public static final double kI = 0;
    public static final double kD = 0;
  }

  private Elevator m_elevator;
  private PIDController m_controller = new PIDController(Config.kP, Config.kI, Config.kD);
  
  private double m_setpoint = m_elevator.getEncoderPositionUp()/3;
  private double m_encoderTicks;
  
  /** Creates a new OneThirdExtensionElevator. */
  public OneThirdExtensionElevator(Elevator elevator) {
    m_elevator = elevator;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_encoderTicks = m_elevator.getEncoderTicks();

    m_elevator.setMotor(m_controller.calculate(m_encoderTicks, m_setpoint));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevator.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_setpoint - m_encoderTicks <= 10;
  }
}
