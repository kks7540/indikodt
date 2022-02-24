package com.indi.kodt.core.util;

import java.io.StringReader;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongHandler implements TypeHandler {
  private static final Logger logger = LoggerFactory.getLogger(LongHandler.class);

  public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
    String s = (String)parameter;
    StringReader reader = new StringReader(s);
    ps.setCharacterStream(i, reader, s.length());
  }

  public Object getResult(ResultSet rs, String columnName) throws SQLException {
    return rs.getString(columnName);
  }

  public Object getResult(ResultSet arg0, int arg1) throws SQLException {
    return arg0.getObject(arg1);
  }

  public Object getResult(CallableStatement arg0, int arg1) throws SQLException {
    return arg0.getObject(arg1);
  }
}
