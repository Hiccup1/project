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
	private String[] column = { "记录号", "学号", "级别代码", "记录时间", "描述"};
	
	public SearchReward() {
		init();
	}
	
	public void init() {
		this.setTitle("奖励记录查找");
		this.setSize(500, 400);
		this.setLocation(350,150);
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		GridBagConstraints gr1 = new GridBagConstraints();
		gr1.fill = GridBagConstraints.BOTH;  //设置组件可以横向纵向拉伸
		
		gr1.weightx = 1;
        //gr1.weighty = 1;
		gr1.gridwidth = 2;     //设置组件横向跨2个网格
		gr1.gridheight = 1;
		
		labID = new JLabel("记录号：", JLabel.CENTER);
		layout.setConstraints(labID, gr1);
		this.add(labID);
		
		gr1.gridwidth = 3;     //设置组件横向跨2个网格
		gr1.gridheight = 1;
		jtf = new JTextField(40);
		layout.setConstraints(jtf, gr1);
		this.add(jtf);
		
		gr1.gridwidth = 1;     //设置组件横向跨1个网格
		gr1.gridheight = 1;
		btn1 = new JButton("查询");
		layout.setConstraints(btn1, gr1);
		this.add(btn1);
		
		gr1.gridwidth = 0;     //设置组件横向跨1个网格
		gr1.gridheight = 1;
		//gr1.gridwidth = GridBagConstraints.REMAINDER; //添加的组件是本行最后一个组件
		btn2 = new JButton("查询全部");
		layout.setConstraints(btn2, gr1);
		this.add(btn2);
		String[][] res = daoReward.searchReward("", 1);
		myTableModel = new DefaultTableModel(res, column);
		jt = new JTable(myTableModel);
        jspan = new JScrollPane(jt);

		myTableModel.fireTableStructureChanged();// JTable刷新结构
		myTableModel.fireTableDataChanged();// 刷新JTable数据
        gr1.weightx = 1;
        gr1.weighty = 1;
        gr1.gridwidth = 7;     //设置组件横向跨7个网格
        //gr1.gridheight = 8;     //设置组件纵向跨8个网格
        //gr1.gridwidth = GridBagConstraints.REMAINDER; //添加的组件是本行最后一个组件
        //gr1.gridheight = GridBagConstraints.REMAINDER; //添加的组件是本行最后一个组件
        layout.setConstraints(jspan, gr1);
        this.add(jspan);  
        btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jtfstr = jtf.getText();
				String[][] res = daoReward.searchReward(jtfstr, 0);
				myTableModel = new DefaultTableModel(res, column);
		        jt.setModel(myTableModel);
				myTableModel.fireTableStructureChanged();// JTable刷新结构
				myTableModel.fireTableDataChanged();// 刷新JTable数据
		        //setVisible(true);
			}
		});
        
        btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[][] res = daoReward.searchReward("", 1);
				myTableModel = new DefaultTableModel(res, column);
		        jt.setModel(myTableModel);
				myTableModel.fireTableStructureChanged();// JTable刷新结构
				myTableModel.fireTableDataChanged();// 刷新JTable数据
				//setVisible(true);
			}
		});
        
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}
