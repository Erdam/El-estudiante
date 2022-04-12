package erdam.ej9.estudiante.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import erdam.ej9.estudiante.mundo.Departamento;
import erdam.ej9.estudiante.mundo.Estudiante;
/**
 * Ventana principal de la aplicación.
 */

@SuppressWarnings("serial")
public class InterfazEstudiante extends JFrame{
	//------- A T R I B U T O S -------//
	/**
	 * Clase principal del mundo.
	 */
	private Estudiante estudiante;
	/**
	 * Panel con el curso 1.
	 */
	private PanelCurso curso1;
	/**
	 * Panel con el curso 2.
	 */
	private PanelCurso curso2;
	/**
	 * Panel con el curso 3.
	 */
	private PanelCurso curso3;
	/**
	 * Panel con el curso 4.
	 */
	private PanelCurso curso4;
	/**
	 * Panel contenedor del banner.
	 */
	private PanelBanner banner;
	/**
	 * Panel con la información del estudiante.
	 */
	private PanelEstudiante panelEstudiante;
	/**
	 * Panel de los botones con las dos opciones.
	 */
	private PanelBotones panelBotones;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor de la interfaz.<br>
	 * <b>post: </b> Se inicializarón todos los paneles.
	 */
	public InterfazEstudiante()
	{
		estudiante = new Estudiante();
		JPanel principal       	= new JPanel();
		JPanel panelCursos	 	= new JPanel();   
		banner 					= new PanelBanner();
		panelEstudiante 		= new PanelEstudiante();
		curso1 					= new PanelCurso(this);
		curso2 					= new PanelCurso(this);
		curso3 					= new PanelCurso(this);
		curso4 					= new PanelCurso(this);
		panelBotones            = new PanelBotones(this);
		setSize(800, 800);
		setResizable(false);
		setTitle("Estudiante");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		add(banner, BorderLayout.NORTH);
		principal.setLayout(new BorderLayout());
		panelCursos.setLayout(new GridLayout(2,2,5,5) );
		panelCursos.add(curso1);
		panelCursos.add(curso2);
		panelCursos.add(curso3);
		panelCursos.add(curso4);
		principal.add(panelEstudiante,BorderLayout.NORTH );
		principal.add(panelCursos,BorderLayout.CENTER );
		add(principal, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH );
		actualizar();
		
	}
	//--------- M É T O D O S ----------//
    /**
     * Actualiza todos los paneles.
     */
	private void actualizar()
	{
		panelEstudiante.actualizarEstudiante(estudiante);
		curso1.actualizar(estudiante.getCurso1());
		curso2.actualizar(estudiante.getCurso2());
		curso3.actualizar(estudiante.getCurso3());
		curso4.actualizar(estudiante.getCurso4());
		
	}

	// ---------------------------------------------------//
	/**
	 * Ventana emergente para cambiar el curso actual pasando los valores por parametro.
	 * @param pCodigoCurso Código del curso. pCodigoCurso!=null && pCodigoCurso!="". 
	 */
	public void mostrarDialogoCambiarCurso(String pCodigoCurso)
	{
		DialogoCambiarCurso dialogo = new DialogoCambiarCurso(this,pCodigoCurso);
		dialogo.setVisible(true);
	}
	// ---------------------------------------------------//
	/**
	 * Cambiar la información del curso actual.<br>
	 * @param pCodigoActual Código actual del curso. pCodigoActual!=null && pCodigoActual!="". 
	 * @param pCodigoNuevo Código nuevo del curos. pCodigoNuevo!=null && pCodigoNuevo!=""
	 * @param pNombre Nombre del curso. pNombre!=null && pNombre!="". 
	 * @param pDepartamento Departamento del curso. pDepartamento!=null.
	 * @param pCreditos Crédito a asignar. pCreditos
	 */
	public void cambiarCurso(String pCodigoActual, String pCodigoNuevo, String pNombre, Departamento pDepartamento, int pCreditos)
	{
		if(estudiante.cambiarCurso(pCodigoActual, pCodigoNuevo, pNombre, pCreditos, pDepartamento))
		{
			actualizar();
		}else
		{
			JOptionPane.showMessageDialog( this, "La cantidad de créditos debe ser un valor numérico.", "Cambiar curso", JOptionPane.ERROR_MESSAGE );
		}
	}
	// ---------------------------------------------------//
    /**
     * Asigna la nota de un curso.
     * @param pCodigo Código del curso que se le va a asignar la nota. pCodigo != null && pCodigo != "".
     */
	public void asignarNota(String pCodigo)
	{
		String ingresado = JOptionPane.showInputDialog(this, "Nota obtenida en el curso","Asignar nota", JOptionPane.DEFAULT_OPTION);
		if(ingresado!=null)
		{
			try {
				double nota = Double.parseDouble(ingresado);
				if(nota < 0)
				{

                    JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un valor positivo.", "Asignar nota", JOptionPane.ERROR_MESSAGE );
				}
				else
				{
					boolean asigno = estudiante.asignarNota(pCodigo, nota);
					if(asigno)
					{
						actualizar();
					}
					else
					{
						JOptionPane.showMessageDialog( this, "La nota debe estar entre 1.5 y 5.0.", "Asignar nota", JOptionPane.ERROR_MESSAGE );
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog( this, "Debe ingresar un valor numérico.", "Asignar nota", JOptionPane.ERROR_MESSAGE );
			}
			
		}
	}
	// ---------------------------------------------------//
    /**
     * Indica si el estudiante está en prueba o no.
     */
	public void estaEnPrueba()
	{
		double promedio = estudiante.calcularPromedio();
		boolean enPrueba = estudiante.enPrueba();
		if(promedio == -1)
		{
			JOptionPane.showMessageDialog( this, "Debe asignar nota al menos a un curso.", "Estudiante en prueba", JOptionPane.INFORMATION_MESSAGE );	
		}
		else
		{
			if(enPrueba)
			{
				 JOptionPane.showMessageDialog( this, "El estudiante se encuentra en prueba académica (promedio < 3.25).", "Estudiante en prueba", JOptionPane.INFORMATION_MESSAGE );
			}else
			{
				JOptionPane.showMessageDialog( this, "El estudiante no se encuentra en prueba académica (promedio >= 3.25).", "Estudiante en prueba", JOptionPane.INFORMATION_MESSAGE );
			}
		}
		
	}
	// ---------------------------------------------------//
	/**
	 * Indica si el estudiante es candidato a becado o no.
	 */
	public void estaConBeca()
	{
		double promedio = estudiante.calcularPromedio();
		boolean conBeca = estudiante.becado();
		if(promedio == -1)
		{
			JOptionPane.showMessageDialog( this, "Debe asignar nota al menos a un curso.", "Estudiante en prueba", JOptionPane.INFORMATION_MESSAGE );
			
		}else
		{
			if(conBeca)
			{
				JOptionPane.showMessageDialog( this, "El estudiante es candidato a beca (promedio >= 4.75).", "Estudiante candidato a beca", JOptionPane.INFORMATION_MESSAGE );
			}else
			{
				JOptionPane.showMessageDialog( this, "El estudiante no es candidato a beca (promedio < 4.75).", "Estudiante candidato a beca", JOptionPane.INFORMATION_MESSAGE );
			}
		}
	}
	// ---------------------------------------------------//
	// ---------------------------------------------------//
	/**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
	 */
	public static void main(String[] pArgs) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			InterfazEstudiante principal = new InterfazEstudiante();
			principal.setVisible(true);
		} catch (Exception e) {
			 e.printStackTrace();
		}

	}
}
