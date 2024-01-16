package com.example.navigationanimation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SecondScreen(
    onClick: () -> Unit
) {
    Column {
        Text(text = "Second Screen")
        Button(
            onClick = onClick
        ) {
            Text(text = "To First Screen")
        }
    }
}