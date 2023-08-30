package com.myproject.sales.screens.home

import androidx.lifecycle.viewModelScope
import com.myproject.data.User
import com.myproject.data.screens.HomeRepository
import com.myproject.sales.MainViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
) : MainViewModel() {
    private val _users = MutableStateFlow(User())
    val user = _users.asStateFlow()

    fun getData() {
        viewModelScope.launch {
            homeRepository.getInfo().observeResource(
                onSuccess = { data -> data.let { _users.value = it } },
                onError = { error -> Timber.d("What is error: $error") },
            )
        }
    }
}
