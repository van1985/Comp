package com.lexico.procesos;

import com.lexico.Analizador_Lexico;
import com.lexico.Simbolo;
import static java.lang.Math.pow;
/**
 * 
 * @author vanden
 *
 *Se encarga de reconocer las constantes enteras del tipo _i y verifica el rango.
 * entre -2'15 y 2'15-1
 */

public class Proceso4 extends Proceso{

	public Proceso4(Analizador_Lexico al){
		super(al);
	}
	
	@Override
	public boolean ejecutar(Simbolo[] s, char c) {
		try{
			int val = Integer.valueOf(s[0].getLexema());
			int min = (int) Math.pow(-2,15);
			int max = (int)Math.pow(2,15)-1;
			if ((val>=min)&&(val<max)){
				super.guardar(s, "CTE_I");
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
