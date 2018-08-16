package com.addhen.github.user

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.addhen.github.AppNavigation
import com.addhen.github.Result
import com.addhen.github.base.BaseActivity
import com.addhen.github.user.databinding.ActivityUserBinding
import javax.inject.Inject

class UserActivity : BaseActivity(0) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityUserBinding

    private val viewModel by lazy {
        ViewModelProviders.of(this@UserActivity, viewModelFactory).get(UserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@UserActivity, R.layout.activity_user)
        binding.toolbar.title = getString(R.string.user)
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar ?: return
        actionBar.setHomeButtonEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        binding.viewModel = viewModel
        binding.viewModel!!.username = intent.getStringExtra(AppNavigation.EXTRA_USER_NAME)
        initView()
    }

    private fun initView() {
        viewModel.userLiveData.observe(this, Observer {
            when (it?.status) {
                Result.Status.SUCCESS -> {
                    val user = viewModel.userLiveData.value?.data ?: return@Observer
                    binding.viewModel!!.user.set(user)
                    binding.loading.visibility = View.GONE
                }
                Result.Status.LOADING -> {
                    binding.emptyViewHeader.visibility = View.GONE
                    binding.loading.visibility = View.VISIBLE
                }
                else -> {
                    binding.loading.visibility = View.GONE
                }
            }
        })
        lifecycle.addObserver(viewModel)
    }
}
