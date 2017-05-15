/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp.send;

import javax.swing.JFrame;

/**
 *
 * @author Olav Rune
 */
public class Main {
    
      public static void main(String[] args) {
          
          UDPsend udpSend = new UDPsend(1111, "localhost");

          GuiFrame gui = new GuiFrame();
           gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
gui.addUDPSendSocket(udpSend);
             gui.pack();
        gui.setVisible(true);
        
        
      }
     
      
    
}
