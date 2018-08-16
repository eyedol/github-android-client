package com.addhen.github.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.addhen.github.base.BaseViewModelFactory
import com.addhen.github.login.LoginViewModel
import com.addhen.github.user.UserViewModel
import com.addhen.github.users.UsersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    internal abstract fun bindUsersActivityViewModel(usersViewModel: UsersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    internal abstract fun bindUserActivityViewModel(userViewModel: UserViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindLoginActivityViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    internal abstract fun bindAppViewModelFactory(
        factory: BaseViewModelFactory
    ): ViewModelProvider.Factory
}
