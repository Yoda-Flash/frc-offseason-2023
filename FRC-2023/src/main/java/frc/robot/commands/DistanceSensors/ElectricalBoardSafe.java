// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DistanceSensors;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DistanceSensors;

public class ElectricalBoardSafe extends CommandBase {
  private static final class Config{
    public static final double kSafeDistanceInches = 10.0;
    public static final double kSafeDistanceCM = 25.4;
  }

  private DistanceSensors m_sensors;

  /** Creates a new ElectricalBoardSafe. */
  public ElectricalBoardSafe(DistanceSensors sensors) {
    m_sensors = sensors;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_sensors.getDistanceCM() <= Config.kSafeDistanceCM){
      SmartDashboard.putString("Is electrical board safe?", "No!!!Get away now");
    }
    else SmartDashboard.putString("Is electrical board safe?", "Yes");
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
