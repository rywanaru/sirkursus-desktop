package view;

import dao.PesertaDAO;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Peserta;

public class FormPeserta extends JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormPeserta.class.getName());
    private ButtonGroup bgGender;

    public FormPeserta() {
        initComponents();
        initButtonGroup();
        setLocationRelativeTo(null);
    }

    private void initButtonGroup() {
        bgGender = new ButtonGroup();
        bgGender.add(rbLaki);
        bgGender.add(rbPerempuan);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        btnProsesPendaftaran = new javax.swing.JButton();
        btnResetForm = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRingkasanPendaftaran = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        txtKodeAkses = new javax.swing.JPasswordField();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        cmbPilihanKursus = new javax.swing.JComboBox<>();
        cbModulCetak = new javax.swing.JCheckBox();
        cbSertifikat = new javax.swing.JCheckBox();
        cbAksesRekaman = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNoHp = new javax.swing.JTextField();
        txtProdi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Pendaftaran Kelas - SIKURSUS Desktop");

        jPanel1.setBackground(new java.awt.Color(240, 240, 238));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel2.setForeground(new java.awt.Color(75, 75, 70));
        jLabel2.setText("Nim");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel3.setForeground(new java.awt.Color(75, 75, 70));
        jLabel3.setText("Nama Peserta");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel4.setForeground(new java.awt.Color(75, 75, 70));
        jLabel4.setText("Jenis Kelamin");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel5.setForeground(new java.awt.Color(75, 75, 70));
        jLabel5.setText("Program Studi");

        txtNim.setForeground(new java.awt.Color(55, 55, 52));

        btnProsesPendaftaran.setBackground(new java.awt.Color(125, 125, 119));
        btnProsesPendaftaran.setForeground(new java.awt.Color(255, 255, 255));
        btnProsesPendaftaran.setText("Proses");
        btnProsesPendaftaran.addActionListener(this::btnProsesPendaftaranActionPerformed);

        btnResetForm.setBackground(new java.awt.Color(227, 227, 224));
        btnResetForm.setForeground(new java.awt.Color(75, 75, 70));
        btnResetForm.setText("Resest");
        btnResetForm.addActionListener(this::btnResetFormActionPerformed);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel6.setForeground(new java.awt.Color(75, 75, 70));
        jLabel6.setText("Nomor Hp");

        txtRingkasanPendaftaran.setForeground(new java.awt.Color(55, 55, 52));
        jScrollPane2.setViewportView(txtRingkasanPendaftaran);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel7.setForeground(new java.awt.Color(75, 75, 70));
        jLabel7.setText("Email");

        txtKodeAkses.setForeground(new java.awt.Color(55, 55, 52));

        rbLaki.setForeground(new java.awt.Color(75, 75, 70));
        rbLaki.setText("Laki-Laki");

        rbPerempuan.setForeground(new java.awt.Color(75, 75, 70));
        rbPerempuan.setText("Perempuan");

        cmbPilihanKursus.setForeground(new java.awt.Color(55, 55, 52));
        cmbPilihanKursus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "--Pilih Kursus--", "UI/UX", "Pemrograman Java Desktop", "Pemrograman Web", "Database MySQL", "Dasar-Dasar Pemrograman" 
        }));

        cbModulCetak.setForeground(new java.awt.Color(75, 75, 70));
        cbModulCetak.setText("Modul Cetak");

        cbSertifikat.setForeground(new java.awt.Color(75, 75, 70));
        cbSertifikat.setText("Sertifikat");

        cbAksesRekaman.setForeground(new java.awt.Color(75, 75, 70));
        cbAksesRekaman.setText("Akses Rekaman");

        jPanel2.setBackground(new java.awt.Color(167, 167, 162));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form Pendaftaran Kelas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel8.setForeground(new java.awt.Color(75, 75, 70));
        jLabel8.setText("Kursus");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel9.setForeground(new java.awt.Color(75, 75, 70));
        jLabel9.setText("Kode Akses");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel10.setForeground(new java.awt.Color(75, 75, 70));
        jLabel10.setText("Fasilitas");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel11.setForeground(new java.awt.Color(75, 75, 70));
        jLabel11.setText("Ringkasan");

        txtNama.setForeground(new java.awt.Color(55, 55, 52));
        txtEmail.setForeground(new java.awt.Color(55, 55, 52));
        txtNoHp.setForeground(new java.awt.Color(55, 55, 52));
        txtProdi.setForeground(new java.awt.Color(55, 55, 52));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbModulCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cbSertifikat, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(cbAksesRekaman)
                        .addContainerGap(131, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoHp, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProdi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNim, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(txtKodeAkses, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPilihanKursus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(rbLaki, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(rbPerempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(btnProsesPendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnResetForm, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(45, 45, 45))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rbLaki)
                    .addComponent(rbPerempuan))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtKodeAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbPilihanKursus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbModulCetak)
                    .addComponent(cbSertifikat)
                    .addComponent(cbAksesRekaman))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProsesPendaftaran)
                    .addComponent(btnResetForm))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void resetForm() {
        txtNim.setText("");
        txtNama.setText("");
        if (bgGender != null) {
            bgGender.clearSelection();
        } else {
            rbLaki.setSelected(false);
            rbPerempuan.setSelected(false);
        }
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

    private void btnProsesPendaftaranActionPerformed(java.awt.event.ActionEvent evt) {
        String nim = txtNim.getText().trim();
        String nama = txtNama.getText().trim();
        String jenisKelamin = rbLaki.isSelected() ? "L" : (rbPerempuan.isSelected() ? "P" : "");
        String prodi = txtProdi.getText().trim();
        String noHp = txtNoHp.getText().trim();
        String email = txtEmail.getText().trim();
        String kursus = cmbPilihanKursus.getSelectedItem().toString();

        if (nim.isEmpty() || nama.isEmpty() || prodi.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "NIM, Nama, dan Prodi wajib diisi!", 
                "Peringatan Validasi", 
                JOptionPane.WARNING_MESSAGE);
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
        sb.append(String.format("%-15s : %s\n", "Gender", jenisKelamin.equals("L") ? "Laki-laki" : (jenisKelamin.equals("P") ? "Perempuan" : "-")));
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
            Peserta peserta = new Peserta(nim, nama, jenisKelamin, prodi, noHp, email);
            PesertaDAO dao = new PesertaDAO();
            boolean sukses = dao.insert(peserta);

            if (sukses) {
                JOptionPane.showMessageDialog(this, 
                    "Data peserta berhasil disimpan ke database XAMPP!", 
                    "Informasi Sukses", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Gagal menyimpan ke database:\n" + e.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void btnResetFormActionPerformed(java.awt.event.ActionEvent evt) {
        int jawab = JOptionPane.showConfirmDialog(
            this,
            "Kosongkan seluruh input?",
            "Konfirmasi Reset",
            JOptionPane.YES_NO_OPTION);

        if (jawab == JOptionPane.YES_OPTION) {
            resetForm();
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new FormPeserta().setVisible(true));
    }

    private javax.swing.JButton btnProsesPendaftaran;
    private javax.swing.JButton btnResetForm;
    private javax.swing.JCheckBox cbAksesRekaman;
    private javax.swing.JCheckBox cbModulCetak;
    private javax.swing.JCheckBox cbSertifikat;
    private javax.swing.JComboBox<String> cmbPilihanKursus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtKodeAkses;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtNoHp;
    private javax.swing.JTextField txtProdi;
    private javax.swing.JTextPane txtRingkasanPendaftaran;
}