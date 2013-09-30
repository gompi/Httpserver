/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class TestSocketController {

    public static void main(String[] args) {
        try {
            ServerSocket welcomeSocket = new ServerSocket(6789, 5);
            Socket connectionSocket;
            while (true) {
                connectionSocket = welcomeSocket.accept();
                SocketController sc = new SocketController(connectionSocket);
                sc.doIt();
            }
        } catch (SocketException ex) {
            System.err.println("Connection closed" + ex);
        } catch (IOException ex) {

            Logger.getLogger(TestSocketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}