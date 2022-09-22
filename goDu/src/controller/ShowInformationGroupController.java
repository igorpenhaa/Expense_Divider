package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Accommodation;
import model.Group;
import model.Restaurant;
import model.Transportation;
import model.database.DatabaseProvider;
import view.Home;
import view.RegisterGroup;
import view.ShowInformationGroup;

/**
 * Classe controller da {@link view.ShowInformationGroup}, tem como função
 * gerenciar e linkar os botões clicados com suas respectivas páginas.
 * 
 * @see java.util.ArrayList
 * @see java.util.List
 * @see javax.swing.DefaultComboBoxModel
 * @see model.Accommodation
 * @see model.Group
 * @see model.Restaurant
 * @see model.Transportation
 * @see model.database.DatabaseProvider
 * @see view.Home
 * @see view.ShowInformationGroup
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class ShowInformationGroupController {
	private ShowInformationGroup view;
	private String NameInformationGroup;
	private String nameGroupReturn;

	/**
	 * Construtor recebe a view a qual irá gerenciar.
	 * 
	 * @param view
	 */
	public ShowInformationGroupController(ShowInformationGroup view) {
		this.view = view;
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: Caso buttonBack: volte à Home. Caso ComboBox Group: mostre as
	 * informações deste grupo.
	 * 
	 * @param source Um botao da tela
	 */
	public void sendAction(Object source) {
		if (source == view.getButtonBack()) {
			new Home();
			view.dispose();
		} else if (source == view.getButtonNewGroup()) {
			new RegisterGroup();
			view.dispose();
		} else if (source == view.getButtonSearch()) {
			if (view.getFieldExpectedGroup().getText() != null) {
				NameInformationGroup = view.getFieldExpectedGroup().getText();
				view.getFieldReport().setText(generateReport());
				view.getFieldGroup().setSelectedItem(nameGroupReturn);
			}
		} else {
			if (view.getFieldGroup().getSelectedItem() != null) {
				NameInformationGroup = view.getFieldGroup().getSelectedItem().toString();
				view.getFieldReport().setText(generateReport());
				view.getFieldExpectedGroup().setText(NameInformationGroup);
			}
		}

	}

	/**
	 * Método que mostra a array de grupos e retorna um DefaultComboBoxModel com a
	 * array criada pela createArrayGroup.
	 * 
	 * @return DefaultComboBoxModel
	 */
	public DefaultComboBoxModel<Object> updateModel() {
		return new DefaultComboBoxModel<>(createArrayGroup());
	}

	/**
	 * Cria a array de grupos que será mostrada pela updateModel
	 * 
	 * @return model.toArray()
	 */
	public Object[] createArrayGroup() {
		List<String> model = new ArrayList<>();

		for (Group group : DatabaseProvider.getGroups()) {
			model.add(group.getNameGroup());
		}

		return model.toArray();
	}

	public String generateReport() {
		boolean flag0 = false;
		boolean flag1 = false;
		boolean flag2 = false;
		StringBuilder model = new StringBuilder();

		model.append("Grupo:\n");

		for (Group currentGroup : DatabaseProvider.getGroups()) {
			if (currentGroup.getNameGroup().toUpperCase().equals(NameInformationGroup.toUpperCase())) {
				nameGroupReturn = currentGroup.getNameGroup();

				model.append("    - ");
				model.append("Nome do grupo: " + currentGroup.getNameGroup());
				model.append("\n");

				model.append("    - ");
				model.append("Criador: " + currentGroup.getCreator().getName());
				model.append("\n");

				model.append("    - ");
				model.append("Motivação: " + currentGroup.getMotivation());
				model.append("\n");

				model.append("    - ");
				model.append("Data de planejamento: " + currentGroup.getExpectedDate());
				model.append("\n");

				model.append("    - ");
				model.append("Números de membros: " + currentGroup.getNumberOfMembers());
				model.append("\n");

				model.append("    - ");
				model.append("Preço Total: " + currentGroup.getTotalPrice());
				model.append("\n");

				model.append("    - ");
				model.append("Preço por Membro: " + currentGroup.getTotalPrice() / currentGroup.getNumberOfMembers());
				model.append("\n");

				model.append("    ____________________________________________________ \n");

				for (Transportation currentTransportation : currentGroup.getTransportation()) {
					flag0 = true;

					model.append("    -> ");
					model.append("Transporte: " + currentTransportation.getTransportMode());
					model.append("\n");

					model.append("    - ");
					model.append("Destino: " + currentTransportation.getLocale());
					model.append("\n");

					model.append("    - ");
					model.append("Data de viagem: " + currentTransportation.getDate());
					model.append("\n");

					model.append("    - ");
					model.append("Custo do transporte: " + currentTransportation.getTransportCost());
					model.append("\n");
				}
				if (!flag0) {
					model.append("    - Não há transportes cadastrados nesse grupo \n");
				}

				model.append("    ____________________________________________________ \n");

				for (Restaurant currentRestaurant : currentGroup.getRestaurant()) {
					flag1 = true;

					model.append("    -> ");
					model.append("Nome do restaurante: " + currentRestaurant.getName());
					model.append("\n");

					model.append("    - ");
					model.append("Local: " + currentRestaurant.getLocale());
					model.append("\n");

					model.append("    - ");
					model.append("Data de encontro: " + currentRestaurant.getDate());
					model.append("\n");

					model.append("    - ");
					model.append("Estrelas do restaurante: " + currentRestaurant.getStars());
					model.append("\n");

					model.append("    - ");
					model.append("Prato pedido: " + currentRestaurant.getMeal());
					model.append("\n");

					model.append("    - ");
					model.append("Custo do prato: " + currentRestaurant.getMealPrice());
					model.append("\n");
				}
				if (!flag1) {
					model.append("    - Não há restaurantes cadastrados nesse grupo \n");
				}

				model.append("    ____________________________________________________ \n");

				for (Accommodation currentAccommodation : currentGroup.getAccommodation()) {
					flag2 = true;

					model.append("    -> ");
					model.append("tipo de hospedagem: " + currentAccommodation.getAccommodation());
					model.append("\n");

					model.append("    - ");
					model.append("Lugar da hospedagem: " + currentAccommodation.getLocale());
					model.append("\n");

					model.append("    - ");
					model.append("Data de hospedagem: " + currentAccommodation.getDate());
					model.append("\n");

					model.append("    - ");
					model.append("Custo da acomodação: " + currentAccommodation.getAccommodationCost());
					model.append("\n");
				}

				if (!flag2) {
					model.append("    - Não há acomodações cadastrados nesse grupo \n");
				}
			}
		}

		return model.toString();
	}

	public String getNameInformationGroup() {
		return NameInformationGroup;
	}
}