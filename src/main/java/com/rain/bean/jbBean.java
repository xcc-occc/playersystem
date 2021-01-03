package com.rain.bean;

public class jbBean {
    private int jid;//收藏记录的id
    private int tid;//话题的id

    private String name;//发表者名称
    private String content;//内容
    private String fbtime;// 发表时间
    private String jbtime;// 被举报时间

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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

    public String getFbtime() {
        return fbtime;
    }

    public void setFbtime(String fbtime) {
        this.fbtime = fbtime;
    }

    public String getJbtime() {
        return jbtime;
    }

    public void setJbtime(String jbtime) {
        this.jbtime = jbtime;
    }
}
