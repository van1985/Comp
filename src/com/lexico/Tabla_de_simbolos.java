package com.lexico;

import java.util.Hashtable;

import javax.swing.table.DefaultTableModel;

public class Tabla_de_simbolos {
	
	private Hashtable<String, Simbolo> tabladesimbolos;
	private DefaultTableModel model;

	public Tabla_de_simbolos(DefaultTableModel t){
		this.tabladesimbolos=new Hashtable<String,Simbolo>();
		this.model = t;
		Simbolo aux = new Simbolo("Palabra Reservada","if");
		add("if", aux);
		
		aux = new Simbolo("Palabra Reservada","then");
		add("then", aux);

		aux = new Simbolo("Palabra Reservada","else");
		add("else", aux);

		aux = new Simbolo("Palabra Reservada","endif");
		add("endif", aux);

		aux = new Simbolo("Palabra Reservada","print");
		add("print", aux);
		
		aux = new Simbolo("Palabra Reservada","int");
		add("int", aux);

		aux = new Simbolo("Palabra Reservada","begin");
		add("begin", aux);

		aux = new Simbolo("Palabra Reservada","end");
		add("end", aux);
		
		aux = new Simbolo("Palabra Reservada","global");
		add("global", aux);
		
		aux = new Simbolo("Palabra Reservada","loop");
		add("loop", aux);
		
		aux = new Simbolo("Palabra Reservada","until");
		add("until", aux);
	}
	
	public void add(String s, Simbolo simb){
		this.tabladesimbolos.put(s, simb);
		Object[] obj = {simb.getToken(),simb};
		this.model.addRow(obj);
	}
	
	public Simbolo getSimbolo(String s){
		return this.tabladesimbolos.get(s);
	}
	
	public boolean existeSimbolo(String l){
		return this.tabladesimbolos.containsKey(l);
	}
	
}
