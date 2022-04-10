package com.tukjax.cargo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.channels.ServerSocketChannel;

import static com.tukjax.cargo.netty.example.Constants.PUB_PORT;

public class NettyServer {

    public static void main(String[] args) {
        ServerBootstrap serverBootStrap = new ServerBootstrap();

        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootStrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
                                System.out.println(msg);
                            }
                        });
                    }
                });
        retrzBind(serverBootStrap,  80);
    }

    private static void retrzBind(ServerBootstrap serverBootstrap, int port){
        serverBootstrap.bind(port).addListener((RESULT)->{
            if(RESULT.isSuccess()){
                System.out.println(String.format("bind success port is %s",port));
            }else{
                System.out.println(String.format("bind fail port is %s",port));
                retrzBind(serverBootstrap, port+1);
            }
        });

    }

}
