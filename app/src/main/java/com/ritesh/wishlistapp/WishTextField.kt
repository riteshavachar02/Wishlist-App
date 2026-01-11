package com.ritesh.wishlistapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun WishTextField(
    value: String,
    label: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = colorResource(id = R.color.white),
            focusedBorderColor = colorResource(id = R.color.teal_200),
            unfocusedBorderColor = colorResource(id = R.color.white),
            errorBorderColor = colorResource(id = R.color.red),
            focusedLabelColor = colorResource(id = R.color.teal_700),
            unfocusedLabelColor = colorResource(id = R.color.white),
            errorLabelColor = colorResource(id = R.color.red),
            cursorColor = colorResource(id = R.color.teal_700),
            errorCursorColor = colorResource(id = R.color.red)
        )
    )
}