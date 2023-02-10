package Tool.ByteUtil;

/**
 * @author Justice_wby
 * @create 2023-02-03 2:17
 */
/**
 * 支持 import Java 标准库 (JDK 1.8)
 */
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 注意：目前 Java 代码的入口类名称必须为 Main（大小写敏感）
 */
public class Main {

    private static final Logger log = Logger.getLogger(Main.class.getName());

    private static short byteOrder = 1; // 字节排序方式，默认采用小端序
    private static final short BigEndian = 0; // 大端序
    private static final short LittleEndian = 1; // 小端序

    static {
        log.setLevel(Level.INFO);
    }

    /**
     * 设置当前工具类默认端序
     *
     * @param order 输入端序
     */
    public static void setByteOrder(short order) {
        byteOrder = order;
    }

    /**
     * 截取子字节数组
     *
     * @param start       起始位
     * @param end         终点位
     * @param sourceArray 源数组
     * @return 边缘判断后，返回截取后的字节数组
     */
    public static byte[] getChildArray(int start, int end, byte[] sourceArray) {
        if (end < start) {
            throw new IllegalArgumentException("end should bigger then start");
        }
        start = Math.max(0, start);
        end = Math.min(end, sourceArray.length);
        return Arrays.copyOfRange(sourceArray, start, end);
    }

    /**
     * 翻转数组顺序，用于切换大端序和小端序
     *
     * @param input 输入字节数组
     */
    public static void reverseBytes(byte[] input) {
        byte temp;
        for (int i = 0; i < input.length / 2; i++) {
            temp = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }
    }

    /**
     * 取int类型低8位，返回字节
     *
     * @param val 输入整型
     * @return 返回截取位后字节
     */
    public static byte packRaw_u8b(int val) {
        return (byte) (val & 0xff);
    }

    /**
     * 取int类型低16位，返回字节数组(2个字节)
     *
     * @param val 输入整型
     * @return 返回字节数组
     */
    public static byte[] packRaw_u16b(int val) {
        byte[] bt = new byte[2]; // 16位2字节
        val = val & 0xffff;
        /* 小端序 */
        bt[0] = (byte) (val & 0xff);
        bt[1] = (byte) (val >> 8 & 0xff);
        if (byteOrder == BigEndian) {
            reverseBytes(bt);
        }
        return bt;
    }

    /**
     * 取int类型低16位，返回字节数组(2个字节)
     *
     * @param val        输入整型
     * @param _byteOrder 输入端序
     * @return 返回字节数组
     */
    public static byte[] packRaw_u16b(int val, short _byteOrder) {
        byte[] bt = new byte[2]; // 16位2字节
        val = val & 0xffff;
        /* 小端序 */
        bt[0] = (byte) (val & 0xff);
        bt[1] = (byte) (val >> 8 & 0xff);
        if (_byteOrder == BigEndian) {
            reverseBytes(bt);
        }
        return bt;
    }

    /**
     * 取int/long类型低32位，返回字节数组(4个字节)
     *
     * @param val 输入整型/长整型
     * @return 返回字节数组
     */
    public static byte[] packRaw_u32b(long val) {
        byte[] bt = new byte[4];
        val = val & 0xffffffffL;
        bt[0] = (byte) (val & 0xff);
        bt[1] = (byte) (val >> 8 & 0xff);
        bt[2] = (byte) (val >> 16 & 0xff);
        bt[3] = (byte) (val >> 24 & 0xff);
        if (byteOrder == BigEndian) {
            reverseBytes(bt);
        }
        return bt;
    }

    /**
     * 取int/long类型低32位，返回字节数组(4个字节)
     *
     * @param val        输入整型/长整型
     * @param _byteOrder 输入端序
     * @return 返回字节数组
     */
    public static byte[] packRaw_u32b(long val, short _byteOrder) {
        byte[] bt = new byte[4];
        val = val & 0xffffffffL;
        bt[0] = (byte) (val & 0xff);
        bt[1] = (byte) (val >> 8 & 0xff);
        bt[2] = (byte) (val >> 16 & 0xff);
        bt[3] = (byte) (val >> 24 & 0xff);
        if (_byteOrder == BigEndian) {
            reverseBytes(bt);
        }
        return bt;
    }

    /**
     * 取int/long类型64位，返回字节数组(8个字节)
     *
     * @param val 输入整型/长整型
     * @return 返回字节数组
     */
    public static byte[] packRaw_u64b(long val) {
        byte[] bt = new byte[8];

        bt[0] = (byte) (val & 0xff);
        bt[1] = (byte) (val >> 8 & 0xff);
        bt[2] = (byte) (val >> 16 & 0xff);
        bt[3] = (byte) (val >> 24 & 0xff);
        bt[4] = (byte) (val >> 32 & 0xff);
        bt[5] = (byte) (val >> 40 & 0xff);
        bt[6] = (byte) (val >> 48 & 0xff);
        bt[7] = (byte) (val >> 56 & 0xff);
        if (byteOrder == BigEndian) {
            reverseBytes(bt);
        }
        return bt;
    }

    /**
     * 取int/long类型64位，返回字节数组(8个字节)
     *
     * @param val        输入整型/
     * @param _byteOrder 输入端序
     * @return 返回字节数组
     */
    public static byte[] packRaw_u64b(long val, short _byteOrder) {
        byte[] bt = new byte[8];

        bt[0] = (byte) (val & 0xff);
        bt[1] = (byte) (val >> 8 & 0xff);
        bt[2] = (byte) (val >> 16 & 0xff);
        bt[3] = (byte) (val >> 24 & 0xff);
        bt[4] = (byte) (val >> 32 & 0xff);
        bt[5] = (byte) (val >> 40 & 0xff);
        bt[6] = (byte) (val >> 48 & 0xff);
        bt[7] = (byte) (val >> 56 & 0xff);
        if (_byteOrder == BigEndian) {
            reverseBytes(bt);
        }
        return bt;
    }

    /**
     * 解码字节转为long类型
     *
     * @param val 输入字节
     * @return 转码后的长整型
     */
    public static long unpackRaw_u8b(byte val) {
        return (long) val & 0x00ff;
    }

    /**
     * 解码字节数组(2个)转为short类型，占符号位
     *
     * @param val 输入小端序字节数组
     * @return 编码为short类型
     */
    public static short unpackRaw_u16b(byte[] val) {
        if (byteOrder == LittleEndian) {
            reverseBytes(val);
        }
        return (short) ((val[0] & 0xff) << 8 | val[1] & 0xff);
    }

    /**
     * 解码字节数组(2个)转为long类型，不占符号位
     *
     * @param val 输入小端序字节数组
     * @return 编码为long类型
     */
    public static long unpackRaw_16b(byte[] val) {
        if (byteOrder == LittleEndian) {
            reverseBytes(val);
        }
        return (val[0] & 0xff) << 8 | val[1] & 0xff;
    }

    /**
     * 解码字节数组(2个)转为short类型，占符号位
     *
     * @param val        输入大端序字节数组
     * @param _byteOrder 输入端序
     * @return 编码为short类型
     */
    public static short unpackRaw_u16b(byte[] val, short _byteOrder) {
        if (_byteOrder == LittleEndian) {
            reverseBytes(val);
        }
        return (short) ((val[0] & 0xff) << 8 | val[1] & 0xff);
    }

    /**
     * 解码字节数组(2个)转为long类型，不占符号位
     *
     * @param val        输入大端序字节数组
     * @param _byteOrder 输入端序
     * @return 编码为long类型
     */
    public static long unpackRaw_16b(byte[] val, short _byteOrder) {
        if (_byteOrder == LittleEndian) {
            reverseBytes(val);
        }
        return (val[0] & 0xff) << 8 | val[1] & 0xff;
    }

    /**
     * 解码字节数组(4个)转为int类型，占符号位
     *
     * @param val 输入小端序字节数组
     * @return 编码为int类型
     */
    public static int unpackRaw_u32b(byte[] val) {
        if (byteOrder == LittleEndian) {
            reverseBytes(val);
        }
        return (val[0] & 0xff) << 24 | (val[1] & 0xff) << 16 | (val[2] & 0xff) << 8 | val[3] & 0xff;
    }

    /**
     * 解码字节数组(4个)转为long类型，不占符号位
     *
     * @param val 输入小端序字节数组
     * @return 编码为long类型
     */
    public static long unpackRaw_32b(byte[] val) {
        if (byteOrder == LittleEndian) {
            reverseBytes(val);
        }
        return (long) (val[0] & 0xff) << 24 | (val[1] & 0xff) << 16 | (val[2] & 0xff) << 8 | val[3] & 0xff;
    }

    /**
     * 解码字节数组(4个)转为int类型，占符号位
     *
     * @param val        输入大端序字节数组
     * @param _byteOrder 输入端序
     * @return 编码为int类型
     */
    public static int unpackRaw_u32b(byte[] val, short _byteOrder) {
        if (_byteOrder == LittleEndian) {
            reverseBytes(val);
        }
        return (val[0] & 0xff) << 24 | (val[1] & 0xff) << 16 | (val[2] & 0xff) << 8 | val[3] & 0xff;
    }

    /**
     * 解码字节数组(4个)转为long类型，不占符号位
     *
     * @param val        输入大端序字节数组
     * @param _byteOrder 输入端序
     * @return 编码为long类型
     */
    public static long unpackRaw_32b(byte[] val, short _byteOrder) {
        if (_byteOrder == LittleEndian) {
            reverseBytes(val);
        }
        return (long) (val[0] & 0xff) << 24 | (val[1] & 0xff) << 16 | (val[2] & 0xff) << 8 | val[3] & 0xff;
    }

    /**
     * 解码字节数组(8个)转为long类型，占符号位
     *
     * @param val 输入小端序字节数组
     * @return 编码为long类型
     */
    public static long unpackRaw_u64b(byte[] val) {
        if (byteOrder == LittleEndian) {
            reverseBytes(val);
        }
        return (long) (val[0] & 0xff) << 56 | (long) (val[1] & 0xff) << 48 | (long) (val[2] & 0xff) << 40 | (long) (val[3] & 0xff) << 32 | (long) (val[4] & 0xff) << 24 | (val[5] & 0xff) << 16 | (val[6] & 0xff) << 8 | val[7] & 0xff;
    }

    /**
     * 解码字节数组(8个)转为long类型，占符号位
     *
     * @param val 输入大端序字节数组
     * @return 编码为long类型
     */
    public static long unpackRaw_u64b(byte[] val, short _byteOrder) {
        if (_byteOrder == LittleEndian) {
            reverseBytes(val);
        }
        return (long) (val[0] & 0xff) << 56 | (long) (val[1] & 0xff) << 48 | (long) (val[2] & 0xff) << 40 | (long) (val[3] & 0xff) << 32 | (long) (val[4] & 0xff) << 24 | (val[5] & 0xff) << 16 | (val[6] & 0xff) << 8 | val[7] & 0xff;
    }

    /**
     * 解码字节数组(8个)转为BigInteger类型，不占符号位
     *
     * @param val        输入大端序字节数组
     * @param _byteOrder 输入端序
     * @return 编码为BigInteger类型
     */
    public static BigInteger unpackRaw_64b(byte[] val, short _byteOrder) {
        if (_byteOrder == LittleEndian) {
            reverseBytes(val);
        }
        return new BigInteger(val);
    }

    /* 获取MAC、IP等工具接口 */

    /**
     * 获取本地的IP地址
     *
     * @return 返回IP地址的字符串
     * @throws UnknownHostException 未知主机异常
     */
    public static String getLocalIPAddress() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        return address.getHostAddress();
    }

    /**
     * 获取本地的MAC地址
     *
     * @return 返回MAC地址的字符串
     * @throws UnknownHostException 未知主机异常
     * @throws SocketException      套接字异常
     */
    public static String getLocalMACAddress() throws UnknownHostException, SocketException {
        InetAddress address = InetAddress.getLocalHost();
        byte[] macByteArrAddress = NetworkInterface.getByInetAddress(address).getHardwareAddress();
        return byteArr2MacStr(macByteArrAddress);
    }

    /**
     * 将MAC的字节数组转为字符串
     *
     * @param bytes MAC地址字节数组(大端序)
     * @return 拼接后的MAC字符串
     */
    public static String byteArr2MacStr(byte[] bytes) {
        StringBuilder res = new StringBuilder();
        if (bytes == null || bytes.length < 6) {
            log.warning("输入字节数组不合法.");
            return null;
        }
        int index = 0;
        for (byte bt : bytes) {
            int value = 0xff & bt;
            res.append(Integer.toHexString(value).length() == 2 ? Integer.toHexString(value) :
                    '0' + Integer.toHexString(value));
            if (++index < bytes.length) res.append(':');
        }
        return res.toString().toUpperCase();
    }

    /**
     * 解析MAC地址字符串为字节数组
     *
     * @param macStr 输入字符串MAC地址
     * @return 包含MAC信息的字节数组
     */
    public static byte[] macStr2ByteArr(String macStr) {
        byte[] bt = new byte[6]; // MAC有6个字节
        String[] macArr = macStr.split(":");
        if (macArr.length < 6) {
            log.warning(macStr + "is invaild MAC address.");
            return null;
        }
        bt[0] = packRaw_u8b(Integer.parseInt(macArr[0], 16));
        bt[1] = packRaw_u8b(Integer.parseInt(macArr[1], 16));
        bt[2] = packRaw_u8b(Integer.parseInt(macArr[2], 16));
        bt[3] = packRaw_u8b(Integer.parseInt(macArr[3], 16));
        bt[4] = packRaw_u8b(Integer.parseInt(macArr[4], 16));
        bt[5] = packRaw_u8b(Integer.parseInt(macArr[5], 16));

        return bt;
    }

    /**
     * 将输入的字符串IP地址解析为字节数组
     *
     * @param ipStr 输入的IP字符串
     * @return 解析后的IP字节数组
     */
    public static byte[] ipStr2ByteArr(String ipStr) {
        Objects.requireNonNull(ipStr, "ipStr is null");
        // 将ip转存到int/long整型上
        int[] temp = new int[4];
        String[] ipArr = ipStr.split("\\.");
        temp[0] = Integer.parseInt(ipArr[0]);
        temp[1] = Integer.parseInt(ipArr[1]);
        temp[2] = Integer.parseInt(ipArr[2]);
        temp[3] = Integer.parseInt(ipArr[3]);
        int ip = temp[0] << 24 | temp[1] << 16 | temp[2] << 8 | temp[3];
        return packRaw_u32b(ip, BigEndian);
    }

    public static void main(String []args) {
        try {
            String localIPAddress = getLocalIPAddress();
            String localMACAddress = getLocalMACAddress();
            log.info("local IP address is: " + localIPAddress + "\n");
            log.info("local MAC address is: " + localMACAddress + "\n");
            log.info("Parse the IP address into a byte array, and the result is: " + Arrays.toString(ipStr2ByteArr(localIPAddress)) + "\n");
            log.info("Parse the MAC address into a byte array, and the result is: " + Arrays.toString(macStr2ByteArr(localMACAddress)));
        } catch (UnknownHostException | SocketException e) {
            throw new RuntimeException(e);
        }
    }
}
