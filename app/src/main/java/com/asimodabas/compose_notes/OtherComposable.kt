package com.asimodabas.compose_notes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun otherScreen() {

    //Column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.imagee),
            contentDescription = null
        )
        Spacer(modifier = Modifier.padding(5.dp))
        var string = remember {
            mutableStateOf("Add Text")
        }
        TextField(
            modifier = Modifier
                .background(color = Color.White)
                .padding(5.dp),
            value = string.value,
            onValueChange = {
                string.value = it
                //println(string)
            })
        Spacer(modifier = Modifier.padding(5.dp))
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            modifier = Modifier
                .background(color = Color.Red)
                .padding(5.dp),
            text = "Text",
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(5.dp))
        CustomText(text = "Custom Text")
        Spacer(modifier = Modifier.padding(5.dp))
        Row {
            Text(
                modifier = Modifier
                    .background(Color.Red)
                    .padding(5.dp),
                text = "Text 1",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(5.dp))
            CustomText(text = "Text 2")
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                modifier = Modifier
                    .background(Color.Red)
                    .padding(5.dp),
                text = "Text 3",
                color = Color.Gray,
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = {
            println("Clicked Button")
        }) {
            Text(text = "Button")
        }
        Spacer(modifier = Modifier.padding(5.dp))

    }
}