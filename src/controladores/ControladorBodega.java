package controladores;

/**
 * @autor alba soto
 * @version 23/03/2018 */
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.ParqueaderoBodega;
import entidades.UnidadHabitacional;
import validadores.ValidadorGeneral;

public class ControladorBodega {
	
	public static List<ParqueaderoBodega> listaBodega = new ArrayList<ParqueaderoBodega>();

	public void crearListaBodega(ParqueaderoBodega Bodega) {
		listaBodega.add(Bodega);
	}
	

	/**
	 * Metodo extraer datos de las columnas excel, ademas de eliminar los espacios
	 * en blanco de las celdas extraidas
	 */
	/**
	 * @param libro
	 * @return
	 */
	public List<ParqueaderoBodega> extraerBodega(XSSFWorkbook libro) {
		List<ParqueaderoBodega> listaBodega = new ArrayList<ParqueaderoBodega>();
		XSSFSheet hoja = libro.getSheetAt(1);
		for (int i = 2; i < hoja.getLastRowNum(); i++) {
			XSSFRow fila = hoja.getRow(i);
			if (!comprobarSiEstaVaciaLaFila(fila)) {

				ParqueaderoBodega bodega = new ParqueaderoBodega(new UnidadHabitacional(fila.getCell(5).toString()),
						fila.getCell(6).toString().trim(), fila.getCell(7).toString().trim(),
						fila.getCell(8).toString().trim(), null, null);
				listaBodega.add(bodega);
			}
		}
		return listaBodega;
	}
	
	public static boolean comprobarSiEstaVaciaLaFila(XSSFRow fila) {
		for (int i = 5; i <8; i++) {
			XSSFCell celda = fila.getCell(i);
			if (celda.toString().toString()!="") {
				return false;
			} 		
		}
		return true;
	}
}
