// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PhotonLimelight;
import frc.robot.subsystems.Turret;

public class PhotonTrackTarget extends CommandBase {

  private PhotonLimelight m_limelight;
  private Turret m_turret;

  private double basePosition;
  private double jankPosition;

  /** Creates a new PhotonTrackTarget. */
  public PhotonTrackTarget(PhotonLimelight limelight, Turret turret) {
    m_limelight = limelight;
    m_turret = turret;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_limelight.turnOn();

    basePosition = 0.7;
    jankPosition = 0.6;
    
    m_turret.setBaseAngle(basePosition);
    m_turret.setRotationAngle(jankPosition);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("Base Servo", basePosition);
    SmartDashboard.putNumber("Jank Servo", jankPosition);
    SmartDashboard.putNumber("Pitch", m_limelight.getPhotonPitch());
    SmartDashboard.putNumber("Yaw", m_limelight.getPhotonYaw());
    SmartDashboard.putBoolean("Has Target?", m_limelight.hasTargets()); 
    
    if (m_limelight.hasTargets() == true) {
    
      if (m_limelight.getPhotonPitch() > 1.5) {
        //If object is to the right and if servo isn't at maximum right position
        System.out.println("Object to the right");

        if (basePosition > 0.4){
          basePosition -= 0.005;
          m_turret.setBaseAngle(basePosition);
          System.out.println("Move Right");
        }
      }

      else if (m_limelight.getPhotonPitch() < -1.5){
        System.out.println("Object to the left");

        if (basePosition < 1){
          basePosition += 0.005;
          m_turret.setBaseAngle(basePosition);
          System.out.println("Move Left");
        }
      }

      if (m_limelight.getPhotonYaw() > 1.5){
        System.out.println("Object above");

        if (jankPosition > 0){
          jankPosition -= 0.005;
          m_turret.setRotationAngle(jankPosition);
          System.out.println("Move Up");
        }
      }
      
      else if (m_limelight.getPhotonYaw() < -1.5){
        System.out.println("Object below");

        if (jankPosition < 1){
          jankPosition += 0.005;
          m_turret.setRotationAngle(jankPosition);
          System.out.println("Move Down");
        }

      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_limelight.turnOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
