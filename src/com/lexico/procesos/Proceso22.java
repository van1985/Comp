package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

public class Proceso22 extends Proceso{

	public Proceso22(Analizador_Lexico al) {
		super(al);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		s[0].setLexema(s[0].getLexema());
		super.guardar(s, "Cadena caracteres");
		return false;
	}

}
