// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DistanceSensors extends SubsystemBase {

  private AnalogInput m_ultrasonic = new AnalogInput(3);
  private AnalogPotentiometer m_potentiometer = new AnalogPotentiometer(m_ultrasonic);

  /** Creates a new DistanceSensors. */
  public DistanceSensors() {

  }

  public int getRawUltrasonicValue(){
    return m_ultrasonic.getValue();
  }
  
  public double getUltrasonicVoltage(){
    return m_ultrasonic.getVoltage();
  }

  public double getScaledValue(){
    return m_potentiometer.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  

  }
}
