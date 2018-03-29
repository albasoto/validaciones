package controladores;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.ParqueaderoBodega;
import entidades.UnidadHabitacional;
import validadores.ValidadorGeneral;

public class ControladorParqueadero {
	public static List<ParqueaderoBodega> listaParqueadero = new ArrayList<ParqueaderoBodega>();

	public void crearListaParqueadero(ParqueaderoBodega parqueaderoBodega) {
		listaParqueadero.add(parqueaderoBodega);
	}

	/**
	 * M�todo extraer datos de las columnas excel, ademas de eliminar los espacios
	 * en blanco de las celdas extraidas
	 */
	
	/**
	 * @param libro
	 * @return
	 */
	public List<ParqueaderoBodega> extraerParqueadero(XSSFWorkbook libro) {

		List<ParqueaderoBodega> listaParqueadero = new ArrayList<ParqueaderoBodega>();

		XSSFSheet hoja = libro.getSheetAt(1);
		for (int i = 2; i < hoja.getLastRowNum(); i++) {
			XSSFRow fila = hoja.getRow(i);

			if (!comprobarSiEstaVaciaLaFila(fila)) {

				ParqueaderoBodega parqueadero = new ParqueaderoBodega(
						new UnidadHabitacional(fila.getCell(0).toString()), fila.getCell(1).toString().trim(),
						fila.getCell(2).toString().trim(), fila.getCell(3).toString().trim(), null, null);

				listaParqueadero.add(parqueadero);
			}
		}
		return listaParqueadero;
	}
	
	public static boolean comprobarSiEstaVaciaLaFila(XSSFRow fila) {
		for (int i = 0; i <3; i++) {
			XSSFCell celda = fila.getCell(i);
			if (celda.toString().toString()!="") {
				return false;
			} 		
		}
		return true;
	}

}
