package visual;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JtextFielCarnet extends javax.swing.JTextField {
    public JtextFielCarnet() {
        addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                JTextField text =(JTextField)e.getSource();
                if(text.getText().length()==limite){
                    e.consume();
                }
                if(c<'0' || c>'9'){
                    e.consume();
                }
            }
        });
    }
    private int limite=-1;
    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        if(limite>=1){
            this.limite = limite;
        }
    }
}
