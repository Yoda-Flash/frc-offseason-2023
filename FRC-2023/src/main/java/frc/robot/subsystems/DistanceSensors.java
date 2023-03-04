// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DistanceSensors extends SubsystemBase {

  //For analog input ultrasonic
  private AnalogInput m_aIUltrasonic = new AnalogInput(3);
  private AnalogPotentiometer m_potentiometer = new AnalogPotentiometer(m_aIUltrasonic);

  //For Ping Response ultrasonic
  private Ultrasonic m_pRUltrasonic = new Ultrasonic(1, 2);

  /** Creates a new DistanceSensors. */
  public DistanceSensors() {
  }

  public double getDistanceInches(){
    return m_pRUltrasonic.getRangeInches();
  }

  public int getRawAIUltrasonicValue(){
    return m_aIUltrasonic.getValue();
  }
  
  public double getAIUltrasonicVoltage(){
    return m_aIUltrasonic.getVoltage();
  }

  public double getAIScaledValue(){
    return m_potentiometer.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  

  }
}
