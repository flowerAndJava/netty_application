package com.haopt.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;

public class TcpServer {
    private final int port;

    public TcpServer(int port) {
        this.port = port;
    }

    public void init() {
        NioEventLoopGroup boss = new NioEventLoopGroup();//主线程组
        NioEventLoopGroup work = new NioEventLoopGroup();//工作线程组
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();//引导对象
            bootstrap.group(boss, work);//配置工作线程组
            bootstrap.channel(NioServerSocketChannel.class);//配置为NIO的socket通道
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel ch) throws Exception {//绑定通道参数
                    ch.pipeline().addLast("logging", new LoggingHandler("DEBUG"));//设置log监听器，并且日志级别为debug，方便观察运行流程
                    ch.pipeline().addLast("encode", new EncoderHandler());//编码器。发送消息时候用过
                    ch.pipeline().addLast("decode", new DecoderHandler());//解码器，接收消息时候用
                    ch.pipeline().addLast("handler", new TcpServerHandler());//业务处理类，最终的消息会在这个handler中进行业务处理
                }
            });
            //使用了Future来启动线程，并绑定了端口
            ChannelFuture future = bootstrap.bind(port).sync();
            //以异步的方式关闭端口
            future.channel().closeFuture().sync();
        } catch (Exception e) {
        } finally {
            work.shutdownGracefully();
            //出现异常后，关闭线程组
            boss.shutdownGracefully();
        }

    }
}