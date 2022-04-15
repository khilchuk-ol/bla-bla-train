package com.example.bla_bla_train

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.lab1.R
import com.google.android.material.textfield.TextInputEditText

class FormFragment : Fragment(R.layout.fragment_form) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fromInput: TextInputEditText = view.findViewById(R.id.fromInput)
        val toInput: TextInputEditText = view.findViewById(R.id.toInput)
        val timeInput: RadioGroup = view.findViewById(R.id.timeInput)

        val okButton: Button = view.findViewById(R.id.okButton)
        okButton.setOnClickListener { _ ->
            val chosenTimeBtn: RadioButton? = view.findViewById(timeInput.checkedRadioButtonId)

            val msg = if (!isTextInputValid(fromInput.text.toString()) ||
                !isTextInputValid(toInput.text.toString()) ||
                chosenTimeBtn == null ||
                chosenTimeBtn.text.toString().isEmpty()) {
                "Для підтвердження потрібно заповнити всі поля коректно"
            } else {
                "Ви обрали таку поїздку: \n  час    : " + chosenTimeBtn.text.toString() + " \n  маршрут: " + fromInput.text.toString() + " -> " + toInput.text.toString()
            }

            parentFragmentManager.setFragmentResult("tripFormResp", bundleOf("msg" to msg))
        }
    }

    private fun isTextInputValid(str: String?): Boolean {
        val regex = """^[^A-Za-z]+$""".toRegex()
        return str != null && str.isNotEmpty() && !regex.matches(str)
    }
}