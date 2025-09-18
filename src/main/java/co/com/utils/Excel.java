package co.com.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Excel {

    public static List<Map<String, String>> leerDatosDeHojaDeExcel(String rutaDeExcel, String hojaDeExcel) throws IOException {
        List<Map<String, String>> datos = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(rutaDeExcel);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(hojaDeExcel);
            Iterator<Row> rowIterator = sheet.iterator();

            // Fila de títulos
            Row titulos = rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Map<String, String> filaDatos = new HashMap<>();

                for (Cell cell : row) {
                    String titulo = titulos.getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                    String valor = "";

                    switch (cell.getCellType()) {
                        case STRING:
                            valor = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            valor = String.valueOf((long) cell.getNumericCellValue());
                            break;
                        case BLANK:
                            valor = "";
                            break;
                        default:
                            valor = cell.toString();
                    }
                    filaDatos.put(titulo, valor);
                }
                datos.add(filaDatos);
            }
        }
        return datos;
    }
}
