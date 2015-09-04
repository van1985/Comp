package com.lexico;

public class Matriz {

	private Par[][] matrix;

	public Matriz(int f, int c) {
		this.matrix = new Par[f][c];
	}
	
	public Par getElemento(int f, int c){
		return this.matrix[f][c];
	}
	public void setElemento(int f, int c, Par p){
		this.matrix[f][c] = p;
	}
}
