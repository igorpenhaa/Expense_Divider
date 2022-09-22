package model;

/**
 * Classe herdeira de {@link model.Arrangement}, armazena as informações de cada modal adicionado ao grupo.
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class Transportation extends Arrangement {

	private String transportMode;
	private double transportCost;

	/**
	 * Contrutor padrão para registrar um transporte dentro de um grupo.
	 * 
	 * @param date
	 * @param locale
	 * @param transportMode
	 * @param cost
	 */
	public Transportation(String date, String locale, String transportMode, double cost) {
		super(date, locale);
		this.transportMode = transportMode;
		this.transportCost = cost;
	}

	public String getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}

	public double getTransportCost() {
		return transportCost;
	}

	public void setTransportCost(double transportCost) {
		this.transportCost = transportCost;
	}

	@Override
	public String toString() {
		return "Transportation [transportMode=" + transportMode + ", transportCost=" + transportCost + ", date=" + date
				+ ", locale=" + locale + "]";
	}

}
