/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author chuon
 */
public class Server {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    private static final String fileToSend = "F:\\test\\chuong.txt";

    public static void main(String args[]) throws IOException {

//        while (true) {
        ServerSocket welcomeSocket = new ServerSocket(3248);
        Socket connectionSocket = welcomeSocket.accept();

        FileHandler fileHandler = new FileHandler(connectionSocket);
        fileHandler.send(fileToSend);
        connectionSocket.close();

//        }
    }
}
