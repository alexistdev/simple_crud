# simple_crud

##Simple application for movie catalogue with Backend Springboot and Frontend Angular
</br>
<img src="https://github.com/alexistdev/simple_crud/blob/main/image/simple1.png?raw=true" width="450px">
<img src="https://github.com/alexistdev/simple_crud/blob/main/image/simple2.png?raw=true" width="450px">
## Installasi springboot:
- git clone 
- buka folder : BE
- buka file: src/main/resources/application.properties dan ubah port menjadi 8901, sesuaikan dengan kebutuhan anda.
- Jalankan Xampp dan Buat database kosong dengan nama: movie
- ketik di terminal : mvn install
- Jalankan springboot : springboot:run
- Buka postman dan test dengan menjalankan tambah movie [post] localhost:8091/api/movie
- isi body dengan format json:

  <pre>
    {
    "title" : "Transformer: Rise of Beasts",
    "director": "Steven Caple Jr.",
    "summary" : "Kembali ke aksi dan tontonan yang telah memikat penonton bioskop di seluruh dunia",
    "genres" : [
            {
                "id":1,
                "name" : "Action"
            },
            {
                "id":4,
                "name" : "Sci-Fi"
            }
    ]
},
  </pre>

## Installasi Angular:
- git clone
- buka folder : FE
- jalankan diterminal: npm install
- jalankan di terminal: ng serve
- url nya: http://localhost:4200/movies
- Angular dijalankan setelah springboot dijalankan terlebih dahulu!

