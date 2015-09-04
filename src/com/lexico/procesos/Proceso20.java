package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

//Reconoce un literal y lo guarda.

public class Proceso20 extends Proceso{

	public Proceso20(Analizador_Lexico al) {
		super(al);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		s[0].setLexema("" +c);
		super.guardar(s, "Literal");
		return false;
	}

}
