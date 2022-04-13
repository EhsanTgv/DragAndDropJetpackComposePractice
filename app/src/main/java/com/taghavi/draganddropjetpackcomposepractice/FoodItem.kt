package com.taghavi.draganddropjetpackcomposepractice

import androidx.annotation.DrawableRes

data class FoodItem(
    val id: Int,
    val name: String,
    val price: Double,
    @DrawableRes val image: Int
) {
  companion object{
      val foodList = listOf(
          FoodItem(1, "Pizza", 20.0, R.drawable.food_pizza),
          FoodItem(2, "French Toast", 10.5, R.drawable.food_toast),
          FoodItem(3, "Chocolate cake", 12.99, R.drawable.food_cake),
      )
  }
}