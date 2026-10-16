package latihan;

import java.util.Scanner;

public class LatihanBidangDatar {
    public static void main(String[] args) {

        // PERSEGI
        try (Scanner input = new Scanner(System.in)) {
            // PERSEGI
            System.out.println("=== PERSEGI ===");
            System.out.print("Masukkan sisi: ");
            double sisi = input.nextDouble();
            
            double luasPersegi = sisi * sisi;
            double kelilingPersegi = 4 * sisi;
            
            System.out.println("Luas     : " + luasPersegi);
            System.out.println("Keliling : " + kelilingPersegi);
            
            
            // PERSEGI PANJANG
            System.out.println();
            System.out.println("=== PERSEGI PANJANG ===");
            
            System.out.print("Masukkan panjang: ");
            double panjang = input.nextDouble();
            
            System.out.print("Masukkan lebar: ");
            double lebar = input.nextDouble();
            
            double luasPersegiPanjang = panjang * lebar;
            double kelilingPersegiPanjang = 2 * (panjang + lebar);
            
            System.out.println("Luas     : " + luasPersegiPanjang);
            System.out.println("Keliling : " + kelilingPersegiPanjang);
            
            
            // LINGKARAN
            System.out.println();
            System.out.println("=== LINGKARAN ===");
            
            System.out.print("Masukkan jari-jari: ");
            double jariJari = input.nextDouble();
            
            double luasLingkaran = Math.PI * jariJari * jariJari;
            double kelilingLingkaran = 2 * Math.PI * jariJari;
            
            System.out.printf("Luas     : %.2f%n", luasLingkaran);
            System.out.printf("Keliling : %.2f%n", kelilingLingkaran);
        }
    }
}