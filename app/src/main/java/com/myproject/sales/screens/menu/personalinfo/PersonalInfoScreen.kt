package com.myproject.sales.screens.menu.personalinfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.myproject.sales.screens.menu.MenuViewModel
import com.myproject.sales.ui.theme.CancelRed
import com.myproject.sales.ui.theme.SaveGreen

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: MenuViewModel = hiltViewModel(),
) {
    val mutableUser by viewModel.userInfo.collectAsState()
    var newUserName by rememberSaveable { mutableStateOf("") }
    var newName by rememberSaveable { mutableStateOf("") }
    var newEmail by rememberSaveable { mutableStateOf("") }
    var newPhone by rememberSaveable { mutableStateOf("") }
    var newPoints by rememberSaveable { mutableStateOf("") }
    var isEditingEnabled by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.getUserInfo()
    }

    LaunchedEffect(Unit) {
        viewModel.wasSaveButtonClicked.collect {
            navController.popBackStack()
        }
    }

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        MyOutlinedTextField(
            mutableUser.userName.orEmpty(),
            "User name",
            isEditingEnabled,
            onValueChanged = { newValue ->
                newUserName = newValue
            },
        )
        MyOutlinedTextField(
            mutableUser.name.orEmpty(),
            "Name",
            isEditingEnabled,
            onValueChanged = { newValue ->
                newName = newValue
            },
        )
        MyOutlinedTextField(
            mutableUser.email.orEmpty(),
            "Email",
            isEditingEnabled,
            onValueChanged = { newValue ->
                newEmail = newValue
            },
        )
        MyOutlinedTextField(
            mutableUser.phone.orEmpty(),
            "Phone",
            isEditingEnabled,
            onValueChanged = { newValue ->
                newPhone = newValue
            },
        )
        MyOutlinedTextField(
            mutableUser.points.toString(),
            "Points",
            isEditingEnabled,
            onValueChanged = { newValue ->
                newPoints = newValue
            },
        )
        if (isEditingEnabled) {
            Button(
                onClick = {
                    isEditingEnabled = !isEditingEnabled
                    viewModel.onSaveButtonClicked()
                    viewModel.updateUserInfo(newUserName)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isEditingEnabled) {
                        SaveGreen
                    } else {
                        MaterialTheme.colors.primary
                    },
                    contentColor = Color.White,
                ),
            ) {
                Text(text = "Save")
            }

            Button(
                onClick = { isEditingEnabled = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    CancelRed,
                    Color.White,
                ),
            ) {
                Text(text = "Cancel")
            }
        } else {
            Button(
                onClick = {
                    isEditingEnabled = !isEditingEnabled
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isEditingEnabled) {
                        SaveGreen
                    } else {
                        MaterialTheme.colors.primary
                    },
                    contentColor = Color.White,
                ),
            ) {
                Text(text = "Edit?")
            }
        }
    }
}

@Composable
fun MyOutlinedTextField(
    textValue: String,
    labelText: String,
    isEnabled: Boolean,
    onValueChanged: ((String) -> Unit)? = null,
) {
    OutlinedTextField(
        value = textValue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onValueChange = { newValue ->
            if (isEnabled) {
                onValueChanged?.let { it(newValue) }
            }
        },
        enabled = isEnabled,
        label = { Text(text = labelText, style = MaterialTheme.typography.h1) },
    )
}
