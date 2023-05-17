package com.example.realmdatabase.di

import com.example.realmdatabase.changescren.ChangeContactPresenter
import com.example.realmdatabase.data.ContactRepository
import com.example.realmdatabase.data.ContactRepositoryImpl
import com.example.realmdatabase.mainscreen.MainViewModel
import com.example.realmdatabase.addscreen.AddContactPresenter
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<Realm> {
        Realm.init(androidApplication())

        val configuration = RealmConfiguration.Builder()
            .name("todo.db")
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(0)
            .allowWritesOnUiThread(true)
            .allowQueriesOnUiThread(true)
            .build()

        Realm.setDefaultConfiguration(configuration)

        Realm.getDefaultInstance()
    }

    single<ContactRepository> {
        ContactRepositoryImpl(realm = get())
    }

    viewModel {
        MainViewModel(contactRepository = get())
    }

    single<AddContactPresenter> {
        AddContactPresenter(contactRepository = get())
    }

    single<ChangeContactPresenter> { params ->
        ChangeContactPresenter(contactRepository = get(), contact = params[0])
    }


}