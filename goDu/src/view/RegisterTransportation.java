package view;

import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.RegisterTransportationController;
import model.Group;

/**
 * Classe herdeira de {@link JstructureRegisters}, a qual tem frame para
 * registrar um novo transporte em cada grupo.
 * 
 * @see java.awt.event.ActionEvent
 * @see javax.swing.JFormattedTextField
 * @see javax.swing.JLabel
 * @see javax.swing.JTextField
 * @see javax.swing.SwingConstants
 * @see controller.RegisterTransportationController
 * @see model.Group
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterTransportation extends JstructureRegisters {
	private static final long serialVersionUID = 1L;
	private final JTextField fieldTransportation, fieldLocale, fieldCost;
	private final JFormattedTextField fieldTravelDate;
	private Group pickedGroupEdit;
	private final RegisterTransportationController controller = new RegisterTransportationController(this);

	/**
	 * A classe recebe um modal de transporte, um local de destino, o valor de
	 * locomoção e data da viagem. "setting" os paramêtros da classe mãe.
	 */
	public RegisterTransportation(Group pickedGroupEdit) {
		super("Cadastre um novo Transporte");

		this.pickedGroupEdit = pickedGroupEdit;

		JLabel labelTransportation = new JLabel("Modo de transporte:");
		labelTransportation.setFont(JstructureRegisters.FONT);
		labelTransportation.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTransportation.setBounds(169, 195, 175, 13);
		this.add(labelTransportation);

		JLabel labelLocale = new JLabel("Destino:");
		labelLocale.setFont(JstructureRegisters.FONT);
		labelLocale.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLocale.setBounds(169, 243, 175, 13);
		this.add(labelLocale);

		JLabel labelDate = new JLabel("Data de viagem:");
		labelDate.setFont(JstructureRegisters.FONT);
		labelDate.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDate.setBounds(158, 297, 186, 13);
		this.add(labelDate);

		JLabel labelCost = new JLabel("Preço do transporte:");
		labelCost.setFont(JstructureRegisters.FONT);
		labelCost.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCost.setBounds(82, 343, 262, 13);
		this.add(labelCost);

		fieldTransportation = new JTextField();
		labelTransportation.setLabelFor(fieldTransportation);
		fieldTransportation.setBounds(405, 192, 147, 19);
		this.add(fieldTransportation);
		fieldTransportation.setColumns(10);

		fieldLocale = new JTextField();
		labelLocale.setLabelFor(fieldLocale);
		fieldLocale.setBounds(405, 240, 147, 21);
		this.add(fieldLocale);
		fieldLocale.setColumns(10);

		fieldTravelDate = new JFormattedTextField(this.maskingDate());
		labelDate.setLabelFor(fieldTravelDate);
		fieldTravelDate.setBounds(405, 294, 147, 19);
		this.add(fieldTravelDate);

		fieldCost = new JTextField();
		labelCost.setLabelFor(fieldCost);
		fieldCost.setBounds(405, 343, 147, 19);
		this.add(fieldCost);
		fieldCost.setColumns(10);

	}

	public JTextField getFieldTransportation() {
		return fieldTransportation;
	}

	public JTextField getFieldLocale() {
		return fieldLocale;
	}

	public JFormattedTextField getFieldTravelDate() {
		return fieldTravelDate;
	}

	public JTextField getFieldCost() {
		return fieldCost;
	}

	public Group getPickedGroupEdit() {
		return pickedGroupEdit;
	}

	public RegisterTransportationController getController() {
		return controller;
	}

	/**
	 * Método herdado de ActionListner, o qual sinconiza a view com sua respectiva
	 * controller.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.sendAction(e.getSource());
	}

}
