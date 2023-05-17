package com.example.realmdatabase.changescren

import com.example.realmdatabase.data.ContactRepository
import com.example.realmdatabase.data.model.Contact

class ChangeContactPresenter(
    private val contactRepository: ContactRepository,
    private val contact: Contact
) {

    private var changeContactView: ChangeContactView? = null

    fun initAction(changeContactView: ChangeContactView) {
        this.changeContactView = changeContactView
        changeContactView.prefillContact(contact)
    }

    fun onChangeContactClicked(name: String, surname: String, number: String) {
        if (contact.name != name || contact.surname != surname || contact.number != number) {
            contact.name = name
            contact.number = number
            contact.surname = surname
            contactRepository.changeContact(contact = contact)
            changeContactView?.showChangeContactSuccessInfo()
        }
    }
}