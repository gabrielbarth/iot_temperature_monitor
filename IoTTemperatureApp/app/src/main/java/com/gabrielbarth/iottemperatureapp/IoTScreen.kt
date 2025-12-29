package com.gabrielbarth.iottemperatureapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IoTScreen(
    temperature: String,
    onLedOn: () -> Unit,
    onLedOff: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Temperatura",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "$temperature °C",
            fontSize = 36.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onLedOn,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ligar LED")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onLedOff,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Desligar LED")
        }
    }
}
