package com.example.realmdatabase.addscreen

import com.example.realmdatabase.data.ContactRepository
import javax.inject.Inject

class AddContactPresenter @Inject constructor(private val contactRepository: ContactRepository) {

    private var addContactView: AddContactView? = null

    fun initView(addContactView: AddContactView) {
        this.addContactView = addContactView
    }


    fun addContact(name: String, surname: String, number: String) {
        contactRepository.addContact(name, surname, number)
        addContactView?.showAddContactSuccessInfo()
    }


}