package visual.RelatedEntityView;

import models.RelatedEntity;
import services.ServicesLocator;
import visual.JtextFielCarnet;
import visual.MainScreen.MainScreen;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class AddRelatedEntity extends javax.swing.JDialog {

    /**
     * Creates new form AddRelatedEmtity
     */
    public AddRelatedEntity(MainScreen parent) {
        super(parent, true);
        initComponents(parent);
    }

    private void initComponents(MainScreen parent) {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        directorName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        entityName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        phone = new JtextFielCarnet();
        jLabel5 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        deletejButton = new javax.swing.JButton();
        AddjButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        entityType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 22, 28));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Añadir Entidad");
        jPanel1.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 210, 40));

        directorName.setBackground(new java.awt.Color(47, 50, 65));
        directorName.setForeground(new java.awt.Color(204, 204, 204));
        directorName.getCaret().setBlinkRate(500);
        directorName.setCaretColor(Color.lightGray);
        directorName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        directorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(directorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 230, 50));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 215, 179));
        jLabel2.setText("Tipo de entidad:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 110, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 215, 179));
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 60, 30));

        entityName.setBackground(new java.awt.Color(47, 50, 65));
        entityName.setForeground(new java.awt.Color(204, 204, 204));
        entityName.getCaret().setBlinkRate(500);
        entityName.setCaretColor(Color.lightGray);
        entityName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        entityName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetIDJTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(entityName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 230, 50));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 215, 179));
        jLabel4.setText("Direccion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, 30));

        address.setBackground(new java.awt.Color(47, 50, 65));
        address.setForeground(new java.awt.Color(204, 204, 204));
        address.getCaret().setBlinkRate(500);
        address.setCaretColor(Color.lightGray);
        address.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNamejTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 230, 50));

        phone.setBackground(new java.awt.Color(47, 50, 65));
        phone.setForeground(new java.awt.Color(204, 204, 204));
        phone.setLimite(8);
        phone.getCaret().setBlinkRate(500);
        phone.setCaretColor(Color.lightGray);
        phone.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 230, 50));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 215, 179));
        jLabel5.setText("Telefono:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 70, 30));

        correo.setBackground(new java.awt.Color(47, 50, 65));
        correo.setForeground(new java.awt.Color(204, 204, 204));
        correo.getCaret().setBlinkRate(500);
        correo.setCaretColor(Color.lightGray);
        correo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressjTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 230, 50));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 215, 179));
        jLabel6.setText("Correo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, 30));

        deletejButton.setForeground(new java.awt.Color(153, 0, 0));
        deletejButton.setText("Salir");
        deletejButton.setFocusable(false);
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deletejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 120, 40));

        AddjButton1.setBackground(new java.awt.Color(232, 152, 70));
        AddjButton1.setText("Añadir");
        AddjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name =entityName.getText();
                String gmail = correo.getText();
                String direccion = address.getText();
                String tel = phone.getText();
                String director = directorName.getText();
                String type = entityType.getSelectedItem().toString();
                if(!name.equals("") && !gmail.equals("") && !tel.equals("") && !direccion.equals("") && !type.equals("") && !director.equals("")) {
                    try {
                        //String entityName, String entityType, String address, String phone, String contactEmail,
                        //                         String directorName, String centerCode
                        ServicesLocator.getInstance().getRelatedEntityServices().createRelatedEntity(new RelatedEntity(name,type,direccion,tel,gmail,director,"JbL"));
                        parent.Actualizar(5);
                        dispose();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            }
        });
        jPanel1.add(AddjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 120, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 215, 179));
        jLabel7.setText("Nombre del Director");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, 30));

        entityType.setBackground(new java.awt.Color(47, 50, 65));
        entityType.setForeground(new java.awt.Color(255, 215, 179));
        entityType.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = super.createArrowButton();
                button.setBackground(new java.awt.Color(47, 50, 65)); // Fondo del botón desplegable
                button.setForeground(new java.awt.Color(255, 215, 179)); // Color de la flecha
                return button;
            }
        });
        entityType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Clinica","Auto Escuela"}));
        entityType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(entityType, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 230, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 540));

        pack();
    }// </editor-fold>

    private void phoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void carnetIDJTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void firstNamejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addressjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int respuesta=JOptionPane.showConfirmDialog(null, "Está seguro que desea cerrar esta ventana?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==0){
            dispose();
        }
    }

    private void AddjButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.JButton AddjButton1;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField entityName;
    private javax.swing.JButton deletejButton;
    private javax.swing.JTextField address;
    private javax.swing.JComboBox<String> entityType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private JtextFielCarnet phone;
    private javax.swing.JTextField directorName;
    // End of variables declaration
}
