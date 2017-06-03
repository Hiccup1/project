package edu.view_student;

import edu.model_student.*;
import edu.dao_student.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UpdateStudent extends JFrame{
	private static final long serialVersionUID = 5870864087464173884L;
	
	private DAOStudent_IMP daoIMP = new DAOStudent_IMP();
	private Student stu = new Student();
	private JLabel labStudentID, labName, labSex, labClass, labDepartment, 
					labBirthday, labNative_place, labUpdate;
	private JButton btnYes, btnNo;
	private JTextField jtfStudentID, jtfName, jtfSex, jtfClass, jtfDepartment, 
					jtfBirthday, jtfNative_place, jtfUpdate;
	
	public UpdateStudent() {
		init();
	}
	
	public void init() {
		this.setLayout(new GridLayout(9, 2, 20, 10));
		this.setTitle("ѧ��������Ϣ�޸�");
		this.setSize(250, 380);
		this.setLocation(450,150);
		
		labUpdate = new JLabel("�޸�ѧ��=", JLabel.CENTER);
		labStudentID = new JLabel("ѧ��", JLabel.CENTER);
		labName = new JLabel("����", JLabel.CENTER);
		labSex = new JLabel("�Ա�", JLabel.CENTER);
		labClass = new JLabel("�༶���", JLabel.CENTER);
		labDepartment = new JLabel("Ժϵ���", JLabel.CENTER);
		labBirthday = new JLabel("����", JLabel.CENTER);
		labNative_place = new JLabel("����", JLabel.CENTER);
		
		btnYes = new JButton("�޸�");
		btnNo = new JButton("ȡ��");
		
		jtfUpdate = new JTextField(20);
		jtfStudentID = new JTextField(20);
		jtfName = new JTextField(20);
		jtfSex = new JTextField(20);
		jtfClass = new JTextField(20);
		jtfDepartment = new JTextField(20);
		jtfBirthday = new JTextField(20);
		jtfNative_place = new JTextField(20);
		
		this.add(labUpdate);       this.add(jtfUpdate);
		this.add(labStudentID);    this.add(jtfStudentID);
		this.add(labName);         this.add(jtfName);
		this.add(labSex);          this.add(jtfSex);
		this.add(labClass);        this.add(jtfClass);
		this.add(labDepartment);   this.add(jtfDepartment);
		this.add(labBirthday);     this.add(jtfBirthday);
		this.add(labNative_place); this.add(jtfNative_place);
		this.add(btnNo);           this.add(btnYes);
		
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stu.setStudentId(Integer.parseInt(jtfStudentID.getText()));
				stu.setName(jtfName.getText());
				stu.setSex(jtfSex.getText());
				stu.setClassID(Integer.parseInt(jtfClass.getText()));
				stu.setDepartment(Integer.parseInt(jtfDepartment.getText()));
				stu.setBirthday(jtfBirthday.getText());
				stu.setNative_place(jtfNative_place.getText());
				boolean res = daoIMP.updateStudent(stu, jtfUpdate.getText());
				if(res) {
					JOptionPane.showMessageDialog(null,"�޸ĳɹ�", "��ʾ",JOptionPane.WARNING_MESSAGE); 
				}
				else {
					JOptionPane.showMessageDialog(null,"�޸�ʧ��,ѧ�Ų�����", "��ʾ",JOptionPane.WARNING_MESSAGE); 
				}
			}
		});
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}
