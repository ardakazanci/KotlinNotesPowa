data class Students(val id: Int, val firstName: String, val lastName: String) {
    var fullName = "$lastName, $firstName"
}

object StudentRegistry {
    val allStudents = mutableListOf<Students>()

    fun addStudent(student: Students) {
        allStudents.add(student)
    }

    fun removeStudent(student: Students) {
        allStudents.remove(student)
    }

    fun listAllStudents() {
        allStudents.forEach {
            println(it.fullName)
        }
    }
}

object JsonKeys {
    const val JSON_KEY_ID = "id"
    const val JSON_KEY_FIRSTNAME = "first_name"
    const val JSON_KEY_LASTNAME = "last_name"
}

class Scientist private constructor(val id: Int, val firstName: String, val lastName: String) {

    companion object Factory {
        var currentId = 0

        fun newScientist(firstName: String, lastName: String): Scientist {
            currentId += 1
            return Scientist(currentId, firstName, lastName)
        }
    }

    var fullName = "$firstName $lastName"
}

object ScientistRepository {
    val allScientists = mutableListOf<Scientist>()

    fun addScientist(student: Scientist) {
        allScientists.add(student)
    }

    fun removeScientist(student: Scientist) {
        allScientists.remove(student)
    }

    fun listAllScientists() {
        allScientists.forEach {
            println("${it.id}: ${it.fullName}")
        }
    }
}

interface Counts {
    fun studentCount(): Int
    fun scientistCount(): Int
}

fun main() {

    // Singletons

    //// object keyword

    val marie = Students(1, "Marie", "Curie")
    val albert = Students(2, "Albert", "Einstein")
    val richard = Students(3, "Richard", "Feynman")

    StudentRegistry.addStudent(marie)
    StudentRegistry.addStudent(albert)
    StudentRegistry.addStudent(richard)

    StudentRegistry.listAllStudents()
    // > Curie, Marie
    // > Einstein, Albert
    // > Feynman, Richard

    // Java static members

    //// Companion object

    val emmy = Scientist.newScientist("Emmy", "Noether")
    val isaac = Scientist.Factory.newScientist("Isaac", "Newton")
    val nick = Scientist.newScientist("Nikola", "Tesla")

    ScientistRepository.addScientist(emmy)
    ScientistRepository.addScientist(isaac)
    ScientistRepository.addScientist(nick)

    ScientistRepository.listAllScientists()
    // > 1: Emmy Noether
    // > 2: Isaac Newton
    // > 3: Nikola Tesla

    //// Accessing from Java

    /* Scientist isaac = Scientist.Factory.newScientist("Isaac", "Newton") */

    // Anonymous classes

    val counter = object : Counts {
        override fun studentCount(): Int {
            return StudentRegistry.allStudents.size
        }

        override fun scientistCount(): Int {
            return ScientistRepository.allScientists.size
        }
    }

    println(counter.studentCount()) // > 3
    println(counter.scientistCount()) // > 3
}