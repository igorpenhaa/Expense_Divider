package model;

/**
 * Classe abstrata a qual será herdada por Transportation, Restaurant e Accommodation.
 * 
 * @author Bruno Ribeiro
 * @author Igora Penha
 */
public abstract class Arrangement {

	protected String date;
	protected String locale;

	/**
	 * Construtor padrão para todas das datas e locais dos eventos ocorridos pelas classes herdeiras.
	 * 
	 * @param date
	 * @param locale
	 */
	public Arrangement(String date, String locale) {
		super();
		this.date = date;
		this.locale = locale;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}
