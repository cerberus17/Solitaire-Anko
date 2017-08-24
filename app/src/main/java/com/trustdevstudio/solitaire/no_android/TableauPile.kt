package com.trustdevstudio.solitaire

class TableauPile(var cards: MutableList<Card> = mutableListOf()) {
  init {
    if (cards.size > 0)
      cards.last().faceUp = true
  }

  fun addCards(newCards: MutableList<Card>): Boolean {
    if (cards.size > 0) {
      if (newCards.first().value == cards.last().value - 1 &&
          suitCheck(newCards.first(), cards.last())) {
        cards.addAll(newCards)
        return true
      }
    }
    else if (newCards.first().value == 12) {
      cards.addAll(newCards)
      return true
    }

    return false
  }

  fun removeCards(tappedIndex: Int) {
    for (i in tappedIndex..cards.lastIndex) {
      cards.removeAt(tappedIndex)
    }

    if (cards.size > 0 && !cards.last().faceUp)
      cards.last().faceUp = true
  }

  fun suitCheck(card1: Card, card2: Card): Boolean {
    return ((redSuits.contains(card1.suit) && blackSuits.contains(card2.suit)) ||
            (blackSuits.contains(card1.suit) && redSuits.contains(card2.suit)))
  }
}