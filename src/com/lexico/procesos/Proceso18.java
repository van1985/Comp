package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

public class Proceso18 extends Proceso{

	public Proceso18(Analizador_Lexico al) {
		super(al);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		this.anLex.addError(this.anLex.getLinea(), "Caracter invalido: "+c+" \"");
		s[0].setLexema("");
		return true;
	}

	
}
