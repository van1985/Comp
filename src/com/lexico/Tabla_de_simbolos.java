package com.lexico;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class Tabla_de_simbolos {
	
	private Hashtable<String, Simbolo> tabladesimbolos;
	private DefaultTableModel model;

	public Tabla_de_simbolos(DefaultTableModel t){
		this.tabladesimbolos=new Hashtable<String,Simbolo>();
		this.model = t;
		model.addColumn("Token");
		model.addColumn("Lexema");
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
		
		aux = new Simbolo("Palabra Reservada","unsigned");
		add("unsigned", aux);

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
	
	public DefaultTableModel getModelTbs(){
		return model;
	}
	
	public Hashtable<String, Simbolo> getTablaDeSimbolos(){
		return tabladesimbolos;
	}
	
	public void removeSimbolo(String l){
		this.tabladesimbolos.remove(l);
		Enumeration<Vector> e = this.model.getDataVector().elements();
		boolean find = false;
		while ((!find) && (e.hasMoreElements())){
			Vector obj = e.nextElement();
			if(l.equals(obj.elementAt(1))){
				this.model.getDataVector().remove(obj);
				find = true;
			}
		}
	}
	
}
