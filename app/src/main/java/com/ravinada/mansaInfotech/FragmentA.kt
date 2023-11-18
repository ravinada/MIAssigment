package com.ravinada.mansaInfotech

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ravinada.mansaInfotech.databinding.FragmentABinding

class FragmentA : Fragment() {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RecyclerViewAdapter
    private val selectedItems = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerViewA.layoutManager = layoutManager
        adapter = RecyclerViewAdapter((0..9).map { it.toString() }.toMutableList()) { position ->
            val selectedItem = adapter.getItem(position)
            if (!selectedItems.contains(selectedItem)) {
                selectedItems.add(selectedItem)
            }
        }
        binding.recyclerViewA.adapter = adapter
    }

    fun moveSelectedItemsToFragmentB() {
        (requireActivity() as? MainActivity)?.moveItemsToFragmentB(selectedItems)
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
