package erdam.ej9.estudiante.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import erdam.ej9.estudiante.mundo.Curso;
import erdam.ej9.estudiante.mundo.Departamento;

public class CursoTest {
	//------- A T R I B U T O S -------//
	private Curso curso;
	//--------- E S C E N A R I O S ----------//
	/**
     * Escenario 1: Crea un nuevo producto sin unidades vendidas.
     */
	private void setupEscenario()
	{ 
		curso = new Curso("Mat122", "Matématica",30, Departamento.MATEMATICA);
	}
	//--------- M É T O D O S  D E  P R U E B A ----------//
	/**
	 * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
	 * curso <br>
	 * getCodigoCurso <br>
	 * getNombreCurso <br>
	 * getCredito <br>
	 * getDepartamento
	 */
	@Test
	public void testCurso()
	{
		setupEscenario();
		assertEquals( "El código del curso no corresponde.", "Mat122", curso.getCodigoCurso() );
		assertEquals( "El Nombre del curso no corresponde.", "Matématica", curso.getNombreCurso());
		assertEquals( "El crédito del curso no corresponde.", 30, curso.getCredito() );
		assertTrue( "El departamento del curso no corresponde.",  Departamento.MATEMATICA == curso.getDepartamento());
		
	}
	//---------------------------------------------------//
	/**
	 * Prueba 2: Verifica el método getNota.<br>
     * <b> Métodos a probar: </b> <br>
     * Nota  <br>
     * getNota  <br>
     * setNota  <br>
     * estaCalificado<br>
	 */
	@Test
	public void testNota()
	{
	   setupEscenario();
	   int nota =5;
	   assertTrue("La nota no coinciden",0 == curso.getNota());	
	   assertFalse( "El curso no debería tener nota.",curso.estaCalificado());
	   curso.setNota(nota);
	   assertTrue("La nota no coinciden debería ser 5",nota == curso.getNota());
	   assertTrue("Debería estar calificado", curso.estaCalificado());
	}


}
