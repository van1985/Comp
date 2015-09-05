%{
package com.sintactico;

import com.lexico.*;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.util.*;
%}

%token INT DOUBLE ID GLOBAL CTEI IF ELSE OP_LE OP_GE OP_NE CTED FOR PRINT CADENA OP_ASIG SEP_LIM

%right '=' OP_ASIG

%%
/*_PROGRAMA_______________________________________________________________________________________________________________________________________*/

programa: seccion_declaracion
	;

/*_SECCION DECLARACION_______________________________________________________________________________________________________________________________________*/

seccion_declaracion: sentencia_declaracion seccion_declaracion
    | sentencia_declaracion
    ;

/*_SENTENCIA DECLARACION_______________________________________________________________________________________________________________________________________*/

sentencia_declaracion: declaracion
	;

/*_DECLARACION_______________________________________________________________________________________________________________________________________*/

declaracion: INT identificadores
    | GLOBAL identificadores
    ;

/*_IDENTIFICADORES_______________________________________________________________________________________________________________________________________*/

identificadores: ID ',' identificadores 
	| ID ';'
	;
	
	
%%
private Analizador_Lexico al;
private DefaultTableModel modelError;
private Stack<Integer> pila;
private Stack<Integer> estados;
private Simbolo auxFor; //variable iteracion for
private String sent; //sentido de variacion del for (+/-)

public Parser(Analizador_Lexico al,DefaultTableModel me,boolean debugMe){
	this.al = al;
	this.modelError = me;
	yydebug=debugMe;
	this.pila = new Stack<Integer>();
	this.estados = new Stack<Integer>();
}

public int yylex(){
	Simbolo s;
	while ((s = this.al.getToken()).getLexema() != "$") {
		yylval = new ParserVal(s);
		return s.getNumero();
	}
	yylval = new ParserVal(s);
	return s.getNumero();
}

void aserror(String s){
	if (s == "syntax error"){
		Object[] obj = {"[SINTACTICO]",this.al.getLinea(),"Error de sintaxis"};
		this.modelError.addRow(obj);
	}
	else{
		Object[] obj = {"[SINTACTICO]",this.al.getLinea(),s};		
		this.modelError.addRow(obj);
	}
}

void yyerror(String s){
}

void yyout(String s){
}
public String toString() {
	/*
	Enumeration<Terceto> e = this.tercetos.elements();
	String str = new String();
	while (e.hasMoreElements()){
		Terceto t = e.nextElement();
		str += t.getNumero()+"-  "+t.toString();
	}
	return str;
	*/
	return "";
}