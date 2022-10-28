package colorGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ProgramFrame extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ColorGen colorGen;
	private JButton button;
	private JPanel panel;
	private JLabel rgbLabel;
	private JLabel hexLabel;

	private String RGB;
	private String HEX;
	private int count;
	
	ProgramFrame() {
		
		button = new JButton("Generate");
		button.setBounds(75, 275, 150, 35);
		button.addActionListener(this);
		
		panel = new JPanel();
		panel.setBounds(75, 100, 150, 150);
		
		rgbLabel = new JLabel("RBG:  (0, 0, 0)");
		rgbLabel.setBounds(300, 100, 200, 35);
		rgbLabel.setFont(new Font("Times Roman", Font.BOLD, 20));
		
		hexLabel = new JLabel("HEX:  #FFFFFF");
		hexLabel.setBounds(300, 100, 200, 135);
		hexLabel.setFont(new Font("Times Roman", Font.BOLD, 20));

		this.setTitle("Color Generator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.add(panel);
		this.add(button);
		this.add(rgbLabel);
		this.add(hexLabel);
		this.setVisible(true);
	}
	
	private void setColor() {
		
		ColorGen colorGen = new ColorGen();
		RGB = colorGen.rgb;
		HEX = colorGen.hex;
		
		panel.setBackground(colorGen.bgColor);
		rgbLabel.setText(RGB);
		hexLabel.setText(HEX);
	}
	
	private void saveColor(String hex, String rgb) {
		
		count +=1;
		System.out.println(String.format("Color %d:\n%s, \n%s\n" ,count,rgb, hex));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button) {
			setColor();
			saveColor(HEX, RGB);
		}
		
	}

}
