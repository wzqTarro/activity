package com.activity.vo;

import java.io.Serializable;
import java.util.Date;

public class UserinfoVO implements Serializable{
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -8206958631712847261L;

	private Integer id;

    private String username;

    private String nicheng;

    private String zh;

    private Date setdate;

    private Integer dwid;

    private String phone;

    private String idno;

    private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNicheng() {
		return nicheng;
	}

	public void setNicheng(String nicheng) {
		this.nicheng = nicheng;
	}

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	public Date getSetdate() {
		return setdate;
	}

	public void setSetdate(Date setdate) {
		this.setdate = setdate;
	}

	public Integer getDwid() {
		return dwid;
	}

	public void setDwid(Integer dwid) {
		this.dwid = dwid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
