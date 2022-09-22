package view;

import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.RegisterAccommodationController;
import model.Group;

/**
 * Classe herdeira de {@link JstructureRegisters}, a qual tem frame para registrar uma nova acomodação em cada grupo.
 * 
 * @see java.awt.event.ActionEvent
 * @see javax.swing.JFormattedTextField
 * @see javax.swing.JLabel
 * @see javax.swing.JTextField
 * @see javax.swing.SwingConstants
 * @see controller.RegisterAccommodationController
 * @see model.Group
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterAccommodation extends JstructureRegisters {
	private static final long serialVersionUID = 1L;
	private final JTextField fieldAccommodation, fieldCost, fieldLocale;
	private final JFormattedTextField accommodationDate;
	private Group pickedGroupEdit;
	private final RegisterAccommodationController controller = new RegisterAccommodationController(this);

	/**
	 * A classe recebe um tipo de hospedagem, um local de acomodação, o valor de da estadia e data de hospedagem.
	 * "setting" os paramêtros da classe mãe.
	 */
	public RegisterAccommodation(Group pickedGroupEdit) {
		super("Cadastre uma nova Acomodação");

		this.pickedGroupEdit = pickedGroupEdit;

		JLabel labelAccommodation = new JLabel("Tipo de hospedagem:");
		labelAccommodation.setFont(JstructureRegisters.FONT);
		labelAccommodation.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAccommodation.setBounds(169, 195, 175, 13);
		this.add(labelAccommodation);

		JLabel labelLocale = new JLabel("Local de hospedagem:");
		labelLocale.setFont(JstructureRegisters.FONT);
		labelLocale.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLocale.setBounds(169, 243, 175, 13);
		this.add(labelLocale);

		JLabel labelDate = new JLabel("Data de hospedagem:");
		labelDate.setFont(JstructureRegisters.FONT);
		labelDate.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDate.setBounds(158, 297, 186, 13);
		this.add(labelDate);

		JLabel labelCost = new JLabel("Preço da hospedagem:");
		labelCost.setFont(JstructureRegisters.FONT);
		labelCost.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCost.setBounds(82, 343, 262, 13);
		this.add(labelCost);

		fieldAccommodation = new JTextField();
		labelAccommodation.setLabelFor(fieldAccommodation);
		fieldAccommodation.setBounds(405, 192, 147, 19);
		this.add(fieldAccommodation);
		fieldAccommodation.setColumns(10);

		fieldLocale = new JTextField();
		labelLocale.setLabelFor(fieldLocale);
		fieldLocale.setBounds(405, 240, 147, 21);
		this.add(fieldLocale);
		fieldLocale.setColumns(10);

		accommodationDate = new JFormattedTextField(this.maskingDate());
		labelDate.setLabelFor(accommodationDate);
		accommodationDate.setBounds(405, 294, 147, 19);
		this.add(accommodationDate);

		fieldCost = new JTextField();
		labelCost.setLabelFor(fieldCost);
		fieldCost.setBounds(405, 343, 147, 19);
		this.add(fieldCost);
		fieldCost.setColumns(10);

	}

	public JTextField getFieldAccommodation() {
		return fieldAccommodation;
	}

	public JTextField getFieldCost() {
		return fieldCost;
	}

	public JFormattedTextField getFieldDate() {
		return accommodationDate;
	}

	public JTextField getFieldLocale() {
		return fieldLocale;
	}

	public RegisterAccommodationController getController() {
		return controller;
	}

	/**
	 * Método herdado de ActionListner, o qual sinconiza a view com sua respectiva controller.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.sendAction(e.getSource());
	}

	public Group getPickedGroupEdit() {
		return pickedGroupEdit;
	}
}
