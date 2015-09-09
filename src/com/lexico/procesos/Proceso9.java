package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

/**
 * 
 * @author vanden
 *
 * Se encarga de informar que se finalizo un comentario
 */

public class Proceso9 extends Proceso{

	public Proceso9(Analizador_Lexico al){
		super(al);
	}
	
	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		//s[0].setToken("Finalizacion de comentario en la linea " + anLex.getLinea());
		return false;
	}

}
