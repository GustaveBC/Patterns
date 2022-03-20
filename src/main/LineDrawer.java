package main;

import java.awt.Color;
import java.awt.Graphics;

import main.panels.Directions;
import main.panels.Pattern1Panel;
import main.panels.Pattern2Panel;

public class LineDrawer {
	
	private Pattern1Panel p1Panel;
	private Pattern2Panel p2Panel;
	
	public int x1;
	public int x2;
	public int y1;
	public int y2;
	public final int LINE_SIZE = 15;
	
	public boolean lineSquiggle = true;

	public LineDrawer(Pattern1Panel p1Panel) {
		this.p1Panel = p1Panel;
	}
	
	public LineDrawer(Pattern2Panel p2Panel) {
		this.p2Panel = p2Panel;
	}
	
	public void goDR1(Graphics g) {
		System.out.println("DR1");	
		while(x2 < p1Panel.width1 && y2 < p1Panel.height1) {
			x1 = x2;
			y1 = y2;
			if(lineSquiggle) {
				x2 += LINE_SIZE;
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = false;
			}else {
				y2 += LINE_SIZE;
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = true;
			}
		}
		if(x2 >= p1Panel.width1) {
			p1Panel.directions1 = Directions.DL;
		}else if(y2 >= p1Panel.height1) {
			p1Panel.directions1 = Directions.UR;
		}else {
			System.out.println(x1+" "+x2);
		}
	}

	public void goUR1(Graphics g) {
		System.out.println("UR1");	
		while(x2 < p1Panel.width1 && y2 > 0) {
			x1 = x2;
			y1 = y2;
			if(lineSquiggle) {
				x2 += LINE_SIZE;
				
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = false;
			}else {
				y2 -= LINE_SIZE;
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = true;
			}
		}
		if(x2 >= p1Panel.width1) {
			p1Panel.directions1 = Directions.UL;
		}else if(y2 <= 0) {
			p1Panel.directions1 = Directions.DR;
		}else {
			System.out.println(x1+" "+x2);
		}
		
	}
	public void goUL1(Graphics g) {
		System.out.println("UL1");	
		while(x2 > 0 && y2 > 0) {
			x1 = x2;
			y1 = y2;
			if(lineSquiggle) {
				x2 -= LINE_SIZE;
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = false;
			}else {
				y2 -= LINE_SIZE;
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = true;
			}
		}
		if(x2 <= 0) {
			p1Panel.directions1 = Directions.UR;
		}else if(y2 <= 0) {
			p1Panel.directions1 = Directions.DL;
		}else {
			System.out.println(x1+" "+x2);
		}
		
	}
	
	public void goDL1(Graphics g) {
		System.out.println("DL1");	
		while(x2 > 0 && y2 < p1Panel.width1) {
			x1 = x2;
			y1 = y2;
			if(lineSquiggle) {
				x2 -= LINE_SIZE;
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = false;
			}else {
				y2 += LINE_SIZE;
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = true;
			}
		}
		if(x2 <= 0) {
			p1Panel.directions1 = Directions.DR;
		}else if(y2 >= p1Panel.height1) {
			p1Panel.directions1 = Directions.UL;
		}else {
			System.out.println(x1+" "+x2);
		}
		
	}
	
	public void  goDR2(Graphics g) {
		System.out.println("DR2");
		while(x2 < p2Panel.width2 && y2 < p2Panel.height2) {
			
			x1 = x2;
			y1 = y2;
			x2 += LINE_SIZE;
			y2 += LINE_SIZE;
			if(lineSquiggle) {
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = false;
			}else {
				lineSquiggle = true;
			}
		}
		if(x2 >= p2Panel.width2) {
			p2Panel.directions2 = Directions.DL;
		}else if(y2 >= p2Panel.height2) {
			p2Panel.directions2 = Directions.UR;
		}else {
			System.out.println(x1+" "+x2);
		}
	}
	
	public void  goUR2(Graphics g) {
		System.out.println("UR2");
		while(x2 < p2Panel.width2 && y2 > 0) {
			
			x1 = x2;
			y1 = y2;
			x2 += LINE_SIZE;
			y2 -= LINE_SIZE;
			if(lineSquiggle) {
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = false;
			}else {
				lineSquiggle = true;
			}
		}
		if(x2 >= p2Panel.width2) {
			p2Panel.directions2 = Directions.UL;
		}else if(y2 <= 0) {
			p2Panel.directions2 = Directions.DR;
		}else {
			System.out.println(x1+" "+x2);
		}
	}
	
	public void  goUL2(Graphics g) {
		System.out.println("UL2");
		while(x2 > 0 && y2 > 0) {
			
			x1 = x2;
			y1 = y2;
			x2 -= LINE_SIZE;
			y2 -= LINE_SIZE;
			if(lineSquiggle) {
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = false;
			}else {
				lineSquiggle = true;
			}
		}
		if(x2 <= 0) {
			p2Panel.directions2 = Directions.UR;
		}else if(y2 <= 0) {
			p2Panel.directions2 = Directions.DL;
		}else {
			System.out.println(x1+" "+x2);
		}
	}
	
	public void  goDL2(Graphics g) {
		System.out.println("DL2");
		while(x2 > 0 && y2 < p2Panel.height2) {
			
			x1 = x2;
			y1 = y2;
			x2 -= LINE_SIZE;
			y2 += LINE_SIZE;
			if(lineSquiggle) {
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = false;
			}else {
				lineSquiggle = true;
			}
		}
		if(x2 <= 0) {
			p2Panel.directions2 = Directions.DR;
		}else if(y2 >= p2Panel.height2) {
			p2Panel.directions2 = Directions.UL;
		}else {
			System.out.println(x1+" "+x2);
		}
	}
}
