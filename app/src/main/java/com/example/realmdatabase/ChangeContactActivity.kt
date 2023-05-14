package com.example.realmdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.widget.Toast
import com.example.realmdatabase.databinding.ActivityChangeContactBinding
import com.example.realmdatabase.presenter.Action

class ChangeContactActivity : AppCompatActivity(), Action {
    private val presenter: Presenter by inject()

    companion object {
        private const val ID_KEY = "ID_KEY"
        private const val NAME_KEY = "NAME_KEY"
        private const val SURNAME_KEY = "SURNAME_KEY"
        private const val NUMBER_KEY = "NUMBER_KEY"
        fun createIntent(
            context: Context,
            id: String?,
            name: String?,
            surname: String?,
            number: String?
        ):
                Intent = Intent(context, ChangeContactActivity::class.java).apply {
            putExtra(ID_KEY, id)
            putExtra(NAME_KEY, name)
            putExtra(SURNAME_KEY, surname)
            putExtra(NUMBER_KEY, number)

        }
    }

    private var changeableContact: Contact = Contact()
    private val binding by lazy { ActivityChangeContactBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.initAction(this)
        setContentView(binding.root)

        with(changeableContact){
            id = intent.getStringExtra(ID_KEY) ?: ""
            name = intent.getStringExtra(NAME_KEY) ?: ""
            surname = intent.getStringExtra(SURNAME_KEY) ?: ""
            number = intent.getStringExtra(NUMBER_KEY) ?: ""
        }



        with(binding) {
            changeEtName.setText(changeableContact.name)
            changeEtSurname.setText(changeableContact.surname)
            changeEtNumber.setText(changeableContact.number)

            btnSaveChange.setOnClickListener {
                presenter.changeContact()
            }
        }

    }

    fun getChangeableContact(): Contact {
        with(changeableContact){
            name = binding.changeEtName.text.toString()
            surname = binding.changeEtSurname.text.toString()
            number = binding.changeEtNumber.text.toString()
        }
        return changeableContact
    }


    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(
            Intent(
                this,
                MainActivity::class.java
            ).setFlags(FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TOP)
        )
    }


    override fun showMessage() {
        Toast.makeText(this, getString(R.string.change_contact_message), Toast.LENGTH_SHORT).show()
    }


}