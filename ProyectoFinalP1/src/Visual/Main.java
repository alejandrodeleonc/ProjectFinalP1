package Visual;


import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import Logico.Cliente;
import Logico.Tricom;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main  {

	private static final int MAXIMIZED_BOTH = 0;
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
					//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Tricom.getInstance().guardar();
			}
			@Override
			public void windowOpened(WindowEvent e) {
				Tricom.getInstance().cargardatos();
			}
		});

		
		frame.setResizable(false);
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		frame.setSize(ancho, alto-35);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");

		menuBar.add(mnClientes);
		
		JMenuItem mntmAdmPub = new JMenuItem("Nuevo cliente");
		mntmAdmPub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoCliente o = new NuevoCliente();
				o.setModal(true);
				o.setLocationRelativeTo(null);
				o.setVisible(true);
				
			}
		});
	
	
		mnClientes.add(mntmAdmPub);
		
		JMenuItem mntmNuevaPublicacion = new JMenuItem("Registro de clientes");
		mntmNuevaPublicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registroclientes.getInstance().setModal(true);
				Registroclientes.getInstance().setLocationRelativeTo(null);
				Registroclientes.getInstance().setVisible(true);
			}
		});
		
		mnClientes.add(mntmNuevaPublicacion);
		
		JMenu mnPrestamos = new JMenu("Empleados");
		menuBar.add(mnPrestamos);
		
		JMenuItem mntmAdministradorDePrestamos = new JMenuItem("Registro de empleados");
		
		mnPrestamos.add(mntmAdministradorDePrestamos);
		
		JMenuItem mntmAdministradorDePrestamos_1 = new JMenuItem("Nuevo empleado");
		
		
	
		mnPrestamos.add(mntmAdministradorDePrestamos_1);
		
		JMenu mnInformacion = new JMenu("Facturacion");		
		menuBar.add(mnInformacion);
		
		JMenuItem mntmPagos = new JMenuItem("Ver facturas cliente");
		mntmPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturacion o = new Facturacion();
				o.setLocationRelativeTo(null);
				o.setVisible(true);
			}
		});
		mnInformacion.add(mntmPagos);
		
		JMenuItem mntmGenerarFactura = new JMenuItem("Generar Factura");
		mntmGenerarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tricom.getInstance().ge
			}
		});
	
		mnInformacion.add(mntmGenerarFactura);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}


