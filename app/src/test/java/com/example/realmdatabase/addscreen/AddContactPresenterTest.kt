package com.example.realmdatabase.addscreen

import com.example.realmdatabase.data.ContactRepository
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class AddContactPresenterTest {

	private val repository: ContactRepository = mock()
	private val presenter = AddContactPresenter(repository)

	@Test
	fun `add contact EXPECT repository add contact`() {
		val name = "Vano"
		val surname = "No"
		val number = "12345"

		presenter.addContact(name = name, surname = surname, number = number)

		verify(repository).addContact(name = name, surname = surname, number = number)
	}

	@Test
	fun `add contact EXPECT show add contact success info`() {
		val view: AddContactView = mock()
		presenter.initView(view)

		presenter.addContact(name = "", surname = "", number = "")

		verify(view).showAddContactSuccessInfo()
	}
}