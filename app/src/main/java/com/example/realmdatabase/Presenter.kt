package com.example.realmdatabase

import com.example.realmdatabase.presenter.MainAction

class Presenter(private val contactRepository: ContactRepository) {

    private var mainAction: MainAction? = null


    fun initAction(mainAction: MainAction) {
        this.mainAction = mainAction
    }

    fun addContact(name: String, surname: String, number: String) {
        contactRepository.addContact(name, surname, number)
        mainAction?.onAddContact(contactRepository.getContact())
    }

    fun changeContact(id: String?, name: String?, surname: String?, number: String?) {
        contactRepository.changeContact(
            idContact = id,
            name = name,
            surname = surname,
            number = number
        )
    }
}