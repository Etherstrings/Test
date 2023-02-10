package Tool.JinZhiTrans;

/**
 * @author Justice_wby
 * @create 2023-02-03 16:59
 */
/**
 * 支持 import Java 标准库 (JDK 1.8)
 */
import java.util.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        // int 转换为二进制，4个字节
        ByteTool.IntToByte(n);
        short sh = 1;
        // int 转换位short
        ByteTool.IntToByte(sh);
        char nc = '9';
        // 10进制字符转换位整数
        System.out.println(ByteTool.hexToInt(nc));
    }
}

/**
 * java入门级小工具：进制互换
 * 介绍：在网络编程中，常常需要对进制进行转换，这是一个非常常见的基础小工具。
 */
class ByteTool {
    /**
     * int 转换为二进制，4个字节
     *
     * @return
     */
    public static byte[] IntToByte(int v) {
        //System.out.print("int value="+v);
        byte[] arr = new byte[4];

        arr[0] = (byte) (v & 0x000000ff);
        v >>= 8;//右移8位
        arr[1] = (byte) (v & 0x000000ff);
        v >>= 8;//右移8位
        arr[2] = (byte) (v & 0x000000ff);
        v >>= 8;//右移8位
        arr[3] = (byte) (v & 0x000000ff);
        return arr;
    }

    /**
     * int 转换位short
     *
     * @return
     */
    public static byte[] ShortToByte(short v) {
        byte[] arr = new byte[2];

        arr[0] = (byte) (v & 0x00ff);
        v >>= 8;
        arr[1] = (byte) (v & 0x00ff);
        return arr;
    }

    /**
     * Hex数组转换为字符串
     *
     * @param cmd
     * @param len
     * @return
     */
    public static String arrToString(byte[] cmd, int len) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) sb.append(String.format("%02X ", cmd[i]));
        return sb.toString();
    }

    /**
     * 二进制的字符串转换位byte数组
     *
     * @param s
     * @return
     */
    public static byte[] stringToArray(String s) {
        byte[] arr = new byte[s.length() / 2];
        int t = 0;
        for (int i = 0; i < s.length() - 1; i += 2) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            arr[t] = (byte) (hexToInt(a) * 16 + hexToInt(b));
            t++;
        }
        return arr;
    }

    /**
     * 10进制字符转换位整数
     *
     * @param a
     * @return
     */
    public static int hexToInt(char a) {
        if (a >= '0' && a <= '9') return (int) (a - '0');
        if (a >= 'A' && a <= 'Z') return 10 + (a - 'A');
        return 0;
    }

    /***
     * 二进制转换为字符串0010.....
     * @param b
     */
    public static String byteToString(byte b) {
        StringBuffer sb = new StringBuffer();
        byte a = 0x01;
        for (int i = 0; i < 8; i++) {
            if (0 == (a & b)) {
                sb.insert(0, "0");
            } else {
                sb.insert(0, "1");
            }
            a <<= 1;//左移1位
        }
        return sb.toString();
    }

    /**
     * 字节转换int，高到低
     * @param data
     * @param start
     * @return
     */
    public static int byteArrayToInt2(byte[] data, int start) {
        int value = 0;
        for (int i = start; i < start + 4; i++) {
            int shift = i * 8;
            value += (data[i] & 0xFF) << shift;
        }
        return value;
    }

    /**
     * 字节转换int，低到高
     * @param data
     * @param start
     * @return
     */
    public static int byteArrayToInt(byte[] data, int start) {
        int value = 0;
        for (int i = start; i < start + 4; i++) {
            int shift = (start + 3 - i) * 8;
            value += (data[i] & 0xFF) << shift;
        }
        return value;
    }

    /**
     * 字节转short
     *
     * @param bytes
     * @param start
     * @return
     */
    public static short byteArrayToShort(byte[] bytes, int start) {
        short v = 0;
        v = (short) ((bytes[start] & 0xff) << 8 | bytes[start + 1] & 0xff);//温度11-12位
        return v;
    }

    /***
     * byte数组转换为float，低位到高位
     * @param arr
     * @param index 数据开始下标
     * @return
     */
    public static float getFloat(byte[] arr, int index) {
        ByteBuffer buf = ByteBuffer.allocateDirect(4);
        buf.put(arr, index, 4);
        buf = buf.order(ByteOrder.LITTLE_ENDIAN);//方向转换
        buf.rewind();
        float f = buf.getFloat();
        return f;
    }

    /***
     * byte数组转换为float，高位位到低位
     * @param arr
     * @param index 数据开始下标
     * @return
     */
    public static float getFloat2(byte[] arr, int index) {
        ByteBuffer buf = ByteBuffer.allocateDirect(4);
        buf.put(arr, index, 4);
        buf = buf.order(ByteOrder.BIG_ENDIAN);//方向转换
        buf.rewind();
        float f = buf.getFloat();
        return f;
    }
}