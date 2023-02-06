// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.List;

import org.photonvision.PhotonCamera;
import org.photonvision.common.hardware.VisionLEDMode;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PhotonLimelight extends SubsystemBase {

  private PhotonCamera camera = new PhotonCamera("limelight-ahs");

  private PhotonPipelineResult result;

  private List<PhotonTrackedTarget> targets; 

  private PhotonTrackedTarget target; 

  private boolean hasTargets; 

  private double yaw; 
  private double pitch; 

  /** Creates a new PhotonLimelight. */
  public PhotonLimelight() {}

  public boolean hasTargets(){
    return hasTargets;
  }

  public double getPhotonYaw(){
    return yaw;
  }

  public double getPhotonPitch(){
    return pitch;
  }

  public void turnOn(){
    camera.setLED(VisionLEDMode.kOn);
  }

  public void turnOff(){
    camera.setLED(VisionLEDMode.kOff);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
   result = camera.getLatestResult();
   targets = result.getTargets();
   target = result.getBestTarget();
   hasTargets = result.hasTargets();
   yaw = target.getYaw();
   pitch = target.getPitch();

  }
}
