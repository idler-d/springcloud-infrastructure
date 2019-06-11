package com.idler.demo.commons.codec;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 摘要相关类型的方法
 *
 * @author idler
 */
public class CodecUtils {

  public static String md5Hex(String content, String salt, String charset)
      throws NoSuchAlgorithmException, UnsupportedEncodingException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    if (StringUtils.isBlank(charset)) {
      return HexUtils.byte2hex(md.digest(StringUtils.appendIfMissing(content, salt).getBytes()));
    }
    return HexUtils.byte2hex(md.digest(StringUtils.appendIfMissing(content, salt).getBytes(charset)));
  }

  public static String md5Hex(String content, String salt)
      throws NoSuchAlgorithmException, UnsupportedEncodingException {
    return md5Hex(content, salt, null);
  }

  public static String md5Hex(String content)
      throws NoSuchAlgorithmException, UnsupportedEncodingException {
    return md5Hex(content, null, null);
  }


}
