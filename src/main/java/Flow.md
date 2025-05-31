## Alur membuat projek ini

### 1. Persiapan
```
    1. Siapkan database (sudah siap pakai) dan projek maven
    2. Siapkan dependency di maven
    <!--
        a. Ganti compiler source nya (versi java)
        b. Tambahkan dependency yang diperlukan (Bisa dicari di Search Maven)
            - junit-jupiter (jangan lupa scope nya test)
            - mysql-connector-java
        c. Tambahkan dependency hikaricp (dari github)
    -->
```
### 2. Membuat koneksi database
```
    a. Create package : util
    b. Create file : DatabaseUtil
    c. Create same package and file in test scope
```
### 3. Membuat package di java -> repository
```
    a. Create file : TodoListRepository (interface)
    b. Create file : TodoListRepositoryImpl (class)
    c. Create Testing
```