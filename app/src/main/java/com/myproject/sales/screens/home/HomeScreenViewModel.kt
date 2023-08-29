package com.myproject.sales.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myproject.data.User
import com.myproject.data.resource.Resource
import com.myproject.data.screens.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
) : ViewModel() {
    private val _users = MutableStateFlow(User())
    val user = _users.asStateFlow()

    fun getData() {
        viewModelScope.launch {
            homeRepository.getInfo()
                .onEach { resource ->
                    when (resource) {
                        is Resource.Success -> resource.data?.let { _users.value = it }
                        is Resource.Error -> Timber.d("What is error: ${resource.error}")
                    }
                }.launchIn(viewModelScope)
        }
    }
}
