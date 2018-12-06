package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagarFactura extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldPlan;
	private JTextField txtFieldPrecioNeto;
	private JTextField txtFieldPrecioBruto;
	private JTextField txtFieldFechaEmision;
	private JTextField txtCliente;
	private JTextField txtFieldFechaPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagarFactura frame = new PagarFactura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PagarFactura() {
		setTitle("FACTURAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 11, 307, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPlan = new JLabel("Plan");
		lblPlan.setBounds(47, 62, 46, 14);
		panel.add(lblPlan);
		
		txtFieldPlan = new JTextField();
		txtFieldPlan.setBounds(109, 59, 150, 20);
		panel.add(txtFieldPlan);
		txtFieldPlan.setColumns(10);
		
		JLabel lblPrecioNeto = new JLabel("Precio neto");
		lblPrecioNeto.setBounds(47, 87, 70, 20);
		panel.add(lblPrecioNeto);
		
		txtFieldPrecioNeto = new JTextField();
		txtFieldPrecioNeto.setBounds(109, 87, 150, 20);
		panel.add(txtFieldPrecioNeto);
		txtFieldPrecioNeto.setColumns(10);
		
		JLabel lblPrecioBruto = new JLabel("Precio bruto");
		lblPrecioBruto.setBounds(47, 118, 60, 14);
		panel.add(lblPrecioBruto);
		
		txtFieldPrecioBruto = new JTextField();
		txtFieldPrecioBruto.setBounds(109, 115, 150, 20);
		panel.add(txtFieldPrecioBruto);
		txtFieldPrecioBruto.setColumns(10);
		
		JLabel lblFechaDeEmision = new JLabel("Fecha de emision");
		lblFechaDeEmision.setBounds(47, 143, 95, 14);
		panel.add(lblFechaDeEmision);
		
		txtFieldFechaEmision = new JTextField();
		txtFieldFechaEmision.setBounds(135, 140, 124, 20);
		panel.add(txtFieldFechaEmision);
		txtFieldFechaEmision.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(47, 37, 46, 14);
		panel.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtCliente.setBounds(109, 34, 150, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblInformacinDeLa = new JLabel("Informaci\u00F3n de la facura ");
		lblInformacinDeLa.setBounds(10, 12, 212, 14);
		panel.add(lblInformacinDeLa);
		
		JLabel lblFechaDePago = new JLabel("Fecha de pago");
		lblFechaDePago.setBounds(47, 168, 82, 14);
		panel.add(lblFechaDePago);
		
		txtFieldFechaPago = new JTextField();
		txtFieldFechaPago.setColumns(10);
		txtFieldFechaPago.setBounds(135, 168, 124, 20);
		panel.add(txtFieldFechaPago);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPagar.setBounds(323, 227, 89, 23);
		contentPane.add(btnPagar);
	}

}
