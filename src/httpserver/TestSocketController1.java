/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class TestSocketController1 {
     public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            try {
                ServerSocket welcomeSocket = new ServerSocket(6789, 5);
                Socket connectionSocket;
                //SocketEcho service;
                while (true) {
                    connectionSocket = welcomeSocket.accept();
                    Runnable service = new SocketEcho(connectionSocket);
                    pool.execute(service); //calls run in SocketIterative class
                }
            } catch (SocketException ex) {
                System.err.println("Connection closed" + ex);
            } catch (IOException ex) {

                Logger.getLogger(TestSocketController1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        pool.shutdown();
    }
}
