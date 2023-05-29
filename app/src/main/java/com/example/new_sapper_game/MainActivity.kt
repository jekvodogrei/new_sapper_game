package com.example.new_sapper_game

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.util.Random
import android.widget.Toast



class MainActivity : ComponentActivity() {

    private var buttons: Array<TextView>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createButtons()

    }

    fun createButtons() {
        buttons = Array(64) {
            findViewById<TextView?>(getButtonId(it + 1))
        }


        var minesLeft = 10
        var emptyButton = 64


        while (emptyButton > 0) {
            val buttonIndex = Random().nextInt(buttons!!.size)
            val btn = buttons!![buttonIndex]

            if (btn.text.toString() != " ") {
                btn.setOnClickListener{btn.text = "no" }

                emptyButton--
            }
        }

        while (minesLeft > 0) {

            val mineIndex = Random().nextInt(buttons!!.size)
            var mineButton = buttons!![mineIndex]
            val duration = 1000
            var toast = Toast.makeText(applicationContext, "Over", duration)

            if (mineButton.text.toString() != "MINE") {
                mineButton.setOnClickListener{mineButton.text = "M"}
                mineButton = toast

                minesLeft--
            }
        }
    }

    private fun getButtonId(index: Int): Int = this.resources.getIdentifier("button$index", "id", this.packageName)

}
