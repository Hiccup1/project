package edu.dao_student;

import edu.model_student.*;

/**
 * 模块说明： DAOPunishment接口
 * by 李兴栋
 * 
 */

public interface DAOPunishment {
	void destroy();
	boolean insertPunishment(Punishment pun);
	boolean deletePunishment(Punishment pun);
	String[][] searchPunishment(String s1, int flag);
	boolean updatePunishment(Punishment pun, String s1);
}
