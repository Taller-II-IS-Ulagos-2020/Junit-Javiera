package cl.ulagos.application;

public class Identificador {

	public boolean validarIdentificador(String s) {
		
		char achar;
		boolean idValido = false;
		
	if((s!=null) &&(s.length()>0)) {
		achar = s.charAt(0);
		idValido = sValido(achar);

		if (s.length() > 1)
		{
			achar = s.charAt(1);
			int i = 1;
			while (i < s.length() -1) {

				achar = s.charAt(i);
				if (!fValido(achar)) 
					idValido = false;
				i++;

			}
		}
	}
		if (idValido && (s.length() >=1) && (s.length() < 6)) 
			return true;
		else
			return false;
		}
	

	public boolean sValido(char ch) {

		if (((ch>= 'A') && (ch <= 'Z')) || ((ch >= 'a') && (ch <= 'z')))
			return true;
		else
			return false;
	}
	
	public boolean fValido(char ch) {
		
		if (((ch>= 'A') && (ch <= 'Z')) || ((ch >= 'a') && (ch <= 'z')) || ((ch >='0') && (ch <= '9')))
			return true;
		else
			return false;
	}

}
