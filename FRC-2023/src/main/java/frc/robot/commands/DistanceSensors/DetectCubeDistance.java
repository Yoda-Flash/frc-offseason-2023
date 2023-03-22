// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DistanceSensors;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DistanceSensors;
import frc.robot.subsystems.Drivetrain;

public class DetectCubeDistance extends CommandBase {

  private static final class Config{
    public static final double kIntakeDistance = 3;
  }
  private DistanceSensors m_sensors;
  private Drivetrain m_drivetrain;

  /** Creates a new DetectConeDistance. */
  public DetectCubeDistance(Drivetrain drivetrain, DistanceSensors sensors) {
    m_sensors = sensors;
    m_drivetrain = drivetrain;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_sensors.getDistanceCM() >= (Config.kIntakeDistance + 1)) {
      m_drivetrain.getDrive().arcadeDrive(0.4, 0);
    }
    else if (m_sensors.getDistanceCM() <= (Config.kIntakeDistance - 1)){
      m_drivetrain.getDrive().arcadeDrive(-0.4, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_sensors.getDistanceCM() <= (Config.kIntakeDistance + 1) && m_sensors.getDistanceCM() >= (Config.kIntakeDistance - 1);
  }
}