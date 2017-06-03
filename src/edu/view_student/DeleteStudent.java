package edu.view_student;

import edu.dao_student.DAOStudent_IMP;
import edu.model_student.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * ģ��˵���� ɾ��ѧ����¼����
 * by ���˶�
 * 
 */

public class DeleteStudent extends JFrame{
	private static final long serialVersionUID = 5870864087464173884L;
	
	private DAOStudent_IMP daoIMP = new DAOStudent_IMP();
	private Student stu = new Student();
	private JButton btn1, btn2;
	private JTextField jtf;
	private JLabel lab;
	
	public DeleteStudent() {
		init();
	}
	
	public void init() {
		this.setLayout(new GridLayout(2, 2, 20, 10));
		this.setTitle("ѧ��������Ϣɾ��");
		this.setSize(250, 100);
		this.setLocation(450,150);
		
		lab = new JLabel("ѧ��=", JLabel.CENTER);
		this.add(lab);
		
		jtf = new JTextField(20);
		this.add(jtf);
		
		btn1 = new JButton("ɾ��");
		btn2 = new JButton("ȡ��");
		
		this.add(btn1); this.add(btn2);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stu.setStudentId(Integer.parseInt(jtf.getText()));
				boolean res = daoIMP.deleteStudent(stu);
				if(res) {
					JOptionPane.showMessageDialog(null,"ɾ���ɹ�", "��ʾ",JOptionPane.WARNING_MESSAGE); 
				}
				else {
					JOptionPane.showMessageDialog(null,"ɾ��ʧ��,��Ϣ������", "��ʾ",JOptionPane.WARNING_MESSAGE); 
				}
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
