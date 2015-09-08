package com.view;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		
		View aplication = new View("Diseño de Compiladores: Analizador Sintactico");
		aplication.initialize();
		aplication.initConnections();
		aplication.pack();
		aplication.setExtendedState(JFrame.MAXIMIZED_BOTH);

		aplication.setVisible(true);
	}

}
