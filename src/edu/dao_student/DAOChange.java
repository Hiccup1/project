package edu.dao_student;

import edu.model_student.*;

/**
 * ģ��˵���� DAOChange�ӿ�
 * by ���˶�
 * 
 */

public interface DAOChange {
	void destroy();
	boolean insertChange(Change cha);
	boolean deleteChange(Change cha);
	String[][] searchChange(String s1, int flag);
	boolean updateChange(Change cha, String s1);
}
