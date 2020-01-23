
fun main() {
    // RANGES
    val closedRange = 0..5

    val halfOpenRange = 0 until 5 // 5 dahil değil


    for (i in halfOpenRange) {
        println(i)
    }

    println("------")

    val decreasingRange = 5 downTo 0 // 0 dahil.
    for (i in decreasingRange) {
        println(i)
    }

    println("------")


    val sampleRange = 3 downTo 0 // 0 dahil. ya da 0 until 3 ya da 0..3 dahillik durumları kritik.
    for (i in sampleRange) {
        println(i)
    }

    println("------")

    // FOR LOOPS
    val count = 10

    // TRIANGLE NUMBERS
    var sum = 0
    for (i in 1..count) {
        sum += i
    }

    println(sum)
    println("------")

    // FIBONACCI
    sum = 1
    var lastSum = 0
    repeat(10) { // 10 KERE BU İŞLEM TEKRAR EDER
        val temp = sum
        sum += lastSum
        lastSum = temp
    }
    println(sum)




    // SUM ODD NUMBERS
    sum = 0
    for (i in 1..count step 2) {
        sum += i
    }
    println(sum)

    // COUNT DOWN
    sum = 0
    for (i in count downTo 1 step 2) {
        sum += i
    }
    println(sum)

    // CHESS BOARD ITERATION
    sum = 0
    for (row in 0 until 8) {
        if (row % 2 == 0) {
            continue
        }

        for (column in 0 until 8) {
            sum += row * column
        }
    }
    println(sum)

    sum = 0
    rowLoop@ for (row in 0 until 8) {
        columnLoop@ for (column in 0 until 8) {
            if (row == column) {
                continue@rowLoop
            }
            sum += row * column
        }
    }
    println(sum)


    // WHEN EXPRESSION
    val number = 10

    when (number) {
        0 -> println("Zero")
        else -> println("Non-zero")
    }

    when (number) {
        10 -> println("It's ten!")
    }

    val string = "Dog"
    when (string) {
        "Cat", "Dog" -> println("Animal is a house pet.") // OR
        else -> println("Animal is not a house pet.")
    }

    val numberName = when (number) {
        2 -> "two"
        4 -> "four"
        6 -> "six"
        8 -> "eight"
        10 -> "ten"
        else -> {
            println("Unknown number")
            "Unknown"
        }
    }

    println(numberName) // > ten


    val hourOfDay = 12
    val timeOfDay: String

//  timeOfDay = when (hourOfDay) {
//      0, 1, 2, 3, 4, 5 -> "Early morning"
//      6, 7, 8, 9, 10, 11 -> "Morning"
//      12, 13, 14, 15, 16 -> "Afternoon"
//      17, 18, 19 -> "Evening"
//      20, 21, 22, 23 -> "Late evening"
//      else -> "INVALID HOUR!"
//  }

    timeOfDay = when (hourOfDay) {
        in 0..5 -> "Early morning"
        in 6..11 -> "Morning"
        in 12..16 -> "Afternoon"
        in 17..19 -> "Evening"
        in 20..23 -> "Late evening"
        else -> "INVALID HOUR!"
    }
    println(timeOfDay)

    when {
        number % 2 == 0 -> println("Even")
        else -> println("Odd")
    }

    val (x, y, z) = Triple(3, 2, 5)

    when {
        x == 0 && y == 0 && z == 0 -> println("Origin")
        y == 0 && z == 0 -> println("On the x-axis.")
        x == 0 && z == 0 -> println("On the y-axis.")
        x == 0 && y == 0 -> println("On the z-axis.")
        else -> println("Somewhere in space")
    }

    when {
        x == 0 && y == 0 && z == 0 -> println("Origin")
        y == 0 && z == 0 -> println("On the x-axis at x = $x")
        x == 0 && z == 0 -> println("On the y-axis at y = $y")
        x == 0 && y == 0 -> println("On the z-axis at z = $z")
        else -> println("Somewhere in space at x = $x, y = $y, z = $z")
    }

    when {
        x == y -> println("Along the y = x line.")
        y == x * x -> println("Along the y = x^2 line.")
    }
}
