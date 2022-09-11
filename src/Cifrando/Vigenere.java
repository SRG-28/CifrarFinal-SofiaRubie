package Cifrando; //SubClase, hereda de la interfaz CifrandoSustitucionLlave

public class Vigenere implements CifrandoSustitucionLlave {
	private String cleartext = "";
	private String encryptedtext = "";
	private String key = "";

	// Constructores
	public Vigenere(String Cadena, String Clave)
	{
		cleartext = Cadena.toUpperCase();
		key = Clave;
		
		// Crear llave
		key = generateKey(Cadena, Clave);
	}
	
	
	// Metodos heredados de la interfaz 
	
  	public String Cifrar() 
	{ 
  		encryptedtext = cipherText(cleartext,key); 
  		return encryptedtext;
	} 

	//  
	public String Descifrar() 
	{ 
		return originalText(encryptedtext, key);
	} 
	
	public String Descifrar(String Text, String Key) 
	{ 
		
		return originalText(Text, generateKey(Text,Key));
	}
	
	public String CleanUpInvalidChars()
	{
		String CleanText = "";
		return CleanText;
	}
	
	// Metodos y funciones locales
		
	static String generateKey(String str, String key) 
	{ 
		int x = str.length(); 

		for (int i = 0; ; i++) 
		{ 
			if (x == i) 
				i = 0; 
			if (key.length() == str.length()) 
				break; 
			key+=(key.charAt(i)); 
		} 
		return key; 
	} 

	static String cipherText(String str, String key) 
	{ 
		String cipher_text=""; 

		for (int i = 0; i < str.length(); i++) 
		{ 
			// converting in range 0-25 
			int x = (str.charAt(i) + key.charAt(i)) %26; 

			// convert into alphabets(ASCII) 
			x += 'A'; 

			cipher_text+=(char)(x); 
		} 
		return cipher_text; 
	} 

	static String originalText(String cipher_text, String key) 
	{ 
		String orig_text=""; 

		for (int i = 0 ; i < cipher_text.length() && 
								i < key.length(); i++) 
		{ 
			// converting in range 0-25 
			int x = (cipher_text.charAt(i) - 
						key.charAt(i) + 26) %26; 

			// convert into alphabets(ASCII) 
			x += 'A'; 
			orig_text+=(char)(x); 
		} 
		return orig_text; 
	} 
}// fin de la clase vigenere
