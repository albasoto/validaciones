package controladores;


import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.UnidadHabitacional;
import validadores.ValidadorGeneral;

public class ControladorUnidad {

	public static List<UnidadHabitacional> listaUnidad = new ArrayList<UnidadHabitacional>();

	public void crearListaUnidad(UnidadHabitacional unidad) {
		listaUnidad.add(unidad);
	}

	/**
	 * M�todo Contacto extraer datos de las columnas excel, ademas de eliminar los
	 * espacios en blanco de las celdas extraidas
	 */
	/**
	 * @param libro
	 * @return
	 */
	public List<UnidadHabitacional> extraerUnidades(XSSFWorkbook libro) {

		List<UnidadHabitacional> listaUnidades = new ArrayList<UnidadHabitacional>();

		XSSFSheet hoja = libro.getSheetAt(0);
		for (int i = 2; i < hoja.getLastRowNum(); i++) {
			XSSFRow fila = hoja.getRow(i);
			if (!comprobarSiEstaVaciaLaFila(fila)) {
				
				XSSFCell celdaId = fila.getCell(1);
				celdaId.setCellType(Cell.CELL_TYPE_STRING);
				
				XSSFCell celdaArea= fila.getCell(2);
				celdaArea.setCellType(Cell.CELL_TYPE_STRING);
				XSSFCell celdaAlicuota= fila.getCell(3);
				celdaAlicuota.setCellType(Cell.CELL_TYPE_STRING);
				
				XSSFCell celdaTelefono= fila.getCell(7);
				celdaTelefono.setCellType(Cell.CELL_TYPE_STRING);
				
				UnidadHabitacional unidad = new UnidadHabitacional(fila.getCell(0).toString().trim(),
						celdaId.toString().trim(), 
						celdaArea.toString().trim(),
						celdaAlicuota.toString().trim(), 
						fila.getCell(4).toString().trim(),
						fila.getCell(5).toString().trim(), fila.getCell(6).toString().trim(),
						celdaTelefono.toString().trim(), fila.getCell(8).toString().trim(),
						fila.getCell(9).toString().trim(), null, null);

				listaUnidades.add(unidad);
			}
		}

		return listaUnidades;

	}
	
	public static boolean comprobarSiEstaVaciaLaFila(XSSFRow fila) {
		for (int i = 0; i <10; i++) {
			XSSFCell celda = fila.getCell(i);
			if (celda.toString().toString()!="") {
				return false;
			} 		
		}
		return true;
	}
	
	
	

}
