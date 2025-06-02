package visual.LicenseView;
import models.Driver;
import models.License;
import services.ServicesLocator;
import visual.MainScreen.MainScreen;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class AddLicense extends javax.swing.JDialog {

    public AddLicense(MainScreen parent, Driver driver) {
        super(parent, true);
        initComponents(driver,parent);
    }


    private void initComponents(Driver driver,MainScreen parent) {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        carnetIDJTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        carnetIDJTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        AddjButton1 = new javax.swing.JButton();
        deletejButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(23, 22, 28));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Añadir Licencia");
        jPanel1.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 260, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 215, 179));
        jLabel3.setText("Tipo de Licencia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        carnetIDJTextField1.setBackground(new java.awt.Color(47, 50, 65));
        carnetIDJTextField1.setForeground(new java.awt.Color(204, 204, 204));
        carnetIDJTextField1.getCaret().setBlinkRate(500);
        carnetIDJTextField1.setCaretColor(Color.lightGray);
        carnetIDJTextField1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        carnetIDJTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetIDJTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(carnetIDJTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 500, 40));

        //jComboBox1.setBackground(new java.awt.Color(47, 50, 65));
        jComboBox1.setForeground(new java.awt.Color(255, 215, 179));
        jComboBox1.setBackground(new java.awt.Color(47, 50, 65));
        jComboBox1.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = super.createArrowButton();
                button.setBackground(new java.awt.Color(47, 50, 65)); // Fondo del botón desplegable
                button.setForeground(new java.awt.Color(255, 215, 179)); // Color de la flecha
                return button;
            }
        });
        ArrayList<String> licenseDriver = new ArrayList<String>();
        try{
            licenseDriver= (ArrayList<String>) ServicesLocator.getInstance().getDriverServices().getValidLicenses(driver.getDriverId());

            if(licenseDriver.size()>0){
                String[] driverLicense = licenseDriver.toArray(new String[licenseDriver.size()]);
                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(driverLicense));
            }
            else{
                JOptionPane.showMessageDialog(null, "El chofer ya cuenta con todas las licencias por lo tanto no se puede crear una nueva licencia de este conductor");
                dispose();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 230, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 215, 179));
        jLabel5.setText("Nombre del conductor:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 215, 179));
        jLabel6.setText("Restricciones");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 215, 179));
        jLabel7.setText("ID de la Licencia:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        carnetIDJTextField3.setBackground(new java.awt.Color(47, 50, 65));
        carnetIDJTextField3.setForeground(new java.awt.Color(204, 204, 204));
        carnetIDJTextField3.getCaret().setBlinkRate(500);
        carnetIDJTextField3.setCaretColor(Color.lightGray);
        carnetIDJTextField3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        carnetIDJTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetIDJTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(carnetIDJTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 215, 179));
        jLabel8.setText("ID del conductor:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 215, 179));
        jLabel1.setText(driver.getDriverId());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 230, 40));

        jLabel2.setForeground(new java.awt.Color(255, 215, 179));
        jLabel2.setText(driver.getFirstName()+" "+driver.getLastName());
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 230, 40));

        jLabel4.setForeground(new java.awt.Color(255, 215, 179));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 230, 40));

        AddjButton1.setBackground(new java.awt.Color(232, 152, 70));
        AddjButton1.setText("Añadir");
        AddjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //String licenseId, String driverId, String licenseType, Date issueDate, Date expirationDate,
                //                   String restrictions, boolean renewed, String licenseStatus
                String idLicense=carnetIDJTextField3.getText();
                String licenseType=jComboBox1.getSelectedItem().toString();
                String restricciones=carnetIDJTextField1.getText();
                if(!Objects.equals(idLicense, "") && !Objects.equals(licenseType, "") && !Objects.equals(restricciones, "")){
                    try {
                        LocalDate createDate=LocalDate.now();
                        Date creact=Date.valueOf(LocalDate.now());
                        Date expirationDate=Date.valueOf(LocalDate.now().plusYears(10));
                        ServicesLocator.getInstance().getLicenseServices().createLicense(new License(idLicense,driver.getDriverId(),licenseType,creact,expirationDate,restricciones,false,"Vigente"));
                        parent.Actualizar(2);
                        dispose();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,"Verifique que el codigo de la licencia no este repetido");
                    }
                }
            }
        });
        jPanel1.add(AddjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 120, 30));

        deletejButton.setForeground(new java.awt.Color(153, 0, 0));
        deletejButton.setText("Salir");
        deletejButton.setFocusable(false);
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deletejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 610));

        pack();
    }// </editor-fold>

    private void carnetIDJTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void carnetIDJTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void AddjButton1ActionPerformed(java.awt.event.ActionEvent evt, Driver driver, MainScreen father) {

    }
    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int respuesta= JOptionPane.showConfirmDialog(null, "Está seguro que desea cerrar esta ventana?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==0){
            dispose();
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JButton AddjButton1;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField carnetIDJTextField1;
    private javax.swing.JTextField carnetIDJTextField3;
    private javax.swing.JButton deletejButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}