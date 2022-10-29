package colorGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class ProgramFrame extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ColorGen colorGen;
	private JButton genButton;
	private JButton urlButton;
	private JPanel colorPanel;
	private JLabel rgbLabel;
	private JLabel hexLabel;
	private JLabel hspLabel;
	private JLabel imgLabel;

	private final Color BG_COLOR = new Color(33, 22, 33);
	private String RGB;
	private String HEX;
	private String colorURL;
	private String hspString;
	private int count;
	
	ProgramFrame() {
		
		genButton = new JButton("Generate");	
		genButton.setBounds(75, 275, 150, 35);
		genButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		genButton.setFocusPainted(false);
		genButton.setBackground(Color.white);
		genButton.setForeground(Color.white);
		genButton.setOpaque(false);
		genButton.addActionListener(this);
		
		urlButton = new JButton("Color Info...");
		urlButton.setBounds(75, 40, 150, 35);
		urlButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		urlButton.setFocusPainted(false);
		urlButton.setBackground(Color.white);
		urlButton.setForeground(Color.white);
		urlButton.setOpaque(false);
		urlButton.addActionListener(this);
		
		colorPanel = new JPanel();
		colorPanel.setBounds(75, 100, 150, 150);
		colorPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		
		rgbLabel = new JLabel("RBG:  (255, 255, 255)", SwingConstants.CENTER);
		rgbLabel.setBounds(300, 100, 200, 35);
		rgbLabel.setFont(new Font("Font.SANS_SERIFs",Font.BOLD, 15));
		rgbLabel.setForeground(Color.white);
		rgbLabel.setBackground(BG_COLOR);
		rgbLabel.setOpaque(true);
		rgbLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,2 ));
		
		hexLabel = new JLabel("HEX:  #FFFFFF", SwingConstants.CENTER);
		hexLabel.setBounds(300, 157, 200, 35);
		hexLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		hexLabel.setForeground(Color.white);
		hexLabel.setBackground(BG_COLOR);
		hexLabel.setOpaque(true);
		hexLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		
		hspLabel = new JLabel("Brightness:  Light", SwingConstants.CENTER);
		hspLabel.setBounds(300, 215, 200, 35);
		hspLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		hspLabel.setForeground(Color.white);
		hspLabel.setBackground(BG_COLOR);
		hspLabel.setOpaque(true);
		hspLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		
		imgLabel = new JLabel("<html>Color<br/>Generator<br/>---------</html>", SwingConstants.CENTER);
		imgLabel.setBounds(550, 100, 200,150);
		imgLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
		imgLabel.setForeground(Color.white);

		this.setTitle("Color Generator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.getContentPane().setBackground(BG_COLOR);
		this.add(colorPanel);
		this.add(genButton);
		this.add(urlButton);
		this.add(rgbLabel);
		this.add(hexLabel);
		this.add(hspLabel);
		this.add(imgLabel);
		this.setVisible(true);
	}
	
	private void setColor() {
		
		ColorGen colorGen = new ColorGen();
		RGB = colorGen.rgb;
		HEX = colorGen.hex;
		hspString = String.format("Brightness:  %s",colorGen.hspString);
		colorURL = colorGen.colorURL;
		
		colorPanel.setBackground(colorGen.bgColor);
		
		hexLabel.setBackground(colorGen.bgColor);
		rgbLabel.setBackground(colorGen.bgColor);
		hspLabel.setBackground(colorGen.bgColor);
		
		hexLabel.setForeground(fgCheck(colorGen.hspString));
		rgbLabel.setForeground(fgCheck(colorGen.hspString));
		hspLabel.setForeground(fgCheck(colorGen.hspString));
		imgLabel.setForeground(colorGen.bgColor);
		
		rgbLabel.setText(RGB);
		hexLabel.setText(HEX);
		hspLabel.setText(hspString);
	}
	
	private Color fgCheck(String hsp) {
		if(hsp == "Light") {
			return Color.BLACK;
		}
		else {
			return Color.WHITE;
		}
	}
	
	private void saveColor(String hex, String rgb) {
		count +=1;
		System.out.println(String.format("Color %d:\n%s, \n%s, \n%s\n" ,count,rgb, hex, hspString));
		
	}
	
	private void urlGenerator() {
		
			try {
				Desktop.getDesktop().browse(new URL(colorURL).toURI());
			} catch (IOException | URISyntaxException e1) {
				e1.printStackTrace();
			}
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == genButton) {
			setColor();
			saveColor(HEX, RGB);
		
	}			
			if(e.getSource() == urlButton) {
				urlGenerator();
			}
		}
	}
