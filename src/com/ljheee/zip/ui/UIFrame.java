package com.ljheee.zip.ui;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


/**
 * MyZip
 * 
 * @author ljheee
 *
 */
public class UIFrame {

	private JFrame jf = null;
	private JLabel leftInfo = new JLabel("状态栏:");
	private JLabel pathInfo = new JLabel("  ");
	private JLabel timeInfo = new JLabel("  ");

	JMenuItem openFileItem, exitItem, findFileItem, viewLogItem, delLogItem, aboutItem;
	private JMenuItem switchSuanfa;


	ActionHandle handle = new ActionHandle();
	MyMenuHandler menuHandle = new MyMenuHandler();
	
	private JTextField srcFiles;
	private JTextField destZip;
	private JTextField srcZip;
	private JTextField destFiles;

	JButton btn_srcFiles,btn_destZip,compact,btn_srcZip,btn_destFiles,unCompact;
	JFileChooser fileChooser = new JFileChooser();
	
	File src = null;
	File dest = null;
	

	public UIFrame() {
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//可选择目录

		jf = new JFrame("Zip Tool 1.0");
		jf.setSize(750,510 );
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);

		JPanel topJPanel = new JPanel();
		topJPanel.setLayout(new GridLayout(2, 1));

		JRootPane rootPane = new JRootPane(); // 此panel，添加菜单
		rootPane.setBackground(Color.gray);
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("文件(F)");
		JMenu commandMenu = new JMenu("命令(C)");
		JMenu toolMenu = new JMenu("工具(S)");
		JMenu optionMenu = new JMenu("选项(N)");
		JMenu helpMenu = new JMenu("帮助(H)");

		rootPane.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(commandMenu);
		menuBar.add(toolMenu);
		menuBar.add(optionMenu);
		menuBar.add(helpMenu);

		findFileItem = new JMenuItem("查找文件");
		switchSuanfa = new JMenuItem("转换压缩格式");
		findFileItem.addActionListener(handle);
		switchSuanfa.addActionListener(handle);
		toolMenu.add(findFileItem);
		toolMenu.add(switchSuanfa);

		viewLogItem = new JMenuItem("查看日志");
		delLogItem = new JMenuItem("清除日志");
		viewLogItem.addActionListener(handle);
		delLogItem.addActionListener(handle);
		optionMenu.add(viewLogItem);
		optionMenu.add(delLogItem);

		openFileItem = new JMenuItem("打开压缩文件");
		exitItem = new JMenuItem("退出");
		openFileItem.addActionListener(handle);
		exitItem.addActionListener(handle);

		aboutItem = new JMenuItem("关于");
		helpMenu.add(aboutItem);
		aboutItem.addActionListener(handle);

		// 给菜单 添加菜单项
		fileMenu.add(openFileItem);
		fileMenu.add(exitItem);


		topJPanel.add(rootPane);// 工具panel :文件、编辑、查看
		jf.getContentPane().add(topJPanel, BorderLayout.NORTH);
		
		

		// center
		JPanel centerP = new JPanel();
		jf.getContentPane().add(centerP, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u5F85\u538B\u7F29\u6587\u4EF6\u6E90\uFF1A");
		
		srcFiles = new JTextField();
		srcFiles.setColumns(10);
		
		//浏览srcFiles--压缩
		btn_srcFiles = new JButton("\u6D4F\u89C8");
		
		JLabel label_1 = new JLabel("\u538B\u7F29\u5230\uFF1A");
		
		destZip = new JTextField();
		destZip.setColumns(10);
		
		//view destZip
		btn_destZip = new JButton("\u6D4F\u89C8");
		
		//压缩
		compact = new JButton("\u538B\u7F29");

		
		JLabel label_2 = new JLabel("\u5F85\u89E3\u538B\u6587\u4EF6\u6E90\uFF1A");
		
		srcZip = new JTextField();
		srcZip.setColumns(10);
		
		//浏览--srcZip
		btn_srcZip = new JButton("\u6D4F\u89C8");
		
		
		JLabel label_3 = new JLabel("\u89E3\u538B\u5230\uFF1A");
		
		destFiles = new JTextField();
		destFiles.setColumns(10);
		
		
		//浏览--destFiles
		btn_destFiles = new JButton("\u6D4F\u89C8");
		
		//解压
		unCompact = new JButton("\u89E3\u538B");
		
		btn_srcFiles.addActionListener(handle);
		btn_destZip.addActionListener(handle);
		btn_srcZip.addActionListener(handle);
		btn_destFiles.addActionListener(handle);
		
		compact.addActionListener(handle);
		unCompact.addActionListener(handle);
		
		
		GroupLayout gl_centerP = new GroupLayout(centerP);
		gl_centerP.setHorizontalGroup(
			gl_centerP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerP.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_centerP.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_3)
						.addComponent(label_2)
						.addComponent(label_1)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_centerP.createParallelGroup(Alignment.LEADING, false)
						.addComponent(destFiles)
						.addComponent(srcZip)
						.addComponent(destZip)
						.addComponent(srcFiles, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_centerP.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_centerP.createSequentialGroup()
							.addComponent(btn_srcZip)
							.addContainerGap())
						.addGroup(gl_centerP.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_centerP.createSequentialGroup()
								.addComponent(btn_srcFiles)
								.addContainerGap(206, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_centerP.createSequentialGroup()
								.addGroup(gl_centerP.createParallelGroup(Alignment.LEADING)
									.addComponent(btn_destZip)
									.addComponent(btn_destFiles))
								.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
								.addGroup(gl_centerP.createParallelGroup(Alignment.LEADING)
									.addComponent(unCompact)
									.addComponent(compact))
								.addGap(15)))))
		);
		gl_centerP.setVerticalGroup(
			gl_centerP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerP.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_centerP.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(srcFiles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_srcFiles))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_centerP.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(destZip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_destZip)
						.addComponent(compact))
					.addGap(59)
					.addGroup(gl_centerP.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addGroup(gl_centerP.createParallelGroup(Alignment.BASELINE)
							.addComponent(srcZip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_srcZip)))
					.addGap(18)
					.addGroup(gl_centerP.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(destFiles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_destFiles)
						.addComponent(unCompact))
					.addContainerGap(200, Short.MAX_VALUE))
		);
		centerP.setLayout(gl_centerP);
		
		
		
		

		

		// south--状态栏
		JToolBar bottomToolBar = new JToolBar();
		bottomToolBar.setFloatable(false);// 设置JToolBar不可拖动

		bottomToolBar.setPreferredSize(new Dimension(jf.getWidth(), 20));
		bottomToolBar.add(leftInfo);

		// bottomToolBar.addSeparator(); //此方法添加分隔符 无效
		JSeparator jsSeparator = new JSeparator(SwingConstants.VERTICAL);
		bottomToolBar.add(jsSeparator);// 添加分隔符

		leftInfo.setPreferredSize(new Dimension(200, 20));
		leftInfo.setHorizontalTextPosition(SwingConstants.LEFT);

		bottomToolBar.add(pathInfo);
		pathInfo.setHorizontalTextPosition(SwingConstants.LEFT);
		bottomToolBar.add(new JSeparator(SwingConstants.VERTICAL));// 添加分隔符

		bottomToolBar.add(timeInfo);
		timeInfo.setPreferredSize(new Dimension(70, 20));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		timeInfo.setText(sdf.format(new Date()));

		jf.getContentPane().add(bottomToolBar, BorderLayout.SOUTH);// 下面--放“状态栏”

		jf.setVisible(true);
	}

	/**
	 * 主界面菜单--事件监听
	 * @author ljheee
	 *
	 */
	class ActionHandle implements ActionListener {

		Thread t1;

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == openFileItem) { // 
				
			}

			if (e.getSource() == exitItem) {// exit application
				System.exit(0);
			}

			if (e.getSource() == aboutItem) {// show about
				JOptionPane.showMessageDialog(jf, "@Author:ljheee \n 2016");
			}

			if (e.getSource() == findFileItem) {// viewItem 
				jf.repaint();
			}

			if (e.getSource() == switchSuanfa) {// 
												// 
			}

			if (e.getSource() == viewLogItem) {// e

			}

			if (e.getSource() == delLogItem) {// 
				
			}
			
			
			
			if (e.getSource() == compact){//压缩文件
				
			}
			if (e.getSource() == unCompact){//解压文件
				
			}
			
			if (e.getSource() == btn_srcFiles){//选择文件路径
				fileChooser.showOpenDialog(jf);
				srcFiles.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
			
			if (e.getSource() == btn_destZip){//
				fileChooser.showOpenDialog(jf);
				destZip.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
		}
	}

	/**
	 * Menu事件监听
	 * @author ljheee
	 *
	 */
	class MyMenuHandler implements MenuListener {

		@Override
		public void menuCanceled(MenuEvent e) {
		}
		@Override
		public void menuDeselected(MenuEvent e) {
		}

		@Override
		public void menuSelected(MenuEvent e) {

		}
		

	}
	
	

	public static void main(String[] args) {
		new UIFrame();
	}
}
