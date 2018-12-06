package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import Logico.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Nuevoempleado extends JDialog {
	private JTextField txNombre;
	private JTextField txDireccion;
	private JTextField txCedula;
	private JTextField txTelefono;
	private JTextField txID;
	private JRadioButton rdbtnCom;
	private JPanel pnClasificacion;
	private JRadioButton rdbtnAdm;
	private JLabel lblPregunta;
	private JPanel pnInf;
	private JLabel lbDireccion;
	private JLabel lbNombre;
	private JLabel lbCR;
	private JLabel lbTel;
	private JLabel lbID;
	private JButton btnRegistrar;
	private JPanel panel;
	private JLabel lblUsuario;
	private JTextField txUser;
	private JLabel lblContrasea;
	private JTextField txPass;
	private JLabel lblConfirmarContrasea;
	private JTextField txConfirm;
	private JTextField txtArea;
	private JLabel lblArea;
	private JLabel lbSueldo;
	private JTextField txtSueldo;

	public  Nuevoempleado() {
		setTitle("Nuevo Empleado");
		setBounds(100, 100, 498, 535);
		getContentPane().setLayout(null);
		
		pnClasificacion = new JPanel();
		pnClasificacion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Empleo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnClasificacion.setBounds(27, 189, 430, 113);
		getContentPane().add(pnClasificacion);
		pnClasificacion.setLayout(null);
		
		rdbtnAdm = new JRadioButton("Administrativo");
		rdbtnAdm.setSelected(true);
		rdbtnAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCom.setSelected(false);
				lblArea.setText("Area");
			}
		});
		rdbtnAdm.setBounds(194, 23, 100, 23);
		pnClasificacion.add(rdbtnAdm);
		
		rdbtnCom = new JRadioButton("Comercial");
		rdbtnCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblArea.setText("Puesto");
				rdbtnAdm.setSelected(false);
				
			}
		});
		rdbtnCom.setBounds(296, 23, 109, 23);
		pnClasificacion.add(rdbtnCom);
		
		lblPregunta = new JLabel("\u00BFQue tipo de cliente empleado?");
		lblPregunta.setBounds(10, 27, 178, 14);
		pnClasificacion.add(lblPregunta);
		
		txtArea = new JTextField();
		txtArea.setColumns(10);
		txtArea.setBounds(73, 53, 346, 20);
		pnClasificacion.add(txtArea);
		
		lblArea = new JLabel("Area");
		lblArea.setBounds(10, 56, 53, 14);
		pnClasificacion.add(lblArea);
		
		lbSueldo = new JLabel("Sueldo ");
		lbSueldo.setBounds(10, 87, 53, 14);
		pnClasificacion.add(lbSueldo);
		
		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(73, 84, 346, 20);
		pnClasificacion.add(txtSueldo);
		
		pnInf = new JPanel();
		pnInf.setLayout(null);
		pnInf.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnInf.setBounds(27, 29, 430, 149);
		getContentPane().add(pnInf);
		
		lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(10, 58, 46, 14);
		pnInf.add(lbNombre);
		
		txNombre = new JTextField();
		txNombre.setColumns(10);
		txNombre.setBounds(76, 55, 336, 20);
		pnInf.add(txNombre);
		
		txDireccion = new JTextField();
		txDireccion.setColumns(10);
		txDireccion.setBounds(76, 117, 336, 20);
		pnInf.add(txDireccion);
		
		lbDireccion = new JLabel("Direccion");
		lbDireccion.setBounds(10, 120, 66, 14);
		pnInf.add(lbDireccion);
		
		txCedula = new JTextField();
		txCedula.setColumns(10);
		txCedula.setBounds(76, 86, 134, 20);
		pnInf.add(txCedula);
		
		lbCR = new JLabel("Cedula");
		lbCR.setBounds(10, 89, 46, 14);
		pnInf.add(lbCR);
		
		lbTel = new JLabel("Telefono");
		lbTel.setBounds(217, 89, 53, 14);
		pnInf.add(lbTel);
		
		txTelefono = new JTextField();
		txTelefono.setColumns(10);
		txTelefono.setBounds(268, 86, 144, 20);
		pnInf.add(txTelefono);
		
		txID = new JTextField();
		txID.setEditable(false);
		txID.setColumns(10);
		txID.setBounds(76, 26, 336, 20);
		pnInf.add(txID);
		
		
		lbID = new JLabel("ID");
		lbID.setBounds(10, 29, 46, 14);
		pnInf.add(lbID);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txCedula.getText() == "" || txDireccion.getText() == "" || txNombre.getText() == "" || txTelefono.getText() == ""
						|| txConfirm.getText() == "" || txUser.getText() == "" || txtSueldo.getText() == "" || txPass.getText() == "") {
					JOptionPane.showMessageDialog(null, "No se admiten campos vacios", "ATENCION", JOptionPane.INFORMATION_MESSAGE, null);
				}else {
					int id = Integer.parseInt(txID.getText());
					String nombre = txNombre.getText();
					double ced = Double.parseDouble(txCedula.getText());
					double tel = Double.parseDouble(txTelefono.getText());
					String direccion = txDireccion.getText();
					double sueldo = Double.parseDouble(txtSueldo.getText());
					String area = txtArea.getText();
					String usuario = txUser.getText();
					String clave = null;
					do {
						if(txPass.getText().equals(txConfirm.getText())) {
							clave = txPass.getText();
						}else {
							txPass.setText("");
							txConfirm.setText("");
							JOptionPane.showMessageDialog(null, "Las contraseñas no coindicen", "ATENCION", JOptionPane.INFORMATION_MESSAGE, null);
						}
					}while(clave == null);
					
					
					if(rdbtnAdm.isSelected()&& !rdbtnCom.isSelected()) {
						Administrativo emp = new Administrativo(id, nombre, tel, direccion, sueldo, usuario, clave, area);
						Tricom.getInstance().addEmpleados(emp);
					}else if(rdbtnCom.isSelected() && !rdbtnAdm.isSelected()){
						String nombreemp = txtArea.getText();
						Comercial emp = new Comercial(id, nombre, tel, direccion, sueldo, usuario, clave, area);
						Tricom.getInstance().addEmpleados(emp);
					}
				}
			}
		});
		btnRegistrar.setBounds(125, 433, 97, 40);
		getContentPane().add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(259, 433, 108, 41);
		getContentPane().add(btnCancelar);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Acceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(27, 313, 430, 109);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 24, 46, 14);
		panel.add(lblUsuario);
		
		txUser = new JTextField();
		txUser.setColumns(10);
		txUser.setBounds(76, 21, 336, 20);
		panel.add(txUser);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 52, 78, 14);
		panel.add(lblContrasea);
		
		txPass = new JTextField();
		txPass.setColumns(10);
		txPass.setBounds(76, 49, 336, 20);
		panel.add(txPass);
		
		lblConfirmarContrasea = new JLabel("Confirmar ");
		lblConfirmarContrasea.setBounds(10, 81, 60, 14);
		panel.add(lblConfirmarContrasea);
		
		txConfirm = new JTextField();
		txConfirm.setColumns(10);
		txConfirm.setBounds(76, 78, 336, 20);
		panel.add(txConfirm);
		
	}
	
}
