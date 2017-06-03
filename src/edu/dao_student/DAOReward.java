package edu.dao_student;

import edu.model_student.*;

/**
 * 模块说明： DAOReward接口
 * by 李兴栋
 * 
 */

public interface DAOReward {
	void destroy();
	boolean insertReward(Reward rew);
	boolean deleteReward(Reward rew);
	String[][] searchReward(String s1, int flag);
	boolean updateReward(Reward rew, String s1);
}
