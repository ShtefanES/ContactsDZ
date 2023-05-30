package com.example.realmdatabase.di

import com.example.realmdatabase.data.ContactRepository
import com.example.realmdatabase.data.ContactRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ContactsRepositoryModule {

	@Singleton
	@Binds
	fun bindRepository(repository: ContactRepositoryImpl): ContactRepository
}