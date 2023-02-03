// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class EncoderTest extends CommandBase {

  private Elevator m_elevator; 
  private double m_encoderPositionUp;
  private double m_encoderPositionDown;
  private boolean goneUp;

  /** Creates a new EncoderTest. */
  public EncoderTest(Elevator elevator) {
    m_elevator = elevator;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_encoderPositionUp = 0;
    m_encoderPositionDown = 0;
    m_elevator.resetEncoderTicks();
    goneUp = false;
    if (m_elevator.getLowerLimit()) m_elevator.setMotor(-0.7);
    else m_elevator.setMotor(0);
    SmartDashboard.putNumber("Encoder Position", m_encoderPositionUp);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (m_elevator.getUpperLimit() && goneUp == false) m_elevator.setMotor(0.7);
    else if (!m_elevator.getUpperLimit() && goneUp == false) {
      goneUp = true;
      m_encoderPositionUp = m_elevator.getEncoderTicks();
      m_elevator.resetEncoderTicks();
    }
    else if (m_elevator.getLowerLimit() && goneUp == true) m_elevator.setMotor(-0.7); 
    else System.out.println("Debugging time, suffer!!!");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_encoderPositionDown = m_elevator.getEncoderTicks();
    m_elevator.resetEncoderTicks();
    m_elevator.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !m_elevator.getLowerLimit();
  }
}
