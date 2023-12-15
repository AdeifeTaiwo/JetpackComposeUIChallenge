package com.example.jetpackcomposeuichallenge.presentation.home.profileedit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jetpackcomposeuichallenge.presentation.search.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor() : ViewModel() {

    private val _uiState = mutableStateOf(ProfileEditState())
    val uiState: State<ProfileEditState> = _uiState


    fun onEvent(event: ProfileEditEvent) {

        when (event) {
            is ProfileEditEvent.EditFirstName -> {
                _uiState.value = uiState.value.copy(
                    firstName = event.firstName
                )
            }

            is ProfileEditEvent.EditLastName -> {
                _uiState.value = uiState.value.copy(
                    lastName = event.lastName
                )
            }

            is ProfileEditEvent.EditMobileNumber -> {
                _uiState.value = uiState.value.copy(
                    mobileNumber = event.mobileNumber
                )
            }

            is ProfileEditEvent.EditEmail -> {
                _uiState.value = uiState.value.copy(
                    email = event.email
                )
            }
        }
    }
}