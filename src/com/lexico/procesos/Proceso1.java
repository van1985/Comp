package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;


/**
 * 
 * @author vanden
 *
 * Concatenar la cadena. Este proceso no devuelve ningun caracter. Consume.
 */

public class Proceso1 extends Proceso{

	public Proceso1(Analizador_Lexico al){
		super(al);
	}
	
	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		if (c == '\n')
			this.anLex.incLinea();
		s[0].setLexema(s[0].getLexema()+c);
		return false;
	}

}
