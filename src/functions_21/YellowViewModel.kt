package functions_21

/*
 Functions as arguments
*/
class YellowViewModel {

    val sampleList = listOf<String>("1,", "2,", "3")

    fun sampleFunction(filter: (String) -> Boolean) {

        sampleList.filter(filter)
            .forEach {
                println("Sample $it")
            }

    }

}