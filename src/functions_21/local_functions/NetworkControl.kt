package functions_21.local_functions

import OOP_19.Person
import javax.xml.ws.Response

/*
Okunabilirlik için bazı kodları yeniden düzenlemek istiyorsanız, ancak başka bir şey için kullanılabilir
olması gerekmiyorsa yerel işlevler yararlı olabilir.
 */

fun handleNetworkResponse(response: Response<Person>) {
    fun handleSuccess(person: Person) {

    }

    fun handleError(error: Throwable?) {

    }

    /*when (response.isSuccess) {
        true -> handleSuccess((response.data))
        false -> handleError(response.error)
    }*/
}