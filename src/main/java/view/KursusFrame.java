package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class KursusFrame extends JFrame {

    private JTextField txtKodeKursus, txtNamaKursus, txtBiaya;
    private JComboBox<String> cmbLevel;
    private JTable table;
    private JButton btnSimpan, btnEdit, btnHapus, btnReset;

    public KursusFrame() {
        setTitle("Master Kursus - SIKURSUS Desktop");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 520);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 242, 250));
        setContentPane(mainPanel);

        // Header Banner
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(120, 102, 155));
        headerPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        JLabel lblTitle = new JLabel("Form Master Kursus");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(Color.WHITE);
        headerPanel.add(lblTitle);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Form Content Panel
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setOpaque(false);
        contentPanel.setBorder(new EmptyBorder(20, 25, 20, 25));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        // Kode Kursus
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblKode = new JLabel("Kode Kursus");
        lblKode.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblKode.setForeground(new Color(91, 75, 108));
        contentPanel.add(lblKode, gbc);

        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtKodeKursus = new JTextField(20);
        contentPanel.add(txtKodeKursus, gbc);

        // Nama Kursus
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.0;
        JLabel lblNama = new JLabel("Nama Kursus");
        lblNama.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNama.setForeground(new Color(91, 75, 108));
        contentPanel.add(lblNama, gbc);

        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNamaKursus = new JTextField(20);
        contentPanel.add(txtNamaKursus, gbc);

        // Level
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel lblLevel = new JLabel("Level");
        lblLevel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblLevel.setForeground(new Color(91, 75, 108));
        contentPanel.add(lblLevel, gbc);

        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        cmbLevel = new JComboBox<>(new String[]{"BEGINNER", "INTERMEDIATE", "ADVANCED"});
        contentPanel.add(cmbLevel, gbc);

        // Biaya
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel lblBiaya = new JLabel("Biaya (Rp)");
        lblBiaya.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblBiaya.setForeground(new Color(91, 75, 108));
        contentPanel.add(lblBiaya, gbc);

        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtBiaya = new JTextField(20);
        contentPanel.add(txtBiaya, gbc);

        // Tombol Aksi
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 10));
        btnPanel.setOpaque(false);
        
        btnSimpan = new JButton("SIMPAN");
        btnSimpan.setBackground(new Color(120, 102, 155));
        btnSimpan.setForeground(Color.WHITE);
        btnSimpan.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSimpan.addActionListener(e -> JOptionPane.showMessageDialog(this, "Data Kursus berhasil disimpan."));

        btnEdit = new JButton("EDIT");
        btnEdit.setBackground(new Color(233, 226, 243));
        btnEdit.setForeground(new Color(91, 75, 108));
        btnEdit.setFont(new Font("Segoe UI", Font.BOLD, 12));

        btnHapus = new JButton("HAPUS");
        btnHapus.setBackground(new Color(233, 226, 243));
        btnHapus.setForeground(new Color(91, 75, 108));
        btnHapus.setFont(new Font("Segoe UI", Font.BOLD, 12));

        btnReset = new JButton("RESET");
        btnReset.setBackground(new Color(233, 226, 243));
        btnReset.setForeground(new Color(91, 75, 108));
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnReset.addActionListener(e -> { txtKodeKursus.setText(""); txtNamaKursus.setText(""); txtBiaya.setText(""); });

        btnPanel.add(btnSimpan);
        btnPanel.add(btnEdit);
        btnPanel.add(btnHapus);
        btnPanel.add(btnReset);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        contentPanel.add(btnPanel, gbc);

        // Tabel
        table = new JTable(new Object[][]{}, new String[]{"Kode Kursus", "Nama Kursus", "Level", "Biaya"});
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(650, 140));

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        contentPanel.add(scroll, gbc);

        mainPanel.add(contentPanel, BorderLayout.CENTER);
    }
}