package st;

import java.awt.*;//用了graphics
import java.util.Date;

public class st	extends java.applet.Applet implements Runnable{	//总的括号
	Thread trl=null;
	public void init() {}
	public void start() {
		trl=new Thread(this);
		trl.start();
	}
	public void stop() {}
	public void destroy() {}
	public void paint(Graphics g)
	{
		Date timeNow=new Date();
		Clock myClock=new 
							Clock(timeNow.getHours(),
								timeNow.getMinutes(),
								timeNow.getSeconds());
		myClock.show(g,100,100,100);
	}
	public void run() {
		while (true) {
		repaint();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class Clock {
	int hours,minutes,second,radius;
	Clock(int hrs,int min,int sec)
	{
		hours=hrs%12;
		minutes=min;
		second=sec;
		
	}
	void show(Graphics g,int x,int y,int radius)
	{
		int hrs_len=(int)(radius*0.5);
		int min_len=(int)(radius*0.7);
		int sec_len=(int)(radius*0.85);
		double theta;
		g.drawOval(x-radius, y-radius, radius*2, radius*2);
		theta=(double)(hours*60*60+minutes*60+second)/43200.0*2.0*Math.PI;
		drawNiddle(g,Color.blue,x,y,hrs_len,theta);
		theta=(double)(minutes*60-second)/3600.0*2.0*Math.PI;
		drawNiddle(g,Color.blue,x,y,min_len,theta);
		theta=(double)(second)/60.0*2.0*Math.PI;
		drawNiddle(g,Color.red,x,y,sec_len,theta);
	}
	private void drawNiddle(Graphics g, Color c, int x, int y, int len, double theta) {
		// TODO Auto-generated method stub
		g.setColor(c);
		g.drawLine(x, y, (int)(x+len*Math.sin(theta)),(int)(y-len*Math.cos(theta)));
	}
	
	}
}
