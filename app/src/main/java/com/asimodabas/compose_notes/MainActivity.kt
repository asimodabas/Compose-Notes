package com.asimodabas.compose_notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asimodabas.compose_notes.ui.theme.ComposeNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainScreen()
        }
    }

    @Composable
    fun mainScreen() {

        //Column
        Column {
            Text(
                modifier = Modifier
                    .background(color = Color.Red)
                    .padding(5.dp),
                text = "Text 1",
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold)

            CustomText(text = "Custom Text")
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
    }

    @Composable
    fun CustomText(text:String){

        Text(
            modifier = Modifier
                .background(color = Color.Black)
                .padding(5.dp)
                .clickable {
                    println("Clicked")
                },
            text = text,
            color = Color.Red,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium)

    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        mainScreen()
    }
}