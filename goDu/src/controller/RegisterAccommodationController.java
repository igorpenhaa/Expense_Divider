package controller;

import java.util.List;

import model.Accommodation;
import model.Group;
import model.Restaurant;
import model.Transportation;
import model.User;
import model.database.DatabaseProvider;
import view.EditGroup;
import view.RegisterAccommodation;

/**
 * Classe controller da {@link view.RegisterAccommodation}, tem como função
 * gerenciar e linkar os botões clicados com suas respectivas páginas.
 * 
 * @see java.util.List
 * @see model.Accommodation
 * @see model.Group
 * @see model.Restaurant
 * @see model.Transportation
 * @see model.User
 * @see model.database.DatabaseProvider
 * @see view.EditGroup
 * @see view.RegisterAccommodation
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterAccommodationController {

	private final RegisterAccommodation view;

	/**
	 * Construtor recebe a view a qual irá gerenciar.
	 * 
	 * @param view
	 */
	public RegisterAccommodationController(RegisterAccommodation view) {
		super();
		this.view = view;
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: Caso buttonConfirm: confirma os valores cadastrados registrando uma
	 * nova acomodação, em seguida volta à EditGroup. Caso buttonCancel: cancela a
	 * operação e volta à EditGroup.
	 * 
	 * @see registerNewAccommodation
	 * @param source Um botao da tela
	 */
	public void sendAction(Object source) {
		if (source == view.getButtonConfirm()) {
			String pickedNameSplitted = view.getPickedGroupEdit().getNameGroup();
			registerNewAccommodation(pickedNameSplitted);
			new EditGroup(view.getPickedGroupEdit());
		} else if (source == view.getButtonCancel()) {
			new EditGroup(view.getPickedGroupEdit());
		}

		view.dispose();
	}

	/**
	 * Método busca pelo grupo em questão clona seus dados anteriores, cria um novo
	 * gurpo com a acomodação adicionada e deleta o gurpo atual.
	 * 
	 * @param name
	 */
	public void registerNewAccommodation(String name) {
		for (Group currentGroup : DatabaseProvider.getGroups()) {
			if (name.equals(currentGroup.getNameGroup())) {

				String date = view.getFieldDate().getText();
				String locale = view.getFieldLocale().getText();
				String accommodation = view.getFieldAccommodation().getText();
				double accommodationCost = Double.parseDouble(view.getFieldCost().getText());

				String names = currentGroup.getNameGroup();
				User creator = currentGroup.getCreator();
				String motivation = currentGroup.getMotivation();
				String expectedDate = currentGroup.getExpectedDate();
				List<Transportation> transportation = currentGroup.getTransportation();
				int numberOfMembers = currentGroup.getNumberOfMembers();
				List<Restaurant> restaurant = currentGroup.getRestaurant();
				List<Accommodation> newAccommodation = currentGroup.getAccommodation();
				double totalPrice = currentGroup.getTotalPrice() + accommodationCost;
				Accommodation accommodations = new Accommodation(date, locale, accommodation, accommodationCost);
				newAccommodation.add(accommodations);

				Group group = new Group(names, creator, motivation, expectedDate, transportation, numberOfMembers,
						restaurant, newAccommodation, totalPrice);

				DatabaseProvider.getGroups().add(group);

				DatabaseProvider.getGroups().remove(currentGroup);
			}
		}
	}

}
