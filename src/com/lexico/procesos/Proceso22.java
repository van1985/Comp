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
		super.guardar(s, "Cadena de caracteres");
		return false;
	}

}
