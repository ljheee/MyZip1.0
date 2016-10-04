package com.ljheee.zip.ui.about;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.geom.*;

public class MyBorder implements Border
{
	GradientPaint gp=null;
	Timer t=new Timer(100,new Dong());
	int pos=0;
	boolean b=true;
	Component cc=null;
	public MyBorder(Component cc)
	{
		this.cc=cc;
		cc.addMouseListener(new MouseE());
	}

	class MouseE implements MouseListener
	{

		public void mouseClicked(MouseEvent e)
		{}
		public void mouseEntered(MouseEvent e)
		{
			if(t.isRunning())
			{
				t.stop();
				t.restart();
			}
			else
			{
				t.start();
			}
		}
		public void mouseExited(MouseEvent e)
		{
			if(t.isRunning())
			{
				t.stop();
			}
		}
		public void mousePressed(MouseEvent e)
		{

		}
		public void mouseReleased(MouseEvent e)
		{
			//cc.setBorder(new BevelBorder(BevelBorder.RAISED));
		}
	}

	class Dong implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			cc.repaint();
		}
	}
	public Insets getBorderInsets(Component c)
	{
		return new Insets(0,0,0,0);
	}
	public boolean isBorderOpaque()
	{
		return true;
	}
	public void paintBorder(Component c, Graphics oldg, int x, int y, int w, int h)
	{

		if(b)
		{
			pos+=5;
			if(pos>=255)
			{
				b=false;
			}
		}
		if(!b)
		{
			pos-=5;
			if(pos<=0)
			{
				b=true;
			}
		}
		Graphics2D gg=(Graphics2D)oldg;
		gp=new GradientPaint(pos,0,new Color(200,200,0,150),10+pos,30,new Color(98,22,200,100),true);
		gg.setPaint(gp);
		gg.setStroke(new BasicStroke(5));

		Rectangle2D br=new Rectangle2D.Double(x,y,w,h);
		gg.draw(br);
	}
}