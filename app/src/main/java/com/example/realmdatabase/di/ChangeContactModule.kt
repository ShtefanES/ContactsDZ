package com.example.realmdatabase.di

import com.example.realmdatabase.changescren.ChangeContactActivity
import com.example.realmdatabase.changescren.ChangeContactActivity.Companion.ID_CONTACT
import com.example.realmdatabase.domain.entity.ContactModel
import dagger.Module
import dagger.Provides

@Module
interface ChangeContactModule {

	companion object {

		@ActivityScope
		@Provides
		fun provideContact(activity: ChangeContactActivity): ContactModel =
			activity.intent.getSerializableExtra(ID_CONTACT) as ContactModel
	}
}