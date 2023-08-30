package com.myproject.sales.screens.menu.aboutapp

import androidx.lifecycle.viewModelScope
import com.myproject.data.AboutApp
import com.myproject.data.screens.AboutAppRepository
import com.myproject.sales.MainViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AboutAppViewModel @Inject constructor(
    private val aboutAppRepository: AboutAppRepository,
) : MainViewModel() {

    private val _aboutAppText = MutableStateFlow(AboutApp())
    val aboutAppText = _aboutAppText.asStateFlow()

    fun getData() {
        viewModelScope.launch {
            aboutAppRepository.getAboutAppText().observeResource(
                onSuccess = { data -> _aboutAppText.value = data },
                onError = { error -> Timber.d("What is error: $error") },
            )
        }
    }
}
