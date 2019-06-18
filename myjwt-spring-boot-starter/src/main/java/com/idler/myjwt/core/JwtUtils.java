package com.idler.myjwt.core;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.RandomUtils;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt相关工具包
 *
 * @author idler
 */
public class JwtUtils {

  public static int KEY_SIZE = 2048;
  private static String privateKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCwlAAvO0E2czC3282R1T1RdpWRrsKfQvgkJy+ie1Cj858uNabIMB4fKuIpDIXJ2eK7nXWUSw3krw/c67jxEPrx/VoutS/5tyDVuNCwyhLYCiTHsMZ9tlhO3pjcO+V0l84WeHQED+RN1octl3z6HYs8ziilmp93+bxkp2eC1YcEPj+CkAzNGMhSkJnNKo6YzVLQzJs6M339N0H0F6tojC242uBRguUkw99/x71gKemqWwsuqYnoHM663D0FMHqI7ikCdk4q3lKZhnPoBNew8K86Nr/CCFgOdAk4RClMVUKkaozEcH6yN/BOnCRe2vGmnTGWcn8EpGZoUEFv3ey8AzmJAgMBAAECggEBAJsdeEgFcpUFfb+VnDFGtHXyiROQBLHpH5iKv+KpFz7fTW9HfDqRYnSYtFHBCWo3OGD9woNBp3PDgVjdzfoeo4OevvEXA40HHRYCI3maGhGkX4j4NnXKkCrAimG1UC0rCcRdjfTfjPv/v4ICeKwy9dS1eal4eivnu2JkWJ7rOo8zNAeQycJkJ6nDOSrCUvQy9zJ52darLpe9ZqwxnluQrv8wCZb90CixI+qmjFwt0d7yxXsshmEZO0bxQh1DWyCHRqOoXJKxqvUNzk/A/gi0CU1zywA3ikLe2GOpunGj7po61BWnl/dYt6d21N2c8FlR/sqptgqNGoh9jfrnfcdv1k0CgYEA675Z25bFMKbiFzhwpa9lYOD/GPwP95cu3+65clLyFeRZH4p6IMB8gyYClZ9XgKfxp9QutoEh72EJOR7BW4K0hnBDkbdYfIm+40uEj6CSuBLFE2WM+eXa2tOO0xzQZQMZXEy9bAPNiYPpusdfGLWjiSPQ+CemfRuDxyVGrCjO8tsCgYEAv8AwMTT76HecjNydEeT9p3vkD5m4+hMuosjFlWxjPaHGRL3XVk/TvojL00R3FYByEzPEVf1cEP9QaVTDWTkX6SB802Q2OEkhJWmjelpS8AmGvVocAtFD2STN9kBRIKQUwMhUBJXpT1NpmLhb5e7xCjI/6PuLWwIIJUlaQQmsqGsCgYEA4zb+aLVyrafLdlIB0M+yyKNTfANGaH6gwVjYCKaFijAi7lGL0JF18Pnrt8ZykiBMvFO4ClOAH7bJKvLHrqnV0VXW6lVqxe4FvBGHXN+JSj1dEYrpS9sNC6iomjXFbfaEtP+J+tfXfNlVp56Nu8UmMAIDYYrl3uNsKb911G0ouc0CgYBN3wfzQ9g1vTWngwSKuttERC0HJN+ZN2cOFske+KiI5AT377zewYZ1b2qPPtO5uLMbFz/ZyA22nWkTjafTuTr7owTueFkInLJIVlFcpAfgkY3Voh2UC1YpfifipJYN0nTXIcP1JMhePbq5mc1AYLwk7ulDfbxHVljmg5aSqRIkRwKBgQCnTujuPKYQTIlXfYYywc/3MyRDNRI5OHMZLG06JcNBCQ+qjBYHBP9KexrnYnon7qRLMf6nGc4u+9nbAxK5kwp1GEl+JKKyO4uybZzTHOw+xCYraSfpkasGTWZF+CLcYyVcWMssdNSnWeDiy7Q79Tf0zaNasWvy6leTjNbS7O09pQ==";
  private static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsJQALztBNnMwt9vNkdU9UXaVka7Cn0L4JCcvontQo/OfLjWmyDAeHyriKQyFydniu511lEsN5K8P3Ou48RD68f1aLrUv+bcg1bjQsMoS2Aokx7DGfbZYTt6Y3DvldJfOFnh0BA/kTdaHLZd8+h2LPM4opZqfd/m8ZKdngtWHBD4/gpAMzRjIUpCZzSqOmM1S0MybOjN9/TdB9BeraIwtuNrgUYLlJMPff8e9YCnpqlsLLqmJ6BzOutw9BTB6iO4pAnZOKt5SmYZz6ATXsPCvOja/wghYDnQJOEQpTFVCpGqMxHB+sjfwTpwkXtrxpp0xlnJ/BKRmaFBBb93svAM5iQIDAQAB";

  public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
    Map<String, Object> content = new HashMap<>();

    content.put("userId", RandomUtils.nextLong());
    content.put("username", "idler");
    content.put("age", 30);

//    String s = sign(content, keyPair.getPrivate());
    String s = sign(content, privateKey);
    System.out.println(s);
    toJson(s, RSAUtils.getPublicKey(publicKey));

  }

  public static String sign(Map<String, Object> content , Key key){
    return Jwts.builder().setClaims(content).signWith(key).compact();
  }

  public static String sign(Map<String, Object> content , String key)
      throws InvalidKeySpecException {
    Key privateKey = RSAUtils.getPrivateKey(key);
    return sign(content, privateKey);
  }

  public static Jws<Claims> parserToken(String token, String publicKey) throws Exception {
    return Jwts.parser().setSigningKey(RSAUtils.getPublicKey(publicKey))
        .parseClaimsJws(token);
  }

  public static String toJson(String code, Key publicKey) {
    Map<String, Object> map = new HashMap<>();

    Jws<Claims> jws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(code);

    map.put("Header", getHeaderMap(jws));
    map.put("body", getBodyMap(jws));

    ObjectMapper objectMapper = new ObjectMapper();
    try {
      String json = objectMapper.writeValueAsString(map);
      System.out.println(json);
      return json;
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return null;
    }

  }

  public static Map<String, Object> getHeaderMap(Jws<Claims> jws) {
    Map<String, Object> map = new HashMap<>();
    jws.getHeader().forEach((key, value) -> map.put((String) key, value ));
    return map;
  }

  public static Map<String, Object> getBodyMap(Jws<Claims> jws) {
    Map<String, Object> map = new HashMap<>();
    jws.getBody().forEach((key, value) -> map.put(key, value ));
    return map;
  }


}
