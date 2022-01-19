package app;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JTextField;

public class Usuario extends javax.swing.JFrame implements Runnable{
    String hora,minutos,segundos;
    Thread hilo;

    public Usuario() {
        initComponents();
        RestrictedTextField r= new RestrictedTextField(txtTelefono);
        r.setLimit(10);
        lbFecha.setText(fecha());
        hilo = new Thread(this);
        hilo.start();
        setVisible(true);
        btnRegistrar.setEnabled(false);
    }
    
    public void hora(){
        Calendar calendario = new GregorianCalendar();
        Date horaactual = new Date();
        calendario.setTime(horaactual);
        hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
    }
    
    @Override
    public void run(){
        //WHILE
        Thread current = Thread.currentThread();
        
//        while(current==hilo){
//            hora();
//            lbHora.setText(hora+":"+minutos+":"+segundos);
//        }
        //FOR
        for (int i = 1; i > 0; i++){
            if(i>0){
                hora();
                lbHora.setText(hora+":"+minutos+":"+segundos);
            }
        }
    }
    
    public void habilitarBotonRegistrar(){
        if(!txtUsuario.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtMaterno.getText().isEmpty() && !txtPaterno.getText().isEmpty() && !txtContrasena.getText().isEmpty() && !txtTelefono.getText().isEmpty()){
            btnRegistrar.setEnabled(true);
    }else{
            btnRegistrar.setEnabled(false);
            }
    }
    private void limpiar(){
        txtUsuario.setText("");
        txtNombre.setText("");
        txtMaterno.setText("");
        txtPaterno.setText("");
        txtContrasena.setText("");
        txtConfirmacion.setText("");
        txtTelefono.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtConfirmacion = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        FondoBlanco = new javax.swing.JLabel();
        FondoAzul = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Usuario");
        setBackground(new java.awt.Color(0, 51, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrar.setBackground(new java.awt.Color(20, 39, 78));
        btnRegistrar.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1261, 854, 260, 120));

        btnCancelar.setBackground(new java.awt.Color(215, 80, 56));
        btnCancelar.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1561, 852, 260, 120));

        txtUsuario.setBackground(new java.awt.Color(155, 164, 180));
        txtUsuario.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 219, 500, 78));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel2.setText("Nombre de Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 219, -1, -1));

        txtContrasena.setBackground(new java.awt.Color(155, 164, 180));
        txtContrasena.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        txtContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyReleased(evt);
            }
        });
        getContentPane().add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 332, 500, 78));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel7.setText("Contraseña:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 332, -1, -1));

        txtConfirmacion.setBackground(new java.awt.Color(155, 164, 180));
        txtConfirmacion.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        getContentPane().add(txtConfirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 445, 500, 78));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel14.setText("Confirmar Contraseña:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 445, -1, -1));

        txtNombre.setBackground(new java.awt.Color(155, 164, 180));
        txtNombre.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 557, 500, 78));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 558, -1, -1));

        txtPaterno.setBackground(new java.awt.Color(155, 164, 180));
        txtPaterno.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaternoKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaternoKeyReleased(evt);
            }
        });
        getContentPane().add(txtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 670, 500, 78));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel5.setText("Apellido Paterno:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 671, -1, -1));

        txtMaterno.setBackground(new java.awt.Color(155, 164, 180));
        txtMaterno.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        txtMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaternoKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaternoKeyReleased(evt);
            }
        });
        getContentPane().add(txtMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 783, 500, 78));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel4.setText("Apellido Materno:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 784, -1, -1));

        txtTelefono.setBackground(new java.awt.Color(155, 164, 180));
        txtTelefono.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 896, 500, 78));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel6.setText("Telefono:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 897, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel8.setText("Fecha de Nacimiento");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 200, -1, -1));

        lbFecha.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbFecha.setText("DD/MM/YYYY");
        getContentPane().add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 108, -1, -1));

        lbHora.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        lbHora.setText("00:00:00");
        getContentPane().add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1700, 108, -1, -1));

        txtDate.setDateFormatString("YYYY/MM/dd");
        txtDate.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        getContentPane().add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 310, 190, 60));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 45)); // NOI18N
        jLabel1.setText("Registro de Usuarios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        FondoBlanco.setBackground(new java.awt.Color(204, 204, 204));
        FondoBlanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Blanco - RU.png"))); // NOI18N
        getContentPane().add(FondoBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1820, 980));

        FondoAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Azul.jpg"))); // NOI18N
        getContentPane().add(FondoAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        //int IDUsuario = Integer.parseInt(txtID.getText());
        String Usuario = txtUsuario.getText();
        String Nombre = txtNombre.getText();
        String Apellido_Materno = txtMaterno.getText();
        String Apellido_Paterno = txtPaterno.getText();
        String Contraseña = txtContrasena.getText();
        String Contraseña2 = txtConfirmacion.getText();
        String Telefono = txtTelefono.getText();
        //int Telefono = Integer.parseInt(txtTelefono.getText());
        //Date Fecha_Nacimiento = txtMes.getText();
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Usuarios (Nombre, ApellidoMaterno, ApellidoPaterno, Usuario, Contraseña, Telefono, FechaNacimiento) VALUES (?,?,?,?,HASHBYTES('SHA1',?),?,?)");
            ps.setString(1, Nombre);
            ps.setString(2, Apellido_Materno);
            ps.setString(3, Apellido_Paterno);
            ps.setString(4, Usuario);
            ps.setString(5, Contraseña);
            ps.setString(6, Telefono);
            ps.setString(7, ((JTextField)txtDate.getDateEditor().getUiComponent()).getText());
            if(Contraseña.equals(Contraseña2)){
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Tu Contraseña no coincide");
            }
            
            //ps.setInt(6, Telefono);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        habilitarBotonRegistrar();
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void txtContrasenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyReleased
        habilitarBotonRegistrar();
    }//GEN-LAST:event_txtContrasenaKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        habilitarBotonRegistrar();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtMaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaternoKeyReleased
        habilitarBotonRegistrar();
    }//GEN-LAST:event_txtMaternoKeyReleased

    private void txtPaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoKeyReleased
        habilitarBotonRegistrar();
    }//GEN-LAST:event_txtPaternoKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        habilitarBotonRegistrar();
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c != ' ')) evt.consume();
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Menu frame = new Menu();
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ')) evt.consume();
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ')) evt.consume();
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ')) evt.consume();
    }//GEN-LAST:event_txtPaternoKeyTyped

    private void txtMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaternoKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ')) evt.consume();
    }//GEN-LAST:event_txtMaternoKeyTyped

    public static String fecha(){
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }
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
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoAzul;
    private javax.swing.JLabel FondoBlanco;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbHora;
    private javax.swing.JPasswordField txtConfirmacion;
    private javax.swing.JPasswordField txtContrasena;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
