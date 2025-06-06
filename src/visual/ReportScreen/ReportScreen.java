package visual.ReportScreen;

import services.ServicesLocator;
import visual.LoginScreen.LoginScreen;
import visual.ReportView.ReportView;

import javax.swing.*;
import java.awt.BorderLayout;

public class ReportScreen extends javax.swing.JFrame {



    public ReportScreen() {
        initComponents();

        ReportView reportView = new ReportView(this);
        reportView.setSize(1560, 1050);
        reportView.setLocation(0, 0);

        Content.removeAll();
        Content.add(reportView, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }

    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        Content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel.setBackground(new java.awt.Color(23, 22, 28));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Content.setBackground(new java.awt.Color(23, 22, 28));
        MainPanel.add(Content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1560, 1050));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1560, 1050));

        RefreshButton = new javax.swing.JButton();
        RefreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/refresh.png"))); // ícono de recargar
        RefreshButton.setToolTipText("Refrescar vista actual");
        RefreshButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RefreshButton.setBorder(null);
        RefreshButton.setBackground(new java.awt.Color(47, 50, 65));
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServicesLocator.getInstance().getLicenseServices().refreshLicesesData();
                JOptionPane.showMessageDialog(null, "Datos actualizados con exito");
            }
        });

        MainPanel.add(RefreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 20, 45, 45));
        MainPanel.setComponentZOrder(RefreshButton, 0);

        logOutButton = new javax.swing.JButton();
        logOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-cerrar-sesión-30.png"))); // ícono de recargar
        logOutButton.setToolTipText("Refrescar vista actual");
        logOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutButton.setBorder(null);
        logOutButton.setBackground(new java.awt.Color(47, 50, 65));
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int option = JOptionPane.showOptionDialog(null, "Desea cerrar la sesion actual",
                        "Cerrar sesion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                        null,null,null);
                if (option == JOptionPane.YES_OPTION) {
                    LoginScreen login = new LoginScreen();
                    login.setVisible(true);
                    login.setLocationRelativeTo(null);
                    dispose();
                }
            }
        });

        MainPanel.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1415, 20, 45, 45));
        MainPanel.setComponentZOrder(logOutButton, 0);


        pack();
    }

    private javax.swing.JPanel Content;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton logOutButton;
}

