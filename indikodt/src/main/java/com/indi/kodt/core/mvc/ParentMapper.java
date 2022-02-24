package com.indi.kodt.core.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

public class ParentMapper extends SqlSessionDaoSupport {
  @Resource(name = "sqlSession")
  public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
    super.setSqlSessionFactory(sqlSession);
  }

  public int insert(String queryId) {
    return getSqlSession().insert(queryId);
  }

  public int insert(String queryId, Object parameterObject) {
    return getSqlSession().insert(queryId, parameterObject);
  }

  public int update(String queryId) {
    return getSqlSession().update(queryId);
  }

  public int update(String queryId, Object parameterObject) {
    return getSqlSession().update(queryId, parameterObject);
  }

  public int delete(String queryId) {
    return getSqlSession().delete(queryId);
  }

  public int delete(String queryId, Object parameterObject) {
    return getSqlSession().delete(queryId, parameterObject);
  }

  public Object queryForObject(String queryId, Object parameterObject) throws DataAccessException {
    return selectOne(queryId, parameterObject);
  }

  public Object queryForObject(String queryId) throws DataAccessException {
    return selectOne(queryId);
  }

  public Map queryForMap(String queryId, Object parameterObject) throws DataAccessException {
    HashMap map = selectOne(queryId, parameterObject);
    return map;
  }

  public Map queryForMap(String queryId) throws DataAccessException {
    HashMap map = selectOne(queryId);
    return map;
  }

  public List queryForList(String queryId, Object parameterObject) throws DataAccessException {
    return selectList(queryId, parameterObject);
  }

  public List queryForList(String queryId) throws DataAccessException {
    return selectList(queryId);
  }

  public List queryForList(String queryId, Object parameterObject, int skip, int max) throws DataAccessException {
    return listWithPaging(queryId, parameterObject, skip, max);
  }

  private <T> T selectOne(String queryId) {
    return (T)getSqlSession().selectOne(queryId);
  }

  private <T> T selectOne(String queryId, Object parameterObject) {
    return (T)getSqlSession().selectOne(queryId, parameterObject);
  }

  private <E> List<E> selectList(String queryId) {
    return getSqlSession().selectList(queryId);
  }

  private <E> List<E> selectList(String queryId, Object parameterObject) {
    return getSqlSession().selectList(queryId, parameterObject);
  }

  private List<?> listWithPaging(String queryId, Object parameterObject, int pageIndex, int pageSize) {
    int skipResults = pageIndex * pageSize;
    RowBounds rowBounds = new RowBounds(skipResults, pageSize);
    return getSqlSession().selectList(queryId, parameterObject, rowBounds);
  }
}
