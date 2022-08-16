package cn.dicraft.myblog.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 通过该工具类，可以获取密码，
 * 在main函数中输入自己密码对应的明码，
 * 然后运行，可以在控制台获取对应的密码，
 * 这个密码是要存储在数据库中的password字段
 */

/**
 * @author: DiCraft
 * @Date: 2022-08-13 12:36
 * @package: cn.dicraft.myblog.util
 * @Version: 1.0
 * @Decsription: MD5加密工具类
 */
public class MD5Utils {
    /**
     * @Description: MD5加密
     * @Auther: DiCraft
     * @Date: 2022-08-13 12:36
     * @Param: 要加密的字符串
     * @Return: 加密后的字符串
     */

    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buffer = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buffer.append("0");
                }
                buffer.append(Integer.toHexString(i));
            }
            //32位加密
            return buffer.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * eg：这里是"111111"字符串，
     * 运行main后，
     * 获得密码为："96e79218965eb72c92a549dd5a330112"，
     * 则将该字符串存储进数据库中
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(code("hello"));
    }

}
