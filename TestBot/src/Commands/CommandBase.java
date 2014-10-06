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

/**
 *
 * @author arxos-lin
 */
public abstract class CommandBase extends Command{
    
    public static OI oi;
    
    public static Subsystem driveSubsystem = new DriveSubsystem();
    
    public static void inti(){
        oi = new OI();
    }
    
    public CommandBase(String name){
        super(name);
    }
    
    public CommandBase(){
        super();
    }
}
