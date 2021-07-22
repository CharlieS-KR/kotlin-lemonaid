package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    val AMAZING: String = "AMAZING"
    val GOOD: String = "GOOD"
    val OK: String = "OK"

    lateinit var editText: EditText
    lateinit var amazingRadio: RadioButton
    lateinit var goodRadio: RadioButton
    lateinit var okRadio: RadioButton

    var currentlySelectedRadio: String = AMAZING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.cost_of_service)
        amazingRadio = findViewById(R.id.option_twenty_percent)
        goodRadio = findViewById(R.id.option_eighteen_percent)
        okRadio = findViewById(R.id.option_fifteen_percent)

        amazingRadio.setOnClickListener { updateSelectedRadio(AMAZING) }
        goodRadio.setOnClickListener { updateSelectedRadio(GOOD) }
        okRadio.setOnClickListener { updateSelectedRadio(OK) }
    }

    private fun updateSelectedRadio(serviceQuality: String) {
        currentlySelectedRadio = serviceQuality
    }

    private fun calculateTotalCost(): Double {
        var tipAmount: Double
        val costOfService: Double = editText.text.toString().toDouble()

        if (currentlySelectedRadio === AMAZING) {
            tipAmount = costOfService * .2
            return costOfService + tipAmount
        } else if (currentlySelectedRadio === GOOD) {
            tipAmount = costOfService * .18
            return costOfService + tipAmount
        } else {
            tipAmount = costOfService * .15
            return costOfService + tipAmount
        }
    }
}