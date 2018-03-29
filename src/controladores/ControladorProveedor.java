package controladores;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.Proveedor;
import validadores.ValidadorGeneral;

public class ControladorProveedor {
	public static List<Proveedor> listaProveedor = new ArrayList<Proveedor>();

	public void crearListaProveedor(Proveedor proveedor) {
		listaProveedor.add(proveedor);
	}

	/**
	 * Metodo Contacto extraer datos de las columnas excel, ademas de eliminar los
	 * espacios en blanco de las celdas extraidas
	 */
	
	/**
	 * @param libro
	 * @return
	 */
	public List<Proveedor> extraerProveedor(XSSFWorkbook libro) {

		List<Proveedor> listaProveedor = new ArrayList<Proveedor>();

		XSSFSheet hoja = libro.getSheetAt(3);

		for (int i = 2; i < hoja.getLastRowNum(); i++) {
			XSSFRow fila = hoja.getRow(i);
			if (!comprobarSiEstaVaciaLaFila(fila)) {
				Proveedor proveedor = new Proveedor(

						fila.getCell(0).toString().trim(), fila.getCell(1).toString().trim(),
						fila.getCell(2).toString().trim(), fila.getCell(3).toString().trim(),
						fila.getCell(4).toString().trim(), fila.getCell(5).toString().trim(),
						fila.getCell(6).toString().trim(), fila.getCell(7).toString().trim(),
						fila.getCell(8).toString().trim(), null, null

				);

				listaProveedor.add(proveedor);
			}
		}
		return listaProveedor;
	}
	
	
	public static boolean comprobarSiEstaVaciaLaFila(XSSFRow fila) {
		for (int i = 0; i <8; i++) {
			XSSFCell celda = fila.getCell(i);
			if (celda.toString().toString()!="") {
				return false;
			} 		
		}
		return true;
	}
}
