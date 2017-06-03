package edu.view_student;

import edu.dao_student.*;
import edu.model_student.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class InsertReward extends JFrame{
	private static final long serialVersionUID = 5870864087464173884L;
	
	private DAOReward_IMP daoIMP = new DAOReward_IMP();
	private Reward rew = new Reward();
	private JLabel labID, labStudentId, labLeves, labRec_time, labDescription;
	private JButton btnYes, btnNo;
	private JTextField jtfID, jtfStudentId, jtfRec_time, jtfDescription;
	private JComboBox jcb;  //������ 
	
	public InsertReward() {
		init();
	}
	
	public void init() {
		this.setLayout(new GridLayout(6, 2, 20, 10));
		this.setTitle("������¼����");
		this.setSize(250, 300);
		this.setLocation(450,150);
		
		labID = new JLabel("��¼��", JLabel.CENTER);
		labStudentId = new JLabel("ѧ��", JLabel.CENTER);
		labLeves = new JLabel("�������", JLabel.CENTER);
		labRec_time = new JLabel("��¼ʱ��", JLabel.CENTER);
		labDescription = new JLabel("����", JLabel.CENTER);
		
		btnYes = new JButton("ȷ��");
		btnNo = new JButton("ȡ��");
		
		String str1[] = {"0У�صȽ�ѧ��", "1Уһ�Ƚ�ѧ��", "2У���Ƚ�ѧ��", "3У���Ƚ�ѧ��", "4ϵһ�Ƚ�ѧ��", "5ϵ���Ƚ�ѧ��", "6ϵ���Ƚ�ѧ��"};  
        jcb = new JComboBox(str1);
		
		jtfID = new JTextField(20);
		jtfStudentId = new JTextField(20);
		//jtfLeves = new JTextField(20);
		jtfRec_time = new JTextField(20);
		jtfDescription = new JTextField(20);
		
		this.add(labID);          this.add(jtfID);
		this.add(labStudentId);   this.add(jtfStudentId);
		this.add(labLeves);       this.add(jcb);
		this.add(labRec_time);    this.add(jtfRec_time);
		this.add(labDescription); this.add(jtfDescription);
		this.add(btnNo);          this.add(btnYes);
		
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rew.setId(Integer.parseInt(jtfID.getText()));
				rew.setStudentId(Integer.parseInt(jtfStudentId.getText()));
				String s1 = jcb.getSelectedItem().toString();
				rew.setLevels(s1.charAt(0) - '0');
				rew.setRec_time(jtfRec_time.getText());
				rew.setDescription(jtfDescription.getText());
				boolean res = daoIMP.insertReward(rew);
				if(res) {
					JOptionPane.showMessageDialog(null,"����ɹ�", "��ʾ",JOptionPane.WARNING_MESSAGE); 
				}
				else {
					JOptionPane.showMessageDialog(null,"����ʧ��,��¼���Ѵ���", "��ʾ",JOptionPane.WARNING_MESSAGE); 
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
