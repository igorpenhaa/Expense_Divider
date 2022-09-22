package view;

import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.RegisterEditDataGroupController;
import model.Group;

/**
 * Classe herdeira de {@link JstructureRegisters}, a qual tem frame para editar iformações de cada grupo.
 * 
 * @see java.awt.event.ActionEvent
 * @see javax.swing.JFormattedTextField
 * @see javax.swing.JLabel
 * @see javax.swing.JTextField
 * @see javax.swing.SwingConstants
 * @see controller.RegisterEditDataGroupController
 * @see model.Group
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterEditDataGroup extends JstructureRegisters {
	private static final long serialVersionUID = 1L;
	private final JTextField fieldName, fieldMotivation;
	private JTextField fieldMembers;
	private final JFormattedTextField expectedDate;
	private Group pickedGroupEdit;
	private final RegisterEditDataGroupController controller = new RegisterEditDataGroupController(this);

	/**
	 * A classe recebe um novo nome do grupo, uma nova motivação do grupo, o número de membros pertencentes e data de planejamento.
	 * "setting" os paramêtros da classe mãe.
	 */
	public RegisterEditDataGroup(Group pickedGroupEdit) {
		super("Editando um novo Grupo");

		this.pickedGroupEdit = pickedGroupEdit;

		JLabel labelName = new JLabel("Novo nome do Grupo:");
		labelName.setFont(JstructureRegisters.FONT);
		labelName.setHorizontalAlignment(SwingConstants.RIGHT);
		labelName.setBounds(169, 195, 175, 13);
		this.add(labelName);

		JLabel labelMembers = new JLabel("Número de membros:");
		labelMembers.setFont(JstructureRegisters.FONT);
		labelMembers.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMembers.setBounds(169, 243, 175, 13);
		this.add(labelMembers);

		JLabel labelDate = new JLabel("Data do planejamento:");
		labelDate.setFont(JstructureRegisters.FONT);
		labelDate.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDate.setBounds(158, 297, 186, 13);
		this.add(labelDate);

		JLabel labelMotivation = new JLabel("Motivação do Grupo:");
		labelMotivation.setFont(JstructureRegisters.FONT);
		labelMotivation.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMotivation.setBounds(82, 343, 262, 13);
		this.add(labelMotivation);

		fieldName = new JTextField();
		labelName.setLabelFor(fieldName);
		fieldName.setBounds(405, 192, 147, 19);
		this.add(fieldName);
		fieldName.setColumns(10);

		fieldMembers = new JTextField();
		labelMembers.setLabelFor(fieldMembers);
		fieldMembers.setBounds(405, 240, 147, 21);
		this.add(fieldMembers);
		fieldMembers.setColumns(10);

		expectedDate = new JFormattedTextField(this.maskingDate());
		labelDate.setLabelFor(expectedDate);
		expectedDate.setBounds(405, 294, 147, 19);
		this.add(expectedDate);

		fieldMotivation = new JTextField();
		labelMotivation.setLabelFor(fieldMotivation);
		fieldMotivation.setBounds(405, 343, 147, 19);
		this.add(fieldMotivation);
		fieldMotivation.setColumns(10);

		this.setVisible(true);

	}

	public JTextField getFieldName() {
		return fieldName;
	}

	public JTextField getFieldMembers() {
		return fieldMembers;
	}

	public JTextField getFieldMotivation() {
		return fieldMotivation;
	}

	public JFormattedTextField getFieldDate() {
		return expectedDate;
	}

	public RegisterEditDataGroupController getController() {
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
