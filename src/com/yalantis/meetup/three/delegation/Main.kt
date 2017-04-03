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

class Person(name: Nameable): Nameable by name

fun main(args: Array<String>) {
    val person = Person(JackName())
    println(person.name)
}
