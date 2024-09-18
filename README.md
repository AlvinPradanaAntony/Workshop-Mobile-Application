# Workshop Mobile Application based on Java
### Android Java Projects Practice Snippet
- [AppwithFragments](#fragment)
- [AppwithIntent](#intent)
- [ImplementasiSQLite](#implementasi-sqlite)
- [ManagementFile](#management-file)
- [RecycleView](#recyclerview)
- [Retrovolley](#retrovolley)
- [SelectionWidget](#selection-widget)
- [JsonAPI and MoviesDB](#jsonapi-and-moviesdb)
- [Flow](#flow)
<hr>

> [!TIP]
> Repositori ini berisi aplikasi berbasis mobile menggunakan bahasa pemrograman JAVA. Rekomendasi penggunaan versi Gradle adalah versi 7.2 sampai 8.xx. Versi JDK yang digunakan minimum versi 11 keatas

### Selection Widget 
<p align="center">
<img align="center" src="https://github.com/user-attachments/assets/0e1a0e52-1c68-43f3-bfba-89c8e7e366e5" width="214" height="454">
</p>
<br>

### RecyclerView
<p align="center">
<img align="center" src="https://github.com/user-attachments/assets/30e518fd-20e1-4053-afbc-d3d90c3f2810" width="214" height="454">
</p>
<br>

### Fragment
<p align="center">
<img align="center" src="https://github.com/user-attachments/assets/b1317d4b-964f-4d3d-a8ec-b5deaed0e553" width="214" height="454">
</p>
<br>

### Intent
<p align="center">
<img align="center" src="https://github.com/user-attachments/assets/fb2e30ff-89f9-4aab-85a3-746d58f1dee2" width="214" height="454">
</p>
<br>

### Management File
<p align="center">
<img align="center" src="https://github.com/user-attachments/assets/392898a1-d786-429a-8296-49622eb6b854" width="214" height="454">
</p>
<br>

### Implementasi SQLite
<p align="center">
<img align="center" src="https://github.com/user-attachments/assets/7ab340b4-c211-426e-adaf-2f5d700496d7" width="214" height="454">
</p>
<br>

### Retrovolley
<p align="center">
<img align="center" src="https://github.com/user-attachments/assets/fd00ec90-3f86-47a1-a075-7f0c9ca026ea" width="214" height="454">
</p>
<br>

### JsonAPI and MoviesDB
| Home | JSON | JSON API | Movies DB |
|------------|-----------------|-----------------|-----------------|
| ![Home](https://github.com/user-attachments/assets/1dc0d4c8-6b92-49b0-9c03-905c973be75a)| ![JSON API](https://github.com/user-attachments/assets/29fd9ccf-b280-4756-97cf-60cef1fc9e7d) | ![JSON API](https://github.com/user-attachments/assets/4c08d7cc-2dd0-4599-a97a-26cc266ac55f)| ![MOviesDB](https://github.com/user-attachments/assets/112f4ad3-4b42-43ce-9638-29f8207b2c6c)

https://github.com/user-attachments/assets/eed34add-1452-49af-a239-06c123ec5d0d

### Flow
```mermaid
graph TD;
    Tampilan_awal --> JSON;
    Tampilan_awal --> Movies_DB_TMDb;
    Tampilan_awal --> JSON_API;

    JSON --> JSON_API;
    Movies_DB_TMDb --> JSON_API;
```


