package com.ravinada.mansaInfotech

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val dataSet: MutableList<String>,
    private var onItemClick: (Int) -> Unit,
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.textView.text = item

        holder.itemView.setOnClickListener {
            onItemClick.invoke(holder.layoutPosition)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun getItem(position: Int): String {
        return dataSet[position]
    }

    fun removeItems(items: List<String>) {
        items.forEach {
            val position = dataSet.indexOf(it)
            if (position != -1) {
                dataSet.removeAt(position)
                notifyItemRemoved(position)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: List<String>) {
        dataSet.addAll(items)
        notifyDataSetChanged()
    }
}

