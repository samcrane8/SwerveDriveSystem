/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subsystems;
import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.command.Subsystem;
import java.util.Hashtable;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author arxos-lin
 */
public class DriveSubsystem extends Subsystem{
    
    
    public final static String topLeft = "TOP_LEFT";
    public final static String botLeft = "BOT_LEFT";
    public final static String topRight = "TOP_RIGHT";
    public final static String botRight = "BOT_RIGHT";
    
    public static Hashtable swerveModules = new Hashtable();
    
    public DriveSubsystem(){
        swerveModules.put(topLeft, new SwerveDriveModule(
                RobotMap.TOP_LEFT_ENCODER, RobotMap.TOP_LEFT_MOTOR_TRAN, RobotMap.TOP_LEFT_MOTOR_ROT));
        swerveModules.put(botLeft, new SwerveDriveModule(
                RobotMap.BOT_LEFT_ENCODER, RobotMap.BOT_LEFT_MOTOR_TRAN, RobotMap.BOT_LEFT_MOTOR_ROT));
        swerveModules.put(topRight, new SwerveDriveModule(
                RobotMap.TOP_RIGHT_ENCODER, RobotMap.TOP_RIGHT_MOTOR_TRAN, RobotMap.TOP_RIGHT_MOTOR_ROT));
        swerveModules.put(botRight, new SwerveDriveModule(
                RobotMap.BOT_RIGHT_ENCODER, RobotMap.BOT_RIGHT_MOTOR_TRAN, RobotMap.BOT_RIGHT_MOTOR_ROT));
    }
    
    protected void initDefaultCommand() {
        this.setDefaultCommand(null);
    }
    
    /*
    public void setEncoderCount(SwerveDriveModule module){
        int rawCount =  module.getEncoder().get() % TOTAL_TICKS;
        if(rawCount < 0) module.setEncoderCount(TOTAL_TICKS + rawCount);
        module.setEncoderCount(rawCount);
    }*/
    
    public void setAngleCount(SwerveDriveModule module){}
     
}
