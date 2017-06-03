package edu.view_student;

import edu.dao_student.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

public class SearchReward extends JFrame{
	private static final long serialVersionUID = 5870864087464173884L;
	
	private DAOReward_IMP daoReward = new DAOReward_IMP();
	
	private JButton btn1, btn2;
	private JScrollPane jspan;
	private JLabel labID;
	private JTextField jtf;
	private JTable jt;
	private DefaultTableModel myTableModel;
	private String[] column = { "��¼��", "ѧ��", "�������", "��¼ʱ��", "����"};
	
	public SearchReward() {
		init();
	}
	
	public void init() {
		this.setTitle("������¼����");
		this.setSize(500, 400);
		this.setLocation(350,150);
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		GridBagConstraints gr1 = new GridBagConstraints();
		gr1.fill = GridBagConstraints.BOTH;  //����������Ժ�����������
		
		gr1.weightx = 1;
        //gr1.weighty = 1;
		gr1.gridwidth = 2;     //������������2������
		gr1.gridheight = 1;
		
		labID = new JLabel("��¼�ţ�", JLabel.CENTER);
		layout.setConstraints(labID, gr1);
		this.add(labID);
		
		gr1.gridwidth = 3;     //������������2������
		gr1.gridheight = 1;
		jtf = new JTextField(40);
		layout.setConstraints(jtf, gr1);
		this.add(jtf);
		
		gr1.gridwidth = 1;     //������������1������
		gr1.gridheight = 1;
		btn1 = new JButton("��ѯ");
		layout.setConstraints(btn1, gr1);
		this.add(btn1);
		
		gr1.gridwidth = 0;     //������������1������
		gr1.gridheight = 1;
		//gr1.gridwidth = GridBagConstraints.REMAINDER; //��ӵ�����Ǳ������һ�����
		btn2 = new JButton("��ѯȫ��");
		layout.setConstraints(btn2, gr1);
		this.add(btn2);
		String[][] res = daoReward.searchReward("", 1);
		myTableModel = new DefaultTableModel(res, column);
		jt = new JTable(myTableModel);
        jspan = new JScrollPane(jt);

		myTableModel.fireTableStructureChanged();// JTableˢ�½ṹ
		myTableModel.fireTableDataChanged();// ˢ��JTable����
        gr1.weightx = 1;
        gr1.weighty = 1;
        gr1.gridwidth = 7;     //������������7������
        //gr1.gridheight = 8;     //������������8������
        //gr1.gridwidth = GridBagConstraints.REMAINDER; //��ӵ�����Ǳ������һ�����
        //gr1.gridheight = GridBagConstraints.REMAINDER; //��ӵ�����Ǳ������һ�����
        layout.setConstraints(jspan, gr1);
        this.add(jspan);  
        btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jtfstr = jtf.getText();
				String[][] res = daoReward.searchReward(jtfstr, 0);
				myTableModel = new DefaultTableModel(res, column);
		        jt.setModel(myTableModel);
				myTableModel.fireTableStructureChanged();// JTableˢ�½ṹ
				myTableModel.fireTableDataChanged();// ˢ��JTable����
		        //setVisible(true);
			}
		});
        
        btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[][] res = daoReward.searchReward("", 1);
				myTableModel = new DefaultTableModel(res, column);
		        jt.setModel(myTableModel);
				myTableModel.fireTableStructureChanged();// JTableˢ�½ṹ
				myTableModel.fireTableDataChanged();// ˢ��JTable����
				//setVisible(true);
			}
		});
        
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}
