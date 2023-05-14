package com.example.realmdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realmdatabase.presenter.MainAction
import org.koin.android.ext.android.inject
import android.content.Context
import android.content.Intent
import com.example.realmdatabase.databinding.ActivityChangeContactBinding

class ChangeContactActivity : AppCompatActivity(), MainAction {
    private val presenter: Presenter by inject()
    private lateinit var binding: ActivityChangeContactBinding

    companion object {
        private const val ID_KEY = "ID_KEY"
        private const val NAME_KEY = "NAME_KEY"
        private const val SURNAME_KEY = "SURNAME_KEY"
        private const val NUMBER_KEY = "NUMBER_KEY"
        fun createIntent(context: Context, id: String?, name:String?, surname:String?, number:String?):
                Intent = Intent(context, ChangeContactActivity::class.java).apply {
                putExtra(ID_KEY, id)
                putExtra(NAME_KEY,name)
                putExtra(SURNAME_KEY,surname)
                putExtra(NUMBER_KEY,number)
            }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.initAction(this)

        binding = ActivityChangeContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            changeEtName.setText(intent.getStringExtra(NAME_KEY))
            changeEtSurname.setText(intent.getStringExtra(SURNAME_KEY))
            changeEtNumber.setText(intent.getStringExtra(NUMBER_KEY))
        }
        val id = intent.getStringExtra(ID_KEY)
        if (id != null) {
            presenter.changeContact(id)
        }
    }

    override fun onAddContact(contacts: List<Contact>) {

    }
}