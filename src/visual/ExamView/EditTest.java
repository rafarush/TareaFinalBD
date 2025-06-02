package visual.ExamView;

import models.RelatedEntity;
import models.Test;
import services.ServicesLocator;
import visual.MainScreen.MainScreen;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class EditTest extends javax.swing.JDialog {

    /**
     * Creates new form EditTest
     */
    public EditTest(MainScreen parent, Test edit) {
        super(parent, true);
        initComponents(parent,edit);
    }
    private void initComponents(MainScreen parent, Test edit) {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        examinadorName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nameCenter = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        result = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        licenseType = new javax.swing.JTextField();
        AddjButton1 = new javax.swing.JButton();
        deletejButton = new javax.swing.JButton();
        testIDJTextField = new javax.swing.JTextField();
        testType = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 22, 28));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Editar Examen");
        jPanel1.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 260, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 215, 179));
        jLabel7.setText("ID del examen:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        examinadorName.setBackground(new java.awt.Color(47, 50, 65));
        examinadorName.setForeground(new java.awt.Color(204, 204, 204));
        examinadorName.setText(edit.getExaminerName());
        examinadorName.getCaret().setBlinkRate(500);
        examinadorName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        examinadorName.setCaretColor(Color.lightGray);
        jPanel1.add(examinadorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 230, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 215, 179));
        jLabel3.setText("Nombre del examinador:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        nameCenter.setBackground(new java.awt.Color(47, 50, 65));
        nameCenter.setForeground(new java.awt.Color(255, 215, 179));
        nameCenter.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = super.createArrowButton();
                button.setBackground(new java.awt.Color(47, 50, 65)); // Fondo del botón desplegable
                button.setForeground(new java.awt.Color(255, 215, 179)); // Color de la flecha
                return button;
            }
        });
        ArrayList<RelatedEntity> relatedCenter = (ArrayList<RelatedEntity>) ServicesLocator.getInstance().getRelatedEntityServices().getAllEntityByType(Objects.equals(edit.getTestType(), "Medico") ? "Clinica":"Auto Escuela");
        ArrayList<String> nameCente = new ArrayList<>();
        for (RelatedEntity relatedEntity : relatedCenter) {
            nameCente.add(relatedEntity.getEntityName());
        }
        String[] nameCenterArray = nameCente.toArray(new String[nameCente.size()]);
        nameCenter.setModel(new javax.swing.DefaultComboBoxModel<>(nameCenterArray));

        jPanel1.add(nameCenter, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 230, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 215, 179));
        jLabel4.setText("Tipo de Licencia:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 215, 179));
        jLabel5.setText("Resultado:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        result.setBackground(new java.awt.Color(47, 50, 65));
        result.setForeground(new java.awt.Color(255, 215, 179));
        result.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = super.createArrowButton();
                button.setBackground(new java.awt.Color(47, 50, 65)); // Fondo del botón desplegable
                button.setForeground(new java.awt.Color(255, 215, 179)); // Color de la flecha
                return button;
            }
        });
        result.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aprobado", "Reprobado" }));

        jPanel1.add(result, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 230, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 215, 179));
        jLabel6.setText("Tipo de Examen:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 215, 179));
        jLabel8.setText("Nombre del centro:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));

        licenseType.setBackground(new java.awt.Color(47, 50, 65));
        licenseType.setForeground(new java.awt.Color(204, 204, 204));
        licenseType.setText(edit.getLicenseType());
        licenseType.setEnabled(false);
        jPanel1.add(licenseType, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 230, 40));

        AddjButton1.setBackground(new java.awt.Color(232, 152, 70));
        AddjButton1.setText("Editar");
        AddjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int respuesta = JOptionPane.showConfirmDialog(null, "Está seguro que desea Editar a este Examen?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (respuesta == 0) {
                    String centerName = Objects.equals(nameCenter.getSelectedItem().toString(), "") ? edit.getEntityName() : nameCenter.getSelectedItem().toString();
                    Boolean resultado = Objects.equals(result.getSelectedItem().toString(), "Aprobado");
                    String name = Objects.equals(examinadorName.getText().toString(), "") ? edit.getExaminerName() : examinadorName.getText();
                    try{
                        //String testCode, String testType, Date date, boolean result, String entityName,
                        //                String examinerName, String driverId, String licenseType
                        ServicesLocator.getInstance().getTestServices().updateTest(new Test(edit.getTestCode(), edit.getTestType(), edit.getDate(),resultado,centerName,name,edit.getDriverId(), edit.getLicenseType()));
                        parent.Actualizar(3);
                        dispose();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            }
        });
        jPanel1.add(AddjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 120, 30));

        deletejButton.setForeground(new java.awt.Color(153, 0, 0));
        deletejButton.setText("Salir");
        deletejButton.setFocusable(false);
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deletejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 120, 30));

        testIDJTextField.setBackground(new java.awt.Color(47, 50, 65));
        testIDJTextField.setForeground(new java.awt.Color(204, 204, 204));
        testIDJTextField.setText(edit.getTestCode());
        testIDJTextField.setEnabled(false);
        jPanel1.add(testIDJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, 40));

        testType.setForeground(new java.awt.Color(255, 215, 179));
        testType.setText(edit.getTestType());
        jPanel1.add(testType, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 230, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 600));

        pack();
    }

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int respuesta= JOptionPane.showConfirmDialog(null, "Está seguro que desea cerrar esta ventana?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==0){
            dispose();
        }
    }

    private void testIDJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.JButton AddjButton1;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField examinadorName;
    private javax.swing.JTextField licenseType;
    private javax.swing.JButton deletejButton;
    private javax.swing.JComboBox<String> nameCenter;
    private javax.swing.JComboBox<String> result;
    private javax.swing.JLabel testType;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField testIDJTextField;
    // End of variables declaration
}
