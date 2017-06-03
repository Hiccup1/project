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
		this.setTitle("ѧ�������ɾ��");
		this.setSize(250, 100);
		this.setLocation(450,150);
		
		lab = new JLabel("��¼��=", JLabel.CENTER);
		this.add(lab);
		
		jtf = new JTextField(20);
		this.add(jtf);
		
		btn1 = new JButton("ɾ��");
		btn2 = new JButton("ȡ��");
		
		this.add(btn1); this.add(btn2);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cha.setId(Integer.parseInt(jtf.getText()));
				boolean res = daoIMP.deleteChange(cha);
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
