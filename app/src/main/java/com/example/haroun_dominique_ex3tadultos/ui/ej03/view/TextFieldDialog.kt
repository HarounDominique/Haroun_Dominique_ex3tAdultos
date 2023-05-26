package com.example.haroun_dominique_ex3tadultos.ui.ej03.view

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import com.example.haroun_dominique_ex3tadultos.R

@Composable
fun TextFieldDialog(
    // https://www.youtube.com/watch?v=2rCyXaYkTp0
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit,
    modifier: Modifier = Modifier,
    confirmString: String = stringResource(R.string.confirm),
    dismissString: String = stringResource(R.string.cancel),
    titleString: String = stringResource(R.string.add_product),
) {
    var text by remember { mutableStateOf("") }

    val focusRequester = FocusRequester() // (1)
    val focusManager = LocalFocusManager.current

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                if (text.isNotBlank()) onConfirm(text)
                onDismiss()
            }) {
                Text(text = confirmString)
            }
        },
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = dismissString)
            }
        },
        title = { Text(text = titleString) },
        text = {
            TextField(
                value = text,
                onValueChange = { text = it },
                Modifier.focusRequester(focusRequester),
                /*                keyboardActions = KeyboardActions(onNext = {
                                    focusManager.moveFocus(
                                        FocusDirection.Next
                                    )
                                }),*/  // (3)
                singleLine = true,
            )  // (1)
            LocalView.current.viewTreeObserver.addOnWindowFocusChangeListener {// (2)
                if (it) focusRequester.requestFocus()
            }
        },
    )

}