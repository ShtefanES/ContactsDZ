package com.example.realmdatabase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.realmdatabase.databinding.ActivityAddContactBinding
import com.example.realmdatabase.presenter.Action
import org.koin.android.ext.android.inject

class AddContactActivity : AppCompatActivity(), Action {

    private lateinit var binding: ActivityAddContactBinding

    private val presenter: Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.initAction(this)

       binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            with(binding) {
                presenter.addContact(
                    name = etName.text.toString(),
                    surname = etSurname.text.toString(),
                    number = etNumber.text.toString()
                )
            }
        }
    }

    override fun showMessage() {
        Toast.makeText(this, "контакт добавлен", Toast.LENGTH_SHORT).show()
    }
}