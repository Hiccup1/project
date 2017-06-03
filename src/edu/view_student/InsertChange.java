package edu.view_student;

import edu.dao_student.*;
import edu.model_student.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InsertChange extends JFrame{
	private static final long serialVersionUID = 5870864087464173884L;
	
	private DAOChange_IMP daoIMP = new DAOChange_IMP();
	private Change cha = new Change();
	private JLabel labID, labStudentId, labChange, labRec_time, labDescription;
	private JButton btnYes, btnNo;
	private JTextField jtfID, jtfStudentId, jtfRec_time, jtfDescription;
	private JComboBox jcb;  //下拉框  
	
	public InsertChange() {
		init();
	}
	
	public void init() {
		this.setLayout(new GridLayout(6, 2, 20, 10));
		this.setTitle("学籍变更情况输入");
		this.setSize(250, 300);
		this.setLocation(450,150);
		
		labID = new JLabel("记录号", JLabel.CENTER);
		labStudentId = new JLabel("学号", JLabel.CENTER);
		labChange = new JLabel("变更代码", JLabel.CENTER);
		labRec_time = new JLabel("记录时间", JLabel.CENTER);
		labDescription = new JLabel("描述", JLabel.CENTER);
		
		btnYes = new JButton("确认");
		btnNo = new JButton("取消");
		
		String str1[] = {"0转系", "1休学", "2复学", "3退学", "4毕业"};  
        jcb = new JComboBox(str1);
		
		jtfID = new JTextField(20);
		jtfStudentId = new JTextField(20);
		//jtfChange = new JTextField(20);
		jtfRec_time = new JTextField(20);
		jtfDescription = new JTextField(20);
		
		this.add(labID);          this.add(jtfID);
		this.add(labStudentId);   this.add(jtfStudentId);
		this.add(labChange);      this.add(jcb);
		this.add(labRec_time);    this.add(jtfRec_time);
		this.add(labDescription); this.add(jtfDescription);
		this.add(btnNo);          this.add(btnYes);
		
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cha.setId(Integer.parseInt(jtfID.getText()));
				cha.setStudentId(Integer.parseInt(jtfStudentId.getText()));
				String s1 = jcb.getSelectedItem().toString();
				cha.setChanges(s1.charAt(0) - '0');
				cha.setRec_time(jtfRec_time.getText());
				cha.setDescription(jtfDescription.getText());
				boolean res = daoIMP.insertChange(cha);
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
