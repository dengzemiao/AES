package com.thinta.testreadword;
import android.util.Base64;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/NoPadding";//默认的加密算法

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器
            int blockSize = cipher.getBlockSize();

            byte[] byteContent = content.getBytes();

            int plaintextLength = byteContent.length;
            if(plaintextLength % blockSize != 0)
            {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(byteContent, 0, plaintext, 0, byteContent.length);

            int len = password.getBytes().length;
            if(len % 16 != 0)
            {
                len = len + (16 - (len % 16));
            }

            byte[] newpass = new byte[len];

            System.arraycopy(password.getBytes(), 0, newpass, 0, password.getBytes().length);

            SecretKeySpec keySpec = new SecretKeySpec(newpass, "AES");

            cipher.init(Cipher.ENCRYPT_MODE, keySpec);// 初始化为加密模式的密码器

            byte[] result = cipher.doFinal(plaintext);// 加密

           // return Base64.encodeBase64String(result);//通过Base64转码返回
            return Base64.encodeToString(result,Base64.DEFAULT);//通过Base64转码返回
        } catch (Exception ex) {
           // Logger.getLogger(AesDec.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param password
     * @return
     */
    public static String decrypt(String content, String password) {

        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            //使用密钥初始化，设置为解密模式
          //   cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));
            int blockSize = cipher.getBlockSize();

            byte[] byteContent = content.getBytes();

            int plaintextLength = byteContent.length;
            if(plaintextLength % blockSize != 0)
            {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(byteContent, 0, plaintext, 0, byteContent.length);

            int len = password.getBytes().length;
            if(len % 16 != 0)
            {
                len = len + (16 - (len % 16));
            }

            byte[] newpass = new byte[len];

            System.arraycopy(password.getBytes(), 0, newpass, 0, password.getBytes().length);

            SecretKeySpec keySpec = new SecretKeySpec(newpass, "AES");

            cipher.init(Cipher.DECRYPT_MODE, keySpec);// 初始化为加密模式的密码器

            //执行操作
         //   byte[] result = cipher.doFinal(Base64.decodeBase64(content));
            byte[] result = cipher.doFinal(Base64.decode(content,Base64.DEFAULT));

            return new String(result, "utf-8");
        } catch (Exception ex) {
           // Logger.getLogger(AesDec.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }


    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(final String password) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);

            int len = password.getBytes().length;
            if(len % 16 != 0)
            {
                len = len + (16 - (len % 16));
            }

            byte[] newpass = new byte[len];
            System.arraycopy(password.getBytes(), 0, newpass, 0, password.getBytes().length);


            //AES 要求密钥长度为 128
            kg.init(128, new SecureRandom(newpass));

            //生成一个密钥
            SecretKey secretKey = kg.generateKey();

            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
           // Logger.getLogger(AesDec.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }


}
