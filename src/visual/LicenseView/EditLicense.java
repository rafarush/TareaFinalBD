package visual.LicenseView;

import models.InfractionType;
import models.License;
import models.LicenseCategory;
import models.LicenseStatus;
import services.ServicesLocator;
import visual.MainScreen.MainScreen;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EditLicense extends javax.swing.JDialog {

    public EditLicense(MainScreen parent, License edit) {
        super(parent, true);
        initComponents(parent,edit);
    }
    private void initComponents(MainScreen parent, License edit) {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        restricciones = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        licenseType = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        driverId = new javax.swing.JLabel();
        driverName = new javax.swing.JLabel();
        AddjButton1 = new javax.swing.JButton();
        deletejButton = new javax.swing.JButton();
        LicenseID = new javax.swing.JTextField();
        estatus = new javax.swing.JComboBox<>();
        jLabel90 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 22, 28));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Editar Licencia");
        jPanel1.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 260, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 215, 179));
        jLabel3.setText("Tipo de Licencia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        restricciones.setBackground(new java.awt.Color(47, 50, 65));
        restricciones.setForeground(new java.awt.Color(204, 204, 204));
        restricciones.setText(edit.getRestrictions());
        restricciones.getCaret().setBlinkRate(500);
        restricciones.setCaretColor(Color.lightGray);
        restricciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetIDJTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(restricciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 230, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 215, 179));
        jLabel5.setText("Nombre del conductor:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 215, 179));
        jLabel6.setText("Restricciones");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 215, 179));
        jLabel7.setText("ID de la Licencia:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        licenseType.setBackground(new java.awt.Color(47, 50, 65));
        licenseType.setForeground(new java.awt.Color(204, 204, 204));
        licenseType.setEnabled(false);
        licenseType.setText(edit.getLicenseType());
        jPanel1.add(licenseType, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 230, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 215, 179));
        jLabel8.setText("ID del conductor:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        driverId.setForeground(new java.awt.Color(255, 215, 179));
        driverId.setText(edit.getDriverId());
        jPanel1.add(driverId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 230, 40));

        driverName.setForeground(new java.awt.Color(255, 215, 179));
        driverName.setText(ServicesLocator.getInstance().getDriverServices().obtainDriver(edit.getDriverId()).getFirstName());
        jPanel1.add(driverName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 230, 40));

        jLabel90.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 215, 179));
        jLabel90.setText("Estado:");
        jPanel1.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, -1));

        estatus.setBackground(new java.awt.Color(47, 50, 65));
        estatus.setForeground(new java.awt.Color(204, 204, 204));
        estatus.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = super.createArrowButton();
                button.setBackground(new java.awt.Color(47, 50, 65));
                button.setForeground(new java.awt.Color(255, 215, 179));
                return button;
            }
        });
        List<LicenseStatus> type = ServicesLocator.getInstance().getLicenseStatusServices().getAllLicenseStatuses();
        ArrayList<String> list = new ArrayList<>();
        for (LicenseStatus ls : type) {
            list.add(ls.getLicenseStatus());
        }
        String[] arr = list.toArray(new String[list.size()]);
        estatus.setModel(new javax.swing.DefaultComboBoxModel<>(arr));
        estatus.setEnabled(false);
        jPanel1.add(estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 230, 40));

        AddjButton1.setBackground(new java.awt.Color(232, 152, 70));
        AddjButton1.setText("Editar");
        AddjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String restric = restricciones.getText().equals("") ? edit.getLicenseType() : restricciones.getText();
                String status = estatus.getSelectedItem().toString();
                try{
                    //String licenseId, String driverId, String licenseType, Date issueDate, Date expirationDate,
                    //                   String restrictions, boolean renewed, String licenseStatus
                    ServicesLocator.getInstance().getLicenseServices().updateLicense(new License(edit.getLicenseId(), edit.getDriverId(), edit.getLicenseType(), edit.getIssueDate(),edit.getExpirationDate(),restric,edit.isRenewed(),status));
                    parent.Actualizar(2);
                    dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });
        jPanel1.add(AddjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 120, 30));

        deletejButton.setForeground(new java.awt.Color(153, 0, 0));
        deletejButton.setText("Salir");
        deletejButton.setFocusable(false);
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deletejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 120, 30));

        LicenseID.setBackground(new java.awt.Color(47, 50, 65));
        LicenseID.setForeground(new java.awt.Color(204, 204, 204));
        LicenseID.setText(edit.getLicenseId());
        LicenseID.setEnabled(false);
        jPanel1.add(LicenseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 230, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 610));

        pack();
    }// </editor-fold>

    private void carnetIDJTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void carnetIDJTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void AddjButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int respuesta= JOptionPane.showConfirmDialog(null, "Está seguro que desea cerrar esta ventana?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==0){
            dispose();
        }
    }

    private void carnetIDJTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private javax.swing.JButton AddjButton1;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField restricciones;
    private javax.swing.JTextField licenseType;
    private javax.swing.JTextField LicenseID;
    private javax.swing.JComboBox<String> estatus;
    private javax.swing.JButton deletejButton;
    private javax.swing.JLabel driverId;
    private javax.swing.JLabel driverName;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}