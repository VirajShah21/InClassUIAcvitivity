package edu.temple.inclassuiacvitivity

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var selectedTextSize: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val changeButton = findViewById<Button>(R.id.changeButton)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        // Step 1: Populate array
        val numberArray = IntArray(100)

        for (i in 1 until 101) {
            numberArray[i - 1] = i
        }

        spinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, numberArray.asList())


        // Step 2: Save selected text size
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedTextSize = position + 1
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedTextSize = 12
            }
        }

        // Step 3: Change TextView to saved text size
        changeButton.setOnClickListener {
            val textView = findViewById<TextView>(R.id.textDisplay)
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, selectedTextSize as Float)
        }

    }
}