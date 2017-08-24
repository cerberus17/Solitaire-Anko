package com.trustdevstudio.solitaire

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

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
