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
public final static short DOUBLE=258;
public final static short ID=259;
public final static short GLOBAL=260;
public final static short CTEI=261;
public final static short IF=262;
public final static short ELSE=263;
public final static short THEN=264;
public final static short OP_LE=265;
public final static short OP_GE=266;
public final static short OP_NE=267;
public final static short CTED=268;
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
    0,    0,    0,    1,    1,    3,    3,    4,    4,    4,
    2,    2,    2,    2,    5,    5,    6,    6,    7,    7,
    7,    8,    8,    9,    9,   13,   13,   10,   10,   10,
   15,   15,   15,   15,   14,   14,   14,   16,   16,   16,
   16,   16,   17,   17,   18,   18,   18,   18,   18,   19,
   19,   19,   19,   19,   19,   20,   12,   21,   21,   11,
};
final static short yylen[] = {                            2,
    2,    1,    1,    2,    1,    2,    2,    3,    2,    1,
    2,    1,    2,    1,    1,    1,    3,    4,    1,    1,
    1,    1,    1,    4,    3,    1,    1,    3,    2,    2,
    3,    2,    2,    2,    3,    3,    1,    5,    5,    3,
    3,    1,    1,    1,    5,    4,    4,    3,    5,    1,
    1,    1,    1,    1,    1,    3,    2,    3,    5,    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    3,
    5,    0,    0,   15,   16,   19,   20,   22,   23,    0,
    6,    0,    7,   43,   44,    0,    0,    0,   42,    0,
   57,    0,    0,    0,   30,    0,    0,    0,    0,    1,
    4,   11,   13,    0,    9,   27,    0,    0,    0,    0,
    0,   50,   51,   52,   53,   54,   55,    0,    0,    0,
    0,    0,    0,   34,    0,   33,   28,    0,   17,    8,
   24,    0,    0,    0,    0,    0,    0,   40,    0,   41,
    0,   56,   60,   31,   18,    0,    0,   47,    0,    0,
    0,   49,   45,   38,   39,   59,
};
final static short yydgoto[] = {                          8,
    9,   10,   11,   21,   12,   13,   14,   15,   16,   17,
   18,   19,   47,   27,   37,   28,   29,   30,   58,   33,
   31,
};
final static short yysindex[] = {                      -119,
 -244, -208, -244,  -35, -232,  -40, -119,    0, -119,    0,
    0, -115, -115,    0,    0,    0,    0,    0,    0,  -11,
    0, -225,    0,    0,    0, -207,  -32,   -7,    0, -197,
    0, -230, -199,   34,    0,  -38,   20, -119,  -44,    0,
    0,    0,    0, -244,    0,    0,   36,   14,  -36, -207,
 -207,    0,    0,    0,    0,    0,    0, -207,  -34,  -23,
 -232, -179,  -35,    0,   60,    0,    0,  -22,    0,    0,
    0, -207, -207,   -7,   -7,    8, -207,    0, -207,    0,
 -161,    0,    0,    0,    0,   29,   35,    0,   46,   53,
 -232,    0,    0,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,   92,    0,    0,    0,    0,    0,    0,  110,    0,
    0,   10,   12,    0,    0,    0,    0,    0,    0,    2,
    0,    0,    0,    0,    0,    0,    0,    1,    0,    0,
    0,    0,    0,    0,    0,    0,   93,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  108,   58,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   69,    0,    0,    0,    0,    0,
    0,    0,    0,   23,   45,   73,    0,    0,    0,    0,
  112,    0,    0,    0,    0,    0,   77,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  104,    9,   18,   11,   82,    0,    0,    0,    0,    0,
    0,    0,    0,   87,    0,  -13,   40,   52,   67,  -41,
    0,
};
final static int YYTABLESIZE=388;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         36,
   37,   10,   66,    7,   26,   77,   50,    7,   51,   12,
   50,   14,   51,   23,   20,   39,   79,   40,   35,   81,
   42,   43,   35,   52,   72,   53,   41,   52,    2,   53,
   46,    4,   44,   24,   59,   25,   74,   75,    5,   60,
    6,   37,   32,   37,   36,   37,   68,   45,   88,   96,
   50,   24,   51,   25,   70,   41,   50,   26,   51,   37,
   37,   37,   37,   35,   22,   35,   61,   35,   32,   92,
   63,   50,   48,   51,   64,   93,   46,   50,   67,   51,
   69,   35,   35,   35,   35,   36,   94,   36,   50,   36,
   51,   21,   29,   95,   71,   50,   82,   51,   78,   80,
   84,   91,   85,   36,   36,   36,   36,   25,   48,    2,
   38,   58,   49,   62,   83,   73,   26,    0,    0,    0,
    0,    0,    0,   37,   10,   37,    0,   32,    0,    0,
    0,    0,    0,    0,   12,    0,   14,    1,    0,    2,
    3,    0,    4,    2,   76,   35,    4,   35,    0,    5,
    0,    6,    0,    5,    0,    6,    0,    0,   86,   87,
    0,    0,    0,   89,    0,   90,    0,   36,    0,   36,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   26,    0,   26,    0,    0,    0,    0,    0,    0,    0,
    0,   32,    0,   32,    0,   48,    0,   48,    0,   46,
    0,   46,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   21,   29,   21,   29,    0,    0,
    0,    0,    0,   24,   24,   25,   25,    0,    0,    0,
   25,   34,   25,   65,   58,   24,   58,   25,    0,    0,
   54,   55,   56,   57,   54,   55,   56,   57,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   10,   37,
   10,   10,   37,   10,   37,    0,    0,    0,    0,   37,
   10,   37,   10,    0,    0,    0,   37,   37,   37,   37,
   37,   35,    0,    0,   35,    0,   35,    0,    0,    0,
    0,   35,    0,   35,    0,    0,    0,    0,   35,   35,
   35,   35,   35,   36,    0,    0,   36,    0,   36,    0,
    0,    0,    0,   36,    0,   36,   26,    0,    0,   26,
   36,   36,   36,   36,   36,    0,   26,   32,   26,    0,
   32,   48,    0,   26,   48,   46,   48,   32,   46,   32,
   46,   48,    0,   48,   32,   46,    0,   46,   48,    0,
   21,   29,   46,   21,   29,    0,    0,    0,    0,    0,
   21,   29,   21,   29,    0,    0,   25,   21,   29,   25,
   58,    0,    0,   58,    0,    0,   25,    0,   25,    0,
   58,    0,   58,   25,    0,    0,    0,   58,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         40,
    0,    0,   41,  123,   40,   40,   43,  123,   45,    0,
   43,    0,   45,    3,  259,    7,   40,    9,   59,   61,
   12,   13,    0,   60,   61,   62,    9,   60,  259,   62,
  256,  262,   44,  259,   42,  261,   50,   51,  269,   47,
  271,   41,  275,   43,    0,   45,   38,   59,   41,   91,
   43,  259,   45,  261,   44,   38,   43,    0,   45,   59,
   60,   61,   62,   41,  273,   43,  264,   45,    0,   41,
  270,   43,    0,   45,   41,   41,    0,   43,   59,   45,
  125,   59,   60,   61,   62,   41,   41,   43,   43,   45,
   45,    0,    0,   41,   59,   43,  276,   45,   59,   60,
   41,  263,  125,   59,   60,   61,   62,    0,   22,    0,
    7,    0,   26,   32,   63,   49,   59,   -1,   -1,   -1,
   -1,   -1,   -1,  123,  123,  125,   -1,   59,   -1,   -1,
   -1,   -1,   -1,   -1,  125,   -1,  125,  257,   -1,  259,
  260,   -1,  262,  259,   58,  123,  262,  125,   -1,  269,
   -1,  271,   -1,  269,   -1,  271,   -1,   -1,   72,   73,
   -1,   -1,   -1,   77,   -1,   79,   -1,  123,   -1,  125,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  123,   -1,  125,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  123,   -1,  125,   -1,  123,   -1,  125,   -1,  123,
   -1,  125,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  123,  123,  125,  125,   -1,   -1,
   -1,   -1,   -1,  259,  259,  261,  261,   -1,   -1,   -1,
  123,  272,  125,  272,  123,  259,  125,  261,   -1,   -1,
  277,  278,  279,  280,  277,  278,  279,  280,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  257,  259,
  259,  260,  262,  262,  264,   -1,   -1,   -1,   -1,  269,
  269,  271,  271,   -1,   -1,   -1,  276,  277,  278,  279,
  280,  259,   -1,   -1,  262,   -1,  264,   -1,   -1,   -1,
   -1,  269,   -1,  271,   -1,   -1,   -1,   -1,  276,  277,
  278,  279,  280,  259,   -1,   -1,  262,   -1,  264,   -1,
   -1,   -1,   -1,  269,   -1,  271,  259,   -1,   -1,  262,
  276,  277,  278,  279,  280,   -1,  269,  259,  271,   -1,
  262,  259,   -1,  276,  262,  259,  264,  269,  262,  271,
  264,  269,   -1,  271,  276,  269,   -1,  271,  276,   -1,
  259,  259,  276,  262,  262,   -1,   -1,   -1,   -1,   -1,
  269,  269,  271,  271,   -1,   -1,  259,  276,  276,  262,
  259,   -1,   -1,  262,   -1,   -1,  269,   -1,  271,   -1,
  269,   -1,  271,  276,   -1,   -1,   -1,  276,
};
}
final static short YYFINAL=8;
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
null,null,null,null,null,null,null,"INT","DOUBLE","ID","GLOBAL","CTEI","IF",
"ELSE","THEN","OP_LE","OP_GE","OP_NE","CTED","LOOP","UNTIL","PRINT","CHAIN",
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
"identificadores : ID ',' identificadores",
"identificadores : ID ';'",
"identificadores : ID",
"bloque : sent_tipos bloque",
"bloque : sent_tipos",
"bloque : ambitos bloque",
"bloque : ambitos",
"sent_tipos : sent_simple",
"sent_tipos : sent_estruct",
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
"term_aritmetica : term_aritmetica '*' '(' exp_aritmetica ')'",
"term_aritmetica : term_aritmetica '/' '(' exp_aritmetica ')'",
"term_aritmetica : term_aritmetica '*' factor",
"term_aritmetica : term_aritmetica '/' factor",
"term_aritmetica : factor",
"factor : ID",
"factor : CTEI",
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

//#line 163 "parser.y"
private Analizador_Lexico al;
private DefaultTableModel modelError;
private Stack<Integer> pila;
private Stack<Integer> estados;
private Simbolo auxFor; //variable iteracion for
private String sent; //sentido de variacion del for (+/-)
private JTextArea modelInformation;

public Parser(Analizador_Lexico al,DefaultTableModel me,boolean debugMe,JTextArea mInfo){
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
	this.modelInformation.setText( this.modelInformation.getText() + s);
}
public String toString() {
	return "";
}
//#line 400 "Parser.java"
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
case 10:
//#line 37 "parser.y"
{ aserror("Falta ;"); }
break;
case 17:
//#line 56 "parser.y"
{yyout("[Sintactico] Declaracion ambito - sent ejecutables");}
break;
case 18:
//#line 57 "parser.y"
{yyout("[Sintactico] Declaracion ambito - sent decl+ejecutables");}
break;
case 21:
//#line 64 "parser.y"
{ aserror(" Declaracion/Asignacion invalida");}
break;
case 24:
//#line 75 "parser.y"
{yyout("[Sintactico] Asignacion");}
break;
case 25:
//#line 76 "parser.y"
{aserror("Falta el ;");}
break;
case 27:
//#line 80 "parser.y"
{aserror("Falta el lado derecho de la asignacion");}
break;
case 29:
//#line 87 "parser.y"
{ aserror("Falta fin de la sentencia ;");}
break;
case 30:
//#line 88 "parser.y"
{aserror("Falta contenido a imprimir");}
break;
case 31:
//#line 93 "parser.y"
{yyout("[Sintactico] Print cadena de caracteres");}
break;
case 32:
//#line 94 "parser.y"
{ aserror("Falta el ) del print"); }
break;
case 33:
//#line 95 "parser.y"
{ aserror("Falta el contenido a imprimir"); }
break;
case 34:
//#line 96 "parser.y"
{ aserror("Falta el )"); }
break;
case 46:
//#line 124 "parser.y"
{ aserror("Falta Cerrar Parentesis"); }
break;
case 47:
//#line 125 "parser.y"
{ aserror("Falta Abrir Parentesis"); }
break;
case 48:
//#line 126 "parser.y"
{ aserror("Faltan Parentesis"); }
break;
case 49:
//#line 127 "parser.y"
{ aserror("No es posible Asignacion"); }
break;
case 58:
//#line 152 "parser.y"
{yyout("[Sintactico] Sentencia IF Simple");}
break;
case 59:
//#line 153 "parser.y"
{yyout("[Sintactico] Sentencia IF Compuesta");}
break;
case 60:
//#line 158 "parser.y"
{yyout("[Sintactico] Sentencia Loop");}
break;
//#line 645 "Parser.java"
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
