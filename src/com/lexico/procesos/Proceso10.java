package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

/**
 * 
 * @author vanden
 *
 * Detecta saltos de lineas y suma una linea
 */

public class Proceso10 extends Proceso{

	public Proceso10(Analizador_Lexico al) {
		super(al);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		anLex.incLinea();
		return false;
	}

}
