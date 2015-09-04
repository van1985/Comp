package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

/**
 * 
 * @author vanden
 *
 * Se encarga de reconocer los tokens de tipo identificador. No consume. Devuelve string / caracter.
 */

public class Proceso2 extends Proceso {
	
	public Proceso2(Analizador_Lexico al){
		super(al);
	}

	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		int linea;
		if (s[0].getLexema().length() > 15)
			if (c == '\n')
				linea = anLex.getLinea()-1;// En caso de que haya un salto
			// de linea después de un ident
			// o constate.
			else
			{
				linea = anLex.getLinea();
			this.anLex.addError(new Integer(linea), "Identificador <"
					+ s[0].getLexema()
					+ ">, posee mas de 15 caracteres de largo");

			String a = new String((String) s[0].getLexema().substring(0, 15));
			this.anLex.addError(new Integer(linea), "Identificador <" + s[0].getLexema()
					+ "> truncado por: <" + a.toString() + ">");
			s[0].setLexema(a);
		}
		super.guardar(s, "Identificador");
		return true;
	}
}
