package com.example.realmdatabase.changescren

import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import com.example.realmdatabase.R
import com.example.realmdatabase.databinding.ActivityChangeContactBinding
import com.example.realmdatabase.domain.entity.ContactModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ChangeContactActivity : DaggerAppCompatActivity(), ChangeContactView {

    @Inject
    lateinit var presenter: ChangeContactPresenter

    private val binding by lazy { ActivityChangeContactBinding.inflate(layoutInflater) }

    private val etName: EditText by lazy { binding.changeEtName }
    private val etSurname: EditText by lazy { binding.changeEtSurname }
    private val etNumber: EditText by lazy { binding.changeEtNumber }

    companion object {
        const val ID_CONTACT = "ID_CONTACT"
        fun createIntent(
            context: Context,
            contact: ContactModel
        ):
                Intent =
            Intent(context, ChangeContactActivity::class.java).putExtra(ID_CONTACT, contact)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.initAction(this)
        setContentView(binding.root)

        with(binding) {
            btnSaveChange.setOnClickListener {
                presenter.onChangeContactClicked(
                    name = changeEtName.text.toString(),
                    surname = changeEtSurname.text.toString(),
                    number = changeEtNumber.text.toString()
                )
            }
        }
    }

    override fun prefillContact(contact: ContactModel) {
        etName.setText(contact.name)
        etSurname.setText(contact.surname)
        etNumber.setText(contact.number)
    }

    override fun showChangeContactSuccessInfo() {
        Toast.makeText(this, getString(R.string.change_contact_message), Toast.LENGTH_SHORT).show()
    }
}