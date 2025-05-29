package visual.ReportView;

import report.PDFReportGenerator;
import services.ServicesLocator;
import visual.DriverView.SelectDriver;

import visual.MainScreen.MainScreen;
import visual.ReportScreen.ReportScreen;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReportView extends javax.swing.JPanel {

    public ReportView(javax.swing.JFrame father) {
        initComponents(father);
    }

    private void initComponents(javax.swing.JFrame father) {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        jPanelCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanelRelatedEntity = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelInfraction = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanelCenter1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanelLicense = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanelExpiredLicense = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanelDriver1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanelTest = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanelConsolidatedInfraction = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 22, 28));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Reportes del Sistema");
        jPanel1.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 600, 40));

        jPanelCenter.setBackground(new java.awt.Color(47, 50, 65));
        jPanelCenter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelCenterMouseClicked(evt);
            }
        });
        jPanelCenter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelCenter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-información-50 (1).png"))); // NOI18N
        jPanelCenter.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 50, 50));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 215, 179));
        jLabel2.setText("Ficha del Centro");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelCenter.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 215, 179));
        jLabel3.setText("Informacion general del Centro de licencias");
        jPanelCenter.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, 20));

        jPanel1.add(jPanelCenter, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 400, 200));

        jPanelRelatedEntity.setBackground(new java.awt.Color(47, 50, 65));
        jPanelRelatedEntity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelRelatedEntityMouseClicked(evt);
            }
        });
        jPanelRelatedEntity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelRelatedEntity.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/edifice.png"))); // NOI18N
        jPanelRelatedEntity.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 50, 50));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 215, 179));
        jLabel5.setText("Ficha de Entidad");
        jPanelRelatedEntity.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 215, 179));
        jLabel6.setText("Informacion detallada de una entidad asociada");
        jPanelRelatedEntity.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, 20));

        jPanel1.add(jPanelRelatedEntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, 400, 200));

        jPanelInfraction.setBackground(new java.awt.Color(47, 50, 65));
        jPanelInfraction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelInfractionMouseClicked(evt);
            }
        });
        jPanelInfraction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelInfraction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-error-50 (1).png"))); // NOI18N
        jPanelInfraction.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 50, 50));

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 215, 179));
        jLabel8.setText("Infracciones Registradas");
        jPanelInfraction.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 215, 179));
        jLabel9.setText("Reporte de infracciones registradas en un periodo de tiempo");
        jPanelInfraction.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 20));

        jPanel1.add(jPanelInfraction, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 390, 400, 200));

        jPanelCenter1.setBackground(new java.awt.Color(47, 50, 65));
        jPanelCenter1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-información-50 (1).png"))); // NOI18N
        jPanelCenter1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 50, 50));

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 215, 179));
        jLabel11.setText("Ficha del Centro");
        jPanelCenter1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 215, 179));
        jLabel12.setText("Informacion general del Centro de licencias");
        jPanelCenter1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, 20));

        jPanel1.add(jPanelCenter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 400, 200));

        jPanelLicense.setBackground(new java.awt.Color(47, 50, 65));
        jPanelLicense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelLicenseMouseClicked(evt);
            }
        });
        jPanelLicense.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelLicense.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-licencia-50 (1).png"))); // NOI18N
        jPanelLicense.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 50, 50));

        jLabel14.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 215, 179));
        jLabel14.setText("Licencias Emitidas");
        jPanelLicense.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 215, 179));
        jLabel15.setText("Reporte de licencias emitidas en un periodo de tiempo");
        jPanelLicense.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 20));

        jPanel1.add(jPanelLicense, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 400, 200));

        jPanelExpiredLicense.setBackground(new java.awt.Color(47, 50, 65));
        jPanelExpiredLicense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelExpiredLicenseMouseClicked(evt);
            }
        });
        jPanelExpiredLicense.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelExpiredLicense.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-calendario-50.png"))); // NOI18N
        jPanelExpiredLicense.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 50, 50));

        jLabel17.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 215, 179));
        jLabel17.setText("Licencias Vencidas");
        jPanelExpiredLicense.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 215, 179));
        jLabel18.setText("Reporte de conductores con licencias vencidas");
        jPanelExpiredLicense.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, 20));

        jPanel1.add(jPanelExpiredLicense, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 630, 400, 200));

        jPanelDriver1.setBackground(new java.awt.Color(47, 50, 65));
        jPanelDriver1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelDriver1MouseClicked(evt);
            }
        });
        jPanelDriver1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelDriver1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-grupos-de-usuarios-50 (1).png"))); // NOI18N
        jPanelDriver1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 50, 50));

        jLabel20.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 215, 179));
        jLabel20.setText("Ficha de Conductor");
        jPanelDriver1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 215, 179));
        jLabel21.setText("Informacion detallada de un conductor especifico");
        jPanelDriver1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, 20));

        jPanel1.add(jPanelDriver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 150, 400, 200));

        jPanelTest.setBackground(new java.awt.Color(47, 50, 65));
        jPanelTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelTestMouseClicked(evt);
            }
        });
        jPanelTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelTest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-examen-50 (1).png"))); // NOI18N
        jPanelTest.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 50, 50));

        jLabel23.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 215, 179));
        jLabel23.setText("Exámenes Realizados");
        jPanelTest.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 215, 179));
        jLabel24.setText("Reporte de exámenes realizados en un periodo de tiempo");
        jPanelTest.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        jPanel1.add(jPanelTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 390, 400, 200));

        jPanelConsolidatedInfraction.setBackground(new java.awt.Color(47, 50, 65));
        jPanelConsolidatedInfraction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelConsolidatedInfractionMouseClicked(evt);
            }
        });
        jPanelConsolidatedInfraction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelConsolidatedInfraction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-bar-chart-50.png"))); // NOI18N
        jPanelConsolidatedInfraction.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 50, 50));

        jLabel26.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 215, 179));
        jLabel26.setText("Infracciones Consolidadas");
        jPanelConsolidatedInfraction.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 215, 179));
        jLabel27.setText("Reporte de infracciones consolidadas por tipo en un año");
        jPanelConsolidatedInfraction.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 20));

        jPanel1.add(jPanelConsolidatedInfraction, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 400, 200));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 1050));
    }// </editor-fold>

    private void jPanelCenterMouseClicked(java.awt.event.MouseEvent evt) {

        try {
            String pdfPath = PDFReportGenerator.createCenterReportPDF();

            File file = new File(pdfPath);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                throw new UnsupportedOperationException("El archivo no existe.");
            }
        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Hubo un problema al crear el reporte.");
        }

    }

    private void jPanelDriver1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
//        try {
//            String pdfPath = PDFReportGenerator.createDriverReportPDF("20321108643");
//
//            File file = new File(pdfPath);
//            if (file.exists()) {
//                Desktop.getDesktop().open(file);
//            } else {
//                throw new UnsupportedOperationException("El archivo no existe.");
//            }
//        } catch (IOException e) {
//
//            JOptionPane.showMessageDialog(null, "Hubo un problema al crear el reporte.");
//        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                MainScreen parent = new MainScreen();
                SelectDriver dialog = new SelectDriver(parent,3);

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

    private void jPanelRelatedEntityMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:

        try {
            String pdfPath = PDFReportGenerator.createRelatedEntityReportPDF("Bailey Electronic LLC");

            File file = new File(pdfPath);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                throw new UnsupportedOperationException("El archivo no existe.");
            }
        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Hubo un problema al crear el reporte.");
        }
    }

    private void jPanelLicenseMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        java.sql.Date start = java.sql.Date.valueOf("2020-01-01");
        java.sql.Date end = java.sql.Date.valueOf("2025-03-31");
        try {
            String pdfPath = PDFReportGenerator.createLicenseReportPDF(start, end);

            File file = new File(pdfPath);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                throw new UnsupportedOperationException("El archivo no existe.");
            }
        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Hubo un problema al crear el reporte.");
        }
    }

    private void jPanelTestMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        java.sql.Date start = java.sql.Date.valueOf("2020-01-01");
        java.sql.Date end = java.sql.Date.valueOf("2025-03-31");
        try {
            String pdfPath = PDFReportGenerator.createTestReportPDF(start, end);

            File file = new File(pdfPath);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                throw new UnsupportedOperationException("El archivo no existe.");
            }
        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Hubo un problema al crear el reporte.");
        }
    }

    private void jPanelInfractionMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        java.sql.Date start = java.sql.Date.valueOf("2020-01-01");
        java.sql.Date end = java.sql.Date.valueOf("2025-03-31");
        try {
            String pdfPath = PDFReportGenerator.createInfractionReportPDF(start, end);

            File file = new File(pdfPath);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                throw new UnsupportedOperationException("El archivo no existe.");
            }
        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Hubo un problema al crear el reporte.");
        }
    }

    private void jPanelConsolidatedInfractionMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        try {
            String pdfPath = PDFReportGenerator.createConsolidatedInfractionReportPDF(2025);

            File file = new File(pdfPath);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                throw new UnsupportedOperationException("El archivo no existe.");
            }
        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Hubo un problema al crear el reporte.");
        }
    }

    private void jPanelExpiredLicenseMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        java.sql.Date start = java.sql.Date.valueOf("2020-01-01");
        java.sql.Date end = java.sql.Date.valueOf("2025-03-31");
        try {
            String pdfPath = PDFReportGenerator.createExpiredLicensesReportPDF(start, end);

            File file = new File(pdfPath);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                throw new UnsupportedOperationException("El archivo no existe.");
            }
        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Hubo un problema al crear el reporte.");
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCenter;
    private javax.swing.JPanel jPanelCenter1;
    private javax.swing.JPanel jPanelConsolidatedInfraction;
    private javax.swing.JPanel jPanelDriver1;
    private javax.swing.JPanel jPanelExpiredLicense;
    private javax.swing.JPanel jPanelInfraction;
    private javax.swing.JPanel jPanelLicense;
    private javax.swing.JPanel jPanelRelatedEntity;
    private javax.swing.JPanel jPanelTest;
    // End of variables declaration
}
