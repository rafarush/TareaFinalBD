package visual.ExamView;

import models.Driver;

import javax.swing.JOptionPane;
public class AddTest extends javax.swing.JDialog {
    public AddTest(java.awt.Frame parent, Driver driver) {
        super(parent, true);
        initComponents(driver);
    }
    private void initComponents(Driver driver) {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        carnetIDJTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        carnetIDJTextField4 = new javax.swing.JTextField();
        AddjButton1 = new javax.swing.JButton();
        deletejButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 22, 28));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Añadir Examen");
        jPanel1.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 260, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 215, 179));
        jLabel7.setText("ID del examen:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        carnetIDJTextField3.setBackground(new java.awt.Color(47, 50, 65));
        carnetIDJTextField3.setForeground(new java.awt.Color(204, 204, 204));
        carnetIDJTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetIDJTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(carnetIDJTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 230, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 215, 179));
        jLabel3.setText("Nombre del examinador:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(47, 50, 65));
        jComboBox1.setForeground(new java.awt.Color(255, 215, 179));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 230, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 215, 179));
        jLabel4.setText("Tipo de Licencia:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        jComboBox2.setBackground(new java.awt.Color(47, 50, 65));
        jComboBox2.setForeground(new java.awt.Color(255, 215, 179));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 230, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 215, 179));
        jLabel5.setText("Resultado:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jComboBox3.setBackground(new java.awt.Color(47, 50, 65));
        jComboBox3.setForeground(new java.awt.Color(255, 215, 179));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aprobado", "Reprobado" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 230, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 215, 179));
        jLabel6.setText("Tipo de Examen:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jComboBox4.setBackground(new java.awt.Color(47, 50, 65));
        jComboBox4.setForeground(new java.awt.Color(255, 215, 179));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teórico", "Práctico", "Médico" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 230, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 215, 179));
        jLabel8.setText("Nombre del centro:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));

        carnetIDJTextField4.setBackground(new java.awt.Color(47, 50, 65));
        carnetIDJTextField4.setForeground(new java.awt.Color(204, 204, 204));
        carnetIDJTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetIDJTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(carnetIDJTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, 40));

        AddjButton1.setBackground(new java.awt.Color(232, 152, 70));
        AddjButton1.setText("Añadir");
        AddjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddjButton1ActionPerformed(evt);
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 600));

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
    private javax.swing.JTextField carnetIDJTextField3;
    private javax.swing.JTextField carnetIDJTextField4;
    private javax.swing.JButton deletejButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}
