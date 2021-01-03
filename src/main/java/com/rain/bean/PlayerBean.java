package com.rain.bean;

public class PlayerBean {
	/**
	 * 球员的数据表的bean
	 */
	private int bid;//id
	private String name;//球员名称
	private String card;//球员编号
	private String autho;//国籍
	private int num;//年龄
	private String type;//球员的分类
	private String press;//性别
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getAutho() {
		return autho;
	}
	public void setAutho(String autho) {
		this.autho = autho;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	
}
