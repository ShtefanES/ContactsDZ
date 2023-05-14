package com.example.realmdatabase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val contactRepository: ContactRepository) : ViewModel() {
    private val _goChangeContactScreenEvent = SingleLiveEvent<Contact>()
    val goChangeContactScreenEvent: LiveData<Contact> = _goChangeContactScreenEvent
     val allContacts: ContactLiveData
     get() = getAllContacts() as ContactLiveData


    private fun getAllContacts(): MutableLiveData<List<Contact>> {
        val list = ContactLiveData()
        val allContacts = contactRepository.getContact()
        list.value = allContacts.subList(0, allContacts.size)
        return list
    }

    fun onButtonClickedChangeContact(index:Int){
        _goChangeContactScreenEvent.value = allContacts.value?.get(index)
    }


    override fun onCleared() {
        super.onCleared()
        Log.d("MainViewModel", "MainViewModel -> onCleared")
    }
}