# Kotlin alapú szoftverfejlesztés
## Specifikáció
Az elkészítendő szoftver egy Spring Boot alkalmazás, amely egy pizzarendeléssel foglalkozó honlap backend részét képezi. A honlapról bejelentkezés nélkül, bárki rendelhet, majd megtekintheti rendelése státuszát.

### Megvalósítás
A kínálat illetve a megrendelések perzisztensen vannak tárolva egy MongoDB adatbázisban. A kínálat megtekintését, illetve rendelések feladását/megtekintését egy REST API teszi lehetővé. Az alkalmazás teljes mértékben reaktív, a WebFlux keretrendszer segítségével. A teljes alkalmazás, az adatbázissal együtt egy Docker konténerben futtatható.