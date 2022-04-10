package com.tukjax.cargo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.tukjax.cargo.netty.example.Constants.PUB_PORT;
import static com.tukjax.cargo.netty.example.Constants.LOCALHOST;

public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootStrap = new Bootstrap();

        NioEventLoopGroup group = new NioEventLoopGroup();
        bootStrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                });
        Channel channel = bootStrap.connect(LOCALHOST,PUB_PORT).channel();
        while (true){
            channel.writeAndFlush(LocalDateTime.now() + ": hello world");
            Thread.sleep(1000l);
        }
    }

}
