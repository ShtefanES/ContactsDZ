package com.example.realmdatabase.changescren

import com.example.realmdatabase.data.model.Contact

interface ChangeContactView {
    fun showChangeContactSuccessInfo()
    fun prefillContact(contact: Contact)
}