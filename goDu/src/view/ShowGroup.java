package view;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import controller.ShowGroupController;

/**
 * Classe herdeira de {@link JstructureShow}, a qual lista todos os grupos existentes.
 * 
 * @see java.awt.Color
 * @see java.awt.event.ActionEvent
 * @see javax.swing.JButton
 * @see javax.swing.JList
 * @see javax.swing.border.LineBorder
 * @see controller.ShowGroupController
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class ShowGroup extends JstructureShow {
	private static final long serialVersionUID = 3378863774624440091L;
	private ShowGroupController controller = new ShowGroupController(this);
	private final JList<String> fieldGroups;
	private final JButton buttonNewGroup;

	/**
	 * A classe constroi um novo botão para sua tela e "setting" os paramêtros da classe mãe.
	 */
	public ShowGroup() {
		super("Grupos", "Grupos cadastrados:", "Lista:");

		fieldGroups = new JList<>();
		fieldGroups.setModel(controller.updateList());
		fieldGroups.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		fieldGroups.setFont(JstructureShow.FONT);
		fieldGroups.setForeground(Color.BLACK);
		fieldGroups.setBackground(new Color(245, 245, 220));
		this.addSourceList(fieldGroups);

		buttonNewGroup = new JButton("Novo grupo");
		buttonNewGroup.setFont(JstructureShow.FONT);
		buttonNewGroup.setForeground(new Color(33, 113, 204));
		buttonNewGroup.setBackground(Color.LIGHT_GRAY);
		buttonNewGroup.setBounds(122, 420, 117, 21);
		buttonNewGroup.setEnabled(true);
		buttonNewGroup.addActionListener(this);
		this.add(buttonNewGroup);

		this.setVisible(true);
	}

	public JList<String> getFieldGroups() {
		return fieldGroups;
	}

	public JButton getButtonNewGroup() {
		return buttonNewGroup;
	}

	public ShowGroupController getController() {
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