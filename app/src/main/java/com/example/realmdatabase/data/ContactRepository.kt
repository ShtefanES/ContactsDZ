package com.example.realmdatabase.data

import androidx.lifecycle.LiveData
import com.example.realmdatabase.domain.entity.ContactModel

interface ContactRepository {

    fun addContact(name: String, surname: String, number: String)

    fun getContactsLiveData(): LiveData<List<ContactModel>>

   fun changeContact(contact: ContactModel)
}