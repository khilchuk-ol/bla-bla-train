package com.example.bla_bla_train.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bla_bla_train.model.Trip
import com.example.lab1.R

class TripListAdapter : ListAdapter<Trip, TripListAdapter.TripViewHolder>(TripsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
        return TripViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind("${current.time} : ${current.from.padStart(10)} ---> ${current.to.padEnd(10)}")
    }

    class TripViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tripItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            tripItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): TripViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return TripViewHolder(view)
            }
        }
    }

    class TripsComparator : DiffUtil.ItemCallback<Trip>() {
        override fun areItemsTheSame(oldItem: Trip, newItem: Trip): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Trip, newItem: Trip): Boolean {
            return oldItem.from == newItem.from && oldItem.to == newItem.to && oldItem.time == newItem.time
        }
    }
}