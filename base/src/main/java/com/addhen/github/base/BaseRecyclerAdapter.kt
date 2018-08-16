package com.addhen.github.base

import androidx.annotation.UiThread
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber

abstract class BaseRecyclerAdapter<T, V : RecyclerView.ViewHolder> constructor() : RecyclerView.Adapter<V>() {

    private val diffCallback = object : DiffUtil.ItemCallback<T>() {

        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return this@BaseRecyclerAdapter.areItemsTheSame(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return this@BaseRecyclerAdapter.areContentsTheSame(oldItem, newItem)
        }
    }
    private val asyncListDiffer = AsyncListDiffer(this, diffCallback)
    protected abstract fun areItemsTheSame(oldItem: T, newItem: T): Boolean
    protected abstract fun areContentsTheSame(oldItem: T, newItem: T): Boolean

    @UiThread
    fun reset(items: List<T>) {
        asyncListDiffer.submitList(items)
    }

    override fun getItemCount(): Int {
        return asyncListDiffer.currentList.size
    }

    fun getItem(position: Int): T {
        return asyncListDiffer.currentList.elementAt(position)
    }

    private fun onError(it: Throwable) {
        Timber.e(it)
    }
}
