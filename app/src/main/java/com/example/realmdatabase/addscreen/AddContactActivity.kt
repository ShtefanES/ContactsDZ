package com.example.realmdatabase.addscreen

import android.os.Bundle
import android.widget.Toast
import com.example.realmdatabase.R
import com.example.realmdatabase.databinding.ActivityAddContactBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AddContactActivity : DaggerAppCompatActivity(), AddContactView {

    private lateinit var binding: ActivityAddContactBinding

    @Inject
    lateinit var addContactPresenter: AddContactPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addContactPresenter.initView(this)

        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            with(binding) {
                addContactPresenter.addContact(
                    name = etName.text.toString(),
                    surname = etSurname.text.toString(),
                    number = etNumber.text.toString()
                )
            }
        }
    }

    override fun showAddContactSuccessInfo() {
        Toast.makeText(this, getString(R.string.add_contact_message), Toast.LENGTH_SHORT).show()
    }
}