package com.idler.myjwt.config;

import com.idler.myjwt.properties.JwtProperties;
import com.idler.myjwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(JwtService.class)
@EnableConfigurationProperties(JwtProperties.class)
public class StarterAutoConfigure {

  @Autowired
  private JwtProperties jwtProperties;

  @Bean
  @ConditionalOnMissingBean
  JwtService jwtService() {
    return new JwtService(jwtProperties);
  }
}
