package com.haopt.netty;


import com.haopt.netty.server.TcpServer;

public class StartServer {
    public static void main(String[] args) {
        try {
            new TcpServer(5566).init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
