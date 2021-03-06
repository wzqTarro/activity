package com.activity.vo;

import java.io.Serializable;

public class UnitVO implements Serializable{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 8328450486610611230L;
	private Integer id;

    private String unit;

    private Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
