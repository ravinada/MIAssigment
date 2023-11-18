package com.ravinada.mansaInfotech

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.ravinada.mansaInfotech.databinding.ItemLayoutBinding

class RecyclerViewAdapter(
    private val dataSet: MutableList<String>,
    private var onItemSelectionChanged: (List<String>) -> Unit,
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val selectedItems = HashSet<Int>()

    class ViewHolder(binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val textView: TextView = binding.textView
        val checkMark: AppCompatImageView = binding.checkMark
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.textView.text = item

        val isSelected = selectedItems.contains(position)
        holder.checkMark.visibility = if (isSelected) View.VISIBLE else View.GONE

        holder.itemView.setOnClickListener {
            if (isSelected) {
                selectedItems.remove(position)
            } else {
                selectedItems.add(position)
            }

            notifyItemChanged(position)
            onItemSelectionChanged.invoke(getSelectedItems())
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
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

    fun getSelectedItems(): List<String> {
        return selectedItems.map { dataSet[it] }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearSelection() {
        selectedItems.clear()
        notifyDataSetChanged()
    }
}
