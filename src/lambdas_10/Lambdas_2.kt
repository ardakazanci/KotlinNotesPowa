package lambdas_10


// Bir değişkenin lambda declaration işlemi
// var multiplyLambdas : (Int,Int)->Int


fun main() {

    // Bir değişkene lambda atanması işlemi.
    var multiplyLambdas: (Int, Int) -> Int = { a: Int, b: Int ->
        a * b
    }

    // Kotlin'in tür çıkarımını kullanarak daha kısa lambda tanımlayabiliriz.
    // Unutulmaması gereken nokta ilk olarak iki adet değer alacağını ilan etmiş olmamızdır.
    multiplyLambdas = { a, b ->
        a * b
    }


    // IT ANAHTAR KELİMESİ KULLANIMI //

    // it anahtar kelimesi kullanımı eğer lambda ifadenin tek bir parametresi var ise ilgili parametrenin temsili için
    // it anahtar kelimesi kullanılır.
    var sampleItKeywordLambda: (String) -> String = { it ->
        it
    }

    // ilgili değişkene bir lambda atadık. Lambda 1 adet argüman alıyor ve String türünde
    // daha sonra ilgili argümanı döndürüyor. İlk atama işlemi olduğu için it kullanamayız.
    // türünü en başta belirlediğimiz lambda ifadelerin tür çıkarımını kullanarak it vs. kullanabiliriz.
    var sampleItKeyworkdLambda2 = { a: String ->
        a
    }
    // Yukarıda tanımladığımız lambdanın yeni atama işlemini bu şekilde yapabiliriz.
    sampleItKeyworkdLambda2 = { it ->
        it
    }

    // Örnek it anahtar kelimesi kullanımı için yeni bir örnek
    var square: (Int) -> Int = { it ->
        it * it
    }

    // IT ANAHTAR KELİMESİ KULLANIMI SON //

    // Lambda değişkenimiz tanımlandığında, tıpkı bir işlevmiş gibi kullanabiliriz.
    val lambdaResult = multiplyLambdas(2, 5)
    println(lambdaResult)

    var dortIslem: (Int, Int, String) -> String = { sayi1: Int, sayi2: Int, operation: String ->

        when (operation) {
            "+" -> {
                "Toplama işleminin Sonucu ${sayi1 + sayi2}"
            }
            "-" -> {
                "Çıkarma işleminin Sonucu ${sayi1 - sayi2}"
            }
            "*" -> {
                "Çarpma işleminin Sonucu ${sayi1 * sayi2}"
            }
            "/" -> {
                "Bölme işleminin Sonucu ${sayi1 / sayi2}"
            }
            else -> {
                "Geçersiz Operatör"
            }
        }

    }


    println(dortIslem(1, 2, "+"))
    println(dortIslem(1, 2, "/"))
    println(dortIslem(1, 2, "*"))
    println(dortIslem(1, 2, "-"))


    // ARGÜMAN OLARAK LAMBDALARIN KULLANILMASI

    // 2 Adet normal parametre alan 1 adet işlev - lambda alan fonksiyon örneği.
    fun dortIslem(sayi1: Int, sayi2: Int, islem: (Int, Int) -> Int): Int {

        val islemSonucu = islem(sayi1, sayi2)
        println(islemSonucu)
        return islemSonucu

    }


    val islemArgumanNormalLambda: (Int, Int) -> Int = { a, b ->
        a * b
    }

    fun islemArgumanNormalFonksiyon(a: Int, b: Int): Int = a * b
    // Normal bir şekilde lambda ifade argüman olarak gönderildi.
    dortIslem(1, 2, islemArgumanNormalLambda)
    // Lambdalar isimsiz fonksiyonlar olduğu için burada bir fonksiyonu normal bir şekilde gönderdik.
    dortIslem(1, 2, ::islemArgumanNormalFonksiyon)

}



