package model.database;

import java.util.ArrayList;
import java.util.List;

import model.Group;
import model.User;

/**
 * Classe utilizada como pseudo banco de dados para o armazenamento de dados de
 * grupos e usuários.
 * 
 * @see java.util.ArrayList
 * @author Bruno Ribeiro
 * @author Igora Penha
 */
public class DatabaseProvider {
	private static final List<User> USERS = new ArrayList<>();
	private static final List<Group> GROUPS = new ArrayList<>();

	/**
	 * Construtor privado, para evitar que outras classes possam estanciá-la ou
	 * herdá-la.
	 */
	private DatabaseProvider() {

	}

	public static List<User> getUsers() {
		return USERS;
	}

	public static List<Group> getGroups() {
		return GROUPS;
	}

	/**
	 * Método para buscar dentro do database um usuário selecionado na view.
	 * Verifica por O(n) cada usuário cadastrado e se corresponde ao nome clicado na
	 * tela.
	 * 
	 * @param name
	 * @return currentUser/null
	 */
	public static User searchForPickedUser(String name) {
		for (User currentUser : DatabaseProvider.getUsers()) {
			if (currentUser.getName().equals(name)) {
				return currentUser;
			}
		}

		return null;
	}

	/**
	 * Método para buscar dentro do database um grupo selecionado na view. Verifica
	 * por O(n) cada grupo cadastrado e se corresponde ao nome clicado na tela.
	 * 
	 * @param name
	 * @return currentGroup/null
	 */
	public static Group searchForPickedGroup(String name) {
		for (Group currentGroup : DatabaseProvider.getGroups()) {
			if (name.equals(currentGroup.getNameGroup())) {
				return currentGroup;
			}
		}
		return null;
	}

	/**
	 * Método para buscar dentro do database os grupos de um determinado criador.
	 * Verifica por O(n) cada grupo cadastrado e se corresponde ao usuário clicado
	 * na tela.
	 * 
	 * @param creator
	 * @return currentGroup/null
	 */
	public static Group searchForPickedGroup(User creator) {
		for (Group currentGroup : DatabaseProvider.getGroups()) {
			if (creator.equals(currentGroup.getCreator())) {
				return currentGroup;
			}
		}
		return null;
	}
}
