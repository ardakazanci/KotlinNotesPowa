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


    // RUN SCOPE FUNCTIONS
    // This olarak ifade eder. Kullanım durumuna göre Let yerine kullanılabilir
    // ek olarak null kontrolü sağlar.
    var name: String? = "Abcd"
    fun performRunOperation() {
        val name = User().name?.run {
            "The name of the Person is: $this"
        }
        print(name)
    }

    // WITH SCOPE FUNCTIONS
    // Mantık olarak Run ile aynıdır farkları Null kontrol mekanizmasıdır.
    fun performRunOperation2() {
        val person: User? = null
        person?.run {
            name = "asdf"
            contactNumber = "1234"
            address = "wasd"
            displayInfo()
        }
    }

    // Eğer with kullansaydık
    // Null kontrol mekanizması her bir this içerisinde ele alınmalıydı.
    fun performWithFunctions() {
        val person: User? = null
        with(person) {
            this?.name = "asdf"
            this?.contactNumber = "1234"
            this?.address = "wasd"
            this?.displayInfo()
        }
    }
    // APPLY SCOPE FUNCTIONS
    // With ' ten farkı null kontrol mekanizması daha kolay

    fun performApplyOperation() {
        val person: User? = null
        person?.apply {
            name = "asdf"
            contactNumber = "1234"
            address = "wasd"
            displayInfo()
        }
    }

    // Run ifadesi bir return ifadesi kabul ederken Apply ifadesi return ifadesi kabul etmez.

    // Android Programlama örneği

    /**
     *
     * Normal Kullanım
    fun createIntent(intentData: String, intentAction: String): Intent {
    val intent = Intent()
    intent.action = intentAction
    intent.data = Uri.parse(intentData)
    return intent
    }

    // Apply Kullanımı
    fun createIntent(intentData: String, intentAction: String) =
    Intent().apply {
    action = intentAction
    data = Uri.parse(intentData)
    }
     *
     *
     */


    // ALSO SCOPE FUNCTIONS
    // Örnekte görüldüğü üzere zincirleme bir işlem sağlanabilir.
    // Let'ten farkı return ifadesi kabul etmemesidir.
    fun performAlsoOperation() {
        val name = User().also {
            print("Current name is: ${it.name}\n")
            it.name = "ModifiedName"
        }.run {
            "Modified name is: $name\n"
        }
        print(name)
    }


    // ÖZET

    /**
    it              this
    ------------------------
    Return Result :        let      |       run,with
    Return Object :        also     |       apply

     */

}