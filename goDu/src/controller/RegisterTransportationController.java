package controller;

import java.util.List;

import model.Accommodation;
import model.Group;
import model.Restaurant;
import model.Transportation;
import model.User;
import model.database.DatabaseProvider;
import view.EditGroup;
import view.RegisterTransportation;

/**
 * Classe controller da {@link view.RegisterTransportation}, tem como função gerenciar e linkar os botões clicados com suas respectivas páginas.
 * 
 * @see java.util.List
 * @see model.Accommodation
 * @see model.Group
 * @see model.Restaurant
 * @see model.Transportation
 * @see model.User
 * @see model.database.DatabaseProvider
 * @see view.EditGroup
 * @see view.RegisterTransportation
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterTransportationController {

	private final RegisterTransportation view;

	/**
	 * Construtor recebe a view a qual irá gerenciar.
	 * 
	 * @param view
	 */
	public RegisterTransportationController(RegisterTransportation view) {
		super();
		this.view = view;
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: 
	 * Caso buttonConfirm: confirma os valores cadastrados registrando um novo transporte, em seguida volta à EditGroup. 
	 * Caso buttonCancel: cancela a operação e volta à EditGroup.
	 * 
	 * @see registerNewTransport
	 * @param source Um botao da tela
	 */
	public void sendAction(Object source) {
		if (source == view.getButtonConfirm()) {
			String pickedNameSplitted = view.getPickedGroupEdit().getNameGroup();
			registerNewTransport(pickedNameSplitted);
			new EditGroup(view.getPickedGroupEdit());
		} else if (source == view.getButtonCancel()) {
			new EditGroup(view.getPickedGroupEdit());
		}

		view.dispose();
	}

	/**
	 * Método busca pelo grupo em questão clona seus dados anteriores, cria um novo gurpo
	 * com o transporte adicionado e deleta o gurpo atual.
	 * 
	 * @param name
	 */
	public void registerNewTransport(String name) {

		for (Group currentGroup : DatabaseProvider.getGroups()) {
			if (name.equals(currentGroup.getNameGroup())) {

				String date = view.getFieldTravelDate().getText();
				String locale = view.getFieldLocale().getText();
				String transportMode = view.getFieldTransportation().getText();
				Double transportationCost = Double.parseDouble(view.getFieldCost().getText());

				String names = currentGroup.getNameGroup();
				User creator = currentGroup.getCreator();
				String motivation = currentGroup.getMotivation();
				String expectedDate = currentGroup.getExpectedDate();
				List<Transportation> newTransportation = currentGroup.getTransportation();
				int numberOfMembers = currentGroup.getNumberOfMembers();
				List<Restaurant> restaurant = currentGroup.getRestaurant();
				List<Accommodation> accommodation = currentGroup.getAccommodation();
				double totalPrice = currentGroup.getTotalPrice() + transportationCost;
				Transportation transport = new Transportation(date, locale, transportMode, transportationCost);
				newTransportation.add(transport);

				Group group = new Group(names, creator, motivation, expectedDate, newTransportation, numberOfMembers,
						restaurant, accommodation, totalPrice);

				DatabaseProvider.getGroups().add(group);

				DatabaseProvider.getGroups().remove(currentGroup);
			}
		}
	}

}
