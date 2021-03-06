package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Logico.*;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Facturacion extends JDialog {
	private JPanel contentPane;
	private JTextField txtCliente;
	private JTextField txtFieldNombreRNC;
	private JTextField txtFieldRNC;
	private JRadioButton rdbtnRnc;
	private JRadioButton rdbtnCedula;
	private JPanel Informacion_panel;
	private boolean cedulaOrRnc = true;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JLabel lblTelefono_1;
	private JTextField txtFieldTelefono;
	private JLabel lblDireccion_1;
	private JTextField txtFieldDireccion;
	private JLabel lblFacturasPagadas;
	private JLabel lblRNC ;
	private JButton btnPagar;
	private Cliente c = null;
	private JList<String> list_pago;
	private JList<String> list_deudas;
	private JPanel panel_2;
	private JLabel label;
	private JTextField textField;
	private JLabel label_1;
	private JTextField textField_1;
	private JLabel label_2;
	private JTextField textField_2;
	private JLabel label_3;
	private JTextField textField_3;
	private JLabel label_4;
	private JTextField textField_4;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField textField_5;

	/**
	 * Create the dialog.
	 */

	public Facturacion() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				cargarlistas();
			}
		});
		setResizable(false);
		setTitle("BUSCAR FACTURAS");
		
		setBounds(100, 100, 790, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(47, 11, 458, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rdbtnRnc = new JRadioButton("RNC");
		rdbtnRnc.setSelected(true);
		rdbtnRnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblRNC.setText("RNC");
				rdbtnCedula.setSelected(false);
				cedulaOrRnc = true;
			}
		});
		rdbtnRnc.setBounds(131, 37, 73, 23);
		panel.add(rdbtnRnc);
		
		rdbtnCedula = new JRadioButton("Cedula");
		rdbtnCedula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRNC.setText("Cedula");
				rdbtnRnc.setSelected(false);
				cedulaOrRnc = false;
			}
		});
		rdbtnCedula.setBounds(225, 37, 109, 23);
		panel.add(rdbtnCedula);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(96, 10, 238, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(31, 11, 42, 19);
		panel.add(lblNewLabel);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double codigo = Double.valueOf(txtCliente.getText()); 
				
				Cliente auxcliente = null;
				auxcliente = Tricom.getInstance().buscarporcedulaornc(codigo, cedulaOrRnc);
				c = auxcliente;
				
				if (cedulaOrRnc == true) {
					if (c == null) {
						JOptionPane.showMessageDialog(null, "No se ha encontrado ese RNC, el cliente no existe","Advertencia", JOptionPane.INFORMATION_MESSAGE, null);
					}
					txtFieldNombreRNC.setText(auxcliente.getNombre());
					txtFieldRNC.setText(String.valueOf(((Empresarial)auxcliente).getRnc()));
					
				}
				
				if (cedulaOrRnc == false) {
					if (c == null) {
						JOptionPane.showMessageDialog(null, "No se ha encontrado esa c�dula, el cliente no existe","Advertencia", JOptionPane.INFORMATION_MESSAGE, null);
					}
					txtFieldNombreRNC.setText(auxcliente.getNombre());
					txtFieldRNC.setText(String.valueOf(((Personal)auxcliente).getCedula()));
				}
				txtFieldTelefono.setText(String.valueOf(auxcliente.getTelefono()));
				txtFieldDireccion.setText(auxcliente.getDireccion());
				cargarlistas();
			}
		});
		
		btnBuscar.setBounds(344, 9, 89, 23);
		panel.add(btnBuscar);
		
		Informacion_panel = new JPanel();
		Informacion_panel.setBorder(new LineBorder(new Color(211, 211, 211), 2));
		Informacion_panel.setBounds(47, 82, 458, 143);
		Informacion_panel.setToolTipText("Informacion");
		contentPane.add(Informacion_panel);
		Informacion_panel.setLayout(null);
		
		JLabel lblInformacin = new JLabel("Informaci\u00F3n");
		lblInformacin.setBounds(10, 11, 102, 14);
		Informacion_panel.add(lblInformacin);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 39, 46, 14);
		Informacion_panel.add(lblNombre);
		
		txtFieldNombreRNC = new JTextField();
		txtFieldNombreRNC.setBounds(79, 36, 352, 20);
		Informacion_panel.add(txtFieldNombreRNC);
		txtFieldNombreRNC.setColumns(10);
		
		lblRNC = new JLabel("RNC");
		lblRNC.setBounds(20, 61, 46, 14);
		Informacion_panel.add(lblRNC);
		
		txtFieldRNC = new JTextField();
		txtFieldRNC.setBounds(79, 61, 352, 20);
		Informacion_panel.add(txtFieldRNC);
		txtFieldRNC.setColumns(10);
		
		lblTelefono_1 = new JLabel("Telefono");
		lblTelefono_1.setBounds(20, 89, 46, 14);
		Informacion_panel.add(lblTelefono_1);
		
		txtFieldTelefono = new JTextField();
		txtFieldTelefono.setBounds(79, 86, 352, 20);
		Informacion_panel.add(txtFieldTelefono);
		txtFieldTelefono.setColumns(10);
		
		lblDireccion_1 = new JLabel("Direccion");
		lblDireccion_1.setBounds(20, 114, 46, 14);
		Informacion_panel.add(lblDireccion_1);
		
		txtFieldDireccion = new JTextField();
		txtFieldDireccion.setBounds(79, 111, 352, 20);
		Informacion_panel.add(txtFieldDireccion);
		txtFieldDireccion.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBounds(31, 243, 493, 274);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("          Facturas por pagar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(36, 11, 196, 22);
		panel_1.add(lblNewLabel_1);
		
		lblFacturasPagadas = new JLabel("       Facturas pagadas ");
		lblFacturasPagadas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFacturasPagadas.setForeground(new Color(0, 128, 0));
		lblFacturasPagadas.setBounds(278, 11, 187, 22);
		panel_1.add(lblFacturasPagadas);
		
		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		});
		btnPagar.setBounds(384, 244, 84, 22);
		panel_1.add(btnPagar);
		
		list_deudas = new JList<String>();
		list_deudas.setBounds(36, 236, 168, -190);
		panel_1.add(list_deudas);
		
		list_pago = new JList<String>();
		list_pago.setBounds(288, 220, 155, -174);
		panel_1.add(list_pago);
		
		btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(460, 556, 89, 23);
		contentPane.add(btnNewButton);
		
		panel_2 = new JPanel();
		panel_2.setBounds(541, 243, 493, 274);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		label = new JLabel("Plan");
		label.setBounds(47, 62, 46, 14);
		panel_2.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(109, 59, 150, 20);
		panel_2.add(textField);
		
		label_1 = new JLabel("Precio neto");
		label_1.setBounds(47, 87, 70, 20);
		panel_2.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(109, 87, 150, 20);
		panel_2.add(textField_1);
		
		label_2 = new JLabel("Precio bruto");
		label_2.setBounds(47, 118, 60, 14);
		panel_2.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(109, 115, 150, 20);
		panel_2.add(textField_2);
		
		label_3 = new JLabel("Fecha de emision");
		label_3.setBounds(47, 143, 95, 14);
		panel_2.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(135, 140, 124, 20);
		panel_2.add(textField_3);
		
		label_4 = new JLabel("Cliente");
		label_4.setBounds(47, 37, 46, 14);
		panel_2.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(109, 34, 150, 20);
		panel_2.add(textField_4);
		
		label_5 = new JLabel("Informaci\u00F3n de la facura ");
		label_5.setBounds(10, 12, 212, 14);
		panel_2.add(label_5);
		
		label_6 = new JLabel("Fecha de pago");
		label_6.setBounds(47, 168, 82, 14);
		panel_2.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(135, 168, 124, 20);
		panel_2.add(textField_5);
	}
	private void cargarlistas() {
		if(c != null) {
			DefaultListModel<String> pagas = new DefaultListModel<>();
			DefaultListModel<String> deuda = new DefaultListModel<>();
			for (Factura fac : c.getMisFacturas()) {
				if(fac.isEstado()) {
					pagas.addElement(fac.getFechaEmision().toString());
				}else {
					deuda.addElement(fac.getFechaEmision().toString());
					}
				}
			list_deudas.setModel(deuda);
			list_pago.setModel(pagas);
			
			}
		}
	
	}

