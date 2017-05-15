/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp.send;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
 *
 * @author Olav Rune
 */
public class UDPsend {

    private InetAddress HOST;
    private DatagramSocket s;
    private final int PORT;
    private byte[] outByte;

    public UDPsend(int port, String ipAddr) {
        
    this.PORT = port;
    
        try {
            HOST = InetAddress.getByName(ipAddr);
        } catch (UnknownHostException ex) {
            System.out.println("Exeption in generating InetAddress in UDPSend...  n/" + ex.getMessage());
        }
    
        try {
            s = new DatagramSocket();
        } catch (SocketException ex) {
            System.out.println("Exeption in generating DatagramSocket in UDPSend...  n/" + ex.getMessage());
        }
    }

    public boolean sendParam(byte[] bytesToSend) {
        boolean result = false;
        byte[] paramBytes = bytesToSend;
        result = send(paramBytes);
        return result;
    }

    private boolean send(byte[] b) {
        boolean result = false;
      
        DatagramPacket out = new DatagramPacket(b, b.length, HOST, PORT);
  
        try {
            
            s.send(out);
            result = true;
        } catch (IOException ex) {
            System.out.println("Exeption in sending (s.send(out)) in UDPSend...  n/" + ex.getMessage());
        }
        return result;
    }
}
