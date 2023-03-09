// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.LimelightTestTurret;

public class TrackTarget extends CommandBase {

  private Limelight m_limelight;
  private LimelightTestTurret m_turret;

  private double basePosition;
  private double jankPosition;
  // added private 1/26/2023

  /** Creates a new TrackTarget. */
  public TrackTarget(Limelight limelight, LimelightTestTurret turret) {

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
    SmartDashboard.putNumber("TX", m_limelight.getTX());
    SmartDashboard.putNumber("TY", m_limelight.getTY());
    SmartDashboard.putNumber("TV", (double)m_limelight.getTV()); // casting
    
    // if (m_limelight.getTV() == 1) {
    //   System.out.println("Get TV == 1");

      if (m_limelight.getTX() > 1.5) {
        //If object is to the right and if servo isn't at maximum right position
        System.out.println("Object to the right");

        if (basePosition > 0.4){
          basePosition -= 0.005;
          m_turret.setBaseAngle(basePosition);
          System.out.println("Move Right");
        }
      }

      else if (m_limelight.getTX() < -1.5){
        System.out.println("Object to the left");

        if (basePosition < 1){
          basePosition += 0.005;
          m_turret.setBaseAngle(basePosition);
          System.out.println("Move Left");
        }
      }

      if (m_limelight.getTY() > 1.5){
        System.out.println("Object above");

        if (jankPosition > 0){
          jankPosition -= 0.005;
          m_turret.setRotationAngle(jankPosition);
          System.out.println("Move Up");
        }
      }
      
      else if (m_limelight.getTY() < -1.5){
        System.out.println("Object below");

        if (jankPosition < 1){
          jankPosition += 0.005;
          m_turret.setRotationAngle(jankPosition);
          System.out.println("Move Down");
        }

      }
    }

  // }

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
