
package programa;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Conexion;


public class Ventana extends javax.swing.JFrame {

    public Ventana() {
        initComponents();
        
       /*
        int ancho = panelImagen.getWidth(); // Obtener el ancho en pixeles del panel en la variable ancho
        int alto = panelImagen.getHeight(); // obtener el alto en pixeles del panel en la variable ancho.
        
        String ruta = "/imagenes/positivo.png";
        
        
        Imagen imagen = new Imagen(ancho,alto,ruta);
        
        panelImagen.add(imagen);
        panelImagen.repaint();
        */
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImagen = new javax.swing.JPanel();
        botonCargar = new javax.swing.JButton();
        btnMostrarImagen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonCargar.setText("Cargar Imagen");
        botonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarActionPerformed(evt);
            }
        });

        btnMostrarImagen.setText("Mostrar Imagen");
        btnMostrarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImagenLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(botonCargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(btnMostrarImagen)
                .addGap(45, 45, 45))
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImagenLayout.createSequentialGroup()
                .addContainerGap(581, Short.MAX_VALUE)
                .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCargar)
                    .addComponent(btnMostrarImagen))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarActionPerformed
        
        JFileChooser escoger = new JFileChooser();
        // MOdelo al JFileChooser para que nos muestre archivos y directorios
        escoger.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);        
        
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.png","png"); // Solo muestres carpetas e imagenes png.
        escoger.setFileFilter(filtro); // establecemos el filtro en el JFileChooser

        int seleccion = escoger.showOpenDialog(this); // Darnos cuenta cual ha sido la opcion que el usuario ha escogido
        
        // Guardar foto a la BASE DE DATOS
        PreparedStatement ps = null;
        Conexion con = new Conexion();
        
        
        if(seleccion == JFileChooser.APPROVE_OPTION){ // Si el usuario escogio aceptar.
            // Obtener cual es el archivo ha seleccionado
            // Posteriormente, ponerlo en el JPanel
            File archivo = escoger.getSelectedFile(); // Obtenemos el archivo selecionado
            
            try{
                // InputStream
                // Contiene el archivo / imagen que el usuario selecciono
                FileInputStream archivoEntrada = new FileInputStream(archivo);
                Connection conexion = con.obtenerConexion();
                
                ps = conexion.prepareStatement("insert into imagen (img) values(?)");
                ps.setBinaryStream(1, archivoEntrada, (int) archivo.length());
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Imagen guardada");
            }catch(Exception ex){
                System.err.println("Error : "+ ex);
            }
        }

    }//GEN-LAST:event_botonCargarActionPerformed

    private void btnMostrarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarImagenActionPerformed
        int idImagen = Integer.parseInt(JOptionPane.showInputDialog("Digite el Id de la imagen que desea cargar"));
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Conexion con = new Conexion();
        
        
        try{
            Connection conexion = con.obtenerConexion();
            
            ps = conexion.prepareStatement("select img from imagen where idImagen = ?");
            ps.setInt(1, idImagen);
            rs = ps.executeQuery();
            
            // va almacenar la imagen. 
            // posteriormente, lo mandara a la clase imagen para que lo pueda pintar en el panel
            BufferedImage buffImg = null;
            
            // hay que traer todos los bites que esa imagen tiene en la BD
            // Y guardarlos en un InputStream
            // 1 es el numero de columnas ( en este caso es la columna img ) 
            while(rs.next()){
                InputStream img = rs.getBinaryStream(1);
                buffImg = ImageIO.read(img);
                
                int ancho = panelImagen.getWidth(); // Obtener el ancho en pixeles del panel en la variable ancho
                int alto = panelImagen.getHeight(); // obtener el alto en pixeles del panel en la variable ancho.
                
                Imagen imagen = new Imagen(ancho,alto,buffImg);
                panelImagen.add(imagen);
                panelImagen.repaint();
                
            }
            
            
            rs.close();
            
        }catch(Exception ex){
            System.err.println("Error : " + ex);
        }
    }//GEN-LAST:event_btnMostrarImagenActionPerformed

 /*
                String ruta = archivo.getAbsolutePath(); // Obtenemos la ruta del archivo seleccionado
            
    
    */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCargar;
    private javax.swing.JButton btnMostrarImagen;
    private javax.swing.JPanel panelImagen;
    // End of variables declaration//GEN-END:variables
}
