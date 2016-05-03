/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandler;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author chuon
 */
public class Client {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    private static final String serverIP = "127.0.0.1";
    private static final int serverPort = 3248;
    private static final String fileOutput = "F:\\test\\out.txt";

    public static void main(String args[]) throws IOException {

        Socket clientSocket = null;

        clientSocket = new Socket(serverIP, serverPort);

        FileHandler fileHandler = new FileHandler(clientSocket);
        fileHandler.get(fileOutput);
    }
}
