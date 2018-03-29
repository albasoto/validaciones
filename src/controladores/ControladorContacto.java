package controladores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.Contacto;
import entidades.UnidadHabitacional;
import validadores.ValidadorGeneral;

public class ControladorContacto {
	public static List<Contacto> listaContacto = new ArrayList<Contacto>();

	public void crearListaContacto(Contacto contacto) {
		listaContacto.add(contacto);
	}

	/**
	 * Metodo extraer datos de las columnas excel, ademas de eliminar los espacios
	 * en blanco de las celdas extraidas
	 */

	/**
	 * @param libro
	 * @return
	 */
	public List<Contacto> extraerContacto(XSSFWorkbook libro) {
		List<Contacto> listaContacto = new ArrayList<Contacto>();
		XSSFSheet hoja = libro.getSheetAt(0);
		for (int i = 2; i < hoja.getLastRowNum(); i++) {
			XSSFRow fila = hoja.getRow(i);

			XSSFCell celdaId = fila.getCell(11);
			celdaId.setCellType(Cell.CELL_TYPE_STRING);

			XSSFCell celdaCelular = fila.getCell(18);
			celdaCelular.setCellType(Cell.CELL_TYPE_STRING);

			XSSFCell celdaTelefono = fila.getCell(19);
			celdaTelefono.setCellType(Cell.CELL_TYPE_STRING);

			if (!comprobarSiEstaVaciaLaFila(fila)) {
				Contacto contacto = new Contacto(new UnidadHabitacional(celdaId.toString().trim()),
						fila.getCell(12).toString().trim(), fila.getCell(13).toString().trim(),
						fila.getCell(14).toString().trim(), fila.getCell(15).toString().trim(),
						fila.getCell(16).toString().trim(), fila.getCell(17).toString().trim(),
						celdaCelular.toString().trim(), celdaTelefono.toString().trim(),
						fila.getCell(20).toString().trim(), fila.getCell(21).toString().trim(), null, null);
				listaContacto.add(contacto);

			}

		}
		return listaContacto;
	}
	
	public static boolean comprobarSiEstaVaciaLaFila(XSSFRow fila) {
		for (int i = 11; i <=21; i++) {
			XSSFCell celda = fila.getCell(i);
			if (celda.toString().toString()!="") {
				return false;
			} 		
		}
		return true;
	}

	

}
