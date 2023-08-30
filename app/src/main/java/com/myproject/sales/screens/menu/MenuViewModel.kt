package com.myproject.sales.screens.menu

import androidx.lifecycle.viewModelScope
import com.myproject.data.PersonalInfoData
import com.myproject.data.screens.PersonalInfoRepository
import com.myproject.sales.MainViewModel
import com.myproject.sales.data.MenuList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val personalInfoRepository: PersonalInfoRepository,
) : MainViewModel() {

    private val _userInfo = MutableStateFlow(PersonalInfoData())
    val userInfo = _userInfo.asStateFlow()
    private val _menuList = MutableStateFlow(listOf(MenuList()))
    val menuList = _menuList.asStateFlow()
    private val _wasSaveButtonClicked = MutableSharedFlow<Unit>()
    val wasSaveButtonClicked = _wasSaveButtonClicked.asSharedFlow()
    private val _navigateToProfileScreen = MutableSharedFlow<Unit>()
    val navigateToProfileScreen = _navigateToProfileScreen.asSharedFlow()

    fun getUserInfo() {
        viewModelScope.launch {
            personalInfoRepository.getUserInf().observeResource(
                onSuccess = { data -> data.let { _userInfo.value = it } },
                onError = { error -> Timber.d("What is error: $error") },
            )
        }
    }

    fun updateUserInfo(name: String) {
        viewModelScope.launch {
            personalInfoRepository.updateUserInfo(name).observeResource(
                onSuccess = { Timber.d("Success") },
                onError = { error -> Timber.d("Error: $error") },
            )
        }
    }

    fun onSaveButtonClicked() {
        viewModelScope.launch {
            _wasSaveButtonClicked.emit(Unit)
        }
    }

    fun onNavigationToProfileClicked() {
        viewModelScope.launch {
            _navigateToProfileScreen.emit(Unit)
        }
    }

    fun getMenuList() {
        viewModelScope.launch {
            _menuList.value = listOf(
                MenuList(0, "Settings"),
                MenuList(1, "About app"),
                MenuList(2, "Connect me"),
            )
        }
    }
}
