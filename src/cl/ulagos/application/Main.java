package cl.ulagos.application;

public class Main {

	public static void main (String[] args) {
		
		if (args.length == 0) {
			System.out.println("Uso: Main <string>");
			
		}
		else
		{
			Identificador id = new Identificador();
			if (id.validarIdentificador(args[0])) {
				System.out.println("Valido");
			}else
			{
				System.out.println("Invalido");
			}
		}
	}
}
