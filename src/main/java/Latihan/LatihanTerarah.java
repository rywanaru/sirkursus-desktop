package Latihan; //package
public class LatihanTerarah {
     public static void main(String[] args) { //main mehode
      
String kode = "JAVA-BSC"; //variabel
String nama = "Java Desktop Fundamental";

double biaya = 2_400_000;
double regis = 500_000;

double diskonq = 0.05;
double diskon = 0.10;
double diskonw = 0.15;

boolean aktif = true;

double total = biaya + regis;

  if (total >= 3_000_000 ){

            double potongan = total * diskonw;
            double totalBayar = total - potongan;

            System.out.println("Total      : Rp" + total);
            System.out.println("Diskon 10% : Rp" + potongan);
            System.out.println("Total Bayar: Rp" + totalBayar);
            System.out.println("Status     : MAHAL");

        } else if (total <3_000_000) {

            double potongan = total * diskon;
            double totalBayar = total - potongan;

            System.out.println("Total      : Rp" + total);
            System.out.println("Diskon 5%  : Rp" + potongan);
            System.out.println("Total Bayar: Rp" + totalBayar);
            System.out.println("Status     : TERJANGKAU");
        } else{
            double potongan = total * diskonq;
            double totalBayar = total - potongan;

            System.out.println("Total      : Rp" + total);
            System.out.println("Diskon 5%  : Rp" + potongan);
            System.out.println("Total Bayar: Rp" + totalBayar);
            System.out.println("Status     : TERJANGKAU");
        }
    }
}