package com.yalantis.meetup.three.properties


import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


/**
 * Created by ihor on 04.04.17.
 */
fun main(args: Array<String>) {
    val e = Example()
    println(e.byVarDelegate)
    println(e.byValDelegate)
    println(e.byReadOnlyDelegate)
    println(e.byReadWriteDelegate)
}

class Example {
    var byVarDelegate: String by VarDelegate()
    var byReadWriteDelegate: String by ReadWriteDelegate()


    val byValDelegate: String by ValDelegate()
    val byReadOnlyDelegate: String by ReadOnlyDelegate()
}

class VarDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}

class ValDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }
}

class ReadOnlyDelegate: ReadOnlyProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }
}

class ReadWriteDelegate : ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}