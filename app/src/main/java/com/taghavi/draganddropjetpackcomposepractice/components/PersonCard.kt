package com.taghavi.draganddropjetpackcomposepractice.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taghavi.draganddropjetpackcomposepractice.DropTarget
import com.taghavi.draganddropjetpackcomposepractice.models.FoodItem
import com.taghavi.draganddropjetpackcomposepractice.models.Person

@Composable
fun PersonCard(person: Person) {
    val foodItems = remember {
        mutableStateMapOf<Int, FoodItem>()
    }

    DropTarget<FoodItem>(
        modifier = Modifier
            .padding(6.dp)
            .width(width = 120.dp)
            .fillMaxHeight(0.8f)
    ) { isInBound, foodItem ->
        val bgColor = if (isInBound) Color.Red else Color.White

        foodItem?.let {
            if (isInBound) {
                foodItems[foodItem.id] = foodItem
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
                .background(
                    bgColor,
                    RoundedCornerShape(16.dp)
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = person.profile), contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = person.name,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            if (foodItems.isNotEmpty()) {
                Text(
                    text = "$${foodItems.values.sumOf { it.price }}",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "${foodItems.size} Items",
                    fontSize = 14.sp,
                    color = Color.Black,
                )
            }
        }
    }
}