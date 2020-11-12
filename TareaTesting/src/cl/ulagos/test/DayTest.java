package cl.ulagos.test;

import cl.ulagos.hotel.Appointment;
import cl.ulagos.hotel.Day;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DayTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DayTest
{
	private Day day1;
	private Appointment a1;

	/**
	 * Default constructor for test class DayTest
	 */
	public DayTest()
	{
	}

	/**
	 * Sets up the test fixture.
	 *
	 * Called before every test case method.
	 */
	@BeforeEach
	public void setUp()
	{
		day1 = new Day(1);
		a1 = new Appointment("one hour appointment a1", 1);
	}

	public void fillDay(){
		Appointment a2,a3,a4,a5,a6,a7,a8,a9;
		a2=new Appointment("a2",1);
		a3=new Appointment("a3",1);
		a4=new Appointment("a4",1);
		a5=new Appointment("a5",1);
		a6=new Appointment("a6",1);
		a7=new Appointment("a7",1);
		a8=new Appointment("a8",1);
		a9=new Appointment("a9",1);
		day1.makeAppointment(9, a1);
		day1.makeAppointment(10, a2);
		day1.makeAppointment(11, a3);
		day1.makeAppointment(12, a4);
		day1.makeAppointment(13, a5);
		day1.makeAppointment(14, a6);
		day1.makeAppointment(15, a7);
		day1.makeAppointment(16, a8);
		day1.makeAppointment(17, a9);
	}
	
	
	//primera cita en un dia vacío
	@Test
	public void t4a_firstAppointmentInEmptyDayShouldSucceed()
	{
		//given: empty day 
		// (from setup)
		// when: make appointment
		boolean success = day1.makeAppointment(9, a1);
		// then: is successfull
		assertEquals(true,success );
	}
	//La primera cita en un día vacío debería realmente programar una cita
	@Test
	public void t4b_firstAppointmentInEmptyDayShouldActuallyScheduleAppointment()
	{
		//given: empty day 
		// (from setup)
		// when: make appointment
		boolean success = day1.makeAppointment(9, a1);
		// then: appoint is scheduled
		assertEquals(a1, day1.getAppointment(9) );
	}
	//cita muy  temprano false
	@Test
	public void t5_appointmentTooEarlyShouldFail()
	{
		//given: empty day 
		// (from setup)
		// when: make appointment @ 800
		boolean success = day1.makeAppointment(8, a1);
		// then: is not successfull
		assertEquals(false,success );
	}
	//cita muy tarde false
	@Test
	public void t6_appointmentTooLateShouldFail()
	{
		//given: empty day 
		// (from setup)
		// when: make appointment @ 800
		boolean success = day1.makeAppointment(18, a1);
		// then: is not successfull
		assertEquals(false,success );
	}
	//segunda cita: no esta vacío a esa hora
	@Test
	public void t7a_secondAppointmentInNonEmptySlotFails()
	{
		//given: day w/ app. @1100
		Appointment originalAppointment = new Appointment("first",1);
		day1.makeAppointment(11, originalAppointment);
		// when: make appointment
		boolean success = day1.makeAppointment(11, a1);
		// then: is successfull
		assertEquals(false,success );
	}
	//La segunda cita en un espacio no vacío deja la primera cita
	@Test
	public void t7b_secondAppointmentInNonEmptySlotLeavesFirstAppointment()
	{
		//given: day w/ app. @1100
		Appointment originalAppointment = new Appointment("first",1);
		day1.makeAppointment(11, originalAppointment);
		// when: make appointment
		boolean success = day1.makeAppointment(11, a1);
		// then: appoint not scheduled
		assertEquals(originalAppointment, day1.getAppointment(11) );
	}
	//buscar espacio en un día vacío debe devolver el primer espacio
	@Test
	public void t8_findSpaceInEmptyDayShouldReturnFirstSlot(){
		// given empty day
		// when findSpace for 2h appointment
		int actual =(int) day1.findSpace(new Appointment("lasts 2 h",2));
		// then should return 900
		assertEquals(9,actual);

	}
	//iniciando una cita a las 12 horas, ingresar una cita de duración de 5 horas debiera dar false 
	//ya que seria desde las 09:00 hasta 14:00 y entremedio ya existe una cita a las 12 
	@Test
	public void t9_longerAppointmentOverlappingOtherShouldFail(){
		//given appointment @ 1200
		day1.makeAppointment(12,a1);
		//when makeAppointment 900-1400 (5h @ 900)
		Appointment longAppointment = new Appointment("loooong",5);
		boolean actual =   day1.makeAppointment(9,longAppointment);
		//then should fail
		System.out.println(actual);
		assertEquals(true, actual);
	}
	@Test
	//retorno 10 FindSpace
	public void primerTest() {
		System.out.println("Este es el primer test-INICIO");
		day1.makeAppointment(9,a1);
		int diez = (int)day1.findSpace(new Appointment("segunda cita",1.0));
		System.out.println("Siguiente hora libre --->  "+diez);
		day1.showAppointments();
		assertEquals(10, diez);
	}
	
	@Test
	public void segundoTest() {
		System.out.println("Este es el segundo test-INICIO");
		//llenar dia 
		fillDay();
		int menos1 = (int)day1.findSpace(new Appointment("cita",2.0));
		day1.showAppointments();
		System.out.println("Este es el segundo testing-FIN");
		assertEquals(-1,menos1);
	}
	@Test
	public void tercerTest() {
		System.out.println("Este es el tercer test-INICIO");
		day1.makeAppointment(9,a1);
		Appointment segundacita = new Appointment("segundacita",2.0);
		//boolean actual =   day1.makeAppointment(9,segundacita);
		//System.out.println("valor boolean --->  "+actual);
		assertFalse(day1.makeAppointment(9,segundacita));
		day1.showAppointments();
		System.out.println("Este es el tercer test-FIN");
		
	}
	@Test
	public void cuartoTest() {
		System.out.println("Este es el cuarto test-INICIO");
		Appointment citamedia = new Appointment("cita media hora",0.5);
		boolean prueba =   day1.makeAppointment(9,citamedia);
		assertEquals(true,prueba);
		day1.showAppointments();
		System.out.println("Este es el cuarto test-FIN");
	}
	
	
}

