package com.ferrum.match.tracker

import com.ferrum.match.tracker.view.MatchView
import javafx.stage.Stage
import tornadofx.App
import tornadofx.reloadStylesheetsOnFocus

class Application : App(MatchView::class) {
    init {
        reloadStylesheetsOnFocus()
    }

    override fun start(stage: Stage) {
        super.start(stage)
        stage.minWidth = 600.0
        stage.minHeight = 400.0
    }
}