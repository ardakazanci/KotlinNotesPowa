package class_11


// 1
class Person(val userName: String, val userPassword: String) {
    val userInfo
        get() = "$userName & $userPassword"
}

// 2
class SimplePerson(val name: String)


fun main() {
    // 1
    val samplePerson = Person(userName = "Arda", userPassword = "123456")
    println(samplePerson.userName)
    println(samplePerson.userPassword)
    println(samplePerson.userInfo)

    // 2
    val simpleUser1 = SimplePerson("Arda")
    val simpleUser2 = simpleUser1

}


