package com.example.haroun_dominique_ex3tadultos.ui.ej01.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class Ej01ViewModel(): ViewModel() {
    //ESTADO
    private var _counterList = mutableStateListOf<Int>()
    val counterList get() = _counterList


    private var _firstScreenTextFieldValue by mutableStateOf("")
    val firstScreenTextFieldValue get() = _firstScreenTextFieldValue

    //FUNCIONES
    fun resetNumCounter(){
        _counterList.clear()
        _firstScreenTextFieldValue=""
    }

    fun increaseCounter(index:Int){
        _counterList[index]++
    }

    fun decreaseCounter(index:Int){
        _counterList[index]--
    }

    fun setFirstScreenTextFieldValue(text:String){
        _firstScreenTextFieldValue=text
    }

    fun counterListInit(number:Int){
        repeat(number){
            _counterList.add(0)
        }
    }
}