package main.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main.LineDrawer;

public class Pattern1Panel extends JPanel{
	
	public int width1;
	public int height1;
	public Directions directions1 = Directions.DR;
	public LineDrawer lineDrawer;
	
	public Pattern1Panel(int width, int height) {
		this.width1 = width;
		this.height1 = height;
		this.setSize(this.width1,this.height1);
		this.lineDrawer = new LineDrawer(this);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		System.out.println(height);
//		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		directions1 = Directions.DR;
		System.out.println("REPAINTED");
		lineDrawer.x1 = 0;
		lineDrawer.x2 = 0;
		lineDrawer.y1 = 0;
		lineDrawer.y2 = 0;
		g.setColor(Color.BLACK);
		while((lineDrawer.x2 < width1 || lineDrawer.y2 < height1) && (lineDrawer.x2 > 0 || lineDrawer.y2 < height1) && (lineDrawer.x2 < width1 || lineDrawer.y2 > 0)) {
//		for(int i = 0; i<2; i++) {
			switch(directions1) {
			case DR:
				lineDrawer.goDR1(g);
				break;
			case UR:
				lineDrawer.goUR1(g);
				break;
			case UL:
				lineDrawer.goUL1(g);
				break;
			case DL:
				lineDrawer.goDL1(g);
				
			default:
				System.out.println(directions1.toString());
			}
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(lineDrawer.x2+" "+lineDrawer.y2);
		}
	}

}
