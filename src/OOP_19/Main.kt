package OOP_19

/**
 *
 * VAL -> Getter
 * VAR -> GETTER - SETTER
 *
 */

fun main() {

    val person = Person("Arda", "Kazancı")
    person.fullName()


    val programmer = Developer("Arda", "Kazancı", "PHP")
    programmer.fullName()

    val dummyObject = Dummy("1")

    // dummyObject.args1 = 15 Error

}