package colorGenerator;

import java.awt.Color;
import java.util.Random;

public class ColorGen {
	
	private Random random;
	private int r;
	private int g;
	private int b;
	private int hexR;
	private int hexG;
	private int hexB;
	private int hexR2;
	private int hexG2;
	private int hexB2;
	private double hspValue;
	public String rgb;
	public String hex;
	public String colorURL;
	public String hspString;
	
	public Color bgColor;
	
	ColorGen() {
		
		rgbGen();
		hexGen(r,g,b);
		hspGen(r,g,b);
		bgColor = new Color(r,g,b);
		colorURL = (String.format("https://convertingcolors.com/rgb-color-%d_%d_%d.html",r,g,b));

		
	}
	
	private void rgbGen() {
		random = new Random();
		
		 r = random.nextInt(1, 256);
		 g = random.nextInt(1, 256);
		 b = random.nextInt(1, 256);
		 
		 rgb = String.format("RGB:  (%d, %d, %d)",r, g, b);
	}
	
	private void hexGen(int r, int g, int b) {
		hexR = (int) Math.floor((double) r/16);
		hexG = (int) Math.floor((double) g/16);
		hexB = (int) Math.floor((double) b/16);
		
		hexR2 = (int) (16 *((double) r / 16 - Math.floor(r / 16)));
		hexG2 = (int) (16 *((double) g / 16 - Math.floor(g / 16)));
		hexB2 = (int) (16 *((double) b / 16 - Math.floor(b / 16)));
		
		hexConverter(Integer.toString(hexR));
		hexConverter(Integer.toString(hexG));
		hexConverter(Integer.toString(hexB));
		hexConverter(Integer.toString(hexR2));
		hexConverter(Integer.toString(hexG2));
		hexConverter(Integer.toString(hexB2));
		
		hex = String.format("HEX:  #%x%x%x%x%x%x", hexR, hexR2, hexG, hexG2, hexB, hexB2).toUpperCase();
		
	}
	
	private void hexConverter(String x) {
		if(x == "10") {
			x = "A";
		}
		else if(x == "11") {
			x = "B";
		}
		else if(x == "12") {
			x = "C";
		}
		else if(x == "13") {
			x = "D";
		}
		else if(x == "14") {
			x = "E";
		}
		else if(x == "15") {
			x = "F";
		}
	}
	
	private void hspGen(int r,int g, int b) { // HSP equation from http://alienryderflex.com/hsp.html
		
		hspValue = Math.sqrt(
			    0.299 * (r * r) +
			    0.587 * (g * g) +
			    0.114 * (b * b)
			    );
		
		if(hspValue > 127.5) {
			hspString = "Light";
		}
		else {
			hspString = "Dark";
		}
		
	}
}
