package com.ljheee.zip.ui.about;
import java.awt.*;
import javax.swing.*;

class MyDongcLabel extends JLabel implements Runnable
{
	private static final long serialVersionUID = 941392629959395233L;
	int a=0;
	Thread th=null;
	public MyDongcLabel()
	{
		setSize(470,10);
		setOpaque(true);
		th=new Thread(this);
		th.start();
	}

	public void paint(Graphics oldg)
	{
		Graphics2D g=(Graphics2D)oldg;
		g.setStroke(new BasicStroke(20));
		g.setPaint(new GradientPaint(a,20,Color.white,a+250,20,new Color(98,102,200),true));
		g.drawLine(0,0,470,0);
	}

	public void run()
	{
		while(true)
		{
			a+=3;
			repaint();
			try
			{
				Thread.currentThread().sleep(11);
			}catch(Exception e){}

		}
	}
}