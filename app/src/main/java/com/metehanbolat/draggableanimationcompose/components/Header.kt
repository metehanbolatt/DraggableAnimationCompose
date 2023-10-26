package com.metehanbolat.draggableanimationcompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.metehanbolat.draggableanimationcompose.R

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(6f)
        ) {
            Text(text = "MSI Raider GE65HX", fontSize = 32.sp, fontWeight = FontWeight.ExtraBold)
            Text(text = "Gaming Laptop", color = Color.Gray, fontWeight = FontWeight.Normal)
        }

        Image(
            modifier = Modifier.weight(1f),
            painter = painterResource(id = R.drawable.msi_logo),
            contentDescription = "MSI Logo"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    Header()
}