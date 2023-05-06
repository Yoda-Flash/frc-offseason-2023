// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous.PathPlanner;

import java.time.chrono.ThaiBuddhistChronology;
import java.util.HashMap;
import java.util.Map;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.commands.FollowPathWithEvents;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.Autonomous.RunIntakeIn;
import frc.robot.commands.Autonomous.RunIntakeOut;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.RollerIntake;

public class TestTwoPieceAuto extends CommandBase {
  private static final class Config{
    public static final double kMaxVelocity = 4;
    public static final double kMaxAccel = 3;
  }

  private RollerIntake m_rollerIntake;
  private PathPlannerTrajectory m_twoPieceHybrid = PathPlanner.loadPath("2 Piece Hybrid Auto", new PathConstraints(Config.kMaxVelocity, Config.kMaxAccel));
  
  private HashMap<String, Command> m_eventMap = new HashMap<>();

  private FollowPathWithEvents m_follow = new FollowPathWithEvents(
    null,
    m_twoPieceHybrid.getMarkers(),
    m_eventMap
);

  /** Creates a new TestTwoPieceAuto. */
  public TestTwoPieceAuto() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_eventMap.put("place1", new RunIntakeOut(m_rollerIntake));
    m_eventMap.put("intake", new RunIntakeIn(m_rollerIntake));
    m_eventMap.put("place2", new RunIntakeOut(m_rollerIntake));
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
