package edu.dao_student;

import edu.util_student.DBUtil;
import edu.model_student.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 模块说明： DAOStunt_IMP类实现DAPStudent接口
 * by 李兴栋
 * 
 */
public class DAOStudent_IMP implements DAOStudent{
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
	
	public String[][] searchStudent(String s1, int flag) {
		String[][] result = new String[100][7];
		if(flag == 1) sql = "select *from student";
		else sql = "select *from student where STUDENTID = ";//SQL语句  
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
				result[i][6] = ret.getString(7);
				i++;
			}//显示数据  
	        destroy();//关闭连接  
	   } catch (SQLException e) {  
	        e.printStackTrace();  
	   }
		return result;
	}
	
	public boolean insertStudent(Student stu) {
		boolean result = false;
		if (stu == null) {
			return result;
		}
		// insert
		String sql = "insert into student(STUDENTID,NAME,SEX,CLASSID,DEPARTMENT,BIRTHDAY,NATIVE_PLACE) values(?,?,?,?,?,?,?)";
		String[] param = { Integer.toString(stu.getstudentID()), stu.getName(), stu.getSex(), Integer.toString(stu.getClassID()), 
				Integer.toString(stu.getDepartment()),stu.getBirthday() , stu.getNative_place() };
		if (db.executeUpdate(sql, param) == 1) {
			destroy();
			result = true;
		}
		destroy();
		return result;
	}
	
	public boolean updateStudent(Student stu, String s1) {
		boolean result = false; 
		if (stu == null) {
			return result;
		}
		// insert
		String sql = "update student set STUDENTID = ?,NAME = ?,SEX = ?,CLASSID = ?,DEPARTMENT = ?,BIRTHDAY = ?,NATIVE_PLACE = ? where STUDENTID = ?";
		String[] param = { Integer.toString(stu.getstudentID()), stu.getName(), stu.getSex(), Integer.toString(stu.getClassID()), 
				Integer.toString(stu.getDepartment()),stu.getBirthday() , stu.getNative_place(), s1 };
		if (db.executeUpdate(sql, param) == 1) {
			destroy();
			result = true;
		}
		destroy();
		return result;
	}
	
	public boolean deleteStudent(Student stu) {
		boolean result = false;
		if (stu == null) {
			return result;
		}
		String sql = "delete from student where STUDENTID=?";
		String[] param = { Integer.toString(stu.getstudentID()) };
		int rowCount = db.executeUpdate(sql, param);
		if (rowCount == 1) {
			result = true;
		}
		destroy();
		return result;
	}
	
}
