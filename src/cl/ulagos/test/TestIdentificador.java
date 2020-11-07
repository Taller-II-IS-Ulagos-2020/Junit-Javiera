package cl.ulagos.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import cl.ulagos.application.Identificador;

public class TestIdentificador {

	@Test
	public void primerTest() {
		
		Identificador id = new Identificador();
		boolean resultado = id.validarIdentificador("");
		assertEquals(false,resultado);
		
	}
	
	@Test
	public void segundoTest() {
		
		Identificador id = new Identificador();
		boolean resultado = id.validarIdentificador("1de");
		assertEquals(false,resultado);
		
	}
	
	
}
