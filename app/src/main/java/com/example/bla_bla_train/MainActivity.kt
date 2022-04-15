package com.example.bla_bla_train

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab1.R
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val fromInput: TextInputEditText = findViewById(R.id.fromInput)
        val toInput: TextInputEditText = findViewById(R.id.toInput)
        val timeInput: RadioGroup = findViewById(R.id.timeInput)

        val okButton: Button = findViewById(R.id.okButton)
        okButton.setOnClickListener {
            val chosenTimeBtn: RadioButton? = findViewById(timeInput.checkedRadioButtonId)

            if (!isTextInputValid(fromInput.text.toString()) ||
                !isTextInputValid(toInput.text.toString()) ||
                chosenTimeBtn == null ||
                chosenTimeBtn.text.toString().isEmpty()) {

                val toast = Toast.makeText(applicationContext, "Для підтвердження потрібно заповнити всі поля коректно", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.BOTTOM, 0, 0)
                toast.show()
            } else {
                val tripInfoMsg = "Ви обрали таку поїздку: \n  час    : " + chosenTimeBtn.text.toString() + " \n  маршрут: " + fromInput.text.toString() + " -> " + toInput.text.toString()

                val toast = Toast.makeText(applicationContext, tripInfoMsg, Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.BOTTOM, 0, 0)
                toast.show()
            }
        }
    }

    private fun isTextInputValid(str: String?): Boolean {
        val regex = """^[^A-Za-z]+$""".toRegex()
        return str != null && str.isNotEmpty() && !regex.matches(str)
    }
}