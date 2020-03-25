package let_run_also_with_14


// Tanım olarak, Scope Functions bir nesne bağlamında bir kod bloğu yürüten işlevlerdir.

// let , run , also , with , apply


fun main() {

    fun performLetOperation() {
        // Bir return işlemi gerçekleşir.
        val person = User().let {
            "The name of the Person is: ${it.name}" // return@let ...
            // it.name = "Arda" // output : Kotlin.Unit
        }
        print(person)
    }

    // Return işlemi nesne property'si üzerinden gerçekleştirildi.
    fun performLetOperation2() {
        val person = User().let {
            it.name = "NewName"
        }
        print(person)
    }

    // Lambda değeri yeniden adlandırıldı.
    fun performLetOperation3() {
        val person = User().let { personDetails ->
            personDetails.name = "NewName"
        }
        print(person)
    }

    // Null kontrolü
    fun performLetOperation4() {
        val name = User().name?.let {
            // Eğer null değilse çalışacaktır.
            "The name of the Person is: $it"
        }
        print(name)
    }

    val numbers = mutableListOf("One", "Two", "Three", "Four", "Five")
    numbers.map {
        it.length
    }.filter {
        it > 3 // Eğer 3 ten büyükse let operatörü bloğu çalışacaktır
    }.let {
        print(it)
    }

}