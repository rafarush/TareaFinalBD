/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package visual.LicenseView;

import models.License;
import services.ServicesLocator;

import visual.CustomTable;
import visual.DriverView.AddDriver;
import visual.DriverView.SelectDriver;
import visual.MainScreen.MainScreen;

import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author adian
 */
public class LicensView extends javax.swing.JPanel {

    /**
     * Creates new form LicensView
     */
    public LicensView(MainScreen father) {
        initComponents(father);
    }
    private void setupTable() {
        // 1. Configurar datos
        List<String> columns = Arrays.asList(
                "Código", "Conductor", "Tipo",
                "Emision", "Vencimiento", "Estado"
        );

        try {
            List<License>driversBD = ServicesLocator.getInstance().getLicenseServices().getAllLicensesWithDriverName();
            Object[][] data =new Object[driversBD.size()][6];
            int pos=0;
            for (License d : driversBD) {
                Object[] row = {d.getLicenseId(),d.getDriverId(),d.getLicenseType(),d.getIssueDate().toString(),d.getExpirationDate().toString(),d.getLicenseStatus()};
                data[pos]=row;
                pos++;
            }
            CustomTable customTable = getCustomTable(columns, data);
            customTable.getTableHeader().setReorderingAllowed(false);

            // 4. Asignar al scroll pane
            jScrollPane2.setViewportView(customTable);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private CustomTable getCustomTable(List<String> columns, Object[][] data) {
        CustomTable customTable = new CustomTable(columns, data);


        // 2. Crear tabla personalizada


        // 3. Configurar acción al hacer doble click
        customTable.setRowDoubleClickListener(row -> {
            String info = "Información de la Licencia:\n\n" +
                    "Código: " + customTable.getValueAt(row, 0) + "\n" +
                    "Conductor: " + customTable.getValueAt(row, 1) + "\n" +
                    "Tipo: " + customTable.getValueAt(row, 2) + "\n" +
                    "Emision: " + customTable.getValueAt(row, 3) + "\n" +
                    "Vencimiento: " + customTable.getValueAt(row, 4) + "\n" +
                    "Estado: " + customTable.getValueAt(row, 5);

            JOptionPane.showMessageDialog(
                    this,
                    info,
                    "Detalles de la Licencia",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });
        return customTable;
    }

    private void initComponents(MainScreen parent) {

        TitleLabel = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        AddDriversButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        DeleteButton = new javax.swing.JButton();
        EditJButton = new javax.swing.JButton();
        CustomTable customTable = new CustomTable();


        setBackground(new java.awt.Color(23, 22, 28));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Gestion de Licencias");
        add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 600, 40));

        SearchTextField.setBackground(new java.awt.Color(47, 50, 65));
        SearchTextField.setForeground(new java.awt.Color(153, 153, 153));
        SearchTextField.setText("Buscar Licencia...");
        SearchTextField.setBorder(null);
        SearchTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchTextFieldMouseClicked(evt);
            }
        });
        SearchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextFieldActionPerformed(evt);
            }
        });
        add(SearchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 230, 40));


        jLabel1.setBackground(new java.awt.Color(47, 50, 65));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-búsqueda-30.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 40, 40));


        AddDriversButton.setBackground(new java.awt.Color(232, 152, 70));
        AddDriversButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        AddDriversButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-más-30.png"))); // NOI18N
        AddDriversButton.setText("   Nueva Licencia");
        AddDriversButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {

                        SelectDriver dialog = new SelectDriver(parent,1);

                        dialog.setLocationRelativeTo(null);
                        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                            @Override
                            public void windowClosing(java.awt.event.WindowEvent e) {
                                System.exit(0);
                            }
                        });
                        dialog.setVisible(true);
                    }
                });
            }
        });
        add(AddDriversButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 60, 200, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 215, 179));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-calendario-24.png"))); // NOI18N
        jLabel2.setText("Periodo:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 100, 40));

        List<String> columns = Arrays.asList(
                "Código", "Conductor", "Tipo",
                "Emision", "Vencimiento", "Estado"
        );

        try {
            List<License>driversBD = ServicesLocator.getInstance().getLicenseServices().getAllLicensesWithDriverName();
            Object[][] data =new Object[driversBD.size()][6];
            int pos=0;
            for (License d : driversBD) {
                Object[] row = {d.getLicenseId(),d.getDriverId(),d.getLicenseType(),d.getIssueDate().toString(),d.getExpirationDate().toString(),d.getLicenseStatus()};
                data[pos]=row;
                pos++;
            }
            customTable = new CustomTable(columns, data);
            customTable.getTableHeader().setReorderingAllowed(false);
            jScrollPane2.setViewportView(customTable);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        DeleteButton.setBackground(new java.awt.Color(204, 0, 0));
        DeleteButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/Icons/icons8-borrar-para-siempre-30.png"))); // NOI18N
        DeleteButton.setText("Eliminar");
        CustomTable finalCustomTable = customTable;
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int selectedRow = finalCustomTable.getSelectedRow();
                if (selectedRow != -1) {
                    String licenseID = finalCustomTable.getValueAt(selectedRow, 0).toString();
                    int respuesta= JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este examen?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(respuesta==0){
                        try{
                            ServicesLocator.getInstance().getLicenseServices().deleteLicense(licenseID);
                            parent.Actualizar(2);
                        }
                        catch(Exception e){

                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Selecione la Licencia que desea eliminar antes de realizar esta accion");
                }
            }
        });
        add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 130, 140, 40));

        EditJButton.setBackground(new java.awt.Color(255, 204, 0));
        EditJButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        EditJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/Icons/icons8-pencil-30.png"))); // NOI18N
        EditJButton.setText("   Editar");
        EditJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        int selectedRow = finalCustomTable.getSelectedRow();
                        if (selectedRow != -1) {
                            String licenseID = finalCustomTable.getValueAt(selectedRow, 0).toString();
                            License edit = ServicesLocator.getInstance().getLicenseServices().obtainLicense(licenseID);
                            EditLicense dialog = new EditLicense(parent,edit);
                            dialog.setLocationRelativeTo(null);
                            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                                @Override
                                public void windowClosing(java.awt.event.WindowEvent e) {
                                    System.exit(0);
                                }
                            });
                            dialog.setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Seleccione la licencia que desea editar");
                        }
                    }
                });
            }
        });
        add(EditJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, 140, 40));



        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 1250, 690));

    }// </editor-fold>//GEN-END:initComponents

    private void SearchTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchTextFieldMouseClicked
        SearchTextField.setText("");
    }//GEN-LAST:event_SearchTextFieldMouseClicked

    private void SearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextFieldActionPerformed

    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        SearchTextField.requestFocusInWindow();
        SearchTextField.setText("");
    }

    private void AddDriversButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }
    private javax.swing.JButton AddDriversButton;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditJButton;
}
