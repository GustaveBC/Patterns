package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.panels.Pattern1Panel;
import main.panels.Pattern2Panel;

public class PatternFrame extends JFrame implements ActionListener{
	
	private JButton button;
	private JButton pattern1;
	private JButton pattern2;
	private JTextField resizeInformation;
	private JLabel resizeInstruction;
	private JLabel sizeOf;

	public int resizeWidth;// bother resize[] variables will be the generated pannel's dimension
	public int resizeHeight;
	public int screenWidth = 800; //those two variables will be the frame's dimension
	public int screenHeight = 600;
	
	private boolean patternChoice = true;//true for pattern1, false for pattern2
	
	public PatternFrame() {
		this.setSize(screenWidth, screenHeight);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.setResizable(false);	
		this.setTitle("Patterns v1");
		this.setLayout(null);
		
		resizeInstruction = new JLabel();
		resizeInstruction.setFont(new Font("Sans Script", Font.PLAIN,12));
		resizeInstruction.setText("<html><hr> Please insert the Width and Height for the pattern, separated by commas. Be careful: the dimensions are in pixels*15. If the dimensions given are superior to the one of your monitor, visual bugs may occur<hr></html>");
		//resize informations are mutliplied by  15 afterwards.
		resizeInstruction.setBounds((screenWidth-250)/2, 100, 250, 95);
		
		resizeInformation = new JTextField();
		resizeInformation.setBounds((screenWidth-50)/2, 200, 50, 30);
		resizeInformation.setBorder(BorderFactory.createLineBorder(Color.BLACK));//125,83
		
		button = new JButton("Start");
		button.setBounds((screenWidth-100)/2, (screenHeight-50)/2, 100, 50);
		button.setBackground(Color.LIGHT_GRAY);
		button.setFocusable(false);
		button.addActionListener(this);
		
		pattern1 = new JButton("Pattern 1");
		pattern1.setFocusable(false);
		pattern1.setBackground(Color.WHITE);
		pattern1.addActionListener(this);
		pattern1.setBounds((int) ((screenWidth-100)*0.25), (screenHeight-50)/2, 100, 50);
		
		pattern2 = new JButton("Pattern 2");
		pattern2.setFocusable(false);
		pattern2.setBackground(Color.WHITE);
		pattern2.addActionListener(this);
		pattern2.setBounds((int) ((screenWidth-100)*0.75), (screenHeight-50)/2, 100, 50);
		
		sizeOf = new JLabel();
		sizeOf.setFont(new Font("Sans Script", Font.PLAIN,15));
		sizeOf.setBackground(Color.WHITE);
		sizeOf.setBounds((screenWidth-50)/2,screenHeight-20,50,20);
		sizeOf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		addComponents();
	}

	private void addComponents() {
		this.add(resizeInformation);
		this.add(button);
		this.add(resizeInstruction);
		this.add(pattern1);
		this.add(pattern2);
		this.getContentPane().repaint();
		
	}
	

	
	public void resizeFrame(int width, int height) {
		screenWidth = width+100;
		screenHeight = height+100;
		this.setSize(screenWidth, screenHeight);
	}
	
	private boolean checkIfCorrect(String temporaryData) {
		try {
			String[] splitted = temporaryData.split(",");
			try{
				int width = Integer.valueOf(splitted[0]);
				int height = Integer.valueOf(splitted[1]);
				return true;
			}catch(NumberFormatException e) {
				return false;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public void changeToPanel() {
		
		
		this.getContentPane().removeAll();
		
		if(patternChoice) {
			 Pattern1Panel p1Panel = new Pattern1Panel(resizeWidth,resizeHeight);
			 p1Panel.setBounds(50,0,resizeWidth,resizeHeight);
			 
			 this.add(p1Panel);
		}
		else {
			Pattern2Panel p2Panel = new Pattern2Panel(resizeWidth,resizeHeight);
			p2Panel.setBounds(50,0,resizeWidth,resizeHeight);
			
			this.add(p2Panel);
		}
		sizeOf.setBounds((resizeWidth-50)/2,resizeHeight+30,100,20);
		sizeOf.setText(resizeWidth/15+","+resizeHeight/15);
		this.add(sizeOf);
		this.getContentPane().repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			if(!checkIfCorrect(resizeInformation.getText())) {
				resizeInformation.setText("Error");
				return;
			}
			resizeWidth = Integer.valueOf(resizeInformation.getText().split(",")[0])*15;
			resizeHeight = Integer.valueOf(resizeInformation.getText().split(",")[1])*15;
			
			this.resizeFrame(resizeWidth, resizeHeight);// PUT RESIZE FIRST
			System.out.println(screenWidth);
			this.changeToPanel();
		}
		if(e.getSource() == pattern1) {
			pattern1.setBackground(Color.GREEN);
			pattern2.setBackground(Color.WHITE);
			patternChoice = true;
		}
		if(e.getSource() == pattern2) {
			pattern2.setBackground(Color.GREEN);
			pattern1.setBackground(Color.WHITE);
			patternChoice = false;
		}
		
	}
	
}
//I have recently interested myself in computer generated patterns. 
//Sadly, as a 1st year high school student, I am incapable of making sense of these results. The google doc linked sums it pretty well, and shows neat visual examples.
//Tell me what you guys think about all of this! I haven't seen it anywhere else.

//https://docs.google.com/document/d/1s22yAVgPNHMNY0aW7Dg7D6Gl9_9rRHNKq9G655xBm3E/edit?usp=sharing