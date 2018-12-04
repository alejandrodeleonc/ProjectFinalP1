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

public class Registroclientes extends JDialog {
	private static JTable table;
	private JButton btnModificar;
	private static Object[] fila;
	private static String[] columnNames = {"Código","Cédula","Nombre","Dirección","Planes"};
	private static DefaultTableModel modelo;
	private static DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
	private JButton btnEliminar;
	private JButton btnNCliente;
	private JLabel lblListadoDeClientes;
	private int codigo = -1;
	private static Registroclientes registro;

	public static Registroclientes getInstance() {
		if(registro == null) {
			registro = new Registroclientes();
		}
		return registro;
	}
	private Registroclientes(){
		setBounds(100, 100, 825, 436);
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
				NuevoCliente nframe = new NuevoCliente();
				nframe.setModal(true);
				nframe.setVisible(true);
			}
		});
		btnNCliente.setFont(new Font("Century Gothic", Font.BOLD, 12));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		
		lblListadoDeClientes = new JLabel("Listado de clientes ");
		lblListadoDeClientes.setFont(new Font("Century Gothic", Font.BOLD, 22));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 621, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
								.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
								.addComponent(btnNCliente, GroupLayout.PREFERRED_SIZE, 127, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(269)
							.addComponent(lblListadoDeClientes)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addComponent(lblListadoDeClientes)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNCliente, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
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
					fila[4] = cliente.getMisPlanes().size();

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
