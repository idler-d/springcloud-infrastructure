package com.idler.demo.exception.vo;

import lombok.Data;

@Data
public class ResponseResult {
  private int statusCode;
  private String message;
  private Long timestamp;

  public ResponseResult(int statusCode, String message) {
    this.statusCode = statusCode;
    this.message = message;
    this.timestamp = System.currentTimeMillis();
  }
}
