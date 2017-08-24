package com.trustdevstudio.solitaire

import java.util.*

class Deck {
//  val fn = fun(i: Int): Card {
//    val value = i % 13;
//    val suit = when(i / 13) {
//      0 -> "Clubs"
//      1 -> "Diamonds"
//      2 -> "Hearts"
//      else -> "Spades"
//    }
//
//    return Card(value, suit)
//  }

  // "it" is internal default variable name for single argument lambdas.
  val cards: Array<Card> = Array(52, { Card(it % 13, getSuit(it)) })
  var cardsInDeck: MutableList<Card> = cards.toMutableList()

  private fun getSuit(i: Int): String = when(i / 13) {
    0 -> clubs
    1 -> diamonds
    2 -> hearts
    else -> spades
  }

  fun drawCard(): Card = cardsInDeck.removeAt(0)

  fun reset() {
    cardsInDeck = cards.toMutableList()
    cardsInDeck.forEach { it.faceUp = false }
    Collections.shuffle(cardsInDeck)
  }
}