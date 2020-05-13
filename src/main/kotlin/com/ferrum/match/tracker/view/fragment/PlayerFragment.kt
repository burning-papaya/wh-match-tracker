/**
 *  Author: BurningPapaya
 *  Date: 10.05.2020
 *  Time: 21:43
 */
package com.ferrum.match.tracker.view.fragment

import com.ferrum.match.tracker.domain.Player
import com.ferrum.match.tracker.model.PlayerModel
import javafx.beans.binding.BooleanBinding
import javafx.beans.property.Property
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.value.ObservableBooleanValue
import javafx.scene.Node
import tornadofx.*


class PlayerFragment : Fragment() {

    private val player : PlayerModel by inject()
    private val form: PlayerModel = PlayerModel(Player(""))
    private val showVPInput = SimpleBooleanProperty(false)
    private val showKPInput = SimpleBooleanProperty(false)
    private val showCPInput = SimpleBooleanProperty(false)

    override val root = vbox {
        hbox {
            spacing = 30.toDouble()
            textfield(player.name)
            button("End turn") {
                visibleWhen(player.isMyTurn)
                action {
                    toggleTurn()
                }
            }
        }
        this += getPropertyEditor(form.victoryPoints, showVPInput, "VP")
        this += getPropertyEditor(form.killPoints, showKPInput, "KP")
        this += getPropertyEditor(form.commandPoints, showCPInput, "CP")
    }

    private fun toggleTurn() {
        // set current player's turn to end
        player.isMyTurn.value = !player.isMyTurn.value
        player.commit()
    }

    fun getPropertyEditor (
        property: Property<Number>,
        displayFlag: Property<Boolean>,
        label: String
    ) : Node {
        return hbox {
            button("+") {
                action {
                    property.value = property.value.toInt() + 1
                    displayFlag.value = property.value != 0
                }
            }
            label(" $label ") {
                visibleWhen(!(displayFlag as SimpleBooleanProperty))
            }
            textfield (property) {
                visibleWhen(displayFlag)
            }
            button("-") {
                action {
                    property.value = property.value.toInt() - 1
                    displayFlag.value = property.value != 0
                }
            }
            label(" : ${property.value}")
        }
    }
}