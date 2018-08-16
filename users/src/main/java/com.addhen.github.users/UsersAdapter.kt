package com.addhen.github.users

import android.content.Context
import android.view.ViewGroup
import com.addhen.github.base.BaseBindingHolder
import com.addhen.github.base.BaseRecyclerAdapter
import com.addhen.github.users.databinding.ListUserItemBinding

class UsersAdapter(private val context: Context) :
    BaseRecyclerAdapter<UserItemViewModel, BaseBindingHolder<ListUserItemBinding>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseBindingHolder<ListUserItemBinding> {
        return BaseBindingHolder(context, parent, R.layout.list_user_item)
    }

    override fun onBindViewHolder(holder: BaseBindingHolder<ListUserItemBinding>, position: Int) {
        val itemBinding = holder.binding
        itemBinding.viewModel = getItem(position)
        itemBinding.executePendingBindings()
    }

    override fun areItemsTheSame(oldItem: UserItemViewModel, newItem: UserItemViewModel): Boolean {
        return oldItem.user.id == newItem.user.id
    }

    override fun areContentsTheSame(oldItem: UserItemViewModel, newItem: UserItemViewModel): Boolean {
        return oldItem == newItem
    }
}
