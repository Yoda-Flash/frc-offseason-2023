// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  /** Creates a new Limelight. */

  private Limelight m_limelight = new Limelight();
  
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tX = table.getEntry("tx");
  NetworkTableEntry tY = table.getEntry("ty");
  NetworkTableEntry tA = table.getEntry("ta");
  
  double x = tX.getDouble(0.0);
  double y = tY.getDouble(0.0);
  double area = tA.getDouble(0.0);

  public Limelight() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    SmartDashboard.putNumber("Limelight", x);
    SmartDashboard.putNumber("Limelight", y);
    SmartDashboard.putNumber("Limelight", area);
    
  }
}
