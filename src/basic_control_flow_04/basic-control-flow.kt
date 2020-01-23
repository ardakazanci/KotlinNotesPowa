package basic_control_flow_04


fun main() {

    // COMPARISON OPERATORS

    //val yes: Bool = true
    //val no: Bool = false
    val yes = true
    val no = false

    val doesOneEqualTwo = (1 == 2)
    val doesOneNotEqualTwo = (1 != 2)
    val alsoTrue = !(1 == 2)
    val isOneGreaterThanTwo = (1 > 2)
    val isOneLessThanTwo = (1 < 2)

    val and = true && true
    val or = true || false

    val andTrue = 1 < 2 && 4 > 3
    val andFalse = 1 < 2 && 3 > 4

    val orTrue = 1 < 2 || 3 > 4
    val orFalse = 1 == 2 || 3 == 4

    val andOr = (1 < 2 && 3 > 4) || 1 < 4

    val guess = "dog"
    val dogEqualsCat = guess == "cat"

    val order = "cat" < "dog"
    println("ORDER = " + order)

    // IF-STATEMENTS
    if (2 > 1) {
        println("Yes, 2 is greater than 1.")
    }

    val animal = "Fox"
    if (animal == "Cat" || animal == "Dog") {
        println("Animal is a house pet.")
    } else {
        println("Animal is not a house pet.")
    }

    // TERNARY OPERATOR
    val a = 5
    val b = 10

    /*
    val min: Int
    if (a < b) {
    min = a
    } else {
    min = b
    }
    */
    val min = if (a < b) a else b

    /*
    val max: Int
    if (a > b) {
    max = a
    } else {
    max = b
    }
    */

    val max = if (a > b) a else b

    val hourOfDay = 12

    val timeOfDay = if (hourOfDay < 6) {
        "Early morning"
    } else if (hourOfDay < 12) {
        "Morning"
    } else if (hourOfDay < 17) {
        "Afternoon"
    } else if (hourOfDay < 20) {
        "Evening"
    } else if (hourOfDay < 24) {
        "Late evening"
    } else {
        "INVALID HOUR!"
    }
    println(timeOfDay)

    val name = "Dick Lucas"

    if (1 > 2 && name == "Dick Lucas") {
        // ...
    }

    if (1 < 2 || name == "Dick Lucas") {
        // ...
    }

    // SCOPE
    var hoursWorked = 45

    var price = 0
    if (hoursWorked > 40) {
        val hoursOver40 = hoursWorked - 40
        price += hoursOver40 * 50
        hoursWorked -= hoursOver40
    }
    price += hoursWorked * 25

    println(price)
    //println(hoursOver40)


    // WHILE LOOPS
    //while true { // Commented out as this will loop forever
    //}

    // Made up sequence (it's powers of 2 minus 1, i.e. 3, 7, 15, 31, 63, etc)
    var sum = 1
    while (sum < 1000) {
        sum = sum + (sum + 1)
    }
    println(sum)

    sum = 1
    do {
        sum = sum + (sum + 1)
    } while (sum < 1000)
    println(sum)

    sum = 1
    while (sum < 1) {
        sum = sum + (sum + 1)
    }
    println(sum)

    sum = 1
    do {
        sum = sum + (sum + 1)
    } while (sum < 1)
    println(sum)

    sum = 1
    while (true) {
        sum = sum + (sum + 1)
        if (sum >= 1000) {
            break
        }
    }
    println(sum)

}
