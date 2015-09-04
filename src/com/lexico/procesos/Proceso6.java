package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;

/**
 * 
 * @author vanden
 *
 * Se encarga de reconocer constantes del tipo _ui y validar su rango
 */

public class Proceso6 extends Proceso{

	public Proceso6(Analizador_Lexico al){
		super(al);
	}
	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		try{
			int val = Integer.valueOf(s[0].getLexema());
			int max = (int)Math.pow(2,16)-1;
			if ((val>=0)&&(val<=max)){
				super.guardar(s, "Constante Entera del tipo _ui");
			}
			else{
				this.anLex.addError(this.anLex.getLinea(), "Constante entera fuera de rango: "+s[0].getLexema());
				s[0].setLexema("");
			}
		}catch (NumberFormatException e){
			this.anLex.addError(this.anLex.getLinea(), "Constante entera fuera de rango: "+s[0].getLexema());
			s[0].setLexema("");
		}
		finally{ return false; }
	}

}
