package visual.UserView;

import models.Driver;
import models.User;
import services.ServicesLocator;
import visual.CustomTable;
import visual.MainScreen.MainScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

public class UserView extends javax.swing.JPanel {

    public UserView(MainScreen parent) {
        initComponents(parent);
    }
    private void initComponents(MainScreen parent) {

        TitleLabel = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        AddUserButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        DeleteButton = new javax.swing.JButton();
        EditJButton = new javax.swing.JButton();
        CustomTable customTable = new CustomTable();

        setBackground(new java.awt.Color(23, 22, 28));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Gestion de Usuarios");
        add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 600, 40));

        SearchTextField.setBackground(new java.awt.Color(47, 50, 65));
        SearchTextField.setForeground(new java.awt.Color(153, 153, 153));
        SearchTextField.setText("Buscar usuario...");
        SearchTextField.getCaret().setBlinkRate(500);
        SearchTextField.setCaretColor(Color.lightGray);
        SearchTextField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
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
        add(SearchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 230, 40));

        jLabel1.setBackground(new java.awt.Color(47, 50, 65));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-búsqueda-30.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 40, 40));

        AddUserButton.setBackground(new java.awt.Color(232, 152, 70));
        AddUserButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        AddUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-más-30.png"))); // NOI18N
        AddUserButton.setText("   Nuevo Usuario");
        AddUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        AddUser dialog = new AddUser(parent);
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
        add(AddUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 60, 200, 40));

        List<String> columns = Arrays.asList(
                "Nombre","Rol"
        );

        try {
            List<User>usersBD = ServicesLocator.getInstance().getUserServices().getAllUsers();
            Object[][] data =new Object[usersBD.size()][5];
            int pos=0;
            for (User u : usersBD) {
                Object[] row = {u.getUsername(),u.getRole()};
                data[pos]=row;
                pos++;
            }
            customTable = new CustomTable(columns, data);
            customTable.getTableHeader().setReorderingAllowed(false);

            jScrollPane2.setViewportView(customTable);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 1250, 690));

        DeleteButton.setBackground(new java.awt.Color(204, 0, 0));
        DeleteButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-borrar-para-siempre-30.png"))); // NOI18N
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
                int select = finalCustomTable.getSelectedRow();
                if (select != -1) {
                    String userName = (String) finalCustomTable.getValueAt(select,0);
                    try{
                        ServicesLocator.getInstance().getUserServices().deleteUser(userName);
                        parent.Actualizar(6);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(parent,e.getMessage());
                    }


                }
            }
        });
        add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 130, 140, 40));

        EditJButton.setBackground(new java.awt.Color(255, 204, 0));
        EditJButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        EditJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-pencil-30.png"))); // NOI18N
        EditJButton.setText("   Editar");
        EditJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int select = finalCustomTable.getSelectedRow();
                if (select != -1) {
                    String userName = (String) finalCustomTable.getValueAt(select,0);
                    User u = ServicesLocator.getInstance().getUserServices().getUser(userName);
                    try{
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                EditUser dialog = new EditUser(parent,u);
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

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(parent,e.getMessage());
                    }
                }
            }
        });
        add(EditJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, 140, 40));
    }// </editor-fold>

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        SearchTextField.requestFocusInWindow();
        SearchTextField.setText("");
    }


    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void EditJButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void SearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void SearchTextFieldMouseClicked(java.awt.event.MouseEvent evt) {
        SearchTextField.setText("");
    }


    // Variables declaration - do not modify
    private javax.swing.JButton AddUserButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditJButton;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}
