/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/visualForms/JPanel.java to edit this template
 */
package visual.ExamView;

import models.Driver;
import models.Test;
import services.ServicesLocator;
import visual.CustomTable;
import visual.DriverView.SelectDriver;
import visual.MainScreen.MainScreen;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author adian
 */
public class ExamView extends javax.swing.JPanel {

    /**
     * Creates new form ExamView
     */
    public ExamView(MainScreen father) {
        initComponents(father);
    }
    private void initComponents(MainScreen father) {

        TitleLabel = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        AddDriversButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CustomTable customTable = new CustomTable();
        DeleteButton = new javax.swing.JButton();
        EditJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(23, 22, 28));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Gestion de Exámenes");
        add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 600, 40));

        SearchTextField.setBackground(new java.awt.Color(47, 50, 65));
        SearchTextField.setForeground(new java.awt.Color(153, 153, 153));
        SearchTextField.setText("Buscar examen...");
        SearchTextField.getCaret().setBlinkRate(500);
        SearchTextField.setCaretColor(Color.lightGray);
        SearchTextField.setBorder(null);
        add(SearchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 230, 40));


        jLabel1.setBackground(new java.awt.Color(47, 50, 65));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/Icons/icons8-búsqueda-30.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 40, 40));


        AddDriversButton.setBackground(new java.awt.Color(232, 152, 70));
        AddDriversButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        AddDriversButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/Icons/icons8-más-30.png"))); // NOI18N
        AddDriversButton.setText("   Nuevo Examen");
        AddDriversButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        SelectDriver dialog = new SelectDriver(father,2);
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

        // 1. Configurar datos
        List<String> columns = Arrays.asList(
                "Código","Conductor","Tipo",
                "Fecha", "Entidad", "Examinador", "Resultado"
        );

        try {
            List<Test>testBD = ServicesLocator.getInstance().getTestServices().getAllTestsWithDriverName();
            Object[][] data =new Object[testBD.size()][7];
            int pos=0;
            for (Test d : testBD) {
                Object[] row = {d.getTestCode(),d.getDriverId(),d.getTestType(),d.getDate().toString(),d.getEntityName(),d.getExaminerName(),d.getResult()==true? "Aprobado":"Reprobado"};
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
        tableSorter = new TableRowSorter<>((DefaultTableModel) customTable.getModel());
        SearchTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchTextFieldMouseClicked(evt);
            }
        });
        SearchTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar()=='\n'){
                    String aux = SearchTextField.getText();
                    if(aux.trim().length()==0){
                        tableSorter.setRowFilter(null);
                        finalCustomTable.setRowSorter(tableSorter);
                    }else{
                        tableSorter.setRowFilter(RowFilter.regexFilter("(?i)"+aux));
                        finalCustomTable.setRowSorter(tableSorter);
                    }
                }
            }
        });
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int selectedRow = finalCustomTable.getSelectedRow();
                if (selectedRow != -1) {
                    String testID = finalCustomTable.getValueAt(selectedRow, 0).toString();
                    int respuesta= JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este Chofer?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(respuesta==0){
                        try{
                            ServicesLocator.getInstance().getTestServices().deleteTest(testID);
                            father.Actualizar(3);
                        }
                        catch(Exception e){

                        }
                    }

                }
                else{
                    JOptionPane.showMessageDialog(null, "Selecione el chofer que quiere eliminar antes de realizar esta accion");
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
                            String testID = finalCustomTable.getValueAt(selectedRow, 0).toString();
                            Test edit = ServicesLocator.getInstance().getTestServices().obtainTest(testID);
                            EditTest dialog = new EditTest(father, edit);
                            dialog.setLocationRelativeTo(null);
                            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                                @Override
                                public void windowClosing(java.awt.event.WindowEvent e) {
                                    System.exit(0);
                                }
                            });
                            dialog.setVisible(true);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Seleccione el examen que desea editar");
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

    private void SearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        SearchTextField.requestFocusInWindow();
        SearchTextField.setText("");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void AddDriversButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }



    private javax.swing.JButton AddDriversButton;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditJButton;
    private TableRowSorter<DefaultTableModel> tableSorter;

}
