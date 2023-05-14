package com.example.realmdatabase

import com.example.realmdatabase.presenter.Action

class Presenter(private val contactRepository: ContactRepository) {

    private var action: Action? = null

    fun initAction(action: Action) {
        this.action = action
    }

    fun addContact(name: String, surname: String, number: String) {
        contactRepository.addContact(name, surname, number)
        action?.showMessage()
    }

    fun changeContact(id: String?, name: String?, surname: String?, number: String?) {
        contactRepository.changeContact(
            idContact = id,
            name = name,
            surname = surname,
            number = number
        )
        action?.showMessage()
    }
}