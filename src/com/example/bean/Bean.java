package com.example.bean;

@SuppressWarnings("unused")
public class Bean {
	private String title;
	private String des;
	private String time;
	private String phone;
	private boolean isCkecked;

	public boolean isCkecked() {
		return isCkecked;
	}

	public void setCkecked(boolean isCkecked) {
		this.isCkecked = isCkecked;
	}

	public Bean(String title, String des, String time, String phone) {
		super();
		this.title = title;
		this.des = des;
		this.time = time;
		this.phone = phone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
