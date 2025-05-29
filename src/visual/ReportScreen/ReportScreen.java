package visual.ReportScreen;

import visual.ReportView.ReportView;

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

        pack();
    }

    private javax.swing.JPanel Content;
    private javax.swing.JPanel MainPanel;
}

