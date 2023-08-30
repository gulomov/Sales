package com.myproject.sales

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myproject.data.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class MainViewModel : ViewModel() {

    inline fun <T> Flow<Resource<T>>.observeResource(
        crossinline onSuccess: (T) -> Unit,
        crossinline onError: (Throwable) -> Unit,
    ) {
        this.onEach { resource ->
            when (resource) {
                is Resource.Success -> resource.data?.let { onSuccess(it) }
                is Resource.Error -> resource.error?.let { onError(it) }
            }
        }.launchIn(viewModelScope)
    }
}
