
package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Conexion;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    public static void main(String[] args) {
        //crearExcel();
        
        //leerExcel();
        
        //cargarBDExcel();
        cargar_Desde_BD_To_Excel();
    }
    
    
    public static void crearExcel(){
        // crear objeto Workbook para crear excel
        Workbook libro = new XSSFWorkbook();
        // creo una nueva pestaña
        Sheet hoja = libro.createSheet("Hello world");
        
         // Creamos la primera fila en la posicion 0
        Row fila0 = hoja.createRow(0);
        fila0.createCell(0).setCellValue("HOlita");
        fila0.createCell(1).setCellValue(5.9);
        fila0.createCell(2).setCellValue(true);
        
        Cell celda = fila0.createCell(3);
        // Creacion de formulas
        celda.setCellFormula(String.format("14+5",""));
        
        Row fila1 = hoja.createRow(1);
        fila1.createCell(0).setCellValue(4.5);
        fila1.createCell(1).setCellValue(15.7);
        
        Cell celda1 = fila1.createCell(3);
        celda1.setCellFormula(String.format("A%d+B%d",2,1));
        
        try{
            // creo el archivo
            FileOutputStream archivo = new FileOutputStream("Excel2.xlsx");
            // escribo el archivo en mi workbook
            libro.write(archivo);
            archivo.close();
        }catch(Exception ex){
            System.err.println("Error : "+ ex);
        }

    }

    public static void leerExcel(){
        try{
            FileInputStream archivo = new FileInputStream(new File("D:\\productos.xlsx"));
            // Libro de lectura
            XSSFWorkbook libroLectura = new XSSFWorkbook(archivo);
            // hoja de lectura
            XSSFSheet hojaLectura = libroLectura.getSheetAt(0);
            
            int numFilas = hojaLectura.getLastRowNum();
            
            System.out.println(numFilas);
            
            for(int i=0; i< numFilas; i++){
                // Obtener los valores de cada una de las filas de la hoja
                Row fila = hojaLectura.getRow(i);
                int numCol = fila.getLastCellNum();
                System.out.println(numCol);
                
                for(int j=0; j<numCol; j++){
                    Cell celda = fila.getCell(j);
                    // Tipo de dato de la celda
                    switch(celda.getCellTypeEnum().toString()){
                        case "NUMERIC":
                            System.out.print(celda.getNumericCellValue());
                            break;
                        case "STRING":
                            System.out.print(celda.getStringCellValue()+ " ");
                            break;
                        case "FORMULA":
                            System.out.print(celda.getCellFormula() + " ");
                            break;
                    }
                }
            }
        }catch(Exception ex){
            System.err.println("Error : "+ ex);
        }
    }
    
    public static void cargarBDExcel(){
        Conexion con = new Conexion();
           
        PreparedStatement ps;
        
        try{
            Connection conexion = con.obtenerConexion();
            FileInputStream archivo = new FileInputStream(new File("D:\\productos.xlsx"));
            // Libro de lectura
            XSSFWorkbook libroLectura = new XSSFWorkbook(archivo);
            // hoja de lectura
            XSSFSheet hojaLectura = libroLectura.getSheetAt(0);
            
            int numFilas = hojaLectura.getLastRowNum();
            
            
            
            for(int i=1; i< numFilas; i++){
                // Obtener los valores de cada una de las filas de la hoja
                Row fila = hojaLectura.getRow(i);
                ps = conexion.prepareStatement("insert into producto(codigo,nombre,precio,cantidad) values(?,?,?,?)");
                
                // getCell -> obtengo la posicion de la celda
                // getStringCellValue --> Obtener el valor que tiene la celda
                ps.setString(1, String.valueOf(fila.getCell(0).getNumericCellValue()));
                ps.setString(2, fila.getCell(1).getStringCellValue());
                ps.setDouble(3, fila.getCell(2).getNumericCellValue());
                ps.setInt(4, (int)fila.getCell(3).getNumericCellValue());
                
                ps.executeUpdate();
            }
            
            conexion.close();
        }catch(Exception ex){
            System.err.println("Error : "+ ex);
        }
    }
    
    public static void cargar_Desde_BD_To_Excel(){
        
        Workbook libro = new XSSFWorkbook();
        Sheet hoja = libro.createSheet("Reporte de productos");
        Conexion con = new Conexion();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String[] cabeceras = new String[]{"codigo","Nombre","Precio","Cantidad"};
        
         // Fila cabeceras de las columnas
        Row filaCabeceras = hoja.createRow(0);
        // nombre de las cabeceras en la primera fila.
        for (int i=0; i<cabeceras.length;i++){
            Cell celda = filaCabeceras.createCell(i);
            celda.setCellValue(cabeceras[i]);
        }
        
        // Se coloca 1 porque la fila 0 ya pertenece a la cabecera
        int numeroFila = 1;
        try{
            Connection conexion = con.obtenerConexion();
            
            ps = conexion.prepareStatement("select codigo, nombre, precio, cantidad from producto");
            rs = ps.executeQuery();
            
            // Cantidad de columnas de la query
            int numeroColumnas = rs.getMetaData().getColumnCount();
            
            while(rs.next()){
                Row filaDatos = hoja.createRow(numeroFila);
                
                for (int i=0; i<numeroColumnas;i++){
                    Cell celda = filaDatos.createCell(i);
                    
                     if(i==0 || i==1){
                        celda.setCellValue(rs.getString(i+1));
                    } else{
                         celda.setCellValue(rs.getDouble(i+1));
                     }
                }
                numeroFila++;
            }
            
            // Se establece el archivo
            FileOutputStream archivo = new FileOutputStream("ReporteProductos.xlsx");
            libro.write(archivo);
            archivo.close();
        }catch(Exception ex){
            System.err.println("Error : "+ ex);
        }
        
    }
}
