package cl.ulagos.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import cl.ulagos.application.Identificador;

public class UsoBeforeCasoTest {
	Identificador id;
	
	@BeforeEach
	public void inicializador() {
		id=new Identificador();
		System.out.println("Inicializando");
	}
	
	@Test
	public void particionValida() {
		
		boolean resultado=id.validarIdentificador("a1");
		assertEquals(true,resultado);
	}
	
	@Test
	public void particionInvalida01() {
		
		boolean resultado=id.validarIdentificador("");
		assertEquals(false,resultado);
	}
	
	@Test
	public void particionInvalida02() {
		
		boolean resultado=id.validarIdentificador("A1b2C3d");
		assertEquals(false,resultado);
	}
	
	@Test
	public void particionInvalida03() {
		
		boolean resultado=id.validarIdentificador("2B3");
		assertEquals(false,resultado);
	}
	
	@Test
	public void particionInvalida04() {
		
		boolean resultado=id.validarIdentificador("z#12");
		assertEquals(false,resultado);
	}
	
	@AfterEach
	public void limpiar() {
		System.out.println("Limpiando");
	}

}

