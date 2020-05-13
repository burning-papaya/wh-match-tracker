/**
 *  Author: BurningPapaya
 *  Date: 10.05.2020
 *  Time: 16:57
 */
package com.ferrum.match.tracker.controller

import com.ferrum.match.tracker.domain.Player
import com.ferrum.match.tracker.model.PlayerModel
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.Controller


class MatchController : Controller() {

    fun getPlayers() : ObservableList<PlayerModel> {
        return FXCollections.observableArrayList(
            PlayerModel(Player("Player 1")),
            PlayerModel(Player("Player 2")))
    }
}