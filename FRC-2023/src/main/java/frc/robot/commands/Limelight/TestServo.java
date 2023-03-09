// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimelightTestTurret;

public class TestServo extends CommandBase {

  private Timer m_timer = new Timer();
  private LimelightTestTurret m_turret;
 // private Joystick m_joystick;
  
  /** Creates a new TestServo. */
  public TestServo(LimelightTestTurret turret) {

    m_turret = turret;
   // m_joystick = joystick;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.start(); 
    m_timer.reset();
    SmartDashboard.putNumber("Test Base Servo", 0);
    SmartDashboard.putNumber("Test Jank Servo", 0);
    //m_turret.setBaseAngle(0);
    //m_turret.setRotationAngle(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if (m_timer.hasElapsed(1)) m_turret.setRotationAngle(1);
    m_turret.setBaseAngle(SmartDashboard.getNumber("Test Base Servo", 0));
    m_turret.setRotationAngle(SmartDashboard.getNumber("Test Jank Servo", 0));
   
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_turret.setBaseAngle(0);
    m_turret.setRotationAngle(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
