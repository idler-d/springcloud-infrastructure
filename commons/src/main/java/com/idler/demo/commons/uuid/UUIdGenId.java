package com.idler.demo.commons.uuid;

import tk.mybatis.mapper.genid.GenId;

public class UUIdGenId implements GenId<String> {
  @Override
  public String genId(String table, String column) {
    return SequenceUUID.get().toString();
  }
}
