# App.java
Didalam 'App.java' terdapat object showMenu

Menu.showMenu();
Bertujuan untuk menampilkan menu yang berisi Read, Insert, Edit, Delete, dan Exit

# com
Terdapat beberapa package, yaitu:
1. config
2. controllers
3. layout
4. models

## 1. config
MyConfig.java : Bertujuan untuk menghubungkan program dengan server localhost masing-masing

## 2. controllers
DbController.java : Berfungsi sebagai pengontrol akses setiap menu dari program ke database

## 3. layout
### 3.1 Delete
Delete.java : Berfungsi untuk menampilkan isi menu untuk menghapus data yang diinginkan

### 3.2 Edit
Edit.java : Berfungsi untuk menampilkan isi menu untuk mengubah data yang diinginkan, seperti nama, harga, atau stok

### 3.3 Insert
Insert.java : Berfungsi untuk menampilkan isi menu untuk menambahkan data baru sesuai keinginan

### 3.4 Menu
Menu.java : Berfungsi untuk menampilkan isi menu seperti Read, Insert, Edit, Delete dan Exit, serta pesan jika pilihan dari menu tidak ada

### 3.5 Read
Read.java : Berfungsi untuk mengambil dan menampilkan data-data yang terdapat di database 

## 4. models
Produk.java : Class yang berisi constructor dan method untuk menggambil(getter) dan mengisi(set) data ke objek, atau disebut juga inisialisasi objek


