//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 2 "parser.y"
package com.sintactico;

import com.lexico.*;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.util.*;
//#line 24 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short INT=257;
public final static short UNSIGNED=258;
public final static short ID=259;
public final static short GLOBAL=260;
public final static short CTEI=261;
public final static short IF=262;
public final static short ELSE=263;
public final static short THEN=264;
public final static short OP_LE=265;
public final static short OP_GE=266;
public final static short OP_NE=267;
public final static short CTEUI=268;
public final static short LOOP=269;
public final static short UNTIL=270;
public final static short PRINT=271;
public final static short CHAIN=272;
public final static short OP_ASIG=273;
public final static short SEP_LIM=274;
public final static short BEGIN=275;
public final static short END=276;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    0,    1,    1,    3,    3,    3,    4,    4,
    4,    2,    2,    2,    2,    5,    5,    5,    6,    6,
    7,    7,    7,    8,    8,    9,    9,   13,   13,   10,
   10,   10,   15,   15,   15,   15,   14,   14,   14,   16,
   16,   16,   17,   17,   17,   17,   17,   18,   18,   18,
   18,   18,   19,   19,   19,   19,   19,   19,   20,   12,
   21,   21,   11,
};
final static short yylen[] = {                            2,
    2,    1,    1,    2,    1,    2,    2,    3,    3,    2,
    1,    2,    1,    2,    1,    1,    1,    1,    3,    4,
    1,    1,    1,    1,    1,    4,    3,    1,    1,    3,
    2,    2,    3,    2,    2,    2,    3,    3,    1,    3,
    3,    1,    1,    1,    2,    1,    2,    5,    4,    4,
    3,    5,    1,    1,    1,    1,    1,    1,    3,    2,
    3,    5,    4,
};
final static short yydefred[] = {                         0,
   18,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    3,    5,    0,    0,   16,   17,   21,   22,   24,
   25,    0,    6,    0,    0,    7,   43,   44,   46,    0,
    0,    0,    0,   42,    0,   60,    0,    0,    0,   32,
    0,    0,    0,    0,    1,    4,   12,   14,    0,   10,
    8,   29,    0,    0,    0,   45,   47,    0,    0,   53,
   54,   55,   56,   57,   58,    0,    0,    0,    0,    0,
    0,   36,    0,   35,   30,    0,   19,    9,   26,    0,
    0,    0,    0,    0,   40,   41,    0,   59,   63,   33,
   20,    0,    0,   50,    0,   52,   48,   62,
};
final static short yydgoto[] = {                         10,
   11,   12,   13,   23,   14,   15,   16,   17,   18,   19,
   20,   21,   53,   32,   42,   33,   34,   35,   66,   38,
   36,
};
final static short yysindex[] = {                      -112,
    0, -235, -219, -230, -235,  -36, -227,  -34, -112,    0,
 -112,    0,    0, -101, -101,    0,    0,    0,    0,    0,
    0,  -28,    0, -235,  -42,    0,    0,    0,    0,   -9,
 -247,  -33,  -12,    0, -214,    0, -155, -225,   14,    0,
  -21,   16, -112,  -66,    0,    0,    0,    0, -235,    0,
    0,    0,   24,   -6,  -43,    0,    0,   -9,   -9,    0,
    0,    0,    0,    0,    0,   -9,   -9,   -9, -227, -211,
  -36,    0,   31,    0,    0,  -35,    0,    0,    0,   -9,
   -9,  -12,  -12,   13,    0,    0, -174,    0,    0,    0,
    0,   25,   39,    0, -227,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,  117,    0,    0,    0,    0,    0,    0,
   91,    0,    0,    5,    7,    0,    0,    0,    0,    0,
    0,  164,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    1,    0,    0,    0,    0,    0,    0,    0,
    0,  118,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  139,   76,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   77,    0,    0,    0,    0,    0,    0,    0,
    0,   26,   51,   95,    0,    0,  143,    0,    0,    0,
    0,    0,   99,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   84,   38,   -3,    8,   60,    0,    0,    0,    0,    0,
    0,    0,    0,   -2,    0,  -25,    6,   27,   45,  -54,
    0,
};
final static int YYTABLESIZE=435;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         58,
   39,   59,   31,   30,   13,   41,   15,   46,   31,   58,
    9,   59,   26,   56,   87,   49,   60,   80,   61,   74,
   57,    9,   54,   22,   40,   37,   60,   55,   61,   67,
   50,   51,   82,   83,   68,   31,   58,   24,   59,   46,
   98,   39,   25,   39,   71,   39,   44,   37,   45,   69,
   38,   47,   48,   94,   72,   58,   78,   59,   77,   39,
   39,   39,   39,   84,   88,   96,   37,   58,   37,   59,
   37,   90,   85,   86,   75,   28,   34,   92,   93,   97,
   76,   58,   79,   59,   37,   37,   37,   37,   95,   91,
    2,   38,   43,   38,   51,   38,   70,   89,   49,   81,
    1,    0,    0,    4,    0,    0,    6,    0,    0,   38,
   38,   38,   38,    7,    0,    8,   23,   31,    0,    0,
    0,    0,    0,   39,    0,   39,    0,    0,    0,   13,
    0,   15,    0,    0,   28,   34,    0,    0,   27,    0,
    0,    0,   61,    1,    2,    3,    4,    5,   37,    6,
   37,    0,    0,    0,    1,    0,    7,    4,    8,    0,
    6,    0,    0,   11,    0,    0,    0,    7,    0,    8,
    0,    0,    0,   38,    0,   38,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   28,   34,
   28,   34,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   52,    0,    0,   27,   51,   28,   51,
    0,   49,   27,   49,   28,   29,    0,    0,    0,    0,
    0,   29,    0,   62,   63,   64,   65,   39,    0,   23,
   31,   23,   31,   62,   63,   64,   65,    0,    0,   27,
   73,   28,    0,    0,    0,    0,   39,    0,   29,   39,
    0,   27,   39,   27,   39,   61,    0,   61,    0,   39,
    0,   39,    0,    0,    0,    0,   39,   39,   39,   39,
   39,   37,    0,    0,   37,    0,   11,   37,    0,   37,
    0,    0,    0,    0,   37,    0,   37,    0,    0,    0,
    0,   37,   37,   37,   37,   37,   38,    0,    0,   38,
    0,    0,   38,    0,   38,    0,    0,    0,    0,   38,
    0,   38,    0,    0,    0,    0,   38,   38,   38,   38,
   38,   28,   34,    0,   28,   34,    0,   28,   34,    0,
    0,    0,    0,    0,   28,   34,   28,   34,    0,    0,
   51,   28,   34,   51,   49,    0,   51,   49,   51,    0,
   49,    0,   49,   51,    0,   51,    0,   49,    0,   49,
   51,    0,   23,   31,   49,   23,   31,    0,   23,   31,
    0,    0,    0,    0,    0,   23,   31,   23,   31,    0,
    0,    0,   23,   31,   27,    0,    0,   27,   61,    0,
   27,   61,    0,    0,   61,    0,    0,   27,    0,   27,
    0,   61,    0,   61,   27,    0,    0,    0,   61,   11,
   11,   11,   11,   11,    0,   11,    0,    0,    0,    0,
    0,    0,   11,    0,   11,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         43,
    0,   45,   45,   40,    0,   40,    0,   11,   45,   43,
  123,   45,    5,  261,   69,   44,   60,   61,   62,   41,
  268,  123,   25,  259,   59,    0,   60,   30,   62,   42,
   59,   24,   58,   59,   47,   45,   43,  257,   45,   43,
   95,   41,  273,   43,  270,   45,    9,  275,   11,  264,
    0,   14,   15,   41,   41,   43,   49,   45,  125,   59,
   60,   61,   62,   66,  276,   41,   41,   43,   43,   45,
   45,   41,   67,   68,   59,    0,    0,   80,   81,   41,
   43,   43,   59,   45,   59,   60,   61,   62,  263,  125,
    0,   41,    9,   43,    0,   45,   37,   71,    0,   55,
  256,   -1,   -1,  259,   -1,   -1,  262,   -1,   -1,   59,
   60,   61,   62,  269,   -1,  271,    0,    0,   -1,   -1,
   -1,   -1,   -1,  123,   -1,  125,   -1,   -1,   -1,  125,
   -1,  125,   -1,   -1,   59,   59,   -1,   -1,    0,   -1,
   -1,   -1,    0,  256,  257,  258,  259,  260,  123,  262,
  125,   -1,   -1,   -1,  256,   -1,  269,  259,  271,   -1,
  262,   -1,   -1,    0,   -1,   -1,   -1,  269,   -1,  271,
   -1,   -1,   -1,  123,   -1,  125,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  123,  123,
  125,  125,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  256,   -1,   -1,  259,  123,  261,  125,
   -1,  123,  259,  125,  261,  268,   -1,   -1,   -1,   -1,
   -1,  268,   -1,  277,  278,  279,  280,  272,   -1,  123,
  123,  125,  125,  277,  278,  279,  280,   -1,   -1,  259,
  272,  261,   -1,   -1,   -1,   -1,  256,   -1,  268,  259,
   -1,  123,  262,  125,  264,  123,   -1,  125,   -1,  269,
   -1,  271,   -1,   -1,   -1,   -1,  276,  277,  278,  279,
  280,  256,   -1,   -1,  259,   -1,  123,  262,   -1,  264,
   -1,   -1,   -1,   -1,  269,   -1,  271,   -1,   -1,   -1,
   -1,  276,  277,  278,  279,  280,  256,   -1,   -1,  259,
   -1,   -1,  262,   -1,  264,   -1,   -1,   -1,   -1,  269,
   -1,  271,   -1,   -1,   -1,   -1,  276,  277,  278,  279,
  280,  256,  256,   -1,  259,  259,   -1,  262,  262,   -1,
   -1,   -1,   -1,   -1,  269,  269,  271,  271,   -1,   -1,
  256,  276,  276,  259,  256,   -1,  262,  259,  264,   -1,
  262,   -1,  264,  269,   -1,  271,   -1,  269,   -1,  271,
  276,   -1,  256,  256,  276,  259,  259,   -1,  262,  262,
   -1,   -1,   -1,   -1,   -1,  269,  269,  271,  271,   -1,
   -1,   -1,  276,  276,  256,   -1,   -1,  259,  256,   -1,
  262,  259,   -1,   -1,  262,   -1,   -1,  269,   -1,  271,
   -1,  269,   -1,  271,  276,   -1,   -1,   -1,  276,  256,
  257,  258,  259,  260,   -1,  262,   -1,   -1,   -1,   -1,
   -1,   -1,  269,   -1,  271,
};
}
final static short YYFINAL=10;
final static short YYMAXTOKEN=280;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,"'('","')'","'*'","'+'","','",
"'-'",null,"'/'",null,null,null,null,null,null,null,null,null,null,null,"';'",
"'<'","'='","'>'",null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
"'{'",null,"'}'",null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,"INT","UNSIGNED","ID","GLOBAL","CTEI","IF",
"ELSE","THEN","OP_LE","OP_GE","OP_NE","CTEUI","LOOP","UNTIL","PRINT","CHAIN",
"OP_ASIG","SEP_LIM","BEGIN","END","\"<=\"","\">=\"","\"<>\"","\"==\"",
};
final static String yyrule[] = {
"$accept : programa",
"programa : declaraciones bloque",
"programa : declaraciones",
"programa : bloque",
"declaraciones : declaraciones declaracion",
"declaraciones : declaracion",
"declaracion : INT identificadores",
"declaracion : GLOBAL identificadores",
"declaracion : UNSIGNED INT identificadores",
"identificadores : ID ',' identificadores",
"identificadores : ID ';'",
"identificadores : ID",
"bloque : sent_tipos bloque",
"bloque : sent_tipos",
"bloque : ambitos bloque",
"bloque : ambitos",
"sent_tipos : sent_simple",
"sent_tipos : sent_estruct",
"sent_tipos : error",
"ambitos : '{' bloque '}'",
"ambitos : '{' declaraciones bloque '}'",
"sent_simple : asignacion",
"sent_simple : imprimir",
"sent_simple : ID",
"sent_estruct : iter_loop",
"sent_estruct : sent_sel",
"asignacion : ID OP_ASIG cuerpo_asignacion ';'",
"asignacion : ID OP_ASIG cuerpo_asignacion",
"cuerpo_asignacion : exp_aritmetica",
"cuerpo_asignacion : error",
"imprimir : PRINT cartel ';'",
"imprimir : PRINT cartel",
"imprimir : PRINT ';'",
"cartel : '(' CHAIN ')'",
"cartel : '(' CHAIN",
"cartel : '(' ')'",
"cartel : CHAIN ')'",
"exp_aritmetica : exp_aritmetica '+' term_aritmetica",
"exp_aritmetica : exp_aritmetica '-' term_aritmetica",
"exp_aritmetica : term_aritmetica",
"term_aritmetica : term_aritmetica '*' factor",
"term_aritmetica : term_aritmetica '/' factor",
"term_aritmetica : factor",
"factor : ID",
"factor : CTEI",
"factor : '-' CTEI",
"factor : CTEUI",
"factor : '-' CTEUI",
"cond : '(' exp_aritmetica comparadores exp_aritmetica ')'",
"cond : '(' exp_aritmetica comparadores exp_aritmetica",
"cond : exp_aritmetica comparadores exp_aritmetica ')'",
"cond : exp_aritmetica comparadores exp_aritmetica",
"cond : '(' exp_aritmetica '=' exp_aritmetica ')'",
"comparadores : '<'",
"comparadores : '>'",
"comparadores : \"<=\"",
"comparadores : \">=\"",
"comparadores : \"<>\"",
"comparadores : \"==\"",
"cuerpo : BEGIN sent_tipos END",
"sent_sel : IF cuerpo_if",
"cuerpo_if : cond THEN cuerpo",
"cuerpo_if : cond THEN cuerpo ELSE cuerpo",
"iter_loop : LOOP cuerpo UNTIL cond",
};

//#line 184 "parser.y"
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
//#line 412 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 2:
//#line 17 "parser.y"
{ aserror("Faltan sentencias ejecutables"); }
break;
case 3:
//#line 18 "parser.y"
{ aserror("Faltan sentencias de declaracion"); }
break;
case 6:
//#line 29 "parser.y"
{yyout("[Sintactico] Declaracion identificadores INT");}
break;
case 7:
//#line 30 "parser.y"
{yyout("[Sintactico] Declaracion identificadores GLOBAL");}
break;
case 8:
//#line 31 "parser.y"
{yyout("[Sintactico] Declaracion identificadores UNSIGNED INT");}
break;
case 11:
//#line 38 "parser.y"
{ aserror("Falta ;"); }
break;
case 19:
//#line 58 "parser.y"
{yyout("[Sintactico] Declaracion ambito - sent ejecutables");}
break;
case 20:
//#line 59 "parser.y"
{yyout("[Sintactico] Declaracion ambito - sent decl+ejecutables");}
break;
case 23:
//#line 66 "parser.y"
{ aserror(" Declaracion/Asignacion invalida");}
break;
case 26:
//#line 77 "parser.y"
{yyout("[Sintactico] Asignacion");}
break;
case 27:
//#line 78 "parser.y"
{aserror("Falta el ;");}
break;
case 29:
//#line 82 "parser.y"
{aserror("Falta el lado derecho de la asignacion");}
break;
case 31:
//#line 89 "parser.y"
{ aserror("Falta fin de la sentencia ;");}
break;
case 32:
//#line 90 "parser.y"
{aserror("Falta contenido a imprimir");}
break;
case 33:
//#line 95 "parser.y"
{yyout("[Sintactico] Print cadena de caracteres");}
break;
case 34:
//#line 96 "parser.y"
{ aserror("Falta el ) del print"); }
break;
case 35:
//#line 97 "parser.y"
{ aserror("Falta el contenido a imprimir"); }
break;
case 36:
//#line 98 "parser.y"
{ aserror("Falta el )"); }
break;
case 45:
//#line 120 "parser.y"
{
			Simbolo s = (Simbolo)val_peek(0).simbolo;
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
break;
case 47:
//#line 139 "parser.y"
{aserror("No se pueden crear constantes _ui con signo negativas");}
break;
case 49:
//#line 145 "parser.y"
{ aserror("Falta Cerrar Parentesis"); }
break;
case 50:
//#line 146 "parser.y"
{ aserror("Falta Abrir Parentesis"); }
break;
case 51:
//#line 147 "parser.y"
{ aserror("Faltan Parentesis"); }
break;
case 52:
//#line 148 "parser.y"
{ aserror("No es posible Asignacion"); }
break;
case 61:
//#line 173 "parser.y"
{yyout("[Sintactico] Sentencia IF Simple");}
break;
case 62:
//#line 174 "parser.y"
{yyout("[Sintactico] Sentencia IF Compuesta");}
break;
case 63:
//#line 179 "parser.y"
{yyout("[Sintactico] Sentencia Loop");}
break;
//#line 685 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
