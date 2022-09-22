package end_to_end;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.database.DatabaseProvider;
import view.RegisterGroup;
import view.RegisterUser;

class CreateTests {

	@BeforeEach
	void cleanDatabase() {
		DatabaseProvider.getGroups().clear();
		DatabaseProvider.getUsers().clear();
	}

	@Test
	void tryToCreateANewUser() {
		var userTest = new RegisterUser();

		userTest.getFieldName().setText("Leo King");
		userTest.getFieldBirthday().setText("03/07/2002");

		assertTrue(DatabaseProvider.getUsers().isEmpty());

		userTest.getButtonConfirm().doClick();

		assertEquals(1, DatabaseProvider.getUsers().size());

		var savedUser = DatabaseProvider.getUsers().get(0);

		assertEquals("Leo King", savedUser.getName());
		assertEquals("03/07/2002", savedUser.getBirthday());
	}

	@Test
	void tryToCreateANewGroup() {
		var userTest = new RegisterUser();

		userTest.getFieldName().setText("Leo King");
		userTest.getFieldBirthday().setText("03/07/2002");
		userTest.getButtonConfirm().doClick();

		var groupTest = new RegisterGroup();

		groupTest.getFieldName().setText("Amigos do Leo");
		groupTest.getFieldCreator().setSelectedItem(userTest);
		groupTest.getFieldDate().setText("03/07/2023");
		groupTest.getFieldMotivation().setText("Niver");

		assertTrue(DatabaseProvider.getGroups().isEmpty());

		groupTest.getButtonConfirm().doClick();

		assertEquals(1, DatabaseProvider.getGroups().size());

		var savedGroup = DatabaseProvider.getGroups().get(0);

		assertEquals("Amigos do Leo", savedGroup.getNameGroup());
		assertEquals("Leo King", savedGroup.getCreator().getName());
		assertEquals("03/07/2002", savedGroup.getCreator().getBirthday());
		assertEquals("03/07/2023", savedGroup.getExpectedDate());
		assertEquals("Niver", savedGroup.getMotivation());
	}

}
