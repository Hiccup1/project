package edu.model_student;

/**
 * ģ��˵���� ѧ����Ϣ
 * by ���˶�
 * 
 */

public class Student {
	private int studentID;
	private String name;
	private String sex;
	private int classID;    //�༶���
	private int department;// Ժϵ���
	private String birthday;  //����
	private String native_place;// ����

	public int getstudentID() {
		return studentID;
	}

	public void setStudentId(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID =  classID;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNative_place() {
		return native_place;
	}

	public void setNative_place(String native_place) {
		this.native_place = native_place;
	}
}
