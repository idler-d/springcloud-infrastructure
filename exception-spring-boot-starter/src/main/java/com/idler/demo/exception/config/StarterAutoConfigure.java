package com.idler.demo.exception.config;

import com.idler.demo.exception.advice.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StarterAutoConfigure {

  @Bean
  @ConditionalOnMissingBean
  GlobalExceptionHandler globalExceptionHandler() {
    return new GlobalExceptionHandler();
  }
}
