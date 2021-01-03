package com.rain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rain.bean.TypeBean;
import com.rain.util.DBUtil;
/**
 * 球员分类的类
 */
public class TypeDao {
	/**
	 * 获取所有球员类型的信息，返回数组形式
	 * @return
	 */
	public ArrayList<TypeBean> get_ListInfo(){
		ArrayList<TypeBean> tag_Array = new ArrayList<TypeBean>();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from playertype";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				TypeBean tag = new TypeBean();
				tag.setTid(rs.getInt("tid"));
				tag.setName(rs.getString("name"));
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
	 * 修改球员分类的信息
	 * @param tid
	 * @param name
	 */
	public void updateTypeplayer(int tid, String name) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnectDb();
		String sql = "update playertype set name=? where tid=?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, name);
			stm.setInt(2, tid);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 添加一个球员分类
	 * @param name
	 */
	public void addplayerType(String name) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnectDb();
		String sql = "insert  into playertype(name) values(?)";
		int rs = 0;
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, name);;
			rs = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除一个球员分类
	 * @param tid
	 */
	public void deleteplayerType(int tid) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnectDb();
		String sql = "delete from playertype where tid=?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, tid);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(uid);
		
	}
}
