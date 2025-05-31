package visual.LoginScreen;

import models.User;
import services.ServicesLocator;
import utils.PasswordUtil;
import visual.MainScreen.MainScreen;
import visual.ReportScreen.ReportScreen;
import visual.ReportView.ReportView;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {

    private static final Color DARK_GRAY = new Color(23, 22, 28);
    private static final Color SIDEBAR_GRAY = new Color(47, 50, 65);
    private static final Color ORANGE = new Color(255, 140, 0);
    private static final Font LABEL_FONT = new Font("Segoe UI", Font.PLAIN, 16);
    private static final Font FIELD_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    private static final Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 16);
    private static final Font ERROR_FONT = new Font("Segoe UI", Font.BOLD, 14);

    public LoginScreen() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Inicio de Sesión");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar ventana
        setResizable(false);

        JPanel panel = new JPanel(null);
        panel.setBackground(DARK_GRAY);

        // Label Usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(LABEL_FONT);
        userLabel.setBounds(50, 50, 80, 25);
        panel.add(userLabel);

        // Campo Usuario
        JTextField userText = new JTextField();
        userText.setBounds(150, 50, 180, 25);
        userText.setFont(FIELD_FONT);
        userText.setBackground(SIDEBAR_GRAY);
        userText.setForeground(Color.WHITE);
        userText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.add(userText);

        // Label Contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(LABEL_FONT);
        passwordLabel.setBounds(50, 100, 90, 25);
        panel.add(passwordLabel);

        // Campo Contraseña
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(150, 100, 180, 25);
        passwordText.setFont(FIELD_FONT);
        passwordText.setBackground(SIDEBAR_GRAY);
        passwordText.setForeground(Color.WHITE);
        passwordText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.add(passwordText);

        // Botón Iniciar Sesión
        JButton loginButton = new JButton("Acceder");
        loginButton.setBounds(135, 160, 130, 38);
        loginButton.setFont(BUTTON_FONT);
        loginButton.setBackground(ORANGE);
        loginButton.setForeground(Color.BLACK);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(loginButton);

        // Label Error centrado
        JLabel errorLabel = new JLabel("", SwingConstants.CENTER);
        errorLabel.setBounds(50, 210, 300, 30);
        errorLabel.setForeground(new Color(255, 85, 85)); // rojo suave
        errorLabel.setFont(ERROR_FONT);
        panel.add(errorLabel);

        loginButton.addActionListener(e -> {
            String username = userText.getText().trim();
            String password = new String(passwordText.getPassword());

            try {
                User user = ServicesLocator.getInstance().getUserServices().getUser(username);
                if(user != null && PasswordUtil.checkPassword(password, user.getPassword())) {
                    openWindowsOnRole(user);
                    dispose();
                }else {
                    errorLabel.setText("Usuario o contraseña incorrectos.");
                }
            } catch (Exception ex) {
                errorLabel.setText("Error de conexión o validación.");
                ex.printStackTrace();
            }
        });

        add(panel);
    }

    private void openWindowsOnRole(User user) {
        switch (user.getRole()) {
            case "admin":
                new MainScreen(true).setVisible(true);
                break;
            case "client":
                new ReportScreen().setVisible(true);
                //new ReportView(null).setVisible(true);
                break;
            case "manager":
                new MainScreen(false).setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Rol desconocido: " + user.getRole());
        }
    }
}
