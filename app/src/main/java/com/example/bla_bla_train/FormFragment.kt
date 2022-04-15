package com.example.bla_bla_train

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.bla_bla_train.model.Trip
import com.example.bla_bla_train.viewmodel.TripViewModel
import com.example.lab1.R
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

class FormFragment() : Fragment(R.layout.fragment_form) {
    var createTripListener: ((trip: Trip) -> Unit)? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fromInput: TextInputEditText = view.findViewById(R.id.fromInput)
        val toInput: TextInputEditText = view.findViewById(R.id.toInput)
        val timeInput: RadioGroup = view.findViewById(R.id.timeInput)

        val okButton: Button = view.findViewById(R.id.okButton)
        okButton.setOnClickListener { _ ->
            val chosenTimeBtn: RadioButton? = view.findViewById(timeInput.checkedRadioButtonId)

            val isInvalidInput = !isTextInputValid(fromInput.text.toString()) ||
                    !isTextInputValid(toInput.text.toString()) ||
                    chosenTimeBtn == null ||
                    chosenTimeBtn.text.toString().isEmpty()

            val msg = if (isInvalidInput) {
                "Для підтвердження потрібно заповнити всі поля коректно"
            } else {
                "Ви обрали таку поїздку: \n  час    : " + chosenTimeBtn?.text.toString() + " \n  маршрут: " + fromInput.text.toString() + " -> " + toInput.text.toString()
            }

            if (!isInvalidInput) {
                val sdf = SimpleDateFormat("dd/M/yyyy", Locale.UK)
                val currentDate = sdf.format(Date())

                val trip = Trip(fromInput.text.toString(), toInput.text.toString(), "$currentDate ${chosenTimeBtn?.text.toString()}")

                createTripListener?.let { it(trip) }
            }

            parentFragmentManager.setFragmentResult(CREATE_TRIP_KEY, bundleOf("msg" to msg))
        }
    }

    private fun isTextInputValid(str: String?): Boolean {
        val regex = """^[^A-Za-z]+$""".toRegex()
        return str != null && str.isNotEmpty() && !regex.matches(str)
    }

    companion object {
        const val CREATE_TRIP_KEY = "create.trip.form.response"
    }
}