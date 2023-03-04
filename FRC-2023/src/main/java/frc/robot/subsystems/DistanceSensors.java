// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DistanceSensors extends SubsystemBase {
  private static final class Config{
    public static final int kAnalogInputChannel = 3;

    public static final int kPingChannel = 1;
    public static final int kEchoChannel = 2;
  }

  //For analog input ultrasonic
  private AnalogInput m_aIUltrasonic = new AnalogInput(Config.kAnalogInputChannel);
  private AnalogPotentiometer m_potentiometer = new AnalogPotentiometer(m_aIUltrasonic);

  //For Ping Response ultrasonic
  private Ultrasonic m_pRUltrasonic = new Ultrasonic(Config.kPingChannel, Config.kEchoChannel);
  //Filters noise from ultrasonic
  private MedianFilter m_filter = new MedianFilter(5);

  /** Creates a new DistanceSensors. */
  public DistanceSensors() {
  }

  public double getRawDistanceInches(){
    return m_pRUltrasonic.getRangeInches();
  }

  public double getDistanceInches(){
    double m_measurement = m_pRUltrasonic.getRangeInches();
    double m_filteredMeasurement = m_filter.calculate(m_measurement);
    return m_filteredMeasurement;
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
