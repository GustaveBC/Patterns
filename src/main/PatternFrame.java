package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.panels.Pattern1Panel;
import main.panels.Pattern2Panel;

public class PatternFrame extends JFrame implements ActionListener{
	
	private JButton button;
	private JButton pattern1;
	private JButton pattern2;
	private JTextField resizeInformation;
	private JLabel resizeInstruction;

	public int resizeWidth;
	public int resizeHeight;
	public int screenWidth = 800; 
	public int screenHeight = 600;
	
	private boolean patternChoice = true;//true for pattern1, false for pattern2
	
	public PatternFrame() {
		this.setSize(screenWidth, screenHeight);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
		this.setResizable(false);	
		this.setTitle("Patterns v1");
		this.setLayout(null);
		
		resizeInstruction = new JLabel();
		resizeInstruction.setFont(new Font("Sans Script", Font.PLAIN,12));
		resizeInstruction.setText("<html><hr> Please insert the Width and Height for the pattern, separated by commas. Both should be between 50 and 2000(pixels)<hr></html>");
		resizeInstruction.setBounds((screenWidth-250)/2, 130, 250, 65);
		
		resizeInformation = new JTextField();
		resizeInformation.setBounds((screenWidth-50)/2, 200, 50, 30);
		resizeInformation.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		button = new JButton("Start");
		button.setBounds((screenWidth-100)/2, (screenHeight-50)/2, 100, 50);
		button.setBackground(Color.LIGHT_GRAY);
		button.setFocusable(false);
		button.addActionListener(this);
		
		pattern1 = new JButton("Angles");
		pattern1.setFocusable(false);
		pattern1.setBackground(Color.WHITE);
		pattern1.addActionListener(this);
		pattern1.setBounds((int) ((screenWidth-100)*0.25), (screenHeight-50)/2, 100, 50);
		
		pattern2 = new JButton("Line");
		pattern2.setFocusable(false);
		pattern2.setBackground(Color.WHITE);
		pattern2.addActionListener(this);
		pattern2.setBounds((int) ((screenWidth-100)*0.75), (screenHeight-50)/2, 100, 50);
		
		addComponents();
	}

	private void addComponents() {
		this.add(resizeInformation);
		this.add(button);
		this.add(resizeInstruction);
		this.add(pattern1);
		this.add(pattern2);
		this.repaint();
		
	}
	

	
	public void resizeFrame(int width, int height) {
		screenWidth = width;
		screenHeight = height;
		this.setSize(screenWidth,screenHeight);
	}
	
	private boolean checkIfCorrect(String temporaryData) {
		String[] splitted = temporaryData.split(",");
		try{
			int width = Integer.valueOf(splitted[0]);
			int height = Integer.valueOf(splitted[1]);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
		
	}
	
	public void changeToPanel() {
		this.getContentPane().removeAll();
		
		if(patternChoice) {
			this.add(new Pattern1Panel());
		}
		else {
			this.add(new Pattern2Panel());
		}
		
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			if(!checkIfCorrect(resizeInformation.getText())) {
				resizeInformation.setText("Error");
				return;
			}
			resizeWidth = Integer.valueOf(resizeInformation.getText().split(",")[0]);
			resizeHeight = Integer.valueOf(resizeInformation.getText().split(",")[1]);
			
			this.changeToPanel();
			this.resizeFrame(resizeWidth, resizeHeight);
		}
		if(e.getSource() == pattern1) {
			pattern1.setBackground(Color.GREEN);
			patternChoice = true;
		}
		if(e.getSource() == pattern2) {
			pattern2.setBackground(Color.GREEN);
			patternChoice = false;
		}
		
	}
	
}
