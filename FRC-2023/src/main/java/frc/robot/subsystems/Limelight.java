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

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");
  NetworkTableEntry tv = table.getEntry("tv");

  int validTarget = (int) tv.getInteger(0);
  double x;
  double y;
  double area;

  public Limelight() {
  
  }

  public int getTV(){
    return validTarget;
  }

  public double getTX(){
    return x;
  }

  public double getTY(){
    return y;
  }

  public double getTA(){
    return area;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  x = tx.getDouble(0.0);
  y = ty.getDouble(0.0);
  area = ta.getDouble(0.0);

    SmartDashboard.putNumber("Limelight", x);
    SmartDashboard.putNumber("Limelight", y);
    SmartDashboard.putNumber("Limelight", area);
    
  }
}
