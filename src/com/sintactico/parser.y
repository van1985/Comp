%{
package com.sintactico;

import com.lexico.*;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.util.*;
%}

%token INT UNSIGNED ID GLOBAL CTEI IF ELSE THEN OP_LE OP_GE OP_NE CTEUI LOOP UNTIL PRINT CHAIN OP_ASIG SEP_LIM BEGIN END
%right '=' OP_ASIG

%%
/*_PROGRAMA_______________________________________________________________________________________________________________________________________*/

programa: declaraciones bloque |
		  declaraciones { aserror("Faltan sentencias ejecutables"); } |
		  bloque { aserror("Faltan sentencias de declaracion"); }
	;

/*_SECCION DECLARACION_______________________________________________________________________________________________________________________________________*/

declaraciones: declaraciones declaracion
    | declaracion
    ;

/*_DECLARACION_______________________________________________________________________________________________________________________________________*/

declaracion: INT identificadores {yyout("[Sintactico] Declaracion identificadores INT");}
    | GLOBAL identificadores {yyout("[Sintactico] Declaracion identificadores GLOBAL");}
    | UNSIGNED INT identificadores {yyout("[Sintactico] Declaracion identificadores UNSIGNED INT");}
    ;

/*_IDENTIFICADORES_______________________________________________________________________________________________________________________________________*/

identificadores: ID ',' identificadores 
	| ID ';'
	| ID { aserror("Falta ;"); }
	;
	
/*_BLOQUE_______________________________________________________________________________________________________________________________________*/

bloque: sent_tipos bloque |
		sent_tipos |
		ambitos bloque |
		ambitos
		;

/*_SENT_TIPOS_______________________________________________________________________________________________________________________________________*/

sent_tipos: sent_simple |
			sent_estruct |
			error
		;

/*_AMBITOS_______________________________________________________________________________________________________________________________________*/

ambitos: '{' bloque '}' {yyout("[Sintactico] Declaracion ambito - sent ejecutables");} |
		 '{' declaraciones bloque '}' {yyout("[Sintactico] Declaracion ambito - sent decl+ejecutables");}
		 ;

/*_SENT_SIMPLE_______________________________________________________________________________________________________________________________________*/

sent_simple: asignacion 
			|imprimir 
			|ID { aserror(" Declaracion/Asignacion invalida");}
		 ;

/*_SENT_ESTRUCT_______________________________________________________________________________________________________________________________________*/

sent_estruct: iter_loop |
			  sent_sel  
		 ;

/*_ASIGNACION_______________________________________________________________________________________________________________________________________*/

asignacion: ID OP_ASIG cuerpo_asignacion ';' {yyout("[Sintactico] Asignacion");} |
			ID OP_ASIG cuerpo_asignacion {aserror("Falta el ;");}
		 ;

cuerpo_asignacion: exp_aritmetica
			| error  {aserror("Falta el lado derecho de la asignacion");}
		;


/*_IMPRIMIR_______________________________________________________________________________________________________________________________________*/

imprimir: PRINT cartel  ';' |
		  PRINT cartel { aserror("Falta fin de la sentencia ;");} |
		  PRINT ';' {aserror("Falta contenido a imprimir");}
		 ;

/*_CARTEL_______________________________________________________________________________________________________________________________________*/

cartel: '(' CHAIN ')' {yyout("[Sintactico] Print cadena de caracteres");} |
 		'(' CHAIN  { aserror("Falta el ) del print"); } |
 		'(' ')' { aserror("Falta el contenido a imprimir"); } |
 		CHAIN ')' { aserror("Falta el )"); }
		;

/*_EXP_ARITMETICA_______________________________________________________________________________________________________________________________________*/
     
exp_aritmetica: exp_aritmetica '+' term_aritmetica |
				exp_aritmetica '-' term_aritmetica |
				term_aritmetica
		;

/*_TERM_ARITMETICA_______________________________________________________________________________________________________________________________________*/

term_aritmetica: term_aritmetica '*' factor |
				 term_aritmetica '/' factor |
				 factor
		;

/*_FACTOR_______________________________________________________________________________________________________________________________________*/

factor: ID |
		CTEI |
		'-'CTEI 
		{
			Simbolo s = (Simbolo)$2.simbolo;
			if (this.al.getTabladeSimbolos().getSimbolo(s.getLexema()).getRef() == 1){
				this.al.getTabladeSimbolos().removeSimbolo("-");
				this.al.getTabladeSimbolos().removeSimbolo(s.getLexema());
				s.setLexema("-"+s.getLexema());
				this.al.getTabladeSimbolos().add(s.getLexema(),s);
			}
			else{
				if (!this.al.getTabladeSimbolos().existeSimbolo("-"+s.getLexema())){
					Simbolo simb = new Simbolo(s.getToken(),"-"+s.getLexema());
					simb.incRef();
					this.al.getTabladeSimbolos().add(simb.getLexema(),simb);
					
				}
			}
		}
		|
		CTEUI |
		'-'CTEUI {aserror("Constante fuera de rango");}
		;

/*_COND_______________________________________________________________________________________________________________________________________*/

cond: '(' exp_aritmetica comparadores exp_aritmetica ')'
		 | '(' exp_aritmetica comparadores exp_aritmetica { aserror("Falta Cerrar Parentesis"); }
		 | exp_aritmetica comparadores exp_aritmetica ')' { aserror("Falta Abrir Parentesis"); }
		 | exp_aritmetica comparadores exp_aritmetica { aserror("Faltan Parentesis"); }
		 | '(' exp_aritmetica '=' exp_aritmetica ')' { aserror("No es posible Asignacion"); }
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

cuerpo_if: cond THEN cuerpo  {yyout("[Sintactico] Sentencia IF Simple");} |
		   cond THEN cuerpo ELSE cuerpo {yyout("[Sintactico] Sentencia IF Compuesta");}
		;

/*_ITER_LOOP_______________________________________________________________________________________________________________________________________*/

iter_loop: LOOP cuerpo UNTIL cond {yyout("[Sintactico] Sentencia Loop");}
		;


%%
private Analizador_Lexico al;
private DefaultTableModel modelError;
private DefaultTableModel modelInformation;

public Parser(Analizador_Lexico al,DefaultTableModel me,boolean debugMe,DefaultTableModel mInfo){
	this.al = al;
	this.modelError = me;
	yydebug=debugMe;
	this.modelInformation = mInfo;
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
		Object[] obj = {this.al.getLinea(),"[SINTACTICO] Error de sintaxis"};
		this.modelError.addRow(obj);
	}
	else{
		Object[] obj = {this.al.getLinea(),"[SINTACTICO] "+s};		
		this.modelError.addRow(obj);
	}
}

void yyerror(String s){
}

void yyout(String s){
	this.modelInformation.addRow(new Object[]{"[SINTACTICO]",al.getLinea(), s});
	//this.modelInformation.setText( this.modelInformation.getText() + s);
}
public String toString() {
	return "";
}