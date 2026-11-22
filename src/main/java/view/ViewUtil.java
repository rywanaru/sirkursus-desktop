package view;

import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import util.LookupItem;

/**
 * Design system sederhana untuk seluruh form SIKURSUS Desktop.
 * Gaya selaras dengan tampilan Master Data Peserta: header biru navy,
 * latar biru keabu-abuan lembut, form lapang, tombol aksi jelas, dan tabel rapi.
 */
public final class ViewUtil {
    public static final Color BG = new Color(227, 238, 245);           // #E3EEF5 (Background Utama)
    public static final Color CARD = Color.WHITE;                       // #FFFFFF (Card / Panel Konten)
    public static final Color HEADER = new Color(16, 59, 86);           // #103B56 (Header Utama)
    public static final Color PRIMARY = new Color(23, 92, 134);         // #175C86 (Tombol Utama / Aksen Biru)
    public static final Color PRIMARY_DARK = new Color(16, 59, 86);     // #103B56 (Tombol Ubah / Judul Seksi)[cite: 1]
    public static final Color SUCCESS = new Color(24, 128, 92);         // #18805C (Tombol Simpan / Cari)[cite: 1]
    public static final Color DANGER = new Color(196, 54, 54);          // #C43636 (Tombol Hapus)[cite: 1]
    public static final Color SECONDARY = new Color(92, 112, 128);      // #5C7080 (Tombol Reset / Netral)[cite: 1]
    public static final Color BORDER = new Color(176, 200, 218);        // #B0C8DA (Garis Batas)[cite: 1]
    public static final Color TEXT = new Color(25, 39, 52);             // #192734 (Teks Utama)
    public static final Color MUTED = new Color(92, 112, 128);          // #5C7080 (Teks Sekunder)

    private static final Color SELECTION_BG = new Color(209, 229, 244); // #D1E5F4 (Highlight Baris Tabel)
    private static final Color TABLE_HEADER_BG = new Color(16, 59, 86); // #103B56 (Header Tabel)[cite: 1]

    private ViewUtil() {}

    public static DefaultTableModel tableModel(String... columns) {
        return new DefaultTableModel(columns, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
    }

    public static void setupFrame(JFrame frame, int width, int height) {
        frame.setSize(width, height);
        frame.setMinimumSize(new Dimension(Math.min(width, 760), Math.min(height, 520)));
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(BG);
    }

    public static JPanel root(String title) {
        JPanel root = new JPanel(new BorderLayout());
        root.setOpaque(true);
        root.setBackground(BG);
        root.add(header(title), BorderLayout.NORTH);
        return root;
    }

    public static JPanel header(String title) {
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(true);
        header.setBackground(HEADER);
        header.setPreferredSize(new Dimension(100, 70));
        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        header.add(label, BorderLayout.CENTER);
        return header;
    }

    public static JPanel body() {
        JPanel panel = new JPanel(new BorderLayout(0, 12));
        panel.setOpaque(true);
        panel.setBackground(BG);
        panel.setBorder(new EmptyBorder(18, 22, 20, 22));
        return panel;
    }

    public static JPanel formPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(true);
        panel.setBackground(BG);
        panel.setBorder(new EmptyBorder(4, 2, 8, 2));
        return panel;
    }

    public static void addFormRow(JPanel panel, int row, String text, JComponent component) {
        JLabel label = new JLabel(text);
        label.setForeground(TEXT);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        GridBagConstraints lc = new GridBagConstraints();
        lc.gridx = 0;
        lc.gridy = row;
        lc.anchor = GridBagConstraints.WEST;
        lc.insets = new Insets(7, 0, 7, 18);
        lc.ipadx = 8;
        panel.add(label, lc);

        styleInput(component);
        GridBagConstraints fc = new GridBagConstraints();
        fc.gridx = 1;
        fc.gridy = row;
        fc.weightx = 1.0;
        fc.fill = GridBagConstraints.HORIZONTAL;
        fc.anchor = GridBagConstraints.WEST;
        fc.insets = new Insets(7, 0, 7, 0);
        panel.add(component, fc);
    }

    public static void addWideRow(JPanel panel, int row, String text, JComponent component) {
        addFormRow(panel, row, text, component);
    }

    public static void styleInput(JComponent component) {
        component.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        component.setForeground(TEXT);
        if (component instanceof JTextField || component instanceof JComboBox || component instanceof JPasswordField) {
            component.setPreferredSize(new Dimension(420, 34));
            component.setMinimumSize(new Dimension(180, 34));
            component.setBackground(Color.WHITE);
            component.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(BORDER),
                    BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        } else if (component instanceof JCheckBox || component instanceof JRadioButton) {
            component.setBackground(BG);
        }
    }

    public static JButton primaryButton(String text) {
        return button(text, PRIMARY, Color.WHITE);
    }

    public static JButton updateButton(String text) {
        return button(text, PRIMARY_DARK, Color.WHITE);
    }

    public static JButton successButton(String text) {
        return button(text, SUCCESS, Color.WHITE);
    }

    public static JButton dangerButton(String text) {
        return button(text, DANGER, Color.WHITE);
    }

    public static JButton neutralButton(String text) {
        return button(text, SECONDARY, Color.WHITE);
    }

    private static JButton button(String text, Color bg, Color fg) {
        JButton b = new JButton(text);
        b.setFont(new Font("Segoe UI", Font.BOLD, 12));
        b.setForeground(fg);
        b.setBackground(bg);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setOpaque(true);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setPreferredSize(new Dimension(Math.max(105, text.length() * 9 + 30), 36));
        return b;
    }

    public static JPanel actionPanel(JButton... buttons) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 6));
        panel.setOpaque(true);
        panel.setBackground(BG);
        for (JButton button : buttons) panel.add(button);
        return panel;
    }

    public static JPanel searchPanel(String labelText, JTextField field, JButton button) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 7));
        panel.setOpaque(true);
        panel.setBackground(BG);
        JLabel label = new JLabel(labelText);
        label.setForeground(TEXT);
        panel.add(label);
        styleInput(field);
        field.setPreferredSize(new Dimension(230, 34));
        panel.add(field);
        panel.add(button);
        return panel;
    }

    public static JPanel section(String title, JComponent content) {
        JPanel card = new JPanel(new BorderLayout(0, 8));
        card.setOpaque(true);
        card.setBackground(CARD);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                new EmptyBorder(10, 12, 12, 12)));
        if (title != null && !title.trim().isEmpty()) {
            JLabel label = new JLabel(title);
            label.setFont(new Font("Segoe UI", Font.BOLD, 14));
            label.setForeground(PRIMARY_DARK);
            card.add(label, BorderLayout.NORTH);
        }
        card.add(content, BorderLayout.CENTER);
        return card;
    }

    public static JScrollPane tableScroll(JTable table) {
        styleTable(table);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createLineBorder(BORDER));
        scroll.getViewport().setBackground(Color.WHITE);
        return scroll;
    }

    public static void styleTable(JTable table) {
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setRowHeight(28);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionBackground(SELECTION_BG);
        table.setSelectionForeground(TEXT);
        table.setGridColor(BORDER);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.setFillsViewportHeight(true);

        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setOpaque(true);
        table.getTableHeader().setBackground(TABLE_HEADER_BG);
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setPreferredSize(new Dimension(20, 31));

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBorder(new EmptyBorder(0, 7, 0, 7));
        table.setDefaultRenderer(Object.class, renderer);
    }

    public static JLabel note(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        label.setForeground(MUTED);
        return label;
    }

    public static void sqlError(Component parent, String action, SQLException ex) {
        JOptionPane.showMessageDialog(parent,
                action + " gagal.\n" + friendlySqlMessage(ex),
                "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    public static String friendlySqlMessage(SQLException ex) {
        String m = ex.getMessage() == null ? ex.toString() : ex.getMessage();
        if (m.contains("Duplicate entry")) return "Data duplikat ditolak database.\n" + m;
        if (m.toLowerCase().contains("foreign key constraint")) return "Operasi ditolak karena relasi/foreign key masih digunakan.\n" + m;
        return m;
    }

    public static String today() { return LocalDate.now().toString(); }

    public static void selectLookup(JComboBox<LookupItem> combo, int id) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            LookupItem item = combo.getItemAt(i);
            if (item != null && item.getId() == id) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }
}