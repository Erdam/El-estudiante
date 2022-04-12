package erdam.ej9.estudiante.mundo;
/**
 * El estudiante
 */
public class Estudiante {
	// ------- C O N S T A N T E S -------//
	/**
	 * Representa la nota m�nima para estar becado.
	 */
	private final static double ESTUDIANTE_BECADO 			= 4.75;
	/**
	 * Representa la nota m�nima para no estar en prueba acad�mica.
	 */
	private final static double ESTUDIANTE_PRUEBA			= 3.25;
	//------- A T R I B U T O S -------//
	/**
	 * Representa el c�digo del estudiante.
	 */
	private int 				codigoEstudiante;
	/**
	 * Representa el nombre del estudiante.
	 */
	private String 				nombreDeEstudiante;
	/**
	 * Representa le apellido del estudiante.
	 */
	private String 				apellidoDeEstudiante;
	/**
	 * Representa el curso 1 del estudiante.
	 */
	private Curso               curso1;
	/**
	 * Representa el curso 2 del estudiante.
	 */
	private Curso               curso2;
	/**
	 * Representa el curso 3 del estudiante.
	 */
	private Curso               curso3;
	/**
	 * Representa el curso 4 del estudiante.
	 */
	private Curso               curso4;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Crea un nuevo estudiante con los valores dados por par�metro. <br> 
	 * <b>post:</b> El estudiante fue creado con con los siguientes valores.<br>
	 * Nombre del estudiante: Erdam. Apellido del estudiante: Techera. c�digo del estudiante: 123.<br> 
	 * <b>post:</b> Los cuatro curso fuer�n inicializados con los siguientes valores.<br>
	 * Curso 1- El c�digo del curso: Mate11, la materia: Mat�matica, los cr�ditos:3 y el departamento: MATEMATICA. <br> 
	 * Curso 2- El c�digo del curso: Bio66, la materia: Biolog�a, los cr�ditos:3 y el departamento: BIOLOGIA. <br> 
	 * Curso 3- El c�digo del curso: Fis10, la materia: F�sica, los cr�ditos:4 y el departamento: FISICA. <br> 
	 * Curso 4- El c�digo del curso: Ing05, la materia: Ingl�s, los cr�ditos:4 y el departamento: INGLES. <br> 
	 */
	public Estudiante()
	{
		codigoEstudiante 		= 123;
		nombreDeEstudiante 		= "Erdam";
		apellidoDeEstudiante    = "Techera";
		curso1 = new Curso("Mate11", "Mat�matica", 3, Departamento.MATEMATICA);
		curso2 = new Curso("Bio66", "Biolog�a", 3, Departamento.BIOLOGIA);
		curso3 = new Curso("Fis10", "F�sica", 4, Departamento.FISICA);
		curso4 = new Curso("Ing05", "Ingl�s", 4, Departamento.INGLES);
	}
	//--------- M � T O D O S ----------//
	/**
	 * Retorna el c�digo del estudiante.<br>
	 * @return c�digo del estudiante.
	 */
	public int getCodigoEstudiante() {
		return codigoEstudiante;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el nombre del estudiante.<br>
	 * @return nombre del estudiante.
	 */
	public String getNombreDeEstudiante() {
		return nombreDeEstudiante;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el apellido del estudiante.<br>
	 * @return
	 */
	public String getApellidoDeEstudiante() {
		return apellidoDeEstudiante;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el curso 1 del estudiante<br>
	 * @return curso 1 del estudiante.
	 */
	public Curso getCurso1() {
		return curso1;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el curso 2 del estudiante<br>
	 * @return curso 2 del estudiante.
	 */
	public Curso getCurso2() {
		return curso2;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el curso 3 del estudiante<br>
	 * @return curso 3 del estudiante.
	 */
	public Curso getCurso3() {
		return curso3;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el curso 4 del estudiante<br>
	 * @return curso 4 del estudiante.
	 */
	public Curso getCurso4() {
		return curso4;
	}
	
	//---------------------------------------------------//
	/**
	 * Calcula el promedio del estudiante de los cursos que tienen nota asignada.<br>
	 * @return Promedio de los cursos que tienen nota asignada. S� ning�n curso tiene nota asignada devolver� -1.
	 */
	public double calcularPromedio()
	{
        double totalNota = 0.0;
        double totalCreditos = 0.0;
        double promedio = -1;

        if( curso1.estaCalificado( ) )
        {
            totalNota += ( curso1.getNota() * curso1.getCredito() );
            totalCreditos += curso1.getCredito();
        }
        if( curso2.estaCalificado( )  )
        {
            totalNota += ( curso2.getNota()* curso2.getCredito());
            totalCreditos += curso2.getCredito();
        }
        if( curso3.estaCalificado( )  )
        {
            totalNota += ( curso3.getNota() * curso3.getCredito( ) );
            totalCreditos += curso3.getCredito();
        }
        if( curso4.estaCalificado( ) )
        {
            totalNota += ( curso4.getNota() * curso4.getCredito() );
            totalCreditos += curso4.getCredito();
        }

        if( totalCreditos > 0 )
        {
            promedio = ( double )totalNota / totalCreditos;
        }

        return promedio;
		
	}
	//---------------------------------------------------//
	/**
	 * Busca un curso dado su c�digo.<br>
	 * @param pCodigo Codigo del curso. pCodigo!="" && pCodigo!=null.
	 * @return Curso buscado, null en caso de no encontrarlo.
	 */
	public Curso buscarCurso(String pCodigo) {
		Curso buscado = null;
		if (curso1.getCodigoCurso().equals(pCodigo)) {
			buscado = curso1;
		} else if (curso2.getCodigoCurso().equals(pCodigo)) {
			buscado = curso2;
		} else if (curso3.getCodigoCurso().equals(pCodigo)) {
			buscado = curso3;
		} else if (curso4.getCodigoCurso().equals(pCodigo)) {
			buscado = curso4;
		}

		return buscado;
	}
	
	//---------------------------------------------------//
	/**
	 * Registra la nota al curso dado por parametro. <br>
	 * <b>pre:</b>Existe un curso con el c�digo dado. <br>
	 * <b>post:</b>El curso tiene una nueva nota<br>
	 * @param pCodigo Codigo del curso. pCodigo!="" && pCodigo!=null.
	 * @param pNota Notra para asignar al curso. pNota>0.
	 * @return Retorna true si pudo asignar la nota, false de lo contrario.
	 */
	public boolean asignarNota(String pCodigo, double pNota)
	{
		Curso cursoBuscado = buscarCurso(pCodigo);
		boolean registra = false;
		if(pNota>= Curso.MINIMA_NOTA && pNota<= Curso.MAXIMA_NOTA && cursoBuscado!=null )
		{
			cursoBuscado.setNota(pNota);
			registra = true;
		}
		return registra;
	}
	//---------------------------------------------------//
	/**
	 * Indica si el estudiante se encuentra becado.<br>
	 * @return Retorna true si se est� becado, false de lo contrario.
	 */
	public boolean becado()
	{
		boolean tieneBeca=false;
		double promedio = calcularPromedio();
		if(promedio >= ESTUDIANTE_BECADO )
		{
			tieneBeca= true;
		}
		return tieneBeca;
	}
	
	//---------------------------------------------------//
	/**
	 * Indica si el estudiante se encuentra en prueba acad�mica.<br>
	 * @return Retorna true si se encuentra en prueba, false de lo contrario.
	 */
	public boolean enPrueba()
	{
		boolean enPrueba =false;
		double promedio = calcularPromedio();
		if(promedio< ESTUDIANTE_PRUEBA)
		{
			enPrueba = true;
		}
		return enPrueba;
	}
	//---------------------------------------------------//
	/**
	 * Cambia un curso que tiene el c�digo actual con los nuevos valores dados por par�metro. <br>
	 * S� ya existe un curso con el c�digo que se desea asignar, no se cambiar la informaci�n del curso. <br>
	 *  <b>pre: </b> Existe un curso con el c�digo dado. <br>
     * <b>post: </b> El c�digo nuevo, nombre del curso, el cr�dito y el departamento fueron cambiados con los valores dados por par�metro.<br>
	 * @param pCodigoActual C�digo actual del curso a cambiar. pCodigoActual!=null && pCodigoActual!="".
	 * @param pCodigoNuevo C�digo nuevo del curso. pCodigoNuevo!=null && pCodigoNuevo!="".
	 * @param pNombreCurso Nombre del curso. pNombreCurso!=null && pNombreCurso!="".
	 * @param pCredito Credito asignado al curso. pCredito > 0.
	 * @param pDepartamento Departamento del curso. pDepartamento!=null: 
	 * @return Retorna true si se cambi� el curso, false si no se cambi� porque ya exist�a un curso con el c�digo que se deseaba asignar.
	 */
	public boolean cambiarCurso(String pCodigoActual, String pCodigoNuevo, String pNombreCurso, int pCredito,
			Departamento pDepartamento) {
			boolean cambio = false;
	        if( buscarCurso( pCodigoNuevo ) == null )
	        {
	            if( curso1.getCodigoCurso( ).equals( pCodigoActual ) )
	            {
	                curso1 = new Curso( pCodigoNuevo, pNombreCurso,  pCredito, pDepartamento );
	                cambio = true;
	            }
	            else if( curso2.getCodigoCurso( ).equals( pCodigoActual ) )
	            {
	                curso2 = new Curso( pCodigoNuevo, pNombreCurso,  pCredito, pDepartamento );
	                cambio = true;
	            }
	            else if( curso3.getCodigoCurso( ).equals( pCodigoActual ) )
	            {
	                curso3 = new Curso( pCodigoNuevo, pNombreCurso,  pCredito, pDepartamento );
	                cambio = true;
	            }
	            else if( curso4.getCodigoCurso( ).equals( pCodigoActual ) )
	            {
	                curso4 = new Curso( pCodigoNuevo, pNombreCurso,  pCredito, pDepartamento );
	                cambio = true;
	            }
	           
	        }
	        return cambio;
	}

}
