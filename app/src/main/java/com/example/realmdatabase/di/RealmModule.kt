package com.example.realmdatabase.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
interface RealmModule {

	companion object {

	private const val REALM_NAME = "todo.db"

		@Singleton
		@Provides
		fun provideRealm(context: Context): Realm {
		Realm.init(context)
		val configuration = RealmConfiguration.Builder()
			.name(REALM_NAME)
			.deleteRealmIfMigrationNeeded()
			.schemaVersion(0)
			.allowWritesOnUiThread(true)
			.allowQueriesOnUiThread(true)
			.build()
		Realm.setDefaultConfiguration(configuration)

		return Realm.getDefaultInstance()
	}
}
}