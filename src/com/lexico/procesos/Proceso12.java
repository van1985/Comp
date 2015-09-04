package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

/**
 * 
 * @author vanden
 *
 * Se encarga de reconocer el comparador ==. Consume
 */

public class Proceso12 extends Proceso{

	public Proceso12(Analizador_Lexico al) {
		super(al);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		s[0].setLexema("==");
		super.guardar(s, "Operador Relacional");
		return false;
	}

}
