package controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.Contacto;
import entidades.CuentaPorCobrar;
import entidades.CuentaPorPagar;
import entidades.ParqueaderoBodega;
import entidades.Proveedor;
import entidades.UnidadHabitacional;

public class ProcesadorArchivos {

	/**
	 * @param nombreTipo
	 * @param extension
	 * @return
	 */
	public File abrirArchivo(String nombreTipo, String extension) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(nombreTipo, extension);
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		}
		return null;
	}

	/**
	 * Lee el archivo excel desde la ruta seleccionada
	 * 
	 * @param rutaArchivo
	 * @return
	 */
	public XSSFWorkbook leerExcel(String rutaArchivo) {
		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
			XSSFWorkbook archivoExcel = new XSSFWorkbook(file);

			return archivoExcel;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public void crearArchivo(List<UnidadHabitacional> unidades, List<Contacto> contactos,
			List<CuentaPorCobrar> cuentaxCobrar, List<ParqueaderoBodega> parqueaderoBodega, List<Proveedor> proveedor,
			List<CuentaPorPagar> cuentaxPagar
			
			
			) {
		String nombreArchivo = "pruebaSalida544545.xlsx";
		String rutaArchivo = "C:\\Users\\Wendy Soto\\Documents\\Albi\\" + nombreArchivo;
		String hoja = "1.Unidades-Contactos";
		String hojaParquederoBodega = "2.Parqueaderos-Bodegas";
		String hojaCuentaXCobrar = "3.Cuentas x Cobrar";
		String hojaProveedor = "4.Proveedores";
		String hojaCuentaxPagar = "5.Cuentas x Pagar";
		String hojaBodega = "bodega";

		XSSFWorkbook libro = new XSSFWorkbook();
		XSSFSheet hoja1 = libro.createSheet(hoja);
		XSSFSheet hojaparqueadero = libro.createSheet(hojaParquederoBodega);
		XSSFSheet hojacobro = libro.createSheet(hojaCuentaXCobrar);
		XSSFSheet hojaproveedor = libro.createSheet(hojaProveedor);
		XSSFSheet hojapaga = libro.createSheet(hojaCuentaxPagar);
		
		XSSFSheet bodega = libro.createSheet(hojaBodega);
		
		String [] headerBodega= new String[]{
			"uno","dos", "tres", "cuatro"
		};
		// cabecera de la hoja de excel
		String[] header = new String[] { "Tipo", "ID", "Area Metros Cuadrados", "Porcentaje Alicuota",
				"Valor Expensa *", "Valor Seguro", "Ubicación", "Teléfono", "Esta Arrendada *", "Esta Ocupada *",
				"Observaciones", "ID Unidad", "CI/RUC", "Relación", "Nombre *", "	Apellido *", "Correo Electrónico",
				"Correo Electrónico 2", "Celular", "Teléfono", "Vive en Unidad H", "Representante ", "Observaciones" };

		String[] headerCuentaxCobrar = new String[] { "ID Unidad Habitacional *", "Rubro *", "Fecha emisión *",
				"Fecha Vencimiento *", "Nro. Documento","Detalle *", "Valor *", "Modo *", "Observaciones" };

		String[] headerParquedero = new String[] { "ID Unidad Habitacional *", "Identificación *", "Esta Arrendada",
				"Ubicación", "Observaciones" };

		String[] headerProveedor = new String[] { "RUC/CI/Pasaporte *", "Razón Social *", "Correo electrónico",
				"Teléfono oficina *", "Nombre representante *", "Apellido representante *",
				"Correo electrónico representante", "Teléfono representante", "Dirección", "Observaciones" };

		String[] headerCuentaxPagar = new String[] { "RUC/CI/Pasaporte PROVEEDOR *", "Rubro *", "Fecha de Factura *",
				"Fecha de Vencimiento *", "Número de Factura *", "Detalle *", "Valor *", "Observaciones" };
		// poner negrita a la cabecera
		CellStyle style = libro.createCellStyle();
		Font font = libro.createFont();
		font.setBold(true);
		style.setFont(font);
	/*	for (int i = 0; i < bodegas.size() + 1; i++) {
			XSSFRow row = bodega.createRow(i);// se crea las filas

			if (i == 0) {// para la cabecera
				for (int j = 0; j < headerBodega.length; j++) {
					XSSFCell cell = row.createCell(j);// se crea las celdas para la cabecera, junto con la posiciï¿½n
					cell.setCellStyle(style); // se aï¿½ade el style crea anteriormente
					cell.setCellValue(headerBodega[j]);// se aï¿½ade el contenido
				}
			} else {
				XSSFCell cellUnidad = row.createCell(6);
				cellUnidad.setCellValue(bodegas.get(i - 1).getUnidadHabitacional().getId());

				XSSFCell cellIdentificacion = row.createCell(7);
				cellIdentificacion.setCellValue(bodegas.get(i - 1).getId());

				XSSFCell cellEstaArrendada = row.createCell(8);
				cellEstaArrendada.setCellValue(bodegas.get(i - 1).getEstaArrendada());

				XSSFCell cellUbicacion = row.createCell(9);
				cellUbicacion.setCellValue(bodegas.get(i - 1).getUbicacion());

				XSSFCell cellMensaje = row.createCell(10);
				cellMensaje.setCellValue(bodegas.get(i - 1).getMensaje());
				CellStyle cs = libro.createCellStyle();
				cs.setWrapText(true);
				cellMensaje.setCellStyle(cs);
				row.setHeightInPoints((2 * hoja1.getDefaultRowHeightInPoints()));
				bodega.autoSizeColumn(2);
			}
		}*/
		
		for (int i = 0; i < parqueaderoBodega.size() + 1; i++) {
			XSSFRow row = hojaparqueadero.createRow(i);// se crea las filas

			if (i == 0) {// para la cabecera
				for (int j = 0; j < headerParquedero.length; j++) {
					XSSFCell cell = row.createCell(j);// se crea las celdas para la cabecera, junto con la posiciï¿½n
					cell.setCellStyle(style); // se aï¿½ade el style crea anteriormente
					cell.setCellValue(headerParquedero[j]);// se aï¿½ade el contenido
				}
			} else {
				XSSFCell cellUnidad = row.createCell(0);
				cellUnidad.setCellValue(parqueaderoBodega.get(i - 1).getUnidadHabitacional().getId());

				XSSFCell cellIdentificacion = row.createCell(1);
				cellIdentificacion.setCellValue(parqueaderoBodega.get(i - 1).getId());

				XSSFCell cellEstaArrendada = row.createCell(2);
				cellEstaArrendada.setCellValue(parqueaderoBodega.get(i - 1).getEstaArrendada());

				XSSFCell cellUbicacion = row.createCell(3);
				cellUbicacion.setCellValue(parqueaderoBodega.get(i - 1).getUbicacion());

				XSSFCell cellMensaje = row.createCell(4);
				cellMensaje.setCellValue(parqueaderoBodega.get(i - 1).getMensaje());
				CellStyle cs = libro.createCellStyle();
				cs.setWrapText(true);
				cellMensaje.setCellStyle(cs);
				row.setHeightInPoints((2 * hoja1.getDefaultRowHeightInPoints()));
				hojaparqueadero.autoSizeColumn(2);
			}
		}
		
		

		if (unidades.size() >= contactos.size()) {

			for (int i = 0; i < unidades.size() + 1; i++) {
				XSSFRow row = hoja1.createRow(i);// se crea las filas

				if (i == 0) {// para la cabecera
					for (int j = 0; j < header.length; j++) {
						XSSFCell cell = row.createCell(j);// se crea las celdas para la cabecera, junto con la
						// posiciï¿½n
						cell.setCellStyle(style); // se aï¿½ade el style crea anteriormente
						cell.setCellValue(header[j]);// se aï¿½ade el contenido
					}
				} else {

					if (contactos.size() >= i) {

						XSSFCell cellUnidad = row.createCell(11);
						cellUnidad.setCellValue(contactos.get(i - 1).getUnidadHabitacional().getId());

						XSSFCell cellIdentificacion = row.createCell(12);
						cellIdentificacion.setCellValue(contactos.get(i - 1).getIdentificacion());

						XSSFCell cellRelacion = row.createCell(13);
						cellRelacion.setCellValue(contactos.get(i - 1).getRelacion());

						XSSFCell cellNombre = row.createCell(14);
						cellNombre.setCellValue(contactos.get(i - 1).getNombre());

						XSSFCell cellApellido = row.createCell(15);
						cellApellido.setCellValue(contactos.get(i - 1).getApellido());

						XSSFCell cellCorreo = row.createCell(16);
						cellCorreo.setCellValue(contactos.get(i - 1).getEmal1());

						XSSFCell cellCorreo2 = row.createCell(17);
						cellCorreo2.setCellValue(contactos.get(i - 1).getEmail2());

						XSSFCell cellCelular = row.createCell(18);
						cellCelular.setCellValue(contactos.get(i - 1).getCelular());

						XSSFCell cellTelefono = row.createCell(19);
						cellTelefono.setCellValue(contactos.get(i - 1).getTelefono());

						XSSFCell cellViveEnLaUnidad = row.createCell(20);
						cellViveEnLaUnidad.setCellValue(contactos.get(i - 1).getViveEnUnidad());

						XSSFCell cellRepresentante = row.createCell(21);
						cellRepresentante.setCellValue(contactos.get(i - 1).getEsRepresentante());

						XSSFCell cellMensaje = row.createCell(22);
						cellMensaje.setCellValue(contactos.get(i - 1).getMensaje());

						CellStyle cs = libro.createCellStyle();
						cs.setWrapText(true);
						cellMensaje.setCellStyle(cs);
						row.setHeightInPoints((2 * hoja1.getDefaultRowHeightInPoints()));
						hoja1.autoSizeColumn(2);

					}

					XSSFCell cellTipo = row.createCell(0);
					cellTipo.setCellValue(unidades.get(i - 1).getTipo());

					XSSFCell cellId = row.createCell(1);
					cellId.setCellValue(unidades.get(i - 1).getId());

					XSSFCell cellArea = row.createCell(2);
					cellArea.setCellValue(unidades.get(i - 1).getArea());

					XSSFCell cellAlicuota = row.createCell(3);

					cellAlicuota.setCellValue(unidades.get(i - 1).getArea());

					XSSFCell cellValorExpensa = row.createCell(4);
					cellValorExpensa.setCellValue(unidades.get(i - 1).getValorExpensa());

					XSSFCell cellValorSeguro = row.createCell(5);
					cellValorSeguro.setCellValue(unidades.get(i - 1).getValorSeguro());

					XSSFCell cellUbicacion = row.createCell(6);
					cellUbicacion.setCellValue(unidades.get(i - 1).getUbicacion());

					XSSFCell cellTelefono = row.createCell(7);
					cellTelefono.setCellValue(unidades.get(i - 1).getTefono());

					XSSFCell cellEstaArrendada = row.createCell(8);
					cellEstaArrendada.setCellValue(unidades.get(i - 1).getEstaArrendado());

					XSSFCell cellEstaOcupada = row.createCell(9);
					cellEstaOcupada.setCellValue(unidades.get(i - 1).getEstaOcupado());

					XSSFCell cellMensaje = row.createCell(10);
					cellMensaje.setCellValue(unidades.get(i - 1).getMensaje());
					CellStyle cs = libro.createCellStyle();
					cs.setWrapText(true);
					cellMensaje.setCellStyle(cs);
					row.setHeightInPoints((2 * hoja1.getDefaultRowHeightInPoints()));
					hoja1.autoSizeColumn(2);
				}
			}

		} else {

			for (int i = 0; i < contactos.size() + 1; i++) {
				XSSFRow row = hoja1.createRow(i);

				if (i == 0) {
					for (int j = 0; j < header.length; j++) {
						XSSFCell cell = row.createCell(j);
						cell.setCellStyle(style);
						cell.setCellValue(header[j]);
					}
				} else {

					if (unidades.size() >= i) {
						XSSFCell cellTipo = row.createCell(0);
						cellTipo.setCellValue(unidades.get(i - 1).getTipo());

						XSSFCell cellId = row.createCell(1);
						cellId.setCellValue(unidades.get(i - 1).getId());

						XSSFCell cellArea = row.createCell(2);
						cellArea.setCellValue(unidades.get(i - 1).getArea());

						XSSFCell cellAlicuota = row.createCell(3);

						cellAlicuota.setCellValue(unidades.get(i - 1).getArea());

						XSSFCell cellValorExpensa = row.createCell(4);
						cellValorExpensa.setCellValue(unidades.get(i - 1).getValorExpensa());

						XSSFCell cellValorSeguro = row.createCell(5);
						cellValorSeguro.setCellValue(unidades.get(i - 1).getValorSeguro());

						XSSFCell cellUbicacion = row.createCell(6);
						cellUbicacion.setCellValue(unidades.get(i - 1).getUbicacion());

						XSSFCell cellTelefono = row.createCell(7);
						cellTelefono.setCellValue(unidades.get(i - 1).getTefono());

						XSSFCell cellEstaArrendada = row.createCell(8);
						cellEstaArrendada.setCellValue(unidades.get(i - 1).getEstaArrendado());

						XSSFCell cellEstaOcupada = row.createCell(9);
						cellEstaOcupada.setCellValue(unidades.get(i - 1).getEstaOcupado());

						XSSFCell cellMensaje = row.createCell(10);
						cellMensaje.setCellValue(unidades.get(i - 1).getMensaje());
						CellStyle cs = libro.createCellStyle();
						cs.setWrapText(true);
						cellMensaje.setCellStyle(cs);
						row.setHeightInPoints((2 * hoja1.getDefaultRowHeightInPoints()));
						hoja1.autoSizeColumn(2);

					}

					XSSFCell cellUnidad = row.createCell(11);
					cellUnidad.setCellValue(contactos.get(i - 1).getUnidadHabitacional().getId());

					XSSFCell cellIdentificacion = row.createCell(12);
					cellIdentificacion.setCellValue(contactos.get(i - 1).getIdentificacion());

					XSSFCell cellRelacion = row.createCell(13);
					cellRelacion.setCellValue(contactos.get(i - 1).getRelacion());

					XSSFCell cellNombre = row.createCell(14);
					cellNombre.setCellValue(contactos.get(i - 1).getNombre());

					XSSFCell cellApellido = row.createCell(15);
					cellApellido.setCellValue(contactos.get(i - 1).getApellido());

					XSSFCell cellCorreo = row.createCell(16);
					cellCorreo.setCellValue(contactos.get(i - 1).getEmal1());

					XSSFCell cellCorreo2 = row.createCell(17);
					cellCorreo2.setCellValue(contactos.get(i - 1).getEmail2());

					XSSFCell cellCelular = row.createCell(18);
					cellCelular.setCellValue(contactos.get(i - 1).getCelular());

					XSSFCell cellTelefono = row.createCell(19);
					cellTelefono.setCellValue(contactos.get(i - 1).getTelefono());

					XSSFCell cellViveEnLaUnidad = row.createCell(20);
					cellViveEnLaUnidad.setCellValue(contactos.get(i - 1).getViveEnUnidad());

					XSSFCell cellRepresentante = row.createCell(21);
					cellRepresentante.setCellValue(contactos.get(i - 1).getEsRepresentante());

					XSSFCell cellMensaje = row.createCell(22);
					cellMensaje.setCellValue(contactos.get(i - 1).getMensaje());

					CellStyle cs = libro.createCellStyle();
					cs.setWrapText(true);
					cellMensaje.setCellStyle(cs);
					row.setHeightInPoints((2 * hoja1.getDefaultRowHeightInPoints()));
					hoja1.autoSizeColumn(2);
				}
			}

		}

		
	
		// Parqueaderos
		

		for (int i = 0; i < cuentaxCobrar.size() + 1; i++) {
			XSSFRow row = hojacobro.createRow(i);// se crea las filas

			if (i == 0) {// para la cabecera
				for (int j = 0; j < headerCuentaxCobrar.length; j++) {
					XSSFCell cell = row.createCell(j);// se crea las celdas para la cabecera, junto con la posiciï¿½n
					cell.setCellStyle(style); // se aï¿½ade el style crea anteriormente
					cell.setCellValue(headerCuentaxCobrar[j]);// se aï¿½ade el contenido
				}
			} else {
				XSSFCell cellUnidad = row.createCell(0);
				cellUnidad.setCellValue(cuentaxCobrar.get(i - 1).getUnidadHabitacional().getId());

				XSSFCell cellRubro = row.createCell(1);
				cellRubro.setCellValue(cuentaxCobrar.get(i - 1).getRubro());

				XSSFCell cellFechaEmision = row.createCell(2);
				cellFechaEmision.setCellValue(cuentaxCobrar.get(i - 1).getFechaEmision());

				XSSFCell cellFechaVencimiento = row.createCell(3);
				cellFechaVencimiento.setCellValue(cuentaxCobrar.get(i - 1).getFechaVencimiento());

				XSSFCell cellNumeroFactuta = row.createCell(4);
				cellNumeroFactuta.setCellValue(cuentaxCobrar.get(i - 1).getNumeroDocumento());

				XSSFCell cellDetalle = row.createCell(5);
				cellDetalle.setCellValue(cuentaxCobrar.get(i - 1).getDetalle());
				
				XSSFCell cellValor = row.createCell(6);
				cellValor.setCellValue(cuentaxCobrar.get(i - 1).getValor());

				XSSFCell cellModo = row.createCell(7);
				cellModo.setCellValue(cuentaxCobrar.get(i - 1).getModo());

				XSSFCell cellMensaje = row.createCell(8);
				cellMensaje.setCellValue(cuentaxCobrar.get(i - 1).getMensaje());
				
				CellStyle cs = libro.createCellStyle();
				cs.setWrapText(true);
				cellMensaje.setCellStyle(cs);
				row.setHeightInPoints((2 * hoja1.getDefaultRowHeightInPoints()));
				hojacobro.autoSizeColumn(2);
			}
		}
		// proveedor
		for (int i = 0; i < proveedor.size() + 1; i++) {
			XSSFRow row = hojaproveedor.createRow(i);// se crea las filas

			if (i == 0) {// para la cabecera
				for (int j = 0; j < headerProveedor.length; j++) {
					XSSFCell cell = row.createCell(j);// se crea las celdas para la cabecera, junto con la posiciï¿½n
					cell.setCellStyle(style); // se aï¿½ade el style crea anteriormente
					cell.setCellValue(headerProveedor[j]);// se aï¿½ade el contenido
				}
			} else {

				XSSFCell cellIdentificacion = row.createCell(0);
				cellIdentificacion.setCellValue(proveedor.get(i - 1).getIdentificacion());

				XSSFCell cellRazonSocial = row.createCell(1);
				cellRazonSocial.setCellValue(proveedor.get(i - 1).getRazonSocial());

				XSSFCell cellCorreo = row.createCell(2);
				cellCorreo.setCellValue(proveedor.get(i - 1).getEmal1());

				XSSFCell cellTelefono = row.createCell(3);
				cellTelefono.setCellValue(proveedor.get(i - 1).getTelefono());

				XSSFCell cellNombre = row.createCell(4);
				cellNombre.setCellValue(proveedor.get(i - 1).getNombre());

				XSSFCell cellApellido = row.createCell(5);
				cellApellido.setCellValue(proveedor.get(i - 1).getApellido());

				XSSFCell cellCorreoRepresentante = row.createCell(6);
				cellCorreoRepresentante.setCellValue(proveedor.get(i - 1).getEmail2());

				XSSFCell cellCelular = row.createCell(7);
				cellCelular.setCellValue(proveedor.get(i - 1).getCelular());

				XSSFCell cellDireccion = row.createCell(8);
				cellDireccion.setCellValue(proveedor.get(i - 1).getDireccion());

				XSSFCell cellMensaje = row.createCell(9);
				cellMensaje.setCellValue(proveedor.get(i - 1).getMensaje());
				CellStyle cs = libro.createCellStyle();
				cs.setWrapText(true);
				cellMensaje.setCellStyle(cs);
				row.setHeightInPoints((2 * hoja1.getDefaultRowHeightInPoints()));
				hojaproveedor.autoSizeColumn(2);
			}
		}
		
		for (int i = 0; i < cuentaxPagar.size() + 1; i++) {
			XSSFRow row = hojapaga.createRow(i);// se crea las filas

			if (i == 0) {// para la cabecera
				for (int j = 0; j < headerCuentaxPagar.length; j++) {
					XSSFCell cell = row.createCell(j);// se crea las celdas para la cabecera, junto con la posiciï¿½n
					cell.setCellStyle(style); // se aï¿½ade el style crea anteriormente
					cell.setCellValue(headerCuentaxPagar[j]);// se aï¿½ade el contenido
				}
			} else {
				XSSFCell cellProveedor = row.createCell(0);
				cellProveedor.setCellValue(cuentaxPagar.get(i - 1).getProveedor().getIdentificacion());

				XSSFCell cellRubro = row.createCell(1);
				cellRubro.setCellValue(cuentaxPagar.get(i - 1).getRubro());

				XSSFCell cellFechaFactura = row.createCell(2);
				cellFechaFactura.setCellValue(cuentaxPagar.get(i - 1).getFechaFactura());

				XSSFCell cellFechaVencimiento = row.createCell(3);
				cellFechaVencimiento.setCellValue(cuentaxPagar.get(i - 1).getFechaVencimiento());

				XSSFCell cellNumeroFactuta = row.createCell(4);
				cellNumeroFactuta.setCellValue(cuentaxPagar.get(i - 1).getNumeroFactura());
				
				XSSFCell cellDetalle = row.createCell(5);
				cellDetalle.setCellValue(cuentaxPagar.get(i - 1).getDetalle());


				XSSFCell cellValor = row.createCell(6);
				cellValor.setCellValue(cuentaxPagar.get(i - 1).getValorPorPagar());

				XSSFCell cellMensaje = row.createCell(7);
				cellMensaje.setCellValue(cuentaxPagar.get(i - 1).getMensaje());
				
				CellStyle cs = libro.createCellStyle();
				cs.setWrapText(true);
				cellMensaje.setCellStyle(cs);
				row.setHeightInPoints((2 * hoja1.getDefaultRowHeightInPoints()));
				hojacobro.autoSizeColumn(2);
			}
		}
		File file;
		file = abrirArchivo("xlsx", "xlsx");
		file.renameTo(new File(file.getAbsolutePath()+".xlsx"));
		
		try (FileOutputStream fileOuS = new FileOutputStream(file)) {
			if (file.exists()) {// si el archivo existe se elimina
				file.delete();
				
			}
			libro.write(fileOuS);
			fileOuS.flush();
			fileOuS.close();
			System.out.println("Archivo Creado");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
