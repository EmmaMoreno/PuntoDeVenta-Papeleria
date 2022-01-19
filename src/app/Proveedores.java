package app;

import Atxy2k.CustomTextField.RestrictedTextField;
import static app.Login.Fecha;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Grave
 */
public class Proveedores extends javax.swing.JFrame implements Runnable{
    DefaultTableModel modeloTabla = new DefaultTableModel();
    String hora,minutos,segundos;
    Thread hilo;

    public Proveedores() {
        initComponents();
        RestrictedTextField r= new RestrictedTextField(txtTelefono);
        r.setLimit(10);
        RestrictedTextField r2= new RestrictedTextField(txtTelefono);
        r2.setLimit(50);
        setLocationRelativeTo(null);
        txtId.setVisible(false);
        Fecha.setText(fecha());
        hilo = new Thread(this);
        hilo.start();
        habilitarBotonRegistrar();
        cargarTabla();
        
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
        if(!txtNombre.getText().isEmpty()&& !txtTelefono.getText().isEmpty()){
            btnRegistrar.setEnabled(true);
        }else{
            btnRegistrar.setEnabled(false);
        }
    }
    public void habilitarBotonModificar(){
        if(!txtNombre.getText().isEmpty()&& !txtTelefono.getText().isEmpty()){
            btnModificar.setEnabled(true);
        }else{
            btnModificar.setEnabled(false);
        }
    }
    public void habilitarBotonEliminar(){
        if(!txtNombre.getText().isEmpty()&& !txtTelefono.getText().isEmpty()){
            btnInactivar.setEnabled(true);
        }else{
            btnInactivar.setEnabled(false);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFiltro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();
        JActivo = new javax.swing.JComboBox<>();
        btnInactivar = new javax.swing.JButton();
        lbHora = new javax.swing.JLabel();
        FondoBlancoRProv = new javax.swing.JLabel();
        FondoBlancoListaRProv = new javax.swing.JLabel();
        FondoAzul = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1860, 30, 10, -1));

        btnModificar.setBackground(new java.awt.Color(57, 72, 103));
        btnModificar.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 860, 260, 120));

        btnRegistrar.setBackground(new java.awt.Color(9, 207, 0));
        btnRegistrar.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setEnabled(false);
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseExited(evt);
            }
        });
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 740, 260, 120));

        btnCancelar.setBackground(new java.awt.Color(215, 80, 56));
        btnCancelar.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 740, 260, 120));

        txtFiltro.setBackground(new java.awt.Color(155, 164, 180));
        txtFiltro.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        txtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroActionPerformed(evt);
            }
        });
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });
        getContentPane().add(txtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 390, 78));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel6.setText("BUSCAR:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 180, 30));

        txtNombre.setBackground(new java.awt.Color(155, 164, 180));
        txtNombre.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(1326, 338, 500, 78));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel8.setText("Nombre del Proveedor:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(851, 354, -1, -1));

        txtTelefono.setBackground(new java.awt.Color(155, 164, 180));
        txtTelefono.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(1326, 466, 500, 78));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel1.setText("Telefono del Proveedor:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(851, 482, 430, 50));

        Fecha.setFont(new java.awt.Font("Arial", 0, 35)); // NOI18N
        Fecha.setText("DD/MM/YYYY");
        getContentPane().add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 210, 220, 30));

        jLabel3.setBackground(new java.awt.Color(204, 204, 0));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 45)); // NOI18N
        jLabel3.setText("REGISTRO DE PROVEEDORES");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(851, 235, 690, 34));

        tblProveedores.setBackground(new java.awt.Color(241, 246, 249));
        tblProveedores.setFont(new java.awt.Font("Arial", 0, 26)); // NOI18N
        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Telefono", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProveedores.setRowHeight(30);
        tblProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblProveedoresMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 580, 640));

        JActivo.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        JActivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inactivo", "Activo", " " }));
        JActivo.setSelectedIndex(1);
        getContentPane().add(JActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 610, 190, 70));

        btnInactivar.setBackground(new java.awt.Color(255, 42, 27));
        btnInactivar.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        btnInactivar.setText("Inactivar");
        btnInactivar.setEnabled(false);
        btnInactivar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInactivarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInactivarMouseExited(evt);
            }
        });
        btnInactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInactivarActionPerformed(evt);
            }
        });
        getContentPane().add(btnInactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 860, 260, 120));

        lbHora.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        lbHora.setText("00:00:00");
        getContentPane().add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 250, 120, 40));

        FondoBlancoRProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Blanco - RProv.png"))); // NOI18N
        getContentPane().add(FondoBlancoRProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 190, 1060, -1));

        FondoBlancoListaRProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Blanco - Lista - RProv.png"))); // NOI18N
        getContentPane().add(FondoBlancoListaRProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        FondoAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Azul.jpg"))); // NOI18N
        getContentPane().add(FondoAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
            validarIngresosTabla();
            limpiar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tblProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedoresMouseClicked
        
        try{
            int fila = tblProveedores.getSelectedRow();
            int id = Integer.parseInt(tblProveedores.getValueAt(fila,0).toString());
            PreparedStatement ps;
            ResultSet rs;
            Connection con = Conexion.getConexion();
            ps = con.prepareStatement("SELECT NombreProveedor, TelefonoProveedor, Estado FROM Proveedores WHERE IDProveedor =?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                txtId.setText(String.valueOf(id));
                txtNombre.setText(rs.getString("NombreProveedor"));
                txtTelefono.setText(rs.getString("TelefonoProveedor"));
                JActivo.setSelectedIndex(rs.getByte("Estado"));
            }
            habilitarBotonModificar();
            habilitarBotonEliminar();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_tblProveedoresMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int id = Integer.parseInt(txtId.getText());
        String Nombre = txtNombre.getText();
        String Telefono = txtTelefono.getText();
        byte Estado = (byte) JActivo.getSelectedIndex();
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Proveedores SET NombreProveedor=?, TelefonoProveedor=?, Estado=? WHERE IDProveedor=?");
            ps.setString(1,Nombre);
            ps.setString(2,Telefono);
            ps.setByte(3, Estado);
            ps.setInt(4, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Modificado");
            limpiar();
            cargarTabla();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnInactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInactivarActionPerformed
         int id = Integer.parseInt(txtId.getText());
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Proveedores SET Estado = 0 WHERE IDProveedor = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Inactivado");
            limpiar();
            cargarTabla();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btnInactivarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Menu frame = new Menu();
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        habilitarBotonRegistrar();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        habilitarBotonRegistrar();
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void btnRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseEntered
        btnRegistrar.setBackground(new Color(30, 146, 24));
    }//GEN-LAST:event_btnRegistrarMouseEntered

    private void btnRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseExited
        btnRegistrar.setBackground(new Color(9, 207, 0));
    }//GEN-LAST:event_btnRegistrarMouseExited

    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        btnModificar.setBackground(new Color(20,39,78));
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        btnModificar.setBackground(new Color(57,72,103));
    }//GEN-LAST:event_btnModificarMouseExited

    private void btnInactivarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInactivarMouseEntered
        btnInactivar.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnInactivarMouseEntered

    private void btnInactivarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInactivarMouseExited
        btnInactivar.setBackground(new Color(255,42,27));
    }//GEN-LAST:event_btnInactivarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setBackground(new Color(255, 66, 0));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        btnCancelar.setBackground(new Color(215,80,56));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroActionPerformed
    TableRowSorter trs;
    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped
        
        char  c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) evt.consume();
        
        txtFiltro.addKeyListener(new KeyAdapter(){
            
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFiltro.getText(),1));
            }
        });
        trs = new TableRowSorter(tblProveedores.getModel());
        tblProveedores.setRowSorter(trs);
    }//GEN-LAST:event_txtFiltroKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
       char  c = evt.getKeyChar();
       if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && ( c != ' ')) evt.consume();
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char  c = evt.getKeyChar();
        if((c < '0' || c > '9') && ( c != ' '))  evt.consume();
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void tblProveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedoresMouseEntered
     //cargarTabla();
    }//GEN-LAST:event_tblProveedoresMouseEntered

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed
    
    private void limpiar(){
        txtId.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
    }
    
    private void cargarTabla(){
        modeloTabla = (DefaultTableModel) tblProveedores.getModel();
        modeloTabla.setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        
        int[] anchos = {10,50,50,50};
        for(int j = 0; j< tblProveedores.getColumnCount(); j++){
            tblProveedores.getColumnModel().getColumn(j).setPreferredWidth(anchos[j]);
        }
        
        try{
            Connection con = Conexion.getConexion();
            ps = con.prepareStatement("SELECT IDProveedor, NombreProveedor, TelefonoProveedor, Estado FROM Proveedores" );
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            
            while(rs.next()){
                Object[] fila = new Object[columnas];
                for(int i = 0; i < columnas; i++){
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    private void validarIngresosTabla(){
        String Nombre = txtNombre.getText();
        String Telefono = txtTelefono.getText();
        byte Estado = (byte) JActivo.getSelectedIndex();
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.prepareStatement("SELECT NombreProveedor, TelefonoProveedor FROM Proveedores WHERE NombreProveedor=? and TelefonoProveedor=?");
            ps.setString(1,Nombre);
            ps.setString(2, Telefono);
            rs = ps.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Usuario duplicado");
                limpiar();
            }else{
                ps = con.prepareStatement("INSERT INTO Proveedores(NombreProveedor, TelefonoProveedor,Estado) VALUES (?,?,?)");
                ps.setString(1,Nombre);
                ps.setString(2,Telefono);
                ps.setByte(3, Estado);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                cargarTabla();
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel FondoAzul;
    private javax.swing.JLabel FondoBlancoListaRProv;
    private javax.swing.JLabel FondoBlancoRProv;
    private javax.swing.JComboBox<String> JActivo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnInactivar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHora;
    private javax.swing.JTable tblProveedores;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
