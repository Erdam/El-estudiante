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
		//--------- M � T O D O S  D E  P R U E B A ----------//
		/**
		 * Prueba 1: Verifica el m�todo constructor.<br>
		 * <b> M�todos a probar: </b> <br>
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
			assertEquals("Deber�a dar el c�digo del estudiante ", 123, estudiante.getCodigoEstudiante());
			assertEquals("Deber�a dar el nombre del estudiante ", "Erdam", estudiante.getNombreDeEstudiante());
			assertEquals("Deber�a dar el apellido del estudiante ", "Techera", estudiante.getApellidoDeEstudiante());
			assertNotNull( "Deber�a existir el curso 1.", estudiante.getCurso1() );
			assertNotNull( "Deber�a existir el curso 1.", estudiante.getCurso2() );
			assertNotNull( "Deber�a existir el curso 1.", estudiante.getCurso3() );
			assertNotNull( "Deber�a existir el curso 1.", estudiante.getCurso4() );
			
		}
		//---------------------------------------------------//
	    /**
	     * Prueba 2: Verifica el m�todo buscarCurso.<br>
	     * <b> M�todos a probar: </b> <br>
	     * buscarCurso<br>
	     * <b> Casos de prueba: </b> <br>
	     * 1. El curso existe.<br>
	     * 2. El curso no existe.
	     */
		@Test
		public void testBuscarCurso()
		{
			setupEscenario();
			assertNotNull("El curso deber�a existir", estudiante.buscarCurso("Mate11") );
			assertNull("No deber�a existir ning�n curso", estudiante.buscarCurso("Mate10"));
		}
		//---------------------------------------------------//
		/**
	     * Prueba 3: Verifica el m�todo buscarCurso.<br>
	     * <b> M�todos a probar: </b> <br>
	     * asignarNota<br>
	     * <b> Casos de prueba: </b> <br>
	     * 1. El curso no existe.<br>
	     * 2. El curso existe y la nota no est� en el rango.<br>
	     * 3. El curso existe y la nota est� en el rango.
	     */
	    @Test
	    public void testAsignarNotaCurso( )
	    {
	    	setupEscenario();
	    	assertFalse("No deber�a existir el curso", estudiante.asignarNota("Mate10", 5));
	    	assertFalse("deber�a haber ingresado la nota", estudiante.asignarNota("Mate11", 7));
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Mate11", 5));
	    }

		//---------------------------------------------------//
	    /**
	     * Prueba 4: Verifica el m�todo calcularPromedioEstudiante.<br>
	     * <b> M�todos a probar: </b> <br>
	     * calcularPromedio<br>
	     * asignarNota<br>
	     * <b> Casos de prueba: </b> <br>
	     * 1. Ning�n curso tiene notas.<br>
	     * 2. Todos los cursos tienen notas.
	     */
	    @Test
	    public void testCalcularPromedioEstudiante( )
	    {
	    	setupEscenario();
	    	 assertEquals( "El promedio no corresponde.", -1,  estudiante.calcularPromedio(),0.01 );
		    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Mate11", 4));
		    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Bio66", 3));
		    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Fis10", 5));
		    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Ing05", 4));
		    	assertEquals( "El promedio no corresponde.", 4.07,  estudiante.calcularPromedio(),0.01 );
	    	 
	    }
		//---------------------------------------------------//
	    /**
	     *  Prueba 5: Verifica el m�todo enPrueba.<br>
	     * <b> M�todos a probar: </b> <br>
	     * enPrueba<br>
	     * asignarNota<br>
	     * <b> Casos de prueba: </b> <br>
	     * 1. No est� en prueba.<br>
	     * 2. Est� en prueba.
	     */
	    @Test 
	    public void testEnPrueba()
	    {
	    	setupEscenario();
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Mate11", 4));
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Bio66", 3));
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Fis10", 4));
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Ing05", 4));
	    	assertEquals( "El promedio no corresponde.", 3.785,  estudiante.calcularPromedio(),0.01 );
	    	assertFalse("deber�a estar en prueba", estudiante.enPrueba());
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Mate11", 2));
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Bio66", 3));
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Fis10", 2));
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Ing05", 4));
	    	assertEquals( "El promedio no corresponde.", 2.785,  estudiante.calcularPromedio(),0.01 );
	    	assertTrue("deber�a no estar en prueba", estudiante.enPrueba());
	    	
	    }
	    
	    //---------------------------------------------------//
	    /**
	     *  Prueba 6: Verifica el m�todo becado.<br>
	     * <b> M�todos a probar: </b> <br>
	     * becado<br>
	     * asignarNota<br>
	     * <b> Casos de prueba: </b> <br>
	     * 1. No est� en becado.<br>
	     * 2. Est� becado.
	     */
	    @Test
	    public void testBecado()
	    {
	    	setupEscenario();
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Mate11", 4.7));
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Bio66", 5));
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Fis10", 4.9));
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Ing05", 4.8));
	    	assertTrue("deber�a estar becado", estudiante.becado());
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Mate11", 3));
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Bio66", 3));
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Fis10", 3));
	    	assertTrue("deber�a haber ingresado la nota", estudiante.asignarNota("Ing05", 4));
	    	assertFalse("deber�a no estar becado", estudiante.becado());
	    	
	    }
	    //---------------------------------------------------//
	    /**
	     * Prueba 7: Verifica el m�todo cambiarCurso.<br>
	     * <b> M�todos a probar: </b> <br>
	     * cambiarCurso<br>
	     * <b> Casos de prueba: </b> <br>
	     * 1. Ya existe un curso con el nuevo c�digo.<br>
	     * 2. No existe un curso con el nuevo c�digo.
	     */
	    @Test
	    public void testCambiarCurso()
	    {
	    	setupEscenario();
	    	assertFalse("No deber�a haber un curso con �ste c�digo", estudiante.cambiarCurso("Mate10", "Mate20", "Mat�matica A", 4, Departamento.MATEMATICA));
	    	assertFalse("No deber�a haber un curso con �ste c�digo", estudiante.cambiarCurso("Mate11", "Bio66", "Biolog�a b", 3, Departamento.BIOLOGIA));
	    	assertEquals("Deber�a dar el c�digo actual del curso ", "Mate11", estudiante.getCurso1().getCodigoCurso());
	       assertTrue("Deber�a existir un curso con �ste c�digo", estudiante.cambiarCurso("Mate11", "Mate30", "Mat�matica A", 5, Departamento.MATEMATICA));
	       System.out.print(estudiante.getCurso1().getCodigoCurso());
	       assertEquals("Deber�a haber cambiado el c�digo actual del curso ", "Mate30", estudiante.getCurso1().getCodigoCurso());
	    }
	    

}
