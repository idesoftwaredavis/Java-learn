/*
    CRUD es el acronimo que se usa para referirse a las funciones basicas
    en bases de datos o la capa de persistencia en un software.
*/
package aplicacion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Conexion extends javax.swing.JFrame {
    public static final String URL = "jdbc:mysql://localhost:3306/escuela?autoReconnet=true&useSSL=false";
    public static final String usuario = "root";
    public static final String password = "";
    
    public Conexion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(btnConectar)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btnConectar)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
       Connection conexion = obtenerConexion();
       PreparedStatement ps; // guardara las diversas consultas que uno puede hacer.
       ResultSet rs; // Leer los registros que obtengo
       
       try{
           ps = conexion.prepareStatement("select * from persona");
           
           rs = ps.executeQuery();
           
           if(rs.next()){
               JOptionPane.showMessageDialog(null, 
                       String.format("nombre : %s \n domicilio : %s \n celular : %s \n correo : %s \n fecha : %s \n genero : %s \n ",
                                    rs.getString("nombre"),rs.getString("domicilio"),rs.getString("celular"),
                                    rs.getString("correo_electronico"),rs.getDate("fecha_nacimiento"),rs.getString("genero")));
           }else{
               JOptionPane.showMessageDialog(null, "No existen registros");
           }
           conexion.close();
       }catch(Exception ex){
           System.err.println("Error : "+ ex);
       }
       
       
    }//GEN-LAST:event_btnConectarActionPerformed

    public Connection obtenerConexion(){
        Connection conexion = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            // Establecer la conexion 
            conexion = (Connection) DriverManager.getConnection(URL, usuario,password);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        }catch(Exception ex){
            System.err.println("Error : "+ ex);
        }
        return conexion;
    };
    
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
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    // End of variables declaration//GEN-END:variables

}
