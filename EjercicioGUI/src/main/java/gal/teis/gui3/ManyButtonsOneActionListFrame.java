package gal.teis.gui3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ManyButtonsOneActionListFrame extends JFrame implements ActionListener {
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JLabel lbl;
	private final String LBL_TEXT = "Has pulsado el botón %d";

	public ManyButtonsOneActionListFrame() {
		setBounds(700, 300, 325, 300);
		setResizable(false);
		setTitle("Mismo evento en distintos componentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		btn1 = new JButton("1");
		btn1.setBounds(10, 10, 50, 50);
		add(btn1);
		btn1.addActionListener(this);

		btn2 = new JButton("2");
		btn2.setBounds(70, 10, 50, 50);
		add(btn2);
		btn2.addActionListener(this);

		btn3 = new JButton("3");
		btn3.setBounds(130, 10, 50, 50);
		add(btn3);
		btn3.addActionListener(this);
		
		lbl = new JLabel("Pulsa un botón", SwingConstants.CENTER);
		lbl.setBounds(10, 70, 170, 20);
		add(lbl);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			lbl.setText(String.format(LBL_TEXT, 1));
		} else if (e.getSource() == btn2) {
			lbl.setText(String.format(LBL_TEXT, 2));
		} else if (e.getSource() == btn3) {
			lbl.setText(String.format(LBL_TEXT, 3));
		}
	}

}
