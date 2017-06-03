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
	private JComboBox jcb;  //下拉框 
	
	public InsertReward() {
		init();
	}
	
	public void init() {
		this.setLayout(new GridLayout(6, 2, 20, 10));
		this.setTitle("奖励记录输入");
		this.setSize(250, 300);
		this.setLocation(450,150);
		
		labID = new JLabel("记录号", JLabel.CENTER);
		labStudentId = new JLabel("学号", JLabel.CENTER);
		labLeves = new JLabel("级别代码", JLabel.CENTER);
		labRec_time = new JLabel("记录时间", JLabel.CENTER);
		labDescription = new JLabel("描述", JLabel.CENTER);
		
		btnYes = new JButton("确认");
		btnNo = new JButton("取消");
		
		String str1[] = {"0校特等奖学金", "1校一等奖学金", "2校二等奖学金", "3校三等奖学金", "4系一等奖学金", "5系二等奖学金", "6系三等奖学金"};  
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
					JOptionPane.showMessageDialog(null,"插入成功", "提示",JOptionPane.WARNING_MESSAGE); 
				}
				else {
					JOptionPane.showMessageDialog(null,"插入失败,记录号已存在", "提示",JOptionPane.WARNING_MESSAGE); 
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
