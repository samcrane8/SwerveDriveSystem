/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.ServerSocketConnection;
import javax.microedition.io.SocketConnection;

public class DebuggingServer implements Runnable {
  
  private static DebuggingServer instance_;
  Thread serverThread = new Thread(this);
  private int listenPort_;
  private Vector connections_;
  double lastHeartbeatTime_ = -1;
  private boolean listening_ = true;
  
  private Vector sendData = new Vector();

  public static DebuggingServer getInstance() {
      if (instance_ == null) {
          instance_ = new DebuggingServer();
      }
      return instance_;
  }
  
  public void addDebugData(DebuggingPackage dp){
      sendData.addElement(dp);
  }
  
  public void start() {
      serverThread.start();
  }
  
  public void stop() {
      listening_  = false;
  }
    
  private DebuggingServer() {
    this(1180);
  }

  private DebuggingServer(int port) {
    listenPort_ = port;
    connections_ = new Vector();
  }
  
  public boolean hasClientConnection() {
    return lastHeartbeatTime_ > 0 && (Timer.getFPGATimestamp() - lastHeartbeatTime_) < 3.0; 
  }
  
  public void setPort(int port) {
    listenPort_ = port;
  }

  public void reset(){
      
  }
  
  // This class handles incoming TCP connections
  private class VisionServerConnectionHandler implements Runnable {

    SocketConnection connection;

    public VisionServerConnectionHandler(SocketConnection c) {
      connection = c;
    }

    public void run() {
      try {
        OutputStream os = connection.openOutputStream();

        int ch = 0;
        byte[] b = new byte[1024];
        double timeout = 10.0;
        double lastHeartbeat = Timer.getFPGATimestamp();
        DebuggingServer.this.lastHeartbeatTime_ = lastHeartbeat;
        Vector s_d = DebuggingServer.instance_.sendData; 
        while (Timer.getFPGATimestamp() < lastHeartbeat + timeout) {
          boolean gotData = false;
          while (!s_d.isEmpty()) {
            os.write(((DebuggingPackage)s_d.elementAt(0)).getVal());
            s_d.removeElementAt(0);
          }

          try {
            Thread.sleep(50); // sleep a bit
          } catch (InterruptedException ex) {
            System.out.println("Thread sleep failed.");
          }
        }
        os.close();
        connection.close();

      } catch (IOException e) {
      }
    }
  }

  // run() to implement Runnable
  // This method listens for incoming connections and spawns new
  // VisionServerConnectionHandlers to handle them
  public void run() {
    ServerSocketConnection s = null;
    try {
      s = (ServerSocketConnection) Connector.open("serversocket://:" + listenPort_);
      while (listening_) {
        SocketConnection connection = (SocketConnection) s.acceptAndOpen();
        Thread t = new Thread(new DebuggingServer.VisionServerConnectionHandler(connection));
        t.start();
        connections_.addElement(connection);
        try {
          Thread.sleep(100);
        } catch (InterruptedException ex) {
          System.out.println("Thread sleep failed.");
        }
      }
    } catch (IOException e) {
      System.out.println("Socket failure.");
      e.printStackTrace();
    }
  }
}
