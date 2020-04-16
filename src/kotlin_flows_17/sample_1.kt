package kotlin_flows_17

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*

    -> Normal şartlar altında suspend fonksiyonlar tek bir değer döndürür.
    -> Sequences örneği 5 ms arayla ilgili döngü değerini konsola yazdırır. En önemli nokta Main-Thread i bloke etmektedir.
    -> Suspend Fonksiyon örneğinin en önemli noktası main thread i engellemeden askıya alarak saniye de 1 ilgili değeri ekrana yazdırır.

 */

// Normal Fonksiyon
fun foo(): List<Int> = listOf(1, 2, 3)

// Sequences Fonksiyon
fun sequences(): Sequence<Int> = sequence {
    for (i in 1..5) {
        Thread.sleep(500)
        yield(i)
    }
}

// Suspend Fonksiyon
suspend fun suspendFunc(): List<Int> {
    delay(1000)
    return listOf(1, 2, 3)
}

fun flowFunc(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(500)
        emit(i)
    }
}


fun main() {

    // Normal
    foo().forEach {
        println("Değer : $it")
    }

    // Sequences
    sequences().forEach {
        println("Sequences Değeri : $it")
    }

    /*runBlocking<Unit> {
        suspendFunc().forEach {
            println("Suspend Fonksiyon Değeri : $it")
        }
    }*/

    runBlocking<Unit> {
        // Launch a concurrent coroutine to check if the main thread is blocked
        launch {
            for (k in 1..3) {
                println("I'm not blocked $k")
                delay(100)
            }
        }
        // Collect the flow
        flowFunc().collect { value -> println(value) }


    }

}
