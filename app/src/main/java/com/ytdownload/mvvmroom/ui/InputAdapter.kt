package com.ytdownload.mvvmroom.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ytdownload.mvvmroom.data.model.InputItem
import com.ytdownload.mvvmroom.databinding.ItemInputBinding
import javax.inject.Inject

class InputAdapter @Inject constructor() : ListAdapter<InputItem, InputAdapter.InputViewHolder>(
    COMPARATOR
) {

    private var delete: ((id: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InputViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemInputBinding.inflate(inflate, parent, false)
        return InputViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InputViewHolder, position: Int) {
        holder.bindingItem(getItem(position))
    }

    inner class InputViewHolder(private val binding: ItemInputBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.ivDelete.setOnClickListener {
                val id = getItem(adapterPosition).id
                delete?.invoke(id)
            }
        }

        fun bindingItem(data: InputItem?) {
            data ?: return
            binding.tvInput.text = data.input
        }

    }

    fun setItemDeleteClick(item: (id: Int) -> Unit) = apply {
        delete = item
    }

    companion object {

        private val COMPARATOR = object : DiffUtil.ItemCallback<InputItem>() {
            override fun areItemsTheSame(oldItem: InputItem, newItem: InputItem): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: InputItem, newItem: InputItem): Boolean {
                return oldItem == newItem
            }
        }

    }

}