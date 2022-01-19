/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Atxy2k.CustomTextField.RestrictedTextField;
import static app.Login.Fecha;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grave
 */
public class AgendarPago extends javax.swing.JFrame implements Runnable {
 DefaultTableModel modeloTabla = new DefaultTableModel();
   Calendar hora1 = new GregorianCalendar();
   String hora,minutos,segundos;
    Thread hilo;
    
    public AgendarPago() {
        initComponents();
        btnAgendar.setEnabled(false);
        RestrictedTextField r= new RestrictedTextField(txtMonto);
        r.setLimit(10);
        RestrictedTextField r2= new RestrictedTextField(txtDescripcion);
        r2.setLimit(30);
        setLocationRelativeTo(null);
        BoxProveedor.setModel(Llenar());
        Fecha.setText(Fecha());
        hilo = new Thread(this);
        hilo.start();
        
    }
    public void habilitarBotonAgendar(){
        if(!txtMonto.getText().isEmpty()&& !txtDescripcion.getText().isEmpty()){
            btnAgendar.setEnabled(true);
        }else{
            btnAgendar.setEnabled(false);
        }
    }

    public void hora(){
        Calendar calendario = new GregorianCalendar();
        java.util.Date horaactual = new java.util.Date();
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
                Hora.setText(hora+":"+minutos+":"+segundos);
            }
        }
    }
    private void limpiar(){
        txtId.setText("");
        ((JTextField)txtFecha.getDateEditor().getUiComponent()).setText("");
        txtMonto.setText("");
        txtDescripcion.setText("");
        BoxProveedor.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDescripcion = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAgendar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BoxProveedor = new javax.swing.JComboBox<>();
        Hora = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDescripcion.setBackground(new java.awt.Color(155, 164, 180));
        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 490, 400, 58));

        txtMonto.setBackground(new java.awt.Color(155, 164, 180));
        txtMonto.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoKeyReleased(evt);
            }
        });
        getContentPane().add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 400, 58));

        btnCancelar.setBackground(new java.awt.Color(215, 80, 56));
        btnCancelar.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 680, 250, 78));

        btnAgendar.setBackground(new java.awt.Color(61, 199, 105));
        btnAgendar.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 580, 250, 78));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel6.setText("Descripción:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, 240, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel3.setText("Monto a Pagar:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel1.setText("Proveedor:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 600, -1, -1));

        BoxProveedor.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        BoxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(BoxProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 310, 400, 58));

        Hora.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        Hora.setText("00:00:00");
        getContentPane().add(Hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 190, -1, -1));

        Fecha.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        Fecha.setText("DD/MM/YYYY");
        getContentPane().add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 180, 200, 50));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 45)); // NOI18N
        jLabel2.setText("Agendar Pago");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 320, -1));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 170, 10, -1));

        txtFecha.setDateFormatString("YYYY/MM/dd");
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 600, 170, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Blanco - Login.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 960, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Azul.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jLabel7.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel5.setText("Hora:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 570, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        int Proveedores = BoxProveedor.getSelectedIndex() + 1;
        int Monto = Integer.parseInt(txtMonto.getText());
        String Descripcion = txtDescripcion.getText();

        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Pagos(Fecha,Monto,Descripcion,Estado,FIDProveedor) VALUES (?,?,?,?,?)");
            ps.setString(1, ((JTextField)txtFecha.getDateEditor().getUiComponent()).getText());
            ps.setInt(2,Monto);
            ps.setString(3,Descripcion);
            ps.setByte(4, (byte)0);
            ps.setInt(5,Proveedores);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pago Agendado");

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        limpiar();
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void BoxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxProveedorActionPerformed

    }//GEN-LAST:event_BoxProveedorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Menu frame = new Menu();
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        char  c = evt.getKeyChar();
        if((c < '0' || c > '9') && ( c != ' '))  evt.consume();
    }//GEN-LAST:event_txtMontoKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        char  c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && ( c != ' ')) evt.consume();
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtMontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyReleased
        habilitarBotonAgendar();
    }//GEN-LAST:event_txtMontoKeyReleased

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        habilitarBotonAgendar();
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFechaPropertyChange
        if(!((JTextField)txtFecha.getDateEditor().getUiComponent()).getText().isEmpty()){
            btnAgendar.setEnabled(false);
        }else{
            btnAgendar.setEnabled(true);
        }
    }//GEN-LAST:event_txtFechaPropertyChange

    public DefaultComboBoxModel Llenar(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            Connection con = Conexion.getConexion();
            ps = con.prepareStatement("SELECT NombreProveedor FROM Proveedores" );
            rs = ps.executeQuery();
            
            while(rs.next()){
                modelo.addElement(rs.getString("NombreProveedor"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return modelo;
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
            java.util.logging.Logger.getLogger(AgendarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendarPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxProveedor;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel Hora;
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtDescripcion;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
