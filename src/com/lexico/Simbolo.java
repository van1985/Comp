package com.lexico;

import com.sintactico.ParserTokens;

public class Simbolo implements ParserTokens{

	private String token = null;
	private String lexema;
	private int numero;
	private Integer tipo = -100;
	private int refcount = 0;
	private int minLimit = -1;
	private int maxLimit = -1;
	
	public int getRef() { return this.refcount; }
	public void incRef() { this.refcount++; }
	
	public Simbolo(){
		lexema="";
	}
	
	public Simbolo(String t, String l){
		lexema=l;
		this.setToken(t);
	}
	
	public String getToken(){
		return token;
	}
	
	public String getLexema(){
		return lexema;
	}
	
	public void setToken(String t){
		token = new String(t);
		if ((t == "Literal") || (t == "Operador Relacional") || (t == "Palabra Reservada"))
			this.numero = getTipoToken(this.lexema);
		else
			this.numero = getTipoToken(this.token);
	}
	
	public void setLexema(String l){
		lexema=l;
	}
	
	public int getNumero(){
		return numero;
	}
	
	public static int getTipoToken(String s){
		if (s.equals("if"))
			return IF;
		if (s.equals("else"))
			return ELSE;
		if (s.equals("loop"))
			return LOOP;
		if (s.equals("print"))
			return PRINT;
		if (s.equals("int"))
			return INT;
		if (s.equals("double"))
			return DOUBLE;
		if (s.equals("Constante Doble"))
			return CTED;
		if (s.equals("CTE_I"))
			return CTEI;
		if (s.equals("Cadena caracteres"))
			return CHAIN;
		if (s.equals("Asignacion"))
			return OP_ASIG;
		if (s.equals("Identificador"))
			return ID;
		if (s.equals(">="))
			return OP_GE;
		if (s.equals("<="))
			return OP_LE;
		if (s.equals("<>"))
			return OP_NE;
		if (s.equals(".."))
			return SEP_LIM;
		if (s.equals("EndOfFile"))
			return 0;
		return ((int)s.charAt(0));
	}
	
	public boolean isConstructed(){ return (this.token != null); }
	
	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = new Integer(tipo);
	}
	
	@Override
	public String toString() {
		if ((this.minLimit > -1) && (this.maxLimit > -1))
			return this.lexema + " Limite inferior: " + this.minLimit + " Limite superior: " + this.maxLimit +"\t\t Tipo: "+this.tipo;
		else
			return this.lexema +"\t\t Tipo: "+this.tipo;
	}
}
