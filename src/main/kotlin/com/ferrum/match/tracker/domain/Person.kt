/**
 *  Author: BurningPapaya
 *  Date: 08.05.2020
 *  Time: 16:34
 */
package com.ferrum.match.tracker.domain

import tornadofx.getProperty
import tornadofx.property
import java.time.LocalDate
import java.time.Period


class Person(id: Int, name: String, birthday: LocalDate) {
    var id: Int by property(id)
    fun idProperty() = getProperty(Person::id)

    var name: String by property(name)
    fun nameProperty() = getProperty(Person::name)

    var birthday: LocalDate by property(birthday)
    fun birthdayProperty() = getProperty(Person::birthday)

    val age: Int get() = Period.between(birthday, LocalDate.now()).years
}