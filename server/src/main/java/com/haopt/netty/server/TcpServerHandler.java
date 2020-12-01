package com.haopt.netty.server;

import com.haopt.netty.util.ByteTransform;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TcpServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        byte[] recevierByte = (byte[]) msg;
        String recevierString = ByteTransform.bytesToHexString(recevierByte);
        System.out.println("服务端接收字节长度为：" + recevierString.length() / 2);
        System.out.println("tcp服务接受设备端加密数据：" + recevierString);
        System.out.println("--------------------------------------------");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    /**
     * 客户端断开连接触发方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    /**
     * 方法中报错，触发方法
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
