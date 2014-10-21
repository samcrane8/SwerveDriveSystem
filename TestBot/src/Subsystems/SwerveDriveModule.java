/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subsystems.Modules;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import java.lang.Math;

/**
 *
 * @author arxos-lin
 */
public class SwerveDriveModule {
    
    private final double TAU = Math.PI*2;
    private final int TOTAL_TICKS = 120;
    
    private final double MAX_ACCELERATION = 0;
    private final double MAX_DECELERATION = 0;
    private final double TARGET_SPEED = 0;
    private double error = 0;
    
    private float currentSpeed = 0;
    
    private double time = 0;
    
    private int encoderCount = 0;
    private Encoder encoder;
    private Talon transTalon, rotTalon;
    
    public SwerveDriveModule(int[] encoderPorts, int transTalonPort, int rotTalonPort){
        encoder = new Encoder(encoderPorts[0], encoderPorts[1]);
        transTalon = new Talon(transTalonPort);
        rotTalon = new Talon(rotTalonPort);
    }
    
    public void setEncoderCount(int count){
        encoderCount = count;
    }
    
    public int getEncoderCount(){
        return encoderCount;
    }
    
    /**
     * Given what angle we want for each module,
     * change the power applied by the motor using a
     * PID function.
     * @param angle
     */
    
    private void setError(double angle){
        double currentAngle = ((encoder.get()/TOTAL_TICKS)*TAU);
        double arc1 = 0, arc2 = 0;
        
        if(currentAngle > angle){
            arc1 =  -(currentAngle - angle);
            arc2 = TAU + arc1;
        }else{
            arc1 = angle - currentAngle;
            arc2 = -(TAU - arc1);
        }
        
        if(Math.abs(arc1) > Math.abs(arc2)) error = arc2;
        else error = arc1;
    }
    
    public void setAngle(double angle){
        double start = System.currentTimeMillis();
        
        if(error == 0) setError(angle);

        double acceleration = (TARGET_SPEED - currentSpeed)/time;
        if(acceleration > MAX_ACCELERATION) acceleration = MAX_ACCELERATION;
        if(acceleration < MAX_DECELERATION) acceleration = MAX_DECELERATION;
        currentSpeed += time*acceleration;
        
        time = System.currentTimeMillis() - start;
    }
    
    public void setTransTalon(double speed){
        transTalon.set(speed);
    }
    
    public void setRotTalon(double speed){
        rotTalon.set(speed);
    }
    
    public Talon getTransTalon(){
        return transTalon;
    }
    
    public Talon getRotTalon(){
        return rotTalon;
    }
    
    public Encoder getEncoder(){
        return encoder;
    }
}