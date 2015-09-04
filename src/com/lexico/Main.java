package com.lexico;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class Main {

	static String path="";
	private static DefaultTableModel model = null;
	private static DefaultTableModel modelerror = null;
	private static JTextArea lineNumArea;
	private static JTextArea jTextArea1;
	private static BufferedReader archivo;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jTextArea1 = new JTextArea();
		lineNumArea = new JTextArea();
		model = new DefaultTableModel();
		modelerror = new DefaultTableModel();
		
		URL location = Main.class.getProtectionDomain().getCodeSource().getLocation();
		path = location.getFile()+"/test.txt"; 
		saveFile();
		runAL();
	}
	
	private static void saveFile(){
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis);
			archivo = new BufferedReader(isr);

			String linea = "";
			int line = 1;
			boolean exit = false;
			while (!exit) {
				linea = archivo.readLine();
				if (linea == null)
					exit = true;
				else {
					jTextArea1.append(linea + "\n");
					lineNumArea.append(String.valueOf(line) + " \n");
					line++;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void runAL(){
		Analizador_Lexico al = new Analizador_Lexico(new Tabla_de_simbolos(model), new Read_Text(jTextArea1.getText()), modelerror);
		Simbolo s;
		while ((s = al.getToken()).getLexema() != "$") {
			System.out.println(s.getToken()+ " "+ s.getLexema() + "\n");
		}
	}

}
