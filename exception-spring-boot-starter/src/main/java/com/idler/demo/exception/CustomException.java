package com.idler.demo.exception;

import com.idler.demo.exception.vo.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {
  ResponseResult responseResult;
}
