package erdam.ej9.estudiante.mundo;
/**
 * Cursos del estudiante
 */
public class Curso {
	// ------- C O N S T A N T E S -------//
	/**
	 * Representa nota mínima obtenida en el curso.
	 */
	public final static double MINIMA_NOTA 	= 1.5;
	/**
	 * Representa nota máxima obtenida en el curso.
	 */
	public final static double MAXIMA_NOTA 	= 5.0;
	//------- A T R I B U T O S -------//
	/**
	 * Representa el código del curso.
	 */
	private String 				codigoCurso;
	/**
	 * Representa el nombre del curso.
	 */
	private String 				nombreCurso;
	/**
	 * Representa el departamento perteneciente al curso.
	 */
	private Departamento 		departamento;
	/**
	 * Representa la cantidad de crédito del curso.
	 */
	private int 				credito;
	/**
	 * Representa la nota del curso.
	 */
	private double 				nota;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Creo un curso con los valores pasados por parámetros.<br>
	 * <b>post:</b> El código del curso, el nombre del curso, el depatramento y el crédito fueron inicializados por parámetro. 
	 * @param pCodigoCurso Código de identificación del curso. pCodigoCurso!=null && pCodigoCurso!="". 
	 * @param pNombreCurso Nombre del curso. pNombreCurso!=null && pNombreCurso!="".
	 * @param pCredito Crédito del curso. pCredito>0.
	 * @param pDepartamento Departamento que representa un curso. pDepartamento!=null. 
	 */
	public Curso(String pCodigoCurso, String pNombreCurso,int pCredito, Departamento pDepartamento)
	{
		codigoCurso 	= pCodigoCurso;

		nombreCurso 	= pNombreCurso;
	
		departamento 	= pDepartamento;

		credito         = pCredito;

		nota            = 0;	
	}
	//--------- M É T O D O S ----------//
	/**
	 * Retorna la nota del curso..<br>
	 * @return nota del curso.
	 */
	public double getNota() {
		return nota;
	}
	//---------------------------------------------------//
	/**
	 * Asigna la nota dada por parámetro.<br>
	 * <b>post:</b> Se asigna la nota del curso.
	 * @param pNota Nota del curso. pNota >= 1.5 && pNota<=5.0.
	 */
	public void setNota(double pNota) {
		nota = pNota;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el código del curso.<br>
	 * @return Código del curso.
	 */
	public String getCodigoCurso() {
		return codigoCurso;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el nombre del curso.<br>
	 * @return Nombre del curso.
	 */
	public String getNombreCurso() {
		return nombreCurso;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el departametno del curso.<br>
	 * @return Departamento del curso.
	 */
	public Departamento getDepartamento() {
		return departamento;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el crédito asignado al curso.<br>
	 * @return Crédito del curso.
	 */
	public int getCredito() {
		return credito;
	}
	
	//---------------------------------------------------//
	/**
	 * Indica si el curso ya ha sido calificado.<br>
	 * @return Retorna true si el curso ya tiene nota, false de lo contrario.
	 */
	public boolean estaCalificado()
	{
		boolean calificado 	= false;
		if(nota>0.0)
		{
			calificado 		= true;
		}
		return calificado;
	}
}
