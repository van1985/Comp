package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

/**
 * 
 * @author vanden
 *
 * Se encarga de reconocer un blanco o tab. Consume
 */

public class Proceso19 extends Proceso{

	public Proceso19(Analizador_Lexico al) {
		super(al);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		//System.out.println("Se encontra un blanco/tab en la linea " + anLex.getLinea());
		return false;
	}

}
