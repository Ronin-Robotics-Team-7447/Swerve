// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  public static final double kMaxSpeed = 3.0; // 3 meters per second
  public static final double kMaxAngularSpeed = Math.PI; // 1/2 rotation per second

  // x and y values represent the dimension of the robot (half of the dimention)
  // Set the module of swerve at its location in relation to the center of the robot
  private final Translation2d m_frontLeftLocation = new Translation2d(Constants.Dimension_Q2_X, Constants.Dimension_Q2_Y);
  private final Translation2d m_frontRightLocation = new Translation2d(Constants.Dimension_Q1_X, Constants.Dimension_Q1_Y);
  private final Translation2d m_backLeftLocation = new Translation2d(Constants.Dimension_Q3_X, Constants.Dimension_Q3_X);
  private final Translation2d m_backRightLocation = new Translation2d(Constants.Dimension_Q4_X, Constants.Dimension_Q4_X);

  //ERROR: 2 ENCODER NEEDED ON EACH Module
  private final SwerveModule m_frontLeft = new SwerveModule(1, 2, 0, 1, 2, 3);
  private final SwerveModule m_frontRight = new SwerveModule(3, 4, 4, 5, 6, 7);
  private final SwerveModule m_backLeft = new SwerveModule(5, 6, 8, 9, 10, 11);
  private final SwerveModule m_backRight = new SwerveModule(7, 8, 12, 13, 14, 15);

  //QUESTION: WhAT DOES GYRO DO?
  private final AnalogGyro m_gyro = new AnalogGyro(0);

  //REREAD DOC + MRJOHNSON
  private final SwerveDriveKinematics m_kinematics =
      new SwerveDriveKinematics(
          m_frontLeftLocation, m_frontRightLocation, m_backLeftLocation, m_backRightLocation);

  //REREAD DOC + MRJOHNSON
    private final SwerveDriveOdometry m_odometry =
      new SwerveDriveOdometry(
          m_kinematics,
          m_gyro.getRotation2d(),
          new SwerveModulePosition[] {
            m_frontLeft.getPosition(),
            m_frontRight.getPosition(),
            m_backLeft.getPosition(),
            m_backRight.getPosition()
          });

  

  /** Creates a new Drivetrain. */
  public Drivetrain() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
