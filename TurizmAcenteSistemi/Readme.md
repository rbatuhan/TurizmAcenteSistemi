                        Patika+ Turizm Acentesi Ödevi

Admin Giriş => kullanıcı adı = aa , şifre = aa
Employee Giriş => kullanıcı adı = ee , şifre = ee

Proje kapsamında bir turizm acentesi programı yazılmıştır.
Proje de Admin ve Employee olmak üzere iki tip kullanıcı vardır.

Admin kullanıcısı sisteme kullanıcı ekleme, silme, güncelleme işlemlerini yapabileceği 
bir PopUp a ulaşmaktadır.

Employee kullanıcı sisteme;
* otel ekleyebilir, otelleri listeleyebilir,
* otel id si üzerinden otellere pansiyon tipi ekleyebilir, listeleyebilir,
* otel id si üzerinden sezon ekleyebilir, listeleyebilir.
* otellere oda ekleyebilir, listeleyebilir,
* odalarda filtreler yardımı ile arama yapabilir.
* Rezervasyon ekleme,güncelleme,silme işlemlerini yapabilir.

Proje 5 Package halinde hazırlanmıştır;
* business
* core
* dao
* entity
* view
olmak üzere

Proje için veritabanı olarak PostgreSQL kullanılmıştır.

Database de 6 adet tablo oluşturulmuştur;
* hotel tablosu => otellerin tutulduğu tablo
* pansion_type tablosu => oteller için pansiyon tiplerinin tutulduğu tablo
* reservation tablasu => rezervasyonların tutulduğu tablo
* room tablosu => odaların tutulduğu tablo
* season tablosu => oteller için sezonların tutulduğu tablo
* user tablosu => kullanıcıların tutulduğu tablo

Projeyi çalıştırdıktan sonra giriş ekranında girdiğiniz kullanıcı adı ve şifreye göre
ADMIN paneline 
veya
Employee paneline yönlendirilirsiniz.

Giriş yaptıktan sonra ilgili butonları kullanarak veya tablo üzerine sağ tık ile 
seçeceğiniz seçimler ile işlemlerinizi yapabilirsiniz.

NOT = Ödev malesef yetiştirilememiştir :( 
Ödevde rezervasyon ekranı oluşturulmuş olup ekleme,silme,güncelleme yapılamamıştır.



Proje İsterleri;
1. Değişkenler ve fonksiyon isimleri olabildiğince anlaşılır yapılmıştır.
2. Projede yorum satırları ve Readme dosyası mevcuttur.
3. Kod olabildiğince düzenli ve okunabilir yazılmaya çalışılmıştır.
4. Projede Yazılan kodlarda doğru girinti kullanılmıştır.
5. Projede Swing GUI kullanılmıştır.
6. Projede PostgreSql veritabanı kullanılmış olup Db bağlantısı yapılmıştır.
7. Admin paneleri içerisinde ekleme,güncelleme, silme, filtreleme yapılabilekmektedir.
8. x =>Rezervasyon kısmı eksik
9. Login işleminde kullanı kaydı kontrol ediliyor.
10. Personel sisteme personel panelinin Otel yöntimi kısmından Otel kaydedebiliyor
11. Otelleri sisteme ekledikten sonra üzerine sağ tık yapıp dönem eklenebiliyor.
12. Oteleri sisteme ekledikten sonra üzerine sağ tık yapıp pansiyon tipi eklenebiliyor.
13. Personel sisteme personel panelinin Oda Yöntimi kısmından Oda kaydedebiliyor.
14. Yeni eklenen odalara yetişkin-çocuk fiyatlandırması yapılabiliyor.
15. Personel odaları filtreleri kullanarak filtreleyebiliyor.
16. x => Ufak bir SQL hatası var zaman kalmadığı için düzeltemeden atıyorum.
17. x => Rezervasyon paneli yapıldı ama kodlamaları yapılmadı (fiyat hesaplama)
18. x => Rezervasyon ekleme eklenemedi
19. x => Rezervasyon işlemleri yapılamadı (Oda stoğu azalması)
20. x => Rezervasyon ekleme işlemi yapılmadığından listelenecek veri yok
21. x => Rezervasyon güncelleme eklenemedi
22. x => Rezervasyon silme eklenemedi
23. x => Rezervasyon işlemleri yapılamadı (Oda stoğu artması)
24. Kullanıcıya başarılı işlemleri sonrası pop up mesajları çıkmaktadır.
25. Kullanıcıya hatalı işlemleri sonrası pop up mesajları çıkmaktadır.

Video
https://www.youtube.com/watch?v=LWWDsXSEG0E