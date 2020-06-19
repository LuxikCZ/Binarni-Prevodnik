package cz.spsejecna.titera2.prevodnik;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Frame extends Exception implements ActionListener {
	//prejmenoval jsem Objekty JLabel, tak aby byli lepe rozpoznatelne 
	static JTextField textField = new JTextField(20);
	JFrame frame = new JFrame("Binarni prevodnik");
	static JButton button = new JButton("Prevest");
	JTextArea textArea = new JTextArea(20, 20);
	static String converted;
	static JLabel labelZadani = new JLabel("Sem zadejte cislo, ktere chcete prevest");
	static JLabel labelVysledek = new JLabel("Vysledek");

	public static void addComponentsToPanel(Container cont) {
		cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));

		addLabel(cont, labelZadani);
		addText(cont);
		addButton(cont);
		addLabel(cont, labelVysledek);
	}

	private static void addButton(Container container) {
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(button);
	}

	private static void addLabel(Container container, JLabel label) {
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(label);
	}

	private static void addText(Container container) {
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(textField);
	}

	public static void changeText(JTextField text) {
		text.setText(converted);
	}

	public Frame() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		button.addActionListener(this);

		textArea.setEditable(true);

		button.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		labelZadani.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		labelVysledek.setFont(new Font("Comic Sans MS", Font.BOLD, 24));

		addComponentsToPanel(frame.getContentPane());
		frame.setPreferredSize(new Dimension(500, 200));

		frame.pack();
		frame.setVisible(true);
	}
	//pridal jsem jednu exceptinu
	//a jednu default exceptionu jsem dal do catche
	//obe se vyhazuji do okna
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String num = textField.getText();
			if (num.equals("")) {
				throw new neniZadaneCisloException();
			}
			int number = Integer.parseInt(num);

			converted = Integer.toBinaryString(number);
			labelVysledek.setText("Vysledek: " + converted);
			labelVysledek.setForeground(Color.GREEN);
		} catch (neniZadaneCisloException x) {

		} catch (NumberFormatException y) {
			JFrame frameException = new JFrame("ERROR");
			JLabel labelException = new JLabel("MUSITE ZADAT CISLO");
			frameException.setLocationRelativeTo(null);
			frameException.setSize(200, 100);
			labelException.setForeground(Color.RED);
			frameException.add(labelException);
			frameException.setVisible(true);
		}
	}
}