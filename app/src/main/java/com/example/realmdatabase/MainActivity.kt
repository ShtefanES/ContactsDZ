package com.example.realmdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import com.example.realmdatabase.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), LifecycleObserver {

    private lateinit var binding: ActivityMainBinding

    private val defaultLifecycleObserver = object : DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            super.onCreate(owner)
            Log.d("Main", "DefaultLifecycleObserver - onCreate")
        }

        override fun onStart(owner: LifecycleOwner) {
            super.onStart(owner)
            Log.d("Main", "DefaultLifecycleObserver - onStart")
        }

        override fun onResume(owner: LifecycleOwner) {
            super.onResume(owner)
            Log.d("Main", "DefaultLifecycleObserver - onResume")
        }
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(defaultLifecycleObserver)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ContactsAdapter { index ->
            viewModel.onButtonClickedChangeContact(index)
        }

        viewModel.allContacts.observe(this) {
            adapter.setData(it)
        }
        viewModel.goChangeContactScreenEvent.observe(this, ::startChangeContactActivity)

        binding.rvContacts.adapter = adapter

        binding.fabAddContact.setOnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
           // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }

    private fun startChangeContactActivity(contact: Contact) {
        startActivity(
            ChangeContactActivity.createIntent(
                this,
                id = contact.id,
                name = contact.name,
                surname = contact.surname,
                number = contact.number
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(defaultLifecycleObserver)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


}