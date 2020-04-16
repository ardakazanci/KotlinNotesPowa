package lambdas_10

fun main() {


    println(dummyLambda1(dummyLambda))
    dummyLambda2 {
        it * it
    }

    dummyLambda3 {
        "Değer + $[it}"
    }

}

fun dummyLambda2(b: (b: Int) -> Int) {
    println(b(15))
}


fun dummyLambda3(result: (a: Int) -> String) {

    result(15)

}


fun dummyLambda1(a: (a: Int) -> Int): String {

    val number = 16
    return "Sample Lambda : ${a(number)}"
}


val dummyLambda: (a: Int) -> Int = {
    it * it
}






