package com.example.bla_bla_train

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.lab1.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HistoryBtnFragment : Fragment(R.layout.fragment_history_btn) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val historyBtn: FloatingActionButton = view.findViewById(R.id.fab)
        historyBtn.setOnClickListener { _ ->
            val intent = Intent(this.context, TripsActivity::class.java)
            startActivity(intent)
        }
    }
}