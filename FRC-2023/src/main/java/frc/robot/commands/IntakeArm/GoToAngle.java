// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeArm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class GoToAngle extends CommandBase {
  /** Creates a new GoToAngle. */

  private static final class Config{
    public static final double kP = 0.1;
  }

  private Arm m_arm;

  private double setpoint = 10;
  private double initialTicks;
  
  public GoToAngle(Arm arm) {
      
    m_arm = arm;
  
    addRequirements(m_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initialTicks = m_arm.getEncoderTicks();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_arm.setSpeed(Config.kP*(setpoint - m_arm.getEncoderTicks()));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_arm.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
