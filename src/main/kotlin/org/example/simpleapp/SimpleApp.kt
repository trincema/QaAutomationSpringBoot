package org.example.simpleapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SprintBootAppApplication

fun main(args: Array<String>) {
    runApplication<SprintBootAppApplication>(*args)
}
