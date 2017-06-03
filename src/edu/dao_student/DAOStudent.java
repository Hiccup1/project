package edu.dao_student;

import edu.model_student.*;
/**
 * 模块说明： DAOStudent接口
 * by 李兴栋
 * 
 */
public interface DAOStudent {
	void destroy();
	boolean insertStudent(Student stu);
	String[][] searchStudent(String s1, int flag);
	boolean deleteStudent(Student stu);
	boolean updateStudent(Student stu, String s1);
}
