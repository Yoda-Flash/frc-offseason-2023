
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */
  private static final class Config{
    
    private static final int kRightStickX = 2;
    private static final int kLeftStickY = 3;
    private static final double kSpeedMultiplier = 0.7;
    private static final double kTurnMultiplier = 0.7;
  }
  private Drivetrain m_drivetrain;
  private Joystick m_joystick;
  double speed = m_joystick.getRawAxis(Config.kRightStickX)*Config.kSpeedMultiplier;
  double turn = -m_joystick.getRawAxis(Config.kLeftStickY)*Config.kTurnMultiplier;
  
  public ArcadeDrive(Drivetrain drivetrain, Joystick joystick) {
    m_drivetrain = drivetrain;
    m_joystick = joystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.getDrive().arcadeDrive(speed, turn, true);
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.getDrive().arcadeDrive(0,0, true);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
