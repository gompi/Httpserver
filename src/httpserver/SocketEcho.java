/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Alex
 */
public class SocketEcho implements Runnable{
      private Socket connectionSocket;

    public SocketEcho(Socket connection) {
        connectionSocket = connection;
    }

    public void run()  {
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
       
        
        }
         catch(Exception x){}
    }
}
