package com.idler.myjwt.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("myjwt")
public class JwtProperties {

  private String privateKey;
  private String publicKey;
  private int expireMinutes = 30;
}
