package com.rain.bean;

public class TopicBean {
    private int tid;//话题编号
    private int aid;//发表者的id
    private String username;//发表者的账号
    private String name;
    private String content;
    private String time;//发表时间
    private int idtop;//是否置顶，1为置顶，0为普通
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public int getIdtop() {
        return idtop;
    }

    public void setIdtop(int idtop) {
        this.idtop = idtop;
    }

}
