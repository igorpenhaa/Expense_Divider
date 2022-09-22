package orchestrates;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import model.Accommodation;
import model.Group;
import model.Restaurant;
import model.Transportation;
import model.User;
import model.database.DatabaseProvider;

/**
 * Classe responsável pelo geramento de dados pré cadastrados do software.
 * 
 * @see java.util.Calendar
 * @see java.util.GregorianCalendar
 * @see java.util.List
 * @see model
 * @see model.database 
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RandomBuild {

	/**
	 * Método o qual instancia cinco usuários, cinco grupos, quatro acomodações, quatro restaurantes e quatro transportes.
	 */
	public void RandomBuilder() {

		User igor = new User("Igor", randDate(1500, 2004));
		User bruno = new User("Bruno", randDate(1500, 2004));
		User leok = new User("Leo K", randDate(1500, 2004));
		User isabelle = new User("Isabelle", randDate(1500, 2004));
		User bia = new User("Beatriz", randDate(1500, 2004));

		DatabaseProvider.getUsers().add(igor);
		DatabaseProvider.getUsers().add(bruno);
		DatabaseProvider.getUsers().add(leok);
		DatabaseProvider.getUsers().add(isabelle);
		DatabaseProvider.getUsers().add(bia);

		Group igorGroup = new Group("Amigos do Igor", igor, "Viagem com os amigos", randDate(2023, 2123));
		igorGroup.setNumberOfMembers(5);
		igorGroup.setTotalPrice(6094.43);

		Group brunoGroup = new Group("Amigos do Bruno", bruno, "Viagem em casal", randDate(2023, 2123));
		brunoGroup.setNumberOfMembers(2);
		brunoGroup.setTotalPrice(612.07);

		Group leoGroup = new Group("Amigos do Leo", leok, "Baguncinha do Leo", randDate(2023, 2123));
		leoGroup.setNumberOfMembers(8);
		leoGroup.setTotalPrice(1794.6);

		Group isaGroup = new Group("Amigos do Isabelle", isabelle, "Viagem em familia", randDate(2023, 2123));
		isaGroup.setNumberOfMembers(10);
		isaGroup.setTotalPrice(6094.43);

		Group biaGroup = new Group("Amigos do Beatriz", bia, "Desvendar o Brasil", randDate(2023, 2123));
		biaGroup.setNumberOfMembers(1);
		biaGroup.setTotalPrice(285.94);

		Accommodation hotel = new Accommodation(randDate(2023, 2123), "Rio de Janeiro", "Hotel", 5678.99);
		Accommodation motel = new Accommodation(randDate(2023, 2123), "São Paulo", "Motel", 342.50);
		Accommodation rent = new Accommodation(randDate(2023, 2123), "Belo Horizonte", "airbnb", 1657.90);
		Accommodation family = new Accommodation(randDate(2023, 2123), "Brasilia", "Casa da minha tia Judette", 0.00);

		List<Accommodation> AccomodationIgor = igorGroup.getAccommodation();
		AccomodationIgor.add(hotel);
		igorGroup.setAccommodation(AccomodationIgor);

		List<Accommodation> AccomodationBruno = brunoGroup.getAccommodation();
		AccomodationBruno.add(motel);
		brunoGroup.setAccommodation(AccomodationBruno);

		List<Accommodation> AccomodationLeo = leoGroup.getAccommodation();
		AccomodationLeo.add(rent);
		leoGroup.setAccommodation(AccomodationLeo);

		List<Accommodation> AccomodationIsa = isaGroup.getAccommodation();
		AccomodationIsa.add(hotel);
		isaGroup.setAccommodation(AccomodationIsa);

		List<Accommodation> AccomodationBia = biaGroup.getAccommodation();
		AccomodationBia.add(family);
		biaGroup.setAccommodation(AccomodationBia);

		Restaurant copa = new Restaurant(randDate(2023, 2123), "Rio de Janeiro", "Copacabana Palace", 5, "File Mignon", 367.84);
		Restaurant paris = new Restaurant(randDate(2023, 2123), "São Paulo", "Paris6", 5, "Risoto", 236.77);
		Restaurant rioBistro = new Restaurant(randDate(2023, 2123), "Belo Horizonte", "Rio Bistrô", 4, "Bobo de camarão", 86.90);
		Restaurant benedito = new Restaurant(randDate(2023, 2123), "Brasilia", "Benedito", 3, "Hamburguer", 238.34);

		List<Restaurant> restaurantIgor = igorGroup.getRestaurant();
		restaurantIgor.add(copa);
		igorGroup.setRestaurant(restaurantIgor);

		List<Restaurant> restaurantBruno = brunoGroup.getRestaurant();
		restaurantBruno.add(paris);
		brunoGroup.setRestaurant(restaurantBruno);

		List<Restaurant> restaurantLeo = leoGroup.getRestaurant();
		restaurantLeo.add(rioBistro);
		leoGroup.setRestaurant(restaurantLeo);

		List<Restaurant> restaurantIsa = isaGroup.getRestaurant();
		restaurantIsa.add(copa);
		isaGroup.setRestaurant(restaurantIsa);

		List<Restaurant> restaurantBia = biaGroup.getRestaurant();
		restaurantBia.add(benedito);
		biaGroup.setRestaurant(restaurantBia);

		Transportation cablecar = new Transportation(randDate(2023, 2123), "Cristo Redentor", "bonde", 47.60);
		Transportation plane = new Transportation(randDate(2023, 2123), "Aeroporto de São Paulo", "aviao", 32.80);
		Transportation car = new Transportation(randDate(2023, 2123), "Festa na casa de amigos", "carro", 49.80);
		Transportation uber = new Transportation(randDate(2023, 2123), "Na praia", "Uber", 47.60);

		List<Transportation> transportationIgor = igorGroup.getTransportation();
		transportationIgor.add(cablecar);
		igorGroup.setTransportation(transportationIgor);

		List<Transportation> transportationBruno = brunoGroup.getTransportation();
		transportationBruno.add(plane);
		brunoGroup.setTransportation(transportationBruno);

		List<Transportation> transportationLeo = leoGroup.getTransportation();
		transportationLeo.add(car);
		leoGroup.setTransportation(transportationLeo);

		List<Transportation> transportationIsa = isaGroup.getTransportation();
		transportationIsa.add(cablecar);
		isaGroup.setTransportation(transportationIsa);

		List<Transportation> transportationBia = biaGroup.getTransportation();
		transportationBia.add(uber);
		biaGroup.setTransportation(transportationBia);

		DatabaseProvider.getGroups().add(igorGroup);
		DatabaseProvider.getGroups().add(brunoGroup);
		DatabaseProvider.getGroups().add(leoGroup);
		DatabaseProvider.getGroups().add(isaGroup);
		DatabaseProvider.getGroups().add(biaGroup);

	}

	/**
	 * Método para gerar um número aleatório dentro de um range específico.
	 * 
	 * @param start
	 * @param stop
	 * @return randomNumber; between start and stop.
	 */
	public int randBetween(int start, int stop) {
		return start + (int) Math.round(Math.random() * (stop - start));
	}

	/**
	 * Método para geração de Strings de datas aleatórias.
	 * 
	 * @see randBetween
	 * 
	 * @param start
	 * @param stop
	 * @return date dd/MM/yyyy
	 */
	public String randDate(int start, int stop) {

		GregorianCalendar gc = new GregorianCalendar();

		int year = randBetween(start, stop);
		gc.set(Calendar.YEAR, year);

		int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

		return String.format("%02d", gc.get(Calendar.DAY_OF_MONTH)) + "/" + String.format("%02d", (gc.get(Calendar.MONTH) + 1))
		+ "/" + gc.get(Calendar.YEAR);
	}

}
