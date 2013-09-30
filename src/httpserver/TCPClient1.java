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
public class TCPClient1 {

  
    public static void main(String[] argv) throws IOException, InterruptedException {
        int port = 6789;  //default
        if (argv.length > 0) {
            port = Integer.parseInt(argv[0]);
        }
        Socket clientSocket = new Socket("127.0.0.1", port);
        BufferedReader inFromUser = new BufferedReader(
                new InputStreamReader(System.in));
        PrintStream outToServer = new PrintStream(
                clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        for (int i = 0; i < 100; i++) {
            // String sentence = inFromUser.readLine();
            outToServer.println("gom " + i + " ");
            String modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence);
            Thread.sleep(100);
        }

        clientSocket.close();
    }
}
