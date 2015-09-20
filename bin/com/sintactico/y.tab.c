#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "parser.y"
package com.sintactico;

import com.lexico.*;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.util.*;
#line 13 "y.tab.c"
#define INT 257
#define DOUBLE 258
#define ID 259
#define GLOBAL 260
#define CTEI 261
#define IF 262
#define ELSE 263
#define THEN 264
#define OP_LE 265
#define OP_GE 266
#define OP_NE 267
#define CTED 268
#define LOOP 269
#define UNTIL 270
#define PRINT 271
#define CHAIN 272
#define OP_ASIG 273
#define SEP_LIM 274
#define BEGIN 275
#define END 276
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    0,    0,    0,    1,    1,    3,    3,    4,    4,    4,
    2,    2,    2,    2,    5,    5,    6,    6,    7,    7,
    7,    8,    8,    9,   14,    9,   10,   10,   10,   15,
   15,   15,   15,   13,   13,   13,   16,   16,   16,   16,
   16,   17,   17,   18,   18,   18,   18,   18,   19,   19,
   19,   19,   19,   19,   20,   12,   21,   21,   11,
};
short yylen[] = {                                         2,
    2,    1,    1,    2,    1,    2,    2,    3,    2,    1,
    2,    1,    2,    1,    1,    1,    3,    4,    2,    1,
    1,    1,    1,    4,    0,    6,    3,    2,    2,    3,
    2,    2,    2,    3,    3,    1,    5,    5,    3,    3,
    1,    1,    1,    5,    4,    4,    3,    5,    1,    1,
    1,    1,    1,    1,    3,    2,    3,    5,    4,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    3,
    5,    0,    0,   15,   16,    0,   20,   22,   23,    0,
    6,    0,    7,   42,   43,    0,    0,    0,   41,    0,
   56,    0,    0,    0,   29,    0,    0,    0,    0,    1,
    4,   11,   13,   19,    0,    9,    0,    0,    0,    0,
   49,   50,   51,   52,   53,   54,    0,    0,    0,    0,
    0,    0,   33,    0,   32,   27,    0,   17,    8,   24,
    0,    0,    0,    0,    0,    0,    0,   39,    0,   40,
    0,   55,   59,   30,   18,    0,    0,    0,   46,    0,
    0,    0,   26,   48,   44,   37,   38,   58,
};
short yydgoto[] = {                                       8,
    9,   10,   11,   21,   12,   13,   14,   15,   16,   17,
   18,   19,   27,   71,   37,   28,   29,   30,   57,   33,
   31,
};
short yysindex[] = {                                   -119,
 -230, -222, -230,  -34, -232,  -27, -119,    0, -119,    0,
    0, -115, -115,    0,    0,   -7,    0,    0,    0,  -25,
    0, -243,    0,    0,    0, -243,  -36,   25,    0, -211,
    0, -221, -216,   24,    0,  -41,   -4, -119,  -55,    0,
    0,    0,    0,    0, -230,    0,  -10,  -40, -243, -243,
    0,    0,    0,    0,    0,    0, -243,  -29,  -26, -232,
 -205,  -34,    0,   34,    0,    0,  -46,    0,    0,    0,
 -179, -243, -243,   25,   25,   33, -243,    0, -243,    0,
 -182,    0,    0,    0,    0, -173,   46,   53,    0,   54,
   68, -232,    0,    0,    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,   77,    0,    0,    0,    0,    0,    0,  101,    0,
    0,   10,   12,    0,    0,    0,    0,    0,    0,    2,
    0,    0,    0,    0,    0,    0,    0,    1,    0,    0,
    0,    0,    0,    0,    0,    0,   92,    0,    0,    0,
    0,    0,    0,    0,    0,    0, -157,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   58,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   23,   45,   69,    0,    0,    0,    0,
   93,    0,    0,    0,    0,    0,    0,   73,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   96,   18,   19,   14,   76,    0,    0,    0,    0,    0,
    0,    0,   88,    0,    0,  -13,  -19,   50,   67,  -45,
    0,
};
#define YYTABLESIZE 369
short yytable[] = {                                      65,
   36,   10,   49,    7,   50,   26,   49,    7,   50,   12,
   77,   14,   36,   79,   81,   24,   23,   25,   45,   51,
   72,   52,   34,   51,   39,   52,   40,   41,   20,   42,
   43,   35,   49,   46,   50,   74,   75,    2,   78,   80,
    4,   36,   32,   36,   35,   36,   98,    5,   70,    6,
   22,   44,   60,   62,   66,   67,   41,   31,   69,   36,
   36,   36,   36,   34,   63,   34,   58,   34,   47,   68,
   82,   59,   45,   89,   84,   49,   21,   50,   85,   86,
   92,   34,   34,   34,   34,   35,   94,   35,   49,   35,
   50,   28,   57,   95,   96,   49,   49,   50,   50,   93,
    2,   25,   38,   35,   35,   35,   35,   61,   97,   47,
   49,   83,   50,   48,   73,    0,   31,    0,    0,    0,
    0,    0,    0,   36,   10,   36,    0,    0,    0,    0,
    0,    0,    0,    0,   12,    0,   14,    1,    0,    2,
    3,    0,    4,    2,   76,   34,    4,   34,    0,    5,
    0,    6,    0,    5,    0,    6,    0,    0,    0,   87,
   88,    0,    0,    0,   90,    0,   91,   35,    0,   35,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   31,    0,   31,    0,    0,    0,    0,    0,    0,    0,
    0,   47,    0,   47,    0,   45,    0,   45,    0,   21,
    0,   21,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   28,   57,   28,   57,    0,    0,
    0,    0,    0,    0,   24,    0,   25,    0,    0,   24,
   64,   25,   24,    0,   25,    0,   53,   54,   55,   56,
   53,   54,   55,   56,   34,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   10,   36,
   10,   10,   36,   10,   36,    0,    0,    0,    0,   36,
   10,   36,   10,    0,    0,    0,   36,   36,   36,   36,
   36,   34,    0,    0,   34,    0,   34,    0,    0,    0,
    0,   34,    0,   34,    0,    0,    0,    0,   34,   34,
   34,   34,   34,   35,    0,    0,   35,    0,   35,    0,
    0,    0,    0,   35,    0,   35,   31,    0,    0,   31,
   35,   35,   35,   35,   35,    0,   31,   47,   31,    0,
   47,   45,   47,   31,   45,   21,   45,   47,   21,   47,
    0,   45,    0,   45,   47,   21,    0,   21,   45,    0,
   28,   57,   21,   28,   57,    0,    0,    0,    0,    0,
   28,   57,   28,   57,    0,    0,    0,   28,   57,
};
short yycheck[] = {                                      41,
    0,    0,   43,  123,   45,   40,   43,  123,   45,    0,
   40,    0,   40,   40,   60,  259,    3,  261,   44,   60,
   61,   62,    0,   60,    7,   62,    9,    9,  259,   12,
   13,   59,   43,   59,   45,   49,   50,  259,   58,   59,
  262,   41,  275,   43,    0,   45,   92,  269,   59,  271,
  273,   59,  264,  270,   59,   38,   38,    0,   45,   59,
   60,   61,   62,   41,   41,   43,   42,   45,    0,  125,
  276,   47,    0,   41,   41,   43,    0,   45,  125,  259,
  263,   59,   60,   61,   62,   41,   41,   43,   43,   45,
   45,    0,    0,   41,   41,   43,   43,   45,   45,  273,
    0,  259,    7,   59,   60,   61,   62,   32,   41,   22,
   43,   62,   45,   26,   48,   -1,   59,   -1,   -1,   -1,
   -1,   -1,   -1,  123,  123,  125,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  125,   -1,  125,  257,   -1,  259,
  260,   -1,  262,  259,   57,  123,  262,  125,   -1,  269,
   -1,  271,   -1,  269,   -1,  271,   -1,   -1,   -1,   72,
   73,   -1,   -1,   -1,   77,   -1,   79,  123,   -1,  125,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  123,   -1,  125,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  123,   -1,  125,   -1,  123,   -1,  125,   -1,  123,
   -1,  125,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  123,  123,  125,  125,   -1,   -1,
   -1,   -1,   -1,   -1,  259,   -1,  261,   -1,   -1,  259,
  272,  261,  259,   -1,  261,   -1,  277,  278,  279,  280,
  277,  278,  279,  280,  272,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  257,  259,
  259,  260,  262,  262,  264,   -1,   -1,   -1,   -1,  269,
  269,  271,  271,   -1,   -1,   -1,  276,  277,  278,  279,
  280,  259,   -1,   -1,  262,   -1,  264,   -1,   -1,   -1,
   -1,  269,   -1,  271,   -1,   -1,   -1,   -1,  276,  277,
  278,  279,  280,  259,   -1,   -1,  262,   -1,  264,   -1,
   -1,   -1,   -1,  269,   -1,  271,  259,   -1,   -1,  262,
  276,  277,  278,  279,  280,   -1,  269,  259,  271,   -1,
  262,  259,  264,  276,  262,  259,  264,  269,  262,  271,
   -1,  269,   -1,  271,  276,  269,   -1,  271,  276,   -1,
  259,  259,  276,  262,  262,   -1,   -1,   -1,   -1,   -1,
  269,  269,  271,  271,   -1,   -1,   -1,  276,  276,
};
#define YYFINAL 8
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 280
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,"'('","')'","'*'","'+'","','","'-'",0,"'/'",0,0,0,0,0,0,0,0,0,0,0,
"';'","'<'","'='","'>'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"'{'",0,"'}'",0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,"INT","DOUBLE","ID","GLOBAL","CTEI","IF","ELSE","THEN",
"OP_LE","OP_GE","OP_NE","CTED","LOOP","UNTIL","PRINT","CHAIN","OP_ASIG",
"SEP_LIM","BEGIN","END","\"<=\"","\">=\"","\"<>\"","\"==\"",
};
char *yyrule[] = {
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
"sent_simple : asignacion ';'",
"sent_simple : imprimir",
"sent_simple : ID",
"sent_estruct : iter_loop",
"sent_estruct : sent_sel",
"asignacion : ID OP_ASIG exp_aritmetica ';'",
"$$1 :",
"asignacion : ID OP_ASIG exp_aritmetica $$1 ID OP_ASIG",
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
#endif
#ifndef YYSTYPE
typedef int YYSTYPE;
#endif
#define yyclearin (yychar=(-1))
#define yyerrok (yyerrflag=0)
#ifdef YYSTACKSIZE
#ifndef YYMAXDEPTH
#define YYMAXDEPTH YYSTACKSIZE
#endif
#else
#ifdef YYMAXDEPTH
#define YYSTACKSIZE YYMAXDEPTH
#else
#define YYSTACKSIZE 500
#define YYMAXDEPTH 500
#endif
#endif
int yydebug;
int yynerrs;
int yyerrflag;
int yychar;
short *yyssp;
YYSTYPE *yyvsp;
YYSTYPE yyval;
YYSTYPE yylval;
short yyss[YYSTACKSIZE];
YYSTYPE yyvs[YYSTACKSIZE];
#define yystacksize YYSTACKSIZE
#line 160 "parser.y"
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
	s = " Linea:"+al.getLinea()+" | " + s;
	this.modelInformation.setText( this.modelInformation.getText() + s);
}
public String toString() {
	return "";
}
#line 332 "y.tab.c"
#define YYABORT goto yyabort
#define YYACCEPT goto yyaccept
#define YYERROR goto yyerrlab
int
yyparse()
{
    register int yym, yyn, yystate;
#if YYDEBUG
    register char *yys;
    extern char *getenv();

    if (yys = getenv("YYDEBUG"))
    {
        yyn = *yys;
        if (yyn >= '0' && yyn <= '9')
            yydebug = yyn - '0';
    }
#endif

    yynerrs = 0;
    yyerrflag = 0;
    yychar = (-1);

    yyssp = yyss;
    yyvsp = yyvs;
    *yyssp = yystate = 0;

yyloop:
    if (yyn = yydefred[yystate]) goto yyreduce;
    if (yychar < 0)
    {
        if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, reading %d (%s)\n", yystate,
                    yychar, yys);
        }
#endif
    }
    if ((yyn = yysindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: state %d, shifting to state %d (%s)\n",
                    yystate, yytable[yyn],yyrule[yyn]);
#endif
        if (yyssp >= yyss + yystacksize - 1)
        {
            goto yyoverflow;
        }
        *++yyssp = yystate = yytable[yyn];
        *++yyvsp = yylval;
        yychar = (-1);
        if (yyerrflag > 0)  --yyerrflag;
        goto yyloop;
    }
    if ((yyn = yyrindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
        yyn = yytable[yyn];
        goto yyreduce;
    }
    if (yyerrflag) goto yyinrecovery;
#ifdef lint
    goto yynewerror;
#endif
yynewerror:
    yyerror("syntax error");
#ifdef lint
    goto yyerrlab;
#endif
yyerrlab:
    ++yynerrs;
yyinrecovery:
    if (yyerrflag < 3)
    {
        yyerrflag = 3;
        for (;;)
        {
            if ((yyn = yysindex[*yyssp]) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: state %d, error recovery shifting\
 to state %d\n", *yyssp, yytable[yyn]);
#endif
                if (yyssp >= yyss + yystacksize - 1)
                {
                    goto yyoverflow;
                }
                *++yyssp = yystate = yytable[yyn];
                *++yyvsp = yylval;
                goto yyloop;
            }
            else
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: error recovery discarding state %d\n",
                            *yyssp);
#endif
                if (yyssp <= yyss) goto yyabort;
                --yyssp;
                --yyvsp;
            }
        }
    }
    else
    {
        if (yychar == 0) goto yyabort;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, error recovery discards token %d (%s)\n",
                    yystate, yychar, yys);
        }
#endif
        yychar = (-1);
        goto yyloop;
    }
yyreduce:
#if YYDEBUG
    if (yydebug)
        printf("yydebug: state %d, reducing by rule %d (%s)\n",
                yystate, yyn, yyrule[yyn]);
#endif
    yym = yylen[yyn];
    yyval = yyvsp[1-yym];
    switch (yyn)
    {
case 2:
#line 17 "parser.y"
{ aserror("Faltan sentencias ejecutables"); }
break;
case 3:
#line 18 "parser.y"
{ aserror("Faltan sentencias de declaracion"); }
break;
case 6:
#line 29 "parser.y"
{yyout("[Sintactico] Declaracion identificadores INT");}
break;
case 7:
#line 30 "parser.y"
{yyout("[Sintactico] Declaracion identificadores GLOBAL");}
break;
case 10:
#line 37 "parser.y"
{ aserror("Falta ;"); }
break;
case 17:
#line 56 "parser.y"
{yyout("[Sintactico] Declaracion ambito - sent ejecutables");}
break;
case 18:
#line 57 "parser.y"
{yyout("[Sintactico] Declaracion ambito - sent decl+ejecutables");}
break;
case 19:
#line 62 "parser.y"
{yyout("[Sintactico] Asignacion");}
break;
case 21:
#line 64 "parser.y"
{ aserror(" Declaracion/Asignacion invalida");}
break;
case 25:
#line 76 "parser.y"
{aserror("Falta fin de la sentencia ;");}
break;
case 26:
#line 77 "parser.y"
{aserror("Asignacion Invalida, Falta ID/CONST");}
break;
case 28:
#line 84 "parser.y"
{ aserror("Falta fin de la sentencia ;");}
break;
case 29:
#line 85 "parser.y"
{aserror("Falta contenido a imprimir");}
break;
case 30:
#line 90 "parser.y"
{yyout("[Sintactico] Print cadena de caracteres");}
break;
case 31:
#line 91 "parser.y"
{ aserror("Falta el ) del print"); }
break;
case 32:
#line 92 "parser.y"
{ aserror("Falta el contenido a imprimir"); }
break;
case 33:
#line 93 "parser.y"
{ aserror("Falta el )"); }
break;
case 45:
#line 121 "parser.y"
{ aserror("Falta Cerrar Parentesis"); }
break;
case 46:
#line 122 "parser.y"
{ aserror("Falta Abrir Parentesis"); }
break;
case 47:
#line 123 "parser.y"
{ aserror("Faltan Parentesis"); }
break;
case 48:
#line 124 "parser.y"
{ aserror("No es posible Asignacion"); }
break;
case 57:
#line 149 "parser.y"
{yyout("[Sintactico] Sentencia IF Simple");}
break;
case 58:
#line 150 "parser.y"
{yyout("[Sintactico] Sentencia IF Compuesta");}
break;
case 59:
#line 155 "parser.y"
{yyout("[Sintactico] Sentencia Loop");}
break;
#line 568 "y.tab.c"
    }
    yyssp -= yym;
    yystate = *yyssp;
    yyvsp -= yym;
    yym = yylhs[yyn];
    if (yystate == 0 && yym == 0)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: after reduction, shifting from state 0 to\
 state %d\n", YYFINAL);
#endif
        yystate = YYFINAL;
        *++yyssp = YYFINAL;
        *++yyvsp = yyval;
        if (yychar < 0)
        {
            if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
            if (yydebug)
            {
                yys = 0;
                if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
                if (!yys) yys = "illegal-symbol";
                printf("yydebug: state %d, reading %d (%s)\n",
                        YYFINAL, yychar, yys);
            }
#endif
        }
        if (yychar == 0) goto yyaccept;
        goto yyloop;
    }
    if ((yyn = yygindex[yym]) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn];
    else
        yystate = yydgoto[yym];
#if YYDEBUG
    if (yydebug)
        printf("yydebug: after reduction, shifting from state %d \
to state %d\n", *yyssp, yystate);
#endif
    if (yyssp >= yyss + yystacksize - 1)
    {
        goto yyoverflow;
    }
    *++yyssp = yystate;
    *++yyvsp = yyval;
    goto yyloop;
yyoverflow:
    yyerror("yacc stack overflow");
yyabort:
    return (1);
yyaccept:
    return (0);
}
