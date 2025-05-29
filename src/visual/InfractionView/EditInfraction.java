package visual.InfractionView;

import models.Infraction;
import models.InfractionType;
import services.ServicesLocator;
import visual.MainScreen.MainScreen;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EditInfraction extends javax.swing.JDialog {

    public EditInfraction(MainScreen parent, Infraction edit) {
        super(parent, true);
        initComponents(parent,edit);
    }

    private void initComponents(MainScreen parent, Infraction edit) {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        infractionType = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        estatus = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        point = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        infractionID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        AddjButton1 = new javax.swing.JButton();
        deletejButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 22, 28));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel1.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel1.setText("Editar Infracción");
        jPanel1.add(TitleLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 260, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 215, 179));
        jLabel7.setText("Puntos:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        description.setBackground(new java.awt.Color(47, 50, 65));
        description.setForeground(new java.awt.Color(204, 204, 204));
        description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetIDJTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 230, 40));

        infractionType.setBackground(new java.awt.Color(47, 50, 65));
        infractionType.setForeground(new java.awt.Color(255, 215, 179));
        List<InfractionType> type = ServicesLocator.getInstance().getInfractionTypeServices().getAllInfractionTypes();
        ArrayList<String> list = new ArrayList<>();
        for (InfractionType i : type) {
            list.add(i.getInfractionType());
        }
        String[] arr = list.toArray(new String[list.size()]);
        infractionType.setModel(new javax.swing.DefaultComboBoxModel<>(arr));
        infractionType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String seleccion = (String) infractionType.getSelectedItem();
                    switch(seleccion){
                        case "Leve":
                            point.setText("6");
                            break;
                        case "Grave":
                            point.setText("8");
                            break;
                        case "Muy Grave":
                            point.setText("12");
                            break;

                    }
                }
            }
        });
        jPanel1.add(infractionType, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 230, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 215, 179));
        jLabel8.setText("ID de la Infracción:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 215, 179));
        jLabel9.setText("Estado:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        estatus.setBackground(new java.awt.Color(47, 50, 65));
        estatus.setForeground(new java.awt.Color(255, 215, 179));
        estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pagada", "No pagada" }));
        estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 230, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 215, 179));
        jLabel10.setText("Descripcion:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 100, -1));

        point.setForeground(new java.awt.Color(255, 215, 179));
        point.setText("6");
        jPanel1.add(point, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 230, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 215, 179));
        jLabel11.setText("Tipo de infracción:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        infractionID.setBackground(new java.awt.Color(47, 50, 65));
        infractionID.setForeground(new java.awt.Color(204, 204, 204));
        infractionID.setText(edit.getInfractionCode());
        infractionID.setEnabled(false);
        infractionID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetIDJTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(infractionID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 215, 179));
        jLabel12.setText("Direccion donde se Cometio:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        address.setBackground(new java.awt.Color(47, 50, 65));
        address.setForeground(new java.awt.Color(204, 204, 204));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetIDJTextField5ActionPerformed(evt);
            }
        });
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 230, 40));

        AddjButton1.setBackground(new java.awt.Color(232, 152, 70));
        AddjButton1.setText("Editar");
        AddjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int respuesta = JOptionPane.showConfirmDialog(null, "Está seguro que desea Editar a esta infraccion?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (respuesta == 0) {
                    Boolean estado = estatus.getSelectedItem().toString().equals("Pagada");
                    String direccion = Objects.equals(address.getText(), "") ? edit.getLocation():address.getText();
                    String descrip = Objects.equals(description.getText(), "")? edit.getDescription():description.getText();
                    String type = infractionType.getSelectedItem().toString();
                    int points =Integer.parseInt(point.getText());
                    try{
                        //String infractionCode, String licenseId, String violationType, Date date, String location,
                        //                      String description, int points, boolean ispaid
                        ServicesLocator.getInstance().getInfractionServices().updateInfraction(new Infraction(edit.getInfractionCode(),edit.getLicenseId(),type,edit.getDate(),direccion,descrip,points,estado));
                        parent.Actualizar(4);
                        dispose();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }


                }
            }
        });
        jPanel1.add(AddjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 120, 30));

        deletejButton.setForeground(new java.awt.Color(153, 0, 0));
        deletejButton.setText("Salir");
        deletejButton.setFocusable(false);
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deletejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 560));

        pack();
    }// </editor-fold>

    private void carnetIDJTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void carnetIDJTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void carnetIDJTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
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

    // Variables declaration - do not modify
    private javax.swing.JButton AddjButton1;
    private javax.swing.JLabel TitleLabel1;
    private javax.swing.JTextField description;
    private javax.swing.JTextField infractionID;
    private javax.swing.JTextField address;
    private javax.swing.JButton deletejButton;
    private javax.swing.JComboBox<String> infractionType;
    private javax.swing.JComboBox<String> estatus;
    private javax.swing.JLabel point;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}