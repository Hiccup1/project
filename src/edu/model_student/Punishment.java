package edu.model_student;

/**
 * ģ��˵����������¼��Ϣ��
 * by ���˶�
 * 
 */

public class Punishment {
	private int ID;   //��¼��
	private int studentID;  //ѧ��
	private int levels;   //�������
	private String rec_time; //��¼ʱ��
	private String description;//����
	private String enable; //�Ƿ���ЧT F
	
	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
	
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
