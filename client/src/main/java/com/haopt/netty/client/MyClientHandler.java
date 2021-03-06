package com.haopt.netty.client;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyClientHandler extends SimpleChannelInboundHandler<Object> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object buf) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // （定时器）向服务端发送数据
       /* Timer timer = new Timer();
        final byte[] bytes = ByteTransform.hexStringToBytes("10000000");
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                byte[] msg = {0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                            0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                            0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                            0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                            0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                            0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                            0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                            0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                            0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                            0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                            0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                            0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                            0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                            0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                        0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                };
                byte[] msg1 = {0x00,0x00,0x00,0x00,0x01, 0x01, 0x02,0x01};
                ctx.writeAndFlush(Unpooled.copiedBuffer(msg1));
            }
        }, 5000, 1000);*/

        int i = 0;
        byte[] msg = {0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,


                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,
                0x01, 98, 49, 50, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109,


        };
//            byte[] msg = {0x00, 0x00, 0x00, 0x0c, 51, 52, 53, 54, 0x12, 0x11, 0x11, 0x00, 0x00, 109, 109, 98};
        while (true){
            i = i + 1;
            int length = msg.length;
            byte[] resByte = new byte[msg.length + 4];
            resByte[0] = (byte) ((length >> 24) & 0xFF);
            resByte[1] = (byte) ((length >> 16) & 0xFF);
            resByte[2] = (byte) ((length >> 8) & 0xFF);
            resByte[3] = (byte) (length & 0xFF);
            System.arraycopy(msg, 0, resByte, 4, length);
            System.out.println(resByte.length + "----------------------");
            ctx.writeAndFlush(Unpooled.copiedBuffer(resByte));
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    public int getIntFromBytes(byte high_h, byte high_l, byte low_h, byte low_l) {
        return (high_h & 0xff) << 24 | (high_l & 0xff) << 16 | (low_h & 0xff) << 8 | low_l & 0xff;
    }

}