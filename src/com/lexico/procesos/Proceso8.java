package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

/**
 * 
 * @author vanden
 *
 * Se encarga de informar que comienza una comentario
 */

public class Proceso8 extends Proceso{

	public Proceso8(Analizador_Lexico al){
		super(al);
	}
	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		//s[0].setToken("Comienzo de comentario en la linea " + anLex.getLinea());
		return false;
	}

}
