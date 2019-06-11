package com.idler.demo.commons.codec;

import java.security.Key;
import java.util.Base64;

public class Base64Utils {
  public static String keyByteToBase64(Key bKey) {
    return Base64.getEncoder().encodeToString(bKey.getEncoded());
  }
}
