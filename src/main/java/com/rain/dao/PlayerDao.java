package com.rain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.rain.bean.AdminBean;
import com.rain.bean.PlayerBean;
import com.rain.bean.HistoryBean;
import com.rain.util.DBUtil;
/**
 * 关于球员连接数据库的所有操作的类
 */
public class PlayerDao {

	/**
	 * 添加球员信息，传入所有的信息
	 * @param card
	 * @param name
	 * @param type
	 * @param autho
	 * @param press
	 * @param num
	 */
	public void addplayer(String card, String name, String type, String autho, String press, int num) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnectDb();
		String sql = "insert  into player(card,name,type,autho,press,num) values(?,?,?,?,?,?)";
		int rs = 0;
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, card);
			stm.setString(2, name);
			stm.setString(3, type);
			stm.setString(4, autho);
			stm.setString(5, press);
			stm.setInt(6, num);
			rs = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取所有的球员信息，返回的是ArrayList数组形式
	 * @return
	 */
	public ArrayList<PlayerBean> get_ListInfo(){
		ArrayList<PlayerBean> tag_Array = new ArrayList<PlayerBean>();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from player";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				PlayerBean tag = new PlayerBean();
				tag.setBid(rs.getInt("bid"));
				tag.setName(rs.getString("name"));
				tag.setCard(rs.getString("card"));
				tag.setType(rs.getString("type"));
				tag.setAutho(rs.getString("autho"));
				tag.setPress(rs.getString("press"));
				tag.setNum(rs.getInt("num"));
				tag_Array.add(tag);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.CloseDB(rs, stm, conn);
		}
		return tag_Array;
	}
	/**
	 * 获取收藏记录的全部信息，传入的条件有aid，表示搜索正在收藏的，

	 * @return
	 */
	public ArrayList<HistoryBean> get_HistoryListInfo(String aid){
		ArrayList<HistoryBean> tag_Array = new ArrayList<HistoryBean>();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from history where aid='"+aid+"'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				HistoryBean tag = new HistoryBean();
				tag.setHid(rs.getInt("hid"));
				tag.setAid(rs.getInt("aid"));
				tag.setBid(rs.getInt("bid"));
				tag.setplayername(rs.getString("playername"));
				tag.setCard(rs.getString("card"));
				tag.setBegintime(rs.getString("begintime"));
				tag_Array.add(tag);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.CloseDB(rs, stm, conn);
		}
		return tag_Array;
	}

	/**
	 * 获取单个球员的信息，根据传入的bid来查找，返回一个playerBean数据类型
	 * @param bid
	 * @return
	 */
	public PlayerBean get_playerInfo(int bid){
		PlayerBean tag = new PlayerBean();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from player where bid='"+bid+"'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				tag.setBid(rs.getInt("bid"));
				tag.setName(rs.getString("name"));
				tag.setCard(rs.getString("card"));
				tag.setType(rs.getString("type"));
				tag.setAutho(rs.getString("autho"));
				tag.setPress(rs.getString("press"));
				tag.setNum(rs.getInt("num"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.CloseDB(rs, stm, conn);
		}
		return tag;
	}
	/**
	 * 修改球员的信息，bid作为条件，
	 */
	public void updateplayer(int bid, String card, String name, String type, String autho, String press, int num) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnectDb();
		String sql = "update player set name=?,card=?,type=?,autho=?,press=?,num=? where bid=?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, name);
			stm.setString(2, card);
			stm.setString(3, type);
			stm.setString(4, autho);
			stm.setString(5, press);
			stm.setInt(6, num);
			stm.setInt(7, bid);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除球员信息，根据传入的bid作为条件
	 * @param bid
	 */
	public void deleteplayer(int bid) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnectDb();
		String sql = "delete from player where bid=?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, bid);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(uid);
		
	}
	/**
	 * 用户查找球员，根据输入的名称，使用like进行模糊查询，然后返回一个ArrayList数组类型
	 * @param name
	 * @return
	 */
	public ArrayList<PlayerBean> getLikeList(String name) {
		// TODO Auto-generated method stub
		ArrayList<PlayerBean> tag_Array = new ArrayList<PlayerBean>();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from player where name like '%"+name+"%'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				PlayerBean tag = new PlayerBean();
				tag.setBid(rs.getInt("bid"));
				tag.setName(rs.getString("name"));
				tag.setCard(rs.getString("card"));
				tag.setType(rs.getString("type"));
				tag.setAutho(rs.getString("autho"));
				tag.setPress(rs.getString("press"));
				tag.setNum(rs.getInt("num"));
				tag_Array.add(tag);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.CloseDB(rs, stm, conn);
		}
		return tag_Array;
	}
	/**
	 * 球员收藏，根据传入bid球员id，adminbean当前登录用户的信息，在收藏记录数据表中新插入一条记录
	 * @param bid
	 * @param adminbean
	 */
	public void borrowplayer(int bid, AdminBean adminbean) {
		// TODO Auto-generated method stub
		PlayerBean playerbean = new PlayerBean();
		playerbean = this.get_playerInfo(bid);
		//生成日期的功能
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);  
		int month = c.get(Calendar.MONTH);   
		int day = c.get(Calendar.DATE);  
		//生成收藏开始日期
		String begintime = ""+year+"-"+month+"-"+day;
		month = month + 1;
		Connection conn = DBUtil.getConnectDb();
		String sql = "insert  into history(aid,bid,card,playername,begintime) values(?,?,?,?,?)";
		int rs = 0;
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, adminbean.getAid());
			stm.setInt(2, playerbean.getBid());
			stm.setString(3, playerbean.getCard());
			stm.setString(4, playerbean.getName());
			stm.setString(5, begintime);

			rs = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
