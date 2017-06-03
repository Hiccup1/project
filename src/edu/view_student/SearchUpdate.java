package edu.view_student;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ģ��˵���� ����ɾ��ѡ��
 * by ���˶�
 * 
 */

public class SearchUpdate extends JFrame {
	private static final long serialVersionUID = 5870864087464173884L;
	
	private JButton btnStudent1, btnChange1, btnReward1, btnPunishment1, btnStudent2, btnChange2, btnReward2, btnPunishment2, 
				btnStudent3, btnChange3, btnReward3, btnPunishment3;
	private JLabel lab1, lab2, lab3;
	
	public SearchUpdate() {
		init();
	}
	
	public void init() {
		this.setTitle("����ɾ��");
		this.setSize(350, 300);
		this.setLocation(450,150);
		this.setLayout(new GridLayout(5, 2, 0, 10));
		
		lab1 = new JLabel("����", JLabel.CENTER);
		lab2 = new JLabel("ɾ��", JLabel.CENTER);
		lab3 = new JLabel("�޸�", JLabel.CENTER);
		
		btnStudent1 = new JButton("ѧ����Ϣ��");
		btnChange1 = new JButton("ѧ�������");
		btnReward1 = new JButton("������¼��");
		btnPunishment1 = new JButton("������¼��");
		btnStudent2 = new JButton("ѧ����Ϣ��");
		btnChange2 = new JButton("ѧ�������");
		btnReward2 = new JButton("������¼��");
		btnPunishment2 = new JButton("������¼��");
		btnStudent3 = new JButton("ѧ����Ϣ��");
		btnChange3 = new JButton("ѧ�������");
		btnReward3 = new JButton("������¼��");
		btnPunishment3 = new JButton("������¼��");
		
		this.add(lab1);          this.add(lab2);           this.add(lab3);
		this.add(btnStudent1);   this.add(btnStudent2);    this.add(btnStudent3);
		this.add(btnChange1);    this.add(btnChange2);     this.add(btnChange3);
		this.add(btnReward1);    this.add(btnReward2);     this.add(btnReward3);
		this.add(btnPunishment1);this.add(btnPunishment2); this.add(btnPunishment3);
		
		btnStudent1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchStudent();
			}
		});
		
		btnStudent2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteStudent();
			}
		});
		
		btnChange2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteChange();
			}
		});
		
		btnReward2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteReward();
			}
		});
		
		btnPunishment2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeletePunishment();
			}
		});
		
		btnChange1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchChange();
			}
		});
		
		btnReward1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchReward();
			}
		});
		
		btnPunishment1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchPunishment();
			}
		});
		
		btnStudent3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateStudent();
			}
		});
		
		btnChange3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateChange();
			}
		});
		
		btnReward3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateReward();
			}
		});
		
		btnPunishment3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdatePunishment();
			}
		});
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
