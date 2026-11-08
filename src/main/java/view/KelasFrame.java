package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class KelasFrame extends JFrame {

    private JTextField txtIdKelas, txtNamaKelas, txtJadwal;
    private JTable table;
    private JButton btnSimpan, btnEdit, btnHapus, btnReset;

    public KelasFrame() {
        setTitle("Master Kelas - SIKURSUS Desktop");
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
        JLabel lblTitle = new JLabel("Form Master Kelas");
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

        // ID Kelas
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblId = new JLabel("ID Kelas");
        lblId.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblId.setForeground(new Color(91, 75, 108));
        contentPanel.add(lblId, gbc);

        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        txtIdKelas = new JTextField(20);
        contentPanel.add(txtIdKelas, gbc);

        // Nama Kelas
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.0;
        JLabel lblNama = new JLabel("Nama Kelas");
        lblNama.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNama.setForeground(new Color(91, 75, 108));
        contentPanel.add(lblNama, gbc);

        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNamaKelas = new JTextField(20);
        contentPanel.add(txtNamaKelas, gbc);

        // Jadwal
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel lblJadwal = new JLabel("Jadwal Pertemuan");
        lblJadwal.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblJadwal.setForeground(new Color(91, 75, 108));
        contentPanel.add(lblJadwal, gbc);

        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtJadwal = new JTextField(20);
        contentPanel.add(txtJadwal, gbc);

        // Tombol Aksi
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 10));
        btnPanel.setOpaque(false);
        
        btnSimpan = new JButton("SIMPAN");
        btnSimpan.setBackground(new Color(120, 102, 155));
        btnSimpan.setForeground(Color.WHITE);
        btnSimpan.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSimpan.addActionListener(e -> JOptionPane.showMessageDialog(this, "Data Kelas berhasil disimpan."));

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
        btnReset.addActionListener(e -> { txtIdKelas.setText(""); txtNamaKelas.setText(""); txtJadwal.setText(""); });

        btnPanel.add(btnSimpan);
        btnPanel.add(btnEdit);
        btnPanel.add(btnHapus);
        btnPanel.add(btnReset);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        contentPanel.add(btnPanel, gbc);

        // Tabel
        table = new JTable(new Object[][]{}, new String[]{"ID Kelas", "Nama Kelas", "Jadwal Pertemuan"});
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(650, 160));

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        contentPanel.add(scroll, gbc);

        mainPanel.add(contentPanel, BorderLayout.CENTER);
    }
}