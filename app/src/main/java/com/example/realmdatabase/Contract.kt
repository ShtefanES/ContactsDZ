package com.example.realmdatabase

sealed class UiEvent(): Event {
    object OnButtonClickedAddContact : UiEvent()
}
class OnButtonClickedChangeContact(var index: Int) : UiEvent()