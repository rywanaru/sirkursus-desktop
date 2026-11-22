package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.sql.Date;
import javax.swing.*;
import model.User;
import report.ReportService;
import util.UserSession;
import util.WindowManager;

public class DashboardFrame extends JFrame {
    // Palet warna biru selaras dengan tampilan Master Data Peserta
    private static final Color NAVY_DARK = new Color(16, 59, 86);      // #103B56 (Header & Aksen Utama)
    private static final Color ICE_BLUE_BAR = new Color(214, 230, 242); // #D6E6F2 (Menu Bar)
    private static final Color ICE_BLUE_BG = new Color(227, 238, 245);  // #E3EEF5 (Background Utama)
    private static final Color CARD_WHITE = Color.WHITE;                // #FFFFFF (Card / Panel Konten)
    private static final Color BORDER_SOFT = new Color(176, 200, 218);  // #B0C8DA (Garis Batas)
    private static final Color TEXT_DARK = new Color(25, 39, 52);       // #192734 (Teks Utama)
    private static final Color TEXT_MUTED = new Color(92, 112, 128);    // #5C7080 (Teks Sekunder)

    private final JLabel lblUser = new JLabel();
    private final JLabel lblRole = new JLabel();
    private final JMenuItem miUsers = new JMenuItem("Users");
    private final JMenuItem miPeserta = new JMenuItem("Peserta");
    private final JMenuItem miInstruktur = new JMenuItem("Instruktur");
    private final JMenuItem miKursus = new JMenuItem("Kursus");
    private final JMenuItem miKelas = new JMenuItem("Kelas");

    public DashboardFrame() {
        super("Dashboard - SIKURSUS Desktop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ViewUtil.setupFrame(this, 1040, 650);
        buildMenu();
        buildBody();
        applySession();
    }

    private void buildBody() {
        JPanel root = ViewUtil.root("SIKURSUS Desktop - Dashboard");
        root.setOpaque(true);
        root.setBackground(ICE_BLUE_BG);

        // Menyamakan warna banner header atas dengan biru tua (#103B56)
        if (root.getLayout() instanceof BorderLayout) {
            Component north = ((BorderLayout) root.getLayout()).getLayoutComponent(BorderLayout.NORTH);
            if (north instanceof JComponent) {
                JComponent header = (JComponent) north;
                header.setOpaque(true);
                header.setBackground(NAVY_DARK);
            }
        }

        JPanel body = ViewUtil.body();
        body.setOpaque(true);
        body.setBackground(ICE_BLUE_BG);

        JPanel session = new JPanel(new GridLayout(2, 1, 4, 4));
        session.setOpaque(true);
        session.setBackground(CARD_WHITE);
        session.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_SOFT, 1),
                BorderFactory.createEmptyBorder(12, 16, 12, 16)
        ));

        lblUser.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblUser.setForeground(NAVY_DARK);
        lblRole.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblRole.setForeground(TEXT_MUTED);
        session.add(lblUser);
        session.add(lblRole);
        body.add(ViewUtil.section("Sesi Pengguna", session), BorderLayout.NORTH);

        JTextArea info = new JTextArea(
                "FINAL PROJECT PBO - Pertemuan 9-14\n\n"
                + "Gunakan menu di bagian atas untuk mengelola master, transaksi, dan laporan.\n\n"
                + "Alur utama:\n"
                + "Master Data -> Kelas -> Pendaftaran -> Pembayaran -> Laporan\n\n"
                + "Database : db_sikursus\n"
                + "Arsitektur: View -> DAO -> JDBC -> MySQL\n\n"
                + "Tips: selesaikan master terlebih dahulu sebelum menguji transaksi."
        );
        info.setEditable(false);
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        info.setForeground(TEXT_DARK);
        info.setBackground(CARD_WHITE);
        info.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_SOFT, 1),
                BorderFactory.createEmptyBorder(20, 24, 20, 24)
        ));
        body.add(ViewUtil.section("Ringkasan Sistem", info), BorderLayout.CENTER);

        root.add(body, BorderLayout.CENTER);
        setContentPane(root);
    }

    private void buildMenu() {
        JMenuBar bar = new JMenuBar();
        bar.setOpaque(true);
        bar.setBackground(ICE_BLUE_BAR);
        bar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_SOFT));

        JMenu master = createStyledMenu("Master");
        master.add(miUsers);
        master.add(miPeserta);
        master.add(miInstruktur);
        master.add(miKursus);
        master.add(miKelas);

        JMenu trx = createStyledMenu("Transaksi");
        JMenuItem reg = new JMenuItem("Pendaftaran");
        JMenuItem pay = new JMenuItem("Pembayaran");
        trx.add(reg);
        trx.add(pay);

        JMenu rep = createStyledMenu("Laporan");
        JMenuItem rp = new JMenuItem("Peserta - Semua");
        JMenuItem rr = new JMenuItem("Pendaftaran - Semua");
        JMenuItem rt = new JMenuItem("Pembayaran - Semua");
        JMenuItem rtp = new JMenuItem("Pembayaran - Rentang Tanggal");
        rep.add(rp);
        rep.add(rr);
        rep.add(rt);
        rep.add(rtp);

        JMenu out = createStyledMenu("Keluar");
        JMenuItem logout = new JMenuItem("Logout");
        JMenuItem exit = new JMenuItem("Tutup Aplikasi");
        out.add(logout);
        out.addSeparator();
        out.add(exit);

        styleMenuItems(master, trx, rep, out);

        bar.add(master);
        bar.add(trx);
        bar.add(rep);
        bar.add(out);
        setJMenuBar(bar);

        miUsers.addActionListener(e -> WindowManager.open(UserFrame.class, UserFrame::new));
        miPeserta.addActionListener(e -> WindowManager.open(PesertaFrame.class, PesertaFrame::new));
        miInstruktur.addActionListener(e -> WindowManager.open(InstrukturFrame.class, InstrukturFrame::new));
        miKursus.addActionListener(e -> WindowManager.open(KursusFrame.class, KursusFrame::new));
        miKelas.addActionListener(e -> WindowManager.open(KelasFrame.class, KelasFrame::new));
        reg.addActionListener(e -> WindowManager.open(PendaftaranFrame.class, PendaftaranFrame::new));
        pay.addActionListener(e -> WindowManager.open(PembayaranFrame.class, PembayaranFrame::new));
        rp.addActionListener(e -> ReportService.showPeserta(this));
        rr.addActionListener(e -> ReportService.showPendaftaranSemua(this));
        rt.addActionListener(e -> ReportService.showPembayaranSemua(this));
        rtp.addActionListener(e -> showPaymentPeriod());
        logout.addActionListener(e -> logout());
        exit.addActionListener(e -> System.exit(0));

        miPeserta.setIcon(loadIcon("/icons/peserta.png"));
        miInstruktur.setIcon(loadIcon("/icons/instruktur.png"));
        miKursus.setIcon(loadIcon("/icons/kursus.png"));
        miKelas.setIcon(loadIcon("/icons/kelas.png"));
    }

    private JMenu createStyledMenu(String title) {
        JMenu menu = new JMenu(title);
        menu.setForeground(NAVY_DARK);
        menu.setFont(new Font("Segoe UI", Font.BOLD, 12));
        return menu;
    }

    private void styleMenuItems(JMenu... menus) {
        Font itemFont = new Font("Segoe UI", Font.PLAIN, 12);
        for (JMenu menu : menus) {
            menu.getPopupMenu().setBackground(CARD_WHITE);
            menu.getPopupMenu().setBorder(BorderFactory.createLineBorder(BORDER_SOFT, 1));
            for (Component c : menu.getMenuComponents()) {
                if (c instanceof JMenuItem) {
                    JMenuItem item = (JMenuItem) c;
                    item.setOpaque(true);
                    item.setBackground(CARD_WHITE);
                    item.setForeground(TEXT_DARK);
                    item.setFont(itemFont);
                }
            }
        }
    }

    private ImageIcon loadIcon(String path) {
        URL u = getClass().getResource(path);
        if (u == null) return null;
        Image img = new ImageIcon(u).getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    private void applySession() {
        User u = UserSession.getCurrentUser();
        if (u == null) {
            dispose();
            SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
            return;
        }
        lblUser.setText("Pengguna: " + u.getUsername());
        lblRole.setText("Role: " + u.getRole());
        boolean admin = u.isAdmin();
        miUsers.setEnabled(admin);
        miInstruktur.setEnabled(admin);
        miKursus.setEnabled(admin);
        miKelas.setEnabled(admin);
        miPeserta.setEnabled(true);
    }

    private void showPaymentPeriod() {
        String a = JOptionPane.showInputDialog(this, "Tanggal awal (yyyy-MM-dd):", ViewUtil.today());
        if (a == null) return;
        String b = JOptionPane.showInputDialog(this, "Tanggal akhir (yyyy-MM-dd):", ViewUtil.today());
        if (b == null) return;
        try {
            ReportService.showPembayaranPeriode(this, Date.valueOf(a.trim()), Date.valueOf(b.trim()));
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Format tanggal harus yyyy-MM-dd.");
        }
    }

    private void logout() {
        WindowManager.closeAll();
        UserSession.clear();
        dispose();
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}