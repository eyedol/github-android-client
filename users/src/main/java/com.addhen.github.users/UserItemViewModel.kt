package com.addhen.github.users

import androidx.lifecycle.ViewModel
import com.addhen.github.AppNavigation
import com.addhen.github.user.model.User

class UserItemViewModel(val user: User, val appNavigation: AppNavigation) : ViewModel() {

    fun onUserClick() {
        appNavigation.navigateToUser(user.username)
    }
}
