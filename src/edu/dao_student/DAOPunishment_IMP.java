package edu.dao_student;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.model_student.*;
import edu.util_student.DBUtil;

/**
 * 模块说明： DAOPunishment_IMP类实现DAOPunishment接口
 * by 李兴栋
 * 
 */

public class DAOPunishment_IMP implements DAOPunishment{
	static DBUtil db = DBUtil.getDBUtil();
	static String sql = null;
	static ResultSet ret = null;
	
	public void destroy() {
		try {
			if (ret != null) {
				ret.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			db.close();
		}
	}
	
	public boolean insertPunishment(Punishment pun) {
		boolean result = false;
		if (pun == null) {
			return result;
		}
		// insert
		String sql = "insert into punishment(ID,STUDENTID,LEVELS,REC_TIME,ENABLE,DESCRIPTION) values(?,?,?,?,?,?)";
		String[] param = { Integer.toString(pun.getID()),Integer.toString(pun.getStudentID()), Integer.toString(pun.getLevels()),
				pun.getRec_time(), pun.getEnable(),pun.getDescription() };
		if (db.executeUpdate(sql, param) == 1) {
			destroy();
			result = true;
		}
		destroy();
		return result;
	}
	
	public boolean updatePunishment(Punishment pun, String s1) {
		boolean result = false;
		if (pun == null) {
			return result;
		}
		// insert
		String sql = "update punishment set ID = ?,STUDENTID = ?,LEVELS = ?,REC_TIME = ?,ENABLE = ?,DESCRIPTION = ? where ID = ?";
		String[] param = { Integer.toString(pun.getID()),Integer.toString(pun.getStudentID()), Integer.toString(pun.getLevels()),
				pun.getRec_time(), pun.getEnable(),pun.getDescription(), s1 };
		if (db.executeUpdate(sql, param) == 1) {
			destroy();
			result = true;
		}
		destroy();
		return result;
	}
	
	public String[][] searchPunishment(String s1, int flag) {
		String[][] result = new String[100][6];
		if(flag == 1) sql = "select *from punishment";
		else sql = "select *from punishment where ID = ";//SQL语句  
		db = DBUtil.getDBUtil();
		try {  
			if(flag == 1) ret = db.executeQuery(sql);//执行语句，得到结果集  
			else ret = db.executeQuery(sql+s1);
			int i = 0;
			while (ret.next()) {
				result[i][0] = ret.getString(1);
				result[i][1] = ret.getString(2);
				result[i][2] = ret.getString(3);
				result[i][3] = ret.getString(4);
				result[i][4] = ret.getString(5);
				result[i][5] = ret.getString(6);
				i++;
			}//显示数据  
	        destroy();//关闭连接  
	   } catch (SQLException e) {  
	        e.printStackTrace();  
	   }
		return result;
	}
	
	public boolean deletePunishment(Punishment pun) {
		boolean result = false;
		if (pun == null) {
			return result;
		}
		String sql = "delete from punishment where ID=?";
		String[] param = { Integer.toString(pun.getID()) };
		int rowCount = db.executeUpdate(sql, param);
		if (rowCount == 1) {
			result = true;
		}
		destroy();
		return result;
	}
}


