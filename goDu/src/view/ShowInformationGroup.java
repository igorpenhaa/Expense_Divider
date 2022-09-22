package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.ShowInformationGroupController;

/**
 * Classe herda de {@link JFrame} e implementa {@link ActionListener}, por meio das bibliotecas Java AWT e Java Swing.
 * Lista as informações do gurpo escolido.
 * 
 * @see java.awt
 * @see javax.swing
 * @see JFrame
 * @see ActionListener
 * @see controller.ShowInformationGroupController
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class ShowInformationGroup extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JComboBox<Object> fieldGroup;
	private JTextArea fieldReport;
	private JButton buttonBack, buttonSearch, buttonNewGroup;
	private final JTextField fieldExpectedGroup;
	private JScrollPane scrollPane;
	private static final Font FONT = new Font("Algerian", Font.PLAIN, 12);
	private ShowInformationGroupController controller = new ShowInformationGroupController(this);

	/**
	 * A classe constroi um título da pagina em questão, um botão para voltar a página anterior.
	 * Com este construtor criamos um JFrame, setando background, um tamanho padrão, e um método de fechar a página.
	 */
	public ShowInformationGroup() {
		this.setBackground(new Color(255, 255, 255));
		this.setLayout(null);
		this.setBounds(100, 100, 830, 522);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Relatorio do grupo");
		this.setVisible(true);

		JLabel labelTitle = new JLabel("Informações do grupo");
		labelTitle.setFont(FONT);
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setBounds(51, 59, 725, 13);
		this.add(labelTitle);

		JLabel labelChooseGroup = new JLabel("Escreva ou escolha um grupo");
		labelChooseGroup.setHorizontalAlignment(SwingConstants.CENTER);
		labelChooseGroup.setFont(FONT);
		labelChooseGroup.setBounds(3, 135, 230, 21);
		this.add(labelChooseGroup);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 109, 512, 295);
		this.add(scrollPane);

		fieldGroup = new JComboBox<>();
		fieldGroup.addActionListener(this);
		fieldGroup.setBounds(14, 208, 243, 21);
		fieldGroup.setModel(controller.updateModel());
		this.add(fieldGroup);

		fieldExpectedGroup = new JTextField();
		fieldExpectedGroup.setBounds(15, 168, 113, 21);
		this.add(fieldExpectedGroup);
		fieldExpectedGroup.setColumns(10);

		fieldReport = new JTextArea();
		fieldReport.setFont(new Font("Algerian", Font.PLAIN, 12));
		scrollPane.setViewportView(fieldReport);
		fieldReport.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		fieldReport.setBackground(new Color(245, 245, 220));
		fieldReport.setEditable(false);

		buttonSearch = new JButton("Pesquisar");
		buttonSearch.setFont(JstructureShow.FONT);
		buttonSearch.setForeground(new Color(0, 0, 155));
		buttonSearch.setBackground(Color.LIGHT_GRAY);
		buttonSearch.setBounds(148, 168, 103, 21);
		buttonSearch.setEnabled(true);
		buttonSearch.addActionListener(this);
		this.add(buttonSearch);

		this.setVisible(true);

		buttonBack = new JButton("Voltar");
		buttonBack.setFont(JstructureShow.FONT);
		buttonBack.setForeground(new Color(0, 0, 0));
		buttonBack.setBackground(Color.LIGHT_GRAY);
		buttonBack.setBounds(15, 450, 117, 21);
		buttonBack.setEnabled(true);
		buttonBack.addActionListener(this);
		this.add(buttonBack);

		buttonNewGroup = new JButton("Novo grupo");
		buttonNewGroup.addActionListener(this);
		buttonNewGroup.setForeground(new Color(33, 113, 204));
		buttonNewGroup.setBackground(Color.LIGHT_GRAY);
		buttonNewGroup.setFont(FONT);
		buttonNewGroup.setBounds(140, 450, 113, 21);
		this.add(buttonNewGroup);

		this.setVisible(true);
	}

	public JComboBox<Object> getFieldGroup() {
		return fieldGroup;
	}

	public JTextArea getFieldReport() {
		return fieldReport;
	}

	public JTextField getFieldExpectedGroup() {
		return fieldExpectedGroup;
	}

	public JButton getButtonSearch() {
		return buttonSearch;
	}

	public JButton getButtonBack() {
		return buttonBack;
	}

	public JButton getButtonNewGroup() {
		return buttonNewGroup;
	}

	public ShowInformationGroupController getController() {
		return controller;
	}

	/**
	 * Método herdado de ActionListner, o qual sinconiza a view com sua respectiva controller.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.sendAction(e.getSource());
	}
}
