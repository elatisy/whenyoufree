package com.chy.whenyoufree.common;

import com.chy.whenyoufree.exception.BaseException;
import com.chy.whenyoufree.exception.UnknownException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Encrypt {
    private static final String salt = "echlatisy2333";

    /**
     * 使用默认盐值进行字符串加密
     * @param origin 原串
     * @return 加密后的字符串
     * @throws BaseException
     */
    public static String encrypt(String origin) throws BaseException {
        return encrypt(origin, Encrypt.salt);
    }

    /**
     * 使用自定义盐值进行字符串加密
     * @param origin 原串
     * @param salt 盐值
     * @return 加密后的字符串
     * @throws BaseException
     */
    public static String encrypt(String origin, String salt) throws BaseException {
        return __encrypt(origin + salt);
    }

    /**
     * 使用默认盐值进行原串密串比对
     * @param origin 原串
     * @param secret 密串
     * @return 原串加密后是否等于密串的真伪性
     * @throws BaseException
     */
    public static boolean compare(String origin, String secret) throws BaseException {
        return compare(origin, secret, Encrypt.salt);
    }

    /**
     * 使用自定义盐值进行原串密串比对
     * @param origin 原串
     * @param secret 密串
     * @param salt 盐值
     * @return 原串加密后是否等于密串的真伪性
     * @throws BaseException
     */
    public static boolean compare(String origin, String secret, String salt) throws BaseException {
        return secret.equals(__encrypt(origin + salt));
    }

    private static String __encrypt(String origin) throws BaseException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(origin.getBytes(StandardCharsets.UTF_8));
            byte[] byteResult = messageDigest.digest();

            String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
            StringBuilder resultStringBuilder = new StringBuilder();
            for(byte b : byteResult) {
                int num = b > 0 ? b : b + 256;
                resultStringBuilder.append(hexDigits[num / 16]).append(hexDigits[num % 16]);
            }

            return resultStringBuilder.toString();
        } catch (Exception e) {
            throw new UnknownException("获取md5失败");
        }
    }
}
