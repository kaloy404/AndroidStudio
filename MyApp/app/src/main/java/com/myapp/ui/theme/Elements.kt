package com.myapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppTitle(text: String) {
    Text(
        text = text,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 20.dp)
    )
}

@Composable
fun AppTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .padding(bottom = 20.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
    )
}

@Composable
fun AppButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF6200EA),
            contentColor = Color.White
        )
    ) {
        Text(text)
    }
}

@Composable
fun GridItem(text: String) {
    Text(
        text = text,
        color = Color.White,
        modifier = Modifier
            .padding(4.dp)
            .background(Color(0xFF6200EA), RoundedCornerShape(6.dp))
            .padding(16.dp)
    )
}
