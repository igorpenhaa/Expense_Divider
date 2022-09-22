package view;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import controller.ShowUserController;

/**
 * Classe herdeira de {@link JstructureShow}, a qual lista todos os usuários existentes.
 * 
 * @see java.awt.Color
 * @see java.awt.event.ActionEvent
 * @see javax.swing.JButton
 * @see javax.swing.JList
 * @see javax.swing.border.LineBorder
 * @see controller.ShowUserController
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class ShowUser extends JstructureShow {

	private static final long serialVersionUID = 3378863774624440091L;
	private ShowUserController controller = new ShowUserController(this);
	private final JList<String> fieldUser;
	private final JButton buttonNewUser;

	/**
	 * A classe constroi um novo botão para sua tela e "setting" os paramêtros da classe mãe.
	 */
	public ShowUser() {
		super("Usuários", "Usuarios cadastrados:", "Lista:");

		fieldUser = new JList<>();
		fieldUser.setModel(controller.updateList());
		fieldUser.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		fieldUser.setFont(JstructureShow.FONT);
		fieldUser.setForeground(Color.BLACK);
		fieldUser.setBackground(new Color(245, 245, 220));
		this.addSourceList(fieldUser);

		buttonNewUser = new JButton("Novo Usuário");
		buttonNewUser.setFont(JstructureShow.FONT);
		buttonNewUser.setForeground(new Color(33, 113, 204));
		buttonNewUser.setBackground(Color.LIGHT_GRAY);
		buttonNewUser.setBounds(122, 420, 117, 21);
		buttonNewUser.setEnabled(true);
		buttonNewUser.addActionListener(this);
		this.add(buttonNewUser);

		this.setVisible(true);
	}

	public JList<String> getFieldUser() {
		return fieldUser;
	}

	public JButton getButtonNewUser() {
		return buttonNewUser;
	}

	public ShowUserController getController() {
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