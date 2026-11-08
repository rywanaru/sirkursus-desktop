package view;

import dao.UserDAO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.User;
import util.UserSession;

public class LoginFrame extends JFrame {

    private final UserDAO userDAO = new UserDAO();

    // UI Components
    private JTextField txtUsername;
    private JPasswordField pwdPassword;
    private JButton btnLogin;
    private JButton btnKeluar;
    private JButton btnToggleShow;
    private JLabel lblTitle;
    private JLabel lblSubTitle;
    private JLabel lblUsername;
    private JLabel lblPassword;

    // --- COLOR PALETTE: MODERN LIGHT GRAY (SLATE & INDIGO THEME) ---
    private static final Color COLOR_BG = new Color(241, 245, 249);         // Slate 100 (Background utama clean)
    private static final Color COLOR_CARD_BG = Color.WHITE;                 // Card putih bersih
    private static final Color COLOR_TEXT_DARK = new Color(15, 23, 42);     // Slate 900 (Teks utama tajam)
    private static final Color COLOR_TEXT_MUTED = new Color(100, 116, 139); // Slate 500 (Subteks)
    private static final Color COLOR_ACCENT = new Color(79, 70, 229);       // Indigo modern untuk tombol/brand
    private static final Color COLOR_ACCENT_HOVER = new Color(67, 56, 202); // Indigo gelap untuk hover
    private static final Color COLOR_BORDER = new Color(226, 232, 240);     // Slate 200 untuk garis input/border

    public LoginFrame() {
        initComponents();
        setLocationRelativeTo(null); // Menampilkan form di tengah layar
    }

    private void initComponents() {
        setTitle("Login - SIKURSUS Desktop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(440, 520);
        setResizable(false);

        // Fonts (Segoe UI Modern)
        Font fontTitle = new Font("Segoe UI", Font.BOLD, 22);
        Font fontSubtitle = new Font("Segoe UI", Font.PLAIN, 12);
        Font fontLabel = new Font("Segoe UI", Font.BOLD, 13);
        Font fontInput = new Font("Segoe UI", Font.PLAIN, 13);
        Font fontButton = new Font("Segoe UI", Font.BOLD, 13);

        // Main Background Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(COLOR_BG);
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(24, 24, 24, 24));
        setContentPane(mainPanel);

        // Form Card Panel
        JPanel cardPanel = new JPanel();
        cardPanel.setBackground(COLOR_CARD_BG);
        cardPanel.setLayout(new BorderLayout());
        cardPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDER, 1, true),
                new EmptyBorder(35, 35, 35, 35)
        ));

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(COLOR_CARD_BG);
        headerPanel.setLayout(new GridLayout(2, 1, 0, 6));

        lblTitle = new JLabel("SIKURSUS Desktop", SwingConstants.CENTER);
        lblTitle.setFont(fontTitle);
        lblTitle.setForeground(COLOR_TEXT_DARK);

        lblSubTitle = new JLabel("Sistem Informasi Manajemen Kursus & Pelatihan", SwingConstants.CENTER);
        lblSubTitle.setFont(fontSubtitle);
        lblSubTitle.setForeground(COLOR_TEXT_MUTED);

        headerPanel.add(lblTitle);
        headerPanel.add(lblSubTitle);

        // Form Input Panel
        JPanel formPanel = new JPanel();
        formPanel.setBackground(COLOR_CARD_BG);
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.weightx = 1.0;

        // Username Label & Input
        lblUsername = new JLabel("Username");
        lblUsername.setFont(fontLabel);
        lblUsername.setForeground(COLOR_TEXT_DARK);
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(lblUsername, gbc);

        txtUsername = new JTextField();
        txtUsername.setFont(fontInput);
        txtUsername.setBackground(COLOR_CARD_BG);
        txtUsername.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDER, 1, true),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(txtUsername, gbc);

        // Password Label & Input
        lblPassword = new JLabel("Password");
        lblPassword.setFont(fontLabel);
        lblPassword.setForeground(COLOR_TEXT_DARK);
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(lblPassword, gbc);

        // Panel khusus untuk menggabungkan JPasswordField dan Tombol Lihat Password
        JPanel pwdPanel = new JPanel(new BorderLayout(0, 0));
        pwdPanel.setBackground(COLOR_CARD_BG);

        pwdPassword = new JPasswordField();
        pwdPassword.setFont(fontInput);
        pwdPassword.setBackground(COLOR_CARD_BG);
        pwdPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDER, 1, true),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));

        // Tombol Toggle Lihat/Sembunyikan Password
        btnToggleShow = new JButton("👁");
        btnToggleShow.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
        btnToggleShow.setBackground(new Color(248, 250, 252));
        btnToggleShow.setForeground(COLOR_TEXT_MUTED);
        btnToggleShow.setFocusPainted(false);
        btnToggleShow.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnToggleShow.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 1, 1, COLOR_BORDER),
                BorderFactory.createEmptyBorder(0, 12, 0, 12)
        ));

        // Action Listener untuk menampilkan/menyembunyikan password
        btnToggleShow.addActionListener(e -> {
            if (pwdPassword.getEchoChar() != 0) {
                pwdPassword.setEchoChar((char) 0); // Tampilkan password
                btnToggleShow.setText("🔒");
            } else {
                pwdPassword.setEchoChar('•'); // Sembunyikan password kembali
                btnToggleShow.setText("👁");
            }
        });

        pwdPanel.add(pwdPassword, BorderLayout.CENTER);
        pwdPanel.add(btnToggleShow, BorderLayout.EAST);

        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(pwdPanel, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(COLOR_CARD_BG);
        buttonPanel.setLayout(new GridLayout(1, 2, 12, 0));
        buttonPanel.setBorder(new EmptyBorder(22, 0, 0, 0));

        btnLogin = new JButton("Login");
        btnLogin.setFont(fontButton);
        btnLogin.setBackground(COLOR_ACCENT);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        btnKeluar = new JButton("Keluar");
        btnKeluar.setFont(fontButton);
        btnKeluar.setBackground(COLOR_CARD_BG);
        btnKeluar.setForeground(COLOR_TEXT_DARK);
        btnKeluar.setFocusPainted(false);
        btnKeluar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnKeluar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDER, 1, true),
                BorderFactory.createEmptyBorder(9, 0, 9, 0)
        ));
        btnKeluar.addActionListener(this::btnKeluarActionPerformed);

        buttonPanel.add(btnLogin);
        buttonPanel.add(btnKeluar);

        cardPanel.add(headerPanel, BorderLayout.NORTH);
        cardPanel.add(formPanel, BorderLayout.CENTER);
        cardPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(cardPanel);

        getRootPane().setDefaultButton(btnLogin);
    }

    // Event Handler Tombol Login
    private void btnLoginActionPerformed(ActionEvent evt) {
        String username = txtUsername.getText().trim();
        char[] password = pwdPassword.getPassword();

        if (username.isEmpty() || password.length == 0) {
            JOptionPane.showMessageDialog(this,
                    "Username dan password wajib diisi.",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        btnLogin.setEnabled(false);

        try {
            User user = userDAO.authenticate(username, password);
            if (user == null) {
                JOptionPane.showMessageDialog(this,
                        "Login gagal. Periksa username, password, atau status user.",
                        "Login Gagal",
                        JOptionPane.WARNING_MESSAGE);
                pwdPassword.setText("");
                pwdPassword.requestFocus();
                return;
            }

            UserSession.setCurrentUser(user);
            dispose();
            SwingUtilities.invokeLater(
                    () -> new DashboardFrame().setVisible(true));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Tidak dapat mengakses database: " + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            Arrays.fill(password, '\0');
            btnLogin.setEnabled(true);
            setCursor(Cursor.getDefaultCursor());
        }
    }

    // Event Handler Tombol Keluar
    private void btnKeluarActionPerformed(ActionEvent evt) {
        System.exit(0);
    }
}