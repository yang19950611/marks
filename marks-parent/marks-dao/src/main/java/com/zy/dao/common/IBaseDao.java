package com.zy.dao.common;

import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;
import java.util.Map;

public abstract interface IBaseDao
{
    public abstract <T> Integer count(T paramT);

    public abstract <T> Integer count(String paramString, T paramT);

    public abstract <T> Integer count(String paramString, Map<String, Object> paramMap);

    public abstract <T extends BasePo> BasePo selectOne(T paramT);


    public abstract <T> T selectOne(String paramString, T paramT);

    public abstract <T> T selectOne(String paramString, Map<String, Object> paramMap);

    public abstract <T extends BasePo> int insert(T paramT)
            throws PersistenceException;

    public abstract <T extends BasePo> int insert(List<T> paramList, Map<String, Object> paramMap)
            throws PersistenceException;

    public abstract <T extends BasePo> int update(T paramT)
            throws PersistenceException;

    public abstract <T extends BasePo> int update(T paramT1, T paramT2)
            throws PersistenceException;

    public abstract <T extends BasePo> int update(String paramString, T paramT)
            throws PersistenceException;

    public abstract <T> int update(String paramString, Map<String, Object> paramMap)
            throws PersistenceException;


    public abstract <T extends BasePo> int delete(T paramT)
            throws PersistenceException;

    public abstract <T> int delete(String paramString, T paramT)
            throws PersistenceException;

    public abstract <T> int delete(String paramString, Map<String, Object> paramMap)
            throws PersistenceException;

    public abstract <T extends BasePo> List<T> selectList(T paramT);

    public abstract <T> List<T> selectList(String paramString, T paramT);

    public abstract <T> List<T> selectList(String paramString, Map<String, Object> paramMap);



}