package com.atm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.atm.dao.BeanUserDao;
import com.atm.pojo.BeanUserAccount;
import com.atm.pojo.PageBean;
import com.atm.pojo.RunMessage;
import com.atm.utils.DBUtils;

public class BeanUserDaoImpl implements BeanUserDao{

	@Override
	public BeanUserAccount checkLogin(String ICNo, String pwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement("select * from user where ICNo = ? and pwd = ?");
			ps.setString(1, ICNo);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			BeanUserAccount ua = null;
			if(rs.next()) {
				ua = new BeanUserAccount();
				ua.setICNo(rs.getString("ICNo"));
				ua.setName(rs.getString("name"));
				ua.setPwd(rs.getString("pwd"));
				ua.setMobile(rs.getString("mobile"));
				ua.setIDCard(rs.getString("IDCard"));
				return ua;
			}
			return LOGIN_FALSE;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.close(conn, ps, rs);
		return LOGIN_FALSE;
	}

	@Override
	public int changePwd(String ICNo,String newPwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement("update user set pwd = ? where ICNo = ?");
			ps.setString(1, newPwd);
			ps.setString(2, ICNo);
			int index = ps.executeUpdate();
			if(index > 0) {
				return CHANGE_PASSWORD_SUCCESS;
			}else {
				return CHANGE_PASSWORD_FALSE;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtils.close(conn, ps, null);
		return CHANGE_PASSWORD_FALSE;
	}

	@Override
	public double serchBalance(String ICNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement("select balance from user where ICNo = ?");
			ps.setString(1, ICNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				BeanUserAccount ua = new BeanUserAccount();
				ua.setBalance(rs.getDouble("balance"));
				double num = ua.getBalance();
				return num;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.close(conn, ps, rs);
		return SERCH_FALSE;
	}

	@Override
	public int saveMoney(String ICNo, int MoneyNum) {
		Connection conn = null;
		PreparedStatement ps = null;
		int index = 0;
		try {
			conn = DBUtils.getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("update user set balance=balance+? where ICNo=?");
			ps.setInt(1, MoneyNum);
			ps.setString(2, ICNo);
			if(MoneyNum<=2000) {
				index = ps.executeUpdate();
			}
			if(index>0) {
				conn.commit();
				return UPDATE_SUCCESS;
			}else {
				conn.rollback();
				return UPDATE_FALSE;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.close(conn, ps, null);
		return UPDATE_FALSE;
	}

	@Override
	public int fetchMoney(String ICNo, int MoneyNum) {
		Connection conn = null;
		PreparedStatement ps = null;
		int index = 0;
		try {
			conn = DBUtils.getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("update user set balance=balance-? where ICNo=?");
			ps.setInt(1, MoneyNum);
			ps.setString(2, ICNo);
			if(serchBalance(ICNo)-MoneyNum>0) {
				index = ps.executeUpdate();
				conn.commit();
			}
			if(index>0) {
				conn.rollback();
				return UPDATE_SUCCESS;
			}else if(MoneyNum>2000) {
				conn.rollback();
				return UPDATE_FALSE;
			}else {
				conn.rollback();
				return UPDATE_FALSE;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.close(conn, ps, null);
		return UPDATE_FALSE;
	}
/**
 * 如果
 * ps = conn.prepareStatement("update user set balance=balance+? where ICNo=?");
				ps.setInt(1, MoneyNum);
				ps.setString(2, transferIn);
				ps1 = conn.prepareStatement("update user set balance=balance-? where ICNo=?");
				ps.executeUpdate();
				ps.setInt(1, MoneyNum);
				ps.setString(2, transferOut);
				ps1.executeUpdate();
				就会导致执行executeQuery()先于对SQL语句中的占位符赋值，导致No value specified for parameter 1
 */
	@Override
	public int transfer(String transferOut, String transferIn, double MoneyNum) {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		try {
			conn = DBUtils.getConn();
			conn.setAutoCommit(false);
			if(serchBalance(transferOut)>=MoneyNum) {
				ps = conn.prepareStatement("update user set balance=balance+? where ICNo=?");
				ps.setDouble(1, MoneyNum);
				ps.setString(2, transferIn);
				ps1 = conn.prepareStatement("update user set balance=balance-? where ICNo=?");
				ps1.setDouble(1, MoneyNum);
				ps1.setString(2, transferOut);
				ps.executeUpdate();
				ps1.executeUpdate();
				conn.commit();
				return TRANSFER_SUCCESS;
			}else {
				conn.rollback();
				return TRANSFER_FALSE;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.close(conn, ps, null);
		return TRANSFER_FALSE;
	}


	@Override
	public int quit() {
		return 0;
	}

	@Override
	/**
	 * 转入交易明细
	 */
	public double DetailIn(String ICNo, double Num) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement("update user set saveNum = saveNum+? where icno = ?");
			ps.setObject(1, Num);
			ps.setString(2, ICNo);
			int index = ps.executeUpdate();
			if(index>0) {
				return UPDATE_SUCCESS;
			}else {
				return UPDATE_FALSE;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.close(conn, ps, null);
		return 0;
	}
	/**
	 * 转出交易明细
	 */
	@Override
	public double DetailOut(String ICNo, double Num) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement("update user set fetchNum = fetchNum+? where icno = ?");
			ps.setObject(1, Num);
			ps.setString(2, ICNo);
			int index = ps.executeUpdate();
			if(index>0) {
				return UPDATE_SUCCESS;
			}else {
				return UPDATE_FALSE;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.close(conn, ps, null);
		return 0;
	}
	/**
	 * 查询交易明细
	 */
	@Override
	public BeanUserAccount SerchDetaile(String ICNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		BeanUserAccount dt = new BeanUserAccount();
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement("select * from user where ICNo = ?");
			ps.setString(1, ICNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dt.setFetchNum(rs.getDouble("fetchNum"));
				dt.setSaveNum(rs.getDouble("saveNum"));
				return dt;
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.close(conn, ps, null);
		return null;
	}

	public BeanUserAccount SerchPwd(String ICNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement("select pwd from user where ICNo = ?");
			ps.setString(1, ICNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				BeanUserAccount bua = new BeanUserAccount();
				bua.setPwd(rs.getString("pwd"));
				return bua;
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.close(conn, ps, rs);
		return null;
	}
/**
 * 流水账信息
 */
	@Override
	public int RunMessage(RunMessage rm) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			RunMessage rms = new RunMessage();
			conn = DBUtils.getConn();
			ps = conn.prepareStatement("insert into runmessage values(default,?,?,?,?,?)");
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ps.setString(1, rm.getICno());
			ps.setString(2, df.format(new Date()));
			ps.setString(3, "人民币");
			ps.setDouble(4, rm.getRM_Balance());
			ps.setDouble(5, rm.getRM_Rest());
			int result = ps.executeUpdate();
			
			if(result>0) {
				return UPDATE_SUCCESS; 
			}else {
				return UPDATE_FALSE;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBUtils.close(conn, ps, null);
		return UPDATE_FALSE;
	}
	
	public List<RunMessage> SelMessage(String ICNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RunMessage> list = new ArrayList<RunMessage>();
		try {
			conn = DBUtils.getConn();
			RunMessage rms = null;
			ps = conn.prepareStatement("select * from runmessage where ICno = ?");
			ps.setString(1, ICNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				rms = new RunMessage();
				rms.setICno(rs.getString("ICno"));
				rms.setRM_date(rs.getString("RM_date"));
				rms.setRM_Currency(rs.getString("RM_Currency"));
				rms.setRM_Balance(rs.getDouble("RM_Balance"));
				rms.setRM_Rest(rs.getDouble("Rm_Rest"));
				
				list.add(rms);
			}
//			for(Object ob: list) {
//				System.out.println(ob);
//			}
			DBUtils.close(conn, ps, rs);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<com.atm.pojo.RunMessage> finAllMessage(String ICno, int pageNum, int pageSize) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RunMessage> list = new ArrayList<RunMessage>();
		try {
			conn = DBUtils.getConn();
			RunMessage rms = null;
			ps = conn.prepareStatement("select * from runmessage where ICno=? limit ?,?");
			ps.setString(1, ICno);
			ps.setObject(2, (pageNum-1)*pageSize);
			ps.setObject(3, pageSize);
			rs = ps.executeQuery();
			while(rs.next()) {
				rms = new RunMessage();
				rms.setICno(rs.getString("ICno"));
				rms.setRM_date(rs.getString("RM_date"));
				rms.setRM_Currency(rs.getString("RM_Currency"));
				rms.setRM_Balance(rs.getDouble("RM_Balance"));
				rms.setRM_Rest(rs.getDouble("Rm_Rest"));
				list.add(rms);
			}
			DBUtils.close(conn, ps, rs);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}




	
}
