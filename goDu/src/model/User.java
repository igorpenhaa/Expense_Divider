package model;

/**
 * Classe que armazena as informações de um usuário.
 * 
 * @author Bruno Ribeiro
 * @author Igora Penha
 */
public class User {

	private String name;
	private String birthday;

	/**
	 * Gera um usuário, com nome, e dada de nascimento.
	 * 
	 * @param name nome do usuário
	 * @param birthday data de nascimento do usuário.
	 */
	public User(String name, String birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", birthday=" + birthday + "]";
	}

}
