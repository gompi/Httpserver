/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver;

import java.net.Socket;

/**
 *
 * @author Alex
 */
public interface ServiceInterface extends Runnable {

    public void setSocket(Socket connection);
    
}
