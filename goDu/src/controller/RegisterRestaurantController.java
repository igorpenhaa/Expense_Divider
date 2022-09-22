package controller;

import java.util.List;

import model.Accommodation;
import model.Group;
import model.Restaurant;
import model.Transportation;
import model.User;
import model.database.DatabaseProvider;
import view.EditGroup;
import view.RegisterRestaurant;

/**
 * Classe controller da {@link view.RegisterRestaurant}, tem como função gerenciar e linkar os botões clicados com suas respectivas páginas.
 * 
 * @see java.util.List
 * @see model.Accommodation
 * @see model.Group
 * @see model.Restaurant
 * @see model.Transportation
 * @see model.User
 * @see model.database.DatabaseProvider
 * @see view.EditGroup
 * @see view.RegisterRestaurant
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterRestaurantController {

	private RegisterRestaurant view;

	/**
	 * Construtor recebe a view a qual irá gerenciar.
	 * 
	 * @param view
	 */
	public RegisterRestaurantController(RegisterRestaurant view) {
		super();
		this.view = view;
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: 
	 * Caso buttonConfirm: confirma os valores cadastrados registrando um novo restaurante, em seguida volta à EditGroup. 
	 * Caso buttonCancel: cancela a operação e volta à EditGroup.
	 * 
	 * @see registerNewRestaurant
	 * @param source Um botao da tela
	 */
	public void sendAction(Object source) {
		if (source == view.getButtonConfirm()) {
			String pickedNameSplitted = view.getPickedGroupEdit().getNameGroup();
			registerNewRestaurant((pickedNameSplitted));
			new EditGroup(view.getPickedGroupEdit());
		} else if (source == view.getButtonCancel()) {
			new EditGroup(view.getPickedGroupEdit());
		}

		view.dispose();
	}

	/**
	 * Método busca pelo grupo em questão clona seus dados anteriores, cria um novo gurpo
	 * com o restaurante adicionado e deleta o gurpo atual.
	 * 
	 * @param name
	 */
	public void registerNewRestaurant(String name) {
		for (Group currentGroup : DatabaseProvider.getGroups()) {
			if (name.equals(currentGroup.getNameGroup())) {

				String date = view.getFieldDate().getText();
				String locale = view.getFieldlocale().getText();
				String nameRestaurant = view.getFieldRestaurant().getText();
				Integer stars = Integer.parseInt(view.getFieldStars().getText());
				String meal = view.getFieldMeal().getText();
				double mealCost = Double.parseDouble(view.getFieldCost().getText());

				String names = currentGroup.getNameGroup();
				User creator = currentGroup.getCreator();
				String motivation = currentGroup.getMotivation();
				String expectedDate = currentGroup.getExpectedDate();
				List<Transportation> transportation = currentGroup.getTransportation();
				int numberOfMembers = currentGroup.getNumberOfMembers();
				List<Restaurant> newRestaurant = currentGroup.getRestaurant();
				List<Accommodation> accommodation = currentGroup.getAccommodation();
				double totalPrice = currentGroup.getTotalPrice() + mealCost;
				Restaurant restaurant = new Restaurant(date, locale, nameRestaurant, stars, meal, mealCost);
				newRestaurant.add(restaurant);

				Group group = new Group(names, creator, motivation, expectedDate, transportation, numberOfMembers,
						newRestaurant, accommodation, totalPrice);

				DatabaseProvider.getGroups().add(group);

				DatabaseProvider.getGroups().remove(currentGroup);
			}
		}
	}

}
