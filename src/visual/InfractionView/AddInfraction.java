package visual.InfractionView;

import models.Infraction;
import models.InfractionType;
import models.License;
import services.ServicesLocator;
import visual.MainScreen.MainScreen;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * * @author adian
 */public class AddInfraction extends javax.swing.JDialog {

    /**
     * Creates new form AddInfraction     */    public AddInfraction(MainScreen parent, License license) {
        super(parent, true);
        initComponents(parent,license);
    }

    /**
     * This method is called from within the constructor to initialize the form.     * WARNING: Do NOT modify this code. The content of this method is always     * regenerated by the Form Editor.     */    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents(MainScreen parent, License license) {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TitleLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        infractionType = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        estadoInfraction = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        point = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        infractionID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        AddjButton1 = new javax.swing.JButton();
        deletejButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 22, 28));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel.setText("Añadir Infracción");
        jPanel1.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 260, 40));

        jPanel2.setBackground(new java.awt.Color(23, 22, 28));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleLabel1.setForeground(new java.awt.Color(255, 215, 179));
        TitleLabel1.setText("Añadir Infracción");
        jPanel2.add(TitleLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 260, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 215, 179));
        jLabel7.setText("Puntos:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        descripcion.setBackground(new java.awt.Color(47, 50, 65));
        descripcion.setForeground(new java.awt.Color(204, 204, 204));
        descripcion.getCaret().setBlinkRate(500);
        descripcion.setCaretColor(Color.lightGray);
        descripcion.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetIDJTextField3ActionPerformed(evt);
            }
        });
        jPanel2.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 230, 40));

        infractionType.setBackground(new java.awt.Color(47, 50, 65));
        infractionType.setForeground(new java.awt.Color(255, 215, 179));
        infractionType.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = super.createArrowButton();
                button.setBackground(new java.awt.Color(47, 50, 65)); // Fondo del botón desplegable
                button.setForeground(new java.awt.Color(255, 215, 179)); // Color de la flecha
                return button;
            }
        });
        List<InfractionType> type = ServicesLocator.getInstance().getInfractionTypeServices().getAllInfractionTypes();
        ArrayList<String> list = new ArrayList<>();
        for (InfractionType i : type) {
            list.add(i.getInfractionType());
        }
        String[] arr = list.toArray(new String[list.size()]);
        infractionType.setModel(new javax.swing.DefaultComboBoxModel<>(arr));
        infractionType.addItemListener(new ItemListener() {
            @Override
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
        jPanel2.add(infractionType, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 230, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 215, 179));
        jLabel8.setText("ID de la Infracción:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 215, 179));
        jLabel9.setText("Estado:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        estadoInfraction.setBackground(new java.awt.Color(47, 50, 65));
        estadoInfraction.setForeground(new java.awt.Color(255, 215, 179));
        estadoInfraction.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = super.createArrowButton();
                button.setBackground(new java.awt.Color(47, 50, 65)); // Fondo del botón desplegable
                button.setForeground(new java.awt.Color(255, 215, 179)); // Color de la flecha
                return button;
            }
        });
        estadoInfraction.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pagada", "No pagada" }));
        estadoInfraction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(estadoInfraction, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 230, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 215, 179));
        jLabel10.setText("Descripcion:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 100, -1));

        point.setForeground(new java.awt.Color(255, 215, 179));
        try {
            point.setText("6");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        jPanel2.add(point, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 230, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 215, 179));
        jLabel11.setText("Tipo de infracción:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        infractionID.setBackground(new java.awt.Color(47, 50, 65));
        infractionID.setForeground(new java.awt.Color(204, 204, 204));
        infractionID.getCaret().setBlinkRate(500);
        infractionID.setCaretColor(Color.lightGray);
        infractionID.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        infractionID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetIDJTextField4ActionPerformed(evt);
            }
        });
        jPanel2.add(infractionID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 215, 179));
        jLabel12.setText("Direccion donde se Cometio:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        direccion.setBackground(new java.awt.Color(47, 50, 65));
        direccion.setForeground(new java.awt.Color(204, 204, 204));
        direccion.getCaret().setBlinkRate(500);
        direccion.setCaretColor(Color.lightGray);
        direccion.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetIDJTextField5ActionPerformed(evt);
            }
        });
        jPanel2.add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 230, 40));

        AddjButton1.setBackground(new java.awt.Color(232, 152, 70));
        AddjButton1.setText("Añadir");
        AddjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String idInfraction=infractionID.getText();
                Boolean estado = estadoInfraction.getSelectedItem().toString().equals("Pagada");
                String infractiomType=infractionType.getSelectedItem().toString();
                int points = Integer.parseInt(point.getText());
                String diretions = direccion.getText();
                String description = descripcion.getText();
                if (!idInfraction.equals("") && !estado.equals("") && !infractiomType.equals("") && !description.equals("") && !diretions.equals("")) {
                    try{
                        //String infractionCode, String licenseId, String violationType, Date date, String location,
                        //                      String description, int points, boolean ispaid                        LocalDate createDate=LocalDate.now();
                        Date creact=Date.valueOf(LocalDate.now());
                        System.out.println(license.getLicenseId());
                        ServicesLocator.getInstance().getInfractionServices().createInfraction(new Infraction(idInfraction,license.getLicenseId(),infractiomType,creact,diretions,description,points,estado));
                        parent.Actualizar(4);
                        dispose();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                else {

                }            }
        });
        jPanel2.add(AddjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 120, 30));

        deletejButton.setForeground(new java.awt.Color(153, 0, 0));
        deletejButton.setText("Salir");
        deletejButton.setFocusable(false);
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });
        jPanel2.add(deletejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 120, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 560));

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
        int respuesta=JOptionPane.showConfirmDialog(null, "Está seguro que desea cerrar esta ventana?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==0){
            dispose();
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton AddjButton1;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel TitleLabel1;
    private javax.swing.JTextField descripcion;
    private javax.swing.JTextField infractionID;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton deletejButton;
    private javax.swing.JComboBox<String> infractionType;
    private javax.swing.JComboBox<String> estadoInfraction;
    private javax.swing.JLabel point;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration  
}