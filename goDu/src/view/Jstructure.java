package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Classe abstrata a qual herda de {@link JFrame} e implementa {@link ActionListener}, por meio das bibliotecas Java AWT e Java Swing. 
 * A classe molde para as telas de seleção comuns e possui uma constante para definir a fonte de texto comum.
 * 
 * @see java.awt
 * @see javax.swing
 * @see JFrame
 * @see ActionListener
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public abstract class Jstructure extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	protected static final Font FONT = new Font("Algerian", Font.PLAIN, 14);
	private final JButton button1, button2, button3, button4;

	/**
	 * A classe constroi um título da pagina em questão e três botões os quais são numerados em sequência de cima pra baixo na tela.
	 * Com este construtor criamos um JFrame, setando background, um tamanho padrão, e um método de fechar a página.
	 * 
	 * @param title
	 * @param labelButton1
	 * @param labelButton2
	 * @param labelButton3
	 * @param labelButton4
	 */
	public Jstructure(String title, String labelButton1, String labelButton2, String labelButton3,
			String labelButton4) {

		this.setBackground(new Color(255, 255, 255));
		this.setLayout(null);
		this.setBounds(100, 100, 830, 522);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(title);
		this.setVisible(true);

		button1 = new JButton(labelButton1);
		button1.setEnabled(true);
		button1.setForeground(new Color(0, 0, 0));
		button1.setBackground(Color.LIGHT_GRAY);
		button1.setBounds(280, 213, 267, 31);
		button1.addActionListener(this);
		this.add(button1);

		button2 = new JButton(labelButton2);
		button2.setEnabled(true);
		button2.setForeground(new Color(0, 0, 0));
		button2.setBackground(Color.LIGHT_GRAY);
		button2.setBounds(280, 254, 267, 31);
		button2.addActionListener(this);
		this.add(button2);

		button3 = new JButton(labelButton3);
		button3.setEnabled(true);
		button3.setForeground(new Color(0, 0, 0));
		button3.setBackground(Color.LIGHT_GRAY);
		button3.setBounds(280, 295, 267, 31);
		button3.addActionListener(this);
		this.add(button3);

		button4 = new JButton(labelButton4);
		button4.setEnabled(true);
		button4.setForeground(new Color(0, 0, 0));
		button4.setBackground(Color.LIGHT_GRAY);
		button4.setBounds(280, 336, 267, 31);
		button4.addActionListener(this);
		this.add(button4);

	}

	public JButton getButton1() {
		return button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public JButton getButton3() {
		return button3;
	}

	public JButton getButton4() {
		return button4;
	}

}
