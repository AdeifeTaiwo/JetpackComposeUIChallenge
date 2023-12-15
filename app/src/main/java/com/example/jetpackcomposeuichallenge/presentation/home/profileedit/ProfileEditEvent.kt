package com.example.jetpackcomposeuichallenge.presentation.home.profileedit

sealed class ProfileEditEvent {
    data class EditFirstName(val firstName: String) : ProfileEditEvent()

    data class EditLastName(val lastName: String): ProfileEditEvent()

    data class EditEmail(val email: String): ProfileEditEvent()
    data class EditMobileNumber(val mobileNumber: String): ProfileEditEvent()
}
