package com.haopt.netty;


import com.haopt.netty.client.MyRPCClient;

public class StartClient {
    public static void main(String[] args) {
        new Thread() {
            public void run() {
                try {
                    new MyRPCClient().start("127.0.0.1", 5566);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
