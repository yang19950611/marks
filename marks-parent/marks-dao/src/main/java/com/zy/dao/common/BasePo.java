package com.zy.dao.common;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;


public abstract class BasePo implements Serializable
{
    private static final long serialVersionUID = -3817027601402686029L;
    @Id
    @GeneratedValue(strategy=AUTO)
    @Column(name="id", unique=true, nullable=false)
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
