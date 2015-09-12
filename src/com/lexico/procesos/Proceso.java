package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

public abstract class Proceso {

	protected Analizador_Lexico anLex;
	

	public Proceso(Analizador_Lexico al) {
		anLex = al;
	}

	public abstract boolean ejecutar(Simbolo[] s, char c);

	public void guardar(Simbolo[] s, String token) {
		if (anLex.getTabladeSimbolos().existeSimbolo(s[0].getLexema())) {
			s[0] = anLex.getTabladeSimbolos().getSimbolo(s[0].getLexema());
		} else {
			s[0].setToken(token);
			anLex.getTabladeSimbolos().add(s[0].getLexema(),s[0]);
		}
		anLex.addInformation("[Lexico] Linea:"+anLex.getLinea()+" | "+s[0].getToken()+" "+s[0].getLexema()+" \n");
		s[0].incRef();
	}
}
