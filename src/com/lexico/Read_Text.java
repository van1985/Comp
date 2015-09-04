package com.lexico;

public class Read_Text {

	private static final String EOF = null;
	/**
	 *  
	 */
	
	private String Text;
	private String[] line;
	private int lineas;
	private int count;
    private int columna=0;
	
	
	public Read_Text(String texto) {
		super();
		// TODO Auto-generated constructor stub
		
		Text = new String(texto.toString()+"\n");
		line = Text.split("\n");
		count = 0;
		lineas = line.length;
		
		
	}

	public String readLine(){
	   if (count < lineas)
	      return line[count++];

	   return EOF;
		
	}
	
	public int numberLine(){
		return count;
		
	}

	public boolean eOF() {
		   if (count < lineas)
			      return false;
		  return true;
	}

	public String getCaracter() {
		 String linea = line[count];
	     if (linea.length()==(columna)){
	         linea= readLine();
	         columna=0;
	         return "\n"; //para reconocer el fin de linea y terminar un símbolo
	      }
	      if (linea==null)
	          return null;
	      else{
	        char a = linea.charAt(columna);
	        String b= new String();
	        columna+=1;
	        return (b+a);
	     }
	}
	
	public void backChars(int i){
		columna-=i;
	}
}
