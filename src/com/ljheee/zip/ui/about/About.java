package com.ljheee.zip.ui.about;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class About extends JDialog
{
	private static final long serialVersionUID = 1L;
	
	private JLabel TopLab;
	private MyDongcLabel CenLab;
	private JLabel LineLab;
	private JLabel MaDengLab;
	private JButton btn;
	private MyPicLabel mpl;
	private JTextPane TextPan1,TextPan2;

	Timer t=new Timer(100,new TimerEv());//走马灯效果
	//走马灯效果用的变量
	StringBuffer s=new StringBuffer("谢谢使用!如有问题请联系我们!");
	int len=0;
	int loop=0;
	int over=0;
	int spacelen=15;
	boolean b=true;

	public About(){}
	public About(JFrame owner, String title, boolean modal)
	{
		super(owner,title,modal);
		setBounds(300,200,475,330);
		setResizable(false);

		TopLab=new JLabel(new ImageIcon(About.class.getResource("top.jpg")));
		TopLab.setBounds(0,0,475,80);

		CenLab=new MyDongcLabel();
		CenLab.setBounds(0,80,470,10);

		Border br1=new EtchedBorder();
		TitledBorder br=new TitledBorder(br1);
		LineLab=new JLabel();
		LineLab.setBorder(br);
		LineLab.setBounds(185,235,270,2);

		MaDengLab=new JLabel();
		MaDengLab.setBounds(189,240,270,15);

		btn=new JButton(" 确 定 ");
		btn.setFont(new Font("宋体",0,12));
		btn.setBorder(new MyBorder(btn));
		btn.setBounds(350,265,80,25);
		btn.setFocusPainted(false);

		btn.addMouseListener(new MouseListener()
			{
				public void mouseClicked(MouseEvent e)
				{
					About.this.dispose();
				}
				public void mouseEntered(MouseEvent e)
				{
					Cursor sss=new Cursor(Cursor.HAND_CURSOR);
					setCursor(sss);
				}
				public void mouseExited(MouseEvent e)
				{
					Cursor sss=new Cursor(Cursor.DEFAULT_CURSOR);
					setCursor(sss);
				}
				public void mousePressed(MouseEvent e){}
				public void mouseReleased(MouseEvent e){}
			});

		mpl=new MyPicLabel();
		mpl.setBounds(10,100,128,128);

		TextPan1=new JTextPane();
		TextPan1.setEditable(false);
		TextPan2=new JTextPane();
		TextPan2.setEditable(false);

		TextPan1.setBounds(185,100,310,25);
		TextPan1.setText("JAVA实现的文件压缩工具");
		TextPan2.setBounds(185,120,310,110);
		TextPan2.setText("版本号：V1.0  \n作  者：分析设计:ljheee\n              程序编写:ljheee\n日  期：2016年9月25日\nBlog：my.csdb.net/ljheee\nEMAIL ：jianhua4lee@gmail.com\n公  司：ljheee科技有限公司");//(Tarena IT Training Group)


		t.start();
		len=s.length();
		for(int i=0;i<spacelen;i++)
		{
			s.insert(0,' ');
		}
		Container con=getContentPane();
		con.setBackground(Color.white);
		con.setLayout(null);
		con.add(CenLab);
		con.add(TopLab);
		con.add(mpl);
		con.add(TextPan1);
		con.add(TextPan2);
		con.add(LineLab);
		con.add(MaDengLab);
		con.add(btn);
		setVisible(true);
	}

	//走马灯效果
	class TimerEv implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			s.deleteCharAt(loop);
			s.insert(spacelen+loop,' ');
			over++;
			if(over>=15)
			{
				loop++;
				over=0;
			}
			if(loop==15)
			{
				t.stop();
			}
			MaDengLab.setText(""+s);
		}
	}
}

