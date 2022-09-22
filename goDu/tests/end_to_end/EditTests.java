package end_to_end;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.database.DatabaseProvider;
import view.RegisterAccommodation;
import view.RegisterEditUser;
import view.RegisterGroup;
import view.RegisterRestaurant;
import view.RegisterTransportation;
import view.RegisterUser;
import view.ShowGroup;
import view.ShowUser;

class EditTests {
	
	@BeforeEach
	void cleanDatabase() {
		DatabaseProvider.getGroups().clear();
		DatabaseProvider.getUsers().clear();
	}

	@Test
	void tryToEditUser() {
		var userTest = new RegisterUser();

		userTest.getFieldName().setText("King Leo");
		userTest.getFieldBirthday().setText("20/02/7030");
		userTest.getButtonConfirm().doClick();

		assertTrue(DatabaseProvider.getGroups().isEmpty());
		
		var userEdit = new ShowUser();
		
		userEdit.getFieldUser().setSelectedValue(DatabaseProvider.getUsers().get(0).getName(), true);
		userEdit.getButtonEdit().doClick();
		
		var userChange = new RegisterEditUser(DatabaseProvider.getUsers().get(0));
		
		userChange.getFieldName().setText("Leo King");
		userChange.getFieldBirthday().setText("03/07/2002");
		userChange.getButtonConfirm().doClick();
		
		var savedUser = DatabaseProvider.getUsers().get(0);

		assertEquals(1, DatabaseProvider.getUsers().size());
		assertEquals("Leo King", savedUser.getName());
		assertEquals("03/07/2002", savedUser.getBirthday());
	}
	
	@Test
	void tryToEditGroup() {
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

		var showGroup = new ShowGroup();

		showGroup.getFieldGroups().setSelectedValue(DatabaseProvider.getGroups().get(0).getNameGroup()
				+ " - Preço total: " + DatabaseProvider.getGroups().get(0).getTotalPrice(), true);
		showGroup.getButtonEdit().doClick();

		var addRestaurant = new RegisterRestaurant(DatabaseProvider.getGroups().get(0));

		addRestaurant.getFieldRestaurant().setText("Leo Bomba");
		addRestaurant.getFieldlocale().setText("Taguatinga Sul");
		addRestaurant.getFieldDate().setText("03/07/2023");
		addRestaurant.getFieldStars().setText("4");
		addRestaurant.getFieldMeal().setText("Trio Leo Tudo");
		addRestaurant.getFieldCost().setText("13");

		addRestaurant.getButtonConfirm().doClick();

		var addAccommodation = new RegisterAccommodation(DatabaseProvider.getGroups().get(0));

		addAccommodation.getFieldAccommodation().setText("Motel");
		addAccommodation.getFieldLocale().setText("Taguatinga Sul");
		addAccommodation.getFieldDate().setText("03/07/2023");
		addAccommodation.getFieldCost().setText("67.9");

		addAccommodation.getButtonConfirm().doClick();

		var addTransportation = new RegisterTransportation(DatabaseProvider.getGroups().get(0));

		addTransportation.getFieldTransportation().setText("Carroagem");
		addTransportation.getFieldLocale().setText("Taguatinga Sul");
		addTransportation.getFieldTravelDate().setText("03/07/2023");
		addTransportation.getFieldCost().setText("23.6");

		addTransportation.getButtonConfirm().doClick();

		assertEquals(1, DatabaseProvider.getGroups().size());

		assertEquals("Leo Bomba", DatabaseProvider.getGroups().get(0).getRestaurant().get(0).getName());
		assertEquals("Taguatinga Sul", DatabaseProvider.getGroups().get(0).getRestaurant().get(0).getLocale());
		assertEquals("03/07/2023", DatabaseProvider.getGroups().get(0).getRestaurant().get(0).getDate());
		assertEquals(4, DatabaseProvider.getGroups().get(0).getRestaurant().get(0).getStars());
		assertEquals("Trio Leo Tudo", DatabaseProvider.getGroups().get(0).getRestaurant().get(0).getMeal());
		assertEquals(13.00, DatabaseProvider.getGroups().get(0).getRestaurant().get(0).getMealPrice());

		assertEquals("Motel", DatabaseProvider.getGroups().get(0).getAccommodation().get(0).getAccommodation());
		assertEquals("Taguatinga Sul", DatabaseProvider.getGroups().get(0).getAccommodation().get(0).getLocale());
		assertEquals("03/07/2023", DatabaseProvider.getGroups().get(0).getAccommodation().get(0).getDate());
		assertEquals(67.90, DatabaseProvider.getGroups().get(0).getAccommodation().get(0).getAccommodationCost());

		assertEquals("Carroagem", DatabaseProvider.getGroups().get(0).getTransportation().get(0).getTransportMode());
		assertEquals("Taguatinga Sul", DatabaseProvider.getGroups().get(0).getTransportation().get(0).getLocale());
		assertEquals("03/07/2023", DatabaseProvider.getGroups().get(0).getTransportation().get(0).getDate());
		assertEquals(23.60, DatabaseProvider.getGroups().get(0).getTransportation().get(0).getTransportCost());

	}

}
