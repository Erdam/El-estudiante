package erdam.ej9.estudiante.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Panel para mostrar la información de los cursos.
 *
 */
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import erdam.ej9.estudiante.mundo.Curso;
@SuppressWarnings("serial")
public class PanelCurso extends JPanel implements ActionListener {
	// ------- C O N S T A N T E S -------//
	/**
	 * Comando para agregar nota.
	 */
	private static final String AGREGAR_NOTA 	= "Asignar nota";
	/**
	 * Comando para cambiar un curso.
	 */
	private static final String CAMBIAR_CURSO 	= "Cambiar curso";
	//------- A T R I B U T O S -------//
	private InterfazEstudiante principal;
    /**
     * Código del curso.
     */
    private String 									codigoCurso;

	/**
	 * Etiqueta con imagen de margen.
	 */
	private JLabel 									lblImagen;
	/**
	 * Etiqueta con el nombre del curso.
	 */
	private JLabel 									lblNombre;
	/**
	 * Etiqueta con el departamento que pertenece el curso.
	 */
	private JLabel 									lblDepartamento;
	/**
	 * Etiqueta con los créditos del curso.
	 */
	private JLabel 									lblCredito;
	/**
	 * Etiqueta con la nota del curso.
	 */
	private JLabel 									lblNota;
	/**
	 * Campo con el nombre del curso.
	 */
	private JTextField 								txtNombre;
	/**
	 * Campo con el departamento que pertenece al curso.
	 */
	private JTextField 								txtDepartamento;
	/**
	 * Campo con los créditos del curso.
	 */
	private JTextField 								txtCredito;
	/**
	 * Campo con las notas del curso.
	 */
	private JTextField 								txtNota;
	/**
	 * Botón para agregar una nota.
	 */
	private JButton 								btnAgregarNota;
	/**
	 * Botón para cambiar un curso.
	 */
	private JButton 								btnCambiarCurso;
	
	//----- C O N S T R U C T O R  -----//
    /**
     * Crea el panel que muestra la información de un curso.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
	public PanelCurso(InterfazEstudiante pPrincipal)
	{
		principal=pPrincipal;
		setBorder( new TitledBorder( "Curso " ) );
        setLayout( new BorderLayout( ) );

        JPanel panAux = new JPanel( );
        panAux.setLayout( new GridLayout( 5, 2, 3, 3 ) );

        lblNombre = new JLabel( "Nombre:" );
        panAux.add( lblNombre );

        txtNombre = new JTextField( );
        txtNombre.setEditable( false );
        panAux.add( txtNombre );

        lblDepartamento = new JLabel( "Departamento:" );
        panAux.add( lblDepartamento );

        txtDepartamento = new JTextField( );
        txtDepartamento.setEditable( false );
        panAux.add( txtDepartamento );

        lblCredito = new JLabel( "Créditos:" );
        panAux.add( lblCredito );

        txtCredito = new JTextField( );
        txtCredito.setEditable( false );
        panAux.add( txtCredito );

        lblNota = new JLabel( "Nota:" );
        panAux.add( lblNota );

        txtNota = new JTextField( );
        txtNota.setEditable( false );
        panAux.add( txtNota );

        btnCambiarCurso = new JButton(  CAMBIAR_CURSO);
        btnCambiarCurso.setActionCommand( CAMBIAR_CURSO );
        btnCambiarCurso.addActionListener( this );
        panAux.add( btnCambiarCurso );

        btnAgregarNota = new JButton( AGREGAR_NOTA );
        btnAgregarNota.setActionCommand( AGREGAR_NOTA );
        btnAgregarNota.addActionListener(this);
        panAux.add( btnAgregarNota );

        add( panAux, BorderLayout.CENTER );

        JPanel pnlImg = new JPanel( );
        pnlImg.setLayout( new GridLayout( 1, 2 ) );
        lblImagen = new JLabel( );
        pnlImg.add( lblImagen );
        pnlImg.add( new JLabel( ) );
        add( pnlImg, BorderLayout.WEST );

		
	}
	//--------- M É T O D O S ----------//
	public void actualizar( Curso pCurso )
    {
        txtNombre.setText( pCurso.getNombreCurso());
        setBorder( new TitledBorder( pCurso.getCodigoCurso() ) );
        codigoCurso = pCurso.getCodigoCurso();
        String depto = "";
        String ruta = "./data/imagenes/";
        switch( pCurso.getDepartamento() )
        {
            case MATEMATICA:
            {
                depto = "Matemática";
                ruta += "matematica.png";
                break;
            }
            case FISICA:
            {
                depto = "Física";
                ruta += "fisica.png";
                break;
            }
            case BIOLOGIA:
            {
                depto = "Biología";
                ruta += "biologia.png";
                break;
            }
            case INGLES:
            {
                depto = "Inglés";
                ruta += "ingles.png";
                break;
            }
        }
        ImageIcon icono = new ImageIcon( ruta );
        lblImagen.setIcon( icono );
        txtDepartamento.setText( depto );
        txtCredito.setText( pCurso.getCredito() + "" );
        txtNota.setText( pCurso.getNota() + "" );
    }

	//---------------------------------------------------//
	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvento Evento de click sobre un botón. pEvento != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvento) {
		String command = pEvento.getActionCommand();
		try {
			if(command.equals(CAMBIAR_CURSO)) {
				principal.mostrarDialogoCambiarCurso(codigoCurso);
			}
			if(command.equals(AGREGAR_NOTA)) 
			{
				principal.asignarNota(codigoCurso);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}

}
