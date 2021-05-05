package gal.teis.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
class MainPanel extends JPanel {

	public MainPanel() {
		JButton soundBtn = new JButton("EMITIR SONIDO");
		add(soundBtn);
		soundBtn.addActionListener((e) -> {
			Runnable ru = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
			if (Objects.nonNull(ru)) {
				ru.run();
			}
		});

		setBackground(Color.PINK);
		JButton colorBtn = new JButton("CAMBIAR COLOR");
		add(colorBtn);
		colorBtn.addActionListener((e) -> {
			setBackground(getBackground() == Color.PINK ? Color.GREEN : Color.PINK);
		});

		JButton closeBtn = new JButton("INICIAR SECUENCIA DE AUTODESTRUCCIÓN");
		add(closeBtn);
		closeBtn.addActionListener((e) -> {
			new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
						System.exit(0);
					} catch (Exception excep) {
						System.exit(-1);
					}
				}
			}.run();
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
