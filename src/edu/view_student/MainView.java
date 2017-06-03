package edu.view_student; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ģ��˵���� ��Ҫ����
 * by ���˶�
 * 
 */

public class MainView extends JFrame{
	private static final long serialVersionUID = 5870864087464173884L;
	//���������
	private JButton bt1, bt2, bt3, bt4, bt5;
	private JLabel lab1;
	
	public MainView() {
		init();
	}
	//����ʵ��
	private void init() {
		this.setTitle("ѧ������ϵͳ");
		this.setSize(250, 300);
		this.setLocation(350,150);
		this.setLayout(new GridLayout(6, 2, 0, 10));
		
		lab1 = new JLabel("ѧ������ϵͳ by lxd", JLabel.CENTER);
		this.add(lab1);
		
		bt1 = new JButton("ѧ��������Ϣ����");
		bt2 = new JButton("ѧ������������");
		bt3 = new JButton("�����������");
		bt4 = new JButton("�����������");
		bt5 = new JButton("ѧ�����������ѯ�޸�");
		
		this.add(bt1); 
		this.add(bt2);
		this.add(bt3);
		this.add(bt4);
		this.add(bt5);
		//��Ӽ�����
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
