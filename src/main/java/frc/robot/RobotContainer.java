package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {

	private final XboxController controller;
	private final DriveSubsystem<?> driveSubsystem;
	private final DriveCommand driveCommand;

	public RobotContainer() {
		controller = new XboxController(0);
		driveSubsystem = new DriveSubsystem<WPI_TalonFX>(3, 1, 0, 2, id -> new WPI_TalonFX(id));
		driveCommand = new DriveCommand(driveSubsystem, controller);
	}

	public void start() {
		// Run command forever
		CommandScheduler.getInstance().schedule(driveCommand.perpetually());
	}
}
