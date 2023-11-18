package com.ravinada.mansaInfotech

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ravinada.mansaInfotech.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentA: FragmentA
    private lateinit var fragmentB: FragmentB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentA = FragmentA()
        fragmentB = FragmentB()

        supportFragmentManager.beginTransaction()
            .replace(binding.containerA.id, fragmentA)
            .replace(binding.containerB.id, fragmentB)
            .commit()

        val moveRightButton = binding.buttonRight
        val moveLeftButton = binding.buttonLeft

        moveRightButton.setOnClickListener {
            fragmentA.moveSelectedItemsToFragmentB()
        }

        moveLeftButton.setOnClickListener {
            fragmentB.moveSelectedItemsToFragmentA()
        }
    }

    fun moveItemsToFragmentB(items: List<String>) {
        fragmentB.addItems(items)
        fragmentA.removeItems(items)
    }

    fun moveItemsToFragmentA(items: List<String>) {
        fragmentA.addItems(items)
        fragmentB.removeItems(items)
    }
}
