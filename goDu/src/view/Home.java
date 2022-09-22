package view;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import controller.HomeController;

/**
 * Classe herdeira de {@link Jstructure}, sendo a tela inicial do projeto.
 * 
 * @see java.awt.Color
 * @see java.awt.event.ActionEvent
 * @see javax.swing.JButton
 * @see controller.HomeController
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class Home extends Jstructure {

	private static final long serialVersionUID = 9127820873016844085L;
	private final HomeController controller = new HomeController(this);
	private JButton button5;

	/**
	 * A classe constroi um novo botão para sua tela e "setting" os paramêtros da classe mãe.
	 */
	public Home() {
		super("goDu", "Cadastrar Usuário", "Cadastrar Grupo", "Grupos", "Usuarios");

		button5 = new JButton("Informações do grupo");
		button5.setEnabled(true);
		button5.setForeground(new Color(0, 0, 0));
		button5.setBackground(Color.LIGHT_GRAY);
		button5.setBounds(280, 377, 267, 31);
		button5.addActionListener(this);
		this.add(button5);

		this.setVisible(true);
	}

	public JButton getButton5() {
		return button5;
	}

	public HomeController getController() {
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
