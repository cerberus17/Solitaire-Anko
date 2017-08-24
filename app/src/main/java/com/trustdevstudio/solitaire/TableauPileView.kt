package com.trustdevstudio.solitaire

import android.content.Context
import android.view.ViewManager
import org.jetbrains.anko._RelativeLayout
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.dip
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.imageView
import org.jetbrains.anko.onClick

class TableauPileView(context: Context, val index: Int): _RelativeLayout(context) {
  init {
    addViews()
  }

  fun update() {
    removeAllViews()
    addViews()
  }

  private fun addViews() {
    val cards = GameModel.tableauPiles[index].cards

    cards.forEachIndexed { cardIndex, card ->
      imageView {
        y = (cardIndex * dip(25)).toFloat()
        imageResource = if (card.faceUp) getResId(card) else cardBackDrawable

        onClick {
          GamePresenter.onTableauTap(index, cardIndex)
        }
      }.lparams(context.cardWidth, context.cardHeight)
    }
  }
}

fun ViewManager.tableauPileView(index: Int, init: TableauPileView.() -> Unit = {}) = ankoView({ TableauPileView(it, index) }, 0, init)