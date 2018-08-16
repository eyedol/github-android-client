package com.addhen.github.login

import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.addhen.github.Result
import com.addhen.github.base.BaseViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor() : BaseViewModel() {

    val loginLiveData = MutableLiveData<Result<Login>>()
    val username = ObservableField<String>()
    val password = ObservableField<String>()
    val errorMessages = ObservableArrayMap<String, Int>()

    fun validateFieldsAndSubmitForm() {
        // Don't try this at home. It's a quick way to get login demoed
        val login = Login(username.get().orEmpty(), password.get().orEmpty())
        if (username.get().isNullOrEmpty()) {
            loginLiveData.value = Result.error("Username is empty", login)
            return
        }
        if (password.get().isNullOrEmpty()) {
            loginLiveData.value = Result.error("Password is empty", login)
            return
        }
        loginLiveData.value = Result.success(login)
    }
}
