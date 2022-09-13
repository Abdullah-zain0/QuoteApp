package io.github.quoteapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import io.github.quoteapp.databinding.ItemViewBinding
import io.github.quoteapp.model.QuotesWithAuthor
import io.github.quoteapp.utils.colorList

class QuoteAdapter : ListAdapter<QuotesWithAuthor,
        QuoteAdapter.ResultViewHolder>(DiffCallback) {

    class ResultViewHolder(private var binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(quoteWithAuthor: QuotesWithAuthor, position: Int) {
            binding.quoteAndAuthor = quoteWithAuthor

            binding.textView.setBackgroundColor(colorList[position].backGroundColor)
            binding.textView.setTextColor(colorList[position].forGroundColor)

            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResultViewHolder {
        return ResultViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val result = getItem(position)
        holder.bind(result,position)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<QuotesWithAuthor>() {
        override fun areItemsTheSame(oldItem: QuotesWithAuthor, newItem: QuotesWithAuthor): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: QuotesWithAuthor, newItem: QuotesWithAuthor): Boolean {
            return oldItem.quote == newItem.quote
        }

    }

}