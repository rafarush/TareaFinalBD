package visual;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.function.Consumer;

public class CustomTable extends JTable {
    private Consumer<Integer> rowDoubleClickListener;

    public CustomTable(List<String> columnNames, Object[][] data) {
        // Configurar modelo
        DefaultTableModel model = new DefaultTableModel(data, columnNames.toArray()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setModel(model);
        
        // Aplicar estilos
        applyTableStyles();
        
        // Configurar listener de doble click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = rowAtPoint(e.getPoint());
                    if (row >= 0 && rowDoubleClickListener != null) {
                        rowDoubleClickListener.accept(row);
                    }
                }
            }
        });
    }

    public void setRowDoubleClickListener(Consumer<Integer> listener) {
        this.rowDoubleClickListener = listener;
    }

    private void applyTableStyles() {
        // Estilos básicos
        setBackground(new Color(47, 50, 65));
        setForeground(new Color(255, 215, 179));
        setFont(new Font("Arial", Font.PLAIN, 14));
        setRowHeight(30);
        setGridColor(Color.GRAY);
        
        // Encabezado
        JTableHeader header = getTableHeader();
        header.setBackground(new Color(23, 22, 28));
        header.setForeground(new Color(255, 215, 179));
        header.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Centrar contenido
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
}