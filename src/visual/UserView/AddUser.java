package visual.UserView;

import models.User;
import services.ServicesLocator;
import visual.MainScreen.MainScreen;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.util.Objects;

public class AddUser extends javax.swing.JDialog {

    /**
     * Creates new form AddUser
     */
    public AddUser(MainScreen parent) {
        super(parent, true);
        initComponents(parent);
    }
    private void initComponents(MainScreen parent) {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        deletejButton = new javax.swing.JButton();
        AddjButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        userRol = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 22, 28));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Añadir Usuario");
        jPanel1.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 210, 40));

        deletejButton.setForeground(new java.awt.Color(153, 0, 0));
        deletejButton.setText("Salir");
        deletejButton.setFocusable(false);
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deletejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 120, 40));

        AddjButton1.setBackground(new java.awt.Color(232, 152, 70));
        AddjButton1.setText("Añadir");
        AddjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String username = userName.getText();
                String pass = password.getText();
                String rol = userRol.getSelectedItem().toString().equalsIgnoreCase("cliente") ? "client" : "manager";
                if(!Objects.equals(username, "") && !Objects.equals(pass, "") && !Objects.equals(rol, "")){
                    try{
                        ServicesLocator.getInstance().getUserServices().createUser(new User(username, pass, rol));
                        parent.Actualizar(6);
                        dispose();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            }
        });
        jPanel1.add(AddjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 120, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 215, 179));
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 60, 30));

        userName.setBackground(new java.awt.Color(47, 50, 65));
        userName.setForeground(new java.awt.Color(204, 204, 204));
        userName.getCaret().setBlinkRate(500);
        userName.setCaretColor(Color.lightGray);
        jPanel1.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 230, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 215, 179));
        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, 30));

        password.setBackground(new java.awt.Color(47, 50, 65));
        password.setForeground(new java.awt.Color(204, 204, 204));
        password.getCaret().setBlinkRate(500);
        password.setCaretColor(Color.lightGray);
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 230, 40));

        userRol.setBackground(new java.awt.Color(47, 50, 65));
        userRol.setForeground(new java.awt.Color(255, 215, 179));
        userRol.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = super.createArrowButton();
                button.setBackground(new java.awt.Color(47, 50, 65)); // Fondo del botón desplegable
                button.setForeground(new java.awt.Color(255, 215, 179)); // Color de la flecha
                return button;
            }
        });
        userRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cliente", "Manager"}));
        jPanel1.add(userRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 230, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 215, 179));
        jLabel11.setText("Rol:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 370));

        pack();
    }// </editor-fold>

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int respuesta= JOptionPane.showConfirmDialog(null, "Está seguro que desea cerrar esta ventana?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==0){
            dispose();
        }
    }
    private javax.swing.JButton AddjButton1;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField userName;
    private javax.swing.JButton deletejButton;
    private javax.swing.JTextField password;
    private javax.swing.JComboBox<String> userRol;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}
