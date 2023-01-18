
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MecanumDrivetrain;
public class MecanumDrive extends CommandBase {
  private static final class Config{
    private static final int kLeftStickX = 0;
    private static final int kLeftStickY = 1;
    private static final int kRightStickX = 2;
    //private static final int kRightStickY = 3;
    private static final double kXSpeedMultiplier = 0.7;
    private static final double kYSpeedMultiplier = 0.7;
    private static final double kZRotationMultiplier = 0.7;
  }
  private MecanumDrivetrain m_drivetrain;
  private Joystick m_joystick;
  double xSpeed = m_joystick.getRawAxis(Config.kLeftStickX)*Config.kXSpeedMultiplier;
  double ySpeed = m_joystick.getRawAxis(Config.kLeftStickY)*Config.kYSpeedMultiplier;
  double zRotation = m_joystick.getRawAxis(Config.kRightStickX)*Config.kZRotationMultiplier;
  /** Creates a new MecanumDrive. */
  public MecanumDrive(MecanumDrivetrain drivetrain, Joystick joystick) {
    m_drivetrain = drivetrain;
    m_joystick = joystick;
    // Use addRequirements() here to declare subsystem dependencies.
    //Why is this needed?
    addRequirements(m_drivetrain);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.getDrive().driveCartesian(xSpeed, ySpeed, zRotation, null);
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
