// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeArm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmWithFeedForward extends CommandBase {

  private static final class Config{
    public static final double kRadiansToTicksMultiplier = 180/Math.PI;
  }
  private Arm m_arm;

  private double m_goalPosition = 10*Config.kRadiansToTicksMultiplier;
  private double m_goalVelocity = 5;
  
  /** Creates a new ArmWithFeedForward. */
  public ArmWithFeedForward(Arm arm) {
    m_arm = arm;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_arm.setFeedforward(m_goalPosition, m_goalVelocity);
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
