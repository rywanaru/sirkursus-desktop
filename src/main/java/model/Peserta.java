package model;

public class Peserta extends Orang {
    private String nim;
    private String prodi;
    private String jenisKelamin;
    private String email;

    // 1. Constructor kosong
    public Peserta() {
        super();
    }

    // 2. Constructor lama khusus untuk file-file praktikum di package app (Agar app tidak error)
    public Peserta(int id, String nama, String noHp, String nim, String prodi) {
        super(id, nama, noHp);
        this.nim = nim;
        this.prodi = prodi;
    }

    // 3. Constructor lengkap untuk Form Pendaftaran & Database XAMPP
    public Peserta(String nim, String nama, String jenisKelamin, String prodi, String noHp, String email) {
        super(0, nama, noHp);
        this.nim = nim;
        this.prodi = prodi;
        this.jenisKelamin = jenisKelamin;
        this.email = email;
    }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getProdi() { return prodi; }
    public void setProdi(String prodi) { this.prodi = prodi; }

    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String getInfo() {
        return "PESERTA | " + super.getInfo() + " | NIM: " + nim + " | Prodi: " + prodi;
    }
}