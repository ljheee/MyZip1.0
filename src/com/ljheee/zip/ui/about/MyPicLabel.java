package com.ljheee.zip.ui.about;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.geom.*;
import java.text.*;
import java.awt.image.*;
import javax.swing.Timer;
import java.net.*;

class MyPicLabel extends JLabel implements Runnable
{
	private static final long serialVersionUID = -364635881768636623L;
	int id=0;int a=200;
	boolean flag=false;
	Thread th=null;
	Image img[]=new Image[2];
	BufferedImage bi=null;
	Graphics gg=null;
	URL url[]=new URL[]{MyPicLabel.class.getResource("21.jpg"),MyPicLabel.class.getResource("A3.jpg")};

	public MyPicLabel()
	{
		GregorianCalendar  jj=new GregorianCalendar();

		Toolkit tk=this.getToolkit();
		img[0]=tk.createImage(url[0]);
		img[1]=tk.createImage(url[1]);
		try
		{
			MediaTracker mt=new MediaTracker(this);
			mt.addImage(img[0],0);
			mt.addImage(img[1],0);
			mt.waitForAll();
		}catch(Exception err){}
		bi=new  BufferedImage(128,128,BufferedImage.TYPE_INT_ARGB);
		gg=bi.createGraphics();
		th=new Thread(this);
		th.start();
	}

	public void paint(Graphics g1)
	{
		Graphics2D g=(Graphics2D)g1;


		gg.drawImage(img[id],0,0,130,130,0,0,130,130,this);
		for(int j=0;j<128;j++)
		{
			for(int i=0;i<128;i++)
			{
				int pix=bi.getRGB(i,j);
				Color c=new Color(pix);
				int r=c.getRed();
				int gr=c.getGreen();
				int b=c.getBlue();
				int newpix=new Color(r,gr,b,a).getRGB();
				bi.setRGB(i,j,newpix);
			}
		}
		g.setColor(Color.white);
		g.drawImage(bi,0,0,this);

	}

	public void run()
	{
		while(th!=null)
		{
			if(flag)
			{
				a+=4;
				if(a==200){flag=!flag;}
			}
			else
			{
				a-=4;
				if(a==0)
				{
					flag=!flag;
					id++;
					if(id==2) id=0;
				}
			}
			repaint();
			try
			{
				Thread.currentThread().sleep(100);
			}catch(Exception err){}
		}
	}
}