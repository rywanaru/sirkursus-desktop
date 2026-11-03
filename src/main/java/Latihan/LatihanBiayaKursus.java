








package Latihan; //package

public class LatihanBiayaKursus {       //class
    public static void main(String[] args) {        //mainmethod
        
//variabel
String kode = "JAVA-BSC";
String nama = "Java Desktop Fundamental";
double biaya = 500_000;
double diskon = 0.15;
boolean aktif = true;
double potongan = biaya * diskon;
double total = biaya - potongan;

//deklarasi / output
System.out.println("Kode   : " + kode);
System.out.println("Kursus : " + nama);
System.out.println("Aktif  : " + aktif);
System.out.printf("Total  : Rp%,.0f%n", total);
    
}
}