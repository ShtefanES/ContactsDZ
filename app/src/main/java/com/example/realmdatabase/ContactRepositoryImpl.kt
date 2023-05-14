package com.example.realmdatabase

import io.realm.Realm
import java.util.*

class ContactRepositoryImpl(
    private val realm: Realm
) : ContactRepository {
    override fun addContact(name: String, surname: String, number: String) {
        realm.executeTransaction {
            it.createObject(Contact::class.java, UUID.randomUUID().toString()).apply {
                this.name = name
                this.surname = surname
                this.number = number
            }
        }
    }

    override fun getContact(): List<Contact> {
        return realm.where(Contact::class.java).findAll()
    }

    override fun changeContact(
        contact:Contact
    ) {
        realm.executeTransaction {
            val contactFromDatabase: Contact? =
                it.where(Contact::class.java).equalTo("id", contact.id).findFirst()

            contactFromDatabase?.name = contact.name
            contactFromDatabase?.surname = contact.surname
            contactFromDatabase?.number = contact.number
        }
    }

}