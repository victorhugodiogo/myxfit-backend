package br.com.myxfit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyXFitApplication

fun main(args: Array<String>) {
    runApplication<MyXFitApplication>(*args)
}
