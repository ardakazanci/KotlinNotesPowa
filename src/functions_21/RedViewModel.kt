package functions_21

/*
    Functions as return values
 */

class RedViewModel {

    // Functions as variables
    val sampleVariable: () -> List<Int> = {
        listOf(1, 2, 3, 4)
    }


    // Functions as return values
    fun sampleFunctions(args: Boolean): () -> List<String> {

        return if (args) {
            {
                listOf<String>("1", "2", "3")
            }
        } else {
            {
                listOf<String>("1", "2", "3")
            }
        }

    }

}