package com.idler.myjwt.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idler.myjwt.core.JwtUtils;
import com.idler.myjwt.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import java.util.Map;

public class JwtService {

  private JwtProperties jwtProperties;

  public JwtService(JwtProperties jwtProperties) {
    this.jwtProperties = jwtProperties;
  }

  public String generateToken(Object content) throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference typeReference = new TypeReference<Map<String, Object>>(){};
    return generateToken(
        objectMapper.readValue(objectMapper.writeValueAsString(content), typeReference));
  }

  public String generateToken(Map<String, Object> content) throws Exception {
    return JwtUtils.sign(content, jwtProperties.getPrivateKey());
  }

  public Map<String, Object> parserToken(String token) throws Exception {
    Jws<Claims> claimsJws = JwtUtils.parserToken(token, jwtProperties.getPublicKey());
    return  JwtUtils.getBodyMap(claimsJws);
  }

  public <T> T parserToken(String token, Class<T> clazz) throws Exception {
    Jws<Claims> claimsJws = JwtUtils.parserToken(token, jwtProperties.getPublicKey());
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(
        objectMapper.writeValueAsString(JwtUtils.getBodyMap(claimsJws)), clazz);
  }

  public <T> T parserToken(String token, TypeReference<T> valueTypeRef) throws Exception {
    Jws<Claims> claimsJws = JwtUtils.parserToken(token, jwtProperties.getPublicKey());
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(
        objectMapper.writeValueAsString(JwtUtils.getBodyMap(claimsJws)), valueTypeRef);
  }
}
