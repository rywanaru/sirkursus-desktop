package view;

import dao.PesertaDAO;
import model.Peserta;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class FormPeserta extends javax.swing.JFrame {
    // Palet warna selaras dengan tampilan Master Data Peserta & DashboardFrame
    private static final Color NAVY_DARK = new Color(16, 59, 86);      // #103B56 (Header & Tombol Utama)
    private static final Color ICE_BLUE_BG = new Color(227, 238, 245);  // #E3EEF5 (Background Form)
    private static final Color BTN_RESET_BG = new Color(214, 230, 242); // #D6E6F2 (Tombol Sekunder / Reset)
    private static final Color TEXT_DARK = new Color(25, 39, 52);       // #192734 (Label & Teks Utama)
    private static final Color BORDER_SOFT = new Color(176, 200, 218);  // #B0C8DA (Garis Batas)

    private JPanel jPanel4, jPanel5;
    private JLabel jLabel19, jLabel20, jLabel21, jLabel22, jLabel23, jLabel24, jLabel25, jLabel26, jLabel27, jLabel28, jLabel29;
    private JTextPane txtNim, txtNama, txtProdi, txtNoHp, txtEmail, txtRingkasanPendaftaran;
    private JPasswordField txtKodeAkses;
    private JRadioButton rbLaki, rbPerempuan;
    private ButtonGroup bgJk;
    private JComboBox<String> cmbPilihanKursus;
    private JCheckBox cbModulCetak, cbSertifikat, cbAksesRekaman;
    private JButton btnProsesPendaftaran, btnResetForm;
    private PesertaDAO pesertaDAO;

    public FormPeserta() {
        pesertaDAO = new PesertaDAO();
        initComponents();
        setTitle("Form Pendaftaran Kursus - SIKURSUS Desktop");
        setSize(820, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        jPanel4 = new JPanel();
        jPanel4.setBackground(ICE_BLUE_BG);
        jPanel4.setLayout(null);
        jPanel4.setPreferredSize(new Dimension(780, 850));

        // Header Panel
        jPanel5 = new JPanel();
        jPanel5.setBackground(NAVY_DARK);
        jPanel5.setBounds(0, 0, 820, 65);
        jPanel5.setLayout(null);

        jLabel19 = new JLabel("Form Pendaftaran Kelas", JLabel.CENTER);
        jLabel19.setForeground(Color.WHITE);
        jLabel19.setFont(new Font("Segoe UI", Font.BOLD, 22));
        jLabel19.setBounds(0, 15, 820, 35);
        jPanel5.add(jLabel19);
        jPanel4.add(jPanel5);

        int startY = 85;
        int gap = 45;

        // NIM
        jLabel20 = createLabel("Nim", 50, startY, 120, 25);
        jPanel4.add(jLabel20);
        txtNim = new JTextPane();
        JScrollPane spNim = createScrollPane(txtNim, 180, startY, 540, 30);
        jPanel4.add(spNim);

        // Nama Peserta
        startY += gap;
        jLabel21 = createLabel("Nama Peserta", 50, startY, 120, 25);
        jPanel4.add(jLabel21);
        txtNama = new JTextPane();
        JScrollPane spNama = createScrollPane(txtNama, 180, startY, 540, 30);
        jPanel4.add(spNama);

        // Jenis Kelamin
        startY += gap;
        jLabel22 = createLabel("Jenis Kelamin", 50, startY, 120, 25);
        jPanel4.add(jLabel22);

        rbLaki = new JRadioButton("Laki-Laki");
        rbLaki.setBounds(180, startY, 100, 25);
        rbLaki.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        rbLaki.setForeground(TEXT_DARK);
        rbLaki.setOpaque(false);

        rbPerempuan = new JRadioButton("Perempuan");
        rbPerempuan.setBounds(380, startY, 110, 25);
        rbPerempuan.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        rbPerempuan.setForeground(TEXT_DARK);
        rbPerempuan.setOpaque(false);

        bgJk = new ButtonGroup();
        bgJk.add(rbLaki);
        bgJk.add(rbPerempuan);
        jPanel4.add(rbLaki);
        jPanel4.add(rbPerempuan);

        // Program Studi
        startY += gap;
        jLabel23 = createLabel("Program Studi", 50, startY, 120, 25);
        jPanel4.add(jLabel23);
        txtProdi = new JTextPane();
        JScrollPane spProdi = createScrollPane(txtProdi, 180, startY, 540, 30);
        jPanel4.add(spProdi);

        // Nomor Hp
        startY += gap;
        jLabel24 = createLabel("Nomor Hp", 50, startY, 120, 25);
        jPanel4.add(jLabel24);
        txtNoHp = new JTextPane();
        JScrollPane spNoHp = createScrollPane(txtNoHp, 180, startY, 540, 30);
        jPanel4.add(spNoHp);

        // Email
        startY += gap;
        jLabel25 = createLabel("Email", 50, startY, 120, 25);
        jPanel4.add(jLabel25);
        txtEmail = new JTextPane();
        JScrollPane spEmail = createScrollPane(txtEmail, 180, startY, 540, 30);
        jPanel4.add(spEmail);

        // Kode Akses
        startY += gap;
        jLabel26 = createLabel("Kode Akses", 50, startY, 120, 25);
        jPanel4.add(jLabel26);
        txtKodeAkses = new JPasswordField();
        txtKodeAkses.setBounds(180, startY, 540, 30);
        txtKodeAkses.setBackground(Color.WHITE);
        txtKodeAkses.setForeground(TEXT_DARK);
        txtKodeAkses.setBorder(BorderFactory.createLineBorder(BORDER_SOFT, 1));
        jPanel4.add(txtKodeAkses);

        // Pilihan Kursus
        startY += gap;
        jLabel28 = createLabel("kursus", 50, startY, 120, 25);
        jPanel4.add(jLabel28);
        cmbPilihanKursus = new JComboBox<>(new String[] { "-Pilih Kursus-", "UI/UX", "Pemrograman Java Desktop", "Pemrograman Web", "Database MySQL", "Dasar-Dasar Pemrograman" });
        cmbPilihanKursus.setBounds(180, startY, 540, 30);
        cmbPilihanKursus.setBackground(Color.WHITE);
        cmbPilihanKursus.setForeground(TEXT_DARK);
        jPanel4.add(cmbPilihanKursus);

        // Fasilitas
        startY += gap;
        jLabel27 = createLabel("Fasilitas", 50, startY, 120, 25);
        jPanel4.add(jLabel27);

        cbModulCetak = new JCheckBox("Modul Cetak");
        cbModulCetak.setBounds(180, startY, 115, 25);
        cbModulCetak.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cbModulCetak.setForeground(TEXT_DARK);
        cbModulCetak.setOpaque(false);

        cbSertifikat = new JCheckBox("Sertifikat");
        cbSertifikat.setBounds(330, startY, 90, 25);
        cbSertifikat.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cbSertifikat.setForeground(TEXT_DARK);
        cbSertifikat.setOpaque(false);

        cbAksesRekaman = new JCheckBox("Akses Rekaman");
        cbAksesRekaman.setBounds(500, startY, 130, 25);
        cbAksesRekaman.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cbAksesRekaman.setForeground(TEXT_DARK);
        cbAksesRekaman.setOpaque(false);

        jPanel4.add(cbModulCetak);
        jPanel4.add(cbSertifikat);
        jPanel4.add(cbAksesRekaman);

        // Ringkasan
        startY += gap;
        jLabel29 = createLabel("Ringkasan", 50, startY, 120, 25);
        jPanel4.add(jLabel29);

        txtRingkasanPendaftaran = new JTextPane();
        txtRingkasanPendaftaran.setEditable(false);
        JScrollPane spRingkasan = createScrollPane(txtRingkasanPendaftaran, 180, startY, 540, 120);
        jPanel4.add(spRingkasan);

        // Tombol Proses & Reset
        startY += 140;
        btnProsesPendaftaran = new JButton("PROSES");
        btnProsesPendaftaran.setBounds(180, startY, 110, 35);
        btnProsesPendaftaran.setOpaque(true);
        btnProsesPendaftaran.setContentAreaFilled(true);
        btnProsesPendaftaran.setBackground(NAVY_DARK);
        btnProsesPendaftaran.setForeground(Color.WHITE);
        btnProsesPendaftaran.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnProsesPendaftaran.addActionListener(e -> btnProsesPendaftaranActionPerformed());
        jPanel4.add(btnProsesPendaftaran);

        btnResetForm = new JButton("RESET");
        btnResetForm.setBounds(305, startY, 110, 35);
        btnResetForm.setOpaque(true);
        btnResetForm.setContentAreaFilled(true);
        btnResetForm.setBackground(BTN_RESET_BG);
        btnResetForm.setForeground(NAVY_DARK);
        btnResetForm.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnResetForm.addActionListener(e -> btnResetFormActionPerformed());
        jPanel4.add(btnResetForm);

        // Bungkus dengan JScrollPane utama
        JScrollPane mainScrollPane = new JScrollPane(jPanel4);
        mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setContentPane(mainScrollPane);
    }

    private JLabel createLabel(String text, int x, int y, int w, int h) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, w, h);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(TEXT_DARK);
        return label;
    }

    private JScrollPane createScrollPane(JTextPane textPane, int x, int y, int w, int h) {
        textPane.setBackground(Color.WHITE);
        textPane.setForeground(TEXT_DARK);
        JScrollPane sp = new JScrollPane(textPane);
        sp.setBounds(x, y, w, h);
        sp.setBorder(BorderFactory.createLineBorder(BORDER_SOFT, 1));
        return sp;
    }

    private void resetForm() {
        txtNim.setText("");
        txtNama.setText("");
        bgJk.clearSelection();
        txtProdi.setText("");
        txtNoHp.setText("");
        txtEmail.setText("");
        txtKodeAkses.setText("");
        cmbPilihanKursus.setSelectedIndex(0);
        cbModulCetak.setSelected(false);
        cbSertifikat.setSelected(false);
        cbAksesRekaman.setSelected(false);
        txtRingkasanPendaftaran.setText("");
        txtNim.requestFocus();
    }

    private void btnResetFormActionPerformed() {
        int jawab = JOptionPane.showConfirmDialog(this, "Kosongkan seluruh input?", "Konfirmasi Reset", JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION) {
            resetForm();
        }
    }

    private void btnProsesPendaftaranActionPerformed() {
        String nim = txtNim.getText().trim();
        String nama = txtNama.getText().trim();
        String jenisKelamin = rbLaki.isSelected() ? "L" : (rbPerempuan.isSelected() ? "P" : "");
        String prodi = txtProdi.getText().trim();
        String noHp = txtNoHp.getText().trim();
        String email = txtEmail.getText().trim();
        String kursus = cmbPilihanKursus.getSelectedItem().toString();

        if (nim.isEmpty() || nama.isEmpty() || prodi.isEmpty() || jenisKelamin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "NIM, Nama, Prodi, dan Jenis Kelamin wajib diisi!", "Peringatan Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double biayaDasar = 0;
        if (kursus.contains("Java") || kursus.equalsIgnoreCase("Pemrograman Java Desktop")) {
            biayaDasar = 500000;
        } else if (kursus.contains("UI/UX")) {
            biayaDasar = 400000;
        } else if (kursus.contains("Web")) {
            biayaDasar = 600000;
        } else if (kursus.contains("Database")) {
            biayaDasar = 450000;
        } else {
            biayaDasar = 350000;
        }

        double biayaFasilitas = 0;
        StringBuilder rincianFasilitas = new StringBuilder();

        if (cbModulCetak.isSelected()) {
            biayaFasilitas += 75000;
            rincianFasilitas.append("  - Modul Cetak\n");
        }
        if (cbSertifikat.isSelected()) {
            biayaFasilitas += 50000;
            rincianFasilitas.append("  - Sertifikat\n");
        }
        if (cbAksesRekaman.isSelected()) {
            biayaFasilitas += 100000;
            rincianFasilitas.append("  - Akses Rekaman\n");
        }

        if (rincianFasilitas.length() == 0) {
            rincianFasilitas.append("  - Tidak Ada\n");
        }

        double totalBiaya = biayaDasar + biayaFasilitas;

        java.text.NumberFormat nf = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("id", "ID"));
        nf.setMaximumFractionDigits(0);

        StringBuilder sb = new StringBuilder();
        sb.append("PENDAFTARAN & PENYIMPANAN DATA\n");
        sb.append("====================================\n");
        sb.append(String.format("%-15s : %s\n", "NIM", nim));
        sb.append(String.format("%-15s : %s\n", "Nama", nama));
        sb.append(String.format("%-15s : %s\n", "Gender", jenisKelamin.equals("L") ? "Laki-laki" : "Perempuan"));
        sb.append(String.format("%-15s : %s\n", "Prodi", prodi));
        sb.append(String.format("%-15s : %s\n", "No HP", noHp));
        sb.append(String.format("%-15s : %s\n", "Email", email));
        sb.append(String.format("%-15s : %s\n", "Kursus", kursus));
        sb.append(String.format("%-15s : %s\n", "Biaya Dasar", nf.format(biayaDasar)));
        sb.append("Fasilitas:\n");
        sb.append(rincianFasilitas.toString());
        sb.append("====================================\n");
        sb.append(String.format("%-15s : %s\n", "TOTAL BIAYA", nf.format(totalBiaya)));

        txtRingkasanPendaftaran.setText(sb.toString());

        try {
            Peserta peserta = new Peserta();
            peserta.setNim(nim);
            peserta.setNama(nama);
            peserta.setJenisKelamin(jenisKelamin);
            peserta.setProdi(prodi);
            peserta.setNoHp(noHp);
            peserta.setEmail(email);

            boolean sukses = pesertaDAO.insert(peserta);
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data peserta berhasil disimpan ke database XAMPP!", "Informasi Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan ke database:\n" + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        EventQueue.invokeLater(() -> new FormPeserta().setVisible(true));
    }
}