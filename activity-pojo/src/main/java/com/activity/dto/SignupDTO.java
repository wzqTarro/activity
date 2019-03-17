package com.activity.dto;

import java.io.Serializable;
import java.util.Date;

public class SignupDTO implements Serializable{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -7529946420387027807L;

	/** 报名 **/
	private Integer id;

    private Integer userid;

    private Integer hdid;

    private Date setdate;
    
    /** 账户信息 **/
    private String username;

    private String nicheng;

    private String zh;

    private Date userDate;

    private Integer dwid;

    private String phone;

    private String idno;

    private String email;
}
