package end_to_end;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.database.DatabaseProvider;
import view.RegisterGroup;
import view.RegisterUser;
import view.ShowGroup;
import view.ShowUser;

class DeleteTests {

	@BeforeEach
	void cleanDatabase() {
		DatabaseProvider.getGroups().clear();
		DatabaseProvider.getUsers().clear();
	}

	@Test
	void tryToDeleteAUser() {
		var userTest = new RegisterUser();

		userTest.getFieldName().setText("Leo King");
		userTest.getFieldBirthday().setText("03/07/2002");

		assertTrue(DatabaseProvider.getUsers().isEmpty());

		userTest.getButtonConfirm().doClick();

		assertEquals(1, DatabaseProvider.getUsers().size());

		var deleteUserTest = new ShowUser();

		deleteUserTest.getFieldUser().setSelectedValue(DatabaseProvider.getUsers().get(0).getName(), true);
		deleteUserTest.getButtonDelete().doClick();

		assertEquals(0, DatabaseProvider.getUsers().size());
	}

	@Test
	void tryToDeleteAGroup() {
		var userTest = new RegisterUser();

		userTest.getFieldName().setText("Leo King");
		userTest.getFieldBirthday().setText("03/07/2002");

		userTest.getButtonConfirm().doClick();

		assertTrue(DatabaseProvider.getGroups().isEmpty());

		var groupTest = new RegisterGroup();

		groupTest.getFieldName().setText("Amigos do Leo");
		groupTest.getFieldCreator().setSelectedItem(userTest);
		groupTest.getFieldDate().setText("03/07/2023");
		groupTest.getFieldMotivation().setText("Niver");

		groupTest.getButtonConfirm().doClick();

		assertEquals(1, DatabaseProvider.getGroups().size());

		var deleteGroupTest = new ShowGroup();

		deleteGroupTest.getFieldGroups().setSelectedValue(DatabaseProvider.getGroups().get(0).getNameGroup()
				+ " - Preço total: " + DatabaseProvider.getGroups().get(0).getTotalPrice(), true);
		deleteGroupTest.getButtonDelete().doClick();

		assertEquals(0, DatabaseProvider.getGroups().size());
	}

}
