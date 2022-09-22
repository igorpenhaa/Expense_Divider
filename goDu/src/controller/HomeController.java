package controller;

import view.Home;
import view.RegisterGroup;
import view.RegisterUser;
import view.ShowGroup;
import view.ShowInformationGroup;
import view.ShowUser;

/**
 * Classe controller da {@link view.Home}, tem como função gerenciar e linkar os botões clicados com suas respectivas páginas.
 * 
 * @see view.Home
 * @see view.RegisterGroup
 * @see view.RegisterUser
 * @see view.ShowGroup
 * @see view.ShowInformationGroup
 * @see view.ShowUser
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class HomeController {

	private final Home view;

	/**
	 * Construtor recebe a view a qual irá gerenciar.
	 * 
	 * @param view
	 */
	public HomeController(Home view) {
		super();
		this.view = view;
	}

	/**
	 * Método recebe um Object capiturado pelo método herdado da interface ActionListner nas classes view. Redireciona a página 
	 * de acordo com o botão clicado.
	 * 
	 * 
	 * @see java.util.Objects
	 * @param source
	 */
	public void sendAction(Object source) {
		if (source == view.getButton1()) {
			new RegisterUser();
		} else if (source == view.getButton2()) {
			new RegisterGroup();
		} else if (source == view.getButton3()) {
			new ShowGroup();
		} else if (source == view.getButton4()) {
			new ShowUser();
		} else if (source == view.getButton5()) {
			new ShowInformationGroup();
		}

		view.dispose();
	}

}
