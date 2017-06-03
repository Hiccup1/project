package edu.model_student;

/**
 * 模块说明：奖励记录信息表
 * by 李兴栋
 * 
 */

public class Reward {
	private int ID;   //记录号
	private int studentID;  //学号
	private int levels;   //级别代码
	private String rec_time; //记录时间
	private String description;//描述
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRec_time() {
		return rec_time;
	}

	public void setRec_time(String rec_time) {
		this.rec_time = rec_time;
	}
	
	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}
	
	public int getID() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}
	
	public int getStudentID() {
		return studentID;
	}

	public void setStudentId(int studentID) {
		this.studentID = studentID;
	}
}
