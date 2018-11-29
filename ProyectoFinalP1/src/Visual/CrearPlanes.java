package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class CrearPlanes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearPlanes dialog = new CrearPlanes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearPlanes() {
		setBounds(100, 100, 398, 231);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(133, 28, 230, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("TV");
		rdbtnNewRadioButton.setBounds(56, 100, 49, 23);
		contentPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnTelefono = new JRadioButton("Telefono");
		rdbtnTelefono.setBounds(173, 100, 67, 23);
		contentPanel.add(rdbtnTelefono);
		
		JRadioButton rdbtnInternet = new JRadioButton("Internet");
		rdbtnInternet.setBounds(295, 100, 67, 23);
		contentPanel.add(rdbtnInternet);
		
		JLabel lblNombre = new JLabel("Nombre del plan");
		lblNombre.setBounds(31, 31, 92, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblCrearPlanes = new JLabel("Crear Planes");
		lblCrearPlanes.setBounds(139, 11, 86, 14);
		contentPanel.add(lblCrearPlanes);
		
		JLabel label = new JLabel("");
		label.setBounds(31, 73, 46, 14);
		contentPanel.add(label);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(56, 73, 49, 20);
		contentPanel.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(173, 73, 67, 20);
		contentPanel.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(295, 73, 68, 20);
		contentPanel.add(spinner_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
