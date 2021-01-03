package com.rain.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.rain.bean.*;
import com.rain.util.DBUtil;
/**
 * 关于话题连接数据库的所有操作的类
 */
public class TopicDao {

    /**
     * 添加话题信息，传入所有的信息
     */
    public void addTopic(int aid, String username, String name, String content) {
        // TODO Auto-generated method stub
        Connection conn = DBUtil.getConnectDb();
        String sql = "insert  into topic(aid,username,name ,content,time,istop) values(?,?,?,?,?,?)";
        int rs = 0;
        PreparedStatement stm = null;
        //生成日期的功能
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);
        //生成发表日期
        month = month + 1;
        String begintime = ""+year+"-"+month+"-"+day;


        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, aid);
            stm.setString(2, username);
            stm.setString(3, name);
            stm.setString(4, content);
            stm.setString(5, begintime);
            stm.setInt(6, 1);
            rs = stm.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void addjb(int tid, TopicBean topic) {
        // TODO Auto-generated method stub
        Connection conn = DBUtil.getConnectDb();
        String sql = "insert  into jb(tid,name,content,fbtime,jbtime) values(?,?,?,?,?)";
        int rs = 0;
        PreparedStatement stm = null;
        //生成日期的功能
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);
        //生成发表日期
        month = month + 1;
        String jbtime = ""+year+"-"+month+"-"+day;


        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, tid);
            stm.setString(2, topic.getName());
            stm.setString(3, topic.getContent());
            stm.setString(4, topic.getTime());
            stm.setString(5, jbtime);
            rs = stm.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 获取所有的话题信息，返回的是ArrayList数组形式
     *
     * @return
     */
    public ArrayList<TopicBean> get_ListInfo(){
        ArrayList<TopicBean> tag_Array = new ArrayList<TopicBean>();
        Connection conn = DBUtil.getConnectDb();
        String sql = "select * from topic order by istop desc ";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                TopicBean tag = new TopicBean();
                tag.setTid(rs.getInt("tid"));
                tag.setName(rs.getString("name"));
                tag.setAid(rs.getInt("aid"));
                tag.setUsername(rs.getString("username"));
                tag.setContent(rs.getString("content"));
                tag.setTime(rs.getString("time"));
                tag_Array.add(tag);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.CloseDB(rs, stm, conn);
        }
        return tag_Array;
    }
    public ArrayList<jbBean> get_jbListInfo() {
        ArrayList<jbBean> tag_Array = new ArrayList<jbBean>();
        Connection conn = DBUtil.getConnectDb();
        String sql = "select * from jb";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                jbBean tag = new jbBean();
                tag.setTid(rs.getInt("tid"));
                tag.setName(rs.getString("name"));

                tag.setContent(rs.getString("content"));

                tag.setFbtime(rs.getString("fbtime"));
                tag.setJbtime(rs.getString("jbtime"));
                tag_Array.add(tag);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.CloseDB(rs, stm, conn);
        }
        return tag_Array;
    }

    /**
     *jb话题的信息，bid作为条件，
     */
    public TopicBean get_Topicinfo(int tid) {
        // TODO Auto-generated method stub
        TopicBean tag=new TopicBean();
        Connection conn = DBUtil.getConnectDb();
        String sql = "select * from topic where tid='"+tid+"'";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                tag.setTid(rs.getInt("tid"));
                tag.setName(rs.getString("name"));
                tag.setContent(rs.getString("content"));
                tag.setTime(rs.getString("time"));
                tag.setIdtop(rs.getInt("istop"));
                tag.setAid(rs.getInt("aid"));
                tag.setUsername(rs.getString("username"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tag;
    }

    public void zdTopic(int tid) {
        // TODO Auto-generated method stub
        Connection conn = DBUtil.getConnectDb();
        String sql = "update topic set istop=? where tid=?";
        PreparedStatement stm = null;

        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, 1);
            stm.setInt(2, tid);
            stm.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void topTopic() {
        // TODO Auto-generated method stub
        Connection conn = DBUtil.getConnectDb();
        String sql = "update topic set istop=0";
        PreparedStatement stm = null;

        try {
            stm = conn.prepareStatement(sql);
            stm.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}