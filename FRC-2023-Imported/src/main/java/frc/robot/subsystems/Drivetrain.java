// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  private static final class Config{

    public static final int kLeftPrimaryID = 1;
    public static final int kRightPrimaryID = 2;
    public static final int kLeftSecondaryID = 3;
    public static final int kRightSecondaryID = 4;
  }

  private WPI_TalonFX m_leftPrimary = new WPI_TalonFX(Config.kLeftPrimaryID);
  private WPI_TalonFX m_rightPrimary = new WPI_TalonFX(Config.kRightPrimaryID);
  private WPI_TalonFX m_leftSecondary = new WPI_TalonFX(Config.kLeftSecondaryID);
  private WPI_TalonFX m_rightSecondary = new WPI_TalonFX(Config.kRightSecondaryID);

  private DifferentialDrive m_drive = new DifferentialDrive(m_leftPrimary, m_rightPrimary);

  
  public Drivetrain() {
    m_leftSecondary.follow(m_leftPrimary);
    m_rightSecondary.follow(m_rightPrimary);

    m_rightPrimary.setInverted(false);
    m_rightSecondary.setInverted(false);
  }

  public DifferentialDrive getDrive(){
    return m_drive;
  }
 
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
