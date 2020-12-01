package com.haopt.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class DecoderHandler extends ByteToMessageDecoder {

    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        System.out.println("byteBuf的容量为：" + in.capacity());
        System.out.println("byteBuf的可读容量为：" + in.readableBytes());
        System.out.println("byteBuf的可写容量为：" + in.writableBytes());
        in.markReaderIndex();
        int len = in.readInt();
        System.out.println("数据实际长度：" + len);
        if(len > in.readableBytes()){
            in.resetReaderIndex();
            return;
        }
        byte[] data = new byte[len];
        //读取核心的数据
        in.readBytes(data);
        out.add(data);
    }
}