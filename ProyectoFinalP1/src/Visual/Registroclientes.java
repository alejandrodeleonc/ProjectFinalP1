package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import Logico.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;

public class Registroclientes extends JDialog {
	private static JTable table;
	private JButton btnModificar;
	private static Object[] fila;
	private static String[] columnNames = {"Código","Cédula/RNC","Nombre","Dirección", "Estado","Planes"};
	private static DefaultTableModel modelo;
	private static DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
	private JButton btnEliminar;
	private JButton btnNCliente;
	private int codigo = -1;
	private static Registroclientes registro;
	private JPanel panel;
	private JTextField textField;
	private JButton btnBuscar;
	private JLabel lblResultado;
	private JLabel lblListadoDeClientes;

	public static Registroclientes getInstance() {
		if(registro == null) {
			registro = new Registroclientes();
		}
		return registro;
	}
	private Registroclientes(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				cargar();
			}
		});
		setBounds(100, 100, 928, 487);
		setTitle("Registro de clientes");
		setLocationRelativeTo(null);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		});
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int aux = table.getSelectedRow();	
				
				if(aux > -1){
					btnModificar.setEnabled(true);	
					btnEliminar.setEnabled(true);						
					
					codigo = (int) table.getModel().getValueAt(aux, 0);

				}else{
					btnModificar.setEnabled(false);	
					btnEliminar.setEnabled(false);
					codigo = -1;
					
				}
			}
			});
		modelo = new DefaultTableModel();
		cargar();
		table.setModel(modelo);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		btnNCliente = new JButton("Nuevo cliente");
		btnNCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoCliente nframe = new NuevoCliente(null);
				nframe.setLocationRelativeTo(null);
				nframe.setModal(true);
				nframe.setVisible(true);
			}
		});
		btnNCliente.setFont(new Font("Century Gothic", Font.BOLD, 12));
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente p = Tricom.getInstance().buscarclienteporcodigo(codigo);
				NuevoCliente o = new NuevoCliente(p);
				o.setLocationRelativeTo(null);
				o.setModal(true);
				o.setVisible(true);
			}
		});
		btnModificar.setEnabled(false);
		btnModificar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buscador por cedula", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblListadoDeClientes = new JLabel("Listado de Clientes");
		lblListadoDeClientes.setFont(new Font("Century Gothic", Font.BOLD, 26));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNCliente, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(283)
							.addComponent(lblListadoDeClientes))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(117)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblListadoDeClientes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNCliente, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				cargar();
				lblResultado.setText("");
			}
		});
		
		textField.setBounds(21, 18, 395, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente p = Tricom.getInstance().buscarporcedulaornc(Double.parseDouble(textField.getText()), false);
				if(p == null) {
					lblResultado.setText("No hay resultados de busqueda");
				}else {
					modelo.setColumnIdentifiers(columnNames);	
					modelo.setRowCount(0);
					fila = new Object[modelo.getColumnCount()];		
					
					

							fila[0] = p.getCodigo();
							if(p instanceof Personal) {
								fila[1] = ((Personal)p).getCedula();
							}else {
								fila[1] = ((Empresarial)p).getRnc();
							}
							fila[2] = p.getNombre();
							fila[3] = p.getDireccion();
							if(p.getEstado()) {
								fila[4] = "Activo";
							}else {
								fila[4] = "Inactivo";
							}
							fila[5] = p.getMisPlanes().size();
							

						modelo.addRow(fila);
						
						table.setModel(modelo);		
						table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						table.getTableHeader().setReorderingAllowed(false);
						TableColumnModel columnModel = table.getColumnModel();	
						centrar.setHorizontalAlignment(SwingConstants.CENTER); 
						
						for (int i = 0; i < columnNames.length; i++) {
							table.getColumnModel().getColumn(i).setCellRenderer(centrar);
						}		
						columnModel.getColumn(0).setPreferredWidth(50);
						columnModel.getColumn(1).setPreferredWidth(93);
						columnModel.getColumn(2).setPreferredWidth(200);
						columnModel.getColumn(3).setPreferredWidth(200);
						columnModel.getColumn(4).setPreferredWidth(80);
						
				}
							}
		});
		btnBuscar.setBounds(427, 17, 89, 23);
		panel.add(btnBuscar);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(45, 39, 385, 14);
		panel.add(lblResultado);
		getContentPane().setLayout(groupLayout);}
		
		public static void  cargar() {
			modelo.setColumnIdentifiers(columnNames);	
			modelo.setRowCount(0);
			fila = new Object[modelo.getColumnCount()];		
			
			for (Cliente cliente : Tricom.getInstance().getMisClientes()) {	

					fila[0] = cliente.getCodigo();
					if(cliente instanceof Personal) {
						fila[1] = ((Personal)cliente).getCedula();
					}else {
						fila[1] = ((Empresarial)cliente).getRnc();
					}
					fila[2] = cliente.getNombre();
					fila[3] = cliente.getDireccion();
					if(cliente.getEstado()) {
						fila[4] = "Activo";
					}else {
						fila[4] = "Inactivo";
					}
					fila[5] = cliente.getMisPlanes().size();
					

				modelo.addRow(fila);
					
				}	
				
				table.setModel(modelo);		
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getTableHeader().setReorderingAllowed(false);
				TableColumnModel columnModel = table.getColumnModel();	
				centrar.setHorizontalAlignment(SwingConstants.CENTER); 
				
				for (int i = 0; i < columnNames.length; i++) {
					table.getColumnModel().getColumn(i).setCellRenderer(centrar);
				}		
				columnModel.getColumn(0).setPreferredWidth(50);
				columnModel.getColumn(1).setPreferredWidth(93);
				columnModel.getColumn(2).setPreferredWidth(200);
				columnModel.getColumn(3).setPreferredWidth(200);
				columnModel.getColumn(4).setPreferredWidth(80);
				
			}	
}
