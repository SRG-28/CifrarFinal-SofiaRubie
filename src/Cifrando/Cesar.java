package Cifrando; //SubClase, hereda de la interfaz CifrandoSustitucion

public class Cesar implements CifrandoSustitucion{ 
	private String cadena = new String();
	private short desplazamiento;
	private String CodigoCifrado = "";
	
	public String Cifrar(){ //String palabras, int espacio
		//int x = desplazamiento;
		cadena = cadena.toUpperCase();
		char[] arrayWords = cadena.toCharArray();
		char[] array1 = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char[] charArray = arrayWords;
		int tamChar = charArray.length; 
		for(int i = 0; i <= tamChar-1; i++) {
		char aux = charArray[i];
		int pos = new String(array1).indexOf(aux);
		char nuevaLetra = array1[pos + desplazamiento];
		CodigoCifrado = CodigoCifrado + nuevaLetra;
			}
		return CodigoCifrado;
	}
	
	public String Descifrar()
	{
		return traducirCadena();
	}

	// constructor
	public Cesar(String Cadena, short Desplazamiento)
	{
		cadena = Cadena;
		desplazamiento = Desplazamiento;
	}
	
	private String traducirCadena(){
	        for (int i = 0; i < cadena.length(); i++) {
	            char caracter = cadena.toLowerCase().charAt(i);
	            if(caracter>=97 && caracter<=122){
	                    if(caracter<='a'){
	                        caracter = (char)('z' - (caracter -'a'));
	                    }else{
	                        caracter-=desplazamiento;
	                    }
	                    CodigoCifrado+=(char)(caracter);
	                
	            }else{
	                CodigoCifrado+=caracter;
	            }
	        }
	        cadena = CodigoCifrado;
	        return cadena;
    }//final de la clase traducir...
} // fin de la clase Cesar
