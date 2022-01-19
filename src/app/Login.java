/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Grave
 */
public class Login extends javax.swing.JFrame implements Runnable{
    String hora,minutos,segundos;
    Thread hilo;

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        RestrictedTextField r= new RestrictedTextField(txtUsuario);
        r.setLimit(70);
        RestrictedTextField r2= new RestrictedTextField(txtPassword);
        r2.setLimit(70);
        Fecha.setText(Fecha());
        hilo = new Thread(this);
        hilo.start();
    }
    //!String.valueOf(txtPassword.getPassword()).isEmpty()
    public void habilitarBotonRegistrar(){
        if(!txtUsuario.getText().isEmpty() && !txtPassword.getText().isEmpty()){
            btnEntrar.setEnabled(true);
        }else{
            btnEntrar.setEnabled(false);
        }
    }
    public static String Fecha(){
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEntrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        Nombre = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        Contraseña = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        FondoBlancoLogin = new javax.swing.JLabel();
        FondoAzul = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEntrar.setBackground(new java.awt.Color(61, 199, 105));
        btnEntrar.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        btnEntrar.setText("ENTRAR");
        btnEntrar.setEnabled(false);
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarMouseEntered(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 675, 260, 120));

        btnCancelar.setBackground(new java.awt.Color(215, 80, 56));
        btnCancelar.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 673, 260, 120));

        txtUsuario.setBackground(new java.awt.Color(155, 164, 180));
        txtUsuario.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        txtUsuario.setPreferredSize(new java.awt.Dimension(452, 78));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(951, 400, 452, 78));

        Nombre.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        Nombre.setText("Nombre de Usuario: ");
        getContentPane().add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 415, -1, 30));

        txtPassword.setBackground(new java.awt.Color(155, 164, 180));
        txtPassword.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(951, 528, 452, 78));

        Contraseña.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        Contraseña.setText("Contraseña: ");
        getContentPane().add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 544, -1, -1));

        titulo.setFont(new java.awt.Font("Arial", 0, 45)); // NOI18N
        titulo.setText("Inicio de Sesión");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, 60));

        Fecha.setBackground(new java.awt.Color(0, 0, 0));
        Fecha.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        Fecha.setText("DD/MM/YYYY");
        getContentPane().add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 250, -1, 50));

        lbHora.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        lbHora.setText("00:00:00");
        getContentPane().add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 260, -1, -1));

        FondoBlancoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Blanco - Login.png"))); // NOI18N
        getContentPane().add(FondoBlancoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 225, 960, 630));

        FondoAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Azul.jpg"))); // NOI18N
        getContentPane().add(FondoAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        habilitarBotonRegistrar();
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        btnCancelar.setBackground(new Color(215,80,56));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setBackground(new Color(255, 66, 0));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

        String Usuario = txtUsuario.getText();
        String Contraseña = txtPassword.getText();
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.prepareStatement("SELECT Nombre, Contraseña FROM Usuarios WHERE Usuario=? and Contraseña=HASHBYTES('SHA1',?)");
            ps.setString(1,Usuario);
            ps.setString(2, Contraseña);
            rs = ps.executeQuery();

            if(rs.next()){
                Menu frame = new Menu();
                frame.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta");
                txtUsuario.setText("");
                txtPassword.setText("");
            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }

        /*String Usuario = txtNombre.getText();
        char[] Contraseña = txtPassword.getPassword();

        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT Nombre, Contraseña FROM Usuarios WHERE Nombre =? and Contraseña =?");
            ps.setString(1,Usuario);
            ps.setString(2, String.valueOf(Contraseña));
            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "ENTRANDO...");
            Proveedores pro = new Proveedores();
            pro.setVisible(true);
            dispose();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }*/
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseExited
        btnEntrar.setBackground(new Color(9, 207, 0));
    }//GEN-LAST:event_btnEntrarMouseExited

    private void btnEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseEntered
        btnEntrar.setBackground(new Color(30, 146, 24));
    }//GEN-LAST:event_btnEntrarMouseEntered

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        habilitarBotonRegistrar();
    }//GEN-LAST:event_txtPasswordKeyReleased

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contraseña;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel FondoAzul;
    private javax.swing.JLabel FondoBlancoLogin;
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel titulo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
