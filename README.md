# TasarimDesenleriOdevi

### 1. Verilerin girildiği program: Bu programda günlük test, vaka, yoğun bakımdaki hasta sayısı, entübe hasta sayısı, ölü sayısı ve iyileşen hasta sayıları tarih bilgisi ile birlikte girilebilmelidir. Bunun için basit bir form uygulaması tasarlanabilir. Bu program sunucu (server) konumunda olan bir program olmalıdır. Kendisinden veri almak isteyen diğer programlar bu programa bağlanarak anlık verileri alabilmelidir. Dolayısıyla client-server mimarisi kullanılacaktır ve sunucu programa bağlanmak için TCP soketleri kullanılmalıdır. Ayrıca buradaki soket yapısında gözlemci (observer) tasarım deseninin kullanılması zorunludur. 
### 2. Covid-19 bildirim programı: Program verilerin girildiği programa TCP soketleri ile bağlanmalı ve her an gelen verileri dinleyebilecek konumda olmalıdır. Yeni veri geldiğinde form kendini otomatik olarak güncellemelidir. Ayrıca bir dosyaya son veriler girilmelidir (bu dosya türü excel yada başka bir dosya türü de olabilir). Form Singleton tasarım deseni kullanılarak oluşturulmalıdır.
### 3. Covid-19 grafik programı: Program verilerin girildiği programa TCP soketleri ile bağlanmalı ve her an gelen verileri dinleyebilecek konumda olmalıdır. Yeni veri geldiğinde form kendini otomatik olarak güncellemelidir. Ayrıca bir dosyaya son veriler girilmelidir (bu dosya türü excel yada başka bir dosya türü de olabilir). Form Singleton tasarım deseni kullanılarak oluşturulmalıdır.



## Uygulamanın görünümü:


![td](https://user-images.githubusercontent.com/44363093/86911358-dcc2ee00-c123-11ea-9ed5-a3032fb14596.jpg)
