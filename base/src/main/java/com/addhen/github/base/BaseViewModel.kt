package com.addhen.github.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext

abstract class BaseViewModel : ViewModel() {

    private val job = Job()

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    protected fun launchWithParent(
        context: CoroutineContext = DefaultDispatcher,
        block: suspend CoroutineScope.() -> Unit
    ) = launch(context = context, parent = job, block = block)

    protected fun <T> asyncWithParent(
        context: CoroutineContext = DefaultDispatcher,
        block: suspend CoroutineScope.() -> T
    ) = async(context, parent = job, block = block)
}
