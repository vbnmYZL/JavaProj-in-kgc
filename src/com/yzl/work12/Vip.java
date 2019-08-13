package com.yzl.work12;

import java.io.Serializable;
import java.util.Date;

public class Vip implements Serializable {

	private String userName;  //用户名
	private String passwd;  //密码
	private String vipNum;  //会员号
	private int point;  //积分
	private Date date;  //开卡日期
	
	public Vip() {
		super();
	}
	
	public Vip(String userName, String passwd, String vipNum, int point, Date date) {
		super();
		this.userName = userName;
		this.passwd = passwd;
		this.vipNum = vipNum;
		this.point = point;
		this.date = date;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getVipNum() {
		return vipNum;
	}
	public void setVipNum(String vipNum) {
		this.vipNum = vipNum;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
