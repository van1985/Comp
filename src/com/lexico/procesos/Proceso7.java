package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

/**
 * 
 * @author vanden
 *
 * Se encarga reconocer el token /. No consume.
 */

public class Proceso7 extends Proceso{

	public Proceso7(Analizador_Lexico al){
		super(al);
	}
	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		s[0].setLexema("/");
		super.guardar(s, "Literal");
		return true; // ? Consume
	}

}
