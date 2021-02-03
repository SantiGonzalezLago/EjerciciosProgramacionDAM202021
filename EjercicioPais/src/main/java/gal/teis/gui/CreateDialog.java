package gal.teis.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gal.teis.model.Country;
import gal.teis.model.GovernmentSystem;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class CreateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameField;
	private JTextField capitalField;
	private final ButtonGroup gsButtonGroup = new ButtonGroup();

	/**
	 * Create the dialog.
	 */
	public CreateDialog(JFrame frame) {
		super(frame, true);
		setTitle("Añadir país");
		setBounds(100, 100, 329, 172);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre");
			lblNewLabel.setBounds(10, 11, 90, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Capital");
			lblNewLabel_1.setBounds(10, 36, 90, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Forma de gobierno");
			lblNewLabel_2.setBounds(10, 61, 107, 14);
			contentPanel.add(lblNewLabel_2);
		}
		
		nameField = new JTextField();
		nameField.setBounds(125, 8, 177, 20);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
		capitalField = new JTextField();
		capitalField.setBounds(125, 33, 177, 20);
		contentPanel.add(capitalField);
		capitalField.setColumns(10);
		
		JRadioButton monRadioButton = new JRadioButton("Monarquía");
		gsButtonGroup.add(monRadioButton);
		monRadioButton.setBounds(123, 57, 90, 23);
		contentPanel.add(monRadioButton);
		
		JRadioButton repRadioButton = new JRadioButton("República");
		gsButtonGroup.add(repRadioButton);
		repRadioButton.setBounds(215, 57, 89, 23);
		contentPanel.add(repRadioButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				gsButtonGroup.add(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name, capital;
						GovernmentSystem gs = null;
						name = nameField.getText();
						capital = capitalField.getText();
						if (monRadioButton.isSelected()) {
							gs = GovernmentSystem.MONARCHY;
						} else if (repRadioButton.isSelected()) {
							gs = GovernmentSystem.REPUBLIC;
						}
						if (name.length() == 0) {
							JOptionPane.showMessageDialog(CreateDialog.this, "Es necesario un nombre", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							if (capital.length() == 0) {
								Country.countryList.add(new Country(name));
							} else {
								if (Objects.isNull(gs)) {
									Country.countryList.add(new Country(name, capital));
								} else {
									Country.countryList.add(new Country(name, capital, gs));
								}
							}
							JOptionPane.showMessageDialog(CreateDialog.this, "País añadido con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							CreateDialog.this.dispose();
						}
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				gsButtonGroup.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CreateDialog.this.dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}
}
