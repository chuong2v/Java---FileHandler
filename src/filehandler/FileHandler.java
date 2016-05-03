/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author chuon
 */
public class FileHandler {

    private final Socket socket;

    public FileHandler(Socket socket) {
        this.socket = socket;
    }

    public void get(String filePath) throws IOException {
        byte[] aByte = new byte[1];
        int bytesRead;

        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        if (inputStream != null) {
            FileOutputStream fos = null;
            BufferedOutputStream bos = null;
            fos = new FileOutputStream(filePath);
            bos = new BufferedOutputStream(fos);
            bytesRead = inputStream.read(aByte, 0, aByte.length);

            do {
                baos.write(aByte);
                bytesRead = inputStream.read(aByte);
            } while (bytesRead != -1);

            bos.write(baos.toByteArray());
            bos.flush();
            bos.close();
        }
    }

    public void send(String fileToSend) throws IOException {
        BufferedOutputStream outToClient = new BufferedOutputStream(socket.getOutputStream());

        if (outToClient != null) {
            File myFile = new File(fileToSend);
            byte[] mybytearray = new byte[(int) myFile.length()];

            FileInputStream fis = null;

            try {
                fis = new FileInputStream(myFile);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.toString());
            }
            BufferedInputStream bis = new BufferedInputStream(fis);

            bis.read(mybytearray, 0, mybytearray.length);
            outToClient.write(mybytearray, 0, mybytearray.length);
            outToClient.flush();
            outToClient.close();
        }
    }
}
