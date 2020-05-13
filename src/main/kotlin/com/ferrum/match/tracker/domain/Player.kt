/**
 *  Author: BurningPapaya
 *  Date: 08.05.2020
 *  Time: 21:42
 */
package com.ferrum.match.tracker.domain


import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue



class Player() {

    val nameProperty = SimpleStringProperty("")
    var name: String? by nameProperty

    val factionProperty = SimpleStringProperty("")
    var faction: String? by factionProperty

    val vpProperty = SimpleIntegerProperty(0)
    var victoryPoints: Int by vpProperty

    val kpProperty = SimpleIntegerProperty(0)
    var killPoints: Int by kpProperty

    val cpProperty = SimpleIntegerProperty(0)
    var commandPoints: Int by cpProperty

    val myTurnProperty = SimpleBooleanProperty(false)
    var isMyTurn: Boolean by myTurnProperty

    constructor(name: String?) : this() {
        this.name = name
        this.faction = "Default"
        this.commandPoints = 0
        this.victoryPoints = 0
        this.killPoints = 0
        this.isMyTurn = false
    }

}