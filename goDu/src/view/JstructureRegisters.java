package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;

/**
 * Classe abstrata a qual herda de {@link JFrame} e implementa {@link ActionListener}, por meio das bibliotecas Java AWT e Java Swing.
 * A classe molde para as telas de registro comuns e possui uma constante para definir a fonte de texto comum.
 * 
 * @see java.awt
 * @see javax.swing
 * @see JFrame
 * @see ActionListener
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public abstract class JstructureRegisters extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	protected static final Font FONT = new Font("Algerian", Font.PLAIN, 12);
	private final JButton buttonConfirm, buttonCancel;


	/**
	 * Gera um frame com um fundo branco, um titulo e dois botões, confirmar e
	 * cancelar. Recebe uma String como paramêtro para atribuição do título da página.
	 *  
	 * @param title
	 */
	public JstructureRegisters(String title) {

		this.setBackground(new Color(255, 255, 255));
		this.setLayout(null);
		this.setBounds(100, 100, 830, 522);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(title);
		this.setVisible(true);

		buttonConfirm = new JButton("Confirmar");
		buttonConfirm.addActionListener(this);
		buttonConfirm.setForeground(new Color(0, 128, 0));
		buttonConfirm.setBackground(Color.LIGHT_GRAY);
		buttonConfirm.setFont(FONT);
		buttonConfirm.setBounds(621, 457, 119, 21);
		this.add(buttonConfirm);

		buttonCancel = new JButton("Cancelar");
		buttonCancel.addActionListener(this);
		buttonCancel.setForeground(new Color(128, 0, 0));
		buttonCancel.setBackground(Color.LIGHT_GRAY);
		buttonCancel.setFont(FONT);
		buttonCancel.setBounds(492, 457, 119, 21);
		this.add(buttonCancel);

	}

	public JButton getButtonConfirm() {
		return buttonConfirm;
	}

	public JButton getButtonCancel() {
		return buttonCancel;
	}
	/**
	 * Método para formatar os layouts das datas apresentadas nas telas.
	 * 
	 * @return uma String no padrão dd/MM/yyyy.
	 */
	public MaskFormatter maskingDate() {
		MaskFormatter maskDate = null;
		try {
			maskDate = new MaskFormatter("##/##/####");
		} catch (ParseException ignore) {

		}
		if (maskDate != null) {
			maskDate.setPlaceholderCharacter('_');
		}
		return maskDate;
		
	}
}
