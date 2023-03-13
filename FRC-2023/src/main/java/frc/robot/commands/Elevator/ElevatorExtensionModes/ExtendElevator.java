// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Elevator.ElevatorExtensionModes;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class ExtendElevator extends CommandBase {

  private static final class Config{
    // public static final double kSpeed = 0.5;
    public static final double kP = 0.0125;
    public static final double kI = 0;
    public static final double kD = 0;
  }

  private Elevator m_elevator;
  private PIDController m_controller = new PIDController(Config.kP, Config.kI, Config.kD);

  private double m_setpoint;
  private double m_encoderTicks;
  private double m_speed;
  
  /** Creates a new HalfExtensionElevator. */
  public ExtendElevator(Elevator elevator, double angle) {
    m_elevator = elevator;
    m_setpoint = angle; //NOTE, this is in encoder ticks (ideally a fracion of max encoder ticks)
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
    m_speed = m_controller.calculate(m_encoderTicks, m_setpoint);
    if (m_speed < -0.5) m_speed = -0.5;
    SmartDashboard.putNumber("Calculated Speed", m_speed);

    m_elevator.setMotor(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevator.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
