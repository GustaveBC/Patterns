package main;

import java.awt.Color;
import java.awt.Graphics;

import main.panels.Directions;
import main.panels.Pattern1Panel;
import main.panels.Pattern2Panel;

public class LineDrawer {
	
	private Pattern1Panel p1Panel;
	private Pattern2Panel p2Panel;
	
	public int x1 = 0;
	public int y1 = 0;
	public int x2 = 0;
	public int y2 = 0;
	public final int LINE_SIZE = 25;
	
	public boolean lineSquiggle = true;

	public LineDrawer(Pattern1Panel p1Panel) {
		this.p1Panel = p1Panel;
	}
	
	public LineDrawer(Pattern2Panel p2Panel) {
		this.p2Panel = p2Panel;
	}
	
	public void goDR1(Graphics g) {
		g.setColor(Color.BLACK);
		while(x2 < p1Panel.width || y2 < p1Panel.height) {
//		for(int i = 0; i<12; i++) {
			x1 = x2;
			y1 = y2;
			if(lineSquiggle) {
				x2 += LINE_SIZE;
				System.out.println("test");	
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = false;
			}else {
				y2 += LINE_SIZE;
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = true;
			}
		}
		if(x2 >= p1Panel.width) {
			p1Panel.directions = Directions.DL;
		}else if(y2 >= p1Panel.height) {
			p1Panel.directions = Directions.UR;
		}
	}

	public void goUR1(Graphics g) {
		p1Panel.temp = false;
		while(x2 < p1Panel.width || y2 > 0) {
//		for(int i = 0; i<12; i++) {
			x1 = x2;
			y1 = y2;
			if(lineSquiggle) {
				x2 += LINE_SIZE;
				System.out.println("yeah");	
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = false;
			}else {
				y2 -= LINE_SIZE;
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = true;
			}
		}
		if(x2 >= p1Panel.width) {
			p1Panel.directions = Directions.UL;
		}else if(y2 <= 0) {
			p1Panel.directions = Directions.DR;
		}
		
	}
	public void goUL1(Graphics g) {
		p1Panel.temp = false;
		while(x2 < p1Panel.width || y2 > 0) {
//		for(int i = 0; i<12; i++) {
			x1 = x2;
			y1 = y2;
			if(lineSquiggle) {
				x2 -= LINE_SIZE;
				System.out.println("hi");	
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = false;
			}else {
				y2 -= LINE_SIZE;
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = true;
			}
		}
		if(x2 <= 0) {
			p1Panel.directions = Directions.DL;
		}else if(y2 <= 0) {
			p1Panel.directions = Directions.UR;
		}
		
	}
	
	public void goDL1(Graphics g) {
		p1Panel.temp = false;
		while(x2 < p1Panel.width || y2 > 0) {
//		for(int i = 0; i<12; i++) {
			x1 = x2;
			y1 = y2;
			if(lineSquiggle) {
				x2 -= LINE_SIZE;
				System.out.println("hello");	
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = false;
			}else {
				y2 += LINE_SIZE;
				g.drawLine(x1, y1, x2, y2);
				lineSquiggle = true;
			}
		}
		if(x2 <= 0) {
			p1Panel.directions = Directions.UL;
		}else if(y2 >= p1Panel.height) {
			p1Panel.directions = Directions.DR;
		}
		
	}
}
