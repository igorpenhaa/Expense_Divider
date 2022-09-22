package view;

import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.RegisterUserController;

/**
 * Classe herdeira de {@link JstructureRegisters}, a qual tem frame para registrar um novo usuário.
 * 
 * @see java.awt.event.ActionEvent
 * @see javax.swing.JFormattedTextField
 * @see javax.swing.JLabel
 * @see javax.swing.JTextField
 * @see javax.swing.SwingConstants
 * @see controller.RegisterUserController
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterUser extends JstructureRegisters {
	private static final long serialVersionUID = 1L;
	private final JTextField fieldName;
	private final JFormattedTextField expectedDate;
	private final RegisterUserController controller = new RegisterUserController(this);

	/**
	 * A classe recebe o nome a data de nascimento do usuário e "setting" os paramêtros da classe mãe.
	 */
	public RegisterUser() {
		super("Cadastre um novo Usuário");

		JLabel labelName = new JLabel("Nome:");
		labelName.setFont(JstructureRegisters.FONT);
		labelName.setHorizontalAlignment(SwingConstants.RIGHT);
		labelName.setBounds(169, 195, 175, 13);
		this.add(labelName);

		JLabel labelBirthday = new JLabel("Data de Nascimento:");
		labelBirthday.setFont(JstructureRegisters.FONT);
		labelBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		labelBirthday.setBounds(169, 243, 175, 13);
		this.add(labelBirthday);

		fieldName = new JTextField();
		labelName.setLabelFor(fieldName);
		fieldName.setBounds(405, 192, 147, 19);
		this.add(fieldName);
		fieldName.setColumns(10);

		expectedDate = new JFormattedTextField(this.maskingDate());
		labelBirthday.setLabelFor(expectedDate);
		expectedDate.setBounds(405, 240, 147, 19);
		this.add(expectedDate);
	}

	public JTextField getFieldName() {
		return fieldName;
	}

	public JFormattedTextField getFieldBirthday() {
		return expectedDate;
	}

	public RegisterUserController getController() {
		return controller;
	}

	/**
	 * Método herdado de ActionListner, o qual sinconiza a view com sua respectiva controller.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.sendAction(e.getSource());
	}
}
