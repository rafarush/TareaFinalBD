package visual.MainScreen;
import visual.DriverView.DriversView;
import visual.ExamView.ExamView;
import visual.InfractionView.InfractionView;
import visual.LicenseTypeView.LicenseCategoryView;
import visual.LicenseView.LicensView;
import visual.MainView.MainView;

import visual.RelatedEntityView.RelatedEntityView;
import visual.ReportView.ReportView;
import visual.UserView.UserView;

import java.awt.BorderLayout;
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreem
     */
    public MainScreen(Boolean flag) {
        initComponents(flag);
        MainView p1 = new MainView();
        p1.setSize(1560, 1050);
        p1.setLocation(0,0);
        
        Content.removeAll();
        Content.add(p1,BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
        
    }

    private void initComponents(Boolean flag) {

        MainPanel = new javax.swing.JPanel();
        SideBar = new javax.swing.JPanel();
        InfractionButton = new javax.swing.JButton();
        DriversButton = new javax.swing.JButton();
        ReportsButton = new javax.swing.JButton();
        LicensButton = new javax.swing.JButton();
        ExamButton = new javax.swing.JButton();
        RelatedEntityButton = new javax.swing.JButton();
        HomeButton = new javax.swing.JButton();
        Content = new javax.swing.JPanel();
        UsuariosButton = new javax.swing.JButton();
        CategoriaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel.setBackground(new java.awt.Color(23, 22, 28));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SideBar.setBackground(new java.awt.Color(47, 50, 65));
        SideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InfractionButton.setBackground(new java.awt.Color(47, 50, 65));
        InfractionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-error-50.png"))); // NOI18N
        InfractionButton.setToolTipText("Infracciones");
        InfractionButton.setBorder(null);
        InfractionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InfractionButtonMouseClicked(evt);
            }
        });
        SideBar.add(InfractionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 90, 45));

        DriversButton.setBackground(new java.awt.Color(47, 50, 65));
        DriversButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-grupos-de-usuarios-50.png"))); // NOI18N
        DriversButton.setToolTipText("Choferes");
        DriversButton.setBorder(null);
        DriversButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DriversButtonMouseClicked(evt);
            }
        });
        SideBar.add(DriversButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 45));

        LicensButton.setBackground(new java.awt.Color(47, 50, 65));
        LicensButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-licencia-50.png"))); // NOI18N
        LicensButton.setToolTipText("Licencias");
        LicensButton.setBorder(null);
        LicensButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LicensButtonMouseClicked(evt);
            }
        });
        SideBar.add(LicensButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, 45));

        ExamButton.setBackground(new java.awt.Color(47, 50, 65));
        ExamButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-examen-50.png"))); // NOI18N
        ExamButton.setToolTipText("Examenes");
        ExamButton.setBorder(null);
        ExamButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExamButtonMouseClicked(evt);
            }
        });
        SideBar.add(ExamButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 90, 45));

        UsuariosButton.setBackground(new java.awt.Color(47, 50, 65));
        UsuariosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-grupos-de-usuarios-50 (2).png"))); // NOI18N
        UsuariosButton.setToolTipText("Usuarios");
        UsuariosButton.setVisible(flag);
        UsuariosButton.setBorder(null);
        UsuariosButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsuariosButtonMouseClicked(evt);
            }
        });
        SideBar.add(UsuariosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 710, 90, 45));

        HomeButton.setBackground(new java.awt.Color(47, 50, 65));
        HomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utils/Icons/icons8-casa-45.png"))); // NOI18N
        HomeButton.setToolTipText("Pantalla Principal");
        HomeButton.setBorder(null);
        HomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeButtonMouseClicked(evt);
            }
        });
        SideBar.add(HomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, 45));

        RelatedEntityButton.setBackground(new java.awt.Color(47, 50, 65));
        RelatedEntityButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/Icons/edifice1.png"))); // NOI18N
        RelatedEntityButton.setToolTipText("Entidades");
        RelatedEntityButton.setBorder(null);
        RelatedEntityButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RelatedEntityButtonMouseClicked(evt);
            }
        });
        SideBar.add(RelatedEntityButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 90, 45));

        ReportsButton.setBackground(new java.awt.Color(47, 50, 65));
        ReportsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/Icons/icons8-pizarra-50.png"))); // NOI18N
        ReportsButton.setToolTipText("Reportes");
        ReportsButton.setBorder(null);
        ReportsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReportsButtonMouseClicked(evt);

            }
        });
        SideBar.add(ReportsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 90, 45));

        CategoriaButton.setBackground(new java.awt.Color(47, 50, 65));
        CategoriaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/Icons/icons8-copyright-all-rights-reserved-50.png"))); // NOI18N
        CategoriaButton.setToolTipText("Categoria de licencia");
        CategoriaButton.setBorder(null);
        CategoriaButton.setVisible(flag);
        CategoriaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoriaButtonMouseClicked(evt);
            }
        });
        SideBar.add(CategoriaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 800, 90, 45));

        MainPanel.add(SideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 1050));

        Content.setBackground(new java.awt.Color(23, 22, 28));
        MainPanel.add(Content, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 1350, 1050));


        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1690, 1050));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RelatedEntityButtonMouseClicked(java.awt.event.MouseEvent evt) {
        RelatedEntityView p6 = new RelatedEntityView(this);
        p6.setSize(1560, 1050);
        p6.setLocation(0,0);

        Content.removeAll();
        Content.add(p6,BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }

    private void ReportsButtonMouseClicked(java.awt.event.MouseEvent evt) {
        ReportView p5 = new ReportView(this);
        p5.setSize(1560, 1050);
        p5.setLocation(0,0);

        Content.removeAll();
        Content.add(p5,BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();

    }

    private void DriversButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DriversButtonMouseClicked
        DriversView p2 = new DriversView(this);
        p2.setSize(1560, 1050);
        p2.setLocation(0,0);
        
        Content.removeAll();
        Content.add(p2,BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }//GEN-LAST:event_DriversButtonMouseClicked

    private void HomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseClicked
        MainView p1 = new MainView();
        p1.setSize(1560, 1050);
        p1.setLocation(0,0);
        
        Content.removeAll();
        Content.add(p1,BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }//GEN-LAST:event_HomeButtonMouseClicked

    private void LicensButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LicensButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LicensButtonActionPerformed

    private void LicensButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LicensButtonMouseClicked
        LicensView p3 = new LicensView(this);
        p3.setSize(1560, 1050);
        p3.setLocation(0,0);
        
        Content.removeAll();
        Content.add(p3,BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
        
    }//GEN-LAST:event_LicensButtonMouseClicked

    private void ExamButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExamButtonMouseClicked
        ExamView p4 = new ExamView(this);
        p4.setSize(1560, 1050);
        p4.setLocation(0,0);
        
        Content.removeAll();
        Content.add(p4,BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }//GEN-LAST:event_ExamButtonMouseClicked

    private void InfractionButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InfractionButtonMouseClicked
        // TODO add your handling code here:
        InfractionView p5 = new InfractionView(this);
        p5.setSize(1560, 1050);
        p5.setLocation(0,0);
        
        Content.removeAll();
        Content.add(p5,BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }

    private void CategoriaButtonMouseClicked(java.awt.event.MouseEvent evt) {
        LicenseCategoryView p7 = new LicenseCategoryView(this);
        p7.setSize(1560, 1050);
        p7.setLocation(0,0);

        Content.removeAll();
        Content.add(p7,BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }

    private void UsuariosButtonMouseClicked(java.awt.event.MouseEvent evt) {
        UserView p7 = new UserView(this);
        p7.setSize(1560, 1050);
        p7.setLocation(0,0);

        Content.removeAll();
        Content.add(p7,BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }


    public void Actualizar(int pantalla){
        switch(pantalla){
            case 1: DriversView p2 = new DriversView(this);
                p2.setSize(1560, 1050);
                p2.setLocation(0,0);

                Content.removeAll();
                Content.add(p2,BorderLayout.CENTER);
                Content.revalidate();
                Content.repaint();
                break;
            case 2: LicensView p3 = new LicensView(this);
                p3.setSize(1560, 1050);
                p3.setLocation(0,0);

                Content.removeAll();
                Content.add(p3,BorderLayout.CENTER);
                Content.revalidate();
                Content.repaint();
                break;
                case 3: ExamView p4 = new ExamView(this);
                    p4.setSize(1560, 1050);
                    p4.setLocation(0,0);

                    Content.removeAll();
                    Content.add(p4,BorderLayout.CENTER);
                    Content.revalidate();
                    Content.repaint();
                    break;
                    case 4:InfractionView p5 = new InfractionView(this);
                        p5.setSize(1560, 1050);
                        p5.setLocation(0,0);

                        Content.removeAll();
                        Content.add(p5,BorderLayout.CENTER);
                        Content.revalidate();
                        Content.repaint();
                        break;
            case 5:RelatedEntityView p6 = new RelatedEntityView(this);
                p6.setSize(1560, 1050);
                p6.setLocation(0,0);

                Content.removeAll();
                Content.add(p6,BorderLayout.CENTER);
                Content.revalidate();
                Content.repaint();
                break;
            case 6:UserView p7 = new UserView(this);
                p7.setSize(1560, 1050);
                p7.setLocation(0,0);

                Content.removeAll();
                Content.add(p7,BorderLayout.CENTER);
                Content.revalidate();
                Content.repaint();
                break;
                case 7: LicenseCategoryView p8 = new LicenseCategoryView(this);
                    p8.setSize(1560, 1050);
                    p8.setLocation(0,0);

                    Content.removeAll();
                    Content.add(p8,BorderLayout.CENTER);
                    Content.revalidate();
                    Content.repaint();
        }
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JButton DriversButton;
    private javax.swing.JButton ExamButton;
    private javax.swing.JButton HomeButton;
    private javax.swing.JButton InfractionButton;
    private javax.swing.JButton LicensButton;
    private javax.swing.JButton RelatedEntityButton;
    private javax.swing.JButton ReportsButton;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel SideBar;
    private javax.swing.JButton UsuariosButton;
    private javax.swing.JButton CategoriaButton;
}
