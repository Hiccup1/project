package edu.view_student; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 模块说明： 主要界面
 * by 李兴栋
 * 
 */

public class MainView extends JFrame{
	private static final long serialVersionUID = 5870864087464173884L;
	//主界面组件
	private JButton bt1, bt2, bt3, bt4, bt5;
	private JLabel lab1;
	
	public MainView() {
		init();
	}
	//具体实现
	private void init() {
		this.setTitle("学生管理系统");
		this.setSize(250, 300);
		this.setLocation(350,150);
		this.setLayout(new GridLayout(6, 2, 0, 10));
		
		lab1 = new JLabel("学生管理系统 by lxd", JLabel.CENTER);
		this.add(lab1);
		
		bt1 = new JButton("学生个人信息输入");
		bt2 = new JButton("学籍变更情况输入");
		bt3 = new JButton("奖励情况输入");
		bt4 = new JButton("处罚情况输入");
		bt5 = new JButton("学生个人情况查询修改");
		
		this.add(bt1); 
		this.add(bt2);
		this.add(bt3);
		this.add(bt4);
		this.add(bt5);
		//添加监听器
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsertStudent();
			}
		});
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsertChange();
			}
		});
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsertReward();
			}
		});
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsertPunishment();
			}
		});
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchUpdate();
			}
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
