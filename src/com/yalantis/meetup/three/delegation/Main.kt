package com.yalantis.meetup.three.delegation

/**
 * Created by ihor on 03.04.17.
 */

interface Nameable {
    var name: String
}

class JackName : Nameable {
    override var name: String = "Jack"
}

class LongDistanceRunner: Runnable {
    override fun run() {
        println("long")
    }
}

class Person(name: Nameable, runner: Runnable): Nameable by name, Runnable by runner

fun main(args: Array<String>) {
    val person = Person(JackName(), LongDistanceRunner())
    println(person.name)
    person.run()
}
