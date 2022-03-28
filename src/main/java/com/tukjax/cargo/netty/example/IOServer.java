package com.tukjax.cargo.netty.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static com.tukjax.cargo.netty.example.Constants.PUB_PORT;

public class IOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PUB_PORT);
        new Thread(()->{

            while(true){
                try {
                  Socket socket = serverSocket.accept();

                  new Thread(()->{
                      try{
                          int len ;
                          byte[] data = new byte[1024];
                          InputStream inputStream = socket.getInputStream();
                          while((len = inputStream.read(data) )!= -1){
                              System.out.println(new String(data,0,len));
                          }
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                  }).start();
                }catch (Exception ex){
                    ex.printStackTrace();
                };
            }

        }).start();

    }
}
