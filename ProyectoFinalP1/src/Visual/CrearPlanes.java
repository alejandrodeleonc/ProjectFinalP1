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

public class CrearPlanes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 389, 334);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(87, 28, 230, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(87, 70, 230, 20);
		contentPanel.add(textField_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("TV");
		rdbtnNewRadioButton.setBounds(57, 145, 49, 23);
		contentPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnTelefono = new JRadioButton("Telefono");
		rdbtnTelefono.setBounds(147, 145, 67, 23);
		contentPanel.add(rdbtnTelefono);
		
		JRadioButton rdbtnInternet = new JRadioButton("Internet");
		rdbtnInternet.setBounds(258, 145, 67, 23);
		contentPanel.add(rdbtnInternet);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 31, 46, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblCrearPlanes = new JLabel("Crear Planes");
		lblCrearPlanes.setBounds(139, 11, 86, 14);
		contentPanel.add(lblCrearPlanes);
		
		JLabel label = new JLabel("");
		label.setBounds(31, 73, 46, 14);
		contentPanel.add(label);
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
