package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * Classe abstrata a qual herda de {@link JFrame} e implementa {@link ActionListener}, por meio das bibliotecas Java AWT e Java Swing.
 * A classe molde para as telas de apresentação comuns e possui uma constante para definir a fonte de texto comum.
 * 
 * @see java.awt
 * @see javax.swing
 * @see JFrame
 * @see ActionListener
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public abstract class JstructureShow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	protected static final Font FONT = new Font("Algerian", Font.PLAIN, 12);
	private final JButton buttonBack, buttonEdit, buttonDelete;

	
	/**
	 * Gera um frame com um fundo branco, três titulos (título da página, título cabeçalho e título da lista apresentada)
	 * e três botões (voltar, etitar e deletar).
	 * 
	 * @param pageTitle
	 * @param headTitle
	 * @param listTitle
	 */

	public JstructureShow(String pageTitle, String headTitle, String listTitle) {

		this.setBackground(new Color(245, 245, 220));
		this.setBounds(100, 100, 830, 522);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(pageTitle);
		this.setLayout(null);
		this.setVisible(true);

		JLabel labelTitle = new JLabel(headTitle);
		labelTitle.setFont(JstructureShow.FONT);
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setBounds(278, 51, 254, 16);
		this.add(labelTitle);

		JLabel labelTitle2 = new JLabel(listTitle);
		labelTitle2.setFont(JstructureShow.FONT);
		labelTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle2.setBounds(112, 84, 62, 16);
		this.add(labelTitle2);

		buttonBack = new JButton("Voltar");
		buttonBack.setFont(JstructureShow.FONT);
		buttonBack.setForeground(new Color(0, 0, 0));
		buttonBack.setBackground(Color.LIGHT_GRAY);
		buttonBack.setBounds(122, 450, 117, 21);
		buttonBack.setEnabled(true);
		buttonBack.addActionListener(this);
		this.add(buttonBack);

		buttonEdit = new JButton("Editar");
		buttonEdit.setFont(JstructureShow.FONT);
		buttonEdit.setForeground(new Color(173, 140, 42));
		buttonEdit.setBackground(Color.LIGHT_GRAY);
		buttonEdit.setBounds(601, 420, 109, 21);
		buttonEdit.setEnabled(true);
		buttonEdit.addActionListener(this);
		this.add(buttonEdit);

		buttonDelete = new JButton("Delete");
		buttonDelete.setFont(JstructureShow.FONT);
		buttonDelete.setForeground(new Color(128, 0, 0));
		buttonDelete.setBackground(Color.LIGHT_GRAY);
		buttonDelete.setBounds(601, 450, 109, 21);
		buttonDelete.setEnabled(true);
		buttonDelete.addActionListener(this);
		this.add(buttonDelete);
	}

	public JButton getButtonBack() {
		return buttonBack;
	}

	public JButton getButtonEdit() {
		return buttonEdit;
	}

	public JButton getButtonDelete() {
		return buttonDelete;
	}
	
	/**
	 * Método para a construção de um scrollPane na tela.
	 * 
	 * @param sourceList
	 */

	public void addSourceList(JList<String> sourceList) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 110, 588, 289);
		scrollPane.setViewportView(sourceList);
		this.add(scrollPane);
	}

}
