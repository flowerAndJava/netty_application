package com.haopt.netty.util;

public class ByteTransformIntUtil {
    /**
     * 根据byte转化为int
     * @param high_h
     * @param high_l
     * @param low_h
     * @param low_l
     * @return
     */
    public static int getIntFromBytes(byte high_h, byte high_l, byte low_h, byte low_l) {
        return (high_h & 0xff) << 24 | (high_l & 0xff) << 16 | (low_h & 0xff) << 8 | low_l & 0xff;
    }
    /**
     * 根据byte转化为int
     * @param low_h
     * @param low_l
     * @return
     */
    public static int getIntFromBytes(byte low_h, byte low_l) {
        return ByteTransformIntUtil.getIntFromBytes((byte)0,(byte)0,low_h,low_l);
    }
}
