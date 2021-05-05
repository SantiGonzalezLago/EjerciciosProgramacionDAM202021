package gal.teis.gui2;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class NoLayoutFrame extends JFrame {

	private JButton btn;

	public NoLayoutFrame() {
		setLayout(null);

		btn = new JButton("Estoy en mi posición");
		btn.setBounds(50, 150, 150, 30);
		add(btn);

		setVisible(true);
		setBounds(700, 300, 300, 300);
		setTitle("Componentes y posición");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
