package functions_21

fun sampleFunction(arg: String) {

}

fun sampleFunctions2(arg1: String, arg2: String) {

}

// vararg modifier

fun sampleFunction3(vararg names: String) {

    names.forEach {
        println(it)
    }

}

// Note Multiple Vararg problem !
fun main() {

    sampleFunction3("Arda")
    sampleFunction3("Arda", "Kerem")
    sampleFunction3("Arda", "Kerem", "Ece")
    sampleFunction3()

}