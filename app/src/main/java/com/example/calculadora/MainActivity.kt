package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

// Esta es la actividad principal de la aplicación
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplicacionCalculadora()
        }
    }
}

// Esta función define la interfaz y la lógica de la calculadora
@Composable
fun AplicacionCalculadora() {
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Número 1") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Número 2") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Este botón ejecuta la operación de suma cuando se presiona
        Button(onClick = {
            val n1 = numero1.toDoubleOrNull() ?: 0.0
            val n2 = numero2.toDoubleOrNull() ?: 0.0
            resultado = (n1 + n2).toString()
        },
            modifier = Modifier.fillMaxWidth()) {
            Text("Sumar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Este texto muestra el resultado de la operación al usuario
        Text("Resultado: $resultado", fontSize = 20.sp)
    }
}

//Previsualización de la interfaz
@Preview(showBackground = true)
@Composable
fun PreviewCalculadora() {
    AplicacionCalculadora()
}

