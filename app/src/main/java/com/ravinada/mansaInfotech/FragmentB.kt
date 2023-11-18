package com.ravinada.mansaInfotech

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ravinada.mansaInfotech.databinding.FragmentBBinding

class FragmentB : Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RecyclerViewAdapter
    private val selectedItems = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerViewB.layoutManager = layoutManager
        adapter = RecyclerViewAdapter(mutableListOf()) { position ->
            val selectedItem = adapter.getItem(position)
            if (!selectedItems.contains(selectedItem)) {
                selectedItems.add(selectedItem)
            }
        }
        binding.recyclerViewB.adapter = adapter
    }

    fun moveSelectedItemsToFragmentA() {
        (activity as? MainActivity)?.moveItemsToFragmentA(selectedItems)
        selectedItems.clear()
    }

    fun removeItems(items: List<String>) {
        adapter.removeItems(items)
    }

    fun addItems(items: List<String>) {
        adapter.addItems(items)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
