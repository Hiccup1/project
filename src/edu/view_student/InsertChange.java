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
	private JComboBox jcb;  //������  
	
	public InsertChange() {
		init();
	}
	
	public void init() {
		this.setLayout(new GridLayout(6, 2, 20, 10));
		this.setTitle("ѧ������������");
		this.setSize(250, 300);
		this.setLocation(450,150);
		
		labID = new JLabel("��¼��", JLabel.CENTER);
		labStudentId = new JLabel("ѧ��", JLabel.CENTER);
		labChange = new JLabel("�������", JLabel.CENTER);
		labRec_time = new JLabel("��¼ʱ��", JLabel.CENTER);
		labDescription = new JLabel("����", JLabel.CENTER);
		
		btnYes = new JButton("ȷ��");
		btnNo = new JButton("ȡ��");
		
		String str1[] = {"0תϵ", "1��ѧ", "2��ѧ", "3��ѧ", "4��ҵ"};  
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
