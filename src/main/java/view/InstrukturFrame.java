package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InstrukturFrame extends JFrame {

    private JTextField txtId, txtNama, txtKeahlian, txtNoHp;
    private JTable table;
    private JButton btnSimpan, btnEdit, btnHapus, btnReset;

    // --- COLOR PALETTE: MODERN LIGHT GRAY (SLATE THEME) ---
    private static final Color COLOR_BG = new Color(241, 245, 249);         // Slate 100
    private static final Color COLOR_HEADER_BG = Color.WHITE;               // Header bersih
    private static final Color COLOR_CARD_BG = Color.WHITE;                 // Card putih bersih
    private static final Color COLOR_TEXT_DARK = new Color(15, 23, 42);     // Slate 900
    private static final Color COLOR_TEXT_MUTED = new Color(100, 116, 139); // Slate 500
    private static final Color COLOR_ACCENT = new Color(79, 70, 229);       // Indigo modern
    private static final Color COLOR_BORDER = new Color(226, 232, 240);     // Slate 200
    private static final Color COLOR_BTN_BG = new Color(248, 250, 252);     // Slate 50

    public InstrukturFrame() {
        setTitle("Master Instruktur - SIKURSUS Desktop");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(COLOR_BG);
        setContentPane(mainPanel);

        // --- HEADER BANNER ---
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(COLOR_HEADER_BG);
        headerPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BORDER),
            new EmptyBorder(18, 25, 18, 25)
        ));

        JLabel lblTitle = new JLabel("Form Master Instruktur");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(COLOR_TEXT_DARK);
        headerPanel.add(lblTitle, BorderLayout.WEST);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // --- FORM CONTENT PANEL (CARD) ---
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);
        contentPanel.setBorder(new EmptyBorder(20, 25, 10, 25));

        JPanel formCard = new JPanel(new GridBagLayout());
        formCard.setBackground(COLOR_CARD_BG);
        formCard.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDER, 1, true),
            new EmptyBorder(25, 30, 25, 30)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // ID Instruktur
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblId = new JLabel("ID Instruktur");
        lblId.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblId.setForeground(COLOR_TEXT_DARK);
        formCard.add(lblId, gbc);

        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtId = new JTextField(20);
        txtId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        formCard.add(txtId, gbc);

        // Nama Instruktur
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.0;
        JLabel lblNama = new JLabel("Nama Instruktur");
        lblNama.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblNama.setForeground(COLOR_TEXT_DARK);
        formCard.add(lblNama, gbc);

        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNama = new JTextField(20);
        txtNama.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        formCard.add(txtNama, gbc);

        // Keahlian
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel lblKeahlian = new JLabel("Bidang Keahlian");
        lblKeahlian.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblKeahlian.setForeground(COLOR_TEXT_DARK);
        formCard.add(lblKeahlian, gbc);

        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtKeahlian = new JTextField(20);
        txtKeahlian.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        formCard.add(txtKeahlian, gbc);

        // Nomor HP
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel lblNoHp = new JLabel("Nomor HP");
        lblNoHp.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblNoHp.setForeground(COLOR_TEXT_DARK);
        formCard.add(lblNoHp, gbc);

        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNoHp = new JTextField(20);
        txtNoHp.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        formCard.add(txtNoHp, gbc);

        // Tombol Aksi
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        btnPanel.setOpaque(false);
        
        btnSimpan = new JButton("SIMPAN");
        btnSimpan.setBackground(COLOR_ACCENT);
        btnSimpan.setForeground(Color.WHITE);
        btnSimpan.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSimpan.setFocusPainted(false);
        btnSimpan.setBorder(BorderFactory.createEmptyBorder(8, 18, 8, 18));
        btnSimpan.addActionListener(e -> JOptionPane.showMessageDialog(this, "Data Instruktur berhasil disimpan."));

        btnEdit = new JButton("EDIT");
        btnEdit.setBackground(COLOR_BTN_BG);
        btnEdit.setForeground(COLOR_TEXT_DARK);
        btnEdit.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnEdit.setFocusPainted(false);
        btnEdit.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDER, 1),
            BorderFactory.createEmptyBorder(7, 16, 7, 16)
        ));

        btnHapus = new JButton("HAPUS");
        btnHapus.setBackground(COLOR_BTN_BG);
        btnHapus.setForeground(COLOR_TEXT_DARK);
        btnHapus.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnHapus.setFocusPainted(false);
        btnHapus.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDER, 1),
            BorderFactory.createEmptyBorder(7, 16, 7, 16)
        ));

        btnReset = new JButton("RESET");
        btnReset.setBackground(COLOR_BTN_BG);
        btnReset.setForeground(COLOR_TEXT_DARK);
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnReset.setFocusPainted(false);
        btnReset.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDER, 1),
            BorderFactory.createEmptyBorder(7, 16, 7, 16)
        ));
        btnReset.addActionListener(e -> { txtId.setText(""); txtNama.setText(""); txtKeahlian.setText(""); txtNoHp.setText(""); });

        btnPanel.add(btnSimpan);
        btnPanel.add(btnEdit);
        btnPanel.add(btnHapus);
        btnPanel.add(btnReset);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.insets = new Insets(15, 10, 5, 10);
        formCard.add(btnPanel, gbc);

        contentPanel.add(formCard, BorderLayout.CENTER);
        mainPanel.add(contentPanel, BorderLayout.NORTH);

        // --- TABEL PANEL ---
        table = new JTable(new Object[][]{}, new String[]{"ID Instruktur", "Nama Instruktur", "Bidang Keahlian", "Nomor HP"});
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.setRowHeight(24);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createLineBorder(COLOR_BORDER, 1));

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setOpaque(false);
        tablePanel.setBorder(new EmptyBorder(10, 25, 25, 25));
        tablePanel.add(scroll, BorderLayout.CENTER);

        mainPanel.add(tablePanel, BorderLayout.CENTER);
    }
}