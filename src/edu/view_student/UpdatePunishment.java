package edu.view_student;

import edu.dao_student.*;
import edu.model_student.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UpdatePunishment extends JFrame{
	private static final long serialVersionUID = 5870864087464173884L;
	
	private DAOPunishment_IMP daoIMP = new DAOPunishment_IMP();
	private Punishment pun = new Punishment();
	private JLabel labID, labStudentId, labLeves, labRec_time, labEnable, labDescription, labUpdate;
	private JButton btnYes, btnNo;
	private JTextField jtfID, jtfStudentId, jtfLeves, jtfRec_time, jtfEnable, jtfDescription, jtfUpdate;
	
	public UpdatePunishment() {
		init();
	}
	
	public void init() {
		this.setLayout(new GridLayout(8, 2, 20, 10));
		this.setTitle("处罚记录输入输入");
		this.setSize(250, 300);
		this.setLocation(450,150);
		
		labUpdate = new JLabel("修改记录号=", JLabel.CENTER);
		labID = new JLabel("记录号", JLabel.CENTER);
		labStudentId = new JLabel("学号", JLabel.CENTER);
		labLeves = new JLabel("级别代码", JLabel.CENTER);
		labRec_time = new JLabel("记录时间", JLabel.CENTER);
		labEnable = new JLabel("是否生效", JLabel.CENTER);
		labDescription = new JLabel("描述", JLabel.CENTER);
		
		btnYes = new JButton("确认");
		btnNo = new JButton("取消");
		
		jtfUpdate = new JTextField(20);
		jtfID = new JTextField(20);
		jtfStudentId = new JTextField(20);
		jtfLeves = new JTextField(20);
		jtfRec_time = new JTextField(20);
		jtfEnable = new JTextField(20);
		jtfDescription = new JTextField(20);
		
		this.add(labUpdate);      this.add(jtfUpdate);
		this.add(labID);          this.add(jtfID);
		this.add(labStudentId);   this.add(jtfStudentId);
		this.add(labLeves);       this.add(jtfLeves);
		this.add(labRec_time);    this.add(jtfRec_time);
		this.add(labEnable);      this.add(jtfEnable);
		this.add(labDescription); this.add(jtfDescription);
		this.add(btnNo);          this.add(btnYes);
		
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pun.setId(Integer.parseInt(jtfID.getText()));
				pun.setStudentId(Integer.parseInt(jtfStudentId.getText()));
				pun.setLevels(Integer.parseInt(jtfLeves.getText()));
				pun.setRec_time(jtfRec_time.getText());
				pun.setEnable(jtfEnable.getText());
				pun.setDescription(jtfDescription.getText());
				boolean res = daoIMP.updatePunishment(pun, jtfUpdate.getText());
				if(res) {
					JOptionPane.showMessageDialog(null,"修改成功", "提示",JOptionPane.WARNING_MESSAGE); 
				}
				else {
					JOptionPane.showMessageDialog(null,"修改失败,记录号不存在", "提示",JOptionPane.WARNING_MESSAGE); 
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
