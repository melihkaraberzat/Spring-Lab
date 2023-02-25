#  Uygulamanın Kurulup Çalıştırılması
1. Terminal (cmd , git bash vs.) üzerinden ' git clone https://github.com/melihkaraberzat/Spring-Lab-App.git ' komutunu yazarak çalıştığınız mevcut dizine uygulama dosyalarını indirebilirsiniz.
2. Eğer terminal üzerinden yapmak istemezseniz ' https://github.com/melihkaraberzat/Spring-Lab-App ' adresinde Code butonuna basıp download zip diyebilirsiniz.
3. Proje dosyalarını indirdikten sonra cd komutu ile bulunduğu dizine gidelim.  <p style="color:blue">' cd Spring-Lab-App ' </p>
4. Dizinin içerisine girdikten sonra şu komutu çalıştıralım : <p style="color:blue">mvn clean package</p><span style="color:red">Bilgisayarınızda maven kurulu değilse bu komut çalışmayacaktır. https://maven.apache.org/download.cgi adresinden size uygun olan sürümü indirmelisiniz.</span> Bu komut projeyi compile edip target klasörü oluşturacak ve o klasörün içerisinde çalıştırılabilir JAR uzantılı bir dosya oluşturacak.
5. En sonda Spring uygulamasını çalışır hale getirmek için <p style="color:blue">java -jar target/Laboratuvar-0.0.1-SNAPSHOT.jar</p> komutunu çalıştıralım. Veya target klasörünün içerisindeki Jar uzantılı dosyaya çift de tıklayabiliriz.
6. Spring uygulamamız çalışır hale geldikten sonra, ' localhost:8080/hastalar ' adresine girerek uygulamanın asıl kısmı ile etkileşime geçebilirsiniz.
7. ' localhost:8080/h2-console ' adresinden veritabanına daha detaylı erişebilirsiniz.Veri tabanına erişebilmek için JDBC URL kısmına : <p style="color:blue">jdbc:h2:file:./dbRapor</p> yazmanız yeterli olacaktır.
8. Veritabanında Users tablosuna elinizle kullanıcı adı ve şifre ekleyerek kullanıcı oluşturabilirsiniz. localhost:8080/home adresinden kayıtlı kullanıcı adınız ve şifrenizi girerek /hastalar sayfasına geçiş yapabilirsiniz. Session özelliği ekleyene kadar birazcık gereksiz olabilir :) . 
   
   

# Yapılan Teknik Seçimler ve Gerekçeleri

1. H2 Database kullanma sebebim : Boyutunun ufak olması ve portable bir şekilde kullanılabilir olması. Kendisine ait bir konsolunun olması ve SQL syntaxı kullanması. Application properties'de datasource olarak ' jdbc:h2:file:./dbRapor ' adresini belirtmem database'in portable olmasını sağlıyor.
2. Basit CRUD işlemlerinin ötesinde bir şey olmadığı için aslında service layer'a gerek yoktu fakat ben tam halinin nasıl gözükeceğini gösterebilmek için servis katmanı da kullandım. Bu uygulama için kullanmasam da olabilirdi.
3. Login screen eklemeye çalıştım fakat projeyi daha hızlı teslim edebilmek adına Session özelliği ekleyemedim.Bu yüzden login yapsak da yapmasak da localhost:8080/hastalar sayfasına erişebiliyoruz. 
4. Gelen istekleri handle edebilmesi için HastalarController isimli bir sınıf oluşturdum. Sunucumuza atılan tüm istekler bu controllerın içerisindeki metotlar tarafından handle ediliyor.
5. Hasta değil de raporun unique olacağını düşündüm ve bu yüzden Primary Key'i dosya numarası olarak ayarladım ve rapor oluştururken sistem tarafından otomatik atanması gerektiğini düşündüm.
   