package com.haopt.netty.util;

public class ByteTransform {
    /**
     * 字节数组转化为16进制字符串
     *
     * @param src byte[] data
     * @return hex string
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder builder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        return builder.toString();
    }

    /**
     * 动态参数
     * @param b
     * @return
     */
    public static String byteListToHexString(byte... b) {
        byte[] src = b;
        return bytesToHexString(src);
    }

    /**
     * 字节转化为16进制字符串
     *
     * @param src byte data
     * @return hex string
     */
    public static String bytesToHexString(byte src) {
        StringBuilder stringBuilder = new StringBuilder("");
        int v = src & 0xFF;
        String hv = Integer.toHexString(v);
        if (hv.length() < 2) {
            stringBuilder.append(0);
        }
        stringBuilder.append(hv);
        return stringBuilder.toString();
    }

    /**
     * 字符串转化为字节数组
     *
     * @param hexString the hex string
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d;
        //转换的时候应该注意的是单双数的情况，网上很多都只处理了双数的情况，也就是默认刚好填满，这样16进制字符串长度是单数的话会丢失掉一个字符 因为length/2 是舍去余数的
        if (hexString.length() % 2 != 0) {// 16进制字符串长度是单数
            length = length + 1;
            d = new byte[length];
            // 这里把byte数组从后往前填，字符串也是翻转着填的，最后会空出byte数组的第一个（用来填充我们单出来的那个字符）
            for (int i = length - 1; i > 0; i--) {
                int pos = i * 2;
                d[i] = (byte) (charToByte(hexChars[pos]) | charToByte(hexChars[pos - 1]) << 4);
            }
            d[0] = charToByte(hexChars[0]);
        } else {// 双数情况
            d = new byte[length];
            for (int i = 0; i < length; i++) {
                int pos = i * 2;
                d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
            }
        }
        return d;
    }

    /**
     * Convert char to byte
     *
     * @param c char
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
