package com.lexico;

public class Simbolo {

	private String token = null;
	private String lexema;
	
	public Simbolo(){
		lexema="";
	}
	
	public Simbolo(String t, String l){
		token=t;
		lexema=l;
	}
	
	public String getToken(){
		return token;
	}
	
	public String getLexema(){
		return lexema;
	}
	
	public void setToken(String t){
		token = new String(t);
	}
	
	public void setLexema(String l){
		lexema=l;
	}
	
	public boolean isConstructed(){ return (this.token != null); } 
}
