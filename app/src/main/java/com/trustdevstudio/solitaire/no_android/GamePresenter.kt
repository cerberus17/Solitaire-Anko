package com.trustdevstudio.solitaire

object GamePresenter {
  // view is a property, but not set via constructor. Also, no getter.
  // Therefore, explicit setter needs to be used.
  // ? needs to be explicit to say it's nullable.
  var view: GameView? = null

  fun setGameView(gameView: GameView) {
    view = gameView
  }

  fun onDeckTap() {
    GameModel.onDeckTap()

    //view?.update(GameModel) will optionally call update() if view is not null
    //view!!.update(GameModel) will always call update(). Can cause NPE.
    view?.update()
  }

  fun onWasteTap() {
    GameModel.onWasteTap()

    view?.update() // Using default value (the singleton) for update param
  }

  fun onFoundationTap(index: Int) {
    GameModel.onFoundationTap(index)
    view?.update()
  }

  fun onTableauTap(index: Int, cardIndex: Int) {
    GameModel.onTableauTap(index, cardIndex)
    view?.update()
  }
}