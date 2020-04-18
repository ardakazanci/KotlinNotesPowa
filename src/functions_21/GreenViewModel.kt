package functions_21

/*
Functions as variables
*/
class GreenViewModel {

    var sampleVariable: () -> String = { " Hello " }

    private fun helloUser() {

        println(sampleVariable())

    }

}