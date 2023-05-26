package com.example.haroun_dominique_ex3tadultos.ui.ej02.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.haroun_dominique_ex3tadultos.ui.ej02.state.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ej02(modifier: Modifier = Modifier) {

    val loginViewModel: LoginViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Login Menu") },
                actions = {
                    IconButton(onClick = {
                        loginViewModel.changeScreen(true)
                        loginViewModel.changeUserPassword("")
                        loginViewModel.changeUserName("")
                    }) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Refresh"
                        )
                    }
                }
            )
        },
        content = {

            val loginViewModel : LoginViewModel = viewModel()

            if (!loginViewModel.loginScreen && (loginViewModel.userName == "pepe" && loginViewModel.userPassword == "abc123.")) {
                Column(
                    modifier = Modifier.padding(it),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Sesión iniciada con éxito.")
                }
            } else {
                Column(
                    modifier = modifier.fillMaxSize()
                        .padding(it),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                            .padding(12.dp)) {
                        //Text(text = "Usuario: ")
                        OutlinedTextField(label = { Text("Usuario") },
                            value = loginViewModel.userName,
                            onValueChange = { loginViewModel.changeUserName(it)},
                            isError = (!loginViewModel.loginScreen)
                        )
                    }
                    Row(horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                            .padding(12.dp)) {
                        //Text(text = "Contraseña: ")
                        OutlinedTextField(visualTransformation = PasswordVisualTransformation(),
                            label = { Text("Contraseña") },
                            value = loginViewModel.userPassword,
                            onValueChange = { loginViewModel.changeUserPassword(it) },
                            isError = (!loginViewModel.loginScreen))
                    }
                    Row(horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                            .padding(12.dp)) {
                        Button(onClick = { loginViewModel.changeScreen(false)}) {
                            Text(text = "Iniciar sesión")
                        }
                    }
                }
            }
        }
    )
}