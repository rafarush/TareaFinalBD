package visual.LicenseTypeView;

import models.LicenseCategory;
import services.ServicesLocator;
import visual.MainScreen.MainScreen;

import javax.swing.*;
import java.awt.*;

public class AddCategoryLicense extends javax.swing.JDialog {

    public AddCategoryLicense(MainScreen parent) {
        super(parent, true);
        initComponents(parent);
    }
    private void initComponents(MainScreen parent) {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        deletejButton = new javax.swing.JButton();
        AddjButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        licenseType = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        licenseCategory = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 22, 28));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Añadir Tipo-Categoria");
        jPanel1.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 320, 40));

        deletejButton.setForeground(new java.awt.Color(153, 0, 0));
        deletejButton.setText("Salir");
        deletejButton.setFocusable(false);
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deletejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 120, 40));

        AddjButton1.setBackground(new java.awt.Color(232, 152, 70));
        AddjButton1.setText("Añadir");
        AddjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               String type = licenseType.getText();
               String category = licenseCategory.getText();
               if (!type.isEmpty() && !category.isEmpty()) {
                   try{
                       ServicesLocator.getInstance().getLicenseCategoryServices().createLicenseCategory(new LicenseCategory(type, category));
                       parent.Actualizar(7);
                       dispose();
                   } catch (Exception e) {
                       JOptionPane.showMessageDialog(null, e.getMessage());
                   }
               }
            }
        });
        jPanel1.add(AddjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 120, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 215, 179));
        jLabel3.setText("Tipo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 60, 30));

        licenseType.setBackground(new java.awt.Color(47, 50, 65));
        licenseType.setForeground(new java.awt.Color(204, 204, 204));
        licenseType.getCaret().setBlinkRate(500);
        licenseType.setCaretColor(Color.lightGray);
        jPanel1.add(licenseType, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 230, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 215, 179));
        jLabel4.setText("Categoria:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, 30));

        licenseCategory.setBackground(new java.awt.Color(47, 50, 65));
        licenseCategory.setForeground(new java.awt.Color(204, 204, 204));
        licenseCategory.getCaret().setBlinkRate(500);
        licenseCategory.setCaretColor(Color.lightGray);
        jPanel1.add(licenseCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 230, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 310));

        pack();
    }// </editor-fold>

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int respuesta= JOptionPane.showConfirmDialog(null, "Está seguro que desea cerrar esta ventana?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==0){
            dispose();
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton AddjButton1;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JButton deletejButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField licenseCategory;
    private javax.swing.JTextField licenseType;
    // End of variables declaration
}