package controller;

import model.User;
import model.database.DatabaseProvider;
import view.Home;
import view.RegisterEditUser;
import view.ShowUser;

/**
 * Classe controller da {@link view.RegisterEditUser}, tem como função gerenciar e linkar os botões clicados com suas respectivas páginas.
 * 
 * @see model.User
 * @see model.database.DatabaseProvider
 * @see view.Home
 * @see view.RegisterEditUser
 * @see view.ShowUser
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterEditUserController {

	private final RegisterEditUser view;

	/**
	 * Construtor recebe a view a qual irá gerenciar.
	 * 
	 * @param view
	 */
	public RegisterEditUserController(RegisterEditUser view) {
		super();
		this.view = view;
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: 
	 * Caso buttonConfirm: confirma os valores cadastrados editando um usuário, em seguida volta à Home. 
	 * Caso buttonCancel: cancela a operação e volta à Home.
	 * 
	 * @param source Um botao da tela
	 */
	public void sendAction(Object source) {
		if (source == view.getButtonConfirm()) {
			editUser();
			new Home();
		} else if (source == view.getButtonCancel()) {
			new ShowUser();
		}

		view.dispose();
	}

	/*
	 * Método edita e armazena no database um usuário com o nome e/ou data de nascimento digitados na tela.
	 */
	private void editUser() {

		String name;
		String birthday;

		if (view.getFieldName().getText().isEmpty()) {
			name = view.getPickedUserEdit().getName();
		} else {
			name = view.getFieldName().getText();
		}
		if (view.getFieldBirthday().getText().matches("__/__/____")) {
			birthday = view.getPickedUserEdit().getBirthday();
		} else {
			birthday = view.getFieldBirthday().getText();
		}

		User user = new User(name, birthday);
		User oldUser = view.getPickedUserEdit();

		DatabaseProvider.getUsers().add(user);
		DatabaseProvider.getUsers().remove(oldUser);

	}

}
