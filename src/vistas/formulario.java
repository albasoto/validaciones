package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import controladores.ControladorBodega;
import controladores.ControladorContacto;
import controladores.ControladorCuentaxCobrar;
import controladores.ControladorCuentaxPagar;
import controladores.ControladorParqueadero;
import controladores.ControladorProveedor;
import controladores.ControladorUnidad;
import controladores.ProcesadorArchivos;
import entidades.Contacto;
import entidades.CuentaPorCobrar;
import entidades.CuentaPorPagar;
import entidades.ParqueaderoBodega;
import entidades.Proveedor;
import entidades.UnidadHabitacional;
import validadores.ValidadorContacto;
import validadores.ValidadorCuentasPorCobrar;
import validadores.ValidadorCuentasPorPagar;
import validadores.ValidadorParqueaderoBodega;
import validadores.ValidadorProveedor;
import validadores.ValidadorUnidad;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Color;

public class formulario {

	private String unidad, oid;

	private JFrame frame;
	private JTextField txtUnidad;
	private JTextField txtOid;
	JTextPane txtLog = new JTextPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formulario window = new formulario();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public formulario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.PINK);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Desktop\\ico.png"));
		frame.setBounds(100, 100, 736, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos iniciales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 720, 49);
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblUnidadHabitacional = new JLabel(" U. habitacional ");
		panel.add(lblUnidadHabitacional);

		txtUnidad = new JTextField();
		panel.add(txtUnidad);
		txtUnidad.setColumns(10);

		JLabel lblNewLabel = new JLabel("  OID ");
		panel.add(lblNewLabel);

		txtOid = new JTextField();
		panel.add(txtOid);
		txtOid.setColumns(10);

		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		JButton btnAbrirArchivo = new JButton("Abrir archivo");

		btnAbrirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesar();

			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String unidadObtenida = txtUnidad.getText().trim().toLowerCase();
				String oidObtenido = txtOid.getText().trim().toLowerCase();

				if (unidadObtenida.equals("")) {
					JOptionPane.showMessageDialog(null, "Unidad es requerido");
				} else if (oidObtenido.equals("")) {
					JOptionPane.showMessageDialog(null, "OID es requerido");
				} else if (unidadObtenida.length() < 2) {
					JOptionPane.showMessageDialog(null, "La unidad al menos debe de tener 2 caracteres");
				} else if (unidadObtenida.length() > 2) {
					JOptionPane.showMessageDialog(null, "La unidad debe de tener un máximo de 2 caracteres");
				} else {
					unidad = unidadObtenida;
					oid = oidObtenido;
					JOptionPane.showMessageDialog(null, "Se guardo los datos satisfactoriamente");
					btnAbrirArchivo.setEnabled(true);
				}

			}
		});
		panel.add(btnNewButton);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtLog.setText(null);
				txtOid.setText(null);
				txtUnidad.setText(null);

			}
		});
		panel.add(btnLimpiar);

		btnAbrirArchivo.setEnabled(false);
		btnAbrirArchivo.setBounds(0, 60, 720, 23);
		frame.getContentPane().add(btnAbrirArchivo);
		txtLog.setBackground(Color.WHITE);

		txtLog.setEditable(false);
		txtLog.setBounds(0, 80, 720, 346);
		frame.getContentPane().add(txtLog);
	}

	public void procesar() {
		ProcesadorArchivos procesador = new ProcesadorArchivos();
		ControladorUnidad procesadorUnidad = new ControladorUnidad();
		ControladorContacto procesadorContacto = new ControladorContacto();
		ControladorParqueadero procesadorParqueadero = new ControladorParqueadero();
		ControladorCuentaxCobrar procesadorCobrar = new ControladorCuentaxCobrar();
		ControladorProveedor procesadorProveedor = new ControladorProveedor();
		ControladorCuentaxPagar procesadorPagar = new ControladorCuentaxPagar();
		ControladorBodega procesadorBodega = new ControladorBodega();

		ValidadorUnidad validaUnidad = new ValidadorUnidad();
		ValidadorProveedor validaProveedor = new ValidadorProveedor();
		ValidadorContacto validaContacto = new ValidadorContacto();
		ValidadorCuentasPorCobrar validaCobro = new ValidadorCuentasPorCobrar();
		ValidadorCuentasPorPagar validaPaga = new ValidadorCuentasPorPagar();
		ValidadorParqueaderoBodega validaParqueadero = new ValidadorParqueaderoBodega();

		File archivo = procesador.abrirArchivo("Excel", "xlsx");

		txtLog.setText(txtLog.getText() + "\n" + "Archivo seleccionada: " + archivo.getAbsolutePath());

		String ruta = archivo.getAbsolutePath();

		XSSFWorkbook excel = procesador.leerExcel(ruta);
		txtLog.setText(txtLog.getText() + "\n" + "Hojas por procesar: " + excel.getNumberOfSheets());

		List<Contacto> contactos = procesadorContacto.extraerContacto(excel);
		List<UnidadHabitacional> unidades = procesadorUnidad.extraerUnidades(excel);
		List<Proveedor> proveedor = procesadorProveedor.extraerProveedor(excel);
		List<CuentaPorCobrar> cuentaxCobrar = procesadorCobrar.extraerCuentaCobrar(excel);
		List<CuentaPorPagar> cuentaxPagar = procesadorPagar.extraerCuentaPagar(excel);
		List<ParqueaderoBodega> parqueaderos = procesadorParqueadero.extraerParqueadero(excel);
		List<ParqueaderoBodega> bodega = procesadorBodega.extraerBodega(excel);

		for (UnidadHabitacional unidad : unidades) {
			String mensajesValidacion = validaUnidad.validarUnidad(unidad, unidades);
			if (mensajesValidacion != "") {
				unidad.setMensaje(mensajesValidacion);
			}
		}

		for (Contacto contacto : contactos) {

			Contacto contactoGenerado = validaContacto.crearIdentificacion(contacto, unidad, oid);

			if (contactoGenerado != null) {
				contacto = contactoGenerado;
			}
		}

		for (Contacto contacto : contactos) {
			String mensajesValidacion = validaContacto.validarContacto(contacto, contactos, unidades);
			if (mensajesValidacion != "") {
				contacto.setMensaje(contacto.getMensaje().toString() + mensajesValidacion);
			}
		}
		for (CuentaPorCobrar cobro : cuentaxCobrar) {
			String mensajesValidacion = validaCobro.validarCuentasPorCobrar(cobro, cuentaxCobrar, unidades);
			if (mensajesValidacion != "") {
				cobro.setMensaje(mensajesValidacion);
			}
		}

		for (ParqueaderoBodega parquedero : parqueaderos) {
			String mensajesValidacion = validaParqueadero.validarParquedero(parquedero, parqueaderos, unidades);
			if (mensajesValidacion != "") {
				parquedero.setMensaje(mensajesValidacion);
			}
		}

		for (Proveedor proveedores : proveedor) {
			String mensajesValidacion = validaProveedor.validarProveedor(proveedores, proveedor);
			if (mensajesValidacion != "") {
				proveedores.setMensaje(mensajesValidacion);
			}
		}
		for (CuentaPorPagar cuentasXpagar : cuentaxPagar) {
			String mensajesValidacion = validaPaga.validarCuentasPorPagar(cuentasXpagar, cuentaxPagar, proveedor);
			if (mensajesValidacion != "") {
				cuentasXpagar.setMensaje(mensajesValidacion);
			}
		}

		for (ParqueaderoBodega bodegas : bodega) {
			String mensajesValidacion = validaParqueadero.validarBodega(bodegas, bodega, unidades);
			if (mensajesValidacion != "") {
				bodegas.setMensaje(mensajesValidacion);
			}
		}
		procesador.crearArchivo(unidades, contactos, cuentaxCobrar, parqueaderos, proveedor, cuentaxPagar);

	}
}
