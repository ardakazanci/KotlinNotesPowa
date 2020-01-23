package functions_06

fun main() {

    // FUNCTION BASICS
    fun printMyName() {
        println("My name is Joe Howard.")
    }
    printMyName()


    // FUNCTION PARAMETERS
    fun printMultipleOfFive(value: Int) {
        println("$value * 5 = ${value * 5}")
    }
    printMultipleOfFive(10)

    fun printMultipleOf(multiplier: Int, andValue: Int) {
        println("$multiplier * $andValue = ${multiplier * andValue}")
    }
    printMultipleOf(multiplier = 4, andValue = 2)

    fun printMultipleOfDefaultValue(multiplier: Int, value: Int = 1) {
        println("$multiplier * $value = ${multiplier * value}")
    }
    printMultipleOfDefaultValue(4, 2)

    printMultipleOfDefaultValue(4)


    // RETURN VALUES
    fun multiply(number: Int, multiplier: Int): Int {
        return number * multiplier
    }

    fun multiplyInferred(number: Int, multiplier: Int) = number * multiplier

    val result = multiplyInferred(4, 2)

    fun multiplyAndDivide(number: Int, factor: Int): Pair<Int, Int> {
        return Pair(number * factor, number / factor)
    }
    val (product, quotient) = multiplyAndDivide(4, 2)

    // Parameters as values
//  fun incrementAndPrint(value: Int) {
//    value += 1 // Val cannot be reassigned
//    print(value)
//  }

    fun incrementAndPrint(value: Int): Int {
        val newValue = value + 1
        println(newValue)
        return newValue
    }

    var value = 5
    value = incrementAndPrint(value)
    println(value)


    // OVERLOADING
    fun getValue(value: Int): Int {
        return value + 1
    }

    fun getValue(value: String): String {
        return "The value is $value"
    }

    val valueInt: Int = getValue(42)
    val valueString: String = getValue("Galloway")


    // FUNCTIONS AS VARIABLES
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    // :: parametresi ile bir fonksiyon değişken olarak kullanılabilir.

    var function = ::add // Fonksiyon variable olarak kullanılıyor.
    function(4, 2)

    var function2 = ::add
    function2(1, 2)




    fun subtract(a: Int, b: Int): Int {
        return a - b
    }
    function = ::subtract
    function(4, 2)



    /**
     * function: (Int, Int) -> Int bir fonksiyon parametre olarak alınacak ve sağ tarafındaki şartları sağlayacak
     */

    fun printResult(function: (Int, Int) -> Int, a: Int, b: Int) {
        val result = function(a, b)
        print(result)
    }
    printResult(::add, 4, 2)


    // LAND OF NO RETURN
    //fun noReturn() : Nothing {
    //
    //}

    fun infiniteLoop(): Nothing {
        while (true) {
        }
    }
}