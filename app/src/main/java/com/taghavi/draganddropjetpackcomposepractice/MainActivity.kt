package com.taghavi.draganddropjetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.taghavi.draganddropjetpackcomposepractice.components.FoodItemCard
import com.taghavi.draganddropjetpackcomposepractice.components.PersonCard
import com.taghavi.draganddropjetpackcomposepractice.models.FoodItem.Companion.foodList
import com.taghavi.draganddropjetpackcomposepractice.models.Person.Companion.persons
import com.taghavi.draganddropjetpackcomposepractice.ui.theme.DragAndDropJetpackComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DragAndDropJetpackComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LongPressDraggable(modifier = Modifier.fillMaxSize()) {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(horizontal = 10.dp)
                        ) {
                            items(items = foodList) { food ->
                                FoodItemCard(foodItem = food)
                            }
                        }
                        PersonListContainer()
                    }
                }
            }
        }
    }
}

@Composable
fun BoxScope.PersonListContainer() {
    LazyRow(
        modifier = Modifier
            .fillMaxHeight(0.3f)
            .fillMaxWidth()
            .background(
                Color.LightGray,
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)
            )
            .padding(vertical = 10.dp)
            .align(Alignment.BottomCenter),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        items(items = persons) { person ->
            PersonCard(person)
        }
    }
}