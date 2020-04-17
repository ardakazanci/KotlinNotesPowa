package functional_programming_20

/*
 Variable = Functions
*/

var stringFilter: (String) -> Boolean = {
    it.length > 3
}


/*
Higher - Order functions SAMPLE
*/
public inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
    return filterTo(ArrayList<T>(), predicate)
}


fun main() {

    val stringFilter: (String) -> Boolean = { string ->
        string.length > 3
    }

    val languages = listOf("c++", "php", "java", "kotlin")
    // val filteredLanguages = languages.filter(stringFilter)

    val filteredLanguages = listOf("c++", "php", "java", "kotlin")
        .filter { string ->
            string.length > 3
        }

}



