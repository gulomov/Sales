package com.myproject.sales.screens.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myproject.sales.data.MenuList
import com.myproject.sales.data.PersonalInfoData
import com.myproject.sales.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val personalInfoRepository: PersonalInfoRepository,
) : ViewModel() {
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
            personalInfoRepository.getUserInf().onEach { resource ->
                when (resource) {
                    is Resource.Success -> resource.data?.let { _userInfo.value = it }
                    is Resource.Error -> Timber.d("What is error: ${resource.error}")
                }
            }.launchIn(viewModelScope)
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
                MenuList("Settings"),
                MenuList("About app"),
                MenuList("Connect me"),
            )
        }
    }
}
