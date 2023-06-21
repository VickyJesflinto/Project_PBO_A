package com.layout;

import java.util.Scanner;

import com.controllers.DbController;

public class Delete {
    public static void showDeleteData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Silahkan Pilih Data yang Ingin Dihapus");
        System.out.println("--------------------------------");
        DbController.getDatabase();
        System.out.println("--------------------------------");
        System.out.print("> Pilih ID Produk: ");
        Integer id = sc.nextInt();
        System.out.println("================================");

        if (DbController.deleteData(id)) {
            System.out.println("Berhasil Menghapus Data");
        } else {
            System.out.println("Maaf, Gagal Menghapus Data");
        }

        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }
}

