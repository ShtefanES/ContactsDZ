package com.example.realmdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import com.example.realmdatabase.databinding.ActivityChangeContactBinding
import com.example.realmdatabase.presenter.Action

class ChangeContactActivity : AppCompatActivity(),Action {
    private val presenter: Presenter by inject()
    private lateinit var binding: ActivityChangeContactBinding

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.initAction(this)

        binding = ActivityChangeContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra(ID_KEY)
        val name = intent.getStringExtra(NAME_KEY)
        val surname = intent.getStringExtra(SURNAME_KEY)
        val number = intent.getStringExtra(NUMBER_KEY)

        with(binding) {
            changeEtName.setText(name)
            changeEtSurname.setText(surname)
            changeEtNumber.setText(number)

            btnSaveChange.setOnClickListener {
                presenter.changeContact(
                    id = id,
                    name = changeEtName.text.toString(),
                    surname = changeEtSurname.text.toString(),
                    number = changeEtNumber.text.toString()
                )
            }
        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,MainActivity::class.java))
    }


    override fun showMessage() {
        Toast.makeText(this, "контакт изменён", Toast.LENGTH_SHORT).show()
    }


}