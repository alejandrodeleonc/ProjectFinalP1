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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

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
	
		mnClientes.add(mntmAdmPub);
		
		JMenuItem mntmNuevaPublicacion = new JMenuItem("Registro de clientes");
		
		mnClientes.add(mntmNuevaPublicacion);
		
		JMenu mnPrestamos = new JMenu("Empleados");
		menuBar.add(mnPrestamos);
		
		JMenuItem mntmAdministradorDePrestamos = new JMenuItem("Registro de empleados");
		
		mnPrestamos.add(mntmAdministradorDePrestamos);
		
		JMenuItem mntmAdministradorDePrestamos_1 = new JMenuItem("Nuevo empleado");
		
		
	
		mnPrestamos.add(mntmAdministradorDePrestamos_1);
		
		JMenu mnInformacion = new JMenu("Facturacion");		
		menuBar.add(mnInformacion);
		
		JMenuItem mntmPagos = new JMenuItem("Pagos");
		mnInformacion.add(mntmPagos);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		mnInformacion.add(menuItem);
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


