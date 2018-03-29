package controladores;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.CuentaPorPagar;
import entidades.Proveedor;
import validadores.ValidadorGeneral;

public class ControladorCuentaxPagar {
	public static List<CuentaPorPagar> listaCuentaPagar = new ArrayList<CuentaPorPagar>();

	public void crearListaContacto(CuentaPorPagar cuentaPorPagar) {
		listaCuentaPagar.add(cuentaPorPagar);
	}

	/**
	 * Metodo extraer datos de las columnas excel, ademas de eliminar los espacios
	 * en blanco de las celdas extraidas
	 */
	
	/**
	 * @param libro
	 * @return
	 */
	public List<CuentaPorPagar> extraerCuentaPagar(XSSFWorkbook libro) {

		List<CuentaPorPagar> listaCuentaPagar = new ArrayList<CuentaPorPagar>();

		XSSFSheet hoja = libro.getSheetAt(4);
		for (int i = 2; i < hoja.getLastRowNum(); i++) {
			XSSFRow fila = hoja.getRow(i);

			if (!comprobarSiEstaVaciaLaFila(fila)) {
				CuentaPorPagar cuentaxPagar = new CuentaPorPagar(new Proveedor(fila.getCell(0).toString()),
						fila.getCell(1).toString().trim(), fila.getCell(2).toString().trim(),
						fila.getCell(3).toString().trim(), fila.getCell(4).toString().trim(),
						fila.getCell(5).toString().trim(), fila.getCell(6).toString().trim(), null, null

				);

				listaCuentaPagar.add(cuentaxPagar);
			}

		}
		return listaCuentaPagar;
	}
	
	
	public static boolean comprobarSiEstaVaciaLaFila(XSSFRow fila) {
		for (int i = 0; i <6; i++) {
			XSSFCell celda = fila.getCell(i);
			if (celda.toString().toString()!="") {
				return false;
			} 		
		}
		return true;
	}

}
