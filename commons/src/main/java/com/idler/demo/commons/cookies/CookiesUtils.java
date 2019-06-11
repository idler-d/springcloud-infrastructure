package com.idler.demo.commons.cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtils {

  private HttpServletResponse httpServletResponse;
  private boolean httpOnly = false;
  private String domain = "";

  private CookiesUtils(HttpServletResponse httpServletResponse) {
    this.httpServletResponse = httpServletResponse;
  }

  public static CookiesUtils newBuilder(HttpServletResponse httpServletResponse) {
    return new CookiesUtils(httpServletResponse);
  }

  public CookiesUtils httpOnly() {
    this.httpOnly = true;
    return this;
  }

//  public CookiesUtils domain(String domain) {
//
//  }

  public void build(String name, String value) {
    Cookie cookie = new Cookie(name, value);
    cookie.setHttpOnly(this.httpOnly);
    httpServletResponse.addCookie(cookie);
  }
}
