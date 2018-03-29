package controladores;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.CuentaPorCobrar;
import entidades.UnidadHabitacional;

import validadores.ValidadorGeneral;

public class ControladorCuentaxCobrar {
	public static List<CuentaPorCobrar> listaCuentaCobrar = new ArrayList<CuentaPorCobrar>();

	public void crearListaCuentaPorCobrar(CuentaPorCobrar cuentaPorCobrar) {
		listaCuentaCobrar.add(cuentaPorCobrar);
	}

	/**
	 * M�todo extraer datos de las columnas excel, ademas de eliminar los espacios
	 * en blanco de las celdas extraidas
	 */
	
	/**
	 * @param libro
	 * @return
	 */
	public List<CuentaPorCobrar> extraerCuentaCobrar(XSSFWorkbook libro) {

		List<CuentaPorCobrar> listaCuentaCobrar = new ArrayList<CuentaPorCobrar>();

		XSSFSheet hoja = libro.getSheetAt(2);

		for (int i = 2; i < hoja.getLastRowNum(); i++) {
			XSSFRow fila = hoja.getRow(i);
			XSSFCell celdaId = fila.getCell(0);
			celdaId.setCellType(Cell.CELL_TYPE_STRING);
			
			XSSFCell celdaModo = fila.getCell(6);
			celdaModo.setCellType(Cell.CELL_TYPE_STRING);
			
			

			if (!comprobarSiEstaVaciaLaFila(fila)) {
				CuentaPorCobrar cuentaPorCobrar = new CuentaPorCobrar(
						new UnidadHabitacional(celdaId.toString()), fila.getCell(1).toString().trim(),
						fila.getCell(2).toString().trim(), fila.getCell(3).toString().trim(),
						fila.getCell(4).toString().trim(), fila.getCell(5).toString().trim(),
						celdaModo.toString().trim(), fila.getCell(7).toString().trim(), null, null);

				listaCuentaCobrar.add(cuentaPorCobrar);
			}
		}
		return listaCuentaCobrar;
	}
	
	public static boolean comprobarSiEstaVaciaLaFila(XSSFRow fila) {
		for (int i = 0; i <7; i++) {
			XSSFCell celda = fila.getCell(i);
			if (celda.toString().toString()!="") {
				return false;
			} 		
		}
		return true;
	}

}
