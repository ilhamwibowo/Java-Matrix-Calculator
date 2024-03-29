package src;

import java.util.Scanner;


import java.util.*;


public class Main {

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 6) {
        System.out.println("MENU");        
        System.out.println("1. Sistem Persamaan Linear");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks Balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Regresi Linier Berganda");
        System.out.println("6. Keluar");
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();
        if (choice == 1) {
            int baris, kolom;
            matriksParametrik m;
            System.out.println("1. Metode eliminasi Gauss");
            System.out.println("2. Metode eliminasi Gauss-Jordan");
            System.out.println("3. Metode matriks balikan");
            System.out.println("4. Kaidah Cramer");
            int splPilih = scan.nextInt();
            
            if (splPilih == 1){
                    System.out.print("Banyak persamaan : ");
                    baris = scan.nextInt();
                    System.out.print("Banyak variable : ");
                    kolom = scan.nextInt();
                    System.out.println("Masukkan persamaan : ");
                    m = new matriksParametrik(baris, kolom + 1);
                m.readMatrix();
                m.displayMatrix();
                System.out.println("Memulai algoritma");
                    try{
                        m.rowEsMatrix();
                        m.displayMatrix();
                        System.out.println("^ Matrix hasil eliminasi Gauss ^");
                        m.genStatus();
                        m.parametrikGauss();
                        System.out.println("Solusi Persamaan Linier : ");
		                String hasil = m.printhasil();
		                System.out.println(hasil);
                    } catch(noSolution n){
                        System.out.println("Tidak ada solusi");
                        }
            }
                
            else if(splPilih == 2){
                    System.out.print("Banyak persamaan : ");
                    baris = scan.nextInt();
                    System.out.print("Banyak variable : ");
                    kolom = scan.nextInt();
                    System.out.println("Masukkan persamaan : ");
                    m = new matriksParametrik(baris, kolom + 1);
                m.readMatrix();
                m.displayMatrix();
                    try{
                        m.reducedRowMatrix();
                        m.displayMatrix();
                        System.out.println("^ Matrix hasil eliminasi Gauss ^");
                        m.genStatus();
                        m.parametrikGJ();
                        System.out.println("Solusi Persamaan Linier : ");
		                String hasil = m.printhasil();
		                System.out.println(hasil);
                    } catch(noSolution n){
                        System.out.println("Tidak ada solusi");
                        }
            }
            else if(splPilih == 3){
                System.out.println("Masukkan ukuran matriks (NxN):");
                int N = scan.nextInt();
                matriks m1 = new matriks(N, N);
                System.out.println("Masukkan elemen matriks : ");
                m1.readMatrix();
                SPL.SPLInvers(m1, "x");
            }
            else if(splPilih == 4){
                System.out.println("Masukkan ukuran matriks (NxN):");
                int N = scan.nextInt();
                matriks m1 = new matriks(N, N);
                System.out.println("Masukkan elemen matriks : ");
                m1.readMatrix();
                SPL.SPLCramer(m1, "X");
            }

        }
        else if (choice == 2) {
            System.out.println("1. Metode Eliminasi Gauss");
            System.out.println("2. Metode Ekspansi Kofaktor");
            int x = scan.nextInt();
            if (x == 1) {
                System.out.println("Masukkan ukuran matriks (matriks harus berbentuk persegi NxN): ");
                int N = scan.nextInt();
                System.out.println("Masukkan elemen matriks : ");
                matriks m = new matriks(N, N);
                m.readMatrix();
                System.out.println("Matriks eselon barisnya adalah : ");
                m.rowEsMatrix();
                m.displayMatrix();
                System.out.println("Determinannya adalah : " );
                System.out.print(matriks.determinan_gauss(m) + "\n");
            } 
            else if ( x == 2) {
                System.out.println("Masukkan ukuran matriks (matriks harus berbentuk persegi NxN): ");
                int N = scan.nextInt();
                System.out.println("Masukkan elemen matriks : ");
                matriks m = new matriks(N, N);
                m.readMatrix();
                System.out.println("Determinannya adalah : " );
                System.out.print(matriks.determinan_kofaktor(m));
                
            }
        } 
        else if (choice == 3) {
            System.out.println("1. Metode Adjoint");
            System.out.println("2. Metode Gauss-Jordan");
            int x = scan.nextInt();
            if (x == 1) {
                System.out.println("Masukkan ukuran matriks (NxN):");
                int N = scan.nextInt();
                matriks m = new matriks(N, N);
                System.out.println("Masukkan elemen matriks : ");
                m.readMatrix();
                matriks minv = new matriks(N,N);
                if (m.balikanAdjoin(m, minv)){
                    System.out.println("Balikan dari matriks adalah");
                    minv.displayMatrix();
                } 
                else {
                    System.out.println("Matriks tidak memiliki balikan!");
                } 
                }
            
            else {
                System.out.println("Masukkan ukuran matriks (NxN):");
                int N = scan.nextInt();
                matriks m = new matriks(N, N);
                System.out.println("Masukkan elemen matriks : ");
                m.readMatrix();
                System.out.println("Jika hasil sama, matriks tidak memiliki balikan! ");
                matriks minv = new matriks(N,N);
                matriks.balikanGJ(m, minv);
                minv.displayMatrix();
            }
        }


        else if (choice == 4) {
            System.out.println("Masukkan jumlah titik yang diinginkan : ");
            int N = scan.nextInt();
            interpolasi.solusi(N);
        }
        else if (choice == 5) {
            System.out.println("Masukkan jumlah data yang diinginkan : ");
            int Ndat = scan.nextInt();
            System.out.println("Masukkan jumlah variabel yang diinginkan : ");
            int Nvar = scan.nextInt();
            regresi.solusiRegresi(Ndat,Nvar);
        }
        else if (choice == 6) {
            System.out.println("Selamat tinggal!");
        }
        else {
            System.out.println("Input tidak valid! Ulangi lagi!");
            scan.close();
        }
    }



    }
} 

