package erdam.ej9.estudiante.interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import erdam.ej9.estudiante.mundo.Estudiante;
/**
 * Panel con la informaci�n basica del alumno.
 */
@SuppressWarnings("serial")
public class PanelEstudiante extends JPanel{

	//------- A T R I B U T O S -------//
	/**
	 * Etiqueta con el c�digo del estudiante.
	 */
	private JLabel lblCodigo;
	/**
	 * Etiqueta con el nombre del estudiante.
	 */
	private JLabel lblNombre;
	/**
	 * Etiqueta con el apellido del estudiante.
	 */
	private JLabel lblApellido;
	/**
	 * Etiqueta con el promedio del estudiante.
	 */
	private JLabel lblPromedio;
	/**
	 * Texto con el c�digo del estudiante. 
	 */
	private JTextField txtCodigo;
	/**
	 * Texto con el nombre del estudiante. 
	 */
	private JTextField txtNombre;
	/**
	 * Texto con el apellido del estudiante. 
	 */
	private JTextField txtApellido;
	/**
	 * Texto con el promedio del estudiante. 
	 */
	private JTextField txtPromedio;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor del panel estudiante, con la informaci�n del mismo.
	 */
	public PanelEstudiante()
	{
		
		setBorder(new TitledBorder("Informaci�n del estudiante"));
		lblCodigo 		= new JLabel(" C�digo");
		lblNombre 		= new JLabel(" Nombre");
		lblApellido 	= new JLabel(" Apellido");
		lblPromedio 	= new JLabel(" Promedio");
		txtCodigo       = new JTextField(15);
		txtCodigo.setEditable(false);
		txtNombre     	= new JTextField(15);
		txtNombre.setEditable(false);
		txtApellido     = new JTextField(15);
		txtApellido.setEditable(false);
		txtPromedio     = new JTextField(15);
		txtPromedio.setEditable(false);
		setLayout(new GridLayout(4,1,5,5));
		add(lblCodigo);
		add(txtCodigo);
		add(lblNombre);
		add(txtNombre);
		add(lblApellido );
		add(txtApellido );
		add(lblPromedio );
		add(txtPromedio );
		

	}
	//--------- M � T O D O S ----------//
	public void actualizarEstudiante(Estudiante pEstudiante )
	{
		
        txtCodigo.setText(pEstudiante.getCodigoEstudiante()+"");   
		txtNombre.setText(pEstudiante.getNombreDeEstudiante());
		txtApellido.setText(pEstudiante.getApellidoDeEstudiante());
		if(pEstudiante.calcularPromedio()!=-1)
		{
			txtPromedio.setText(pEstudiante.calcularPromedio()+"");
		}
		else
		{
			txtPromedio.setText("0.0");
		}
	}
	//---------------------------------------------------//

}
