package com.atm.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atm.dao.UserDao;
import com.atm.pojo.User;
import com.atm.pojo.manage;
import com.atm.utill.DBUtils;
/**
 * @author lilijian
 *
 */
public class UserDaoimpl implements UserDao{
	
	/* (non-Javadoc)
	 * @see com.atm.dao.UserDao#login(java.lang.String)
	 */
	@Override
	public manage login(String name) {
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		 manage manage = null;
		try {
		 ps = conn.prepareStatement("select * from manage where name=?");	
		 ps.setString(1, name);
		 rs = ps.executeQuery();
		 while(rs.next()){
			 manage = new manage();
			 manage.setName(rs.getString("name"));
			 manage.setPassword(rs.getString("password"));
		 }
		 DBUtils.release(conn, ps, rs);
			return manage;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	/* (non-Javadoc)
	 * @see com.atm.dao.UserDao#Insone(com.atm.user.User)
	 */
	@Override
	public int Insone(User user) {
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = null;
		int index = 0;
		try {
			ps = conn.prepareStatement("insert into user values (?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getIcno());
			ps.setString(2, user.getName());
			ps.setString(3, "123456");
			ps.setString(4, user.getMobile());
			ps.setString(5, user.getIdcard());
			ps.setDouble(6, user.getBalance());
			ps.setObject(7, null);
			ps.setObject(8, null);
			index = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.release(conn, ps, null);
		return index;
	}

	/* (non-Javadoc)
	 * @see com.atm.dao.UserDao#SelAll()
	 */
	@Override
	public List<User> SelAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<User> list = new ArrayList<User>();
		try {
			conn = DBUtils.getConnection();
			 ps = conn.prepareStatement("select icno,name,pwd,mobile,idcard,balance from user");
			 rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setIcno(rs.getString("icno"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setMobile(rs.getString("mobile"));
				user.setIdcard(rs.getString("idcard"));
				user.setBalance(rs.getDouble("balance"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.release(conn, ps, rs);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.atm.dao.UserDao#Delone()
	 */
	public boolean Delone(String icno){
		
		
		try {
			Connection conn = DBUtils.getConnection();
			PreparedStatement stmt = conn.prepareStatement("delete from user where icno=?");
			stmt.setString(1, icno);
			int index = stmt.executeUpdate();
			if(index<0){
				DBUtils.release(conn, stmt, null);
				return false;
			}else{
				DBUtils.release(conn, stmt, null);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.atm.dao.UserDao#Updone(java.lang.String)
	 */
	@Override
public boolean UpdOne(User user,String ic){
		
		
		try {
			Connection conn = DBUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement("update user set icno=?,name=?,pwd=?,mobile=?,idcard=?,balance=? where icno=?");
			ps.setString(1, user.getIcno());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPwd());
			ps.setString(4, user.getMobile());
			ps.setString(5, user.getIdcard());
			ps.setDouble(6, user.getBalance());
			ps.setString(7, ic);
			
			int index = ps.executeUpdate();
			DBUtils.release(conn, ps, null);
			if(index<0){
				return false;
			}else{
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.atm.dao.UserDao#SelOne()
	 */
	@Override
	public List<User> SelOne(String name) {
		try {
			Connection conn = DBUtils.getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from user where name like ?");
			stmt.setString(1, "%"+name+"%");
			ResultSet rs = stmt.executeQuery();
			List<User> list = new ArrayList<User>();
			
			while(rs.next()){
				User user = new User();
				user.setIcno(rs.getString("icno"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setMobile(rs.getString("mobile"));
				user.setIdcard(rs.getString("idcard"));
				user.setBalance(rs.getDouble("balance"));
				list.add(user);
			}
			
			DBUtils.release(conn, stmt, rs);
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
}




}
