package com.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import com.config.MyConfig;
import com.models.Produk;

public class DbController extends MyConfig {

    public static ArrayList<Produk> getDatabase() {
        connection();
        ArrayList<Produk> list_prod = new ArrayList<>();
        try {
            // query = "SELECT nama, harga, stok FROM tb_produk ORDER BY ID DESC";
            query = "SELECT * FROM tb_produk";

            statement = connect.prepareStatement(query);
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                System.out.println(
                    resultSet.getString("ID") + ". " +
                    resultSet.getString("NAMA") + 
                    " - Rp." + resultSet.getString("HARGA") + 
                    " - Stok:" + resultSet.getString("JUMLAH")
                );
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_prod;
    }

    public static Produk getProdukByNama(int id) {
        Produk produk = null;
        connection();
        query = "SELECT * FROM tb_produk WHERE ID=?";
        try {
            statement = connect.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                produk = new Produk(resultSet.getInt("id"), resultSet.getString("nama"), resultSet.getLong("harga"), resultSet.getInt("jumlah"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produk;
    }

    public static boolean insertData(String nama, long harga, int jumlah) {
        connection();
        query = "INSERT INTO tb_produk (nama, harga, jumlah) VALUES (?, ?, ?)";
        try {
            statement = connect.prepareStatement(query);
            statement.setString(1, nama);
            statement.setLong(2, harga);
            statement.setInt(3, jumlah);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void updateNama(int id, String nama) {
        connection();
        query = "UPDATE tb_produk SET nama=? WHERE id=?";
        try {
            statement = connect.prepareStatement(query);
            statement.setString(1, nama);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateHarga(int id, long harga) {
        connection();
        query = "UPDATE tb_produk SET harga=? WHERE id=?";
        try {
            statement = connect.prepareStatement(query);
            statement.setLong(1, harga);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateJumlah(int id, int jumlah) {
        connection();
        query = "UPDATE tb_produk SET jumlah=? WHERE id=?";
        try {
            statement = connect.prepareStatement(query);
            statement.setInt(1, jumlah);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteData(String id) {
        connection();
        query = "DELETE FROM tb_produk WHERE id=?";
        try {
            statement = connect.prepareStatement(query);
            statement.setString(1, id);
            int affectedRowDelete = statement.executeUpdate();
            if (affectedRowDelete > 0) {
                return true;
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
