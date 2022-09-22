package view;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import controller.EditGroupController;
import model.Group;

/**
 * Classe herdeira de {@link Jstructure}, sendo a tela responsável pela seleção de elementos a serem editados em cada grupo.
 * 
 * @see java.awt.Color
 * @see java.awt.event.ActionEvent
 * @see javax.swing.JButton
 * @see controller.EditGroupController
 * @see model.Group
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class EditGroup extends Jstructure {

	private static final long serialVersionUID = -7401111180569084823L;
	private final JButton buttonBackGroup;
	private Group pickedGroupEdit;
	private final EditGroupController controller = new EditGroupController(this);

	/**
	 * A classe constroi um novo botão para sua tela, permitindo que o usuário volte para a página anterior
	 * e "setting" os paramêtros da classe mãe.
	 */
	public EditGroup(Group pickedGroupEdit) {
		super("Editar Grupos", "Acomodação", "Restaurante", "Transporte", "Editar Dados do Grupo");

		this.pickedGroupEdit = pickedGroupEdit;

		buttonBackGroup = new JButton("Voltar");
		buttonBackGroup.setFont(Jstructure.FONT);
		buttonBackGroup.setForeground(new Color(110, 24, 196));
		buttonBackGroup.setBackground(Color.LIGHT_GRAY);
		buttonBackGroup.setBounds(122, 450, 117, 21);
		buttonBackGroup.setEnabled(true);
		buttonBackGroup.addActionListener(this);
		this.add(buttonBackGroup);

		this.setVisible(true);
	}

	public EditGroupController getController() {
		return controller;
	}

	public JButton getButtonBackGroup() {
		return buttonBackGroup;
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
