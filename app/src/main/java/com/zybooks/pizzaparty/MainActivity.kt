package com.zybooks.pizzaparty

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
        numAttendEditText.requestFocus()


    }

/**
 *  Calculates the total number of pizzas required for a pizza party based on the
 *  number of attendees and their hunger level. The result is displayed in a TextView.
 *  @param view The view that was clicked to initiate the calculation.
 *
*/
    fun calculateClick(view: View) {

        // Get the text that was typed into the EditText
        val numAttendStr = numAttendEditText.text.toString()

        // Convert the text into an integer
        val numAttend = numAttendStr.toIntOrNull() ?: 0

        // Determine how many slices on average each person will eat
        val hungerLevel = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> PizzaCalculator.HungerLevel.LIGHT
            R.id.medium_radio_button -> PizzaCalculator.HungerLevel.MEDIUM
            else -> PizzaCalculator.HungerLevel.RAVENOUS
        }
        // Get the number of pizzas needed
        val calc = PizzaCalculator(numAttend,hungerLevel)
        val totalPizzas = calc.totalPizzas

        //place totalPizzas into the string resource and display
        val totalText = getString(R.string.total_pizza_num, totalPizzas.toString())
        numPizzasTextView.text = totalText
    }
}