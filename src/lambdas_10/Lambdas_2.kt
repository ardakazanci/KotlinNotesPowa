package lambdas_10

import java.lang.NullPointerException


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


    //***** IT ANAHTAR KELİMESİ KULLANIMI //

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

    //***** IT ANAHTAR KELİMESİ KULLANIMI SON //

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


    //***** ARGÜMAN OLARAK LAMBDALARIN KULLANILMASI

    // 2 Adet normal parametre alan 1 adet işlev - lambda alan fonksiyon örneği.
    fun dortIslem(sayi1: Int, sayi2: Int, islem: (Int, Int) -> Int): Int {

        val islemSonucu = islem(sayi1, sayi2)
        println(islemSonucu)
        return islemSonucu

    }

    // Kısa Hali.
    val islemArgumanNormalLambda: (Int, Int) -> Int = { a, b ->
        a * b
    }

    fun islemArgumanNormalFonksiyon(a: Int, b: Int): Int = a * b
    // Teknik 1 Normal bir şekilde lambda ifade argüman olarak gönderildi.
    dortIslem(1, 2, islemArgumanNormalLambda)
    // Teknik 2 Lambdalar isimsiz fonksiyonlar olduğu için burada bir fonksiyonu normal bir şekilde gönderdik.
    dortIslem(1, 2, ::islemArgumanNormalFonksiyon)

    // Teknik 3
    dortIslem(1, 2, { a: Int, b: Int -> a * b })

    // Teknik 4
    dortIslem(1, 2) { a: Int, b: Int -> a * b }

    // Teknik 5
    dortIslem(1, 2, Int::plus)


    //***** DÖNÜŞ DEĞERİ OLMAYAN LAMBDA İŞLEMİ

    // Argüman almayan ve değer döndürmeyen lambda
    var emptyArgsNotReturnLambda: () -> Unit = {
        println("Hello Lambda")
    }
    // Hiçbir şey döndürmeyen lambda
    var nothingArgsNotReturnLambda: () -> Nothing = {
        throw NullPointerException()
    }


    //***** DEĞİŞKENLERE VE SABİTLERE KENDİ KAPSAMINDAN ERİŞMEK

    // Teknik 1
    var sayac = 0

    var counterLambda: () -> Unit = {
        sayac += 1
    }

    counterLambda()
    counterLambda()
    counterLambda()
    counterLambda()

    println("Sayacın son değeri : $sayac") // 4


    // Teknik 2
    // Bir fonksiyonun dönüş türü olarak lambda döndürmesi.
    fun counterFunction(): () -> Int {

        var counter = 0

        var counterLambda: () -> Int = {

            counter += 1
            counter

        }

        return counterLambda


    }

    //println("Çerçevelemi lambda değeri : ${counterFunction()}") return -> () -> kotlin.Int

    // Dönüş olarak lambda döndüğü için lambda olarak kullanabiliriz.

    val counterLambdaResult1 = counterFunction()
    val counterLambdaResult2 = counterFunction()

    println("Version 1 -> " + counterLambdaResult1())
    println("Version 2 -> " + counterLambdaResult2())
    println("İkinci Version 1 -> " + counterLambdaResult1())
    println("İkinci Version 2 -> " + counterLambdaResult2())

    fun resultSinValue(arg: Double): (argLambda: Double) -> Double {

        val getArg = arg

        val processSinValue: (arg: Double) -> Double = { arg ->

            Math.sin(getArg)

        }

        return processSinValue

    }

    fun resultCosValue(arg: Double): () -> String {

        var number = arg

        val cosLambda: () -> String = {

            val result = "$number değerinin cos hesaplaması :" + Math.cos(number)
            result
        }

        return cosLambda
    }

    val sampleSin = resultSinValue(0.5)
    val sampleSin2 = resultSinValue(0.2)

    println("Sin Hesaplama Çerçeve Lambda olarak -> ${sampleSin(0.2)}")
    println("Sin Hesaplama Çerçeve Lambda olarak -> ${sampleSin2(0.5)}")


    val sampleCos = resultCosValue(0.5)

    println("${sampleCos()}")


}



