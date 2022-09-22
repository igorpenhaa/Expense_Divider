package controller;

import javax.swing.DefaultListModel;

import model.Group;
import model.database.DatabaseProvider;
import view.EditGroup;
import view.Home;
import view.RegisterGroup;
import view.ShowGroup;

/**
 * Classe controller da {@link view.ShowGroup}, tem como função gerenciar e
 * linkar os botões clicados com suas respectivas páginas.
 * 
 * @see javax.swing.DefaultListModel
 * @see model.Group
 * @see model.database.DatabaseProvider
 * @see view.EditGroup
 * @see view.Home
 * @see view.RegisterGroup
 * @see view.ShowGroup
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class ShowGroupController {
	private ShowGroup view;
	private Group pickedGroupEdit;
	private String nameGroupEdit;
	private Group pickedGroup;

	/**
	 * Construtor recebe a view a qual irá gerenciar.
	 * 
	 * @param view
	 */
	public ShowGroupController(ShowGroup view) {
		super();
		this.view = view;
	}

	/**
	 * Construtor sem paramêtros para acessar métodos da ShowGroupController sem
	 * estanciar a sua view.
	 */
	public ShowGroupController() {

	}

	/**
	 * Executa uma ação de acordo com o botão selecionado na view
	 * 
	 * Casos: Caso buttonBack: volte à Home. Caso buttonEdit: verifique se algum
	 * grupo foi selecionado, então encaminha a página RegisterEditGroup. Caso
	 * buttonNewGroup: redireciona para a página RegisterGroup. Caso buttonDelete:
	 * verifica se algum grupo foi selecionado, então deleta o mesmo.
	 * 
	 * @param source Um botao da tela
	 */
	public void sendAction(Object source) {
		if (source == view.getButtonBack()) {
			new Home();
		} else if (source == view.getButtonEdit()) {
			nameGroupEdit = view.getFieldGroups().getSelectedValue();

			if (nameGroupEdit != null) {

				pickedGroupEdit = model.database.DatabaseProvider
						.searchForPickedGroup(nameGroupEdit.substring(0, nameGroupEdit.lastIndexOf(" -")));
				new EditGroup(pickedGroupEdit);

			}
		} else if (source == view.getButtonNewGroup()) {
			new RegisterGroup();
		} else if (source == view.getButtonDelete()) {
			deletePickedGroup();
		}

		view.dispose();
	}

	public Group getPickedGroup() {
		return pickedGroup;
	}

	/**
	 * Método deleta do database um grupo selecionado na tela.
	 * 
	 */
	public void deletePickedGroup() {
		String pickedName = view.getFieldGroups().getSelectedValue();
		String pickedNameSplitted = pickedName.substring(0, pickedName.lastIndexOf(" -"));

		if (pickedName != null) {
			pickedGroup = model.database.DatabaseProvider.searchForPickedGroup(pickedNameSplitted);
			DatabaseProvider.getGroups().remove(pickedGroup);
		}

		new ShowGroup();
	}

	/**
	 * Gera um Model com o nome de todos os grupos cadastrados.
	 * 
	 * @return DefaultListModel
	 */
	public DefaultListModel<String> updateList() {
		DefaultListModel<String> names = new DefaultListModel<>();

		for (Group currentGroup : DatabaseProvider.getGroups()) {
			names.addElement(currentGroup.getNameGroup() + " - Preço total: " + currentGroup.getTotalPrice());
		}

		return names;
	}
}