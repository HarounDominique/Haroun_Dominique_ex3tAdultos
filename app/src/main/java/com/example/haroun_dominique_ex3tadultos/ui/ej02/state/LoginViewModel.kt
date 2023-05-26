package com.example.haroun_dominique_ex3tadultos.ui.ej02.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){
    //las siguientes líneas modifican los getters (implícitos por defecto en kotlin) para que retornen no el valor de _variable, que es
    //privada y está protegida, sino el valor de una 'variable intermedia'; de esta manera protegemos la variable original para que sólo
    //pueda ser modificada mediante el viewModel:
    private var _userName by mutableStateOf("")
    val userName get() = _userName

    private var _userPassword by mutableStateOf("")
    val userPassword get() = _userPassword

    private var _loginScreen by mutableStateOf(true)
    val loginScreen get() = _loginScreen

    fun changeUserName(newName: String) {
        _userName = newName
    }

    fun changeUserPassword(newPassword: String) {
        _userPassword = newPassword
    }

    fun changeScreen(newScreen: Boolean) {
        _loginScreen = newScreen
    }
}