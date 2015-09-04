package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

/**
 * 
 * @author vanden
 *
 * Se encarga de informar cuando una constante es invalida
 */

public class Proceso3 extends Proceso{

	public Proceso3(Analizador_Lexico al){
		super(al);
	}

	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		this.anLex.addError(this.anLex.getLinea(), "Constante invalida: "+s[0].getLexema());
		s[0].setLexema("");
		return true; //No consume
	}
}
