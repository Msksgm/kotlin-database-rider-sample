package com.example.kotlindatabaseridersample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinDatabaseRiderSampleApplication

fun main(args: Array<String>) {
	@Suppress("SpreadOperator")
	runApplication<KotlinDatabaseRiderSampleApplication>(*args)
}
