package com.rain.bean;

public class HistoryBean {
	/**
	 * 历史收藏记录的数据表的bean
	 */
	private int hid;//收藏记录的id
	private int aid;//用户的id
	private int bid;//球员的id
	private String card;//球员号
	private String playername;//球员名称
	private String begintime;//收藏时间
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getplayername() {
		return playername;
	}
	public void setplayername(String playername) {
		this.playername = playername;
	}
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	
}
