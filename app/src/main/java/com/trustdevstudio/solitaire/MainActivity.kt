package com.trustdevstudio.solitaire

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*

val cardBackDrawable = R.drawable.cardback_green5
val emptyPileDrawable = R.drawable.cardback_blue1

fun View.getResId(card: Card): Int {
  val resourceName = "card${card.suit}${cardsMap[card.value]}".toLowerCase()
  return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
}

class MainActivity : AppCompatActivity(), GameView {
  var deckView: DeckView? = null
  var wastePileView: WastePileView? = null

  override fun update(model: GameModel) {
    deckView!!.update()
    wastePileView!!.update()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    GamePresenter.setGameView(this)
    GameModel.resetGame()

    // 7 card piles wide, leaving 4dp padding on each side
    val cardWidth = (displayMetrics.widthPixels - dip(8)) / 7
    // Card PNG is 140*190. Use cardWidth  along with ratio.
    val cardHeight = cardWidth * (190 / 140)

    verticalLayout {
      leftPadding = dip(4)
      rightPadding = dip(4)
      topPadding = dip(8)

      linearLayout {
        deckView = deckView().lparams(cardWidth, cardHeight)
        wastePileView = wastePileView().lparams(cardWidth, cardHeight)
        view().lparams(cardWidth, 0)

        for (i in 0..3)
          imageView(imageResource = emptyPileDrawable).lparams(cardWidth, cardHeight)
      }

      linearLayout {

      }
    }

    // Demo Anko code. Replaces XML with object creation. Each object created passes in
    // an init function which, when called, describes the View's properties. This can include
    // style attributes, listeners, ids, etc. Also, each object created allows for calls to
    // describe layout using lparams extension functions.
//    var counter = 0
//
//    relativeLayout {
//      val counterTextView = textView {
//        id = 4343
//        text = "0"
//        textSize = 24f
//      }
//      button {
//        text = "Press Me"
//        onClick {
//          counter++
//          counterTextView.text = counter.toString()
//        }
//      }.lparams {
//        below(counterTextView)
//      }
//    }

    // This portion now commented out to switch over to Anko
//        // Kotlin Android extensions allow for direct reference to widget without id lookup.
//        // Can also use lambdas in listeners.
//        counterButton.setOnClickListener( {
//            counter++
//            counterTextView.text = counter.toString()
//        })
  }
}
