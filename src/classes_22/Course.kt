package classes_22

// class Course - Success

/*
    class(....) // primary constructer
    val -> getter -> Read - Only
    var -> getter - setter -> Read & Write

 */

class Course {

}

class Course_2(name: String) { // primary constructer

    val title = name
    var description = ""

    // Custom setter getter
    var properties = ""
        set(value) {
            println("Changed value $value")
            field = value
        }
        get() {
            return field
        }
}

fun main() {
    val sampleCourseObject = Course()
    sampleCourseObject.toString()

    val sampleCourseObject_2 = Course_2("Sample Title")
    println(sampleCourseObject_2.title)

    sampleCourseObject_2.description = "Sample Description"

    sampleCourseObject_2.properties = "Change Value Updated !"

    // sampleCourseObject_2.title = "Arda" -> Error

    val sampleUser = User("Arda", "12345")
    sampleUser.userName = "123456910000" // Success
    // sampleUser.userName = "1234" // Setter çalışmayacaktır.
    println(sampleUser.userName)

}


class User(userName: String, userPassword: String) {

    var userName = userName
        set(value) {
            if (value.length > 10) {
                field = value
            }
        }
        get() {
            return field
        }

    private val userPassword = userPassword


}

/**
 * arg2 -> 1
 * argSampleInitialize -> 2
 * sampleString ->  3
 * sampleInt -> 4
 */
class ConstructorSample public constructor(arg1: String, val arg2: String) {

    val argSampleInitialize = arg1
    val sampleString: String

    val sampleInt: Int

    init {
        sampleString = "Arda"
    }

    init {

        sampleInt = 15

    }

}


// Zero primaryConstructor arg.
class SamplePrimaryConstructor {

}

