package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.music.Orchestra;

import edu.wpi.first.wpilibj2.command.PrintCommand;

public class Music {
    private WPI_TalonFX musician = new WPI_TalonFX(1);
    private Orchestra orch;

    public Music() {
        orch = new Orchestra();
        orch.addInstrument(musician);
        orch.loadMusic("output.chrp");
    }

    public void play() {
        orch.play();
    }
}
