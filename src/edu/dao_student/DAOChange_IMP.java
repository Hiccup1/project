package edu.dao_student;

import edu.util_student.DBUtil;
import edu.model_student.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 模块说明： DAOChange_IMP类实现DAOChange接口
 * by 李兴栋
 * 
 */

public class DAOChange_IMP implements DAOChange{
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
	
	public boolean insertChange(Change cha) {
		boolean result = false;
		if (cha == null) {
			return result;
		}
		// insert
		String sql = "insert into changes(ID,STUDENTID,CHANGES,REC_TIME,DESCRIPTION) values(?,?,?,?,?)";
		String[] param = { Integer.toString(cha.getID()),Integer.toString(cha.getStudentID()), Integer.toString(cha.getChanges()),
				cha.getRec_time() , cha.getDescription() };
		if (db.executeUpdate(sql, param) == 1) {
			destroy();
			result = true;
		}
		destroy();
		return result;
	}
	
	public String[][] searchChange(String s1, int flag) {
		String[][] result = new String[100][5];
		if(flag == 1) sql = "select *from changes";
		else sql = "select *from changes where ID = ";//SQL语句  
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
				i++;
			}//显示数据  
	        destroy();//关闭连接  
	   } catch (SQLException e) {  
	        e.printStackTrace();  
	   }
		return result;
	}
	
	public boolean updateChange(Change cha, String s1) {
		boolean result = false;
		if (cha == null) {
			return result;
		}
		// insert
		String sql = "update changes set ID = ?,STUDENTID = ?,CHANGES = ?,REC_TIME = ?,DESCRIPTION = ? where ID = ?";
		String[] param = { Integer.toString(cha.getID()),Integer.toString(cha.getStudentID()), Integer.toString(cha.getChanges()),
				cha.getRec_time() , cha.getDescription(), s1};
		if (db.executeUpdate(sql, param) == 1) {
			destroy();
			result = true;
		}
		destroy();
		return result;
	}
	
	public boolean deleteChange(Change cha) {
		boolean result = false;
		if (cha == null) {
			return result;
		}
		String sql = "delete from changes where ID=?";
		String[] param = { Integer.toString(cha.getID()) };
		int rowCount = db.executeUpdate(sql, param);
		if (rowCount == 1) {
			result = true;
		}
		destroy();
		return result;
	}
}
