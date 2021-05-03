package gal.teis.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	public MainPanel() {
		setOpaque(false);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g.setColor(Color.BLUE);
		g.drawString("Como mola dormir, eso se me da de muerte", 50, 50);
		g.drawRect(25, 20, 470, 50);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		Rectangle2D rectangle = new Rectangle2D.Double(100, 100, 200, 150);
		g2.fill(rectangle);
	}
	
}
