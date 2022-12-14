

package prograa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Conexion;


public class Ventana extends javax.swing.JFrame {

   
    public Ventana() {
        initComponents();
        grupoBotones.add(radioBotonHombre);
        grupoBotones.add(radioBotonMujer);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        numeroEdad = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        radioBotonHombre = new javax.swing.JRadioButton();
        radioBotonMujer = new javax.swing.JRadioButton();
        checkBoxBasquet = new javax.swing.JCheckBox();
        checkBoxFutbol = new javax.swing.JCheckBox();
        checkBoxTennis = new javax.swing.JCheckBox();
        checkBoxNatacion = new javax.swing.JCheckBox();
        btnInsertar = new javax.swing.JButton();
        botonMostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Formulario");

        jLabel2.setText("Seleccione Genero");

        jLabel3.setText("Cual es su edad ?");

        jLabel4.setText("Seleccione sus deportes favoritos:");

        radioBotonHombre.setText("Hombre");

        radioBotonMujer.setText("Mujer");

        checkBoxBasquet.setText("Basquet");

        checkBoxFutbol.setText("Futbol");

        checkBoxTennis.setText("Tennis");

        checkBoxNatacion.setText("Natacion");

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        botonMostrar.setText("Mostrar");
        botonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioBotonHombre)
                            .addComponent(radioBotonMujer)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(numeroEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4)
                                .addComponent(checkBoxBasquet)
                                .addComponent(checkBoxFutbol)
                                .addComponent(checkBoxTennis)
                                .addComponent(checkBoxNatacion)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnInsertar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonMostrar))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(161, 161, 161)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(radioBotonHombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioBotonMujer)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(numeroEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(19, 19, 19)
                .addComponent(checkBoxFutbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBoxBasquet)
                .addGap(5, 5, 5)
                .addComponent(checkBoxTennis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBoxNatacion)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(botonMostrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
       
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        
        // data
        String genero = "";
        int edad ;
        boolean futbol = false;
        boolean basquet = false;
        boolean tennis = false;
        boolean natacion = false;
        boolean beisbol = false;
        
        // JRADIOBUTTON
        String generoBoton = radioBotonHombre.isSelected() == true ? genero ="Hombre" : "Mujer";
       
        // JSPINNER
        edad = (int) numeroEdad.getValue();
        
        // CHECKBOX 
        if(checkBoxFutbol.isEnabled() == true){
            futbol = true;
        }
        
        if(checkBoxBasquet.isEnabled() == true){
            basquet = true;
        }
        if(checkBoxTennis.isSelected() == true){
            tennis = true;
        }
        
        if(checkBoxNatacion.isSelected()== true){
            natacion = true;
        }
  
        try{
            Connection conexion = con.obtenerConexion();
            ps = conexion.prepareStatement("insert into gustospersona (genero, edad, futbol, basquet, tennis, natacion) values(?,?,?,?,?,?)");
            ps.setString(1, genero);
            ps.setInt(2, edad);
            ps.setBoolean(3, futbol);
            ps.setBoolean(4, basquet);
            ps.setBoolean(5, tennis);
            ps.setBoolean(6, natacion);
            
            ps.executeUpdate();
            
            
            conexion.close();
        }catch(Exception ex){
            System.err.println("Error : " + ex);
        }
        
        
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void botonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarActionPerformed
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs;
        try{
            Connection conexion = con.obtenerConexion();
            ps = conexion.prepareStatement("select genero,edad,futbol,basquet,tennis,natacion from gustospersona where id=?");
            ps.setInt(1, 2);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                // Obtener RadioButtons
                if(rs.getString("genero").equals("Hombre")){
                    radioBotonHombre.setSelected(true);
                }else if(rs.getString("genero").equals("Mujer")){
                    radioBotonMujer.setSelected(true);
                }
                
                // Obtener JSPINNER
                numeroEdad.setValue(rs.getInt("edad"));
                
                // Obtener CheckBox
                if(rs.getBoolean("futbol") == true){
                    checkBoxFutbol.setSelected(true);
                }
                
                if(rs.getBoolean("basquet")==true){
                    checkBoxBasquet.setSelected(true);
                }
                
                if(rs.getBoolean("natacion") == true){
                    checkBoxNatacion.setSelected(true);
                }
            
            }
            conexion.close();
        }catch(Exception ex){
            System.err.println("Error : " + ex);
        }
    }//GEN-LAST:event_botonMostrarActionPerformed

    /**
     * @param args the command line arguments
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
    private javax.swing.JButton botonMostrar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JCheckBox checkBoxBasquet;
    private javax.swing.JCheckBox checkBoxFutbol;
    private javax.swing.JCheckBox checkBoxNatacion;
    private javax.swing.JCheckBox checkBoxTennis;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner numeroEdad;
    private javax.swing.JRadioButton radioBotonHombre;
    private javax.swing.JRadioButton radioBotonMujer;
    // End of variables declaration//GEN-END:variables

}
