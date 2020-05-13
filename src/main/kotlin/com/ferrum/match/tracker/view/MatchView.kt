/**
 *  Author: BurningPapaya
 *  Date: 08.05.2020
 *  Time: 18:10
 */
package com.ferrum.match.tracker.view

import com.ferrum.match.tracker.controller.MatchController
import com.ferrum.match.tracker.domain.Player
import com.ferrum.match.tracker.model.PlayerModel
import com.ferrum.match.tracker.view.fragment.PlayerFragment
import javafx.geometry.Pos
import javafx.scene.layout.VBox
import tornadofx.*
import kotlin.math.abs


class MatchView : View() {

    // Controllers
    private val controller: MatchController by inject()

    // data
    private var battleRound = 1
    private val players = controller.getPlayers()
    private val playerForm = PlayerModel(Player())


    override val root = borderpane {
        center = vbox {
            hbox {
                spacing = 30.toDouble()
                textfield("Round $battleRound")
                label("00:01:40")
                alignment = Pos.TOP_CENTER
            }
            hbox {
                spacing = 30.toDouble()
                alignment = Pos.TOP_CENTER
                // set player 1 data scope
                val player1Scope = Scope()
                setInScope(players[0], player1Scope)
                val player1Field = find<PlayerFragment>(player1Scope)
                this += player1Field

                vbox {
                    button("commit") {
                        action { println("Player1 : ${players[0].isDirty} | Player2 : ${players[1].isDirty}" ) }
                    }
                    button("reset")
                    button("End turn") {
                        action {

                        }
                    }
                }
                // set player 2 data scope
                val player2Scope = Scope()
                setInScope(players[1], player2Scope)
                this += find<PlayerFragment>(player2Scope)
            }
            hbox {
                alignment = Pos.TOP_CENTER
                spacing = 30.toDouble()

                button("PLAY") {
                    action { players[0].isMyTurn.setValue(true) }
                }
                button("STOP")
            }
        }
    }

    private fun endPlayerTurn(playerIndex: Int) {
        /*// set current player's turn to end
        players[playerIndex].isMyTurn.value = false
        players[playerIndex].commit()
        // set turn of the second player
        // abs(1-1) = 0 ||| abs(0-1)=1
        players[abs(playerIndex-1)].isMyTurn.value = true
        players[abs(playerIndex-1)].commit()
        // increment battle round if playerIndex = 1
        battleRound += playerIndex*/
    }
}
