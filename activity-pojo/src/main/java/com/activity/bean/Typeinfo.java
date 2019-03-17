package com.activity.bean;

import java.io.Serializable;

public class Typeinfo implements Serializable{
    /** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 8587747559691671471L;

	private Integer id;

    private String type;

    private Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}