package edu.view_student;

import edu.dao_student.*;
import edu.model_student.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class DeleteChange extends JFrame{
	private static final long serialVersionUID = 5870864087464173884L;
	
	private DAOChange_IMP daoIMP = new DAOChange_IMP();
	private Change cha = new Change();
	private JButton btn1, btn2;
	private JTextField jtf;
	private JLabel lab;
	
	public DeleteChange() {
		init();
	}
	
	public void init() {
		this.setLayout(new GridLayout(2, 2, 20, 10));
		this.setTitle("学籍变更表删除");
		this.setSize(250, 100);
		this.setLocation(450,150);
		
		lab = new JLabel("记录号=", JLabel.CENTER);
		this.add(lab);
		
		jtf = new JTextField(20);
		this.add(jtf);
		
		btn1 = new JButton("删除");
		btn2 = new JButton("取消");
		
		this.add(btn1); this.add(btn2);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cha.setId(Integer.parseInt(jtf.getText()));
				boolean res = daoIMP.deleteChange(cha);
				if(res) {
					JOptionPane.showMessageDialog(null,"删除成功", "提示",JOptionPane.WARNING_MESSAGE); 
				}
				else {
					JOptionPane.showMessageDialog(null,"删除失败,信息不存在", "提示",JOptionPane.WARNING_MESSAGE); 
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
