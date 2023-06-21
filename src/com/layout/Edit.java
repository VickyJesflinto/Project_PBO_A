package com.layout;

import java.util.Scanner;

import com.controllers.DbController;
import com.models.Produk;

public class Edit {
    public static void showEditData(Integer id) {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Silahkan Pilih Data yang Ingin Diedit");
        System.out.println("================================");
        DbController.getDatabase();
        System.out.println("================================");
        System.out.print("> Pilih ID Produk: ");
        id = sc.nextInt();

        System.out.println("================================");
        System.out.println("Silahkan Pilih Menu Update Data");
        System.out.println("================================");
        System.out.println("1. Update Nama");
        System.out.println("2. Update Harga");
        System.out.println("3. Update Jumlah");
        System.out.println("4. Back to Menu");

        System.out.println("================================");
        System.out.print("> Pilihan: ");
        try {
            int selectMenu = sc.nextInt();
            switch (selectMenu) {
                case 1:
                    showEditNama(id);
                    break;
                case 2:
                    showEditHarga(id);
                    break;
                case 3:
                    showEditJumlah(id);
                    break;
                case 4:
                    Menu.showMenu();
                    break;
                default:
                    System.out.println("================================");
                    System.out.println("Maaf Produk atau Menu yang Dipilih Tidak Ada");
                    System.out.println("--------------------------------");
                    Menu.showMenu();
            }
        } catch (Exception e) {
            System.out.println("================================");
            System.out.println("Maaf Produk atau Menu yang Dipilih Tidak Ada");
            System.out.println("--------------------------------");
            Menu.showMenu();
        }
        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }

    public static void showEditNama(Integer id) {
        Scanner sc = new Scanner(System.in);
        Produk produk = DbController.getProdukByNama(id);

        System.out.println("================================");
        System.out.println("Edit Nama");
        System.out.println("================================");
        System.out.println("Nama Awal: " + produk.getNama());
        System.out.println("--------------------------------");
        System.out.print("Nama Baru: ");
        String namaBaru = sc.nextLine();
        DbController.updateNama(produk.getId(), namaBaru);

        System.out.println("================================");
        System.out.println("Berhasil Update Data Nama");
        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }

    public static void showEditHarga(Integer id) {
        Scanner sc = new Scanner(System.in);
        Produk produk = DbController.getProdukByNama(id);

        System.out.println("================================");
        System.out.println("Edit Nama");
        System.out.println("================================");
        System.out.println("Harga Awal: " + produk.getHarga());
        System.out.println("--------------------------------");
        System.out.print("Harga Baru: ");
        long hargaBaru = sc.nextLong();
        DbController.updateHarga(produk.getId(), hargaBaru);

        System.out.println("================================");
        System.out.println("Berhasil Update Data Harga");
        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }

    public static void showEditJumlah(Integer id) {
        Scanner sc = new Scanner(System.in);
        Produk produk = DbController.getProdukByNama(id);

        System.out.println("================================");
        System.out.println("Edit Nama");
        System.out.println("================================");
        System.out.println("Jumlah Awal: " + produk.getjumlah());
        System.out.println("--------------------------------");
        System.out.print("Jumlah Baru: ");
        int jumlahBaru = sc.nextInt();
        DbController.updateJumlah(produk.getId(), jumlahBaru);

        System.out.println("================================");
        System.out.println("Berhasil Update Data Stok");
        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }
}

