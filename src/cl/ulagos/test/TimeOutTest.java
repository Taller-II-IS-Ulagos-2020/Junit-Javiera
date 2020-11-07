package cl.ulagos.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import cl.ulagos.application.Identificador;

public class TimeOutTest {
	
	Identificador id;
	public static final int LIMITE=100;
	
	@BeforeEach
	public void inicializa() {
		id=new Identificador();
	}
	
		@Test
		@Timeout (value=LIMITE,unit=TimeUnit.MILLISECONDS)
		
		public void particionValida() throws Exception{
			
			//TimeUnit.MILLISECONDS.sleep(101);
			boolean resultado=id.validarIdentificador("");
			assertEquals(true,resultado);
		}
		@Test
		@Timeout (value=LIMITE,unit=TimeUnit.MILLISECONDS)
		public void particionInvalidad01() throws Exception{
			TimeUnit.MILLISECONDS.sleep(101);
			boolean resultado=id.validarIdentificador("");
			assertEquals(false,resultado);
		}
		@Test
		@Timeout (value=LIMITE,unit=TimeUnit.MILLISECONDS)
		public void particionInvalidad02() throws Exception{
			TimeUnit.MILLISECONDS.sleep(101);
			boolean resultado=id.validarIdentificador("A1b2C3d");
			assertEquals(false,resultado);
		}
		@Test
		@Timeout (value=LIMITE,unit=TimeUnit.MILLISECONDS)
		public void particionInvalidad03() throws Exception{
			TimeUnit.MILLISECONDS.sleep(101);
			boolean resultado=id.validarIdentificador("2B3");
			assertEquals(false,resultado);
		}
		@Test
		@Timeout (value=LIMITE,unit=TimeUnit.MILLISECONDS)
		public void particionInvalidad04() throws Exception{
			TimeUnit.MILLISECONDS.sleep(101);
			boolean resultado=id.validarIdentificador("z#12");
			assertEquals(false,resultado);
		}
	

}
