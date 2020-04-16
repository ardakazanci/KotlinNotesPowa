package null_non_null_18

fun main(args: Array<String>?) {

    /*
        ? null - safety operator.
        !! -> Non-Null Assertion
        Conditional checks -> if - else controll
        ?: -> The Elvis operator
     */

    var language: String = "Turkish"

    // language = null -> Error


    var name: String? = "Arda"

    name = null


    /* Null - Safe Calls */

    var languages = listOf<String>("English", "Turkish")

    languages.isNotEmpty()

    var companies: List<String>? = null

    companies?.isNotEmpty()

    companies?.get(0)?.toLowerCase()

    /* Non-Null Assertion */

    // val argCount = args!!.size -> Error Throw


    // Conditional checks

    if (args != null) args.size else 0

    /* The Elvis operator */
    // if args?.size null -> 0 not null args?.size
    val argsCount2 = args?.size ?: 0

}