package erdam.ej9.estudiante.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import erdam.ej9.estudiante.mundo.Departamento;

@SuppressWarnings("serial")
public class DialogoCambiarCurso extends JDialog implements ActionListener {

	// ------- C O N S T A N T E S -------//
	/**
	 * Representa el comando para ingresar un nuevo curso.
	 */
	private static final String ACEPTAR = "Aceptar";
	/**
	 * Representa el comando para cancelar el ingreso de un nuevo curso.
	 */
	private static final String CANCELAR = "Cancelar";
	
	//------- A T R I B U T O S -------//
	/**
     * Etiqueta código actual.
     */
    private JLabel lblCodigoActual;

    /**
     * Etiqueta código nuevo.
     */
    private JLabel lblCodigoNuevo;

    /**
     * Etiqueta nombre.
     */
    private JLabel lblNombre;

    /**
     * Etiqueta departamento.
     */
    private JLabel lblDepartamento;

    /**
     * Etiqueta créditos.
     */
    private JLabel lblCreditos;

    /**
     * Campo de texto del código actual.
     */
    private JTextField txtCodigoActual;

    /**
     * Campo de texto del código nuevo.
     */
    private JTextField txtCodigoNuevo;

    /**
     * Campor de texto del nombre.
     */
    private JTextField txtNombre;

    /**
     * Combo box de los departamentos.
     */
    private JComboBox<String> cbDepartamentos;

    /**
     * Campo de texto de los créditos.
     */
    private JTextField txtCreditos;

    /**
     * Botón para aceptar.
     */
    private JButton btnAceptar;

    /**
     * Botón para cancelar.
     */
    private JButton btnCancelar;

	
	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazEstudiante principal;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Crea el diálogo que permite cambiar la información de un curso.
	 * @param pPrincipal  Ventana principal de la aplicación. pPrincipal != null.
	 * @param pCodigoCurso Código actual del curso. pCodigoCurso != null && pCodigoCurso != "".
	 */
	public DialogoCambiarCurso(InterfazEstudiante pPrincipal, String pCodigoCurso) {
		principal= pPrincipal;
		setSize(500, 300);
		setTitle("Cambiar curso");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setLocationRelativeTo(pPrincipal);
		setResizable(false);
		setLayout( new BorderLayout( ) );
        JPanel panelInfo = new JPanel( );
        panelInfo.setLayout( new GridLayout( 6, 2 ) );
        panelInfo.setBorder( new TitledBorder( "Información curso" ) );

        lblCodigoActual = new JLabel( " Código actual:" );
        panelInfo.add( lblCodigoActual );

        txtCodigoActual = new JTextField( pCodigoCurso );
        txtCodigoActual.setEditable( false );
        panelInfo.add( txtCodigoActual );

        lblCodigoNuevo = new JLabel( " Código nuevo:" );
        panelInfo.add( lblCodigoNuevo );

        txtCodigoNuevo = new JTextField( );
        panelInfo.add( txtCodigoNuevo );

        lblNombre = new JLabel( " Nombre:" );
        panelInfo.add( lblNombre );

        txtNombre = new JTextField( );
        panelInfo.add( txtNombre );

        lblDepartamento = new JLabel( " Departamento:" );
        panelInfo.add( lblDepartamento );

        cbDepartamentos = new JComboBox<String>( );
        cbDepartamentos.addItem( "Matemática" );
        cbDepartamentos.addItem( "Física" );
        cbDepartamentos.addItem( "Biología");
        cbDepartamentos.addItem( "Inglés" );
        panelInfo.add( cbDepartamentos );

        lblCreditos = new JLabel( "Créditos:" );
        panelInfo.add( lblCreditos );

        txtCreditos = new JTextField( );
        panelInfo.add( txtCreditos );

        btnAceptar = new JButton( ACEPTAR );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        panelInfo.add( btnAceptar );

        btnCancelar = new JButton( CANCELAR  );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelInfo.add( btnCancelar );

        add( panelInfo, BorderLayout.CENTER );

    
	
	}
	//--------- M É T O D O S ----------//
	//---------------------------------------------------//
	
	
	
	@Override
	public void actionPerformed(ActionEvent pEvento) {
		String command = pEvento.getActionCommand();
		try {
			if(command.equals(ACEPTAR))
			{
				String codigoActual 	= txtCodigoActual.getText();
				String codigoNuevo 		= txtCodigoNuevo.getText();
				String nombreCurso 		= txtNombre.getText();
				String creditos     	= txtCreditos.getText(); 
				
				Departamento departamento = Departamento.BIOLOGIA;
				String depSelec = (String) cbDepartamentos.getSelectedItem();

	            if( codigoActual.equals( "" ) || codigoNuevo.equals( "" ) || nombreCurso.equals( "" ) || creditos.equals( "" ) )
	            {
	                JOptionPane.showMessageDialog( this, "Debe llenar todos los campos.", "Cambiar curso", JOptionPane.ERROR_MESSAGE );
	            }
	            else
	            {
		                
						switch(depSelec)
						{
							case "Matemática":
								departamento = Departamento.MATEMATICA;
								break;
							case  "Física":
								departamento = Departamento.FISICA;
								break;
							case "Biología":
								departamento = Departamento.BIOLOGIA;
								break;
							case "Inglés":
								departamento = Departamento.INGLES;
								break;
						}
						
					int creditosValor = Integer.parseInt(creditos);
					if(creditosValor<=0)
					{
						 JOptionPane.showMessageDialog( this, "El número de créditos debería ser mayor a 0.", "Cambiar curso", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                    	principal.cambiarCurso(codigoActual, codigoNuevo, nombreCurso, departamento, creditosValor);
                   
                    	dispose();
                    }
	            }	
				
			}else if (command.equals(CANCELAR)) 
			{
			   dispose();
			}
			{
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog( this, "La cantidad de créditos debe ser un valor numérico.", "Cambiar curso", JOptionPane.ERROR_MESSAGE );
		}
		
		
	}

}
