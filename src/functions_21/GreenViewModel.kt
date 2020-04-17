package functions_21

class GreenViewModel {

    var sampleVariable: () -> String = { " Hello " }

    private fun helloUser() {

        println(sampleVariable())

    }

}