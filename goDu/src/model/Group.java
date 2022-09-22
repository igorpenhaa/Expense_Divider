package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que armazena as informações de cada grupo.
 * 
 * @author Bruno Ribeiro
 * @author Igora Penha
 */
public class Group {

	private String name;
	private User creator;
	private String motivation;
	private String expectedDate;
	private List<Transportation> transportation = new ArrayList<>();
	private List<Restaurant> restaurant = new ArrayList<>();
	private List<Accommodation> accommodation = new ArrayList<>();
	private int numberOfMembers;
	private double totalPrice;

	/**
	 * Construtor para alteração de dados do grupo.
	 * 
	 * @param name
	 * @param creator
	 * @param motivation
	 * @param expectedDate
	 * @param transportation
	 * @param numberOfMembers
	 * @param restaurant
	 * @param accommodation
	 * @param totalPrice
	 */
	public Group(String name, User creator, String motivation, String expectedDate, List<Transportation> transportation,
			int numberOfMembers, List<Restaurant> restaurant, List<Accommodation> accommodation, double totalPrice) {
		super();
		this.name = name;
		this.creator = creator;
		this.motivation = motivation;
		this.expectedDate = expectedDate;
		this.transportation = transportation;
		this.restaurant = restaurant;
		this.accommodation = accommodation;
		this.numberOfMembers = numberOfMembers;
		this.totalPrice = totalPrice;
	}

	/**
	 * Contrutor para registro de grupo da tela RegisterGroup.
	 * 
	 * @param name
	 * @param creator
	 * @param expectedDate
	 * @param motivation
	 */
	public Group(String name, User creator, String expectedDate, String motivation) {
		super();
		this.name = name;
		this.creator = creator;
		this.expectedDate = expectedDate;
		this.motivation = motivation;
		this.numberOfMembers = 1;
		this.totalPrice = 0;
	}

	public String getNameGroup() {
		return name;
	}

	public void setNameGroup(String name) {
		this.name = name;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String category) {
		this.motivation = category;
	}

	public String getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(String expectedDate) {
		this.expectedDate = expectedDate;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public int getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(int numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}

	public List<Restaurant> getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}

	public List<Accommodation> getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(List<Accommodation> accommodation) {
		this.accommodation = accommodation;
	}

	public List<Transportation> getTransportation() {
		return transportation;
	}

	public void setTransportation(List<Transportation> transportation) {
		this.transportation = transportation;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Group [name=" + name + ", creator=" + creator + ", motivation=" + motivation + ", expectedDate="
				+ expectedDate + ", numberOfMembers=" + numberOfMembers + ", restaurant=" + restaurant
				+ ", accommodationList=" + accommodation + ", transportationList=" + transportation + ", totalPrice="
				+ totalPrice + "]";
	}

}
