package erdam.ej9.estudiante.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import erdam.ej9.estudiante.mundo.Departamento;
import erdam.ej9.estudiante.mundo.Estudiante;

public class EstudianteTest {
	//------- A T R I B U T O S -------//
		private Estudiante estudiante;
		//--------- E S C E N A R I O S ----------//
		/**
	     * Escenario 1: Crea un nuevo producto sin unidades vendidas.
	     */
		private void setupEscenario()
		{ 
			estudiante = new Estudiante();
		}
		//--------- M É T O D O S  D E  P R U E B A ----------//
		/**
		 * Prueba 1: Verifica el método constructor.<br>
		 * <b> Métodos a probar: </b> <br>
		 * Curso<br>
		 * getCodigoEstudiante <br>
		 * getNombreDeEstudiante <br>
		 * etApellidoDeEstudiante <br>
		 * getCurso1
		 * getCurso2
		 * getCurso3
		 * getCurso4
		 */
		@Test
		public void testEstudiante()
		{
			setupEscenario();
			assertEquals("Debería dar el código del estudiante ", 123, estudiante.getCodigoEstudiante());
			assertEquals("Debería dar el nombre del estudiante ", "Erdam", estudiante.getNombreDeEstudiante());
			assertEquals("Debería dar el apellido del estudiante ", "Techera", estudiante.getApellidoDeEstudiante());
			assertNotNull( "Debería existir el curso 1.", estudiante.getCurso1() );
			assertNotNull( "Debería existir el curso 1.", estudiante.getCurso2() );
			assertNotNull( "Debería existir el curso 1.", estudiante.getCurso3() );
			assertNotNull( "Debería existir el curso 1.", estudiante.getCurso4() );
			
		}
		//---------------------------------------------------//
	    /**
	     * Prueba 2: Verifica el método buscarCurso.<br>
	     * <b> Métodos a probar: </b> <br>
	     * buscarCurso<br>
	     * <b> Casos de prueba: </b> <br>
	     * 1. El curso existe.<br>
	     * 2. El curso no existe.
	     */
		@Test
		public void testBuscarCurso()
		{
			setupEscenario();
			assertNotNull("El curso debería existir", estudiante.buscarCurso("Mate11") );
			assertNull("No debería existir ningún curso", estudiante.buscarCurso("Mate10"));
		}
		//---------------------------------------------------//
		/**
	     * Prueba 3: Verifica el método buscarCurso.<br>
	     * <b> Métodos a probar: </b> <br>
	     * asignarNota<br>
	     * <b> Casos de prueba: </b> <br>
	     * 1. El curso no existe.<br>
	     * 2. El curso existe y la nota no está en el rango.<br>
	     * 3. El curso existe y la nota está en el rango.
	     */
	    @Test
	    public void testAsignarNotaCurso( )
	    {
	    	setupEscenario();
	    	assertFalse("No debería existir el curso", estudiante.asignarNota("Mate10", 5));
	    	assertFalse("debería haber ingresado la nota", estudiante.asignarNota("Mate11", 7));
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Mate11", 5));
	    }

		//---------------------------------------------------//
	    /**
	     * Prueba 4: Verifica el método calcularPromedioEstudiante.<br>
	     * <b> Métodos a probar: </b> <br>
	     * calcularPromedio<br>
	     * asignarNota<br>
	     * <b> Casos de prueba: </b> <br>
	     * 1. Ningún curso tiene notas.<br>
	     * 2. Todos los cursos tienen notas.
	     */
	    @Test
	    public void testCalcularPromedioEstudiante( )
	    {
	    	setupEscenario();
	    	 assertEquals( "El promedio no corresponde.", -1,  estudiante.calcularPromedio(),0.01 );
		    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Mate11", 4));
		    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Bio66", 3));
		    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Fis10", 5));
		    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Ing05", 4));
		    	assertEquals( "El promedio no corresponde.", 4.07,  estudiante.calcularPromedio(),0.01 );
	    	 
	    }
		//---------------------------------------------------//
	    /**
	     *  Prueba 5: Verifica el método enPrueba.<br>
	     * <b> Métodos a probar: </b> <br>
	     * enPrueba<br>
	     * asignarNota<br>
	     * <b> Casos de prueba: </b> <br>
	     * 1. No está en prueba.<br>
	     * 2. Está en prueba.
	     */
	    @Test 
	    public void testEnPrueba()
	    {
	    	setupEscenario();
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Mate11", 4));
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Bio66", 3));
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Fis10", 4));
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Ing05", 4));
	    	assertEquals( "El promedio no corresponde.", 3.785,  estudiante.calcularPromedio(),0.01 );
	    	assertFalse("debería estar en prueba", estudiante.enPrueba());
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Mate11", 2));
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Bio66", 3));
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Fis10", 2));
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Ing05", 4));
	    	assertEquals( "El promedio no corresponde.", 2.785,  estudiante.calcularPromedio(),0.01 );
	    	assertTrue("debería no estar en prueba", estudiante.enPrueba());
	    	
	    }
	    
	    //---------------------------------------------------//
	    /**
	     *  Prueba 6: Verifica el método becado.<br>
	     * <b> Métodos a probar: </b> <br>
	     * becado<br>
	     * asignarNota<br>
	     * <b> Casos de prueba: </b> <br>
	     * 1. No está en becado.<br>
	     * 2. Está becado.
	     */
	    @Test
	    public void testBecado()
	    {
	    	setupEscenario();
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Mate11", 4.7));
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Bio66", 5));
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Fis10", 4.9));
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Ing05", 4.8));
	    	assertTrue("debería estar becado", estudiante.becado());
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Mate11", 3));
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Bio66", 3));
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Fis10", 3));
	    	assertTrue("debería haber ingresado la nota", estudiante.asignarNota("Ing05", 4));
	    	assertFalse("debería no estar becado", estudiante.becado());
	    	
	    }
	    //---------------------------------------------------//
	    /**
	     * Prueba 7: Verifica el método cambiarCurso.<br>
	     * <b> Métodos a probar: </b> <br>
	     * cambiarCurso<br>
	     * <b> Casos de prueba: </b> <br>
	     * 1. Ya existe un curso con el nuevo código.<br>
	     * 2. No existe un curso con el nuevo código.
	     */
	    @Test
	    public void testCambiarCurso()
	    {
	    	setupEscenario();
	    	assertFalse("No debería haber un curso con éste código", estudiante.cambiarCurso("Mate10", "Mate20", "Matématica A", 4, Departamento.MATEMATICA));
	    	assertFalse("No debería haber un curso con éste código", estudiante.cambiarCurso("Mate11", "Bio66", "Biología b", 3, Departamento.BIOLOGIA));
	    	assertEquals("Debería dar el código actual del curso ", "Mate11", estudiante.getCurso1().getCodigoCurso());
	       assertTrue("Debería existir un curso con éste código", estudiante.cambiarCurso("Mate11", "Mate30", "Matématica A", 5, Departamento.MATEMATICA));
	       System.out.print(estudiante.getCurso1().getCodigoCurso());
	       assertEquals("Debería haber cambiado el código actual del curso ", "Mate30", estudiante.getCurso1().getCodigoCurso());
	    }
	    

}
