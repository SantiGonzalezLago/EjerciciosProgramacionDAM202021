package gal.teis.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
class MainPanel extends JPanel {

	private JFrame frame;

	public MainPanel(JFrame frame) {
		this.frame = frame;
		setBackground(Color.PINK);

		JButton soundBtn = new JButton("EMITIR SONIDO");
		add(soundBtn);
		soundBtn.addActionListener((e) -> {
			Runnable ru = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
			if (Objects.nonNull(ru)) {
				ru.run();
			}
		});

		JButton colorBtn = new JButton("CAMBIAR COLOR");
		add(colorBtn);
		colorBtn.addActionListener((e) -> {
			setBackground(getBackground() == Color.PINK ? Color.CYAN : Color.PINK);
		});

		JButton shakeBtn = new JButton("¡TERREMOTO!");
		add(shakeBtn);
		shakeBtn.addActionListener((e) -> {
			new Thread(() -> {
				shakeBtn.setEnabled(false);
				int xDisplacement = 5;
				int yDisplacement = 10;
				Point currLocation = frame.getLocationOnScreen();
				Point p1 = new Point(currLocation.x + xDisplacement, currLocation.y + yDisplacement);
				Point p2 = new Point(currLocation.x - xDisplacement, currLocation.y - yDisplacement);
				Point p3 = new Point(currLocation.x + xDisplacement, currLocation.y - yDisplacement);
				Point p4 = new Point(currLocation.x - xDisplacement, currLocation.y + yDisplacement);
				long endTime = 3000 + System.currentTimeMillis();
				while (System.currentTimeMillis() < endTime) {
					frame.setLocation(p1);
					frame.setLocation(p2);
					frame.setLocation(p3);
					frame.setLocation(p4);
				}
				frame.setLocation(currLocation);
				shakeBtn.setEnabled(true);
			}).start();
		});

		JButton blinkBtn = new JButton("PARPADEO");
		add(blinkBtn);
		blinkBtn.addActionListener((e) -> {
			new Thread(() -> {
				blinkBtn.setEnabled(false);
				int frequency = 2;
				for (int i = 0; i < 3 * frequency; i++) {
					try {
						setVisible(false);
						Thread.sleep(1000 / (2 * frequency));
						setVisible(true);
						Thread.sleep(1000 / (2 * frequency));
					} catch (Exception ex) {
						setVisible(true);
					}
				}
				blinkBtn.setEnabled(true);
			}).start();
		});

		JButton reverseBtn = new JButton("INVERTIR");
		add(reverseBtn);
		reverseBtn.addActionListener((e) -> {
			for (Component c : getComponents()) {
				if (c instanceof JButton) {
					((JButton) c).setText(new StringBuilder(((JButton) c).getText()).reverse().toString());
				}
				
			}
		});

		JButton trollBtn = new JButton("NO PULSES ESTE BOTÓN");
		add(trollBtn);
		trollBtn.addActionListener((e) -> {
			MouseAdapter ma = new MouseAdapter() {				
				public void mouseEntered(MouseEvent evt) {
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int xPos = (int) ((screenSize.width - frame.getWidth()) * Math.random());
					int yPos = (int) ((screenSize.height - frame.getHeight()) * Math.random());
					frame.setLocation(xPos, yPos);
				}
			};
			for (Component c : getComponents()) {
				c.addMouseListener(ma);
			}
			frame.setTitle("TE DIJE QUE NO PULSASES ESE BOTÓN");
		});

		JButton closeBtn = new JButton("INICIAR SECUENCIA DE AUTODESTRUCCIÓN");
		add(closeBtn);
		closeBtn.addActionListener((e) -> {
			closeBtn.setEnabled(false);
			new Thread(() -> {
				try {
					for (int i = 5; i > 0; i--) {
						frame.setTitle(String.format("AUTODESTRUCCIÓN EN %d SEGUNDO%s", i, i==1?"":"S"));
						Thread.sleep(1000);
					}
					System.exit(0);
				} catch (Exception ex) {
					System.exit(-1);
				}
			}).start();
		});
	}

//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//
//		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
//		g.setColor(Color.BLUE);
//		g.drawString("Como mola dormir, eso se me da de muerte", 50, 150);
//		g.drawRect(25, 120, 470, 50);
//		Graphics2D g2 = (Graphics2D) g;
//		g2.setColor(Color.BLACK);
//		Rectangle2D rectangle = new Rectangle2D.Double(100, 200, 200, 150);
//		g2.fill(rectangle);
//	}

}
