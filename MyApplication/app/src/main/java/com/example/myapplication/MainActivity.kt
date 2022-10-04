package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var listOfFoods = listOf("Pizza", "Hamburger", "Mexican", "American", "Cheese")
    var lastRandomIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFoodButton.setOnClickListener {
            if(addFoodEditText.text.toString().isBlank()) {
                Toast.makeText(this, "Add new food field can't be empty, please fill it.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newFood = addFoodEditText.text.toString()
            addFoodEditText.text.clear()
            listOfFoods = listOfFoods + newFood
            textView.text = newFood
            Toast.makeText(applicationContext,"Added $newFood to the list of foods", Toast.LENGTH_SHORT).show()
        }

        decideButton.setOnClickListener {
            var randomFoodIndex = Random.nextInt(listOfFoods.size)
            while (randomFoodIndex == lastRandomIndex) { //User should not get the same food again...
                randomFoodIndex = Random.nextInt(listOfFoods.size)
            }
            lastRandomIndex = randomFoodIndex
            textView.text = listOfFoods[randomFoodIndex]
        }
    }
}