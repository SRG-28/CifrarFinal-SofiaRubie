package Cifrando;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Principal {
	private static Scanner datos;
	public static void main(String[] args) throws IOException, InterruptedException   {	
			datos = new Scanner (System.in);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			short desplazamiento=0;
			String Codigo = " ";
			String CodigoCifrado = " ";
			String codCifra = " ";
			short opcion=0;
				do {
					System.out.println("==========================================");
					System.out.println("================Bievenidos================");
					System.out.println("======Encriptar con Cesar y Vigenere======");
					System.out.println("==========================================");
					System.out.println("1. Cifrar con Cesar");
					System.out.println("2. Descifrar con Cesar");
					System.out.println("3. Cifrar con Vigenere");
					System.out.println("4. Descifrar con Vigenere");
					System.out.println("5. Salir");
					System.out.println("==========================================");
					System.out.print("Digite una opcion: ");
					opcion= datos.nextShort();
					switch (opcion) {
					case 1:
						System.out.println("****Cifrar con Cesar****");
						System.out.print("Digite el codigo a cifrar(sin espacios entre palabras o letras):  ");
						Codigo=buffer.readLine();
						System.out.print("Digite el desplazamiento: ");
						desplazamiento=datos.nextShort();
						Cesar ces = new Cesar(Codigo, (short)desplazamiento);
						CodigoCifrado = ces.Cifrar();
						System.out.print("Codigo: ");
						System.out.println(Codigo);
						System.out.print("Codigo Cifrado: ");
						System.out.println(CodigoCifrado);
						Thread.sleep(2000);
						break;
					case 2:
						System.out.println("****Descifrar con Cesar****");
						System.out.print("Digite el codigo a decifrar: ");
						Codigo = buffer.readLine();
						System.out.print("Ingrese el desplazamiento que selecciono anteriormente: ");
						desplazamiento = datos.nextShort();
						Cesar CaesarD = new Cesar(Codigo, (short)desplazamiento);
						Codigo = CaesarD.Descifrar();
						System.out.print("Codigo descifrado: ");
						System.out.println(Codigo);
						Thread.sleep(2000);
						break;
					case 3:
						System.out.println("****Cifrar con Vigenere****");
						System.out.print("Digite el codigo a cifrar: ");
						Codigo = buffer.readLine();
						Vigenere Vigene = new Vigenere(Codigo, "CLAVE");
						codCifra = Vigene.Cifrar();
						System.out.print("Codigo cifrado: ");
						System.out.println(codCifra);
						Thread.sleep(2000);
						break;
					case 4:
						System.out.println("****Descifrar con Vigenere****");
						System.out.print("Digite el codigo a decifrar: ");
						codCifra = buffer.readLine();
						Vigenere Vigener = new Vigenere(codCifra, "CLAVE");
						System.out.print("Codigo cifrado: ");
						System.out.println(codCifra);
						System.out.print("Codigo descifrado: ");
						System.out.println(Vigener.Descifrar(codCifra, "CLAVE"));
						Thread.sleep(2000);
						break;
					case 5:
						System.out.println("****************Saliendo****************");
						System.out.println("Gracias por utilizar nuestra aplicacion");
						System.out.println("*****************************************");
						break;
					default:
						System.out.println("Debe digitar un numero del 1 al 5");
						Thread.sleep(2000);
					} //fin de switch 
				} while (opcion != 5);	 // fin de do...		
	} //fin del main
} // fin de la clase Principal
