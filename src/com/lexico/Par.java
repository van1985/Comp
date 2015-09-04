package com.lexico;

import com.lexico.procesos.Proceso;

public class Par {

	private int estadoProximo;
	private Proceso p;
	
	public Par(int id, Proceso paux){
		estadoProximo=id;
		p=paux;
	}
	
	Integer getestadoProximo(){
	return estadoProximo;
}
	
	Proceso getProceso(){
		return p;
	}
	
	public void setEstadoProximo(int id){
		estadoProximo=id;
	}
	
	public void setProceso(Proceso paux){
		p=paux;
	}
}
