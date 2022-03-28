package com.tukjax.cargo.netty.example;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static com.tukjax.cargo.netty.example.Constants.LOCALHOST;
import static com.tukjax.cargo.netty.example.Constants.PUB_PORT;


public class PlainClient {

    public static void main(String[] args) throws IOException,Exception{
        Socket socket = new Socket(LOCALHOST,PUB_PORT);

        while(true){

            try {
                socket.getOutputStream().write((new Date() + "hello world").getBytes(StandardCharsets.UTF_8));
                Thread.sleep(1000);
            }catch (Exception ex){
                ex.printStackTrace();
            }


        }
    }
}
