package model;

/**
 * Classe herdeira de {@link model.Arrangement}, armazena as informações de cada acomodação adicionado ao grupo.
 * @author Bruno Ribeiro
 * @author Igora Penha
 */
public class Accommodation extends Arrangement {

	private String accommodation;
	private double accommodationCost;

	/**
	 * Construtor padrão para registrar uma hospedagem dentro do grupo.
	 * 
	 * @param date
	 * @param locale
	 * @param accommodation
	 * @param accommodationCost
	 */
	public Accommodation(String date, String locale, String accommodation, double accommodationCost) {
		super(date, locale);
		this.accommodation = accommodation;
		this.accommodationCost = accommodationCost;
	}

	public String getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

	public double getAccommodationCost() {
		return accommodationCost;
	}

	public void setAccommodationCost(double accommodationCost) {
		this.accommodationCost = accommodationCost;
	}

	@Override
	public String toString() {
		return "Accommodation [accommodation=" + accommodation + ", accommodationCost=" + accommodationCost + ", date="
				+ date + ", locale=" + locale + "]";
	}

}
