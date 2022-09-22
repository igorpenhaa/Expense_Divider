package model;

/**
 * Classe herdeira de {@link model.Arrangement}, armazena as informações de cada restaurante adicionado ao grupo.
 * 
 * @author Bruno Ribeiro
 * @author Igora Penha
 */
public class Restaurant extends Arrangement {

	private String name;
	private Integer stars;
	private String meal;
	private double mealPrice;

	/**
	 * Contrutor padrão para registrar um restaurante dentro de cada grupo.
	 * 
	 * @param date
	 * @param locale
	 * @param name
	 * @param stars
	 * @param meal
	 * @param mealPrice
	 */
	public Restaurant(String date, String locale, String name, int stars, String meal, double mealPrice) {
		super(date, locale);
		this.name = name;
		this.stars = stars;
		this.meal = meal;
		this.mealPrice = mealPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public double getMealPrice() {
		return mealPrice;
	}

	public void setMealPrice(double mealPrice) {
		this.mealPrice = mealPrice;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", stars=" + stars + ", meal=" + meal + ", mealPrice=" + mealPrice
				+ ", date=" + date + ", locale=" + locale + "]";
	}

}
