package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.server.util.*
import org.jetbrains.exposed.sql.*

fun main() {

    Database.connect(
        url = "ec2-34-242-84-130.eu-west-1.compute.amazonaws.com:5432/d4s9f41la5s1vs",
        driver = "org.postgresql.Driver",
        user = "unsmgdpzihlfve",
        password = "8815c5dd3cf2574a090c1fda93c67ef11c2a8a14b9c1584c59feb52ecaaf901e"
    )

    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        configureRouting()
        configureSerialization()
        configureSecurity()
    }.start(wait = true)
}
