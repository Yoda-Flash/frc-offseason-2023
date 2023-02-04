// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.List;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PhotonLimelight extends SubsystemBase {

  PhotonCamera camera = new PhotonCamera("limelight-ahs");

  PhotonPipelineResult result = camera.getLatestResult();

  List<PhotonTrackedTarget> targets = result.getTargets();

  PhotonTrackedTarget target = result.getBestTarget();

  boolean hasTargets = result.hasTargets();;

  double yaw = target.getYaw();
  double pitch = target.getPitch();
 
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

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
   
  }
}
