package erdam.ej9.estudiante.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener {
	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazEstudiante principal;
	/**
	 * Commando para saber si el estudiante está becado
	 */
	private final static String CANDIDATO_BECA ="Candidato a beca";
	/**
	 * Camando para saber si el alumno está en prueba.
	 */
	private final static String EN_PRUEBA = "En prueba"	;
	/**
	 * Botón para saber si está becado.
	 */
	private JButton btnBecado;
	/**
	 * botón para saber si está en prueba.
	 */
	private JButton btnEnPrueba;
	
	/**
	 * Crea el panel con sus botones.
	 * @param pPrincipal  Ventana principal de la aplicación. pPrincipal != null.
	 */
	 public PanelBotones(InterfazEstudiante pPrincipal) {
		 principal = pPrincipal;
		 btnBecado = new JButton(CANDIDATO_BECA);
		 btnBecado.setActionCommand(CANDIDATO_BECA);
		 btnBecado.addActionListener(this);
		 
		 btnEnPrueba = new JButton(EN_PRUEBA);
		 btnEnPrueba.setActionCommand(EN_PRUEBA);
		 btnEnPrueba.addActionListener(this);
		 JPanel escena = new JPanel();
		 escena.setLayout(new GridLayout(1,2,5,5));
		 escena.setBorder(new TitledBorder("Opciones"));
		 escena.add(btnBecado);
		 escena.add(btnEnPrueba);
		 setLayout(new BorderLayout());
		 add(escena, BorderLayout.CENTER);


	}

	@Override
	public void actionPerformed(ActionEvent pEstado) {
		String command = pEstado.getActionCommand();
		try {
			if(command.equals(CANDIDATO_BECA))
			{
				principal.estaConBeca();
				
			}else if(command.equals(EN_PRUEBA))
				{
					principal.estaEnPrueba();
				}
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
	}

}
