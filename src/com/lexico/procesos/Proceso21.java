package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

/*
 * Identificador mal formado despues de un @ otro @ , debe venir una letra
 */

public class Proceso21 extends Proceso{

	public Proceso21(Analizador_Lexico al) {
		super(al);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		this.anLex.addError(this.anLex.getLinea(), "Indentificador mal formado: "+s[0].getLexema());
		s[0].setLexema("");
		return true; //No consume
	}

}
