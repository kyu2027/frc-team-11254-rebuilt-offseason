package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Timer;


public class ShootWithDelay extends Command {
    private Shooter shooter;
    private Timer timer;

    public ShootWithDelay(Shooter shooter) {
        this.shooter = shooter;
        this.timer = new Timer();
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        shooter.shoot();
        if(timer.get() > 0.5) {
            shooter.feed();
        }
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(20.0); // Adjust the delay time as needed
    }
}