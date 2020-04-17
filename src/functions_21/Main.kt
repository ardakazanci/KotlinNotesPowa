package functions_21

fun helloString(args: String) {
    println(args)
}

/*
    Read-Only Functions Variables
*/
val greetingProvider: () -> String = { "Hello" }

/*
    Mutable Functions Variables
*/
var mutableFunctionsVariables: () -> String = { "Hello" }

val sampleReadOnlyLambda: () -> String = { "HellO wORLd" }

/*
    Null Variable
 */
val nullFunctionsForVariable: (() -> String)? = null

fun main() {

    val greeting = greetingProvider()
    println(greeting) // Hello
    val greeting_2 = greetingProvider.invoke()
    println(greeting_2) // Hello
    val greeting_3 = mutableFunctionsVariables()
    println(greeting_3) // Hello
    // New Method
    val greeting_4 = { "Hello World" }
    println(greeting_4()) // Hello World


    nullFunctionsForVariable?.invoke()
    nullFunctionsForVariable?.let {
        it()
    }


    val sampleViewModel = GreenViewModel()
    sampleViewModel.sampleVariable = { "Hello World Arda" }
}



