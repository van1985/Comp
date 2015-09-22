package com.lexico;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.lexico.procesos.Proceso;
import com.lexico.procesos.Proceso1;
import com.lexico.procesos.Proceso2;
import com.lexico.procesos.Proceso20;
import com.lexico.procesos.Proceso21;
import com.lexico.procesos.Proceso22;
import com.lexico.procesos.Proceso3;
import com.lexico.procesos.Proceso4;
import com.lexico.procesos.Proceso5;
import com.lexico.procesos.Proceso6;
import com.lexico.procesos.Proceso7;
import com.lexico.procesos.Proceso8;
import com.lexico.procesos.Proceso9;
import com.lexico.procesos.Proceso10;
import com.lexico.procesos.Proceso11;
import com.lexico.procesos.Proceso12;
import com.lexico.procesos.Proceso13;
import com.lexico.procesos.Proceso14;
import com.lexico.procesos.Proceso15;
import com.lexico.procesos.Proceso16;
import com.lexico.procesos.Proceso17;
import com.lexico.procesos.Proceso18;
import com.lexico.procesos.Proceso19;

public class Analizador_Lexico {

	private Matriz M;
	private Integer linea=1;
	private DefaultTableModel model = null;
	private Read_Text arch;
	private int estadoActual, entrada;
	private String a;
	private boolean devolver;
	private DefaultTableModel informationModel;
	
	public Analizador_Lexico(Tabla_de_simbolos t,Read_Text r,DefaultTableModel m, DefaultTableModel me){
		tbs=t;
		arch = r;
		m.addColumn("Linea");
		m.addColumn("Error");
		model = m;
		informationModel= me;
		CrearMatriz();
	}
	
	private Tabla_de_simbolos tbs;
	
	private void CrearMatriz(){
		M = new Matriz(13,16);
		
		//Creacion de Procesos
		Proceso1 p1 = new Proceso1(this);
		Proceso2 p2 = new Proceso2(this);
		Proceso3 p3 = new Proceso3(this);
		Proceso4 p4 = new Proceso4(this);
		Proceso5 p5 = new Proceso5(this);
		Proceso6 p6 = new Proceso6(this);
		Proceso7 p7 = new Proceso7(this);
		Proceso8 p8 = new Proceso8(this);
		Proceso9 p9 = new Proceso9(this);
		Proceso10 p10 = new Proceso10(this);
		Proceso11 p11 = new Proceso11(this);
		Proceso12 p12 = new Proceso12(this);
		Proceso13 p13 = new Proceso13(this);
		Proceso14 p14 = new Proceso14(this);
		Proceso15 p15 = new Proceso15(this);
		Proceso16 p16 = new Proceso16(this);
		Proceso17 p17 = new Proceso17(this);
		Proceso18 p18 = new Proceso18(this);
		Proceso19 p19 = new Proceso19(this);
		Proceso20 p20 = new Proceso20(this);
		Proceso21 p21 = new Proceso21(this);
		Proceso22 p22 = new Proceso22(this);
		
		//Fila 0
		M.setElemento(0, 0, new Par(1,p1));
		M.setElemento(0, 1, new Par(3,p1));
		M.setElemento(0, 2, new Par(2,p1));
		M.setElemento(0, 3, new Par(0,p18));
		M.setElemento(0, 4, new Par(1,p1));
		M.setElemento(0, 5, new Par(1,p1));
		M.setElemento(0, 6, new Par(0,p20));
		M.setElemento(0, 7, new Par(6,null));
		M.setElemento(0, 8, new Par(11,p1));
		M.setElemento(0, 9, new Par(10,p1));
		M.setElemento(0, 10, new Par(9,p1));
		M.setElemento(0, 11, new Par(0,p10));
		M.setElemento(0, 12, new Par(0,p19));
		M.setElemento(0, 13, new Par(12,null));
		M.setElemento(0, 14, new Par(0,p18));
		
		
		//Fila 1
		M.setElemento(1, 0, new Par(1,p1));
		M.setElemento(1, 1, new Par(1,p1));
		M.setElemento(1, 2, new Par(1,p1));
		M.setElemento(1, 3, new Par(0,p2));
		M.setElemento(1, 4, new Par(1,p1));
		M.setElemento(1, 5, new Par(1,p1));
		M.setElemento(1, 6, new Par(0,p2));
		M.setElemento(1, 7, new Par(0,p2));
		M.setElemento(1, 8, new Par(0,p2));
		M.setElemento(1, 9, new Par(0,p2));
		M.setElemento(1, 10, new Par(0,p2));
		M.setElemento(1, 11, new Par(0,p2));
		M.setElemento(1, 12, new Par(0,p2));
		M.setElemento(1, 13, new Par(0,p2));
		M.setElemento(1, 14, new Par(0,p2));
		
		//Fila 2
		M.setElemento(2, 0, new Par(1,p1));
		M.setElemento(2, 1, new Par(0,p21));
		M.setElemento(2, 2, new Par(0,p21));
		M.setElemento(2, 3, new Par(0,p21));
		M.setElemento(2, 4, new Par(1,p1));
		M.setElemento(2, 5, new Par(1,p1));
		M.setElemento(2, 6, new Par(0,p21));
		M.setElemento(2, 7, new Par(0,p21));
		M.setElemento(2, 8, new Par(0,p21));
		M.setElemento(2, 9, new Par(0,p21));
		M.setElemento(2, 10, new Par(0,p21));
		M.setElemento(2, 11, new Par(0,p21));
		M.setElemento(2, 12, new Par(0,p21));
		M.setElemento(2, 13, new Par(0,p21));
		M.setElemento(2, 14, new Par(0,p21));
		
		//Fila 3
		M.setElemento(3, 0, new Par(0,p3));
		M.setElemento(3, 1, new Par(3,p1));
		M.setElemento(3, 2, new Par(0,p3));
		M.setElemento(3, 3, new Par(4,null));
		M.setElemento(3, 4, new Par(0,p3));
		M.setElemento(3, 5, new Par(0,p3));
		M.setElemento(3, 6, new Par(0,p3));
		M.setElemento(3, 7, new Par(0,p3));
		M.setElemento(3, 8, new Par(0,p3));
		M.setElemento(3, 9, new Par(0,p3));
		M.setElemento(3, 10, new Par(0,p3));
		M.setElemento(3, 11, new Par(0,p3));
		M.setElemento(3, 12, new Par(0,p3));
		M.setElemento(3, 13, new Par(0,p3));
		M.setElemento(3, 14, new Par(0,p3));
		
		//Fila 4
		M.setElemento(4, 0, new Par(0,p3));
		M.setElemento(4, 1, new Par(0,p3));
		M.setElemento(4, 2, new Par(0,p3));
		M.setElemento(4, 3, new Par(0,p3));
		M.setElemento(4, 4, new Par(5,null));
		M.setElemento(4, 5, new Par(0,p4));
		M.setElemento(4, 6, new Par(0,p3));
		M.setElemento(4, 7, new Par(0,p3));
		M.setElemento(4, 8, new Par(0,p3));
		M.setElemento(4, 9, new Par(0,p3));
		M.setElemento(4, 10, new Par(0,p3));
		M.setElemento(4, 11, new Par(0,p3));
		M.setElemento(4, 12, new Par(0,p3));
		M.setElemento(4, 13, new Par(0,p3));
		M.setElemento(4, 14, new Par(0,p3));
		
		//Fila 5
		M.setElemento(5, 0, new Par(0,p5));
		M.setElemento(5, 1, new Par(0,p5));
		M.setElemento(5, 2, new Par(0,p5));
		M.setElemento(5, 3, new Par(0,p5));
		M.setElemento(5, 4, new Par(0,p5));
		M.setElemento(5, 5, new Par(0,p6));
		M.setElemento(5, 6, new Par(0,p5));
		M.setElemento(5, 7, new Par(0,p5));
		M.setElemento(5, 8, new Par(0,p5));
		M.setElemento(5, 9, new Par(0,p5));
		M.setElemento(5, 10, new Par(0,p5));
		M.setElemento(5, 11, new Par(0,p5));
		M.setElemento(5, 12, new Par(0,p5));
		M.setElemento(5, 13, new Par(0,p5));
		M.setElemento(5, 14, new Par(0,p5));
		
		//Fila 6
		M.setElemento(6, 0, new Par(0,p7));
		M.setElemento(6, 1, new Par(0,p7));
		M.setElemento(6, 2, new Par(0,p7));
		M.setElemento(6, 3, new Par(0,p7));
		M.setElemento(6, 4, new Par(0,p7));
		M.setElemento(6, 5, new Par(0,p7));
		M.setElemento(6, 6, new Par(0,p7));
		M.setElemento(6, 7, new Par(7,p8));
		M.setElemento(6, 8, new Par(0,p7));
		M.setElemento(6, 9, new Par(0,p7));
		M.setElemento(6, 10, new Par(0,p7));
		M.setElemento(6, 11, new Par(0,p7));
		M.setElemento(6, 12, new Par(0,p7));
		M.setElemento(6, 13, new Par(0,p7));
		M.setElemento(6, 14, new Par(0,p7));
		
		//Fila 7
		M.setElemento(7, 0, new Par(7,null));
		M.setElemento(7, 1, new Par(7,null));
		M.setElemento(7, 2, new Par(7,null));
		M.setElemento(7, 3, new Par(7,null));
		M.setElemento(7, 4, new Par(7,null));
		M.setElemento(7, 5, new Par(7,null));
		M.setElemento(7, 6, new Par(7,null));
		M.setElemento(7, 7, new Par(8,null));
		M.setElemento(7, 8, new Par(7,null));
		M.setElemento(7, 9, new Par(7,null));
		M.setElemento(7, 10, new Par(7,null));
		M.setElemento(7, 11, new Par(7,p10));
		M.setElemento(7, 12, new Par(7,null));
		M.setElemento(7, 13, new Par(7,null));
		M.setElemento(7, 14, new Par(0,null));
		
		//Fila 8
		M.setElemento(8, 0, new Par(7,null));
		M.setElemento(8, 1, new Par(7,null));
		M.setElemento(8, 2, new Par(7,null));
		M.setElemento(8, 3, new Par(7,null));
		M.setElemento(8, 4, new Par(7,null));
		M.setElemento(8, 5, new Par(7,null));
		M.setElemento(8, 6, new Par(7,null));
		M.setElemento(8, 7, new Par(0,p9));
		M.setElemento(8, 8, new Par(7,null));
		M.setElemento(8, 9, new Par(7,null));
		M.setElemento(8, 10, new Par(7,null));
		M.setElemento(8, 11, new Par(7,null));
		M.setElemento(8, 12, new Par(7,null));
		M.setElemento(8, 13, new Par(7,null));
		M.setElemento(8, 14, new Par(7,null));
		
		//Fila 9
		M.setElemento(9, 0, new Par(0,p11));
		M.setElemento(9, 1, new Par(0,p11));
		M.setElemento(9, 2, new Par(0,p11));
		M.setElemento(9, 3, new Par(0,p11));
		M.setElemento(9, 4, new Par(0,p11));
		M.setElemento(9, 5, new Par(0,p11));
		M.setElemento(9, 6, new Par(0,p11));
		M.setElemento(9, 7, new Par(0,p11));
		M.setElemento(9, 8, new Par(0,p11));
		M.setElemento(9, 9, new Par(0,p11));
		M.setElemento(9, 10, new Par(0,p12));
		M.setElemento(9, 11, new Par(0,p11));
		M.setElemento(9, 12, new Par(0,p11));
		M.setElemento(9, 13, new Par(0,p11));
		M.setElemento(9, 14, new Par(0,p11));
		
		//Fila 10
		M.setElemento(10, 0, new Par(0,p13));
		M.setElemento(10, 1, new Par(0,p13));
		M.setElemento(10, 2, new Par(0,p13));
		M.setElemento(10, 3, new Par(0,p13));
		M.setElemento(10, 4, new Par(0,p13));
		M.setElemento(10, 5, new Par(0,p13));
		M.setElemento(10, 6, new Par(0,p13));
		M.setElemento(10, 7, new Par(0,p13));
		M.setElemento(10, 8, new Par(0,p13));
		M.setElemento(10, 9, new Par(0,p13));
		M.setElemento(10, 10, new Par(0,p14));
		M.setElemento(10, 11, new Par(0,p13));
		M.setElemento(10, 12, new Par(0,p13));
		M.setElemento(10, 13, new Par(0,p13));
		M.setElemento(10, 14, new Par(0,p13));
		
		//Fila 11
		M.setElemento(11, 0, new Par(0,p15));
		M.setElemento(11, 1, new Par(0,p15));
		M.setElemento(11, 2, new Par(0,p15));
		M.setElemento(11, 3, new Par(0,p15));
		M.setElemento(11, 4, new Par(0,p15));
		M.setElemento(11, 5, new Par(0,p15));
		M.setElemento(11, 6, new Par(0,p15));
		M.setElemento(11, 7, new Par(0,p15));
		M.setElemento(11, 8, new Par(0,p15));
		M.setElemento(11, 9, new Par(0,p17));
		M.setElemento(11, 10, new Par(0,p16));
		M.setElemento(11, 11, new Par(0,p15));
		M.setElemento(11, 12, new Par(0,p15));
		M.setElemento(11, 13, new Par(0,p15));
		M.setElemento(11, 14, new Par(0,p15));
		
		//Fila 12
		M.setElemento(12, 0, new Par(12,p1));
		M.setElemento(12, 1, new Par(12,p1));
		M.setElemento(12, 2, new Par(12,p1));
		M.setElemento(12, 3, new Par(12,p1));
		M.setElemento(12, 4, new Par(12,p1));
		M.setElemento(12, 5, new Par(12,p1));
		M.setElemento(12, 6, new Par(12,p1));
		M.setElemento(12, 7, new Par(12,p1));
		M.setElemento(12, 8, new Par(12,p1));
		M.setElemento(12, 9, new Par(12,p1));
		M.setElemento(12, 10, new Par(12,p1));
		M.setElemento(12, 11, new Par(12,p1));
		M.setElemento(12, 12, new Par(12,p1));
		M.setElemento(12, 13, new Par(0,p22));
		M.setElemento(12, 14, new Par(0,p1));
	}
	
	private int getCol(char c){
		if (  ( (c >= 'a') && (c <= 'h') ) || ((c >= 'j') && (c <= 't') ) || ((c >= 'v') && (c <= 'z') ) )
			return 0;
		if ((c >= '0') && (c <= '9'))
			return 1;
		if (c=='@')
			return 2;
		if (c=='_')
			return 3;
		if (c=='u')
			return 4;
		if (c=='i')
			return 5;
		if (((c == '+') || (c == ',') || (c == ';') || (c == '(') || (c == ')') || (c == '*') || (c == '-') || (c == '{') || (c == '}')) )
			return 6;
		if (c == '/')
			return 7;
		if (c == '<')
			return 8;
		if (c== '>')
			return 9;
		if (c=='=')
			return 10;
		if (c == '\n')
			return 11;
		if ( (c == ' ') || (c == '\t') )
			return 12;
		if ( new String(""+c).indexOf("'") != -1   )
			return 13;
		return 14; // caracter invalido
		//14 EOF (?) sino elimino un estado
	}
	
	
	public Integer getLinea(){
		return linea;
	}
	
	public void incLinea(){
		linea+=1;
	}
	
	public Tabla_de_simbolos getTabladeSimbolos(){
		return tbs;
	}
	
	public void addError(Integer l, String s){
		s = "[LEXICO] "+s;
		this.model.addRow(new Object[]{l, s});
	}
	
	public void addInformation(String s){
		this.informationModel.addRow(new Object[]{"[LEXICO]",this.getLinea(), s});
	}
	
	public Simbolo getToken() {
		Simbolo[] s = new Simbolo[1];
		s[0] = new Simbolo();
		Proceso p;
		int inicio = this.getLinea(); //se usa solo para informar cadena sin cierre 
		while (!arch.eOF() && (!s[0].isConstructed())) {
			if (!(devolver))
				a = arch.getCaracter();
			entrada = getCol(a.charAt(0) );
			Par pa= (Par) M.getElemento(estadoActual, entrada);
			p=pa.getProceso();
			if (p != null){
				devolver = p.ejecutar(s, a.charAt(0));
			}
			else
				devolver = false;
			
			if (estadoActual == 18)
				this.arch.backChars(1);
				
			estadoActual = ((Par) M.getElemento(estadoActual,
					entrada)).getestadoProximo().intValue();
		}
		if (arch.eOF() && (!s[0].isConstructed()) && !(s[0].getLexema().isEmpty()))
			this.addError(inicio, "Cadena de caracteres mal formada: "+s[0].getLexema());
		if (arch.eOF() && (!s[0].isConstructed()))
			return new Simbolo("EndOfFile", "$");
		return s[0];
	}
	
	public DefaultTableModel getErroresLexico(){
		return model;
	}
}
