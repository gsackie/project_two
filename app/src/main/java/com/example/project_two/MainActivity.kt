package com.example.project_two

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.project_two.R
import kotlin.math.*

/**
 * MainActivity is the main activity of the calculator application.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private var currentInput = StringBuilder()
    private var currentOperator = ""
    private var firstOperand = 0.0

    class MainActivity : AppCompatActivity() {
        private lateinit var textView: TextView
        private var currentInput = StringBuilder()
        private var currentOperator = ""
        private var firstOperand = 0.0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Initialize the textView
            textView = findViewById(R.id.textView2)
        }

        override fun onConfigurationChanged(newConfig: Configuration) {
            super.onConfigurationChanged(newConfig)
            if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                setContentView(R.layout.activity_main)
            }
            else{
                setContentView(R.layout.activity_main)
            }
        }


    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("currentInput", currentInput.toString())
        outState.putString("currentOperator", currentOperator)
        outState.putDouble("firstOperand", firstOperand)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore the saved state here
        currentInput = StringBuilder(savedInstanceState.getString("currentInput", ""))
        currentOperator = savedInstanceState.getString("currentOperator", "")
        firstOperand = savedInstanceState.getDouble("firstOperand", 0.0)
        textView.text = currentInput.toString()
    }

/**
     * Handles button clicks (digits and decimal point).
     *
     * @param view The clicked button view.
     */
    fun onButtonClick(view: View) {
        if (view is Button) {
            val buttonText = view.text.toString()
            currentInput.append(buttonText)
            textView.text = currentInput.toString()

            Log.d("Calculator", "Button clicked: $buttonText")
        }
    }

    /**
     * Handles operator button clicks (+, -, *, /).
     *
     * @param view The clicked operator button view.
     */
    fun onOperatorClick(view: View) {
        if (view is Button) {
            val operator = view.text.toString()
            if (currentOperator.isNotEmpty()) {
                val currentValue = currentInput.toString().toDoubleOrNull() ?: 0.0
                when (currentOperator) {
                    "+" -> firstOperand += currentValue
                    "-" -> firstOperand -= currentValue
                    "*" -> firstOperand *= currentValue
                    "/" -> firstOperand /= currentValue
                }
                currentInput.clear()
                currentInput.append(firstOperand.toString())
                textView.text = currentInput.toString()
            } else {
                firstOperand = currentInput.toString().toDoubleOrNull() ?: 0.0
                currentInput.clear()
            }
            currentOperator = operator

            Log.d("Calculator", "Operator Clicked: $operator")
        }
    }


    /**
     * Handles equals button click (=).
     *
     * @param view The clicked equals button view.
     */
    fun onEqualsClick(view: View) {
        if (currentOperator.isNotEmpty()) {
            val currentValue = currentInput.toString().toDoubleOrNull() ?: 0.0
            when (currentOperator) {
                "+" -> firstOperand += currentValue
                "-" -> firstOperand -= currentValue
                "*" -> firstOperand *= currentValue
                "/" -> firstOperand /= currentValue
            }
            currentInput.clear()
            currentInput.append(firstOperand.toString())
            textView.text = currentInput.toString()
            currentOperator = ""

            Log.d("Calculator", "Equals Button Clicked")
        }
    }


    /**
     * Handles clear button click (C).
     *
     * @param view The clicked clear button view.
     */
    fun onClearClick(view: View) {
        currentInput.clear()
        currentOperator = ""
        firstOperand = 0.0
        textView.text = "0"

        Log.d("Calculator", "Clear Button Clicked")
    }


    /**
     * Handles plus/minus button click (±).
     *
     * @param view The clicked plus/minus button view.
     */
    fun onPlusMinusClick(view: View) {
        val currentText = currentInput.toString()
        if (currentText.isNotEmpty()) {
            if (currentText[0] == '-') {
                currentInput.deleteCharAt(0)
            } else {
                currentInput.insert(0, "-")
            }
            textView.text = currentInput.toString()

            Log.d("Calculator", "Plus/Minus Button Clicked")
        }
    }

    /**
     * Handles percent button click (%).
     *
     * @param view The clicked percent button view.
     */
    fun onPercentClick(view: View) {
        val currentValue = currentInput.toString().toDoubleOrNull() ?: 0.0
        val result = currentValue / 100.0
        currentInput.clear()
        currentInput.append(result.toString())
        textView.text = currentInput.toString()

        Log.d("Calculator", "Percent Button Clicked")
    }


    /**
     * Handles the "tan" button click.
     *
     * @param view The clicked "tan" button view.
     */
    fun onTanClick(view: View) {
        val currentValue = currentInput.toString().toDoubleOrNull() ?: 0.0
        val result = tan(currentValue)
        currentInput.clear()
        currentInput.append(result.toString())
        textView.text = currentInput.toString()

        Log.d("Calculator", "Tan Button Clicked")
    }


    /**
     * Handles the "sin" button click.
     *
     * @param view The clicked "sin" button view.
     */
    fun onSinClick(view: View) {
        val currentValue = currentInput.toString().toDoubleOrNull() ?: 0.0
        val result = sin(currentValue)
        currentInput.clear()
        currentInput.append(result.toString())
        textView.text = currentInput.toString()

        Log.d("Calculator", "Sin Button Clicked")
    }

    /**
     * Handles the "cos" button click.
     */
    fun onCosClick(view: View) {
        val currentValue = currentInput.toString().toDoubleOrNull() ?: 0.0
        val result = cos(currentValue)
        currentInput.clear()
        currentInput.append(result.toString())
        textView.text = currentInput.toString()

        Log.d("Calculator", "Cos Button Clicked")
    }

    /**
     * Handles the "log10" button click.
     *
     * @param view The clicked "log10" button view.
     */
    fun onLog10Click(view: View) {
        val currentValue = currentInput.toString().toDoubleOrNull() ?: 0.0
        val result = log10(currentValue)
        currentInput.clear()
        currentInput.append(result.toString())
        textView.text = currentInput.toString()

        Log.i("Calculator", "Log10 Button Clicked")
    }


    /**
     * Handles the "ln" button click.
     *
     * @param view The clicked "ln" button view.
     */
    fun onLnClick(view: View) {
        val currentValue = currentInput.toString().toDoubleOrNull() ?: 0.0
        val result = ln(currentValue)
        currentInput.clear()
        currentInput.append(result.toString())
        textView.text = currentInput.toString()

        Log.i("Calculator", "Ln Button Clicked")
    }



}


