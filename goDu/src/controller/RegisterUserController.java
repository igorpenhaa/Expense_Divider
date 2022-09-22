package controller;

import model.User;
import model.database.DatabaseProvider;
import view.Home;
import view.RegisterUser;

/**
 * Classe controller da {@link view.RegisterUser}, tem como função gerenciar e linkar os botões clicados com suas respectivas páginas.
 * 
 * @see model.User
 * @see model.database.DatabaseProvider
 * @see view.Home
 * @see view.RegisterUser
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterUserController {

	private final RegisterUser view;

	/**
	 * Construtor recebe a view a qual irá gerenciar.
	 * 
	 * @param view
	 */
	public RegisterUserController(RegisterUser view) {
		super();
		this.view = view;
	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: 
	 * Caso buttonConfirm: confirma os valores cadastrados registrando um novo usuário, em seguida volta à Home. 
	 * Caso buttonCancel: cancela a operação e volta à Home.
	 * 
	 * @see registerNewUser
	 * @param source Um botao da tela
	 */
	public void sendAction(Object source) {
		if (source == view.getButtonConfirm()) {
			registerNewUser();
			new Home();
		} else if (source == view.getButtonCancel()) {
			new Home();
		}

		view.dispose();
	}

	/*
	 * Método cria e armazena no database um novo usuário com o nome e data de nascimento digitados na tela.
	 */
	private void registerNewUser() {
		String name = view.getFieldName().getText();
		String birthday = view.getFieldBirthday().getText();
		User user = new User(name, birthday);

		DatabaseProvider.getUsers().add(user);
	}

}
