Kurulum:
Java 11 veya üzeri bir JDK.
Intellij IDEA Community Edition Version : 2020.3.4 ya da üzeri bir versiyon

Projeyi çalıştırmadan önce gerekli bağımlılıkların yüklenmesi gerekmektedir. Bağımlılıklar:
org.json 20240303-->API yanıtlarını parse etmek ya da JSON formatında veri oluşturmak için kullanıldı.
junit 4.13.2-->Test anotasyonları ile testleri başlatmak ve assertion'lar için kullanıldı.
io.rest-assured 5.3.0--> Restful Api'ların testi ve gönderilen istekler  dönen yanıtların doğruluğunun sağlanması için kullanıldı.
TestNG 7.10.2--> Testleri organize etmek ayrıyeten Junit de mevcut olmayan bazı anotasyonlar(BeforSuite vb.) için kullanıldı.
--Not:Pom.xml dosyası üzerinden gerekli bağımlılıkların kurulduğundan emin olunmalıdır.

Testlerin Çalıştırılması:
ALLsteps klasörü altındaki E2EAPI klasındaki test anotasyonundan uçtan uca api senaryo koşumu yapılabilir.