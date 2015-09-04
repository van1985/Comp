package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

/**
 * 
 * @author vanden
 *
 * Se encarga de informar cuando una constante es invalida del tipo _ui
 */

public class Proceso5 extends Proceso{

	public Proceso5(Analizador_Lexico al){
		super(al);
	}
	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		this.anLex.addError(this.anLex.getLinea(), "Constante del tipo _ui invalida: "+s[0].getLexema());
		
		s[0].setLexema("");
		return true; //No consume
	}

}
