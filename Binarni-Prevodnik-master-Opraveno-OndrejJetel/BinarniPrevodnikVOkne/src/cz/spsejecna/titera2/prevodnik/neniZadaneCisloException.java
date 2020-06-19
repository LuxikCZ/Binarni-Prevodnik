package cz.spsejecna.titera2.prevodnik;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class neniZadaneCisloException extends Exception{
	public neniZadaneCisloException() {
		JFrame frameException = new JFrame("ERROR");
		JLabel labelException = new JLabel("POLE JE PRAZDNE");
		frameException.setLocationRelativeTo(null);
		frameException.setSize(200, 100);
		labelException.setForeground(Color.RED);
		frameException.add(labelException);
		frameException.setVisible(true);
	}
}
