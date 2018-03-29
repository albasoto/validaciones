package validadores;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ValidadorGeneral {
	/*comprueba que las celdas no esten en blanco celdas en cada una de las pesta�as */
	
	/**
	 * @param fila
	 * @return
	 */
	public static boolean comprobarSiEstaVaciaLaFila(XSSFRow fila) {
		for (int i = fila.getFirstCellNum(); i < fila.getLastCellNum(); i++) {
			XSSFCell celda = fila.getCell(i);
			if (celda != null && celda.getCellType() != XSSFCell.CELL_TYPE_BLANK) {
				return false;
			}
				
		}
		return true;
	}
	

}
