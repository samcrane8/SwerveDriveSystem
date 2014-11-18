/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import Subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.WiredCatJoystick;

/**
 *
 * @author arxos-lin
 */
public abstract class CommandBase extends Command{
    
    public static OI oi;
    
    public static Subsystem driveSubsystem = new DriveSubsystem();
    
    public static WiredCatJoystick jsdriver = new WiredCatJoystick(
            RobotMap.JSDRIVER_ADDRESS);
    
    public static void init(){
        oi = new OI();
        jsdriver.a.toggleWhenPressed(new CrabDriveCommand());
    }
    
    public CommandBase(String name){
        super(name);
    }
    
    public CommandBase(){
        super();
    }
}
