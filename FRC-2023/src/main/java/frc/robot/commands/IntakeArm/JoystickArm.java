// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeArm;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class JoystickArm extends CommandBase {
  /** Creates a new JoystickArm. */
  private static final class Config{
    public static final int kRightTrigger = 3;
    public static final int kLeftTrigger = 2;
    public static final double kSpeedMultiplier = 0.3;
  }

  public Arm m_arm;
  public Joystick m_joystick;

  public JoystickArm(Arm arm, Joystick joystick) {
    m_arm = arm;
    m_joystick = joystick;
    addRequirements(m_arm);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_joystick.getRawAxis(Config.kRightTrigger) > 0.05) {
      m_arm.setSpeed(m_joystick.getRawAxis(Config.kRightTrigger)*Config.kSpeedMultiplier);
    } else if (m_joystick.getRawAxis(Config.kLeftTrigger) > 0.05) {
      m_arm.setSpeed(-m_joystick.getRawAxis(Config.kLeftTrigger)*Config.kSpeedMultiplier);
    } else {
      m_arm.setSpeed(0);
    }
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
