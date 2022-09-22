package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Group;
import model.User;
import model.database.DatabaseProvider;
import view.Home;
import view.RegisterGroup;
import view.RegisterUser;

/**
 * Classe controller da {@link view.RegisterGroup}, tem como função gerenciar e
 * linkar os botões clicados com suas respectivas páginas.
 * 
 * @see java.util.ArrayList
 * @see java.util.List
 * @see javax.swing.DefaultComboBoxModel
 * @see model.Group
 * @see model.User
 * @see model.database.DatabaseProvider
 * @see view.Home
 * @see view.RegisterGroup
 * @see view.RegisterUser
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterGroupController {

	private final RegisterGroup view;

	/**
	 * Construtor recebe a view a qual irá gerenciar.
	 * 
	 * @param view
	 */
	public RegisterGroupController(RegisterGroup view) {
		super();
		this.view = view;
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: Caso buttonConfirm: confirma os valores cadastrados registrando um
	 * novo grupo, em seguida volta à Home. Caso buttonCancel: cancela a operação e
	 * volta à Home. Caso buttonNewUser: redireciona para a página RegisterUser.
	 * 
	 * @param source Um botao da tela
	 */
	public void sendAction(Object source) {
		if (source == view.getButtonConfirm()) {
			registerNewGroup();
			new Home();
		} else if (source == view.getButtonCancel()) {
			new Home();
		} else if (source == view.getButtonNewUser()) {
			new RegisterUser();
		}

		view.dispose();
	}

	/*
	 * Método cria e armazena no database um novo grupo com o nome, criador, data de
	 * planejamento e motivação digitados na tela.
	 */
	private void registerNewGroup() {
		String name = view.getFieldName().getText();
		User creator = model.database.DatabaseProvider
				.searchForPickedUser(view.getFieldCreator().getSelectedItem().toString());
		String expectedDate = view.getFieldDate().getText();
		String motivation = view.getFieldMotivation().getText();

		Group group = new Group(name, creator, expectedDate, motivation);

		DatabaseProvider.getGroups().add(group);
	}

	/**
	 * Método que atualiza a lista de usuários que podem ser os criadores dos
	 * grupos.
	 * 
	 * @return DefaultComboBoxModel
	 */
	public DefaultComboBoxModel<Object> updateModel() {
		return new DefaultComboBoxModel<>(createArrayUser());
	}

	/**
	 * Cria o array de usuários que serão apresentados na DefaultComboBoxModel.
	 * 
	 * @return model.toArray()
	 */
	public Object[] createArrayUser() {
		List<String> model = new ArrayList<>();

		for (User user : DatabaseProvider.getUsers()) {
			model.add(user.getName());
		}

		return model.toArray();
	}

}
