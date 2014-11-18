/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 * @author samcrane
 */
public class WiredCatJoystick extends Joystick{
    
    public JoystickButton a;
    public JoystickButton b;
    public JoystickButton x;
    public JoystickButton y;
    
    public WiredCatJoystick(int i){
        super(i);
        a = new JoystickButton(this, RobotMap.JS_A);
        b = new JoystickButton(this, RobotMap.JS_B);
        x = new JoystickButton(this, RobotMap.JS_X);
        y = new JoystickButton(this, RobotMap.JS_Y);
    }
    
}
