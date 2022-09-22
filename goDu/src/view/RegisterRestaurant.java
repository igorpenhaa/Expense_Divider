package view;

import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.RegisterRestaurantController;
import model.Group;

/**
 * Classe herdeira de {@link JstructureRegisters}, a qual tem frame para
 * registrar um novo restaurante em cada grupo.
 * 
 * @see java.awt.event.ActionEvent
 * @see javax.swing.JFormattedTextField
 * @see javax.swing.JLabel
 * @see javax.swing.JTextField
 * @see javax.swing.SwingConstants
 * @see controller.RegisterRestaurantController
 * @see model.Group
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterRestaurant extends JstructureRegisters {
	private static final long serialVersionUID = 1L;
	private final JTextField fieldRestaurant, fieldlocale, fieldStars, fieldMeal, fieldCost;
	private final JFormattedTextField fieldDate;
	private Group pickedGroupEdit;
	private final RegisterRestaurantController controller = new RegisterRestaurantController(this);

	/**
	 * A classe recebe um restaurante, um local do esatabelecimento, o valor do
	 * prato consumido, quantidade (int) de estrelas do estabelecimento, o prato
	 * consumido e data do acontecimento. "setting" os paramêtros da classe mãe.
	 */
	public RegisterRestaurant(Group pickedGroupEdit) {
		super("Cadastre um novo Restaurante");

		this.pickedGroupEdit = pickedGroupEdit;

		JLabel labelRestaurant = new JLabel("Restaurante:");
		labelRestaurant.setFont(JstructureRegisters.FONT);
		labelRestaurant.setHorizontalAlignment(SwingConstants.RIGHT);
		labelRestaurant.setBounds(169, 98, 175, 13);
		this.add(labelRestaurant);

		JLabel labelLocale = new JLabel("Local:");
		labelLocale.setFont(JstructureRegisters.FONT);
		labelLocale.setHorizontalAlignment(SwingConstants.RIGHT);
		labelLocale.setBounds(169, 147, 175, 13);
		this.add(labelLocale);

		JLabel mealDate = new JLabel("Data de Encontro:");
		mealDate.setFont(JstructureRegisters.FONT);
		mealDate.setHorizontalAlignment(SwingConstants.RIGHT);
		mealDate.setBounds(169, 196, 175, 13);
		this.add(mealDate);

		JLabel labelStars = new JLabel("Estrelas:");
		labelStars.setFont(JstructureRegisters.FONT);
		labelStars.setHorizontalAlignment(SwingConstants.RIGHT);
		labelStars.setBounds(169, 245, 175, 13);
		this.add(labelStars);

		JLabel labelMeal = new JLabel("Nome do Prato:");
		labelMeal.setFont(JstructureRegisters.FONT);
		labelMeal.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMeal.setBounds(158, 294, 186, 13);
		this.add(labelMeal);

		JLabel labelCost = new JLabel("Preço dos pratos:");
		labelCost.setFont(JstructureRegisters.FONT);
		labelCost.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCost.setBounds(82, 343, 262, 13);
		this.add(labelCost);

		fieldRestaurant = new JTextField();
		labelRestaurant.setLabelFor(fieldRestaurant);
		fieldRestaurant.setBounds(405, 98, 147, 19);
		this.add(fieldRestaurant);
		fieldRestaurant.setColumns(10);

		fieldlocale = new JTextField();
		labelLocale.setLabelFor(fieldlocale);
		fieldlocale.setBounds(405, 147, 147, 19);
		this.add(fieldlocale);
		fieldlocale.setColumns(10);

		fieldDate = new JFormattedTextField(this.maskingDate());
		mealDate.setLabelFor(fieldDate);
		fieldDate.setBounds(405, 196, 147, 19);
		this.add(fieldDate);
		fieldDate.setColumns(10);

		fieldStars = new JTextField();
		labelStars.setLabelFor(fieldStars);
		fieldStars.setBounds(405, 245, 147, 21);
		this.add(fieldStars);
		fieldStars.setColumns(10);

		fieldMeal = new JTextField();
		labelMeal.setLabelFor(fieldMeal);
		fieldMeal.setBounds(405, 294, 147, 19);
		this.add(fieldMeal);
		fieldMeal.setColumns(10);

		fieldCost = new JTextField();
		labelCost.setLabelFor(fieldCost);
		fieldCost.setBounds(405, 343, 147, 19);
		this.add(fieldCost);
		fieldCost.setColumns(10);

	}

	public JTextField getFieldRestaurant() {
		return fieldRestaurant;
	}

	public JTextField getFieldlocale() {
		return fieldlocale;
	}

	public JFormattedTextField getFieldDate() {
		return fieldDate;
	}

	public JTextField getFieldStars() {
		return fieldStars;
	}

	public JTextField getFieldMeal() {
		return fieldMeal;
	}

	public JTextField getFieldCost() {
		return fieldCost;

	}

	public Group getPickedGroupEdit() {
		return pickedGroupEdit;
	}

	public RegisterRestaurantController getController() {
		return controller;
	}

	/**
	 * Método herdado de ActionListner, o qual sinconiza a view com sua respectiva
	 * controller.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.sendAction(e.getSource());
	}

}
