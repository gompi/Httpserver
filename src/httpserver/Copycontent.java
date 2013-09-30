/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Alex
 */
public class Copycontent {
      private static void copy(final InputStream input, final OutputStream output) throws IOException {
        final byte[] buffer = new byte[1024];
        while (true) {
            int bytesRead = input.read(buffer);
            if (bytesRead == -1) { break; }
            output.write(buffer, 0, bytesRead);
        }
    }
}
