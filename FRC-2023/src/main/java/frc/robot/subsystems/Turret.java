// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
  /** Creates a new Turret. */
  private static final int baseServoPort = 1;
  private static final int jankServoPort = 0;

  private Servo baseServo = new Servo(baseServoPort);
  private Servo jankServo = new Servo(jankServoPort);

  // private Joystick m_joystick;

  public Turret() {
    // m_joystick = joystick;
  }

  public void setBaseAngle(double angle){
    baseServo.set(angle); // this uses the 0-1 servo thing, not the angle (pls don't put in like pi/3 or 60)
  }

  public void setRotationAngle(double angle){
    // this for the jank one cuz i didnt want to name it "setJankAngle"
    jankServo.set(angle);
  }
  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
