package edu.model_student;

/**
 * 模块说明： 学籍变更信息
 * by 李兴栋
 * 
 */

public class Change {
	private int ID;   //记录号
	private int studentID;  //学号
	private int changes;   //变更代码
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
	
	public int getChanges() {
		return changes;
	}

	public void setChanges(int changes) {
		this.changes = changes;
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
