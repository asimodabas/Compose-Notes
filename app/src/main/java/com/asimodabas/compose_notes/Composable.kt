package com.asimodabas.compose_notes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun toScreen() {

    var myString = remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomText(text = "Android")
            Spacer(modifier = Modifier.padding(5.dp))
            CustomTextField(string = myString.value) {
                myString.value = it
            }
        }
    }
}


@Composable
fun CustomText(text: String) {
    Text(
        modifier = Modifier
            .clickable {
                println("Clicked")
            }
            // .background(color = Color.Black)
            .padding(5.dp),
        text = text,
        color = Color.Red,
        fontSize = 25.sp,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center
    )
}

@Composable
fun CustomTextField(string: String, function: (String) -> Unit) {
    TextField(value = string, onValueChange = function, modifier = Modifier.padding(5.dp))
}
/*
    //Row
    Row {
        Text(
            text = "Text 1",
            color = Color.Black,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold)
        Text(
            text = "Text 2",
            color = Color.Gray,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium)
    }

    //Box
    Box() {
        Text(
            text = "Text 1",
            color = Color.Black,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold)
        Text(
            text = "Text 2",
            color = Color.Gray,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium)
    }
*/