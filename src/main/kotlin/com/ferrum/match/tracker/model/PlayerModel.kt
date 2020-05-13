/**
 *  Author: BurningPapaya
 *  Date: 08.05.2020
 *  Time: 22:04
 */
package com.ferrum.match.tracker.model

import com.ferrum.match.tracker.domain.Player
import tornadofx.ItemViewModel


class PlayerModel(player: Player) : ItemViewModel<Player>(player) {
    val name = bind(Player::nameProperty)
    val faction = bind(Player::factionProperty)
    val victoryPoints = bind(Player::vpProperty)
    val killPoints = bind(Player::kpProperty)
    val commandPoints = bind(Player::cpProperty)
    val isMyTurn = bind(Player::myTurnProperty)
}