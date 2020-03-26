package sealed_class_15

/**
 * Aynı ana türden farklı alt sınıf türleri tanımlamak için kullanılabilir.
 * Enum 'un sınıf türlerini barındıran tipi olarak düşünülebilir.
 */

// Örnek Enum Class
// Sabitler barındırır ve durum tutamaz.

enum class Result(val data: String) {
    SUCCESS("Success"),
    ERROR("Error")
    // ERROR(val error : Exception) -> Enum ile mümkün değildir.

}


// Soyut bir sınıftır ve aynı dosya içerisinde tanımlanmalıdır.
sealed class Employee

data class Manager(val name: String, val age: Int, val team: List<String>) : Employee()
class SeniorDev(val name: String, val age: Int, val projects: Int) : Employee()
object JuniorDev : Employee()


val employee: Employee = SeniorDev("Name", 20, 10)
val message = when (employee) {
    is Manager -> {
        "Welcome ${employee.name}! You have ${employee.team.size} employees in your team!"
    }
    is SeniorDev -> {
        "Welcome ${employee.name}! You have already ${employee.projects} projects under your belt!"
    }
    //Singleton sınıflar için is e gerek yoktur.
    JuniorDev -> {
        "Welcome aboard! We wish you an awesome Experience!"
    }

}


// Android Programlama sürecinde Sonuçların dönüşünü ele alabiliriz.

/*


sealed class ResultValue {
    data class Success(val data: Data) : ResultValue()
    data class Error(val exception: Exception) : ResultValue()
}

*/
