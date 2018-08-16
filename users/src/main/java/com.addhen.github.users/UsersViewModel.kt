package com.addhen.github.users

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.addhen.github.AppNavigation
import com.addhen.github.Result
import com.addhen.github.RxSchedulers
import com.addhen.github.base.BaseViewModel
import com.addhen.github.user.model.User
import com.addhen.github.users.UserItemViewModel
import com.addhen.github.users.UsersRepository
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    private val repository: UsersRepository,
    private val schedulers: RxSchedulers,
    private val appNavigation: AppNavigation
) : BaseViewModel(), LifecycleObserver {

    val users = MutableLiveData<Result<List<UserItemViewModel>>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        refreshUsers()
    }

    fun onRefreshUsers() {
        refreshUsers()
    }

    private fun refreshUsers() {
        launchWithParent(schedulers.main()) {
            users.value = Result.loading()
            try {

                val users = repository.users()
                mapUserItemViewModel(users)
            } catch (httpException: HttpException) {
                Timber.e(httpException)
            } catch (e: Exception) {
                users.value = Result.error(e.localizedMessage, null)
                Timber.e(e)
            }
        }
    }

    private fun mapUserItemViewModel(users: List<User>) {

        val scanLogItemViewModels = users.map { user ->
            UserItemViewModel(user, appNavigation)
        }
        this.users.value = Result.success(scanLogItemViewModels)
    }

}
