package lambdas_10

fun main() {


    val plusOperation = { a: Int, b: Int ->
        a + b
    }

    val minusOperation = { a: Int, b: Int ->
        a - b
    }

    val dividedByOperation = { a: Int, b: Int ->
        a / b
    }

    val multiplyOperation = { a: Int, b: Int ->
        a * b
    }

    val lambdaVariable = plusOperation(2, 5)

    println(lambdaVariable) // -> 7

    val sampleLambda: (Int, Int) -> Int

    // The types are adjusted by kotlin.
    sampleLambda = { a, b ->
        a * b
    }

    val sampleLambdaSecond: (Int) -> Int

    sampleLambdaSecond = {
        2 * it / 9
    }


    var sampleLambdaThird = { a: Int ->
        2 * a
    }

    sampleLambdaThird = {
        it * 4
    }



    // Lambdas as arguments - > TR = Lambdalar bir fonksiyona argüman olarak verilebilir.
    // Daha sonra fonksiyon içinde kullanılabilir.
    fun sampleFunction(a: Int, b: Int, operation: (Int, Int) -> Int): Int {

        return a * b * operation(5, 4)

    }

    val sampleOperation = { a: Int, b: Int ->

        (a * a) * (b * b)

    }

    println(sampleFunction(2, 4, sampleOperation))


    fun dummyFunction(a: Int, b: Int) = a * b

    sampleFunction(2, 5, ::dummyFunction)


    val unitSampleLambda: () -> Unit

    unitSampleLambda = {
        println("Kotlin Apprentice is awesome!")
    }


    val names = arrayOf("ZZZZZZ", "BB", "A", "CCCC", "EEEEE")
    names.sorted() // A, BB, CCCC, EEEEE, ZZZZZZ

    val namesByLength = names.sortedWith(compareBy {
        -it.length
    })
    println(namesByLength) // > [ZZZZZZ, EEEEE, CCCC, BB, A]

    val values = listOf(1, 2, 3, 4, 5, 6)
    values.forEach {
        println("$it: ${it * it}")
    }

    var prices = listOf(1.5, 10.0, 4.99, 2.30, 8.19)
    val largePrices = prices.filter {
        it > 5.0
    }

    val salePrices = prices.map {
        it * 0.9
    }

}