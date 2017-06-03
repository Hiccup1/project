package edu.view_student;

import edu.dao_student.*;
import edu.model_student.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UpdateChange extends JFrame{
	private static final long serialVersionUID = 5870864087464173884L;
	
	private DAOChange_IMP daoIMP = new DAOChange_IMP();
	private Change cha = new Change();
	private JLabel labID, labStudentId, labChange, labRec_time, labDescription, labUpdate;
	private JButton btnYes, btnNo;
	private JTextField jtfID, jtfStudentId, jtfChange, jtfRec_time, jtfDescription, jtfUpdate;
	
	public UpdateChange() {
		init();
	}
	
	public void init() {
		this.setLayout(new GridLayout(7, 2, 20, 10));
		this.setTitle("ѧ���������޸�");
		this.setSize(250, 300);
		this.setLocation(450,150);
		
		labUpdate = new JLabel("�޸ļ�¼��=", JLabel.CENTER);
		labID = new JLabel("��¼��", JLabel.CENTER);
		labStudentId = new JLabel("ѧ��", JLabel.CENTER);
		labChange = new JLabel("�������", JLabel.CENTER);
		labRec_time = new JLabel("��¼ʱ��", JLabel.CENTER);
		labDescription = new JLabel("����", JLabel.CENTER);
		
		btnYes = new JButton("ȷ��");
		btnNo = new JButton("ȡ��");
		
		jtfUpdate = new JTextField(20);
		jtfID = new JTextField(20);
		jtfStudentId = new JTextField(20);
		jtfChange = new JTextField(20);
		jtfRec_time = new JTextField(20);
		jtfDescription = new JTextField(20);
		
		this.add(labUpdate);      this.add(jtfUpdate);
		this.add(labID);          this.add(jtfID);
		this.add(labStudentId);   this.add(jtfStudentId);
		this.add(labChange);      this.add(jtfChange);
		this.add(labRec_time);    this.add(jtfRec_time);
		this.add(labDescription); this.add(jtfDescription);
		this.add(btnNo);          this.add(btnYes);
		
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cha.setId(Integer.parseInt(jtfID.getText()));
				cha.setStudentId(Integer.parseInt(jtfStudentId.getText()));
				cha.setChanges(Integer.parseInt(jtfChange.getText()));
				cha.setRec_time(jtfRec_time.getText());
				cha.setDescription(jtfDescription.getText());
				boolean res = daoIMP.updateChange(cha, jtfUpdate.getText());
				if(res) {
					JOptionPane.showMessageDialog(null,"�޸ĳɹ�", "��ʾ",JOptionPane.WARNING_MESSAGE); 
				}
				else {
					JOptionPane.showMessageDialog(null,"�޸�ʧ��,��¼�Ų�����", "��ʾ",JOptionPane.WARNING_MESSAGE); 
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
