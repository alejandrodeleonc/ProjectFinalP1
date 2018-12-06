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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NuevoCliente extends JDialog {
	private JTextField txNombre;
	private JTextField txDireccion;
	private JTextField txCR;
	private JTextField txRNC;
	private JTextField txID;
	private JRadioButton rdbtnEmpresarial;
	private JPanel pnClasificacion;
	private JRadioButton rdbtnPersonal;
	private JLabel lblPregunta;
	private JPanel pnInf;
	private JLabel lbDireccion;
	private JLabel lbNombre;
	private JLabel lbCR;
	private JLabel lbTel;
	private JLabel lbID;
	private JButton btnRegistrar;
	private JLabel lblNombreEmpresa;
	private JTextField textField;

	public  NuevoCliente(final Cliente c) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if(c != null) {
					setTitle("Modificar Cliente");
					llenar(c);
				}else {
					setTitle("Nuevo Cliente");
				}
			}
		});
		
		
		
		setBounds(100, 100, 525, 399);
		getContentPane().setLayout(null);
		
		pnClasificacion = new JPanel();
		pnClasificacion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Clasificaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnClasificacion.setBounds(38, 32, 430, 64);
		getContentPane().add(pnClasificacion);
		pnClasificacion.setLayout(null);
		
		rdbtnPersonal = new JRadioButton("Personal");
		rdbtnPersonal.setSelected(true);
		rdbtnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnEmpresarial.setSelected(false);
				textField.setEditable(false);
				lblNombreEmpresa.setEnabled(false);
				lbCR.setText("Cedula ");
			}
		});
		rdbtnPersonal.setBounds(174, 23, 78, 23);
		pnClasificacion.add(rdbtnPersonal);
		
		rdbtnEmpresarial = new JRadioButton("Empresarial");
		rdbtnEmpresarial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEditable(true);
				lblNombreEmpresa.setEnabled(true);
				rdbtnPersonal.setSelected(false);
				lbCR.setText("RNC");
			}
		});
		rdbtnEmpresarial.setBounds(276, 23, 109, 23);
		pnClasificacion.add(rdbtnEmpresarial);
		
		lblPregunta = new JLabel("\u00BFQue tipo de cliente es?");
		lblPregunta.setBounds(10, 27, 141, 14);
		pnClasificacion.add(lblPregunta);
		
		pnInf = new JPanel();
		pnInf.setLayout(null);
		pnInf.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnInf.setBounds(38, 107, 430, 180);
		getContentPane().add(pnInf);
		
		lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(10, 58, 46, 14);
		pnInf.add(lbNombre);
		
		txNombre = new JTextField();
		txNombre.setColumns(10);
		txNombre.setBounds(66, 55, 346, 20);
		pnInf.add(txNombre);
		
		txDireccion = new JTextField();
		txDireccion.setColumns(10);
		txDireccion.setBounds(66, 117, 346, 20);
		pnInf.add(txDireccion);
		
		lbDireccion = new JLabel("Direccion");
		lbDireccion.setBounds(10, 120, 53, 14);
		pnInf.add(lbDireccion);
		
		txCR = new JTextField();
		txCR.setColumns(10);
		txCR.setBounds(66, 86, 144, 20);
		pnInf.add(txCR);
		
		lbCR = new JLabel("Cedula");
		lbCR.setBounds(10, 89, 46, 14);
		pnInf.add(lbCR);
		
		lbTel = new JLabel("Telefono");
		lbTel.setBounds(220, 86, 53, 14);
		pnInf.add(lbTel);
		
		txRNC = new JTextField();
		txRNC.setColumns(10);
		txRNC.setBounds(268, 86, 144, 20);
		pnInf.add(txRNC);
		
		txID = new JTextField();
		txID.setEditable(false);
		txID.setColumns(10);
		txID.setBounds(66, 26, 346, 20);
		txID.setText(String.valueOf(Tricom.getInstance().getMisClientes().size()+1));
		pnInf.add(txID);
		
		
		lbID = new JLabel("ID");
		lbID.setBounds(10, 29, 46, 14);
		pnInf.add(lbID);
		
		lblNombreEmpresa = new JLabel("Nombre Empresa");
		lblNombreEmpresa.setEnabled(false);
		lblNombreEmpresa.setBounds(10, 152, 101, 14);
		pnInf.add(lblNombreEmpresa);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(121, 148, 291, 20);
		pnInf.add(textField);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txCR.getText() == "" || txDireccion.getText() == "" || txNombre.getText() == "" || txRNC.getText() == "" ) {
					JOptionPane.showMessageDialog(null, "No se admiten campos vacios", "ATENCION", JOptionPane.INFORMATION_MESSAGE, null);
				}else {
					int id = Integer.parseInt(txID.getText());
					String nombre = txNombre.getText();
					double ced = Double.parseDouble(txCR.getText());
					double tel = Double.parseDouble(txRNC.getText());
					String direccion = txDireccion.getText();
					if(rdbtnPersonal.isSelected()&& !rdbtnEmpresarial.isSelected()) {
						Personal cliente = new Personal(id, nombre, tel, direccion, ced);
						Tricom.getInstance().addClientes(cliente);
					}else if(rdbtnEmpresarial.isSelected() && !rdbtnPersonal.isSelected()){
						String nombreemp = textField.getText();
						Empresarial cliente = new Empresarial(id, nombre, tel, direccion, nombreemp, ced);
						Tricom.getInstance().addClientes(cliente);
					}
					JOptionPane.showMessageDialog(null, "Ciente se ha creado exisitosamente", "ATENCION", JOptionPane.INFORMATION_MESSAGE, null);
					clean();
				}
			}
		});
		btnRegistrar.setBounds(129, 298, 97, 40);
		getContentPane().add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(257, 298, 108, 41);
		getContentPane().add(btnCancelar);
	}
	
	public void clean() {
		textField.setText("");
		txDireccion.setText("");
		txCR.setText("");
		txID.setText("");
		txNombre.setText("");
		txRNC.setText("");
	}
	
	public void llenar(Cliente c) {
		if(c instanceof Empresarial) {
			textField.setEditable(true);
			textField.setText(((Empresarial) c).getNombreEmpresa());
			lbCR.setText("RNC");
			txCR.setText(String.valueOf(((Empresarial)c).getRnc()));
			rdbtnEmpresarial.setSelected(true);
			rdbtnPersonal.setSelected(false);
		}else {
			textField.setEditable(false);
			lbCR.setText("Cedula");
			txCR.setText(String.valueOf(((Personal)c).getCedula()));
			rdbtnEmpresarial.setSelected(false);
			rdbtnPersonal.setSelected(true);
		}
		
		txDireccion.setText(c.getDireccion());
		txID.setText(String.valueOf(c.getCodigo()));
		txNombre.setText(c.getNombre());
		txRNC.setText(String.valueOf(c.getTelefono()));
	}
	
}
