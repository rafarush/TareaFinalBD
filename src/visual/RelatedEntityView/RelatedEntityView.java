package visual.RelatedEntityView;

import models.RelatedEntity;
import services.ServicesLocator;
import visual.CustomTable;
import visual.MainScreen.MainScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

public class RelatedEntityView extends javax.swing.JPanel {

    public RelatedEntityView(MainScreen father) {
        initComponents(father);
    }
    private void initComponents(MainScreen father) {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        AddEntityButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        DeleteButton = new javax.swing.JButton();
        EditJButton = new javax.swing.JButton();
        CustomTable customTable = new CustomTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 22, 28));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Gestion de Entidades");
        jPanel1.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 600, 40));

        SearchTextField.setBackground(new java.awt.Color(47, 50, 65));
        SearchTextField.setForeground(new java.awt.Color(153, 153, 153));
        SearchTextField.setText("Buscar entidad...");
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
        jPanel1.add(SearchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, 230, 40));

        jLabel1.setBackground(new java.awt.Color(47, 50, 65));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-búsqueda-30.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 40, 40));

        AddEntityButton.setBackground(new java.awt.Color(232, 152, 70));
        AddEntityButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        AddEntityButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-más-30.png"))); // NOI18N
        AddEntityButton.setText("   Nueva Entidad");
        AddEntityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        AddRelatedEntity dialog = new AddRelatedEntity(father);
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
        jPanel1.add(AddEntityButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 50, 200, 40));

        List<String> columns = Arrays.asList(
                "Nombre", "Tipo", "Direccion",
                "Teléfono", "Correo","Director"
        );

        try {
            List<RelatedEntity>re = ServicesLocator.getInstance().getRelatedEntityServices().getAllRelatedEntities();
            Object[][] data =new Object[re.size()][6];
            int pos=0;
            for (RelatedEntity d : re) {
                Object[] row = {d.getEntityName(), d.getEntityType(),d.getAddress(),d.getPhone(),d.getContactEmail(),d.getDirectorName()};
                data[pos]=row;
                pos++;
            }
            customTable = new CustomTable(columns, data);
            customTable.getTableHeader().setReorderingAllowed(false);

            // 4. Asignar al scroll pane
            jScrollPane2.setViewportView(customTable);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        DeleteButton.setBackground(new java.awt.Color(204, 0, 0));
        DeleteButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/Icons/icons8-borrar-para-siempre-30.png"))); // NOI18N
        DeleteButton.setText("Eliminar");
        CustomTable finalCustomTable = customTable;
        TableRowSorter<DefaultTableModel> tableSorter = new TableRowSorter<>((DefaultTableModel) customTable.getModel());
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
                    String licenseID = finalCustomTable.getValueAt(selectedRow, 0).toString();
                    int respuesta= JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar esta Entidad?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(respuesta==0){
                        try{
                            ServicesLocator.getInstance().getRelatedEntityServices().deleteRelatedEntity(licenseID);
                            father.Actualizar(5);
                        }
                        catch(Exception e){
                            JOptionPane.showMessageDialog(null, "\"No se puede eliminar esta entidad al estar relacionada con varios examenes.\"");
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Selecione la Entidad que desea eliminar antes de realizar esta accion");
                }
            }
        });
        jPanel1.add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 130, 140, 40));

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
                            String entityName=finalCustomTable.getValueAt(selectedRow, 0).toString();
                            RelatedEntity edit = ServicesLocator.getInstance().getRelatedEntityServices().obtainRelatedEntity(entityName);
                            EditRelatedEntity dialog = new EditRelatedEntity(father, edit);
                            dialog.setLocationRelativeTo(null);
                            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                                @Override
                                public void windowClosing(java.awt.event.WindowEvent e) {
                                    System.exit(0);
                                }
                            });
                            dialog.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null, "Seleccione la Entidad que desea editar");
                        }
                    }
                });
            }
        });
        jPanel1.add(EditJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, 140, 40));

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 1250, 810));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 1050));
    }// </editor-fold>

    private void SearchTextFieldMouseClicked(java.awt.event.MouseEvent evt) {
        SearchTextField.setText("");
    }

    private void SearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        SearchTextField.requestFocusInWindow();
        SearchTextField.setText("");
    }

    private void AddDriversButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private javax.swing.JButton AddEntityButton;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditJButton;
}
