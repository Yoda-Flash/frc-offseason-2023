// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class MecanumDrivetrain extends SubsystemBase {
  /** Creates a new MecanumDrivetrain. */
  private static final class Config{
    public static final int kTopLeftID = 1;
    public static final int kTopRightID = 2;
    public static final int kBottomLeftID = 3;
    public static final int kBottomRightID = 4;
  }
  private WPI_TalonFX m_topLeft  = new WPI_TalonFX(Config.kTopLeftID);
  private WPI_TalonFX m_topRight = new WPI_TalonFX(Config.kTopRightID);
  private WPI_TalonFX m_bottomLeft = new WPI_TalonFX(Config.kBottomLeftID);
  private WPI_TalonFX m_bottomRight = new WPI_TalonFX(Config.kBottomRightID);
  private MecanumDrive m_drive = new MecanumDrive(m_topLeft, m_bottomLeft, m_topRight, m_bottomRight);
  public MecanumDrivetrain() {
    m_topRight.setInverted(true);
    m_bottomRight.setInverted(true);
    
  }
  public MecanumDrive getDrive(){
    return m_drive;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}