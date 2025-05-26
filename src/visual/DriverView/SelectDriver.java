package visual.DriverView;

import models.Driver;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import services.ServicesLocator;
import visual.CustomTable;
import visual.ExamView.AddTest;
import visual.LicenseView.AddLicense;
import visual.MainScreen.MainScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

public class SelectDriver extends JDialog {
    /**
     * Creates new form SelectDriver
     */
    public SelectDriver(MainScreen parent, int view) {
        super(parent, true);
        initComponents(parent,view);
    }
    private void initComponents(MainScreen parent,int view) {

        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jScrollPane2 = new JScrollPane();
        TitleLabel = new JLabel();
        jButton2 = new JButton();
        CustomTable customTable = new CustomTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new Color(23, 22, 28));
        setUndecorated(true);
        getContentPane().setLayout(new AbsoluteLayout());

        jPanel1.setBackground(new Color(23, 22, 28));
        jPanel1.setLayout(new AbsoluteLayout());
        List<String> columns = Arrays.asList(
                "Nombre", "Documento de identidad", "Fecha Nacimiento",
                "Teléfono", "Correo"
        );

        try {
            List<Driver>driversBD = ServicesLocator.getInstance().getDriverServices().getAllDrivers();
            Object[][] data =new Object[driversBD.size()][5];
            int pos=0;
            for (Driver d : driversBD) {
                Object[] row = {d.getFirstName()+" "+d.getLastName(),d.getDriverId(),d.getBirthDate().toString(),d.getPhone(),d.getEmail()};
                data[pos]=row;
                pos++;
            }
            customTable = new CustomTable(columns, data);
            customTable.getTableHeader().setReorderingAllowed(false);

            // 4. Asignar al scroll pane
            jScrollPane2.setViewportView(customTable);
        }catch(Exception e) {
            e.printStackTrace();
        }

        jButton1.setBackground(new Color(232, 152, 70));
        jButton1.setFont(new Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Selecionar");
        CustomTable finalCustomTable = customTable;
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int select= finalCustomTable.getSelectedRow();
                if(select!=-1){
                   String idDriver= (String) finalCustomTable.getValueAt(select,1);
                    Driver driver = null;
                    if(view==1) {
                        try {
                            driver = ServicesLocator.getInstance().getDriverServices().obtainDriver(idDriver);
                            if (driver != null) {
                                Driver finalDriver = driver;
                                java.awt.EventQueue.invokeLater(new Runnable() {
                                    public void run() {
                                        AddLicense dialog = new AddLicense(parent, finalDriver);
                                        dialog.setLocationRelativeTo(null);
                                        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                                            @Override
                                            public void windowClosing(java.awt.event.WindowEvent e) {
                                                System.exit(0);
                                            }
                                        });
                                        dispose();
                                        dialog.setVisible(true);

                                    }
                                });
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if (view==2) {
                        try{
                            driver = ServicesLocator.getInstance().getDriverServices().obtainDriver(idDriver);
                            if (driver != null) {
                                Driver finalDriver1 = driver;
                                java.awt.EventQueue.invokeLater(new Runnable() {
                                    public void run() {
                                        AddTest dialog = new AddTest(parent, finalDriver1);
                                        dialog.setLocationRelativeTo(null);
                                        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                                            @Override
                                            public void windowClosing(java.awt.event.WindowEvent e) {
                                                System.exit(0);
                                            }
                                        });
                                        dispose();
                                        dialog.setVisible(true);
                                    }

                                });
                            }
                        }catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        jPanel1.add(jButton1, new AbsoluteConstraints(430, 100, 130, 30));





        jPanel1.add(jScrollPane2, new AbsoluteConstraints(30, 160, 700, 430));

        TitleLabel.setFont(new Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new Color(255, 215, 179));
        TitleLabel.setText("Seleccione un Chofer");
        jPanel1.add(TitleLabel, new AbsoluteConstraints(50, 50, 600, 40));

        jButton2.setFont(new Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new Color(153, 0, 0));
        jButton2.setText("Salir");
        jButton2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new AbsoluteConstraints(600, 100, 130, 30));

        getContentPane().add(jPanel1, new AbsoluteConstraints(0, 0, 760, 620));

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(ActionEvent evt) {

    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        int respuesta= JOptionPane.showConfirmDialog(null, "Está seguro que desea cerrar esta ventana?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==0){
            dispose();
        }
    }

    private void jButton2MouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private JLabel TitleLabel;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    // End of variables declaration
}
