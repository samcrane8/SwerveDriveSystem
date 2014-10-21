/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import edu.wpi.first.wpilibj.templates.OI;
import java.lang.Math;

/**
 *
 * @author arxos-lin
 */
public class CrabDriveCommand extends CommandBase{
    
    public CrabDriveCommand(){
        requires(driveSubsystem);
    }
    
    protected void initialize(){}

    protected void execute(){}

    protected boolean isFinished(){
        return false;
    }

    protected void end(){}

    protected void interrupted(){}
    
}
