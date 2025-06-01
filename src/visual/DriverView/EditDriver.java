package visual.DriverView;

import models.Driver;
import services.ServicesLocator;
import utils.Validations;
import visual.MainScreen.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class EditDriver extends javax.swing.JDialog {

    public EditDriver(MainScreen parent, Driver edit) {
        super(parent, true);
        initComponents(parent,edit);
    }

    private void initComponents(MainScreen parent, Driver edit) {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        carnetIDJTextField1 = new javax.swing.JTextField();
        emailjTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        firstNamejTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addressjTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        deletejButton = new javax.swing.JButton();
        AddjButton1 = new javax.swing.JButton();
        deletejButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 22, 28));
        setUndecorated(true);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Editor Conductor");
        jPanel1.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 260, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 215, 179));
        jLabel1.setText("Correo: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        phoneTextField.setBackground(new java.awt.Color(47, 50, 65));
        phoneTextField.setForeground(new java.awt.Color(204, 204, 204));
        phoneTextField.setText(edit.getPhone());
        phoneTextField.getCaret().setBlinkRate(500);
        phoneTextField.setCaretColor(Color.lightGray);
        phoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 230, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 215, 179));
        jLabel2.setText("Teléfono:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 215, 179));
        jLabel3.setText("Carnet de Identidad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        carnetIDJTextField1.setBackground(new java.awt.Color(47, 50, 65));
        carnetIDJTextField1.setText(edit.getDriverId());
        carnetIDJTextField1.setForeground(new java.awt.Color(204, 204, 204));
        carnetIDJTextField1.setEnabled(false);
        carnetIDJTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetIDJTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(carnetIDJTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 230, 40));

        emailjTextField.setBackground(new java.awt.Color(47, 50, 65));
        emailjTextField.setForeground(new java.awt.Color(204, 204, 204));
        emailjTextField.setText(edit.getEmail());
        emailjTextField.getCaret().setBlinkRate(500);
        emailjTextField.setCaretColor(Color.lightGray);
        emailjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailjTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(emailjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 230, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 215, 179));
        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        firstNamejTextField.setBackground(new java.awt.Color(47, 50, 65));
        firstNamejTextField.setForeground(new java.awt.Color(204, 204, 204));
        firstNamejTextField.setText(edit.getFirstName());
        firstNamejTextField.getCaret().setBlinkRate(500);
        firstNamejTextField.setCaretColor(Color.lightGray);
        firstNamejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNamejTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(firstNamejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 230, 40));

        lastNameTextField.setBackground(new java.awt.Color(47, 50, 65));
        lastNameTextField.setForeground(new java.awt.Color(204, 204, 204));
        lastNameTextField.setText(edit.getLastName());
        lastNameTextField.getCaret().setBlinkRate(500);
        lastNameTextField.setCaretColor(Color.lightGray);
        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(lastNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 230, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 215, 179));
        jLabel5.setText("Apellido:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        addressjTextField.setBackground(new java.awt.Color(47, 50, 65));
        addressjTextField.setForeground(new java.awt.Color(204, 204, 204));
        addressjTextField.setText(edit.getAddress());
        addressjTextField.getCaret().setBlinkRate(500);
        addressjTextField.setCaretColor(Color.lightGray);
        addressjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressjTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(addressjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 230, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 215, 179));
        jLabel6.setText("Dirección:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        deletejButton.setForeground(new java.awt.Color(153, 0, 0));
        deletejButton.setText("Salir");
        deletejButton.setFocusable(false);
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deletejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 120, 30));

        AddjButton1.setBackground(new java.awt.Color(232, 152, 70));
        AddjButton1.setText("Editar");
        AddjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int respuesta = JOptionPane.showConfirmDialog(null, "Está seguro que desea Editar a este chofer?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (respuesta == 0) {
                String firstName = Objects.equals(firstNamejTextField.getText(), "") ? edit.getFirstName() : firstNamejTextField.getText();
                String lastName = Objects.equals(lastNameTextField.getText(), "") ? edit.getLastName() : lastNameTextField.getText();
                String email = Objects.equals(emailjTextField.getText(), "") ? edit.getEmail() : emailjTextField.getText();
                String phone = Objects.equals(phoneTextField.getText(), "") ? edit.getPhone() : phoneTextField.getText();
                String address = Objects.equals(addressjTextField.getText(), "") ? edit.getAddress() : addressjTextField.getText();
                try {
                    //String driverId, String firstName, String lastName, Date birthDate,
                    //                  String address, String phone, String email
                    Validations.validateEmail(email);
                    ServicesLocator.getInstance().getDriverServices().updateDriver(new Driver(edit.getDriverId(), firstName, lastName, edit.getBirthDate(), address, phone, email));
                    parent.Actualizar(1);
                    dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            }
        });
        jPanel1.add(AddjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 120, 30));

        deletejButton1.setForeground(new java.awt.Color(153, 0, 0));
        deletejButton1.setText("Salir");
        deletejButton1.setFocusable(false);
        deletejButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(deletejButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void phoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void carnetIDJTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void emailjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
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
        int respuesta= JOptionPane.showConfirmDialog(null, "Está seguro que desea cerrar esta ventana?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==0){
            dispose();
        }
    }

    private void AddjButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void deletejButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.JButton AddjButton1;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField addressjTextField;
    private javax.swing.JTextField carnetIDJTextField1;
    private javax.swing.JButton deletejButton;
    private javax.swing.JButton deletejButton1;
    private javax.swing.JTextField emailjTextField;
    private javax.swing.JTextField firstNamejTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTextField phoneTextField;
    // End of variables declaration
}

