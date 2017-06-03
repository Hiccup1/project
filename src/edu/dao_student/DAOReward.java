package edu.dao_student;

import edu.model_student.*;

/**
 * ģ��˵���� DAOReward�ӿ�
 * by ���˶�
 * 
 */

public interface DAOReward {
	void destroy();
	boolean insertReward(Reward rew);
	boolean deleteReward(Reward rew);
	String[][] searchReward(String s1, int flag);
	boolean updateReward(Reward rew, String s1);
}
