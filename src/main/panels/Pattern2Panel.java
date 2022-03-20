package main.panels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main.LineDrawer;

public class Pattern2Panel extends JPanel{
	
	public int width2;
	public int height2;
	private LineDrawer lineDrawer;
	public Directions directions2 = Directions.DR;

	public Pattern2Panel(int screenWidth, int screenHeight) {
		this.width2 = screenWidth;
		this.height2 = screenHeight;
		this.setSize(this.width2,this.height2);
		this.lineDrawer = new LineDrawer(this);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		directions2 = Directions.DR;
		System.out.println("REPAINTED");
		lineDrawer.x1 = 0;
		lineDrawer.x2 = 0;
		lineDrawer.y1 = 0;
		lineDrawer.y2 = 0;
		g.setColor(Color.BLACK);
		while((lineDrawer.x2 < width2 || lineDrawer.y2 < height2) && (lineDrawer.x2 > 0 || lineDrawer.y2 < height2) && (lineDrawer.x2 < width2 || lineDrawer.y2 > 0)) {
//		for(int i = 0; i<6; i++) {
			switch(directions2) {
			case DR:
				lineDrawer.goDR2(g);
				break;
			case UR:
				lineDrawer.goUR2(g);
				break;
			case UL:
				lineDrawer.goUL2(g);
				break;
			case DL:
				lineDrawer.goDL2(g);
				
			default:
				System.out.println(directions2.toString());
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
