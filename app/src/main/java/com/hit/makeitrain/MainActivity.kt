package com.hit.makeitrain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    var moneyCounter = 0
    val numberFormat : NumberFormat = NumberFormat.getCurrencyInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_makeitrain.setOnClickListener{
            makeItRain()
        }

        btn_showtag.setOnClickListener {
            showTag()
        }

    }

    private fun checkMoneyCounter() {
        var Money = numberFormat.parse(moneyCount.text.toString())
        var currentMoney = Money.toInt()
        Log.d("LogCMC", "Current Money: $currentMoney")

        when (currentMoney) {
            10000 -> {
                bg_screen.setBackgroundColor(getResources().getColor(R.color.colorPrimary))
                Toast.makeText(this, "Wow...", Toast.LENGTH_SHORT).show()
            }
            20000 -> {
                bg_screen.setBackgroundColor(getResources().getColor(R.color.colorAccent))
                Toast.makeText(this, "Really dude...??", Toast.LENGTH_SHORT).show()
            }
            30000 -> {
                bg_screen.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark))
                Toast.makeText(this, "Let's make a party!!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun makeItRain() {
        moneyCounter += 1000
        moneyCount.setText(numberFormat.format(moneyCounter))

        checkMoneyCounter()
    }

    private fun showTag() {
        Log.d("LogST", "Show Tag")
    }
}
