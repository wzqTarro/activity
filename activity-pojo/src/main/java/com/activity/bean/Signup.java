package com.activity.bean;

import java.io.Serializable;
import java.util.Date;

public class Signup implements Serializable{
    /** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -6193280750905613789L;

	private Integer id;

    private Integer userid;

    private Integer hdid;

    private Date setdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getHdid() {
        return hdid;
    }

    public void setHdid(Integer hdid) {
        this.hdid = hdid;
    }

    public Date getSetdate() {
        return setdate;
    }

    public void setSetdate(Date setdate) {
        this.setdate = setdate;
    }
}