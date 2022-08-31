# FTTechBootcampCaseProject

FT Teknoloji Spring Bootcamp'i kapsamında yapılan projedir.

Projede exception yönetimi olarak data util kütüphanesi kullanılmıştır. Repository [link](https://github.com/voghbum/java_maven_repo).

Projede istenen kriterlerin hepsi gerçekleştirilmiştir. Bunlar;
- Belirtilen üç entity sınıfını oluşturmak.
- Bir ürüne ait yorumları listeleyen bir metot yazmak.
- Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazmak.
- Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazmak.
- Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazmak.
- Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazmak.
- Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazmak. (Son kullanma tarihi boş olanlar da gelmeli.)

# API

|   | method | mapping                                                      | örnek parametreler                                          |
|---|--------|--------------------------------------------------------------|-------------------------------------------------------------|
|   | GET    | *FTTech/bootcamp/api/urunyorum/findAll/ByKullaniciId*        | kullaniciId=1                                               |
|   | GET    | *FTTech/bootcamp/api/urunyorum/findAll/byUrun*               | urunId=1                                                    |
|   | GET    | *FTTech/bootcamp/api/urunyorum/findAll/byTarihAndKullanici*  | startDate=11/10/1998 18:45&endDate=12/12/2025&kullaniciId=1 |
|   | GET    | *FTTech/bootcamp/api/urunyorum/findAll/byTarihAndUrun*       | startDate=11/10/1998&endDate=12/12/2025 18:45&urunId=1      |
|   | GET    | *FTTech/bootcamp/api/urun/findAll/sonkullanmatarihigecmis*   | YOK                                                         |
|   | GET    | *FTTech/bootcamp/api/urun/findAll/sonkullanmatarihigecmemis* | YOK                                                         |
