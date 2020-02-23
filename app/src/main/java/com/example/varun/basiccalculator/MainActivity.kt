package com.example.varun.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val resultsValue = StringBuilder()
    private lateinit var resultText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.results_text)
        setButtonListeners()
    }

    private fun setButtonListeners() {
        val numbersList : List<View> =
            listOf(one_button, two_button, three_button, four_button, five_button,
                six_button, seven_button, eight_button, nine_button, zero_button,
                multiply_button, divide_button, plus_button, subtract_button, equal_button)

        val operationsList : List<View> =
            listOf(multiply_button, divide_button, plus_button, subtract_button, equal_button, delete_button)

        for (button in numbersList) {
            button.setOnClickListener { handleNumberInput(it) }
        }

        for (button in operationsList) {
            button.setOnClickListener { handleOperation(it) }
        }
    }

    /* Main handler for adding numbers to the results string */
    private fun handleNumberInput(view : View) {
        when (view.id) {
            R.id.zero_button -> resultsValue.append("0")
            R.id.one_button -> resultsValue.append("1")
            R.id.two_button -> resultsValue.append("2")
            R.id.three_button -> resultsValue.append("3")
            R.id.four_button -> resultsValue.append("4")
            R.id.five_button -> resultsValue.append("5")
            R.id.six_button -> resultsValue.append("6")
            R.id.seven_button -> resultsValue.append("7")
            R.id.eight_button -> resultsValue.append("8")
            R.id.nine_button -> resultsValue.append("9")
        }
        resultText.text = resultsValue
    }

    /* Handles the arithmetic */
    private fun handleOperation(view : View) {
        when (view.id) {
            R.id.multiply_button -> multiplyOperation()
            R.id.divide_button -> divideOperation()
            R.id.plus_button -> additionOperation()
            R.id.subtract_button -> subtractOperation()
            R.id.equal_button -> equalOperation()
            R.id.delete_button -> deleteOperation()
        }
    }

    private fun multiplyOperation() {

    }

    private fun divideOperation() {

    }

    private fun additionOperation() {

    }

    private fun subtractOperation() {

    }

    private fun equalOperation() {

    }

    /* Delete the last character entered */
    private fun deleteOperation() {
        /* Don't delete if the string is empty */
        if (resultsValue.isNotEmpty()) {
            resultsValue.deleteCharAt(resultsValue.lastIndex)
            resultText.text = resultsValue
            /* If the string is now empty reset to 0 */
            if (resultsValue.isEmpty()) resultText.text = "0"
        }
    }

}
