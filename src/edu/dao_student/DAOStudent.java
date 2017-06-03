package edu.dao_student;

import edu.model_student.*;
/**
 * ģ��˵���� DAOStudent�ӿ�
 * by ���˶�
 * 
 */
public interface DAOStudent {
	void destroy();
	boolean insertStudent(Student stu);
	String[][] searchStudent(String s1, int flag);
	boolean deleteStudent(Student stu);
	boolean updateStudent(Student stu, String s1);
}
