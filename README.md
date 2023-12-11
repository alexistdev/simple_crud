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
   }
  </pre>
## list api
<table>
  <thead>
    <tr>
      <th>No.</th>
      <th>API ENDPOINT</th>
      <th>METHOD</th>
      <th>DESKRIPSI</th>
      <th>PAYLOAD</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>http://localhost:8901/api/movie</td>
      <td>POST</td>
      <td>Menambah data Movie</td>
      <td>
        <pre>
          {
                "title" : "TTTTT",
                "director": "ttasd",
                "summary" : "Transformer 3223232",
                "genres" : [{"id":4, "name" : "Sci-Fi"}]    
          }
        </pre>
      </td>
    </tr>
     <tr>
      <td>2</td>
      <td>http://localhost:8901/api/lists</td>
      <td>GET</td>
      <td>Mendapatkan data semua movie</td>
       <td>-</td>
    </tr>
    <tr>
      <td>3</td>
      <td>http://localhost:8901/api/movie/{id}</td>
      <td>PATCH</td>
      <td>Update data Movie</td>
      <td>
         <pre>
          {
                "title" : "TTTTT",
                "director": "ttasd",
                "summary" : "Transformer 3223232",
                "genres" : [{"id":4, "name" : "Sci-Fi"}]    
          }
        </pre>
    </tr>
  </tbody>
</table>

## Installasi Angular:
- git clone
- buka folder : FE
- jalankan diterminal: npm install
- jalankan di terminal: ng serve
- url nya: http://localhost:4200/movies
- Angular dijalankan setelah springboot dijalankan terlebih dahulu!

