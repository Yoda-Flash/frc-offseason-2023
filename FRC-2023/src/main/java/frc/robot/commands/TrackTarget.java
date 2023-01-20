// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;

public class TrackTarget extends CommandBase {

  private Limelight m_limelight;
  private Turret m_turret;

  /** Creates a new TrackTarget. */
  public TrackTarget(Limelight limelight, Turret turret) {

    m_limelight = limelight;
    m_turret = turret;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (m_limelight.getTV() == 1) {
      if (m_limelight.getTX() > 0.05) {
        //If object is to the right and if servo isn't at maximum right position
        if (m_turret.getBaseAngle() < 1){
          m_turret.setBaseAngle(m_turret.getBaseAngle() + 0.01);
        }
      }

      else if (m_limelight.getTX() < -0.05){
        if (m_turret.getBaseAngle() > 0){
          m_turret.setBaseAngle(m_turret.getBaseAngle() - 0.01);
        }
      }

      else if (m_limelight.getTY() > 0.05){
        if (m_turret.getRotationAngle() < 1){
          m_turret.setRotationAngle(m_turret.getRotationAngle() + 0.01);
        }
      }
      
      else if (m_limelight.getTY() < -0.05){
        if (m_turret.getRotationAngle() > 0){
          m_turret.setRotationAngle(m_turret.getRotationAngle() - 0.01);
        }

      }
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
