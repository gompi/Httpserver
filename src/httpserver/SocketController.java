/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Alex
 */
public class SocketController implements Runnable {

    private int port;
    private Socket connectionSocket;
    private int noTCP;

    /**
     *
     * @param connection
     */
    public SocketController() {
    }

    public SocketController(Socket connection) {
        connectionSocket = connection;
    }

    public SocketController(int port, int noTCP) {
        this.port = 6789;
        this.noTCP = 5;
    }

    public void run() {
        try {
            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(connectionSocket.getInputStream()));
            PrintStream outToClient = new PrintStream(
                    connectionSocket.getOutputStream());
            String clientSentence = inFromClient.readLine();
            while (clientSentence != null) {
                System.out.println("FROM CLIENT: " + clientSentence);
                String capitalizedSentence = clientSentence.toUpperCase();
                outToClient.println(capitalizedSentence);
                clientSentence = inFromClient.readLine();
            }
        } catch (Exception e) {
        }
    }

    /**
     *
     */
    public void doIt() {
        Runnable service = new SocketEcho(connectionSocket);
        Thread thread1 = new Thread(service);
        thread1.run();
    }

    public void doRead() {
        ServiceRead s = new ServiceRead(connectionSocket);
        Thread thread1 = new Thread((Runnable) s);
        thread1.run();
    }

    public void doWrite() {
    }
}
