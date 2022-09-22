package controller;

import java.util.List;

import model.Accommodation;
import model.Group;
import model.Restaurant;
import model.Transportation;
import model.User;
import model.database.DatabaseProvider;
import view.EditGroup;
import view.Home;
import view.RegisterEditDataGroup;

/**
 * Classe controller da {@link view.RegisterEditDataGroup}, tem como função gerenciar e linkar os botões clicados com suas respectivas páginas.
 * 
 * @see java.util.List
 * @see model.Accommodation
 * @see model.Group
 * @see model.Restaurant
 * @see model.Transportation
 * @see model.User
 * @see model.database.DatabaseProvider
 * @see view.EditGroup
 * @see view.Home
 * @see view.RegisterEditDataGroup
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterEditDataGroupController {

	private final RegisterEditDataGroup view;

	/**
	 * Construtor recebe a view a qual irá gerenciar.
	 * 
	 * @param view
	 */
	public RegisterEditDataGroupController(RegisterEditDataGroup view) {
		super();
		this.view = view;
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: 
	 * Caso buttonConfirm: confirma os valores cadastrados editando os dados de um grupo, em seguida volta à Home. 
	 * Caso buttonCancel: cancela a operação e volta à Home.
	 * 
	 * @param source Um botao da tela
	 */
	public void sendAction(Object source) {
		if (source == view.getButtonConfirm()) {
			String pickedNameSplitted = view.getPickedGroupEdit().getNameGroup();
			editDataGroup((pickedNameSplitted));
			new Home();
		} else if (source == view.getButtonCancel()) {
			new EditGroup(view.getPickedGroupEdit());
		}

		view.dispose();
	}

	/**
	 * Método busca o grupo em questão clona seus dados, cria um novo gurpo com os dados clonados
	 * e os novos dados alterados, em seguida deleta o grupo atual.
	 * 
	 * @param name
	 */
	private void editDataGroup(String name) {
		for (Group currentGroup : DatabaseProvider.getGroups()) {
			if (name.equals(currentGroup.getNameGroup())) {

				String names;
				String motivation;
				String expectedDate;
				Integer numberOfMembers;

				if (view.getFieldName().getText().isEmpty()) {
					names = currentGroup.getNameGroup();
				} else {
					names = view.getFieldName().getText();
				}

				if (view.getFieldMotivation().getText().isEmpty()) {
					motivation = currentGroup.getMotivation();
				} else {
					motivation = view.getFieldMotivation().getText();
				}

				if (view.getFieldDate().getText().matches("__/__/____")) {
					expectedDate = currentGroup.getExpectedDate();
				} else {
					expectedDate = view.getFieldDate().getText();
				}

				if (view.getFieldMembers().getText().length() == 0) {
					numberOfMembers = currentGroup.getNumberOfMembers();
				} else if (Integer.parseInt(view.getFieldMembers().getText()) == 0) {
					numberOfMembers = currentGroup.getNumberOfMembers();
				} else {
					numberOfMembers = Integer.parseInt(view.getFieldMembers().getText());
				}

				User creator = currentGroup.getCreator();
				List<Transportation> transportation = currentGroup.getTransportation();
				List<Restaurant> restaurant = currentGroup.getRestaurant();
				List<Accommodation> accommodation = currentGroup.getAccommodation();
				double totalPrice = currentGroup.getTotalPrice();

				Group group = new Group(names, creator, motivation, expectedDate, transportation, numberOfMembers,
						restaurant, accommodation, totalPrice);

				DatabaseProvider.getGroups().add(group);

				DatabaseProvider.getGroups().remove(currentGroup);
			}
		}

	}

}
