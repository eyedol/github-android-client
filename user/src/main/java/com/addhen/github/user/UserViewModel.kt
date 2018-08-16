package com.addhen.github.user

import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.addhen.github.Result
import com.addhen.github.RxSchedulers
import com.addhen.github.base.BaseViewModel
import com.addhen.github.user.model.User
import com.addhen.github.user.UserRepository
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val repository: UserRepository,
    private val schedulers: RxSchedulers
) : BaseViewModel(), LifecycleObserver {

    val userLiveData = MutableLiveData<Result<User>>()
    val user: ObservableField<User> = ObservableField(
        User(0, "", "", "", "", "", "")
    )
    var username: String = ""

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        loadUser()
    }

    private fun loadUser() {
        asyncWithParent(schedulers.main()) {
            userLiveData.value = Result.loading()
            try {
                val user = repository.user(username)
                userLiveData.value = Result.success(user)
            } catch (httpException: HttpException) {
                Timber.e(httpException)
            } catch (e: Exception) {
                userLiveData.value = Result.error(e.localizedMessage, null)
                Timber.e(e)
            }
        }
    }
}
