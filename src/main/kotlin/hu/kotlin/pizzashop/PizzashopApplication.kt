package hu.kotlin.pizzashop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PizzashopApplication

fun main(args: Array<String>) {
    runApplication<PizzashopApplication>(*args)
}
