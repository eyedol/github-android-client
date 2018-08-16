package com.addhen.github.users

import com.addhen.github.AppNavigation
import com.nhaarman.mockito_kotlin.mock
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mock

class UsersViewModelTest {

    @Mock
    private val repository: UsersRepository = mock()

    @Mock
    private val appNavigation: AppNavigation = mock()

    private lateinit var viewModel: UsersViewModel

    @Test
    @Ignore
    fun users_Empty() {
        TODO()
    }

    @Test
    @Ignore
    fun users_All() {
        TODO()
    }
}
