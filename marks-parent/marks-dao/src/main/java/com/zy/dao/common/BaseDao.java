package com.zy.dao.common;


import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class BaseDao extends SqlSessionDaoSupport implements IBaseDao
{
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    private final Logger logger = LoggerFactory.getLogger(getClass());
    protected static final String POSTFIX_COUNT = ".count";
    protected static final String POSTFIX_SELECTONE = ".selectOne";
    protected static final String POSTFIX_INSERT = ".insert";
    protected static final String POSTFIX_INSERTLIST = ".insertList";
    protected static final String POSTFIX_UPDATE = ".update";
    protected static final String POSTFIX_UPDATE_BY_ENTITY = ".updateByEntity";
    protected static final String POSTFIX_DELETE = ".delete";
    protected static final String POSTFIX_SELECTLIST = ".selectList";
    protected static final String POSTFIX_SELECTLISTORDERBY = ".selectListOrderBy";
    private static Map<String, Map<String, String>> propertyColumnMapper;


    public <T> Integer count(T entity)
    {
        try
        {
            String className = entity.getClass().getName();
            return (Integer)getSqlSession().selectOne(className + ".count", entity);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public <T> Integer count(String statementPostfix, T object)
    {
        try
        {
            return (Integer)getSqlSession().selectOne(statementPostfix, object);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public <T> Integer count(String statementPostfix, Map<String, Object> parameter)
    {
        try
        {
            return (Integer)getSqlSession().selectOne(statementPostfix, parameter);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }


    public <T extends BasePo> T selectOne(T entity)
    {
        try
        {
            String className = entity.getClass().getName();
            return (T) getSqlSession().selectOne(className + ".selectOne", entity);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }


    public <T> T selectOne(String statementPostfix, T object)
    {
        try
        {
            return getSqlSession().selectOne(statementPostfix, object);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public <T> T selectOne(String statementPostfix, Map<String, Object> parameter)
    {
        try
        {
            return getSqlSession().selectOne(statementPostfix, parameter);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }



    public <T extends BasePo> int insert(T entity)
            throws PersistenceException
    {
        String className = entity.getClass().getName();
        try {

            return getSqlSession().insert(className + ".insert", entity);
        } catch (Exception e) {
            this.logger.error("error on insert {}{}, reason: {}", new Object[] { className, ".insert", e.getMessage(), e });
            throw new PersistenceException(e);
        }
    }


    public <T extends BasePo> int insert(List<T> list, Map<String, Object> parameter)
            throws PersistenceException
    {
        int i = 0;
        for (BasePo bp : list) {
            i += insert(bp);
        }
        return i;
    }

    public <T extends BasePo> int update(T entity) throws PersistenceException
    {
        try
        {
            String className = entity.getClass().getName();
            return getSqlSession().update(className + ".update", entity);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public <T extends BasePo> int update(T setParameter, T whereParameter)
            throws PersistenceException
    {
        String className = setParameter.getClass().getName();
        Map<String, Object> parameter = new HashMap();
        parameter.put("s", setParameter);
        parameter.put("w", whereParameter);
        return update(className + ".updateByEntity", parameter);
    }

    public <T extends BasePo> int update(String statementPostfix, T entity) throws PersistenceException
    {
        try
        {
            return getSqlSession().update(statementPostfix, entity);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public <T> int update(String statementPostfix, Map<String, Object> parameter) throws PersistenceException
    {
        try
        {
            return getSqlSession().update(statementPostfix, parameter);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }


    public <T extends BasePo> int delete(T entity)
            throws PersistenceException
    {
        try
        {
            String className = entity.getClass().getName();
            return getSqlSession().delete(className + ".delete", entity);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public <T> int delete(String statementPostfix, T entity)
            throws PersistenceException
    {
        try
        {
            return getSqlSession().update(statementPostfix, entity);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public <T> int delete(String statementPostfix, Map<String, Object> parameter) throws PersistenceException
    {
        try
        {
            return getSqlSession().update(statementPostfix, parameter);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }


    public <T extends BasePo> List<T> selectList(T entity)
    {
        String statementPostfix = entity.getClass().getName() + ".selectList";
        return selectList(statementPostfix, entity);
    }

    public <T> List<T> selectList(String statementPostfix, T entity)
    {
        try
        {
            return getSqlSession().selectList(statementPostfix, entity);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }


    public <T> List<T> selectList(String statementPostfix, Map<String, Object> parameter)
    {
        this.logger.debug("开始执行statementPostfix：{}", statementPostfix);
        try {
            return getSqlSession().selectList(statementPostfix, parameter);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }



    public <T> List<T> selectList(T entity, String[] orderby)
    {
        String statementPostfix = entity.getClass().getName() + ".selectListOrderBy";
        try
        {
            Map<String, Object> map = bean2Map(entity);
            for (String obj : orderby) {
                map.put("orderby_".concat(obj), obj);
            }
            return getSqlSession().selectList(statementPostfix, map);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }



    private <T> Map<String, Object> bean2Map(T entity) throws Exception
    {
        BeanInfo beanInfo = Introspector.getBeanInfo(entity.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        Map<String, Object> map = new HashMap();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            Object value = descriptor.getReadMethod().invoke(entity, new Object[0]);
            map.put(propertyName, value);
        }
        return map;
    }

}