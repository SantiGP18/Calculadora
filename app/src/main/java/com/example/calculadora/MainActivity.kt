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
    // Variables de estado para almacenar los números ingresados y el resultado
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Campo de texto para ingresar el primer número
        TextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Número 1") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Campo de texto para ingresar el segundo número
        TextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Número 2") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Fila de botones para realizar las operaciones matemáticas
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            // Botón de suma
            Button(onClick = {
                val n1 = numero1.toDoubleOrNull() ?: 0.0
                val n2 = numero2.toDoubleOrNull() ?: 0.0
                resultado = (n1 + n2).toString()
            }) {
                Text("+")
            }
            //Botón de resta
            Button(onClick = {
                val n1 = numero1.toDoubleOrNull() ?: 0.0
                val n2 = numero2.toDoubleOrNull() ?: 0.0
                resultado = (n1 - n2).toString()
            }) {
                Text("-")
            }
            // Botón de multiplicación
            Button(onClick = {
                val n1 = numero1.toDoubleOrNull() ?: 0.0
                val n2 = numero2.toDoubleOrNull() ?: 0.0
                resultado = (n1 * n2).toString()
            }) {
                Text("×")
            }
            // Botón de división, manejando la división por cero
            Button(onClick = {
                val n1 = numero1.toDoubleOrNull() ?: 0.0
                val n2 = numero2.toDoubleOrNull()
                resultado = if (n2 != null && n2 != 0.0) {
                    (n1 / n2).toString()
                } else {
                    "Error"
                }
            }) {
                Text("÷")
            }
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

