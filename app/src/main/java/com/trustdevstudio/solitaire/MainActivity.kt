package com.trustdevstudio.solitaire

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter = 0

        // Kotlin Android extensions allow for direct reference to widget without id lookup.
        // Can also use lambdas in listeners.
        counterButton.setOnClickListener( {
            counter++
            counterTextView.text = counter.toString()
        })
    }
}
