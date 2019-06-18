package com.idler.myjwt.core;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtils {

  private static final String ALGORITHM = "RSA";

  public static Key getPublicKey(String publicKey) throws InvalidKeySpecException {
    try {
      return KeyFactory.getInstance(ALGORITHM).generatePublic(
          new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey)));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }

  }

  public static Key getPrivateKey(String privateKey) throws InvalidKeySpecException {
    try {
      return KeyFactory.getInstance(ALGORITHM).generatePrivate(
          new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
  }



  public static KeyPair generatorKeyPair(int size) {

    try {
      // RSA算法要求有一个可信任的随机数源
      SecureRandom secureRandom = new SecureRandom();

      // 为RSA算法创建一个KeyPairGenerator对象
      KeyPairGenerator keyPairGenerator = null;
      keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
      // 利用上面的随机数据源初始化这个KeyPairGenerator对象
      keyPairGenerator.initialize(size, secureRandom);
      // 生成密匙对
      KeyPair keyPair = keyPairGenerator.generateKeyPair();
      return keyPair;
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return null;
  }

}
