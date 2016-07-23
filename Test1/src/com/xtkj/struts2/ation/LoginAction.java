package com.xtkj.struts2.ation;

public class LoginAction {
	private String uid;
	private String pwd;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	public String execute(){
		
		if(this.uid.equals("admin")){
			return "success";
		}else{
			return "error";
		}
	}
	
	public static void main(String[] args) {
		LoginAction la = new LoginAction();
		la.setUid("admin");
		System.out.println(la.execute());
		
	}
	
	
	

}
