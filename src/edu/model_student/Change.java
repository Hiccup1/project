package edu.model_student;

/**
 * ģ��˵���� ѧ�������Ϣ
 * by ���˶�
 * 
 */

public class Change {
	private int ID;   //��¼��
	private int studentID;  //ѧ��
	private int changes;   //�������
	private String rec_time; //��¼ʱ��
	private String description;//����
	
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
