/**
Author: BurningPapaya
Date: 07.04.2020
Time: 18:55
 */
package com.ferrum.match.tracker.controller

import javafx.collections.FXCollections
import kotlinx.coroutines.GlobalScope
import kotlin.coroutines.AbstractCoroutineContextKey
import kotlinx.coroutines.launch
import tornadofx.Controller


class BaseController: Controller() {

    val values = FXCollections.observableArrayList("Alpha","Beta","Gamma","Delta")
}

fun main() {
    GlobalScope.launch {
        println("Hello")
    }
    Thread.sleep(1000)
    println("sadas")
}