%{
package com.sintactico;

import com.lexico.*;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.util.*;
%}

%token INT DOUBLE ID GLOBAL CTEI IF ELSE THEN OP_LE OP_GE OP_NE CTED LOOP UNTIL PRINT CHAIN OP_ASIG SEP_LIM BEGIN END
%right '=' OP_ASIG

%%
/*_PROGRAMA_______________________________________________________________________________________________________________________________________*/

programa: declaraciones bloque |
  		  declaraciones |
  		  bloque
	;

/*_SECCION DECLARACION_______________________________________________________________________________________________________________________________________*/

declaraciones: declaraciones declaracion
    | declaracion
    ;

/*_DECLARACION_______________________________________________________________________________________________________________________________________*/

declaracion: INT identificadores
    | GLOBAL identificadores
    ;

/*_IDENTIFICADORES_______________________________________________________________________________________________________________________________________*/

identificadores: ID ',' identificadores 
	| ID ';'
	;
	
/*_BLOQUE_______________________________________________________________________________________________________________________________________*/

bloque: sent_tipos bloque |
		sent_tipos |
		ambitos
		;

/*_SENT_TIPOS_______________________________________________________________________________________________________________________________________*/

sent_tipos: sent_simple |
			sent_estruct
		;

/*_AMBITOS_______________________________________________________________________________________________________________________________________*/

ambitos: '{' bloque '}' |
		 '{' declaraciones bloque '}'
		 ;

/*_SENT_SIMPLE_______________________________________________________________________________________________________________________________________*/

sent_simple: asignacion |
			 imprimir
		 ;

/*_SENT_ESTRUCT_______________________________________________________________________________________________________________________________________*/

sent_estruct: iter_loop |
			  sent_sel
		 ;

/*_ASIGNACION_______________________________________________________________________________________________________________________________________*/

asignacion: ID OP_ASIG exp_aritmetica ';' 
		 ;


/*_IMPRIMIR_______________________________________________________________________________________________________________________________________*/

imprimir: PRINT cartel ';'
		 ;

/*_CARTEL_______________________________________________________________________________________________________________________________________*/

cartel: '(' CHAIN ')'
		;

/*_EXP_ARITMETICA_______________________________________________________________________________________________________________________________________*/
     
exp_aritmetica: exp_aritmetica '+' term_aritmetica |
				exp_aritmetica '-' term_aritmetica |
				term_aritmetica
		;

/*_TERM_ARITMETICA_______________________________________________________________________________________________________________________________________*/

term_aritmetica: term_aritmetica '*' '(' exp_aritmetica ')' |
				 term_aritmetica '/' '(' exp_aritmetica ')' |
				 term_aritmetica '*' factor |
				 term_aritmetica '/' factor |
				 factor
		;

/*_FACTOR_______________________________________________________________________________________________________________________________________*/

factor: ID |
		CTEI
		;

/*_COND_______________________________________________________________________________________________________________________________________*/

cond: '(' exp_aritmetica comparadores exp_aritmetica ')'
		;

/*_COMPARADORES_______________________________________________________________________________________________________________________________________*/

comparadores: '<' |
			  '>' |
			  '<=' |
			  '>=' |
			  '<>' |
			  '==' 
		;

/*_CUERPO_______________________________________________________________________________________________________________________________________*/

cuerpo: BEGIN sent_tipos END
		;

/*_SENT_SEL_______________________________________________________________________________________________________________________________________*/

sent_sel: IF cuerpo_if
		;
		
/*_CUERPO_IF_______________________________________________________________________________________________________________________________________*/

cuerpo_if: cond THEN cuerpo |
		   cond THEN cuerpo ELSE cuerpo
		;

/*_ITER_LOOP_______________________________________________________________________________________________________________________________________*/

iter_loop: LOOP cuerpo UNTIL cond
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