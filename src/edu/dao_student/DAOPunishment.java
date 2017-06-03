package edu.dao_student;

import edu.model_student.*;

/**
 * ģ��˵���� DAOPunishment�ӿ�
 * by ���˶�
 * 
 */

public interface DAOPunishment {
	void destroy();
	boolean insertPunishment(Punishment pun);
	boolean deletePunishment(Punishment pun);
	String[][] searchPunishment(String s1, int flag);
	boolean updatePunishment(Punishment pun, String s1);
}
