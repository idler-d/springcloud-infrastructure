package com.idler.demo.exception.config;

import com.idler.demo.exception.advice.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnClass(StarterService.class)
//@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {

//  @Autowired
//  private StarterServiceProperties properties;

  @Bean
  @ConditionalOnMissingBean
//  @ConditionalOnProperty(prefix = "example.service", value = "Enabled", havingValue = "true")
  GlobalExceptionHandler globalExceptionHandler() {
    return new GlobalExceptionHandler();
  }
}
