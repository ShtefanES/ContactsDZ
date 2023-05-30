package com.example.realmdatabase.di

import com.example.realmdatabase.addscreen.AddContactActivity
import com.example.realmdatabase.mainscreen.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

	@ActivityScope
	@ContributesAndroidInjector
	abstract fun provideMainActivity(): MainActivity

	@ActivityScope
	@ContributesAndroidInjector
	abstract fun provideAddContactActivity(): AddContactActivity
}