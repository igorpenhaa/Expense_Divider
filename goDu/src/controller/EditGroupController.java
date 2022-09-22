package controller;

import view.EditGroup;
import view.RegisterAccommodation;
import view.RegisterEditDataGroup;
import view.RegisterRestaurant;
import view.RegisterTransportation;
import view.ShowGroup;

/**
 * Classe controller da {@link view.EditGroup}, tem como função gerenciar e linkar os botões clicados com suas respectivas páginas.
 * 
 * @see view.EditGroup
 * @see view.RegisterAccommodation
 * @see view.RegisterEditDataGroup
 * @see view.RegisterRestaurant
 * @see view.RegisterTransportation
 * @see view.ShowGroup
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class EditGroupController {

	private final EditGroup view;
	
	/**
	 * Construtor recebe a view a qual irá gerenciar.
	 * 
	 * @param view
	 */
	public EditGroupController(EditGroup view) {
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
			new RegisterAccommodation(view.getPickedGroupEdit());
		} else if (source == view.getButton2()) {
			new RegisterRestaurant(view.getPickedGroupEdit());
		} else if (source == view.getButton3()) {
			new RegisterTransportation(view.getPickedGroupEdit());
		} else if (source == view.getButton4()) {
			new RegisterEditDataGroup(view.getPickedGroupEdit());
		} else if (source == view.getButtonBackGroup()) {
			new ShowGroup();
		}

		view.dispose();
	}

}
