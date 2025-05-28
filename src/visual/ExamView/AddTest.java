package visual.ExamView;

import models.Driver;
import models.RelatedEntity;
import models.Test;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import services.RelatedEntityServices;
import services.ServicesLocator;
import visual.MainScreen.MainScreen;

import javax.swing.*;
import javax.swing.plaf.basic.BasicHTML;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class AddTest extends javax.swing.JDialog {
    public AddTest(MainScreen parent, Driver driver) {
        super(parent, true);
        initComponents(driver, parent);
    }
    private void initComponents(Driver driver, MainScreen parent) {

        jPanel1 = new JPanel();
        TitleLabel = new JLabel();
        jLabel7 = new JLabel();
        examinadorName = new JTextField();
        jLabel3 = new JLabel();
        centerName = new JComboBox<>();
        jLabel4 = new JLabel();
        licenseType = new JComboBox<>();
        jLabel5 = new JLabel();
        result = new JComboBox<>();
        jLabel6 = new JLabel();
        testType = new JLabel();
        jLabel8 = new JLabel();
        TestID = new JTextField();
        AddjButton1 = new JButton();
        deletejButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new AbsoluteLayout());

        jPanel1.setBackground(new Color(23, 22, 28));
        jPanel1.setLayout(new AbsoluteLayout());

        TitleLabel.setFont(new Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new Color(255, 215, 179));
        TitleLabel.setText("Añadir Examen");
        jPanel1.add(TitleLabel, new AbsoluteConstraints(180, 10, 260, 40));

        jLabel7.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new Color(255, 215, 179));
        jLabel7.setText("ID del examen:");
        jPanel1.add(jLabel7, new AbsoluteConstraints(40, 90, -1, -1));

        examinadorName.setBackground(new Color(47, 50, 65));
        examinadorName.setForeground(new Color(204, 204, 204));
        examinadorName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                carnetIDJTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(examinadorName, new AbsoluteConstraints(310, 340, 230, 40));

        jLabel3.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new Color(255, 215, 179));
        jLabel3.setText("Nombre del examinador:");
        jPanel1.add(jLabel3, new AbsoluteConstraints(310, 310, -1, -1));

        licenseType.setBackground(new Color(47, 50, 65));
        licenseType.setForeground(new Color(255, 215, 179));
        try {
            ArrayList<String> licenseDriver = (ArrayList<String>) ServicesLocator.getInstance().getDriverServices().getMissingLicenses(driver.getDriverId());

            if (licenseDriver.size() > 0) {
                String[] driverLicense = licenseDriver.toArray(new String[licenseDriver.size()]);
                licenseType.setModel(new javax.swing.DefaultComboBoxModel<>(driverLicense));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        licenseType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String seleccion = (String) licenseType.getSelectedItem();

                    // Actualizar otros componentes según la selección
                    switch(seleccion) {
                        case "A":
                            testType.setText(ServicesLocator.getInstance().getTestServices().necessaryTest(driver.getDriverId(),licenseType.getSelectedItem().toString()));
                            ArrayList<RelatedEntity> relatedCenter = (ArrayList<RelatedEntity>) ServicesLocator.getInstance().getRelatedEntityServices().getAllEntityByType(licenseType.getSelectedItem().toString()=="Medico"? "Clinica":"Autoescuela");
                            ArrayList<String> nameCenter = new ArrayList<>();
                            for (RelatedEntity relatedEntity : relatedCenter) {
                                nameCenter.add(relatedEntity.getEntityName());
                            }
                            String[] nameCenterArray = nameCenter.toArray(new String[nameCenter.size()]);
                            centerName.setModel(new DefaultComboBoxModel<>(nameCenterArray));
                            break;
                        case "B":
                            testType.setText(ServicesLocator.getInstance().getTestServices().necessaryTest(driver.getDriverId(),licenseType.getSelectedItem().toString()));
                            ArrayList<RelatedEntity> relatedCente = (ArrayList<RelatedEntity>) ServicesLocator.getInstance().getRelatedEntityServices().getAllEntityByType(testType.getText()=="Medico"? "Clinica":"Autoescuela");
                            ArrayList<String> nameCente = new ArrayList<>();
                            for (RelatedEntity relatedEntity : relatedCente) {
                                nameCente.add(relatedEntity.getEntityName());
                            }
                            String[] nCenterArray = nameCente.toArray(new String[nameCente.size()]);
                            centerName.setModel(new DefaultComboBoxModel<>(nCenterArray));
                            break;
                        case "C":
                            testType.setText(ServicesLocator.getInstance().getTestServices().necessaryTest(driver.getDriverId(),licenseType.getSelectedItem().toString()));
                            ArrayList<RelatedEntity> relateCente = (ArrayList<RelatedEntity>) ServicesLocator.getInstance().getRelatedEntityServices().getAllEntityByType(testType.getText()=="Medico"? "Clinica":"Autoescuela");
                            ArrayList<String> nCenter = new ArrayList<>();
                            for (RelatedEntity relatedEntity : relateCente) {
                                nCenter.add(relatedEntity.getEntityName());
                            }
                            String[] CenterArray = nCenter.toArray(new String[nCenter.size()]);
                            centerName.setModel(new DefaultComboBoxModel<>(CenterArray));
                            break;
                        case "D":
                            testType.setText(ServicesLocator.getInstance().getTestServices().necessaryTest(driver.getDriverId(),licenseType.getSelectedItem().toString()));
                            ArrayList<RelatedEntity> relateCenter = (ArrayList<RelatedEntity>) ServicesLocator.getInstance().getRelatedEntityServices().getAllEntityByType(testType.getText()=="Medico"? "Clinica":"Autoescuela");
                            ArrayList<String> nCente = new ArrayList<>();
                            for (RelatedEntity relatedEntity : relateCenter) {
                                nCente.add(relatedEntity.getEntityName());
                            }
                            String[] centerNameArray = nCente.toArray(new String[nCente.size()]);
                            centerName.setModel(new DefaultComboBoxModel<>(centerNameArray));
                            break;
                            case "E":
                                testType.setText(ServicesLocator.getInstance().getTestServices().necessaryTest(driver.getDriverId(),licenseType.getSelectedItem().toString()));
                                ArrayList<RelatedEntity> rCenter = (ArrayList<RelatedEntity>) ServicesLocator.getInstance().getRelatedEntityServices().getAllEntityByType(testType.getText()=="Medico"? "Clinica":"Autoescuela");
                                ArrayList<String> centerNames = new ArrayList<>();
                                for (RelatedEntity relatedEntity : rCenter) {
                                    centerNames.add(relatedEntity.getEntityName());
                                }
                                String[] centerArray = centerNames.toArray(new String[centerNames.size()]);
                                centerName.setModel(new DefaultComboBoxModel<>(centerArray));
                                break;
                    }
                }
            }
        });
        jPanel1.add(licenseType, new AbsoluteConstraints(310, 120, 230, 40));

        testType.setBackground(new Color(47, 50, 65));
        testType.setForeground(new Color(255, 215, 179));
        try{
            String test = ServicesLocator.getInstance().getTestServices().necessaryTest(driver.getDriverId(),licenseType.getSelectedItem().toString());
            testType.setText(test);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        jPanel1.add(testType, new AbsoluteConstraints(40, 230, 230, 40));

        centerName.setBackground(new Color(47, 50, 65));
        centerName.setForeground(new Color(255, 215, 179));
        ArrayList<RelatedEntity> relatedCenter = (ArrayList<RelatedEntity>) ServicesLocator.getInstance().getRelatedEntityServices().getAllEntityByType(testType.getText()=="Medico"? "Clinica":"Autoescuela");
        ArrayList<String> nameCenter = new ArrayList<>();
        for (RelatedEntity relatedEntity : relatedCenter) {
            nameCenter.add(relatedEntity.getEntityName());
        }
        String[] nameCenterArray = nameCenter.toArray(new String[nameCenter.size()]);
        centerName.setModel(new DefaultComboBoxModel<>(nameCenterArray));
        centerName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(centerName, new AbsoluteConstraints(310, 230, 230, 40));

        jLabel4.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new Color(255, 215, 179));
        jLabel4.setText("Tipo de Licencia:");
        jPanel1.add(jLabel4, new AbsoluteConstraints(310, 90, -1, -1));



        jLabel5.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new Color(255, 215, 179));
        jLabel5.setText("Resultado:");
        jPanel1.add(jLabel5, new AbsoluteConstraints(40, 310, -1, -1));

        result.setBackground(new Color(47, 50, 65));
        result.setForeground(new Color(255, 215, 179));
        result.setModel(new DefaultComboBoxModel<>(new String[] { "Aprobado", "Reprobado" }));
        result.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(result, new AbsoluteConstraints(40, 340, 230, 40));

        jLabel6.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new Color(255, 215, 179));
        jLabel6.setText("Tipo de Examen:");
        jPanel1.add(jLabel6, new AbsoluteConstraints(40, 200, -1, -1));



        jLabel8.setFont(new Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new Color(255, 215, 179));
        jLabel8.setText("Nombre del centro:");
        jPanel1.add(jLabel8, new AbsoluteConstraints(310, 200, -1, -1));

        TestID.setBackground(new Color(47, 50, 65));
        TestID.setForeground(new Color(204, 204, 204));
        TestID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                carnetIDJTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(TestID, new AbsoluteConstraints(40, 120, 230, 40));

        AddjButton1.setBackground(new Color(232, 152, 70));
        AddjButton1.setText("Añadir");
        AddjButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String testID = TestID.getText();
                String type = testType.getText();
                String license = licenseType.getSelectedItem().toString();
                String nameCenter = centerName.getSelectedItem().toString();
                Boolean resultado = result.getSelectedItem().toString().equals("Aprobado");
                String examinador = examinadorName.getText();
                //String testCode, String testType, Date date, boolean result, String entityName,
                //                String examinerName, String driverId, String licenseType
                if(!Objects.equals(testID,"") && !Objects.equals(type,"") && !Objects.equals(license,"") && !Objects.equals(nameCenter,"")){
                    try {
                        LocalDate createDate = LocalDate.now();
                        Date creact = Date.valueOf(LocalDate.now());
                        ServicesLocator.getInstance().getTestServices().createTest(new Test(testID, type, creact, resultado, nameCenter, examinador, driver.getDriverId(), license));
                        parent.Actualizar(3);
                        dispose();
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            }
        });
        jPanel1.add(AddjButton1, new AbsoluteConstraints(120, 470, 120, 30));

        deletejButton.setForeground(new Color(153, 0, 0));
        deletejButton.setText("Salir");
        deletejButton.setFocusable(false);
        deletejButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deletejButton, new AbsoluteConstraints(340, 470, 120, 30));

        getContentPane().add(jPanel1, new AbsoluteConstraints(0, 0, 590, 600));

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

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void carnetIDJTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void AddjButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int respuesta=JOptionPane.showConfirmDialog(null, "Está seguro que desea cerrar esta ventana?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==0){
            dispose();
        }
    }
    // Variables declaration - do not modify
    private javax.swing.JButton AddjButton1;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField examinadorName;
    private javax.swing.JTextField TestID;
    private javax.swing.JButton deletejButton;
    private javax.swing.JComboBox<String> centerName;
    private javax.swing.JComboBox<String> licenseType;
    private javax.swing.JComboBox<String> result;
    private javax.swing.JLabel testType;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}
