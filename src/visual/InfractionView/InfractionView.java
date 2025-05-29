/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package visual.InfractionView;

import models.Driver;
import models.Infraction;
import services.ServicesLocator;
import visual.CustomTable;
import visual.LicenseView.SelectLicense;
import visual.MainScreen.MainScreen;

import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author adian
 */
public class InfractionView extends javax.swing.JPanel {

    /**
     * Creates new form InfractionView
     */
    public InfractionView(MainScreen father) {
        initComponents(father);
    }
    private void initComponents(MainScreen father) {

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
        TitleLabel.setText("Gestion de Infracciones");
        add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 600, 40));

        SearchTextField.setBackground(new java.awt.Color(47, 50, 65));
        SearchTextField.setForeground(new java.awt.Color(153, 153, 153));
        SearchTextField.setText("Buscar infraccion...");
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
        add(SearchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, 230, 40));

        jLabel1.setBackground(new java.awt.Color(47, 50, 65));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-búsqueda-30.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 40, 40));

        AddDriversButton.setBackground(new java.awt.Color(232, 152, 70));
        AddDriversButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        AddDriversButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-más-30.png"))); // NOI18N
        AddDriversButton.setText("   Nueva Infraccion");
        AddDriversButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        SelectLicense dialog = new SelectLicense(father);
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
        add(AddDriversButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 50, 200, 40));



        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 215, 179));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-calendario-24.png"))); // NOI18N
        jLabel2.setText("Periodo:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 100, 40));

        List<String> columns = Arrays.asList(
                "Código", "Licencia", "Tipo",
                "Fecha", "Lugar", "Puntos", "Estado"
        );

        try {
            List<Infraction>driversBD = ServicesLocator.getInstance().getInfractionServices().getAllInfractions();
            Object[][] data =new Object[driversBD.size()][7];
            int pos=0;
            for (Infraction d : driversBD) {
                Object[] row = {d.getInfractionCode(),d.getLicenseId(),d.getViolationType(),d.getDate().toString(),d.getLocation(),"-"+d.getPoints(),d.getIspaid()};
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
                    int respuesta= JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar esta Infraccion?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(respuesta==0){
                        try{
                            ServicesLocator.getInstance().getInfractionServices().deleteInfraction(licenseID);
                            father.Actualizar(4);
                        }
                        catch(Exception e){

                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Selecione la Infraccion que desea eliminar antes de realizar esta accion");
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
                            String infractionId = finalCustomTable.getValueAt(selectedRow, 0).toString();
                            Infraction edit = ServicesLocator.getInstance().getInfractionServices().obtainInfraction(infractionId);
                            EditInfraction dialog = new EditInfraction(father, edit);
                            dialog.setLocationRelativeTo(null);
                            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                                @Override
                                public void windowClosing(java.awt.event.WindowEvent e) {
                                    System.exit(0);
                                }
                            });
                            dialog.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null, "Seleccione la infraction que desea editar");
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

    }//GEN-LAST:event_SearchTextFieldActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        SearchTextField.requestFocusInWindow();
        SearchTextField.setText("");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void AddDriversButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDriversButtonActionPerformed

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
