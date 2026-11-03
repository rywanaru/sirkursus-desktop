package model;

public class Orang {
<<<<<<< HEAD
    private int id;
    private String nama;
    private String noHp;

    // CONSTRUCTOR DEFAULT (Wajib Ada agar Peserta() tidak error)
    public Orang() {
    }

    // CONSTRUCTOR DENGAN PARAMETER
=======
    protected int id;
    protected String nama;
    protected String noHp;

    public Orang() {
        // Constructor kosong
    }

>>>>>>> 7c1b6e3bb4c536df5c2bdc944fc51c33649d0772
    public Orang(int id, String nama, String noHp) {
        this.id = id;
        this.nama = nama;
        this.noHp = noHp;
    }

<<<<<<< HEAD
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getInfo() {
        return "ID: " + id + " | Nama: " + nama + " | No. HP: " + noHp;
    }
=======
    public String getInfo() {
        return "ID: " + id + " | Nama: " + nama + " | No HP: " + noHp;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }
>>>>>>> 7c1b6e3bb4c536df5c2bdc944fc51c33649d0772
}