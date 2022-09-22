package end_to_end;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.database.DatabaseProvider;
import view.RegisterGroup;
import view.RegisterUser;
import view.ShowInformationGroup;

class ReadTest {

	@BeforeEach
	void cleanDatabase() {
		DatabaseProvider.getGroups().clear();
	}

	@Test
	void tryToReadGroups() {
		var userTest = new RegisterUser();

		userTest.getFieldName().setText("Leo King");
		userTest.getFieldBirthday().setText("03/07/2002");

		userTest.getButtonConfirm().doClick();

		var groupTest1 = new RegisterGroup();

		groupTest1.getFieldName().setText("teste");
		groupTest1.getFieldCreator().setSelectedItem(userTest);
		groupTest1.getFieldDate().setText("03/07/2023");
		groupTest1.getFieldMotivation().setText("teste");

		assertTrue(DatabaseProvider.getGroups().isEmpty());

		groupTest1.getButtonConfirm().doClick();

		var groupTest = new RegisterGroup();

		groupTest.getFieldName().setText("Amigos do Leo");
		groupTest.getFieldCreator().setSelectedItem(userTest);
		groupTest.getFieldDate().setText("03/07/2023");
		groupTest.getFieldMotivation().setText("Niver");

		groupTest.getButtonConfirm().doClick();

		assertEquals(2, DatabaseProvider.getGroups().size());

		var informationGroupTest = new ShowInformationGroup();

		informationGroupTest.getFieldGroup().setSelectedItem(DatabaseProvider.getGroups().get(1).getNameGroup());

		informationGroupTest.getFieldReport().getText();

		assertEquals(
				"Grupo:\n    - Nome do grupo: Amigos do Leo\n" + "    - Criador: Leo King\n"
						+ "    - Motivação: Niver\n" + "    - Data de planejamento: 03/07/2023\n"
						+ "    - Números de membros: 1\n" + "    - Preço Total: 0.0\n" + "    - Preço por Membro: 0.0\n"
						+ "    ____________________________________________________ \n"
						+ "    - Não há transportes cadastrados nesse grupo \n"
						+ "    ____________________________________________________ \n"
						+ "    - Não há restaurantes cadastrados nesse grupo \n"
						+ "    ____________________________________________________ \n" + ""
						+ "    - Não há acomodações cadastrados nesse grupo \n",
				informationGroupTest.getFieldReport().getText());
	}

}
