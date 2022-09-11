package Cifrando; //Interfaz, metodos no se implementan aqui

public interface CifrandoSustitucionLlave {
	public String CleanUpInvalidChars();
	public String Descifrar(String Text, String Key);
}
