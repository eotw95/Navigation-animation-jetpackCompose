package com.example.navigationanimation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FirstScreen(
    onClick: () -> Unit
) {
    Column {
        repeat(30) {
            Text(text = "First Screen")
        }
        Button(
            onClick = onClick
        ) {
            Text(text = "To Second Screen")
        }
    }

}