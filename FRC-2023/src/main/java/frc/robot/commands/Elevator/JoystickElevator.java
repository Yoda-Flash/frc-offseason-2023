// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class JoystickElevator extends CommandBase {
  
  private static final class Config{
    public static final int kLeftStickY = 1;
    public static final double kSpeedMultiplier = 0.7;
  }
  
  /** Creates a new JoystickElevator. */
  private Elevator m_elevator;
  private Joystick m_joystick;

  public JoystickElevator(Elevator elevator, Joystick joystick) {
    m_elevator = elevator;
    m_joystick = joystick;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_elevator);
  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_elevator.setMotor(m_joystick.getRawAxis(Config.kLeftStickY)*Config.kSpeedMultiplier);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevator.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
