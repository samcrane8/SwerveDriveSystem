/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author arxos-lin
 */

//This will hold all port values of the robot
public class RobotMap {
    
    //speed controller port values
    public static final int TOP_LEFT_MOTOR_TRAN = 0;
    public static final int BOT_LEFT_MOTOR_TRAN = 0;
    public static final int TOP_RIGHT_MOTOR_TRAN = 0;
    public static final int BOT_RIGHT_MOTOR_TRAN = 0;
    
    public static final int TOP_LEFT_MOTOR_ROT = 0;
    public static final int BOT_LEFT_MOTOR_ROT = 0;
    public static final int TOP_RIGHT_MOTOR_ROT = 0;
    public static final int BOT_RIGHT_MOTOR_ROT = 0;
    
    //encoder port values; 1st index is A, 2nd is B
    public static final int[] TOP_LEFT_ENCODER = {0,0};
    public static final int[] BOT_LEFT_ENCODER = {0,0};
    public static final int[] TOP_RIGHT_ENCODER = {0,0};
    public static final int[] BOT_RIGHT_ENCODER = {0,0};
    
    public static final int JS_A = 999;
    public static final int JS_B = 999;
    public static final int JS_X = 999;
    public static final int JS_Y = 999;
    
    public static final int JSDRIVER_ADDRESS = 1;
    
}
