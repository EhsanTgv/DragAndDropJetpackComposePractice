package com.taghavi.draganddropjetpackcomposepractice

import androidx.annotation.DrawableRes

data class Person(
    val id: Int,
    val name: String,
    @DrawableRes val profile: Int,
) {
    val persons = listOf(
        Person(1, "Jhone", R.drawable.user_one),
        Person(1, "Eyle", R.drawable.user_two),
        Person(1, "Tommy", R.drawable.user_three),
    )
}