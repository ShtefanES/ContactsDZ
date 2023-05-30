package com.example.realmdatabase.di

import android.content.Context
import com.example.realmdatabase.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
	AndroidSupportInjectionModule::class,
	ActivityBindingModule::class,
	RealmModule::class,
	ContactsRepositoryModule::class
])
interface AppComponent : AndroidInjector<App> {

	@Component.Builder
	interface Builder {

		@BindsInstance
		fun context(context: Context): Builder

		fun build(): AppComponent
	}
}