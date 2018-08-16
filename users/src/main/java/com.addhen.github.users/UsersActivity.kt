package com.addhen.github.users

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.addhen.github.Result
import com.addhen.github.base.BaseActivity
import com.addhen.github.users.UsersViewModel
import com.addhen.github.users.databinding.ActivityUsersBinding
import javax.inject.Inject

class UsersActivity : BaseActivity(0) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityUsersBinding

    private val viewModel by lazy {
        ViewModelProviders.of(this@UsersActivity, viewModelFactory).get(UsersViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appName = getString(R.string.app_name)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_users)
        binding.title.text = getString(R.string.user_list)
        setSupportActionBar(binding.toolbar)
        binding.viewModel = viewModel

        initView()
    }

    private fun initView() {
        val usersAdapter = UsersAdapter(this@UsersActivity)
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(
                this@UsersActivity,
                resources.getInteger(R.integer.users_columns)
            )
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            adapter = usersAdapter
        }

        viewModel.users.observe(this, Observer {
            when (it?.status) {
                Result.Status.SUCCESS -> {
                    val list = viewModel.users.value?.data ?: return@Observer
                    binding.loading.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
                    usersAdapter.reset(list)
                    // Force scroll to first item as a workaround for items hiding under the toolbar
                    binding.recyclerView.smoothScrollToPosition(0)
                    binding.swipeRefreshLayout.isRefreshing = false
                    binding.loading.visibility = View.GONE
                }
                Result.Status.LOADING -> {
                    binding.emptyViewHeader.visibility = View.GONE
                    binding.loading.visibility = View.VISIBLE
                    binding.swipeRefreshLayout.isRefreshing = false
                }
                else -> {
                    binding.swipeRefreshLayout.isRefreshing = false
                    binding.loading.visibility = View.GONE
                }
            }
        })
        lifecycle.addObserver(viewModel)
    }
}
