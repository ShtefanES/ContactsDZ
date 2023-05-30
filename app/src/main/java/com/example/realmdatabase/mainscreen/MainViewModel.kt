package com.example.realmdatabase.mainscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.realmdatabase.data.ContactRepository
import com.example.realmdatabase.domain.entity.ContactModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val contactRepository: ContactRepository) : ViewModel() {
    private val _goChangeContactScreenEvent = SingleLiveEvent<ContactModel>()
    val goChangeContactScreenEvent: LiveData<ContactModel> = _goChangeContactScreenEvent
    val allContacts: LiveData<List<ContactModel>>
        get() = contactRepository.getContactsLiveData()

    fun editContact(contact: ContactModel) {
        _goChangeContactScreenEvent.value = contact
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("MainViewModel", "MainViewModel -> onCleared")
    }
}