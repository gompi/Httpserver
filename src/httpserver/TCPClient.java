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
public class TCPClient {

    public static void main(String args[]) throws Exception {

        int port = 6789;  //default
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        System.out.println("port:" + port);
        BufferedReader inFromUser = new BufferedReader(
                new InputStreamReader(System.in));
        // To server on local host
        Socket clientSocket = new Socket("127.0.0.1", port);
        // To server on other host with IP-address = 42.116.200.42
        //Socket clientSocket = new Socket("42.116.200.42", port);

        PrintStream outToServer = new PrintStream(
                clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));


        String sentence = inFromUser.readLine();
        outToServer.println(sentence);
        String modifiedSentence = inFromServer.readLine();

        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
    }
}
