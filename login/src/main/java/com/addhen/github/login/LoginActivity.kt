package com.addhen.github.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.addhen.github.AppNavigation
import com.addhen.github.Result
import com.addhen.github.base.BaseActivity
import com.addhen.github.login.databinding.ActivityLoginBinding
import javax.inject.Inject

class LoginActivity : BaseActivity(0) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var appNavigation: AppNavigation

    private lateinit var binding: ActivityLoginBinding

    private val viewModel by lazy {
        ViewModelProviders.of(this@LoginActivity, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@LoginActivity, R.layout.activity_login)
        binding.viewModel = viewModel
        initView()
    }

    private fun initView() {
        viewModel.loginLiveData.observe(this, Observer {
            when (it?.status) {
                Result.Status.SUCCESS -> {
                    appNavigation.navigateToUsers()
                    finish()
                }

                else -> {
                    if (it.data?.username.isNullOrEmpty()) {
                        binding.usernameLayout.error = it.message
                    } else {
                        binding.passwordLayout.error = it.message
                    }
                }
            }
        })
    }
}
