package com.example.haroun_dominique_ex3tadultos.ui.ej01.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.haroun_dominique_ex3tadultos.ui.ej01.state.Ej01ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ej01(){
    val vm: Ej01ViewModel = viewModel()

    Scaffold(
        topBar =  {
            TopAppBar(title = { Text("Contadores") }, actions = {
                IconButton(
                    onClick = {
                        vm.resetNumCounter()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Actualizar"
                    )
                }
            })
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally){
            if(vm.counterList.size==0){
                Text(text="Introduce el número de contadores")
                TextField(
                    value = vm.firstScreenTextFieldValue,
                    onValueChange = {vm.setFirstScreenTextFieldValue(it)})
                Button(onClick =  {vm.counterListInit(vm.firstScreenTextFieldValue.toIntOrNull()?:0)}) {
                    Text(text="Mostrar")
                }
            }else{
                repeat(vm.counterList.size){
                    Counter(
                        firstButtonAction = { vm.decreaseCounter(it) },
                        secondButtonAction = {vm.increaseCounter(it)},
                        number = vm.counterList[it]) //number está mostrando la variable correcta, ya que si inicializo la lista a 3 en lugar de 0, se muestra correctamente
                }
            }
        }
    }
}