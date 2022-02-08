package main.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main.LineDrawer;

public class Pattern1Panel extends JPanel{
	
	public int width;
	public int height;
	public Directions directions = Directions.DR;
	public LineDrawer lineDrawer;
	public boolean temp = true;
	
	public Pattern1Panel(int width, int height) {
		this.width = width;
		this.height = height;
		this.setSize(this.width,this.height);
		this.lineDrawer = new LineDrawer(this);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		System.out.println(height);
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		lineDrawer.x1 = 0;
		lineDrawer.x2 = 0;
		lineDrawer.y1 = 0;
		lineDrawer.y2 = 0;
		while(!(lineDrawer.x2 >= width && lineDrawer.y2 >= height)) {
			switch(directions) {
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
				System.out.println("failed");
			}
			
		}
	}

}
