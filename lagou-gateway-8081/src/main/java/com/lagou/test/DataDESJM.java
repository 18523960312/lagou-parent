package com.lagou.test;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * https://juejin.cn/post/6882404615443185678
 */
public class DataDESJM {
    /**
     * 生成 DES 算法密钥
     * @return byte[]
     * @throws Exception
     */
    public static byte[] generateDESKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        // must be equal to 56
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encodedKey = secretKey.getEncoded();
        return encodedKey;
    }

    /**
     * DES加密
     * @param encodedKey generateDESKey生成的密钥
     * @param dataBytes byte[]形式的待加密数据
     * @return byte[]
     * @throws Exception
     */
    public static byte[] encryptByDES(byte[] encodedKey, byte[] dataBytes) throws Exception {
        SecretKey secretKey = new SecretKeySpec(encodedKey, "DES");
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(dataBytes);
        return encryptedData;
    }


    /**
     * DES解密
     * @param encodedKey generateDESKey生成的密钥
     * @param encryptedData byte[]形式的待解密数据
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decryptByDES(byte[] encodedKey, byte[] encryptedData) throws Exception {
        SecretKey secretKey = new SecretKeySpec(encodedKey, "DES");
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        return decryptedData;
    }

    public static void main1(String[] args) throws Exception {
        byte[] encodedKey = DataDESJM.generateDESKey();
        String data = "this is a good boy";
        byte[] encryptedData = DataDESJM.encryptByDES(encodedKey, data.getBytes());
        byte[] decryptedData = DataDESJM.decryptByDES(encodedKey, encryptedData);
        System.out.println(encryptedData);
        System.out.println(decryptedData);
        System.out.println(new String(decryptedData));
    }

    /**
     * *****************************************************************************
     * 进行优化:生成 DES 算法密钥(返回string字符串)
     * *****************************************************************************
     */
    public static String generateDESKeyStr() throws Exception {
        return Base64.encodeBase64String(generateDESKey());
    }
    /**
     * DES加密 *****************************************************************************
     * @param key 经过Base64编码的字符串密钥
     * @param data String形式的待加密数据
     * @return 经过Base64编码的加密数据
     * @throws Exception
     * *****************************************************************************
     */
    public static String encryptByDES(String key, String data) throws Exception {
        byte[] encodedKey = Base64.decodeBase64(key);
        byte[] dataBytes = data.getBytes();
        byte[] encryptedData = encryptByDES(encodedKey, dataBytes);
        return Base64.encodeBase64String(encryptedData);
    }

    /**
     * DES解密 **********************************************************************
     * @param key 经过Base64编码的字符串密钥
     * @param data String形式的待解密数据
     * @return 原始数据
     * @throws Exception
     * *****************************************************************************
     */
    public static String decryptByDES(String key, String data) throws Exception {
        byte[] encodedKey = Base64.decodeBase64(key);
        byte[] dataBytes = Base64.decodeBase64(data);
        byte[] decryptedData = decryptByDES(encodedKey, dataBytes);
        return new String(decryptedData);
    }


    public static void main(String[] args) throws Exception {
        String key = DataDESJM.generateDESKeyStr();
        String data = "this is a good boy";
        String encryptedData = DataDESJM.encryptByDES(key, data);
        String decryptedData = DataDESJM.decryptByDES(key, encryptedData);
        System.out.println(decryptedData);
    }


}
