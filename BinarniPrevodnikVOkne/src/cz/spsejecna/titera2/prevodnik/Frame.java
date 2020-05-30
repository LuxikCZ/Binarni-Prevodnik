package cz.spsejecna.titera2.prevodnik;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame implements ActionListener {
	
	static JTextField textField = new JTextField(20);
	JFrame frame = new JFrame("Binární převodník");
	static JButton button = new JButton("Převést");
	JTextArea textArea = new JTextArea(20, 20);
	static String converted;
	static JLabel label1 = new JLabel("Sem zadejte číslo, které chcete převést.");
	static JLabel label2 = new JLabel("Výsledek");
		
	public static void addComponentsToPanel (Container cont) {
		cont.setLayout(new BoxLayout (cont, BoxLayout.Y_AXIS));
		
		addLabel(cont, label1);
		addText(cont);
		addButton(cont);
		addLabel(cont, label2);
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
		label1.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		label2.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		
		addComponentsToPanel(frame.getContentPane());
		frame.setPreferredSize(new Dimension(500, 500));
		
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String num = textField.getText();
		int number = Integer.parseInt(num);
		
		converted = Integer.toBinaryString(number);
		label2.setText("Výsledek: " + converted);
	}
}