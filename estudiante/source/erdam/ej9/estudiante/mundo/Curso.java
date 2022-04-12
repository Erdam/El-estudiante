package erdam.ej9.estudiante.mundo;
/**
 * Cursos del estudiante
 */
public class Curso {
	// ------- C O N S T A N T E S -------//
	/**
	 * Representa nota m�nima obtenida en el curso.
	 */
	public final static double MINIMA_NOTA 	= 1.5;
	/**
	 * Representa nota m�xima obtenida en el curso.
	 */
	public final static double MAXIMA_NOTA 	= 5.0;
	//------- A T R I B U T O S -------//
	/**
	 * Representa el c�digo del curso.
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
	 * Representa la cantidad de cr�dito del curso.
	 */
	private int 				credito;
	/**
	 * Representa la nota del curso.
	 */
	private double 				nota;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Creo un curso con los valores pasados por par�metros.<br>
	 * <b>post:</b> El c�digo del curso, el nombre del curso, el depatramento y el cr�dito fueron inicializados por par�metro. 
	 * @param pCodigoCurso C�digo de identificaci�n del curso. pCodigoCurso!=null && pCodigoCurso!="". 
	 * @param pNombreCurso Nombre del curso. pNombreCurso!=null && pNombreCurso!="".
	 * @param pCredito Cr�dito del curso. pCredito>0.
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
	//--------- M � T O D O S ----------//
	/**
	 * Retorna la nota del curso..<br>
	 * @return nota del curso.
	 */
	public double getNota() {
		return nota;
	}
	//---------------------------------------------------//
	/**
	 * Asigna la nota dada por par�metro.<br>
	 * <b>post:</b> Se asigna la nota del curso.
	 * @param pNota Nota del curso. pNota >= 1.5 && pNota<=5.0.
	 */
	public void setNota(double pNota) {
		nota = pNota;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el c�digo del curso.<br>
	 * @return C�digo del curso.
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
	 * Retorna el cr�dito asignado al curso.<br>
	 * @return Cr�dito del curso.
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
