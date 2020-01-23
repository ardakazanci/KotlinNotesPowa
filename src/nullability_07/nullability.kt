package nullability_07

fun main() {

    // ? : Null olabilir
    // ?: null olursa sağ tarafı çalıştır.
    // !! kesinlikle null değil


    var errorCode: Int?
    errorCode = 100
    errorCode = null


    var successCode: Int?
    successCode = 200
    successCode = null

    // NULL CHECK

    if (successCode != null)
        println("Success OK")
    else
        print("Success False")


    var sampleString: String?
    sampleString = "Arda"
    sampleString = null


    println("String length :  ${sampleString?.length}") // ? işareti kısmı null olabilir eğer null ise sağ taraf çalışmaz.


    // Let statik fonksiyonu eğer null yada !! olabilir eğer olmazsa let blogunu çalıştır anlamı teşır.
    sampleString?.let {
        println("let kısmı çalıştı")
        println("$sampleString")
    }


    // Elvis operator - // Null olduğu taktirde ?: sağ tarafı çalışacaktır.

    var nullableInt: Int? = 10
    var mustHaveResult = nullableInt ?: 0

    mustHaveResult = if (nullableInt != null) nullableInt else 0

    nullableInt = null
    mustHaveResult = nullableInt ?: 0

}